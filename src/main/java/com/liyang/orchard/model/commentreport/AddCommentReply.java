package com.liyang.orchard.model.commentreport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "回复")
public class AddCommentReply {

    @JsonIgnore
    @Id
    @ApiModelProperty(name = "评论回复id")
    @Column(name = "comment_reply_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentReplyId;

    @ApiModelProperty(name = "评论id")
    @Column(name = "comment_id")
    private Integer commentId;

    @ApiModelProperty(name = "被回复用户id")
    @Column(name = "user_passive_id")
    private Integer userPassiveId;

    @ApiModelProperty(name = "回复用户id")
    @Column(name = "user_active_id")
    private Integer userActiveId;

    @ApiModelProperty(name = "回复内容")
    @Column(name = "report_text")
    private String reportText;

}