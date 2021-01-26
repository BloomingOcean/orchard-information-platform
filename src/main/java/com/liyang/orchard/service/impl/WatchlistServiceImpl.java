package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.WatchlistMapper;
import com.liyang.orchard.model.Watchlist;
import com.liyang.orchard.service.WatchlistService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Liyang on 2021/01/25.
 */
@Service
@Transactional
public class WatchlistServiceImpl extends AbstractService<Watchlist> implements WatchlistService {
    @Resource
    private WatchlistMapper watchlistMapper;

}
