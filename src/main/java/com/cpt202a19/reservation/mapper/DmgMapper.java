package com.cpt202a19.reservation.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.cpt202a19.reservation.entity.Dmg;

import java.util.List;

@Mapper
public interface DmgMapper {

    List<Dmg> findByParent(String parent);
    String findNameByCode(String code);
    String findCodeByName(String name);

}
