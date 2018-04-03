package com.erp.orm.entity;

import java.util.Date;

public class ApproveHistory {
    private Integer ahId;

    private Integer mId;

    private String rId;

    private Integer eId;

    private Byte ahState;

    private String ahRemark;

    private Date ahIntime;

    public ApproveHistory(){

    }

    public ApproveHistory(Integer mId,String rId,Integer eId,Byte ahState,String ahRemark){
        this.mId = mId;
        this.rId = rId;
        this.eId = eId;
        this.ahState = ahState;
        this.ahRemark = ahRemark;
    }

    public Integer getAhId() {
        return ahId;
    }

    public void setAhId(Integer ahId) {
        this.ahId = ahId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Byte getAhState() {
        return ahState;
    }

    public void setAhState(Byte ahState) {
        this.ahState = ahState;
    }

    public String getAhRemark() {
        return ahRemark;
    }

    public void setAhRemark(String ahRemark) {
        this.ahRemark = ahRemark == null ? null : ahRemark.trim();
    }

    public Date getAhIntime() {
        return ahIntime;
    }

    public void setAhIntime(Date ahIntime) {
        this.ahIntime = ahIntime;
    }
}