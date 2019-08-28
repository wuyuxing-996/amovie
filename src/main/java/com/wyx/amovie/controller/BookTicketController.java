package com.wyx.amovie.controller;

import com.wyx.amovie.entity.BookForm;
import com.wyx.amovie.entity.Scene;
import com.wyx.amovie.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author wyx
 * @date 2019-08-25 21:03
 */
@Controller
public class BookTicketController {

    @Autowired
    private SceneService sceneService;

    @RequestMapping(value = "/ticket")
    public String ticket() {
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

    @RequestMapping(value = "/book-final")
    public String book4(BookForm bookForm, Model model) {
        model.addAttribute("bookForm", bookForm);
        return "book-final";
    }
}
