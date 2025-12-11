package com.cpt202a19.reservation.controller;

import com.cpt202a19.reservation.controller.ex.*;
import com.cpt202a19.reservation.entity.User;
import com.cpt202a19.reservation.service.IUserService;
import com.cpt202a19.reservation.until.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

    /**learing ideas about sprinboot
      * 约定大于配置的开发思想，省略大量的配置甚至注解的编号
      * 1.接受数据方式:请求处理方法的参数列表设置为pojo类型来接受前端数据
      *    Springboot将前端的url地址中的参数名和pojo类属性名比较，如果两个
      *   名称相同，则将注入到到pojo类中对应的属性上
      * 2.接受数据方式:请求处理方法的参数列表设置为非pojo类型
      *   Springboot将请求的参数名和方法的参数名直接进行比较
      *  如果名称相同，则将自动完成值依赖注入
      */

      
/** Controller class that handles user-related requests */
@RestController
@RequestMapping("users")
public class UserController extends BaseController {

    @Autowired // automatic assembly
    private IUserService userService;
    
    /**
     * The method to finish the function of user's registration
     * @param user the user want to register
     * @return the response by JsonResult
     */
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        userService.reg(user); // Call the business object to perform registration
        return new JsonResult<Void>(OK);
    }
    
    /**
     * The method to finish user's login function
     * @param username the string of user's name
     * @param password the string of user's password
     * @param session stores information of uid and username
     * @return the Jsonresult of corresponding information
     */
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User data = userService.login(username,password);

        /* Complete data binding in the session object (global) */
        session.setAttribute("uid",data.getUid());
        session.setAttribute("username",data.getUsername());

        /* Get the data bound in the session */
        System.out.println("uid:"+getuidFromSession(session));
        System.out.println("用户"+getUsernameFromSession(session)+"登录成功！");
        return new JsonResult<User>(OK,data);
    }

    /**
     * The method to change user's password
     * @param oldPassword the string of user's old password
     * @param newPassword the string of user's new password
     * @param session stores information of uid and username
     * @return the response by JsonResult
     */
    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid,username,oldPassword,newPassword);
        return new JsonResult<Void>(OK);
    }

    /**
     * The method to get user's information by uid
     * @param session stores information of uid and username
     * @return the Jsonresult of corresponding information
     */
    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        Integer uid = getuidFromSession(session);
        User data = userService.getByUid(uid); // Call the business object to get data
        return new JsonResult<User>(OK, data);
    }

    /**
     * The method to change personal information
     * @param user the user want to change information
     * @param session stores information of uid and username
     * @return the response by JsonResult
     */
    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user,HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeInfo(uid, username, user); // Call the business object to modify the user data
        return new JsonResult<Void>(OK);
    }

    /** The upper limit of the avatar file size (10MB) */
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;

    /** File types of avatars allowed to upload */
    public static final List<String> AVATAR_TYPES = new ArrayList<String>();
    
    /** Initialize the file type of avatars that are allowed to be uploaded */
    static {
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/bmp");
        AVATAR_TYPES.add("image/gif");
    }

    /**
     * The method to let users upload and change their avater
     * @param file is file user want to change as avater
     * @param session stores information of uid and username
     * @return the response by JsonResult
     * @exception/throws FileUploadException
     */
    @PostMapping("change_avatar")
    public JsonResult<String> changeAvatar(@RequestParam("file") MultipartFile file, HttpSession session) {

        /* Check whether the file is empty */
        if (file.isEmpty()) {
            throw new FileEmptyException("上传的头像文件不允许为空");
        }
      
        /* Determine whether the uploaded file size exceeds the limit value */
        if (file.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException("不允许上传超过" + (AVATAR_MAX_SIZE / 1024) + "KB的头像文件");
        }

        /* Determine whether the uploaded file type exceeds the limit */
        String contentType = file.getContentType();
        if (!AVATAR_TYPES.contains(contentType)) {
            throw new FileTypeException("不支持使用该类型的文件作为头像，允许的文件类型：\n" + AVATAR_TYPES);
        }

        String parent = session.getServletContext().getRealPath("upload"); // Get the absolute disk path of the current project

        File dir = new File(parent); // Folder to save avatar files
        if (!dir.exists()) { dir.mkdirs(); }

        /* The filename of the saved avatar file */
        String suffix = "";
        String originalFilename = file.getOriginalFilename();
        int beginIndex = originalFilename.lastIndexOf(".");
        if (beginIndex > 0) {
            suffix = originalFilename.substring(beginIndex);
        }
        String filename = UUID.randomUUID().toString() + suffix;

        File dest = new File(dir, filename); // Create a file object, representing the saved avatar file

        /* Execute to save avatar file */
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            throw new FileStateException("文件状态异常，可能文件已被移动或删除");
        } catch (IOException e) {
            throw new FileUploadIOException("上传文件时读写错误，请稍后重尝试");
        }

        String avatar = "/upload/" + filename; // avater path

        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);

        userService.changeAvatar(uid, username, avatar); // Write the avatar to the database

        return new JsonResult<String>(OK, avatar);
    }

}
