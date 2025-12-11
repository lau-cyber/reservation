package com.cpt202a19.reservation.mapper;

import com.cpt202a19.reservation.entity.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class) // is a test launcher that can load Springboot test annotations
@SpringBootTest
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    // Test inserting a new user
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tim4");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }
   
    // The test matches the newly registered user
    @Test
    public void findByUsername() {
        String username = "tim4";
        User result = userMapper.findByUsername(username);
        System.out.println(result);
    }

    // Test update user information
    @Test
    public void updatePasswordByUid() {
        userMapper.updatePasswordByUid(7,"8888","manger",new Date());
    }

    // Test Modified Information
    @Test
    public void findByUid() {
        System.out.println(userMapper.findByUid(7));
    }

    // Test profile
    @Test
    public void updateInfoByUid() {
        User user = new User();
        user.setUid(7);
        user.setPhone("17858802222");
        user.setEmail("admin@gmail.com");
        user.setGender(1);
        user.setModifiedUser("manger");
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        System.out.println("rows=" + rows);
    }

    @Test
    public void updateAvatarByUid() {
        userMapper.updateAvatarByUid(
                7,
                "/upload/avatar.png",
                "管理员",
                new Date());
    }

}