package com.cpt202a19.reservation.service;

import com.cpt202a19.reservation.entity.Dmg;
import com.cpt202a19.reservation.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DmgServiceTests {
    @Autowired
    private IDmgService dmgService;

    @Test
    public void getByParent() {
        List<Dmg> list = dmgService.getByParent("86");
        for (Dmg d : list) {
            System.out.println(d);
        }
    }

    @Test
    public void getNameByCode() {
        try {
            String code = "250000";
            String result = dmgService.getNameByCode(code);
            System.out.println(result);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}