package com.erp.model;

/**
 * 批发销售单明细单 Json 格式
 */
public class JsonWholesaleDetail {
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
     *批发价
     */
    private String wsdPrice;//
    /**
     * 批号
     */
    private String batchNo;
    /**
     *效期
     */
    private String validDate;
    /**
     *货位
     */
    private String spCode;
    /**
     *申请数量
     */
    private String wsdAmount;
    /**
     *金额
     */
    private String wsdMoney;
    /**
     *批次
     */
    private String sbId;
    /**
     *生产日期
     */
    private String produceDate;
    /**
     * 序号
     */
    private String wsdIndex;
    /**
     * 库存主表主键ID
     */
    private String sId;
    /**
     * 库存明细表主键ID
     */
    private String sdId;

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

    public String getWsdPrice() {
        return wsdPrice;
    }

    public void setWsdPrice(String wsdPrice) {
        this.wsdPrice = wsdPrice;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getSpCode() {
        return spCode;
    }

    public void setSpCode(String spCode) {
        this.spCode = spCode;
    }

    public String getWsdAmount() {
        return wsdAmount;
    }

    public void setWsdAmount(String wsdAmount) {
        this.wsdAmount = wsdAmount;
    }

    public String getWsdMoney() {
        return wsdMoney;
    }

    public void setWsdMoney(String wsdMoney) {
        this.wsdMoney = wsdMoney;
    }

    public String getSbId() {
        return sbId;
    }

    public void setSbId(String sbId) {
        this.sbId = sbId;
    }

    public String getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate;
    }

    public String getWsdIndex() {
        return wsdIndex;
    }

    public void setWsdIndex(String wsdIndex) {
        this.wsdIndex = wsdIndex;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getSdId() {
        return sdId;
    }

    public void setSdId(String sdId) {
        this.sdId = sdId;
    }
}
