package com.erp.orm.entity;

import java.util.Date;

/**
 * 用户和模块映射
 */
public class MapUserModule {
    /**
     * 主键自增ID
     */
    private Integer mumId;
    /**
     * 用户ID
     */
    private Integer uId;
    /**
     * 模块ID
     */
    private Integer mId;
    /**
     * 状态
     */
    private Byte mumState;
    /**
     * 创建时间
     */
    private Date mumIntime;

    public Integer getMumId() {
        return mumId;
    }

    public void setMumId(Integer mumId) {
        this.mumId = mumId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Byte getMumState() {
        return mumState;
    }

    public void setMumState(Byte mumState) {
        this.mumState = mumState;
    }

    public Date getMumIntime() {
        return mumIntime;
    }

    public void setMumIntime(Date mumIntime) {
        this.mumIntime = mumIntime;
    }
}