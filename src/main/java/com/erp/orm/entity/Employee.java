package com.erp.orm.entity;

import java.util.Date;

public class Employee {
    private Integer eId;

    private String eName;

    private String eOid;

    private String eMobile;

    private String eBirthday;

    private String eSex;

    private String eIdcard;

    private Byte eState;

    private String eAddress;

    private Date eIntime;

    private Integer uId;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public String geteOid() {
        return eOid;
    }

    public void seteOid(String eOid) {
        this.eOid = eOid == null ? null : eOid.trim();
    }

    public String geteMobile() {
        return eMobile;
    }

    public void seteMobile(String eMobile) {
        this.eMobile = eMobile == null ? null : eMobile.trim();
    }

    public String geteBirthday() {
        return eBirthday;
    }

    public void seteBirthday(String eBirthday) {
        this.eBirthday = eBirthday == null ? null : eBirthday.trim();
    }

    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex == null ? null : eSex.trim();
    }

    public String geteIdcard() {
        return eIdcard;
    }

    public void seteIdcard(String eIdcard) {
        this.eIdcard = eIdcard == null ? null : eIdcard.trim();
    }

    public Byte geteState() {
        return eState;
    }

    public void seteState(Byte eState) {
        this.eState = eState;
    }

    public String geteAddress() {
        return eAddress;
    }

    public void seteAddress(String eAddress) {
        this.eAddress = eAddress == null ? null : eAddress.trim();
    }

    public Date geteIntime() {
        return eIntime;
    }

    public void seteIntime(Date eIntime) {
        this.eIntime = eIntime;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
}