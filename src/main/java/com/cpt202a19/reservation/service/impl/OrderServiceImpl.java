package com.cpt202a19.reservation.service.impl;

import com.cpt202a19.reservation.entity.Information;
import com.cpt202a19.reservation.entity.Order;
import com.cpt202a19.reservation.entity.OrderItem;
import com.cpt202a19.reservation.mapper.OrderMapper;
import com.cpt202a19.reservation.service.IInformationService;
import com.cpt202a19.reservation.service.ICartService;
import com.cpt202a19.reservation.service.IOrderService;
import com.cpt202a19.reservation.service.ex.InsertException;
import com.cpt202a19.reservation.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/** 处理订单和订单数据的业务层实现类 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IInformationService informationService;
    @Autowired
    private ICartService cartService;

    @Transactional
    @Override
    public Order create(Integer rid, Integer[] cids, Integer uid, String username) {
        // 创建当前时间对象
        Date now = new Date();

        // 根据cids查询所勾选的购物车列表中的数据
        List<CartVO> carts = cartService.getVOByCids(uid, cids);

        // 计算这些的总时间
        long totalTime = 0;
        for (CartVO cart : carts) {
            totalTime += cart.getRotime() * cart.getNum();
        }

        // 创建订单数据对象
        Order order = new Order();
        // 补全数据：uid
        order.setUid(uid);
        // 查询收货地址数据
        Information information = informationService.getByRid(rid, uid);
        // 补全数据：收货地址相关的6项
        order.setRecvName(information.getName());
        order.setRecvTel(information.getTel());
        order.setRecvDepartment(information.getDepartmentName());
        order.setRecvMajor(information.getMajorName());
        order.setRecvGrade(information.getGradeName());
        order.setRecvDetails(information.getDetails());
        // 补全数据：totalTime
        order.setTotalTime(totalTime);
        // 补全数据：status
        order.setStatus(0);
        // 补全数据：下单时间
        order.setOrderTime(now);
        // 补全数据：日志
        order.setCreatedUser(username);
        order.setCreatedTime(now);
        order.setModifiedUser(username);
        order.setModifiedTime(now);
        // 插入订单数据
        Integer rows1 = orderMapper.insertOrder(order);
        if (rows1 != 1) {
            throw new InsertException("插入订单数据时出现未知错误，请联系系统管理员");
        }

        // 遍历carts，循环插入订单商品数据
        for (CartVO cart : carts) {
            // 创建订单商品数据
            OrderItem item = new OrderItem();
            // 补全数据：setOid(order.getOid())
            item.setOid(order.getOid());
            // 补全数据：roid, title, image, time, num
            item.setRoid(cart.getRoid());
            item.setTitle(cart.getTitle());
            item.setImage(cart.getImage());
            item.setTime(cart.getRotime());
            item.setNum(cart.getNum());
            // 补全数据：4项日志
            item.setCreatedUser(username);
            item.setCreatedTime(now);
            item.setModifiedUser(username);
            item.setModifiedTime(now);
            // 插入订单商品数据
            Integer rows2 = orderMapper.insertOrderItem(item);
            if (rows2 != 1) {
                throw new InsertException("插入订单商品数据时出现未知错误，请联系系统管理员");
            }
        }

        // 返回
        return order;
    }
}
