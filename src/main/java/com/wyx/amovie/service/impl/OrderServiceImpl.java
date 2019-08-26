package com.wyx.amovie.service.impl;

import com.wyx.amovie.entity.Order;
import com.wyx.amovie.mapper.OrderMapper;
import com.wyx.amovie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wyx
 * @date 2019-08-24 15:22
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public int deleteOrder(Integer id) {
        return orderMapper.deleteOrder(id);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = orderMapper.getAll();
        return orders;
    }

    @Override
    public List<Order> getAllById(Integer userId) {
        List<Order> orders = orderMapper.getAllById(userId);
        return orders;
    }

    @Override
    public Order getOneById(Integer id) {
        return orderMapper.getOneById(id);
    }
}
