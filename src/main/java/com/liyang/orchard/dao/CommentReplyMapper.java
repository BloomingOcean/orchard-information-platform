package com.liyang.orchard.dao;

import com.liyang.orchard.core.Mapper;
import com.liyang.orchard.model.CommentReply;
import com.liyang.orchard.model.commentreport.AddCommentReply;
import org.apache.ibatis.annotations.Param;

public interface CommentReplyMapper extends Mapper<CommentReply> {

    void addCommentReply(AddCommentReply addCommentReply);

    void deleteCommentReplyById(@Param("commentReportId") Integer commentReportId);

    void deleteCommentReplyByCommentIds(@Param("CommentId") Integer CommentId);
}