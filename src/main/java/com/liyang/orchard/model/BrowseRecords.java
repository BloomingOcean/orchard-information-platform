package com.liyang.orchard.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "")
@Table(name = "browse_records")
public class BrowseRecords {
    /**
     * 浏览记录ID
     */
    @Id
    @ApiModelProperty(value = "")
    @Column(name = "browse_records_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer browseRecordsId;

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
     * 浏览时间
     */
    @Column(name = "browse_date")
    private Date browseDate;

    /**
     * 获取浏览记录ID
     *
     * @return browse_records_id - 浏览记录ID
     */
    public Integer getBrowseRecordsId() {
        return browseRecordsId;
    }

    /**
     * 设置浏览记录ID
     *
     * @param browseRecordsId 浏览记录ID
     */
    public void setBrowseRecordsId(Integer browseRecordsId) {
        this.browseRecordsId = browseRecordsId;
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
     * 获取浏览时间
     *
     * @return browse_date - 浏览时间
     */
    public Date getBrowseDate() {
        return browseDate;
    }

    /**
     * 设置浏览时间
     *
     * @param browseDate 浏览时间
     */
    public void setBrowseDate(Date browseDate) {
        this.browseDate = browseDate;
    }
}