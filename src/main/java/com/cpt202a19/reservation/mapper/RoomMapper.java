package com.cpt202a19.reservation.mapper;

import com.cpt202a19.reservation.entity.Room;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomMapper {
    Room findById(Integer id);
}
