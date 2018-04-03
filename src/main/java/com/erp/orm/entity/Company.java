package com.erp.orm.entity;

import java.util.Date;

/**
 * 供应商
 *
 *
 * @author scy
 * @date 2017年1月1日
 */
public class Company {
	/**
	 * 供应商编码
	 */
    private String cId;

    private String cName;

    private String cType;

    private String cPaytype;

    private String cManager;

    private String cZone;

    private String cAddress;

    private String cOrderName;

    private String cOrderTel;

    private String cOrderFax;

    private String cOrderMobile;

    private String cOrderEmail;

    private String cOrderUrl;

    private Byte cStatus;

    private String cBuyer;

    private String cBankId;

    private String cBankName;

    private String cMemo;

    private String cCreator;

    private Date cInitime;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }

    public String getcPaytype() {
        return cPaytype;
    }

    public void setcPaytype(String cPaytype) {
        this.cPaytype = cPaytype == null ? null : cPaytype.trim();
    }

    public String getcManager() {
        return cManager;
    }

    public void setcManager(String cManager) {
        this.cManager = cManager == null ? null : cManager.trim();
    }

    public String getcZone() {
        return cZone;
    }

    public void setcZone(String cZone) {
        this.cZone = cZone == null ? null : cZone.trim();
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress == null ? null : cAddress.trim();
    }

    public String getcOrderName() {
        return cOrderName;
    }

    public void setcOrderName(String cOrderName) {
        this.cOrderName = cOrderName == null ? null : cOrderName.trim();
    }

    public String getcOrderTel() {
        return cOrderTel;
    }

    public void setcOrderTel(String cOrderTel) {
        this.cOrderTel = cOrderTel == null ? null : cOrderTel.trim();
    }

    public String getcOrderFax() {
        return cOrderFax;
    }

    public void setcOrderFax(String cOrderFax) {
        this.cOrderFax = cOrderFax == null ? null : cOrderFax.trim();
    }

    public String getcOrderMobile() {
        return cOrderMobile;
    }

    public void setcOrderMobile(String cOrderMobile) {
        this.cOrderMobile = cOrderMobile == null ? null : cOrderMobile.trim();
    }

    public String getcOrderEmail() {
        return cOrderEmail;
    }

    public void setcOrderEmail(String cOrderEmail) {
        this.cOrderEmail = cOrderEmail == null ? null : cOrderEmail.trim();
    }

    public String getcOrderUrl() {
        return cOrderUrl;
    }

    public void setcOrderUrl(String cOrderUrl) {
        this.cOrderUrl = cOrderUrl == null ? null : cOrderUrl.trim();
    }

    public Byte getcStatus() {
        return cStatus;
    }

    public void setcStatus(Byte cStatus) {
        this.cStatus = cStatus;
    }

    public String getcBuyer() {
        return cBuyer;
    }

    public void setcBuyer(String cBuyer) {
        this.cBuyer = cBuyer == null ? null : cBuyer.trim();
    }

    public String getcBankId() {
        return cBankId;
    }

    public void setcBankId(String cBankId) {
        this.cBankId = cBankId == null ? null : cBankId.trim();
    }

    public String getcBankName() {
        return cBankName;
    }

    public void setcBankName(String cBankName) {
        this.cBankName = cBankName == null ? null : cBankName.trim();
    }

    public String getcMemo() {
        return cMemo;
    }

    public void setcMemo(String cMemo) {
        this.cMemo = cMemo == null ? null : cMemo.trim();
    }

    public String getcCreator() {
        return cCreator;
    }

    public void setcCreator(String cCreator) {
        this.cCreator = cCreator == null ? null : cCreator.trim();
    }

    public Date getcInitime() {
        return cInitime;
    }

    public void setcInitime(Date cInitime) {
        this.cInitime = cInitime;
    }
}