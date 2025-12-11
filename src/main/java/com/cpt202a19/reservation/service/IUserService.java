package com.cpt202a19.reservation.service;

import com.cpt202a19.reservation.entity.User;

/** User module business layer interface */
public interface IUserService {

    /** User registration method, pass user user data object */
    void reg(User user);

    /** Pass username and password, return username, if not, return null */
    User login(String username,String password);

    /** Modify password */
    void changePassword(Integer uid, String username, String oldPassword, String newPassword);

    /** Get the information of the currently logged in user and return the information of the current logged in user */
    User getByUid(Integer uid);

    /** Modify user profile */
     void changeInfo(Integer uid,String username,User user);

    /** Upload user avatar */
    void changeAvatar(Integer uid, String username,String avatar );
 
}
