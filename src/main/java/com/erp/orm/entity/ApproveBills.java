package com.erp.orm.entity;

/**
 * 需要审核的单据
 */
public class ApproveBills {
    private Integer mId;//单据类型模块
    private String rId;//单据ID
    private String mName;//类型模块名称
    private String mUrl;//模块URL


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
        this.rId = rId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
