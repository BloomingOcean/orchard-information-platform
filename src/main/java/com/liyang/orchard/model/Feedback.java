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
@ApiModel(value = "反馈")
@Table(name = "feedback")
public class Feedback {

    @Id
    @ApiModelProperty(value = "反馈ID")
    @Column(name = "feedback_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedbackId;

    @ApiModelProperty(value = "用户ID")
    @Column(name = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "反馈")
    @Column(name = "feedback")
    private String feedback;

    @ApiModelProperty(value = "反馈时间")
    @Column(name = "date")
    private Date date;

}