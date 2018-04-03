package com.erp.orm.entity;

import java.util.Date;

/**
 * 订单合同表实体类
 * 
 * @author xiao
 *
 */
public class Indent {
    private Integer iId;

    private Date iInitime;

    private Integer oId;

    private Integer shId;

    private String iCreator;

    private String cId;

    private Byte iState;

    private String iMemo;

    private Date iChktime;

    public Integer getiId() {
		return iId;
	}

	public void setiId(Integer iId) {
		this.iId = iId;
	}

	public Date getiInitime() {
        return iInitime;
    }

    public void setiInitime(Date iInitime) {
        this.iInitime = iInitime;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getShId() {
        return shId;
    }

    public void setShId(Integer shId) {
        this.shId = shId;
    }

    public String getiCreator() {
        return iCreator;
    }

    public void setiCreator(String iCreator) {
        this.iCreator = iCreator == null ? null : iCreator.trim();
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public Byte getiState() {
        return iState;
    }

    public void setiState(Byte iState) {
        this.iState = iState;
    }

    public String getiMemo() {
        return iMemo;
    }

    public void setiMemo(String iMemo) {
        this.iMemo = iMemo == null ? null : iMemo.trim();
    }

    public Date getiChktime() {
        return iChktime;
    }

    public void setiChktime(Date iChktime) {
        this.iChktime = iChktime;
    }
}