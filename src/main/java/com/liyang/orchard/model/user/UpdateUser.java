package com.liyang.orchard.model.user;

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
@ApiModel(value = "用户自己能更新的信息")
public class UpdateUser {

    @Id
    @ApiModelProperty(value = "用户ID")
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @ApiModelProperty(value = "头像地址")
    @Column(name = "portrait_url")
    private String portraitUrl;

    @ApiModelProperty(value = "昵称")
    @Column(name = "nickname")
    private String nickname;

    @ApiModelProperty(value = "真实姓名")
    @Column(name = "name")
    private String name;

//    @ApiModelProperty(value = "身份证")
//    @Column(name = "id_number")
//    private String idNumber;

//    @ApiModelProperty(value = "实名认证")
//    @Column(name = "verified")
//    private String verified;

//    @ApiModelProperty(value = "会员截至日期")
//    @Column(name = "membership_deadline")
//    private Date membershipDeadline;

    @ApiModelProperty(value = "电话号码")
    @Column(name = "phone")
    private String phone;

    @ApiModelProperty(value = "用户个人描述")
    @Column(name = "user_description")
    private String userDescription;

    @ApiModelProperty(value = "用户居住地址")
    @Column(name = "user_address")
    private String userAddress;

//    @ApiModelProperty(value = "用户角色id")
//    @Column(name = "role_id")
//    private String roleId;
}