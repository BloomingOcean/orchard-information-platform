package com.liyang.orchard.model;

import java.util.Date;
import javax.persistence.*;

public class Comment {
    /**
     * 评论ID
     */
    @Id
    @Column(name = "com_id")
    private Integer comId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 信息广场ID
     */
    @Column(name = "info_id")
    private Integer infoId;

    /**
     * 园主之家ID
     */
    @Column(name = "owner_house_id")
    private Integer ownerHouseId;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 评论日期
     */
    @Column(name = "com_date")
    private Date comDate;

    /**
     * 获取评论ID
     *
     * @return com_id - 评论ID
     */
    public Integer getComId() {
        return comId;
    }

    /**
     * 设置评论ID
     *
     * @param comId 评论ID
     */
    public void setComId(Integer comId) {
        this.comId = comId;
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
     * 获取信息广场ID
     *
     * @return info_id - 信息广场ID
     */
    public Integer getInfoId() {
        return infoId;
    }

    /**
     * 设置信息广场ID
     *
     * @param infoId 信息广场ID
     */
    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    /**
     * 获取园主之家ID
     *
     * @return owner_house_id - 园主之家ID
     */
    public Integer getOwnerHouseId() {
        return ownerHouseId;
    }

    /**
     * 设置园主之家ID
     *
     * @param ownerHouseId 园主之家ID
     */
    public void setOwnerHouseId(Integer ownerHouseId) {
        this.ownerHouseId = ownerHouseId;
    }

    /**
     * 获取评论内容
     *
     * @return comment - 评论内容
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置评论内容
     *
     * @param comment 评论内容
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取评论日期
     *
     * @return com_date - 评论日期
     */
    public Date getComDate() {
        return comDate;
    }

    /**
     * 设置评论日期
     *
     * @param comDate 评论日期
     */
    public void setComDate(Date comDate) {
        this.comDate = comDate;
    }
}