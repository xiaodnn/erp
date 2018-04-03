package com.erp.orm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 批发销售申请单
 */
public class WholesaleApply {
    /**
     * 主键自增ID
     */
    private Integer waId;
    /**
     * 制单人
     */
    private String waCreator;
    /**
     * 制单时间
     */
    private String waDate;
    /**
     * 客户ID
     */
    private Integer cbId;
    /**
     * 客户收货地址
     */
    private String cbStorehouse;
    /**
     * 提货方式
     */
    private String waReceiveWay;
    /**
     * 付款方式
     */
    private String waPayWay;
    /**
     * 发票类型
     */
    private String waInvoiceType;
    /**
     * 价格组ID
     */
    private Integer pId;
    /**
     * 状态
     */
    private Byte waState;
    /**
     * 出库仓库ID
     */
    private Integer shId;
    /**
     * 业务员(员工ID)
     */
    private Integer eId;
    /**
     * 备注
     */
    private String waRemark;
    /**
     * 记录时间
     */
    private String intime;

    public Integer getWaId() {
        return waId;
    }

    public void setWaId(Integer waId) {
        this.waId = waId;
    }

    public String getWaCreator() {
        return waCreator;
    }

    public void setWaCreator(String waCreator) {
        this.waCreator = waCreator == null ? null : waCreator.trim();
    }

    public String getWaDate() {
        return waDate;
    }

    public void setWaDate(String waDate) {
        this.waDate = waDate;
    }

    public Integer getCbId() {
        return cbId;
    }

    public void setCbId(Integer cbId) {
        this.cbId = cbId;
    }

    public String getCbStorehouse() {
        return cbStorehouse;
    }

    public void setCbStorehouse(String cbStorehouse) {
        this.cbStorehouse = cbStorehouse == null ? null : cbStorehouse.trim();
    }

    public String getWaReceiveWay() {
        return waReceiveWay;
    }

    public void setWaReceiveWay(String waReceiveWay) {
        this.waReceiveWay = waReceiveWay == null ? null : waReceiveWay.trim();
    }

    public String getWaPayWay() {
        return waPayWay;
    }

    public void setWaPayWay(String waPayWay) {
        this.waPayWay = waPayWay == null ? null : waPayWay.trim();
    }

    public String getWaInvoiceType() {
        return waInvoiceType;
    }

    public void setWaInvoiceType(String waInvoiceType) {
        this.waInvoiceType = waInvoiceType == null ? null : waInvoiceType.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Byte getWaState() {
        return waState;
    }

    public void setWaState(Byte waState) {
        this.waState = waState;
    }

    public Integer getShId() {
        return shId;
    }

    public void setShId(Integer shId) {
        this.shId = shId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String getWaRemark() {
        return waRemark;
    }

    public void setWaRemark(String waRemark) {
        this.waRemark = waRemark == null ? null : waRemark.trim();
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        if(waDate != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                this.intime = sdf.format(intime);
            } catch (Exception e) {
                this.intime = null;
            }
        }else{
            this.intime = null;
        }
    }
}