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
@ApiModel(value = "信息广场-信息类型")
@Table(name = "type")
public class Type {

    @Id
    @Column(name = "type_id")
    @ApiModelProperty(value = "信息类型ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;

    @ApiModelProperty(value = "类型名称")
    @Column(name = "type_name")
    private String typeName;

}