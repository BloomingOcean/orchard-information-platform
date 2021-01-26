package com.liyang.orchard.model;

import java.util.Date;
import javax.persistence.*;

public class User {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 头像地址
     */
    @Column(name = "portrait_url")
    private String portraitUrl;

    /**
     * 昵称
     */
    private String nikename;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 身份证
     */
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 实名认证
     */
    private String verified;

    /**
     * 会员截至日期
     */
    @Column(name = "membership_deadline")
    private Date membershipDeadline;

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
     * 获取头像地址
     *
     * @return portrait_url - 头像地址
     */
    public String getPortraitUrl() {
        return portraitUrl;
    }

    /**
     * 设置头像地址
     *
     * @param portraitUrl 头像地址
     */
    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    /**
     * 获取昵称
     *
     * @return nikename - 昵称
     */
    public String getNikename() {
        return nikename;
    }

    /**
     * 设置昵称
     *
     * @param nikename 昵称
     */
    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    /**
     * 获取真实姓名
     *
     * @return name - 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置真实姓名
     *
     * @param name 真实姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取身份证
     *
     * @return id_number - 身份证
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置身份证
     *
     * @param idNumber 身份证
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * 获取实名认证
     *
     * @return verified - 实名认证
     */
    public String getVerified() {
        return verified;
    }

    /**
     * 设置实名认证
     *
     * @param verified 实名认证
     */
    public void setVerified(String verified) {
        this.verified = verified;
    }

    /**
     * 获取会员截至日期
     *
     * @return membership_deadline - 会员截至日期
     */
    public Date getMembershipDeadline() {
        return membershipDeadline;
    }

    /**
     * 设置会员截至日期
     *
     * @param membershipDeadline 会员截至日期
     */
    public void setMembershipDeadline(Date membershipDeadline) {
        this.membershipDeadline = membershipDeadline;
    }
}