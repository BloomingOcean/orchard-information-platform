package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.CommentMapper;
import com.liyang.orchard.model.Comment;
import com.liyang.orchard.service.CommentService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Liyang on 2021/01/25.
 */
@Service
@Transactional
public class CommentServiceImpl extends AbstractService<Comment> implements CommentService {
    @Resource
    private CommentMapper commentMapper;

}
