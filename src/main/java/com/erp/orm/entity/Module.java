package com.erp.orm.entity;

import java.util.Date;

public class Module {
    private Integer mId;

    private String mName;

    private String mNikename;

    private String mUrl;

    private Byte mState;

    private Date mIntime;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public String getmNikename() {
        return mNikename;
    }

    public void setmNikename(String mNikename) {
        this.mNikename = mNikename == null ? null : mNikename.trim();
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public Byte getmState() {
        return mState;
    }

    public void setmState(Byte mState) {
        this.mState = mState;
    }

    public Date getmIntime() {
        return mIntime;
    }

    public void setmIntime(Date mIntime) {
        this.mIntime = mIntime;
    }
}