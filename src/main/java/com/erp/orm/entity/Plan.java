package com.erp.orm.entity;

import java.util.Date;

public class Plan {
    private Integer pId;

    private Date pInitime;

    private String oId;

    private String pRid;

    private String pCreator;

    private String pCid;

    private Byte pState;

    private String pMemo;

    private Date pChktime;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Date getpInitime() {
        return pInitime;
    }

    public void setpInitime(Date pInitime) {
        this.pInitime = pInitime;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId == null ? null : oId.trim();
    }

    public String getpRid() {
        return pRid;
    }

    public void setpRid(String pRid) {
        this.pRid = pRid == null ? null : pRid.trim();
    }

    public String getpCreator() {
        return pCreator;
    }

    public void setpCreator(String pCreator) {
        this.pCreator = pCreator == null ? null : pCreator.trim();
    }

    public String getpCid() {
        return pCid;
    }

    public void setpCid(String pCid) {
        this.pCid = pCid == null ? null : pCid.trim();
    }

    public Byte getpState() {
        return pState;
    }

    public void setpState(Byte pState) {
        this.pState = pState;
    }

    public String getpMemo() {
        return pMemo;
    }

    public void setpMemo(String pMemo) {
        this.pMemo = pMemo == null ? null : pMemo.trim();
    }

    public Date getpChktime() {
        return pChktime;
    }

    public void setpChktime(Date pChktime) {
        this.pChktime = pChktime;
    }
}