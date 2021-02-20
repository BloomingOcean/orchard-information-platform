package com.liyang.orchard.dao;

import com.liyang.orchard.core.Mapper;
import com.liyang.orchard.model.Comment;
import com.liyang.orchard.model.commentreport.AddInfoSquareComment;
import com.liyang.orchard.model.commentreport.AddOwnerHouseComment;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CommentMapper extends Mapper<Comment> {

    void addInfoSquareComment(AddInfoSquareComment addInfoSquareComment);

    void addOwnerHouseComment(AddOwnerHouseComment addOwnerHouseComment);

    void deleteByCommentId(Integer commentId);

    List<Integer> getCommentIdsByInfoSquareId(Integer infoSquareId);

    List<Integer> getCommentIdsByOwnerHouseId(Integer ownerHouseId);
}