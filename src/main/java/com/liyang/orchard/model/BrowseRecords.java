package com.liyang.orchard.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "浏览记录")
@Table(name = "browse_records")
public class BrowseRecords {

    @Id
    @ApiModelProperty(value = "浏览记录ID")
    @Column(name = "browse_records_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer browseRecordsId;

    @ApiModelProperty(value = "用户ID")
    @Column(name = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "信息广场ID")
    @Column(name = "info_id")
    private Integer infoId;

    @ApiModelProperty(value = "园主之家ID")
    @Column(name = "owner_house_id")
    private Integer ownerHouseId;

    @ApiModelProperty(value = "浏览时间")
    @Column(name = "browse_date")
    private Date browseDate;

}