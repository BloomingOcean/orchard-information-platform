package com.liyang.orchard.model.infosquare;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "信息广场-发布劳务")
public class LabourInfoSquare {

    @ApiModelProperty(value = "用户ID")
    @Column(name = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "标题")
    @Column(name = "title")
    private String title;

    @ApiModelProperty(value = "描述")
    @Column(name = "description")
    private String description;

    @ApiModelProperty(value = "地址")
    @Column(name = "address")
    private String address;

    @ApiModelProperty(value = "昵称")
    @Column(name = "nikename")
    private String userNikename;

    @ApiModelProperty(value = "联系电话")
    @Column(name = "phone")
    private String phone;

    @ApiModelProperty(value = "招聘人数")
    @Column(name = "recruit_num")
    private String recruitNum;

    @ApiModelProperty(value = "图片列表")
    private List<String> imgList;
}
