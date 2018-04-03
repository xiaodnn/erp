package com.erp.orm.entity;

/**
 * 
 * @author xiao
 * 
 * 商品零售价格组组合主键
 */
public class WaresSalepriceGroupKey {
	/**
	 * 零售价格组ID
	 */
    private Integer spgId;
    /**
     * 商品ID
     */
    private Integer wId;

    public WaresSalepriceGroupKey(){
    	
    }
    public WaresSalepriceGroupKey(Integer spgId,Integer wId){
    	this.spgId = spgId;
    	this.wId = wId;
    }
    
    public Integer getSpgId() {
        return spgId;
    }

    public void setSpgId(Integer spgId) {
        this.spgId = spgId;
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }
}