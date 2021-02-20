package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.CommentReplyMapper;
import com.liyang.orchard.model.CommentReply;
import com.liyang.orchard.model.commentreport.AddCommentReply;
import com.liyang.orchard.service.CommentReplyService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Liyang on 2021/02/20.
 */
@Service
@Transactional
public class CommentReplyServiceImpl extends AbstractService<CommentReply> implements CommentReplyService {
    @Resource
    private CommentReplyMapper commentReplyMapper;

    @Override
    public void addCommentReply(AddCommentReply addCommentReply) {
        commentReplyMapper.addCommentReply(addCommentReply);
    }

    @Override
    public void deleteCommentReplyById(Integer id) {
        commentReplyMapper.deleteCommentReplyById(id);
    }

    @Override
    public void deleteCommentReplyByCommentId(Integer CommentId) {
        commentReplyMapper.deleteCommentReplyByCommentIds(CommentId);
    }
}
