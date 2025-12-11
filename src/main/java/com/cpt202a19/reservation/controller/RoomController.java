package com.cpt202a19.reservation.controller;

import com.cpt202a19.reservation.entity.BaseEntity;
import com.cpt202a19.reservation.entity.Room;
import com.cpt202a19.reservation.service.impl.RoomServiceImpl;
import com.cpt202a19.reservation.until.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("rooms")
public class RoomController extends BaseController {
    @Autowired
    private RoomServiceImpl roomService;

    @GetMapping("{id}/details")
    public JsonResult<Room> getById(@PathVariable("id") Integer id) {
        // 调用业务对象执行获取数据
        Room data = roomService.findById(id);
        // 返回成功和数据
        return new JsonResult<Room>(OK, data);
    }
//    @GetMapping("hot_list")
//    public JsonResult<List<Room>> getHotList(HttpSession session){
//        List<Room> data=;
//        return new JsonResult<List<Room>>(OK,data);
//    }
}
