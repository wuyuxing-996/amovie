package com.wyx.amovie.controller;

import com.wyx.amovie.entity.*;
import com.wyx.amovie.service.OrderService;
import com.wyx.amovie.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author wyx
 * @date 2019-08-25 21:03
 */
@Controller
public class BookTicketController {

    @Autowired
    private SceneService sceneService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/ticket")
    public String ticket(HttpSession session, Model model) {
        User user = (User) session.getAttribute("login");
        List<OrderVo> orderVoList = orderService.getTicketByUserId(user.getId());
        model.addAttribute("orders", orderVoList);
        return "ticket";
    }

    @RequestMapping(value = "/book1")
    public String book1(@RequestParam("movieId") Integer movieId,
                        Model model) {
        List<Scene> scenes = sceneService.getSceneCount(movieId);
        model.addAttribute("scenes", scenes);
        return "book1";
    }

    @RequestMapping(value = "/book2")
    public String book2(BookForm bookForm, Model model) {
        model.addAttribute("bookForm", bookForm);
        return "book2";
    }

    @RequestMapping(value = "/book3-buy")
    public String book3(BookForm bookForm, Model model) {
        model.addAttribute("bookForm", bookForm);
        return "book3-buy";
    }

    @PostMapping(value = "/order")
    public ResponseEntity addOrder(BookForm bookForm, HttpSession session) {
        Order order = new Order();
        User user = (User) session.getAttribute("login");
        order.setUserId(user.getId());
        order.setStatus(0);
        order.setCreateTime(new Date());
        order.setSceneId(bookForm.getChoosenScene());
        Scene scene = sceneService.getById(bookForm.getChoosenScene());
        int price = scene.getPrice();
        order.setTicketNum("7758521");
        String[] site = bookForm.getChoosenSits().split(",");
        order.setTotalPrice(price * site.length);
        StringBuilder sb = new StringBuilder();
        for (String s : site) {
            sb.append(s + '#');
        }
        order.setSeat(sb.toString().substring(0, sb.length() - 1));
        int result = orderService.addOrder(order);
        if (result != 0) {
            return ResponseEntity.ok("支付成功！");
        }
        return ResponseEntity.ok("支付失败！");
    }

    @RequestMapping(value = "/book-final")
    public String book4(BookForm bookForm, Model model) {
        model.addAttribute("bookForm", bookForm);
        Scene scene = sceneService.getById(bookForm.getChoosenScene());
        int price = scene.getPrice();
        String[] site = bookForm.getChoosenSits().split(",");
        if (price * site.length != bookForm.getChoosenCost()) {
            return "404";
        }
        return "book-final";
    }
}
