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
@ApiModel(value = "用户")
@Table(name = "user")
public class User {

    @Id
    @ApiModelProperty(value = "用户ID")
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @ApiModelProperty(value = "头像地址")
    @Column(name = "portrait_url")
    private String portraitUrl;

    @ApiModelProperty(value = "昵称")
    @Column(name = "nikename")
    private String nikename;

    @ApiModelProperty(value = "真实姓名")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "身份证")
    @Column(name = "id_number")
    private String idNumber;

    @ApiModelProperty(value = "实名认证")
    @Column(name = "verified")
    private String verified;

    @ApiModelProperty(value = "会员截至日期")
    @Column(name = "membership_deadline")
    private Date membershipDeadline;

    @ApiModelProperty(value = "电话号码")
    @Column(name = "phone")
    private String phone;

    @ApiModelProperty(value = "密码")
    @Column(name = "password")
    private String password;

}