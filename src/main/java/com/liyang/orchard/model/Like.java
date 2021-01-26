package com.liyang.orchard.model;

import javax.persistence.*;

public class Like {
    /**
     * 点赞ID
     */
    @Id
    @Column(name = "like_id")
    private Integer likeId;

    /**
     * 园主之家ID
     */
    @Column(name = "house_id")
    private Integer houseId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 获取点赞ID
     *
     * @return like_id - 点赞ID
     */
    public Integer getLikeId() {
        return likeId;
    }

    /**
     * 设置点赞ID
     *
     * @param likeId 点赞ID
     */
    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    /**
     * 获取园主之家ID
     *
     * @return house_id - 园主之家ID
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     * 设置园主之家ID
     *
     * @param houseId 园主之家ID
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
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
}