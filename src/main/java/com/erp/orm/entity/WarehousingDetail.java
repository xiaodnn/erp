package com.erp.orm.entity;

import com.erp.model.JsonWarehousingDetail;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 入库明细
 *
 *
 * @author scy
 * @date 2017年1月2日
 */
public class WarehousingDetail {
    /**
	 * 商品明细ID
	 */
    private Integer wdId;
    /**
	 * 入库单号
	 */
    private String whId;
    /**
	 * 商品ID
	 */
    private String wId;
    /**
     * 商品编号
     */
    private String wClassid;
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
     * 批准文号
     */
    private String wApprovalno;
    /**
     * 售价
     */
    private Float wdSaleprice = 0f;
    /**
     * 进价
     */
    private Float wdCostprice = 0f;
    /**
	 * 数量
	 */
    private Float wdAmount = 0f;
    /**
	 * 折扣(小数,九折:0.9)
	 */
    private Float wdDiscount = 0f;
    /**
	 * 折扣价
	 */
    private Float wdDiscPrice = 0f;
    /**
	 * 批号
	 */
    private String wdBatchNo;
    /**
	 * 有效期
	 */
    private Date wdIndate;
    /**
	 * 生产日期
	 */
    private Date wdDate;
    /**
	 * 货位
	 */
    private String wdAllocation;
    /**
	 * 序号
	 */
    private Integer wdIndex;
    /**
	 * 创建时间(默认系统时间)
	 */
    private Date wdInitime;


    public WarehousingDetail(){

    }
    public WarehousingDetail(JsonWarehousingDetail jwd){
        //售价
        if(StringUtils.isNotBlank(jwd.getWdSaleprice())){
            this.wdSaleprice= Float.parseFloat(jwd.getWdSaleprice());
        }
        //进价
        if(StringUtils.isNotBlank(jwd.getWdCostprice())){
            this.wdCostprice= Float.parseFloat(jwd.getWdCostprice());
        }
        //商品ID
        this.wId = jwd.getwId();

        //数量
        if(StringUtils.isNotBlank(jwd.getWdAmount())){
            this.wdAmount= Float.parseFloat(jwd.getWdAmount());
        }
        //折扣
        if(StringUtils.isNotBlank(jwd.getWdDiscount())){
            this.wdDiscount= Float.parseFloat(jwd.getWdDiscount());
        }
        //折扣价
        if(StringUtils.isNotBlank(jwd.getWdDiscPrice())){
            this.wdDiscPrice=	 Float.parseFloat(jwd.getWdDiscPrice());
        }
        //批号
        this.wdBatchNo= jwd.getWdBatchNo();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //有效期
        if(StringUtils.isNotBlank(jwd.getWdIndate())){
            try{
                this.wdIndate= sdf.parse(jwd.getWdIndate());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //生产日期
        if(StringUtils.isNotBlank(jwd.getWdDate())){
            try{
                this.wdDate=	sdf.parse(jwd.getWdDate());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //货位
        this.wdAllocation=	jwd.getWdAllocation();
        //序号
        if(StringUtils.isNotBlank(jwd.getWdIndex())){
            this.wdIndex=Integer.parseInt(jwd.getWdIndex());
        }
    }

    public Integer getWdId() {
        return wdId;
    }

    public void setWdId(Integer wdId) {
        this.wdId = wdId;
    }

    public String getWhId() {
        return whId;
    }

    public void setWhId(String whId) {
        this.whId = whId == null ? null : whId.trim();
    }

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId == null ? null : wId.trim();
    }

    public String getwClassid() {
        return wClassid;
    }

    public void setwClassid(String wClassid) {
        this.wClassid = wClassid;
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

    public String getwApprovalno() {
        return wApprovalno;
    }

    public void setwApprovalno(String wApprovalno) {
        this.wApprovalno = wApprovalno;
    }

    public Float getWdSaleprice() {
        return wdSaleprice;
    }

    public void setWdSaleprice(String wdSaleprice) {
        if(wdSaleprice == null || "".equals(wdSaleprice)){
            this.wdSaleprice = 0f;
        }else{
            this.wdSaleprice =Float.parseFloat(wdSaleprice);
        }
    }

    public Float getWdCostprice() {
        return wdCostprice;
    }

    public void setWdCostprice(String wdCostprice) {
        if(wdCostprice == null || "".equals(wdCostprice)){
            this.wdCostprice = 0f;
        }else{
            this.wdCostprice =Float.parseFloat(wdCostprice);
        }
    }

    public Float getWdAmount() {
        return wdAmount;
    }

    public void setWdAmount(String wdAmount) {
        if(wdAmount == null || "".equals(wdAmount)){
            this.wdAmount = 0f;
        }else{
            this.wdAmount =Float.parseFloat(wdAmount);
        }
    }

    public Float getWdDiscount() {
        return wdDiscount;
    }

    public void setWdDiscount(String wdDiscount) {
        if(wdDiscount == null || "".equals(wdDiscount)){
            this.wdDiscount = 0f;
        }else{
            this.wdDiscount =Float.parseFloat(wdDiscount);
        }
    }

    public Float getWdDiscPrice() {
        return wdDiscPrice;
    }

    public void setWdDiscPrice(String wdDiscPrice) {
        if(wdDiscPrice == null || "".equals(wdDiscPrice)){
            this.wdDiscPrice = 0f;
        }else{
            this.wdDiscPrice =Float.parseFloat(wdDiscPrice);
        }
    }

    public String getWdBatchNo() {
        return wdBatchNo;
    }

    public void setWdBatchNo(String wdBatchNo) {
        this.wdBatchNo = wdBatchNo == null ? null : wdBatchNo.trim();
    }

    public Date getWdIndate() {
        return wdIndate;
    }

    public void setWdIndate(String wdIndate) {
        if(wdIndate == null || "".equals(wdIndate)){
            this.wdIndate = null;
        }else{
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                this.wdIndate = sdf.parse(wdIndate);
            } catch (ParseException e) {
                this.wdIndate = null;
            }
        }
    }

    public Date getWdDate() {
        return wdDate;
    }

    public void setWdDate(String wdDate) {
        if(wdDate == null || "".equals(wdDate)){
            this.wdDate = null;
        }else{
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                this.wdDate = sdf.parse(wdDate);
            } catch (ParseException e) {
                this.wdDate = null;
            }
        }
    }

    public String getWdAllocation() {
        return wdAllocation;
    }

    public void setWdAllocation(String wdAllocation) {
        this.wdAllocation = wdAllocation == null ? null : wdAllocation.trim();
    }

    public Integer getWdIndex() {
        return wdIndex;
    }

    public void setWdIndex(String wdIndex) {
        if(wdIndex == null || "".equals(wdIndex)){
            this.wdIndex = 0;
        }else{
            this.wdIndex =Integer.parseInt(wdIndex);
        }
    }

    public Date getWdInitime() {
        return wdInitime;
    }

    public void setWdInitime(String wdInitime){
        if(wdInitime == null || "".equals(wdInitime)){
            this.wdInitime = null;
        }else{
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                this.wdInitime = sdf.parse(wdInitime);
            } catch (ParseException e) {
                this.wdInitime = null;
            }
        }
    }
}