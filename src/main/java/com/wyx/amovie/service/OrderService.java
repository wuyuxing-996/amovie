package com.wyx.amovie.service;

import com.wyx.amovie.entity.Order;
import com.wyx.amovie.entity.OrderVo;

import java.util.List;

/**
 * @author wyx
 */
public interface OrderService {

    /**
     * 增加订单
     *
     * @param order
     */
    int addOrder(Order order);

    /**
     * 删除订单
     *
     * @param id
     */
    int deleteOrder(Integer id);

    /**
     * 更新订单
     *
     * @param order
     */
    int updateOrder(Order order);

    /**
     * 获取所有订单
     *
     * @return
     */
    List<Order> getAll();

    /**
     * 获取个人所有订单
     *
     * @param userId
     * @return
     */
    List<Order> getAllById(Integer userId);

    /**
     * 获取单个订单
     *
     * @param id
     * @return
     */
    Order getOneById(Integer id);

    /**
     * 获取个人票面
     *
     * @param userId
     * @return
     */
    List<OrderVo> getTicketByUserId(Integer userId);

    /**
     * 获取某张票
     *
     * @param userId
     * @param ticketNum
     * @return
     */
    OrderVo getTicketByNum(Integer userId, String ticketNum);
}
