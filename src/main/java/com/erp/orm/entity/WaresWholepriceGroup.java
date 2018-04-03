package com.erp.orm.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品批发价格组
 * @author xiao
 *
 */
public class WaresWholepriceGroup {
	
	/**
	 * 批发价格组ID
	 */
    private Integer wpgId;
    /**
     * 商品ID
     */
    private Integer wId;
	/**
	 * 批发价
	 */
    private BigDecimal wWholeprice;
    /**
     * 用户ID
     */
    private Integer uId;
    /**
     * 创建时间
     */
    private Date intime;
    /**
     * 商品基础信息
     */
    private WaresBase waresBase;
    /**
     * 用户信息
     */
    private User user;

    public Integer getWpgId() {
		return wpgId;
	}

	public void setWpgId(Integer wpgId) {
		this.wpgId = wpgId;
	}

	public Integer getwId() {
		return wId;
	}

	public void setwId(Integer wId) {
		this.wId = wId;
	}

	public BigDecimal getwWholeprice() {
        return wWholeprice;
    }

    public void setwWholeprice(BigDecimal wWholeprice) {
        this.wWholeprice = wWholeprice;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

	public WaresBase getWaresBase() {
		return waresBase;
	}

	public void setWaresBase(WaresBase waresBase) {
		this.waresBase = waresBase;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}