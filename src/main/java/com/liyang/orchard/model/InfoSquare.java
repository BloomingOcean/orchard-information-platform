package com.liyang.orchard.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "info_square")
public class InfoSquare {
    /**
     * 信息ID
     */
    @Id
    @Column(name = "info_id")
    private Integer infoId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系人
     */
    private String name;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 图片地址
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 视频源
     */
    @Column(name = "video_source")
    private String videoSource;

    /**
     * 求购重量
     */
    @Column(name = "buy_weight")
    private String buyWeight;

    /**
     * 招聘人数
     */
    @Column(name = "recruit_num")
    private String recruitNum;

    /**
     * 信息类型
     */
    @Column(name = "info_type_id")
    private Integer infoTypeId;

    /**
     * 发布时间
     */
    @Column(name = "release_date")
    private Date releaseDate;

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
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
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
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取联系人
     *
     * @return name - 联系人
     */
    public String getName() {
        return name;
    }

    /**
     * 设置联系人
     *
     * @param name 联系人
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取图片地址
     *
     * @return img_url - 图片地址
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置图片地址
     *
     * @param imgUrl 图片地址
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
     * 获取求购重量
     *
     * @return buy_weight - 求购重量
     */
    public String getBuyWeight() {
        return buyWeight;
    }

    /**
     * 设置求购重量
     *
     * @param buyWeight 求购重量
     */
    public void setBuyWeight(String buyWeight) {
        this.buyWeight = buyWeight;
    }

    /**
     * 获取招聘人数
     *
     * @return recruit_num - 招聘人数
     */
    public String getRecruitNum() {
        return recruitNum;
    }

    /**
     * 设置招聘人数
     *
     * @param recruitNum 招聘人数
     */
    public void setRecruitNum(String recruitNum) {
        this.recruitNum = recruitNum;
    }

    /**
     * 获取信息类型
     *
     * @return info_type_id - 信息类型
     */
    public Integer getInfoTypeId() {
        return infoTypeId;
    }

    /**
     * 设置信息类型
     *
     * @param infoTypeId 信息类型
     */
    public void setInfoTypeId(Integer infoTypeId) {
        this.infoTypeId = infoTypeId;
    }

    /**
     * 获取发布时间
     *
     * @return release_date - 发布时间
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * 设置发布时间
     *
     * @param releaseDate 发布时间
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}