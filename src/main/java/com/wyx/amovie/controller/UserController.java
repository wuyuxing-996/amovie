package com.wyx.amovie.controller;

import com.wyx.amovie.constant.Role;
import com.wyx.amovie.entity.User;
import com.wyx.amovie.exception.MessageException;
import com.wyx.amovie.service.UserService;
import com.wyx.amovie.utils.MD5Utils;
import com.wyx.amovie.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users")
    public Msg getUsers() {
        List<User> users = userService.getUsers();
        return Msg.success().add("first", users);
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession session) throws MessageException {
        User user = userService.getUserByEmail(email);
        if (user == null) {
            throw new MessageException("该用户不存在！");
        }
        if (userService.login(email, password)) {
            session.setAttribute("login", user.getNickname());
            return "redirect:/users";
        }
        throw new MessageException("密码错误！");
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public Msg register(User user,
                        Model model) throws MessageException {
        User user1 = userService.getUserByEmail(user.getEmail());
        if (user1 != null) {
            throw new MessageException("该用户已经被注册");
        }
        user.setRole(Role.USER);
        user.setSalt(MD5Utils.getSalt());
        user.setPassword(MD5Utils.md5(user.getPassword(), user.getSalt()));
        userService.saveUser(user);
        return Msg.success().add("mes", "注册成功！");
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
