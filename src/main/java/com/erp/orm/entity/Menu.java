package com.erp.orm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * 功能菜单
 * tc_memu
 * @author scy
 * @date 2016年12月5日
 */
public class Menu {
    private Integer mId;

    private String mName;
    
    private String mState;

    private Double mIndex;

    private String mCreator;

    private Date mIntime;

    private List<MenuSub> menusub = new ArrayList<MenuSub>();
    
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
    
    public String getmState() {
        return mState;
    }

    public void setmState(String mState) {
        this.mState = mState == null ? null : mState.trim();
    }

    public Double getmIndex() {
        return mIndex;
    }

    public void setmIndex(Double mIndex) {
        this.mIndex = mIndex;
    }

    public String getmCreator() {
        return mCreator;
    }

    public void setmCreator(String mCreator) {
        this.mCreator = mCreator == null ? null : mCreator.trim();
    }

    public Date getmIntime() {
        return mIntime;
    }

    public void setmIntime(Date mIntime) {
        this.mIntime = mIntime;
    }

	/**
	 * @return the menusub
	 */
	public List<MenuSub> getMenusub() {
		return menusub;
	}

	/**
	 * @param menusub the menusub to set
	 */
	public void setMenusub(List<MenuSub> menusub) {
		this.menusub = menusub;
	}

}