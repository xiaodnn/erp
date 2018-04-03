package com.erp.orm.entity;

import java.math.BigDecimal;

/**
 * 商品零售价格组
 * @author xiao
 *
 */
public class WaresSalepriceGroup {
	/**
	 * 零售价格组ID
	 */
    private Integer spgId;
    /**
     * 商品ID
     */
    private Integer wId;
	/**
	 * 零售价
	 */
    private BigDecimal wSaleprice;
    /**
	 * 会员价
	 */
    private BigDecimal wVipprice;
    /**
	 * 促销价
	 */
    private BigDecimal wPromoprice;
    /**
	 * 会员促销价
	 */
    private BigDecimal wVippromoprice;
    /**
	 * 促销状态
	 */
    private Integer wStatus;
    /**
	 * 促销开始日期
	 */
    private String wBegindate;
    /**
	 * 促销结束日期
	 */
    private String wEnddate;
    /**
	 * 用户ID
	 */
    private Integer uId;
    /**
	 * 创建时间
	 */
    private String intime;
    /**
     * 商品基础信息
     */
    private WaresBase waresBase;
    /**
     * 用户信息
     */
    private User user;

    
    public Integer getSpgId() {
		return spgId;
	}

	public void setSpgId(Integer spgId) {
		this.spgId = spgId;
	}

	public Integer getwId() {
		return wId;
	}

	public void setwId(Integer wId) {
		this.wId = wId;
	}

	public BigDecimal getwSaleprice() {
        return wSaleprice;
    }

    public void setwSaleprice(BigDecimal wSaleprice) {
        this.wSaleprice = wSaleprice;
    }

    public BigDecimal getwVipprice() {
        return wVipprice;
    }

    public void setwVipprice(BigDecimal wVipprice) {
        this.wVipprice = wVipprice;
    }

    public BigDecimal getwPromoprice() {
        return wPromoprice;
    }

    public void setwPromoprice(BigDecimal wPromoprice) {
        this.wPromoprice = wPromoprice;
    }

    public BigDecimal getwVippromoprice() {
        return wVippromoprice;
    }

    public void setwVippromoprice(BigDecimal wVippromoprice) {
        this.wVippromoprice = wVippromoprice;
    }

    public Integer getwStatus() {
        return wStatus;
    }

    public void setwStatus(Integer wStatus) {
        this.wStatus = wStatus;
    }

    public String getwBegindate() {
        return wBegindate;
    }

    public void setwBegindate(String wBegindate) {
        this.wBegindate = wBegindate;
    }

    public String getwEnddate() {
        return wEnddate;
    }

    public void setwEnddate(String wEnddate) {
        this.wEnddate = wEnddate;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
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