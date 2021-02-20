package com.liyang.orchard.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "个人信息（简单）")
public class SimpleUser {
    @Id
    @ApiModelProperty(value = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private String userId;

    @ApiModelProperty(value = "昵称")
    @Column(name = "user_nickname")
    private String userNickname;

    @ApiModelProperty(value = "用户个人简介")
    @Column(name = "user_description")
    private String userDescription;

    @ApiModelProperty(value = "用户头像url")
    @Column(name = "user_portrait")
    private String userPortrait;
}
