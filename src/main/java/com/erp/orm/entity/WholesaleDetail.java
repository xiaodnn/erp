package com.erp.orm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.erp.model.JsonWholesaleDetail;

/**
 * 批发销售单明细
 */
public class WholesaleDetail {
    /**
     * 批发销售单明细ID
     */
    private Integer wsdId;
    /**
     * 批发单ID
     */
    private Integer wsId;
    /**
     * 商品ID
     */
    private Integer wId;
    /**
     * 商品名称
     */
    private String wTraname;
    /**
     * 商品规格
     */
    private String wStandard;
    /**
     * 单位
     */
    private String wUnit;
    /**
     * 生产厂家
     */
    private String wBusiness;
    /**
     * 产地
     */
    private String wPlace;
    /**
     * 批发价
     */
    private Float wsdPrice = 0f;
    /**
     * 批号
     */
    private String batchNo;
    /**
     * 效期
     */
    private String validDate;
    /**
     * 货位
     */
    private String spCode;
    /**
     * 数量
     */
    private Float wsdAmount = 0f;
    /**
     * 金额
     */
    private Float wsdMoney = 0f;
    /**
     * 批次
     */
    private Integer sbId;
    /**
     * 生产日期
     */
    private String produceDate;
    /**
     * 序号
     */
    private Integer wsdIndex;
    /**
     * 记录时间
     */
    private Date intime;
    /**
     * 库存主表主键ID
     */
    private Integer sId;
    /**
     * 库存明细表主键ID
     */
    private Integer sdId;

    public WholesaleDetail(){}

    public WholesaleDetail(JsonWholesaleDetail jwd){
        //商品ID
        if(StringUtils.isNotBlank(jwd.getwId())){
            this.wId = Integer.parseInt(jwd.getwId());
        }
        //批发价
        if(StringUtils.isNotBlank(jwd.getWsdPrice())){
            this.wsdPrice= Float.parseFloat(jwd.getWsdPrice());
        }
        //数量
        if(StringUtils.isNotBlank(jwd.getWsdAmount())){
            this.wsdAmount= Float.parseFloat(jwd.getWsdAmount());
        }
        //金额
        if(StringUtils.isNotBlank(jwd.getWsdMoney())){
            this.wsdMoney= Float.parseFloat(jwd.getWsdMoney());
        }
        //批次
        if(StringUtils.isNotBlank(jwd.getSbId())){
            this.sbId=	 Integer.parseInt(jwd.getSbId());
        }
        //序号
        if(StringUtils.isNotBlank(jwd.getWsdIndex())){
            this.wsdIndex = Integer.parseInt(jwd.getWsdIndex());
        }
        this.batchNo = jwd.getBatchNo();

        if(StringUtils.isNotBlank(jwd.getValidDate())){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            this.validDate =sdf.format(jwd.getValidDate());
        }else{
            this.validDate = "";
        }

        this.spCode =jwd.getSpCode();

        if(StringUtils.isNotBlank(jwd.getValidDate())){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            this.produceDate =sdf.format(jwd.getProduceDate());
        }else{
            this.produceDate = "";
        }

        //库存主表主键ID
        if(StringUtils.isNotBlank(jwd.getsId())){
            this.sId = Integer.parseInt(jwd.getsId());
        }
        //库存明细表主键ID
        if(StringUtils.isNotBlank(jwd.getSdId())){
            this.sdId = Integer.parseInt(jwd.getSdId());
        }
    }


    public Integer getWsdId() {
        return wsdId;
    }

    public void setWsdId(Integer wsdId) {
        this.wsdId = wsdId;
    }

    public Integer getWsId() {
        return wsId;
    }

    public void setWsId(Integer wsId) {
        this.wsId = wsId ;
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
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

	public String getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
    	if(validDate != null){
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    		this.validDate =sdf.format(validDate);
        }else{
        	this.validDate = "";
        }
    }

    public String getSpCode() {
        return spCode;
    }

    public void setSpCode(String spCode) {
        this.spCode = spCode;
    }

    public Float getWsdAmount() {
        return wsdAmount;
    }

    public void setWsdAmount(Float wsdAmount) {
        this.wsdAmount = wsdAmount;
    }

    public Float getWsdMoney() {
        return wsdMoney;
    }

    public void setWsdMoney(Float wsdMoney) {
        this.wsdMoney = wsdMoney;
    }

    public String getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        if(produceDate != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            this.produceDate =sdf.format(produceDate);
        }else{
            this.produceDate = "";
        }
    }

    public Float getWsdPrice() {
        return wsdPrice;
    }

    public void setWsdPrice(Float wsdPrice) {
        this.wsdPrice = wsdPrice;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public Integer getWsdIndex() {
        return wsdIndex;
    }

    public void setWsdIndex(Integer wsdIndex) {
        this.wsdIndex = wsdIndex;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Integer getSdId() {
        return sdId;
    }

    public void setSdId(Integer sdId) {
        this.sdId = sdId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }
}