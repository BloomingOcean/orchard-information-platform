package com.liyang.orchard.model;

import java.util.Date;
import javax.persistence.*;

public class Feedback {
    /**
     * 反馈ID
     */
    @Id
    @Column(name = "feedback_id")
    private Integer feedbackId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 反馈
     */
    private String feedback;

    /**
     * 反馈时间
     */
    private Date date;

    /**
     * 获取反馈ID
     *
     * @return feedback_id - 反馈ID
     */
    public Integer getFeedbackId() {
        return feedbackId;
    }

    /**
     * 设置反馈ID
     *
     * @param feedbackId 反馈ID
     */
    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取反馈
     *
     * @return feedback - 反馈
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * 设置反馈
     *
     * @param feedback 反馈
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * 获取反馈时间
     *
     * @return date - 反馈时间
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置反馈时间
     *
     * @param date 反馈时间
     */
    public void setDate(Date date) {
        this.date = date;
    }
}