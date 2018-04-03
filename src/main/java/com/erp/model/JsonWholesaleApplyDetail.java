package com.erp.model;

/**
 * 采购入库单 Json 格式
 */
public class JsonWholesaleApplyDetail {
    /**
     *商品ID
     */
    private String wId;//
    /**
     *商品名称
     */
    private String wTraname;//
    /**
     *商品规格
     */
    private String wStandard;//
    /**
     *单位
     */
    private String wUnit;//
    /**
     *生产厂家
     */
    private String wBusiness;//
    /**
     *产地
     */
    private String wPlace;//
    /**
     *售价
     */
    private String wdSaleprice;//
    /**
     *进价
     */
    private String wdCostprice;//
    /**
     *申请数量
     */
    private String wadApplyAmount;//
    /**
     * 批发价
     */
    private String wadApplyPrice;//
    /**
     *批准数量
     */
    private String wadAmount;//
    /**
     * 批准批发价
     */
    private String wadPrice;//
    /**
     * 金额
     */
    private String wadMoney;//
    /**
     * 序号
     */
    private String wadIndex;//

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId;
    }

    public String getwTraname() {
        return wTraname;
    }

    public void setwTraname(String wTraname) {
        this.wTraname = wTraname;
    }

    public String getwStandard() {
        return wStandard;
    }

    public void setwStandard(String wStandard) {
        this.wStandard = wStandard;
    }

    public String getwUnit() {
        return wUnit;
    }

    public void setwUnit(String wUnit) {
        this.wUnit = wUnit;
    }

    public String getwBusiness() {
        return wBusiness;
    }

    public void setwBusiness(String wBusiness) {
        this.wBusiness = wBusiness;
    }

    public String getwPlace() {
        return wPlace;
    }

    public void setwPlace(String wPlace) {
        this.wPlace = wPlace;
    }

    public String getWdSaleprice() {
        return wdSaleprice;
    }

    public void setWdSaleprice(String wdSaleprice) {
        this.wdSaleprice = wdSaleprice;
    }

    public String getWdCostprice() {
        return wdCostprice;
    }

    public void setWdCostprice(String wdCostprice) {
        this.wdCostprice = wdCostprice;
    }

    public String getWadApplyAmount() {
        return wadApplyAmount;
    }

    public void setWadApplyAmount(String wadApplyAmount) {
        this.wadApplyAmount = wadApplyAmount;
    }

    public String getWadApplyPrice() {
        return wadApplyPrice;
    }

    public void setWadApplyPrice(String wadApplyPrice) {
        this.wadApplyPrice = wadApplyPrice;
    }

    public String getWadAmount() {
        return wadAmount;
    }

    public void setWadAmount(String wadAmount) {
        this.wadAmount = wadAmount;
    }

    public String getWadPrice() {
        return wadPrice;
    }

    public void setWadPrice(String wadPrice) {
        this.wadPrice = wadPrice;
    }

    public String getWadMoney() {
        return wadMoney;
    }

    public void setWadMoney(String wadMoney) {
        this.wadMoney = wadMoney;
    }

    public String getWadIndex() {
        return wadIndex;
    }

    public void setWadIndex(String wadIndex) {
        this.wadIndex = wadIndex;
    }
}
