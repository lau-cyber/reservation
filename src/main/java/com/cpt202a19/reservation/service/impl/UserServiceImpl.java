package com.cpt202a19.reservation.service.impl;

import com.cpt202a19.reservation.entity.User;
import com.cpt202a19.reservation.service.IUserService;
import com.cpt202a19.reservation.mapper.UserMapper;
import com.cpt202a19.reservation.service.ex.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/** User module business layer implementation class */
@Service // Hand over objects of the current class to Spring to manage, automatically create objects, and maintain
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * Method to finish user's registration
     * @param user User input to make registration
     * @return the updated state of registration
     * @exception/throws ServiceException
     */
    @Override
    public void reg(User user) {
        String username = user.getUsername();
        
        /* Determine if the user is registered */
        User result = userMapper.findByUsername(username);
        if (result != null) {
            throw new UsernameDuplicateException("尝试注册的用户名[" + username + "]已经被占用");
        }

        /* Password encryption processing implementation - MD5 algorithm encryption, loaded three times in a row */
        String oldPassword = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        user.setSalt(salt);
        String md5Password = getMD5Password(oldPassword,salt);
        user.setPassword(md5Password);
        user.setIsDelete(0);

        /* Four log field information for complete data */
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        /* Execute the realization of the registered business function */
        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }

    }

    /**
     * Declare MD5 encryption processing
     * @param password String of user's input password
     * @param salt String used to make encryption
     * @return the password processed by MD5
     */
    private String getMD5Password(String password, String salt) {

        for (int i = 0; i < 3; i++) {

            /* MD5 encryption algorithm call, three encryptions */
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }

        return password;
    }

    /**
     * The method to finish the login function
     * @param username String of user's name
     * @param password String of user's input password
     * @return the user login
     * @exception/throws ServiceException
     */
    @Override
    public User login(String username, String password) {

        /* Query user data based on the parameter username */
        User result = userMapper.findByUsername(username);

        /* Determine if the query result is null */
        if (result == null) {
            throw new UserNotFoundException("用户数据不存在");
        }
  
        /* Determine whether isDelete in the query result is 1 */
        if (result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户数据不存在");
        }
  
        String salt = result.getSalt(); // Get salt value from query result

        String md5Password = getMD5Password(password, salt); // Combine the parameters password and salt for encryption

        /* Determine whether the password in the query result is inconsistent with the password obtained by the above encryption */
        if (!result.getPassword().equals(md5Password)) {
            throw new PasswordNotMatchException("密码验证失败的错误");
        }
  
        User user = new User(); // Create a new User

        /* Encapsulate the uid, username, and avatar in the query result into a new user object */
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());

        return user;
    }

    /**
     * Method used to change password
     * @param uid Integer used to query information
     * @param username String of user's name
     * @param oloPassword String of user's old password
     * @param newPassword String of user's new password
     * @return the updated state of password changing
     * @exception/throws ServiceException
     */
    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        /* Query user data based on parameter uid */
        User result = userMapper.findByUid(uid);

        /* Check if query result is null */
        if (result == null) {
            throw new UserNotFoundException("用户数据不存在");
        }

        /* Check if isDelete in query result is 1 */
        if (result.getIsDelete().equals(1)) {
            throw new UserNotFoundException("用户数据不存在");
        }

        String salt = result.getSalt(); // Extract the salt value from the query result

        String oldMd5Password = getMD5Password(oldPassword, salt); // Encrypt the parameter oldPassword with the salt value to get old Md5 password

        /* Determine whether the password in the query result is inconsistent with old Md5 password */
        if (!result.getPassword().contentEquals(oldMd5Password)) {
            throw new PasswordNotMatchException("原密码错误");
        }

        String newMd5Password = getMD5Password(newPassword, salt); // Encrypt the parameter newPassword with the salt value to get newMd5Password

        Date now = new Date(); // Create time of date

        Integer rows = userMapper.updatePasswordByUid(uid, newMd5Password, username, now); // Update the password and get the return value

        /* Determine whether the number of affected rows returned by the above is not 1 */
        if (rows != 1) {
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
        }
    }

    /**
     * Get the information of the currently logged in user
     * @param uid Integer used to query information
     * @return a new user
     * @exception/throws ServiceException
     */
    @Override
    public User getByUid(Integer uid) {
        /* Query user data based on parameter uid */
        User result = userMapper.findByUid(uid);

        /* Determine if the query result is null */
        if (result == null) {
            throw new UserNotFoundException("用户数据不存在");
        }

        /* Determine whether isDelete in the query result is 1 */
        if (result.getIsDelete().equals(1)) {
            throw new UserNotFoundException("用户数据不存在");
        }

        User user = new User(); // Create a new user

        /* Encapsulate the username/phone/email/gender in the above query result into a new User object */
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());

        return user;
    }

    /**
     * Modify user profile
     * @param uid Integer used to query information
     * @param username String of user's name
     * @param user User needs to change profile
     * @return the updated state of information changing
     * @exception/throws ServiceException
     */
    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid); // Query user data according to the parameter uid

        /* Determine if the query result is null */
        if (result == null) {
            throw new UserNotFoundException("用户数据不存在");
        }

        /* Determine whether isDelete in the query result is 1 */
        if (result.getIsDelete().equals(1)) {
            throw new UserNotFoundException("用户数据不存在");
        }

        /* Complete data to the parameter user */
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());

        Integer rows = userMapper.updateInfoByUid(user);

        /* Determine whether the number of affected rows returned by the above is not 1 */
        if (rows != 1) {
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
        }
    }

    /**
     * User avatar image upload
     * @param uid Integer used to query information
     * @param username String of user's name
     * @param avater String of user's avater data
     * @return the updated state of avatar image uploading
     * @exception/throws ServiceException
     */
    @Override
    public void changeAvatar(Integer uid, String username, String avatar) {
        User result = userMapper.findByUid(uid);

        /* Check if query result is null */
        if (result == null) {
            throw new UserNotFoundException("用户数据不存在");
        }
  
        /* Check if isDelete in query result is 1 */
        if (result.getIsDelete().equals(1)) {
            throw new UserNotFoundException("用户数据不存在");
        }
  
        Date now = new Date(); // Create current time object

        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, now); // perform an update and get the return value
        
        /* Determine whether the number of affected rows returned by the above is not 1 */
        if (rows != 1) {
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
        }
    }

}
