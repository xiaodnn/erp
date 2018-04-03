package com.erp.orm.entity;

/**
 * 货位信息
 */
public class StorePlace {
    /**
     * 主键ID
     */
    private Integer spId;
    /**
     * 货位编码
     */
    private String spCode;
    /**
     * 货位名称
     */
    private String spName;
    /**
     * 库区ID
     */
    private Integer szId;

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public String getSpCode() {
        return spCode;
    }

    public void setSpCode(String spCode) {
        this.spCode = spCode == null ? null : spCode.trim();
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName == null ? null : spName.trim();
    }

    public Integer getSzId() {
        return szId;
    }

    public void setSzId(Integer szId) {
        this.szId = szId;
    }
}