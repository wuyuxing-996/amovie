package com.wyx.amovie.service.impl;

import com.wyx.amovie.entity.Watch;
import com.wyx.amovie.mapper.WatchMapper;
import com.wyx.amovie.service.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wyx
 * @date 2019-08-28 21:52
 */
@Service
public class WatchServiceImpl implements WatchService {

    @Autowired
    private WatchMapper watchMapper;

    @Override
    public int addWatch(Watch watch) {
        return watchMapper.addWatch(watch);
    }

    @Override
    public int deleteWatch(Integer movieId) {
        return watchMapper.deleteWatch(movieId);
    }

    @Override
    public Watch getWatchByIds(Integer userId, Integer movieId) {
        return watchMapper.getWatchByIds(userId, movieId);
    }
}
