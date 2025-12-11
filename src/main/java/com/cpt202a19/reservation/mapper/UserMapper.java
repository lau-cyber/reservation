package com.cpt202a19.reservation.mapper;

import com.cpt202a19.reservation.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;


/** User Module Persistence Layer Interface */
@Mapper
public interface UserMapper{

    Integer insert(User user);

    User findByUsername(String username);

    /** Modify user password, id, executor, modification time, and number of rows returned according to uid */
    Integer updatePasswordByUid(
            @Param("uid") Integer uid,
            @Param("password") String password,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

    User findByUid(Integer uid); // Query user data by id

    Integer updateInfoByUid(User user); // Update user information according to uid, user encapsulates user id and new personal information, and returns the number of rows

    Integer updateAvatarByUid(
            @Param("uid") Integer uid,
            @Param("avatar") String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

}
