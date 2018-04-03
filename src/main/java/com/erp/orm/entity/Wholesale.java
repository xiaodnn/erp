package com.erp.orm.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 批发销售单
 */
public class Wholesale{
    /**
     * 主键自增ID
     */
    private Integer wsId;
    /**
     * 批发申请单ID
     */
    private Integer waId;
    /**
     * 制单人
     */
    private String wsCreator;
    /**
     * 制单时间
     */
    private Date wsDate;
    /**
     * 客户ID
     */
    private Integer cbId;
    /**
     * 客户收货地址
     */
    private String cbStorehouse;
    /**
     * 提货方式
     */
    private String wsReceiveWay;
    /**
     * 付款方式
     */
    private String wsPayWay;
    /**
     * 发票类型
     */
    private String wsInvoiceType;
    /**
     * 价格组ID
     */
    private Integer pId;
    /**
     * 状态
     */
    private Byte wsState;
    /**
     * 出库仓库ID
     */
    private String shId;
    /**
     * 备注
     */
    private String wsRemark;
    /**
     * 记录时间
     */
    private Date intime;
    /**
     * 销售单明细
     */
    private List<WholesaleDetail> details = new ArrayList<WholesaleDetail>();

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
    
    public Integer getWsId() {
        return wsId;
    }

    public void setWsId(Integer wsId) {
        this.wsId = wsId;
    }

    public Integer getWaId() {
        return waId;
    }

    public void setWaId(Integer waId) {
        this.waId = waId;
    }

    public String getWsCreator() {
        return wsCreator;
    }

    public void setWsCreator(String wsCreator) {
        this.wsCreator = wsCreator == null ? null : wsCreator.trim();
    }

    public Date getWsDate() {
        return wsDate;
    }

    public void setWsDate(String wsDate) {
        if(StringUtils.isNotBlank(wsDate)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                this.wsDate =sdf.parse(wsDate);
            } catch (ParseException e) {
                this.wsDate = null;
            }
        }else{
            this.wsDate = null;
        }
    }

    public Integer getCbId() {
        return cbId;
    }

    public void setCbId(Integer cbId) {
        this.cbId = cbId;
    }

    public String getCbStorehouse() {
        return cbStorehouse;
    }

    public void setCbStorehouse(String cbStorehouse) {
        this.cbStorehouse = cbStorehouse == null ? null : cbStorehouse.trim();
    }

    public String getWsReceiveWay() {
        return wsReceiveWay;
    }

    public void setWsReceiveWay(String wsReceiveWay) {
        this.wsReceiveWay = wsReceiveWay == null ? null : wsReceiveWay.trim();
    }

    public String getWsPayWay() {
        return wsPayWay;
    }

    public void setWsPayWay(String wsPayWay) {
        this.wsPayWay = wsPayWay == null ? null : wsPayWay.trim();
    }

    public String getWsInvoiceType() {
        return wsInvoiceType;
    }

    public void setWsInvoiceType(String wsInvoiceType) {
        this.wsInvoiceType = wsInvoiceType == null ? null : wsInvoiceType.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Byte getWsState() {
        return wsState;
    }

    public void setWsState(Byte wsState) {
        this.wsState = wsState;
    }

    public String getShId() {
        return shId;
    }

    public void setShId(String shId) {
        this.shId = shId == null ? null : shId.trim();
    }

    public String getWsRemark() {
        return wsRemark;
    }

    public void setWsRemark(String wsRemark) {
        this.wsRemark = wsRemark == null ? null : wsRemark.trim();
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

	public List<WholesaleDetail> getDetails() {
		return details;
	}

	public void setDetails(List<WholesaleDetail> details) {
		this.details = details;
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
    
}