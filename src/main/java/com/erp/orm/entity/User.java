package com.erp.orm.entity;

import java.util.Date;

/**
 * 用户
 * @author scy
 *
 */
public class User {
    private Integer uId;

    private String uName;

    private String uPassword;

    private Integer oId;

    private String uMobile;

    private String uIdcard;

    private Byte uState;

    private Date uIntime;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getuMobile() {
        return uMobile;
    }

    public void setuMobile(String uMobile) {
        this.uMobile = uMobile == null ? null : uMobile.trim();
    }

    public String getuIdcard() {
        return uIdcard;
    }

    public void setuIdcard(String uIdcard) {
        this.uIdcard = uIdcard == null ? null : uIdcard.trim();
    }

    public Byte getuState() {
        return uState;
    }

    public void setuState(Byte uState) {
        this.uState = uState;
    }

    public Date getuIntime() {
        return uIntime;
    }

    public void setuIntime(Date uIntime) {
        this.uIntime = uIntime;
    }
}