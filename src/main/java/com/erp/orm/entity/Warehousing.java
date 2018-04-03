package com.erp.orm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 入库信息
 *
 *
 * @author scy
 * @date 2017年1月2日
 */
public class Warehousing {
	/**
	 * 入库单号
	 */
    private String whId;
    /**
	 * 制单时间(默认系统时间)
	 */
    private Date whInitime;
    /**
	 * 入库机构
	 */
    private String oId;
    /**
	 * 入库仓库
	 */
    private String shId;
    /**
	 * 经手人
	 */
    private String whCreator;
    /**
	 * 供应商ID
	 */
    private String cId;
    /**0:无效,1:正常,2:审核中,3:审核完成,4:驳回,5:撤销,6:作废
	 * 审核状态(0:未审核,1:审核中,2:通过,3:未通过,4:作废)
	 */
    private Byte whState;

    private String stateName;
    /**
	 * 备注
	 */
    private String whMemo;
    /**
	 * 审核时间(默认系统时间)
	 */
    private Date whChtime;
    /**
	 * 入库明细信息
	 */
    private List<WarehousingDetail> warehousingDetails;
    
    public String getWhId() {
        return whId;
    }

    public void setWhId(String whId) {
        this.whId = whId == null ? null : whId.trim();
    }

    public Date  getWhInitime() {
//        if(whInitime != null){
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            try {
//                String date = sdf.format(whInitime);
//                this.whInitime = sdf.parse(date);
//            } catch (ParseException e) {
//                this.whInitime = null;
//            }
//        }
        return whInitime;
    }

    public void setWhInitime(String whInitime) {
        if(StringUtils.isNotBlank(whInitime)){
//        if(whInitime != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                this.whInitime = sdf.parse(whInitime);
//                this.whInitime = sdf.format(whInitime);
            } catch (Exception e) {
                this.whInitime = null;
            }
        }else{
            this.whInitime = null;
        }
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getShId() {
        return shId;
    }

    public void setShId(String shId) {
        this.shId = shId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getWhCreator() {
        return whCreator;
    }

    public void setWhCreator(String whCreator) {
        this.whCreator = whCreator == null ? null : whCreator.trim();
    }

    public Byte getWhState() {
        return whState;
    }

    public void setWhState(Byte whState) {
        this.whState = whState;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getWhMemo() {
        return whMemo;
    }

    public void setWhMemo(String whMemo) {
        this.whMemo = whMemo == null ? null : whMemo.trim();
    }

    public Date getWhChtime() {
//        if(whChtime != null){
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            try {
//                String date = sdf.format(whChtime);
//                this.whChtime = sdf.parse(date);
//            } catch (ParseException e) {
//                this.whChtime = null;
//            }
//        }
        return whChtime;
    }

    public void setWhChtime(String whChtime) {
        if(StringUtils.isNotBlank(whChtime)){
//        if(whChtime != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                this.whChtime = sdf.parse(whChtime);
//                this.whChtime = sdf.format(whChtime);
            } catch (Exception e) {
                this.whChtime = null;
            }
        }else{
            this.whChtime = null;
        }
    }

	/**
	 * @return the warehousingDetails
	 */
	public List<WarehousingDetail> getWarehousingDetails() {
		return warehousingDetails;
	}

	/**
	 * @param warehousingDetails the warehousingDetails to set
	 */
	public void setWarehousingDetails(List<WarehousingDetail> warehousingDetails) {
		this.warehousingDetails = warehousingDetails;
	}
    
}