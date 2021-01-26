package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.FavoriteMapper;
import com.liyang.orchard.model.Favorite;
import com.liyang.orchard.service.FavoriteService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Liyang on 2021/01/25.
 */
@Service
@Transactional
public class FavoriteServiceImpl extends AbstractService<Favorite> implements FavoriteService {
    @Resource
    private FavoriteMapper favoriteMapper;

}
