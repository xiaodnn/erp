package com.erp.orm.entity;

/**
 * 批发价格组
 * @author xiao
 *
 */
public class WholepriceGroup {
	/**
	 * 批发价格组ID
	 */
    private Integer wpgId;
    /**
     * 批发价格组名称
     */
    private String wpgName;

    public Integer getWpgId() {
        return wpgId;
    }

    public void setWpgId(Integer wpgId) {
        this.wpgId = wpgId;
    }

    public String getWpgName() {
        return wpgName;
    }

    public void setWpgName(String wpgName) {
        this.wpgName = wpgName == null ? null : wpgName.trim();
    }
}