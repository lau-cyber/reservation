package com.cpt202a19.reservation.service;

import com.cpt202a19.reservation.vo.CartVO;

import java.util.List;

/* 处理reservation-list数据的业务层接口 */
public interface ICartService {
    /*将商品添加到reservation-list*/
    void addToCart(Integer uid, Integer roid, Integer amount, String username);  

    /*查询某用户的reservation-list数据*/
    List<CartVO> getVOByUid(Integer uid);

    /*将reservation-list中某room的数量加1*/
    Integer addNum(Integer cid, Integer uid, String username);

    /*将reservation-list中某room的数量减1*/
    Integer reduceNum(Integer cid, Integer uid, String username);

    /*根据若干个reservation-list数据id查询详情的列表*/
    List<CartVO> getVOByCids(Integer uid, Integer[] cids);
    //    删除data
    void delete(Integer cid, Integer uid);
}
