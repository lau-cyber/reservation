package com.cpt202a19.reservation.mapper;

import com.cpt202a19.reservation.entity.Order;
import com.cpt202a19.reservation.entity.OrderItem;

/** 处理订单及订单商品数据的持久层接口 */
public interface OrderMapper {
    /* 插入订单数据*/
    Integer insertOrder(Order order);

    /*插入订单商品数据*/
    Integer insertOrderItem(OrderItem orderItem);
}
