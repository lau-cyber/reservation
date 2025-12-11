package com.cpt202a19.reservation.service.impl;

import com.cpt202a19.reservation.entity.Cart;
import com.cpt202a19.reservation.entity.Room;
import com.cpt202a19.reservation.mapper.CartMapper;
import com.cpt202a19.reservation.service.ICartService;
import com.cpt202a19.reservation.service.IRoomService;
import com.cpt202a19.reservation.service.ex.AccessDeniedException;
import com.cpt202a19.reservation.service.ex.CartNotFoundException;
import com.cpt202a19.reservation.service.ex.InsertException;
import com.cpt202a19.reservation.service.ex.*;
import com.cpt202a19.reservation.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/** 处理reservation-list数据的业务层实现类 */
@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private IRoomService roomService;

    @Override
    public void addToCart(Integer uid, Integer roid, Integer amount, String username) {  
        // 根据参数roid和uid查询reservation-list中的数据
        Cart result = cartMapper.findByUidAndRoid(uid, roid);                            
        Date date = new Date();
        // 判断查询结果是否为null
        if (result == null) {
            // 是：表示该用户并未将该room添加到reservation-list
            // create Cart object (in real it is reservation-list)
            Cart cart = new Cart();
            // 封装数据：uid,roid,amount
            cart.setUid(uid);
            cart.setRoid(roid);                                                       
            cart.setNum(amount);
            // 调用roomService.findById(roid)查询room数据，得到minim reservation time
            Room room = roomService.findById(roid);   
            // 封装数据：rotime
            cart.setRotime(room.getRotime());  
            // 封装数据：4个日志
            cart.setCreatedUser(username);
            cart.setCreatedTime(date);
            cart.setModifiedUser(username);
            cart.setModifiedTime(date);
            // 调用insert(cart)执行将数据插入到数据表中
            Integer rows = cartMapper.insert(cart);
            if (rows != 1) {
                throw new InsertException("插入room数据时出现未知错误，请联系系统管理员");
            }
        } else {
            Integer cid = result.getCid();
            Integer num = result.getNum() + amount;
            Integer rows = cartMapper.updateNumByCid(cid,num,username,date);
            if (rows != 1){
                throw new InsertException("更新数据时产生未知异常");
            }
        }
    }

    @Override
    public List<CartVO> getVOByUid(Integer uid) {
        return cartMapper.findVOByUid(uid);
    }

    @Override
    public Integer addNum(Integer cid, Integer uid, String username) {
        // 调用findByCid(cid)根据参数cid查询reservation-list数据
        Cart result = cartMapper.findByCid(cid);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出CartNotFoundException
            throw new CartNotFoundException("尝试访问的reservation-list数据不存在");
        }

        // 判断查询结果中的uid与参数uid是否不一致
        if (!result.getUid().equals(uid)) {
            // 是：抛出AccessDeniedException
            throw new AccessDeniedException("非法访问");
        }

        // 可选：检查room的数量是否大于多少(适用于增加数量)或小于多少(适用于减少数量)
        // 根据查询结果中的原数量增加1得到新的数量num
        Integer num = result.getNum() + 1;

        // 创建当前时间对象，作为modifiedTime
        Date now = new Date();
        // 调用updateNumByCid(cid, num, modifiedUser, modifiedTime)执行修改数量
        Integer rows = cartMapper.updateNumByCid(cid, num, username, now);
        if (rows != 1) {
            throw new InsertException("修改room数量时出现未知错误，请联系系统管理员");
        }

        // 返回新的数量
        return num;
    }

    @Override
    public Integer reduceNum(Integer cid, Integer uid, String username) {
        // 调用findByCid(cid)根据参数cid查询reservation-list数据
        Cart result = cartMapper.findByCid(cid);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出CartNotFoundException
            throw new CartNotFoundException("尝试访问的reservation-list数据不存在");
        }

        // 判断查询结果中的uid与参数uid是否不一致
        if (!result.getUid().equals(uid)) {
            // 是：抛出AccessDeniedException
            throw new AccessDeniedException("非法访问");
        }

        // 可选：检查room的数量是否大于多少(适用于增加数量)或小于多少(适用于减少数量)
        // 根据查询结果中的原数量增加1得到新的数量num
        Integer num = result.getNum() - 1;

        // 创建当前时间对象，作为modifiedTime
        Date now = new Date();
        // 调用updateNumByCid(cid, num, modifiedUser, modifiedTime)执行修改数量
        Integer rows = cartMapper.updateNumByCid(cid, num, username, now);
        if (rows != 1) {
            throw new InsertException("修改room数量时出现未知错误，请联系系统管理员");
        }

        // 返回新的数量
        return num;
    }

    @Override
    public List<CartVO> getVOByCids(Integer uid, Integer[] cids) {
        List<CartVO> list = cartMapper.findVOByCids(cids);
        Iterator<CartVO> it = list.iterator();
        while (it.hasNext()) {
            CartVO cart = it.next();
            if (!cart.getUid().equals(uid)) {
                it.remove();
            }
        }
        return list;
    }
    @Override
    public void delete(Integer cid, Integer uid) {

        Cart result = cartMapper.findByCid(cid);
        // 判断查询结果是否为null
        if (result == null) {

            throw new CartNotFoundException("尝试访问的数据不存在");
        }

        // 判断查询结果中的uid与参数uid是否不一致(使用equals()判断)
        if (!result.getUid().equals(uid)) {
            // 是：抛出AccessDeniedException：非法访问
            throw new AccessDeniedException("非常访问");
        }

        // 根据参数cid，调用deleteByCid()执行删除
        Integer rows1 = cartMapper.deleteByCid(cid);
        if (rows1 != 1) {
            throw new DeleteException("删除数据时出现未知错误，请联系系统管理员");
        }

    }
}
