package com.liyang.orchard.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "owner_house")
public class OwnerHouse {
    /**
     * 园主之家
     */
    @Id
    @Column(name = "owner_house_id")
    private Integer ownerHouseId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片URL
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 视频源
     */
    @Column(name = "video_source")
    private String videoSource;

    /**
     * 点赞
     */
    private String like;

    /**
     * 发布日期
     */
    private Date date;

    /**
     * 获取园主之家
     *
     * @return owner_house_id - 园主之家
     */
    public Integer getOwnerHouseId() {
        return ownerHouseId;
    }

    /**
     * 设置园主之家
     *
     * @param ownerHouseId 园主之家
     */
    public void setOwnerHouseId(Integer ownerHouseId) {
        this.ownerHouseId = ownerHouseId;
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
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取图片URL
     *
     * @return img_url - 图片URL
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置图片URL
     *
     * @param imgUrl 图片URL
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * 获取视频源
     *
     * @return video_source - 视频源
     */
    public String getVideoSource() {
        return videoSource;
    }

    /**
     * 设置视频源
     *
     * @param videoSource 视频源
     */
    public void setVideoSource(String videoSource) {
        this.videoSource = videoSource;
    }

    /**
     * 获取点赞
     *
     * @return like - 点赞
     */
    public String getLike() {
        return like;
    }

    /**
     * 设置点赞
     *
     * @param like 点赞
     */
    public void setLike(String like) {
        this.like = like;
    }

    /**
     * 获取发布日期
     *
     * @return date - 发布日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置发布日期
     *
     * @param date 发布日期
     */
    public void setDate(Date date) {
        this.date = date;
    }
}