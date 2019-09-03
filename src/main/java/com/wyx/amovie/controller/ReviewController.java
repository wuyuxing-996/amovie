package com.wyx.amovie.controller;

import com.wyx.amovie.entity.Review;
import com.wyx.amovie.entity.User;
import com.wyx.amovie.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author wyx
 * @date 2019-08-28 15:39
 */
@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping(value = "/review")
    public ResponseEntity addReview(Review review, HttpSession session) {
        User user = (User) session.getAttribute("login");
        if (user == null) {
            return ResponseEntity.ok("请先登录！");
        }
        review.setCreateTime(new Date());
        review.setUserId(user.getId());
        int result = reviewService.addReview(review);
        if (result != 0) {
            return ResponseEntity.ok("评论成功！");
        }
        return ResponseEntity.ok("评论异常！");
    }
}
