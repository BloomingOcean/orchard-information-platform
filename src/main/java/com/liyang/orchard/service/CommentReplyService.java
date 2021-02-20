package com.liyang.orchard.service;
import com.liyang.orchard.model.CommentReply;
import com.liyang.orchard.core.Service;
import com.liyang.orchard.model.commentreport.AddCommentReply;


/**
 * Created by Liyang on 2021/02/20.
 */
public interface CommentReplyService extends Service<CommentReply> {

    void addCommentReply(AddCommentReply addCommentReply);

    void deleteCommentReplyById(Integer id);

    void deleteCommentReplyByCommentId(Integer CommentId);
}
