package com.erp.orm.entity;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.erp.model.JsonWholesaleApplyDetail;

/**
 * 批发销售申请单明细
 */
public class WholesaleApplyDetail {
    /**
     *
     */
    private Integer wadId;
    /**
     * 批发申请单ID
     */
    private String waId;
    /**
     * 商品ID
     */
    private String wId;
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
     * 售价
     */
    private Float wdSaleprice = 0f;
    /**
     * 进价
     */
    private Float wdCostprice = 0f;
    /**
     * 申请数量
     */
    private Float wadApplyAmount = 0f;
    /**
     * 申请批发价
     */
    private Float wadApplyPrice = 0f;
    /**
     * 批准数量
     */
    private Float wadAmount = 0f;
    /**
     * 批准批发价
     */
    private Float wadPrice = 0f;
    /**
     * 金额
     */
    private Float wadMoney = 0f;
    /**
     * 序号
     */
    private Integer wadIndex;
    /**
     * 记录时间
     */
    private Date intime;

    public WholesaleApplyDetail(){

    }
    public WholesaleApplyDetail(JsonWholesaleApplyDetail jwad){
        //商品ID
        this.wId = jwad.getwId();
        //售价
        if(StringUtils.isNotBlank(jwad.getWdSaleprice())){
            this.wdSaleprice= Float.parseFloat(jwad.getWdSaleprice());
        }
        //进价
        if(StringUtils.isNotBlank(jwad.getWdCostprice())){
            this.wdCostprice= Float.parseFloat(jwad.getWdCostprice());
        }
        //申请数量
        if(StringUtils.isNotBlank(jwad.getWadApplyAmount())){
            this.wadApplyAmount= Float.parseFloat(jwad.getWadApplyAmount());
        }
        //申请批发价
        if(StringUtils.isNotBlank(jwad.getWadApplyPrice())){
            this.wadApplyPrice= Float.parseFloat(jwad.getWadApplyPrice());
        }
        //批准数量
        if(StringUtils.isNotBlank(jwad.getWadAmount())){
            this.wadAmount= Float.parseFloat(jwad.getWadAmount());
        }
        //批准批发价
        if(StringUtils.isNotBlank(jwad.getWadPrice())){
            this.wadPrice= Float.parseFloat(jwad.getWadPrice());
        }
        //金额
        if(StringUtils.isNotBlank(jwad.getWadMoney())){
            this.wadMoney= Float.parseFloat(jwad.getWadMoney());
        }
        //序号
        if(StringUtils.isNotBlank(jwad.getWadIndex())){
            this.wadIndex=Integer.parseInt(jwad.getWadIndex());
        }
    }

    public Integer getWadId() {
        return wadId;
    }

    public void setWadId(Integer wadId) {
        this.wadId = wadId;
    }

    public String getWaId() {
        return waId;
    }

    public void setWaId(String waId) {
        this.waId = waId == null ? null : waId.trim();
    }

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId == null ? null : wId.trim();
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

    public Float getWdSaleprice() {
        return wdSaleprice;
    }

    public void setWdSaleprice(Float wdSaleprice) {
        this.wdSaleprice = wdSaleprice;
    }

    public Float getWdCostprice() {
        return wdCostprice;
    }

    public void setWdCostprice(Float wdCostprice) {
        this.wdCostprice = wdCostprice;
    }

    public Float getWadApplyAmount() {
        return wadApplyAmount;
    }

    public void setWadApplyAmount(Float wadApplyAmount) {
        this.wadApplyAmount = wadApplyAmount;
    }

    public Float getWadApplyPrice() {
        return wadApplyPrice;
    }

    public void setWadApplyPrice(Float wadApplyPrice) {
        this.wadApplyPrice = wadApplyPrice;
    }

    public Float getWadAmount() {
        return wadAmount;
    }

    public void setWadAmount(Float wadAmount) {
        this.wadAmount = wadAmount;
    }

    public Float getWadPrice() {
        return wadPrice;
    }

    public void setWadPrice(Float wadPrice) {
        this.wadPrice = wadPrice;
    }

    public Float getWadMoney() {
        return wadMoney;
    }

    public void setWadMoney(Float wadMoney) {
        this.wadMoney = wadMoney;
    }

    public Integer getWadIndex() {
        return wadIndex;
    }

    public void setWadIndex(Integer wadIndex) {
        this.wadIndex = wadIndex;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }
}