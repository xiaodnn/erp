package com.erp.orm.entity;

/**
 * 商品批发价格组 组合主键
 * @author xiao
 *
 */
public class WaresWholepriceGroupKey {
	/**
	 * 批发价格组ID
	 */
    private Integer wpgId;
    /**
     * 商品ID
     */
    private Integer wId;

    public WaresWholepriceGroupKey(){
    	
    }
    public WaresWholepriceGroupKey( Integer wpgId,Integer wId){
    	this.wpgId = wpgId;
    	this.wId = wId;
    }
    
    public Integer getWpgId() {
        return wpgId;
    }

    public void setWpgId(Integer wpgId) {
        this.wpgId = wpgId;
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }
}