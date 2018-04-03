package com.erp.orm.entity;

import java.util.Date;

/**
 * 
 * 系统参数
 * ts_para
 * @author scy
 * @date 2016年12月6日
 */
public class Para {
    private Integer pId;

    private String pName;

    private Integer pMid;

    private Byte pState;

    private String pCreator;

    private Date pIntime;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Integer getpMid() {
        return pMid;
    }

    public void setpMid(Integer pMid) {
        this.pMid = pMid;
    }

    public Byte getpState() {
        return pState;
    }

    public void setpState(Byte pState) {
        this.pState = pState;
    }

    public String getpCreator() {
        return pCreator;
    }

    public void setpCreator(String pCreator) {
        this.pCreator = pCreator == null ? null : pCreator.trim();
    }

    public Date getpIntime() {
        return pIntime;
    }

    public void setpIntime(Date pIntime) {
        this.pIntime = pIntime;
    }
}