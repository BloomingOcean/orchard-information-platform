package com.liyang.orchard.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "关注列表")
@Table(name = "watchlist")
public class Watchlist {

    @Id
    @ApiModelProperty(value = "关注列表ID")
    @Column(name = "watch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer watchId;

    @ApiModelProperty(value = "关注用户")
    @Column(name = "user_positive_id")
    private Integer userPositiveId;

    @ApiModelProperty(value = "被关注用户")
    @Column(name = "user_passive_id")
    private Integer userPassiveId;

}