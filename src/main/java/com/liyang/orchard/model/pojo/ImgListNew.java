package com.liyang.orchard.model.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "照片列表")
public class ImgListNew {

    @Id
    @ApiModelProperty(value = "imgID")
    @Column(name = "img_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imgId;

    @ApiModelProperty(value = "信息广场ID")
    @Column(name = "info_square_id")
    private Integer infoSquareId;

    @ApiModelProperty(value = "园主之家ID")
    @Column(name = "owner_house_id")
    private Integer ownerHouseId;

    @ApiModelProperty(value = "图片地址")
    @Column(name = "img_url")
    private String imgUrl;
}
