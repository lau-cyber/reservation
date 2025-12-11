package com.cpt202a19.reservation.service;

import com.cpt202a19.reservation.entity.Information;
import com.cpt202a19.reservation.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InformationServiceTests {
    @Autowired
    private IInformationService informationService;

    @Test
    public void addNewInformation() {
        Information information = new Information();
        information.setMail("17858805555");
        information.setName("张三");
        informationService.addNewInformation(12,"测试",information);

    }

    @Test
    public void getByUid() {
        Integer uid = 12;
        List<Information> list = informationService.getByUid(uid);
        System.out.println("count=" + list.size());
        for (Information item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void setDefault() {
        try {
            Integer rid = 10;
            Integer uid = 11;
            String username = "系统管理员";
            informationService.setDefault(rid, uid, username);
            System.out.println("OK.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void delete() {
        try {
            Integer rid = 5;
            Integer uid = 12;
            String username = "张三";
            informationService.delete(rid, uid, username);
            System.out.println("OK.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
