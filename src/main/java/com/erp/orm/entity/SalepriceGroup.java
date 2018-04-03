package com.erp.orm.entity;

/**
 * 零售价格组
 * @author xiao
 *
 */
public class SalepriceGroup {
	/**
	 * 零售价格组ID
	 */
    private Integer spgId;
    /**
     * 零售价格组名称
     */
    private String spgName;

    public Integer getSpgId() {
        return spgId;
    }

    public void setSpgId(Integer spgId) {
        this.spgId = spgId;
    }

    public String getSpgName() {
        return spgName;
    }

    public void setSpgName(String spgName) {
        this.spgName = spgName == null ? null : spgName.trim();
    }
}