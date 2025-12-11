package com.cpt202a19.reservation.mapper;

import com.cpt202a19.reservation.entity.Dmg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DmgMapperTests {
    @Autowired
    private DmgMapper dmgMapper;

    @Test
    public void findByParent() {
        String parent = "110100";
        List<Dmg> list = dmgMapper.findByParent(parent);
        System.out.println("count=" + list.size());
        for (Dmg dmg : list) {
            System.out.println(dmg);
        }
    }

    @Test
    public void findNameByCode() {
        String code = "140000";
        String name = dmgMapper.findNameByCode(code);
        System.out.println(name);
    }
}

