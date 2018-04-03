package com.erp.orm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 机构信息
 */
public class Organ {
    /**
     * 主键ID
     */
    private Integer oId;
    /**
     * 机构编码
     */
    private String oCode;
    /**
     * 机构名称
     */
    private String oName;
    /**
     * 地址
     */
    private String oAddress;
    /**
     * 状态
     */
    private Byte oState;
    /**
     * 负责人
     */
    private String oManager;
    /**
     * 零售价格组
     */
    private String oSaleprice;
    /**
     * 批发价格组
     */
    private String oSellprice;
    /**
     * 创建人
     */
    private String oCreator;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date oIntime;

    private Integer recodecount;

    public Integer getRecodecount() {
        return recodecount;
    }

    public void setRecodecount(Integer recodecount) {
        this.recodecount = recodecount;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getoCode() {
        return oCode;
    }

    public void setoCode(String oCode) {
        this.oCode = oCode == null ? null : oCode.trim();
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName == null ? null : oName.trim();
    }

    public String getoAddress() {
        return oAddress;
    }

    public void setoAddress(String oAddress) {
        this.oAddress = oAddress == null ? null : oAddress.trim();
    }

    public Byte getoState() {
        return oState;
    }

    public void setoState(Byte oState) {
        this.oState = oState;
    }

    public Date getoIntime() {
        return oIntime;
    }

    public void setoIntime(Date oIntime) {
        this.oIntime = oIntime;
    }

    public String getoCreator() {
        return oCreator;
    }

    public void setoCreator(String oCreator) {
        this.oCreator = oCreator == null ? null : oCreator.trim();
    }

    public String getoManager() {
        return oManager;
    }

    public void setoManager(String oManager) {
        this.oManager = oManager == null ? null : oManager.trim();
    }

    public String getoSaleprice() {
        return oSaleprice;
    }

    public void setoSaleprice(String oSaleprice) {
        this.oSaleprice = oSaleprice == null ? null : oSaleprice.trim();
    }

    public String getoSellprice() {
        return oSellprice;
    }

    public void setoSellprice(String oSellprice) {
        this.oSellprice = oSellprice == null ? null : oSellprice.trim();
    }
}