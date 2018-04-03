package com.erp.orm.entity;

import java.util.Date;

/**
 *  库区信息
 */
public class StoreZone {
    /**
     * 主键ID
     */
    private Integer szId;
    /**
     * 库区编码
     */
    private String szCode;
    /**
     * 仓库ID
     */
    private Integer shId;
    /**
     * 库区名称
     */
    private String szName;
    /**
     * 创建时间
     */
    private Date szIntime;
    /**
     * 创建人
     */
    private String szCreator;

    public Integer getSzId() {
        return szId;
    }

    public void setSzId(Integer szId) {
        this.szId = szId;
    }

    public String getSzCode() {
        return szCode;
    }

    public void setSzCode(String szCode) {
        this.szCode = szCode == null ? null : szCode.trim();
    }

    public Integer getShId() {
        return shId;
    }

    public void setShId(Integer shId) {
        this.shId = shId;
    }

    public String getSzName() {
        return szName;
    }

    public void setSzName(String szName) {
        this.szName = szName == null ? null : szName.trim();
    }

    public Date getSzIntime() {
        return szIntime;
    }

    public void setSzIntime(Date szIntime) {
        this.szIntime = szIntime;
    }

    public String getSzCreator() {
        return szCreator;
    }

    public void setSzCreator(String szCreator) {
        this.szCreator = szCreator == null ? null : szCreator.trim();
    }
}