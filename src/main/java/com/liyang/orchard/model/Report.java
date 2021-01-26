package com.liyang.orchard.model;

import java.util.Date;
import javax.persistence.*;

public class Report {
    /**
     * 举报ID
     */
    @Id
    @Column(name = "report_id")
    private Integer reportId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 信息ID
     */
    @Column(name = "info_id")
    private Integer infoId;

    /**
     * 举报详情
     */
    @Column(name = "report_content")
    private String reportContent;

    /**
     * 举报时间
     */
    @Column(name = "report_date")
    private Date reportDate;

    /**
     * 获取举报ID
     *
     * @return report_id - 举报ID
     */
    public Integer getReportId() {
        return reportId;
    }

    /**
     * 设置举报ID
     *
     * @param reportId 举报ID
     */
    public void setReportId(Integer reportId) {
        this.reportId = reportId;
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
     * 获取信息ID
     *
     * @return info_id - 信息ID
     */
    public Integer getInfoId() {
        return infoId;
    }

    /**
     * 设置信息ID
     *
     * @param infoId 信息ID
     */
    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    /**
     * 获取举报详情
     *
     * @return report_content - 举报详情
     */
    public String getReportContent() {
        return reportContent;
    }

    /**
     * 设置举报详情
     *
     * @param reportContent 举报详情
     */
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    /**
     * 获取举报时间
     *
     * @return report_date - 举报时间
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * 设置举报时间
     *
     * @param reportDate 举报时间
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
}