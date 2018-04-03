package com.erp.orm.entity;

public class Store {
    /**
     * 库存ID(自增ID)
     */
    private Integer sId;
    /**
     * 机构编码
     */
    private String oCode;
    /**
     * 商品编码
     */
    private String wId;
    /**
     * 库存总数量
     */
    private Float amountSum = 0f;
    /**
     * 待出库总数量
     */
    private Float pAmountSum = 0f;
    /**
     * 最新进价
     */
    private Float costPrice = 0f;
    /**
     * 最新供应商
     */
    private String cId;

    private Integer count = 0;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getoCode() {
        return oCode;
    }

    public void setoCode(String oCode) {
        this.oCode = oCode == null ? null : oCode.trim();
    }

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId == null ? null : wId.trim();
    }

    public Float getAmountSum() {
        return amountSum;
    }

    public void setAmountSum(Float amountSum) {
        this.amountSum = amountSum;
    }

    public Float getpAmountSum() {
        return pAmountSum;
    }

    public void setpAmountSum(Float pAmountSum) {
        this.pAmountSum = pAmountSum;
    }

    public Float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Float costPrice) {
        this.costPrice = costPrice;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}