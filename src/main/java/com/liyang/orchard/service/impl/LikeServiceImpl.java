package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.LikeMapper;
import com.liyang.orchard.model.Like;
import com.liyang.orchard.service.LikeService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Liyang on 2021/01/25.
 */
@Service
@Transactional
public class LikeServiceImpl extends AbstractService<Like> implements LikeService {
    @Resource
    private LikeMapper likeMapper;

}
