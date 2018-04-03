package com.erp.orm.entity;

import java.util.Date;

public class StoreDetail {
    /**
     * 库存批次号
     */
    private Integer sdId;
    /**
     * 库存主表
     */
    private Integer sId;
    /**
     * 机构编码
     */
    private String oCode;
    /**
     * 仓库编码
     */
    private String shCode;
    /**
     * 商品编码
     */
    private String wId;
    /**
     * 批号
     */
    private String batchNo;
    /**
     * 货位号
     */
    private String spCode;
    /**
     * 生产日期
     */
    private Date produceDate;
    /**
     * 有效期
     */
    private Date validDate;
    /**
     * 库存数量
     */
    private Float amount = 0f;
    /**
     * 待出库数量
     */
    private Float pAmount = 0f;

    private Date intime;

    public Integer getSdId() {
        return sdId;
    }

    public void setSdId(Integer sdId) {
        this.sdId = sdId;
    }

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

    public String getShCode() {
        return shCode;
    }

    public void setShCode(String shCode) {
        this.shCode = shCode == null ? null : shCode.trim();
    }

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId == null ? null : wId.trim();
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public String getSpCode() {
        return spCode;
    }

    public void setSpCode(String spCode) {
        this.spCode = spCode == null ? null : spCode.trim();
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

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getpAmount() {
        return pAmount;
    }

    public void setpAmount(Float pAmount) {
        this.pAmount = pAmount;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }
}