package com.liyang.orchard.service;
import com.liyang.orchard.model.Comment;
import com.liyang.orchard.core.Service;
import com.liyang.orchard.model.commentreport.AddInfoSquareComment;
import com.liyang.orchard.model.commentreport.AddOwnerHouseComment;


/**
 * Created by Liyang on 2021/01/25.
 */
public interface CommentService extends Service<Comment> {

    void addInfoSquareComment(AddInfoSquareComment addInfoSquareComment);

    void addOwnerHouseComment(AddOwnerHouseComment addOwnerHouseComment);

    void deleteByCommentId(Integer infoSquareId);

}
