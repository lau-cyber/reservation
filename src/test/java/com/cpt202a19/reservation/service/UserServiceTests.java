package com.cpt202a19.reservation.service;

import com.cpt202a19.reservation.entity.User;
import com.cpt202a19.reservation.service.ex.ServiceException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // is a test launcher that can load Springboot test annotations
@SpringBootTest
public class UserServiceTests {
    @Autowired
    private IUserService iuserService;

    // Test the encrypted registered new user and obtain the corresponding information
    @Test
    public void reg(){
        try{
            User user = new User();
            user.setUsername("test01");
            user.setPassword("123456");
           iuserService.reg(user);
           System.out.println("OK");
        }catch (ServiceException e){
            // Get exception class name
            System.out.println(e.getClass().getSimpleName());
            // Get exception class information
            System.out.println(e.getMessage());
        }
    }

    // Login User Authentication Test
    @Test
    public void login() {
        User user = iuserService.login("test01", "123456");
        System.out.println(user);
    }

    // Test to get the user name
    @Test
    public void getByUid() {
        try {
            Integer uid = 18;
            User user = iuserService.getByUid(uid);
            System.out.println(user);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    // Test modifying personal data
    @Test
    public void changeInfo() {
        try {
            Integer uid = 18;
            String username = "数据管理员";
            User user = new User();
            user.setPhone("15512328888");
            user.setEmail("admin03@cy.cn");
            user.setGender(2);
            iuserService.changeInfo(uid, username, user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    // Test uploading user avatar pictures
    @Test
    public void changAvatar(){
        iuserService.changeAvatar(
                    8,"小明","/upload/test.png"
        );
    }

}
