package com.cpt202a19.reservation.mapper;

import com.cpt202a19.reservation.entity.Cart;
import com.cpt202a19.reservation.entity.Room;
import com.cpt202a19.reservation.vo.CartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTests {
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void insert() {
        Cart cart = new Cart();
        cart.setUid(1);
        cart.setRoid(10000001);
        cart.setRotime(120.0);
        cartMapper.insert(cart);
    }


    @Test
    public void findByUidAndRoid() {
        Integer uid = 1;
        Integer roid = 10000001;
        Cart result = cartMapper.findByUidAndRoid(uid, roid);
        System.out.println(result);
    }

    @Test
    public void findVOByUid() {
        List<CartVO> list = cartMapper.findVOByUid(1);
        System.out.println(list);
    }



}