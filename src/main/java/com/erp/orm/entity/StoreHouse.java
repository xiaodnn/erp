package com.erp.orm.entity;

import java.util.Date;

/**
 * 仓库信息
 */
public class StoreHouse {
    /**
     * 主键ID
     */
    private Integer shId;
    /**
     * 仓库编码
     */
    private String shCode;
    /**
     * 机构ID
     */
    private Integer oId;
    /**
     * 仓库名称
     */
    private String shName;
    /**
     * 创建人
     */
    private String shCreator;
    /**
     * 创建时间
     */
    private Date shIntime;

    public Integer getShId() {
        return shId;
    }

    public void setShId(Integer shId) {
        this.shId = shId;
    }

    public String getShCode() {
        return shCode;
    }

    public void setShCode(String shCode) {
        this.shCode = shCode == null ? null : shCode.trim();
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getShName() {
        return shName;
    }

    public void setShName(String shName) {
        this.shName = shName == null ? null : shName.trim();
    }

    public Date getShIntime() {
        return shIntime;
    }

    public void setShIntime(Date shIntime) {
        this.shIntime = shIntime;
    }

    public String getShCreator() {
        return shCreator;
    }

    public void setShCreator(String shCreator) {
        this.shCreator = shCreator == null ? null : shCreator.trim();
    }
}