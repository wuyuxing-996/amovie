package com.wyx.amovie.mapper;

import com.wyx.amovie.entity.Order;
import com.wyx.amovie.entity.OrderVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wyx
 */
@Mapper
@Repository
public interface OrderMapper {

    /**
     * 查询所有订单
     *
     * @return
     */
    @Select("select * from `order`")
    List<Order> getAll();

    /**
     * 根据id查询单个订单
     *
     * @param id
     * @return
     */
    @Select("select * from `order` where id=#{id}")
    Order getOneById(Integer id);

    /**
     * 根据用户id查询所有订单
     *
     * @param userId
     * @return
     */
    @Select("select * from `order` where user_id=#{userId}")
    List<Order> getAllById(Integer userId);

    /**
     * 添加订单
     *
     * @param order
     * @return
     */
    @Insert("insert into `order`(status,user_id,create_time,scene_id,ticket_num," +
            "total_price,seat) values(#{status},#{userId},#{createTime},#{sceneId}," +
            "#{ticketNum},#{totalPrice},#{seat})")
    int addOrder(Order order);

    /**
     * 更新订单
     *
     * @param order
     * @return
     */
    @Update("update `order` set status=#{status},user_id=#{userId}," +
            "create_time=#{createTime},scene_id=#{sceneId}," +
            "ticket_num=#{ticketNum},total_price=#{totalPrice},seat=#{seat}" +
            " where id=#{id}")
    int updateOrder(Order order);

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @Delete("delete from `order` where id=#{id}")
    int deleteOrder(Integer id);

    /**
     * 获取个人所有订单
     *
     * @param userId
     * @return
     */
    @Select("select o.*,s.movie_name,s.showtime from `order` o LEFT JOIN scene s on o.scene_id=s.id where o.user_id=#{userId}")
    List<OrderVo> getTicketByUserId(Integer userId);

    /**
     * 获取某张票
     *
     * @param userId
     * @param ticketNum
     * @return
     */
    @Select("select o.*,s.movie_name,s.showtime from `order` o LEFT JOIN scene s on o.scene_id=s.id where o.user_id=#{userId} and o.ticket_num=#{ticketNum}")
    OrderVo getTicketByNum(Integer userId, String ticketNum);
}
