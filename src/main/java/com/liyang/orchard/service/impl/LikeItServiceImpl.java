package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.LikeItMapper;
import com.liyang.orchard.model.LikeIt;
import com.liyang.orchard.service.LikeItService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Liyang on 2021/01/30.
 */
@Service
@Transactional
public class LikeItServiceImpl extends AbstractService<LikeIt> implements LikeItService {
    @Resource
    private LikeItMapper likeItMapper;

}
