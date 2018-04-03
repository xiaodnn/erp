package com.erp.orm.entity;

import java.util.Date;

public class MenuSub {
    private Integer msId;

    private String msName;

    private Integer mId;

    private String msState;

    private String msUrl;
    
    private String msUrlname;

    private Date msIntime;

    private String msCreator;

    private Float msIndex;

    public Integer getMsId() {
        return msId;
    }

    public void setMsId(Integer msId) {
        this.msId = msId;
    }

    public String getMsName() {
        return msName;
    }

    public void setMsName(String msName) {
        this.msName = msName == null ? "": msName.trim();
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getMsState() {
        return msState;
    }

    public void setMsState(String msState) {
        this.msState = msState == null ? "": msState.trim();
    }

    public String getMsUrl() {
        return msUrl;
    }

    public void setMsUrl(String msUrl) {
        this.msUrl = msUrl == null ? "": msUrl.trim();
    }

    /**
	 * @return the msUrlname
	 */
	public String getMsUrlname() {
		return msUrlname;
	}

	/**
	 * @param msUrlname the msUrlname to set
	 */
	public void setMsUrlname(String msUrlname) {
		this.msUrlname = msUrlname;
	}

	public Date getMsIntime() {
        return msIntime;
    }

    public void setMsIntime(Date msIntime) {
        this.msIntime = msIntime;
    }

    public String getMsCreator() {
        return msCreator;
    }

    public void setMsCreator(String msCreator) {
        this.msCreator = msCreator == null ? "": msCreator.trim();
    }

    public Float getMsIndex() {
        return msIndex;
    }

    public void setMsIndex(Float msIndex) {
        this.msIndex = msIndex;
    }
}