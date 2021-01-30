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
@ApiModel(value = "园主之家")
@Table(name = "owner_house")
public class OwnerHouse {

    @Id
    @ApiModelProperty(value = "园主之家ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_house_id")
    private Integer ownerHouseId;

    @ApiModelProperty(value = "用户ID")
    @Column(name = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "描述")
    @Column(name = "description")
    private String description;

    @ApiModelProperty(value = "图片URL")
    @Column(name = "img_url")
    private String imgUrl;

    @ApiModelProperty(value = "视频源")
    @Column(name = "video_source")
    private String videoSource;

    @ApiModelProperty(value = "点赞数量")
    @Column(name = "like_it")
    private Integer likeIt;

    @ApiModelProperty(value = "发布日期")
    @Column(name = "date")
    private Date date;

}