package com.cpt202a19.reservation.service.impl;

import com.cpt202a19.reservation.entity.Dmg;
import com.cpt202a19.reservation.mapper.DmgMapper;
import com.cpt202a19.reservation.service.IDmgService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Business layer implementation class for processing Dmg data */
@Service
public class DmgServiceImpl implements IDmgService {
    @Autowired // automatic assembly
    private DmgMapper dmgMapper;

    @Override
    public List<Dmg> getByParent(String parent) {
        List<Dmg> list = dmgMapper.findByParent(parent);

        for (Dmg dmg : list) {
            dmg.setId(null);
            dmg.setParent(null);
        }

        return list;
    }

    @Override
    public String getNameByCode(String code) { return dmgMapper.findNameByCode(code); }

    @Override
    public String getCodeByName(String name) { return dmgMapper.findCodeByName(name); }

}