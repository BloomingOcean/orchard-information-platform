package com.liyang.orchard.model;

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
@ApiModel(value = "评论")
@Table(name = "comment")
public class Comment {

    @Id
    @ApiModelProperty(value = "评论ID")
    @Column(name = "com_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer comId;

    @ApiModelProperty(value = "用户ID")
    @Column(name = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "信息广场ID")
    @Column(name = "info_id")
    private Integer infoId;

    @ApiModelProperty(value = "园主之家ID")
    @Column(name = "owner_house_id")
    private Integer ownerHouseId;

    @ApiModelProperty(value = "评论内容")
    @Column(name = "comment")
    private String comment;

    @ApiModelProperty(value = "评论日期")
    @Column(name = "com_date")
    private Date comDate;

}