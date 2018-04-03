package com.erp.model;

/**
 * 采购入库单 Json 格式
 */
public class JsonWarehousingDetail {
    private String status;
    private String wId;//商品ID
    private String wdSaleprice;//售价
    private String wdCostprice;//进价
    private String wdAmount;//数量
    private String wdDiscount;//折扣
    private String wdDiscPrice;//折扣价
    private String wdBatchNo;//批号
    private String wdIndate;//有效期
    private String wdDate;//生产日期
    private String wdAllocation;//货位
    private String wdIndex;//序号


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId;
    }

    public String getWdSaleprice() {
        return wdSaleprice;
    }

    public void setWdSaleprice(String wdSaleprice) {
        this.wdSaleprice = wdSaleprice;
    }

    public String getWdCostprice() {
        return wdCostprice;
    }

    public void setWdCostprice(String wdCostprice) {
        this.wdCostprice = wdCostprice;
    }

    public String getWdDiscount() {
        return wdDiscount;
    }

    public void setWdDiscount(String wdDiscount) {
        this.wdDiscount = wdDiscount;
    }

    public String getWdAmount() {
        return wdAmount;
    }

    public void setWdAmount(String wdAmount) {
        this.wdAmount = wdAmount;
    }

    public String getWdDiscPrice() {
        return wdDiscPrice;
    }

    public void setWdDiscPrice(String wdDiscPrice) {
        this.wdDiscPrice = wdDiscPrice;
    }

    public String getWdBatchNo() {
        return wdBatchNo;
    }

    public void setWdBatchNo(String wdBatchNo) {
        this.wdBatchNo = wdBatchNo;
    }

    public String getWdIndate() {
        return wdIndate;
    }

    public void setWdIndate(String wdIndate) {
        this.wdIndate = wdIndate;
    }

    public String getWdDate() {
        return wdDate;
    }

    public void setWdDate(String wdDate) {
        this.wdDate = wdDate;
    }

    public String getWdAllocation() {
        return wdAllocation;
    }

    public void setWdAllocation(String wdAllocation) {
        this.wdAllocation = wdAllocation;
    }

    public String getWdIndex() {
        return wdIndex;
    }

    public void setWdIndex(String wdIndex) {
        this.wdIndex = wdIndex;
    }
}
