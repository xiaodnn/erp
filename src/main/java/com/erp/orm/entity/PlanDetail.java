package com.erp.orm.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PlanDetail {
    private Integer pdId;

    private Integer pId;

    private String pdWid;

    private BigDecimal pdPrice;

    private BigDecimal pdAmount;

    private String pdMemo;

    private Date pdInitime;

    public Integer getPdId() {
        return pdId;
    }

    public void setPdId(Integer pdId) {
        this.pdId = pdId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getPdWid() {
        return pdWid;
    }

    public void setPdWid(String pdWid) {
        this.pdWid = pdWid == null ? null : pdWid.trim();
    }

    public BigDecimal getPdPrice() {
        return pdPrice;
    }

    public void setPdPrice(BigDecimal pdPrice) {
        this.pdPrice = pdPrice;
    }

    public BigDecimal getPdAmount() {
        return pdAmount;
    }

    public void setPdAmount(BigDecimal pdAmount) {
        this.pdAmount = pdAmount;
    }

    public String getPdMemo() {
        return pdMemo;
    }

    public void setPdMemo(String pdMemo) {
        this.pdMemo = pdMemo == null ? null : pdMemo.trim();
    }

    public Date getPdInitime() {
        return pdInitime;
    }

    public void setPdInitime(Date pdInitime) {
        this.pdInitime = pdInitime;
    }
}