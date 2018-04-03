package com.erp.orm.entity;

import java.util.Date;

public class StoreBatch {
    /**
     * 库存批次ID
     */
    private Integer sbId;
    /**
     * 库存主表ID
     */
    private Integer sId;
    /**
     *商品ID
     */
    private String wId;
    /**
     * 供应商编码
     */
    private String cId;
    /**
     * 入库数量
     */
    private Float amount = 0f;
    /**
     * 批次进价
     */
    private Float costprice = 0f;
    /**
     * 生产批号
     */
    private String batchNo;
    /**
     * 生产日期
     */
    private Date produceDate;
    /**
     * 有效期
     */
    private Date validDate;
    /**
     *采购员
     */
    private String buyer;
    /**
     *入库时间
     */
    private Date intime;

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId == null ? null : wId.trim();
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getCostprice() {
        return costprice;
    }

    public void setCostprice(Float costprice) {
        this.costprice = costprice;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer == null ? null : buyer.trim();
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }
}