package com.wyx.amovie.service.impl;

import com.wyx.amovie.entity.Order;
import com.wyx.amovie.entity.OrderVo;
import com.wyx.amovie.entity.Scene;
import com.wyx.amovie.mapper.OrderMapper;
import com.wyx.amovie.mapper.SceneMapper;
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

    @Autowired
    private SceneMapper sceneMapper;

    @Override
    public int addOrder(Order order) {
        orderMapper.addOrder(order);
        Scene scene = sceneMapper.getById(order.getSceneId());
        StringBuilder sites = new StringBuilder();
        String newSites = order.getSeat();
        sites.append(scene.getBookedSeat());
        sites.append("#");
        sites.append(newSites);
        if (scene.getBookedSeat() == null) {
            scene.setBookedSeat(newSites);
        } else {
            scene.setBookedSeat(sites.toString());
        }
        String[] s = order.getSeat().split("#");
        int num = scene.getSeatNum() - s.length;
        scene.setSeatNum(num);
        int result = sceneMapper.updateScene(scene);
        return result;
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

    @Override
    public List<OrderVo> getTicketByUserId(Integer userId) {
        List<OrderVo> orderVoList = orderMapper.getTicketByUserId(userId);
        for (OrderVo orderVo : orderVoList) {
            orderVo.setSeat(orderVo.getSeat().replaceAll("#", ","));
        }
        return orderVoList;
    }
}
