package com.wyx.amovie.controller.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wyx.amovie.entity.Order;
import com.wyx.amovie.service.OrderService;
import com.wyx.amovie.utils.Msg;
import com.wyx.amovie.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * @author wyx
 * @date 2019-08-24 16:36
 */
@CrossOrigin
@Controller
@RequestMapping(value = "/api/order")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "20") Integer size) {
        Page<Order> orders = PageHelper.startPage(page, size).doSelectPage(() -> orderService.getAll());
        return new ResponseEntity(orders.toPageInfo(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        Order order = orderService.getOneById(id);
        return Result.checkObject(order);
    }

    @PostMapping
    public ResponseEntity addMovie(@RequestBody Order order) {
        order.setCreateTime(new Date());
        int result = orderService.addOrder(order);
        return Result.checkAdd(result);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity updateMovie(@PathVariable(value = "id") Integer id,
                                      @RequestBody Order order) {
        order.setCreateTime(new Date());
        int result = orderService.updateOrder(order);
        return Result.checkUpdate(result);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteMovie(@PathVariable(value = "id") Integer id) {
        Order order = orderService.getOneById(id);
        if (order == null) {
            Msg msg = Msg.fail().add("原因", "该订单不存在！");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }
        int result = orderService.deleteOrder(id);
        return Result.checkDelete(result);
    }
}
