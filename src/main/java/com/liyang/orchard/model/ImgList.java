package com.liyang.orchard.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "图片列表")
@Table(name = "img_list")
public class ImgList {

    @Id
    @ApiModelProperty(name = "图片url")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_id")
    private Integer imgId;

    @ApiModelProperty(value = "信息广场id")
    @Column(name = "info_square_id")
    private Integer infoSquareId;

    @ApiModelProperty(value = "园主之家id")
    @Column(name = "owner_house_id")
    private Integer ownerHouseId;

    @ApiModelProperty(value = "图片地址")
    @Column(name = "img_url")
    private String imgUrl;
}