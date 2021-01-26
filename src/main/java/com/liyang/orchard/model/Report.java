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
@ApiModel(value = "举报")
@Table(name = "report")
public class Report {

    @Id
    @ApiModelProperty(value = "举报ID")
    @Column(name = "report_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;

    @ApiModelProperty(value = "用户ID")
    @Column(name = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "信息ID")
    @Column(name = "info_id")
    private Integer infoId;

    @ApiModelProperty(value = "举报详情")
    @Column(name = "report_content")
    private String reportContent;

    @ApiModelProperty(value = "举报时间")
    @Column(name = "report_date")
    private Date reportDate;

}