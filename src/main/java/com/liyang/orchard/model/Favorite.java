package com.liyang.orchard.model;

import java.util.Date;
import javax.persistence.*;

public class Favorite {
    /**
     * 收藏ID
     */
    @Id
    @Column(name = "favorite_id")
    private Integer favoriteId;

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
     * 发布日期
     */
    private Date date;

    /**
     * 获取收藏ID
     *
     * @return favorite_id - 收藏ID
     */
    public Integer getFavoriteId() {
        return favoriteId;
    }

    /**
     * 设置收藏ID
     *
     * @param favoriteId 收藏ID
     */
    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
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