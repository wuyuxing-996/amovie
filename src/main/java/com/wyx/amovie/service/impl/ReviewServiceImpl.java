package com.wyx.amovie.service.impl;

import com.wyx.amovie.entity.Review;
import com.wyx.amovie.entity.ReviewVo;
import com.wyx.amovie.mapper.ReviewMapper;
import com.wyx.amovie.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wyx
 * @date 2019-08-28 16:04
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public int addReview(Review review) {
        return reviewMapper.addReview(review);
    }

    @Override
    public List<Review> getAll() {
        return reviewMapper.getAll();
    }

    @Override
    public List<ReviewVo> getMovieReview(Integer movieId) {
        return reviewMapper.getMovieReview(movieId);
    }
}
