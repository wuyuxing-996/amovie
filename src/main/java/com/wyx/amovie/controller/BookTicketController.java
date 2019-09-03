package com.wyx.amovie.controller;

import com.wyx.amovie.entity.*;
import com.wyx.amovie.service.OrderService;
import com.wyx.amovie.service.SceneService;
import com.wyx.amovie.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String book2(Integer sceneId, Model model) {
        BookForm bookForm = new BookForm();
        Scene scene = sceneService.getById(sceneId);
        if (scene == null) {
            return "404";
        }
        bookForm.setMovieName(scene.getMovieName());
        bookForm.setShowtime(scene.getShowtime());
        bookForm.setSceneId(sceneId);
        bookForm.setPrice(scene.getPrice());
        model.addAttribute("bookForm", bookForm);
        model.addAttribute("sits", scene.getBookedSeat());
        return "book2";
    }

    @RequestMapping(value = "/book3-buy")
    public String book3(BookForm bookForm, Model model) {
        Scene scene = sceneService.getById(bookForm.getSceneId());
        BookForm booking = new BookForm();
        String[] site = bookForm.getBookedSits().split(",");
        int price = site.length * scene.getPrice();
        if (scene == null || site.length != bookForm.getSiteNum()) {
            return "404";
        }
        booking.setMovieName(scene.getMovieName());
        booking.setSceneId(scene.getId());
        booking.setPrice(scene.getPrice());
        booking.setTotalPrice(price);
        booking.setBookedSits(bookForm.getBookedSits());
        booking.setSiteNum(site.length);
        booking.setMovieName(scene.getMovieName());
        model.addAttribute("bookForm", booking);
        return "book3-buy";
    }

    @PostMapping(value = "/order")
    @ResponseBody
    public ResponseEntity addOrder(BookForm bookForm, HttpSession session) {
        Order order = new Order();
        StringBuilder ticketNum = new StringBuilder();
        ticketNum.append(MD5Utils.getSalt()).append(MD5Utils.getSalt());
        User user = (User) session.getAttribute("login");
        order.setUserId(user.getId());
        order.setStatus(0);
        order.setCreateTime(new Date());
        order.setSceneId(bookForm.getSceneId());
        Scene scene = sceneService.getById(bookForm.getSceneId());
        int price = scene.getPrice();
        order.setTicketNum(ticketNum.toString());
        String[] site = bookForm.getBookedSits().split(",");
        order.setTotalPrice(price * site.length);
        StringBuilder sb = new StringBuilder();
        for (String s : site) {
            sb.append(s + '#');
        }
        order.setSeat(sb.toString().substring(0, sb.length() - 1));
        int result = orderService.addOrder(order);
        Map<String, String> map = new HashMap<>();
        if (result != 0) {
            map.put("message", "支付成功！");
            map.put("ticketNum", ticketNum.toString());
            return ResponseEntity.ok(map);
        }
        map.put("message", "支付失败！");
        return ResponseEntity.ok(map);
    }

    @RequestMapping(value = "/book-final/{num}")
    public String book4(@PathVariable(value = "num") String ticketNum, HttpSession session, Model model) {
        User user = (User) session.getAttribute("login");
        OrderVo orderVo = orderService.getTicketByNum(user.getId(), ticketNum);
        if (orderVo == null) {
            return "404";
        }
        model.addAttribute("order", orderVo);
        return "book-final";
    }
}
