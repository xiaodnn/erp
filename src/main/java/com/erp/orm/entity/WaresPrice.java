package com.erp.orm.entity;

import java.util.Date;

/**
 * 商品价格信息
 *
 *
 * @author scy
 * @date 2017年1月1日
 */
public class WaresPrice {
    /**
     * 商品ID
     */
    private String wId;
    /**
     * 成本价
     */
    private Float wCostprice = 0f;
    /**
     * 零售价
     */
    private Float wSaleprice = 0f;
    /**
     * 会员价
     */
    private Float wVipprice = 0f;
    /**
     * 批发价
     */
    private Float wSellprice = 0f;
    /**
     * 拆零零售价
     */
    private Float wMinSaleprice = 0f;
    /**
     * 拆零会员价
     */
    private Float wMinVipprice = 0f;
    /**
     * 拆零批发价
     */
    private Float wMinSellprice = 0f;
    /**
     * 国家标准零售价
     */
    private Float wStandardSaleprice = 0f;
    /**
     * 国家标准批发价
     */
    private Float wStandardSellprice = 0f;

    private Date intime;

    private Integer count = 0;

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId == null ? null : wId.trim();
    }

    public Float getwCostprice() {
        return wCostprice;
    }

    public void setwCostprice(Float wCostprice) {
        this.wCostprice = wCostprice;
    }

    public Float getwSaleprice() {
        return wSaleprice;
    }

    public void setwSaleprice(Float wSaleprice) {
        this.wSaleprice = wSaleprice;
    }

    public Float getwVipprice() {
        return wVipprice;
    }

    public void setwVipprice(Float wVipprice) {
        this.wVipprice = wVipprice;
    }

    public Float getwSellprice() {
        return wSellprice;
    }

    public void setwSellprice(Float wSellprice) {
        this.wSellprice = wSellprice;
    }

    public Float getwMinSaleprice() {
        return wMinSaleprice;
    }

    public void setwMinSaleprice(Float wMinSaleprice) {
        this.wMinSaleprice = wMinSaleprice;
    }

    public Float getwMinVipprice() {
        return wMinVipprice;
    }

    public void setwMinVipprice(Float wMinVipprice) {
        this.wMinVipprice = wMinVipprice;
    }

    public Float getwMinSellprice() {
        return wMinSellprice;
    }

    public void setwMinSellprice(Float wMinSellprice) {
        this.wMinSellprice = wMinSellprice;
    }

    public Float getwStandardSaleprice() {
        return wStandardSaleprice;
    }

    public void setwStandardSaleprice(Float wStandardSaleprice) {
        this.wStandardSaleprice = wStandardSaleprice;
    }

    public Float getwStandardSellprice() {
        return wStandardSellprice;
    }

    public void setwStandardSellprice(Float wStandardSellprice) {
        this.wStandardSellprice = wStandardSellprice;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}