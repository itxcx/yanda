package com.yanda.entity.generated;

import java.io.Serializable;
import java.util.Date;

public class BannerInfo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_banner_info.banner_id
     *
     * @mbggenerated
     */
    private Long bannerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_banner_info.banner_desc
     *
     * @mbggenerated
     */
    private String bannerDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_banner_info.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_banner_info.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_banner_info.type
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_banner_info.appendix_id
     *
     * @mbggenerated
     */
    private Long appendixId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_banner_info.mv_id
     *
     * @mbggenerated
     */
    private Long mvId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_banner_info
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_banner_info
     *
     * @mbggenerated
     */
    public BannerInfo(Long bannerId, String bannerDesc, Date createTime, Date updateTime, Integer type, Long appendixId, Long mvId) {
        this.bannerId = bannerId;
        this.bannerDesc = bannerDesc;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.type = type;
        this.appendixId = appendixId;
        this.mvId = mvId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_banner_info
     *
     * @mbggenerated
     */
    public BannerInfo() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_banner_info.banner_id
     *
     * @return the value of t_banner_info.banner_id
     *
     * @mbggenerated
     */
    public Long getBannerId() {
        return bannerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_banner_info.banner_id
     *
     * @param bannerId the value for t_banner_info.banner_id
     *
     * @mbggenerated
     */
    public void setBannerId(Long bannerId) {
        this.bannerId = bannerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_banner_info.banner_desc
     *
     * @return the value of t_banner_info.banner_desc
     *
     * @mbggenerated
     */
    public String getBannerDesc() {
        return bannerDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_banner_info.banner_desc
     *
     * @param bannerDesc the value for t_banner_info.banner_desc
     *
     * @mbggenerated
     */
    public void setBannerDesc(String bannerDesc) {
        this.bannerDesc = bannerDesc == null ? null : bannerDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_banner_info.create_time
     *
     * @return the value of t_banner_info.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_banner_info.create_time
     *
     * @param createTime the value for t_banner_info.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_banner_info.update_time
     *
     * @return the value of t_banner_info.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_banner_info.update_time
     *
     * @param updateTime the value for t_banner_info.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_banner_info.type
     *
     * @return the value of t_banner_info.type
     *
     * @mbggenerated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_banner_info.type
     *
     * @param type the value for t_banner_info.type
     *
     * @mbggenerated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_banner_info.appendix_id
     *
     * @return the value of t_banner_info.appendix_id
     *
     * @mbggenerated
     */
    public Long getAppendixId() {
        return appendixId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_banner_info.appendix_id
     *
     * @param appendixId the value for t_banner_info.appendix_id
     *
     * @mbggenerated
     */
    public void setAppendixId(Long appendixId) {
        this.appendixId = appendixId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_banner_info.mv_id
     *
     * @return the value of t_banner_info.mv_id
     *
     * @mbggenerated
     */
    public Long getMvId() {
        return mvId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_banner_info.mv_id
     *
     * @param mvId the value for t_banner_info.mv_id
     *
     * @mbggenerated
     */
    public void setMvId(Long mvId) {
        this.mvId = mvId;
    }
}