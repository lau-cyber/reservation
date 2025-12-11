package com.cpt202a19.reservation.service;

import com.cpt202a19.reservation.entity.Order;
import com.cpt202a19.reservation.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTests {
    @Autowired
    private IOrderService orderService;

    @Test
    public void create() {
        try {
            Integer rid = 1;
            Integer[] cids = {4, 5, 6,7};
            Integer uid = 31;
            String username = "订单管理员";
            Order order = orderService.create(rid, cids, uid, username);
            System.out.println(order);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}