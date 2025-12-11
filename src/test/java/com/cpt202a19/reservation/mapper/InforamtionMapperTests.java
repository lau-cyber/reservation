package com.cpt202a19.reservation.mapper;

import com.cpt202a19.reservation.entity.Information;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InforamtionMapperTests {
    @Autowired
    private InformationMapper informationMapper;

    @Test
    public void insert() {
        Information information = new Information();
        information.setUid(11);
        information.setName("李四");
        information.setDepartmentName("SAT");
        information.setMail("111111@qq.com");
        information.setDetails("江苏省苏州市西交利物浦大学");
        informationMapper.insert(information);
    }

    @Test
    public void countByUid() {
        Integer count = informationMapper.countByUid(11);
        System.out.println("count=" + count);
    }
    @Test
    public void findByUid() {
        Integer uid = 12;
        List<Information> list = informationMapper.findByUid(uid);
        System.out.println("count=" + list.size());
        for (Information item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void updateNonDefaultByUid() {
        Integer uid = 11;
        Integer rows = informationMapper.updateNonDefaultByUid(uid);
        System.out.println("rows=" + rows);
    }

    @Test
    public void updateDefaultByRid() {
        Integer rid = 11;
        String modifiedUser = "管理员";
        Date modifiedTime = new Date();
        Integer rows = informationMapper.updateDefaultByRid(rid, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByRid() {
        Integer rid = 11;
        Information result = informationMapper.findByRid(rid);
        System.out.println(result);
    }

    @Test
    public void deleteByRid() {
        Integer rid = 7;
        Integer rows = informationMapper.deleteByRid(rid);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findLastModified() {
        Integer uid = 10;
        Information result = informationMapper.findLastModified(uid);
        System.out.println(result);
    }
}
