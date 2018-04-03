package com.erp.orm.entity;

import java.util.Date;

public class Department {
    private Integer dId;

    private String dName;

    private Byte dLevel;

    private Byte dState;

    private Float dIndex;

    private Date dIntime;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public Byte getdLevel() {
        return dLevel;
    }

    public void setdLevel(Byte dLevel) {
        this.dLevel = dLevel;
    }

    public Byte getdState() {
        return dState;
    }

    public void setdState(Byte dState) {
        this.dState = dState;
    }

    public Float getdIndex() {
        return dIndex;
    }

    public void setdIndex(Float dIndex) {
        this.dIndex = dIndex;
    }

    public Date getdIntime() {
        return dIntime;
    }

    public void setdIntime(Date dIntime) {
        this.dIntime = dIntime;
    }
}