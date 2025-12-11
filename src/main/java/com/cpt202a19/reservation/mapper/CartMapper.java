package  com.cpt202a19.reservation.mapper;

import com.cpt202a19.reservation.entity.Cart;
import com.cpt202a19.reservation.vo.CartVO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/** 处理reservation-list数据的持久层接口 */
@Mapper
public interface CartMapper {
    /**
     * 插入reservation-list dat
     * @param cart reservation-list data
     * @return 受影响的行数
     */
    Integer insert(Cart cart);

    /**
     * 修改教室数据中room的数量
     * @param cid 教室数据的id
     * @param num 新的数量
     * @param modifiedUser 修改执行人
     * @param modifiedTime 修改时间
     * @return 受影响的行数
     */
    Integer updateNumByCid(
            @Param("cid") Integer cid,
            @Param("num") Integer num,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据用户id和教室id查询reservation-list中的数据
     * @param uid 用户id
     * @param roid 教室id
     * @return 匹配的数据，如果该用户的备选列表中并没有该教室，则返回null
     */
    Cart findByUidAndRoid(
            @Param("uid") Integer uid,
            @Param("roid") Integer roid);//商品id改成教室id

    /**
     * 查询某用户的教室数据
     * @param uid 用户id
     * @return 该用户的教室数据的列表
     */
    List<CartVO> findVOByUid(Integer uid);

    /**
     * 根据教室数据id查询教室数据详情
     * @param cid 教室数据id
     * @return 匹配的教室数据详情，如果没有匹配的数据则返回null
     */
    Cart findByCid(Integer cid);

    /**
     * 根据若干个教室数据id查询详情的列表
     * @param cids 若干个教室数据id
     * @return 匹配的教室数据详情的列表
     */
    List<CartVO> findVOByCids(Integer[] cids);

    //删除
    Integer deleteByCid(Integer cid);

}
