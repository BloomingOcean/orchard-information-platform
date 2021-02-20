package com.liyang.orchard.model.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "登录用户")
public class LoginUser {

    @ApiModelProperty(value = "用户ID")
    @Column(name = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "昵称")
    @Column(name = "nikename")
    private String userNikename;

    @ApiModelProperty(value = "电话号码")
    @Column(name = "phone")
    private String userPhone;

    @ApiModelProperty(value = "token")
    @Column(name = "token")
    private String userToken;

}