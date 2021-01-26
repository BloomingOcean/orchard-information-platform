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
@ApiModel(value = "收藏")
@Table(name = "favorite")
public class Favorite {

    @Id
    @ApiModelProperty(value = "收藏ID")
    @Column(name = "favorite_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer favoriteId;

    @ApiModelProperty(value = "用户ID")
    @Column(name = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "信息广场ID")
    @Column(name = "info_id")
    private Integer infoId;

    @ApiModelProperty(value = "发布日期")
    @Column(name = "date")
    private Date date;

}