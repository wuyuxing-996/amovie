package com.wyx.amovie.service;

import com.wyx.amovie.entity.Review;
import com.wyx.amovie.entity.ReviewVo;

import java.util.List;

/**
 * @author wyx
 */
public interface ReviewService {

    /**
     * 增加评论
     *
     * @param review
     * @return
     */
    int addReview(Review review);

    /**
     * 获取所有评论
     *
     * @return
     */
    List<Review> getAll();

    /**
     * 获取某电影的评论
     *
     * @param movieId
     * @return
     */
    List<ReviewVo> getMovieReview(Integer movieId);
}
