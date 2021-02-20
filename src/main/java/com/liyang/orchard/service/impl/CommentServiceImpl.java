package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.CommentMapper;
import com.liyang.orchard.dao.CommentReplyMapper;
import com.liyang.orchard.model.Comment;
import com.liyang.orchard.model.CommentReply;
import com.liyang.orchard.model.commentreport.AddInfoSquareComment;
import com.liyang.orchard.model.commentreport.AddOwnerHouseComment;
import com.liyang.orchard.service.CommentService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Liyang on 2021/01/25.
 */
@Service
@Transactional
public class CommentServiceImpl extends AbstractService<Comment> implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Resource
    private CommentReplyMapper commentReplyMapper;

    @Override
    public void addInfoSquareComment(AddInfoSquareComment addInfoSquareComment) {
        commentMapper.addInfoSquareComment(addInfoSquareComment);
    }

    @Override
    public void addOwnerHouseComment(AddOwnerHouseComment addOwnerHouseComment) {
        commentMapper.addOwnerHouseComment(addOwnerHouseComment);
    }

    @Override
    public void deleteByCommentId(Integer commentId) {
        commentMapper.deleteByCommentId(commentId);
        // 删除其下回复
        commentReplyMapper.deleteCommentReplyByCommentIds(commentId);
    }

}
