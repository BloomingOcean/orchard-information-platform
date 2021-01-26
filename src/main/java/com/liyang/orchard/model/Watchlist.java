package com.liyang.orchard.model;

import javax.persistence.*;

public class Watchlist {
    /**
     * 关注列表ID
     */
    @Id
    @Column(name = "watch_id")
    private Integer watchId;

    /**
     * 关注用户
     */
    @Column(name = "user_positive_id")
    private Integer userPositiveId;

    /**
     * 被关注用户
     */
    @Column(name = "user_passive_id")
    private Integer userPassiveId;

    /**
     * 获取关注列表ID
     *
     * @return watch_id - 关注列表ID
     */
    public Integer getWatchId() {
        return watchId;
    }

    /**
     * 设置关注列表ID
     *
     * @param watchId 关注列表ID
     */
    public void setWatchId(Integer watchId) {
        this.watchId = watchId;
    }

    /**
     * 获取关注用户
     *
     * @return user_positive_id - 关注用户
     */
    public Integer getUserPositiveId() {
        return userPositiveId;
    }

    /**
     * 设置关注用户
     *
     * @param userPositiveId 关注用户
     */
    public void setUserPositiveId(Integer userPositiveId) {
        this.userPositiveId = userPositiveId;
    }

    /**
     * 获取被关注用户
     *
     * @return user_passive_id - 被关注用户
     */
    public Integer getUserPassiveId() {
        return userPassiveId;
    }

    /**
     * 设置被关注用户
     *
     * @param userPassiveId 被关注用户
     */
    public void setUserPassiveId(Integer userPassiveId) {
        this.userPassiveId = userPassiveId;
    }
}