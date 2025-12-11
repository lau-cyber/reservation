package com.cpt202a19.reservation.service.impl;

import com.cpt202a19.reservation.controller.ex.ProductNotFoundException;
import com.cpt202a19.reservation.entity.Room;

import com.cpt202a19.reservation.mapper.RoomMapper;
import com.cpt202a19.reservation.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements IRoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Room findById(Integer id) {
        // 根据参数id调用私有方法执行查询，获取room数据
        Room product = roomMapper.findById(id);
        // 判断查询结果是否为null
        if (product == null) {
            // 是：抛出ProductNotFoundException
            throw new ProductNotFoundException("尝试访问的room数据不存在");
        }
        // 将查询结果中的部分属性设置为null
        product.setPriority(null);
        product.setCreatedUser(null);
        product.setCreatedTime(null);
        product.setModifiedUser(null);
        product.setModifiedTime(null);
        // 返回查询结果
        return product;
    }
}
