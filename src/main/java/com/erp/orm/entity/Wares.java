package com.erp.orm.entity;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * 商品信息
 * tb_wares
 * @author scy
 * @date 2016年9月29日
 */
public class Wares {
	/**
	 * 商品编码 主键
	 */
	private String wId;
	/**
	 * 品类编码
	 */
	private String wClassid;
	/**
	 * 商品类型
	 */
	private String wType;
	/**
	 * 通用名
	 */
	private String wGenname;
	/**
	 * 商品名
	 */
	private String wTraname;
	/**
	 * 商品助记码
	 */
	private String wZjm;
	/**
	 * 商品条形码
	 */
	private String wBarcode;
	/**
	 * 批准文号
	 */
	private String wApprovalno;
	/**
	 * 商品单位
	 */
	private String wUnit;
	/**
	 * 商品规格
	 */
	private String wStandard;
	/**
	 * 生产企业
	 */
	private String wBusiness;
	/**
	 * 生产产地
	 */
	private String wPlace;
	/**
	 * 件装量
	 */
	private Float wMax = 0f;
	/**
	 * 件单位
	 */
	private String wMaxunit;
	/**
	 * 最小包装
	 */
	private Float wMin = 0f;
	/**
	 * 最小包装单位
	 */
	private String wMinunit;
	/**
	 * 中包装
	 */
	private Float wMid = 0f;
	/**
	 * 中包装单位
	 */
	private String wMidunit;
	/**
	 * 商品状态
	 */
	private Byte wStatus;
	/**
	 * 创建人
	 */
	private String wCreator;
	/**
	 * 创建日期
	 */
	private Date wInitime;

	/**
	* 贮存条件
	*/
    private String wStoreage;
    /**
    * 医保编码
    */
    private String wMedicalId;
    /**
    * 医保名称
    */
    private String wMedicalName;
    /**
    * 功能疗效
    */
    private String wFunction;
    /**
    * 注册证号
    */
    private String wRegId;
    /**
    * 注册证效期
    */
    private Date wRegExpdate;
    
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
	/**
	 * 批号
	 */
    private String batchNo;
	/**
	 * 有效期
	 */
    private String validDate;
	/**
	 * 货位号
	 */
	private String spCode;
	/**
	 * 库存数量
	 */
	private String amount;
	/**
	 * 批次ID
	 */
	private String sbId;
	/**
	 * 生产日期
	 */
	private String produceDate;
	/**
	 * 库存明细表主键ID
	 */
	private Integer sdId;
	/**
	 * 库存主表主键ID
	 */
	private Integer sId;
	/**
	 * 商品零售价格组
	 */
	private WaresSalepriceGroup wsg;
	/**
	 * 商品批发价格组
	 */
	private WaresWholepriceGroup wwg;
	
	/**
	 * @return the wId
	 */
	public String getwId() {
		return wId;
	}
	/**
	 * @param wId the wId to set
	 */
	public void setwId(String wId) {
		this.wId = wId;
	}
	/**
	 * @return the wClassid
	 */
	public String getwClassid() {
		return wClassid;
	}
	/**
	 * @param wClassid the wClassid to set
	 */
	public void setwClassid(String wClassid) {
		this.wClassid = wClassid;
	}
	/**
	 * @return the wType
	 */
	public String getwType() {
		return wType;
	}
	/**
	 * @param wType the wType to set
	 */
	public void setwType(String wType) {
		this.wType = wType;
	}
	/**
	 * @return the wGenname
	 */
	public String getwGenname() {
		return wGenname;
	}
	/**
	 * @param wGenname the wGenname to set
	 */
	public void setwGenname(String wGenname) {
		this.wGenname = wGenname;
	}
	/**
	 * @return the wTraname
	 */
	public String getwTraname() {
		return wTraname;
	}
	/**
	 * @param wTraname the wTraname to set
	 */
	public void setwTraname(String wTraname) {
		this.wTraname = wTraname;
	}
	/**
	 * @return the wZjm
	 */
	public String getwZjm() {
		return wZjm;
	}
	/**
	 * @param wZjm the wZjm to set
	 */
	public void setwZjm(String wZjm) {
		this.wZjm = wZjm;
	}
	/**
	 * @return the wBarcode
	 */
	public String getwBarcode() {
		return wBarcode;
	}
	/**
	 * @param wBarcode the wBarcode to set
	 */
	public void setwBarcode(String wBarcode) {
		this.wBarcode = wBarcode;
	}
	/**
	 * @return the wApprovalno
	 */
	public String getwApprovalno() {
		return wApprovalno;
	}
	/**
	 * @param wApprovalno the wApprovalno to set
	 */
	public void setwApprovalno(String wApprovalno) {
		this.wApprovalno = wApprovalno;
	}
	/**
	 * @return the wUnit
	 */
	public String getwUnit() {
		return wUnit;
	}
	/**
	 * @param wUnit the wUnit to set
	 */
	public void setwUnit(String wUnit) {
		this.wUnit = wUnit;
	}
	/**
	 * @return the wStandard
	 */
	public String getwStandard() {
		return wStandard;
	}
	/**
	 * @param wStandard the wStandard to set
	 */
	public void setwStandard(String wStandard) {
		this.wStandard = wStandard;
	}
	/**
	 * @return the wBusiness
	 */
	public String getwBusiness() {
		return wBusiness;
	}
	/**
	 * @param wBusiness the wBusiness to set
	 */
	public void setwBusiness(String wBusiness) {
		this.wBusiness = wBusiness;
	}
	/**
	 * @return the wPlace
	 */
	public String getwPlace() {
		return wPlace;
	}
	/**
	 * @param wPlace the wPlace to set
	 */
	public void setwPlace(String wPlace) {
		this.wPlace = wPlace;
	}
	/**
	 * @return the wStatus
	 */
	public Byte getwStatus() {
		return wStatus;
	}
	/**
	 * @param wStatus the wStatus to set
	 */
	public void setwStatus(Byte wStatus) {
		this.wStatus = wStatus;
	}
	/**
	 * @return the wCreator
	 */
	public String getwCreator() {
		return wCreator;
	}
	/**
	 * @param wCreator the wCreator to set
	 */
	public void setwCreator(String wCreator) {
		this.wCreator = wCreator;
	}
	/**
	 * @return the wInitime
	 */
	public Date getwInitime() {
		return wInitime;
	}
	/**
	 * @param wInitime the wInitime to set
	 */
	public void setwInitime(Date wInitime) {
		this.wInitime = wInitime;
	}
	/**
	 * @return the wCostprice
	 */
	public String getwCostprice() {
		if(wCostprice == null){
			return "";
		}
		return wCostprice.toString();
	}
	/**
	 * @param wCostprice the wCostprice to set
	 */
	public void setwCostprice(Float wCostprice) {
		this.wCostprice = wCostprice;
	}
	/**
	 * @return the wSaleprice
	 */
	public String getwSaleprice() {
		if(wSaleprice == null){
			return "";
		}

		return wSaleprice.toString();
	}
	/**
	 * @param wSaleprice the wSaleprice to set
	 */
	public void setwSaleprice(Float wSaleprice) {
		this.wSaleprice = wSaleprice;
	}
	/**
	 * @return the wSellprice
	 */
	public Float getwSellprice() {
		return wSellprice;
	}
	/**
	 * @param wSellprice the wSellprice to set
	 */
	public void setwSellprice(Float wSellprice) {
		this.wSellprice = wSellprice;
	}
	/**
	 * @return the wMax
	 */
	public Float getwMax() {
		return wMax;
	}
	/**
	 * @param wMax the wMax to set
	 */
	public void setwMax(Float wMax) {
		this.wMax = wMax;
	}
	/**
	 * @return the wMaxunit
	 */
	public String getwMaxunit() {
		return wMaxunit;
	}
	/**
	 * @param wMaxunit the wMaxunit to set
	 */
	public void setwMaxunit(String wMaxunit) {
		this.wMaxunit = wMaxunit;
	}
	/**
	 * @return the wMin
	 */
	public Float getwMin() {
		return wMin;
	}
	/**
	 * @param wMin the wMin to set
	 */
	public void setwMin(Float wMin) {
		this.wMin = wMin;
	}
	/**
	 * @return the wMinunit
	 */
	public String getwMinunit() {
		return wMinunit;
	}
	/**
	 * @param wMinunit the wMinunit to set
	 */
	public void setwMinunit(String wMinunit) {
		this.wMinunit = wMinunit;
	}
	/**
	 * @return the wMid
	 */
	public Float getwMid() {
		return wMid;
	}
	/**
	 * @param wMid the wMid to set
	 */
	public void setwMid(Float wMid) {
		this.wMid = wMid;
	}
	/**
	 * @return the wMidunit
	 */
	public String getwMidunit() {
		return wMidunit;
	}
	/**
	 * @param wMidunit the wMidunit to set
	 */
	public void setwMidunit(String wMidunit) {
		this.wMidunit = wMidunit;
	}
	/**
	 * @return the wStoreage
	 */
	public String getwStoreage() {
		return wStoreage;
	}
	/**
	 * @param wStoreage the wStoreage to set
	 */
	public void setwStoreage(String wStoreage) {
		this.wStoreage = wStoreage;
	}
	/**
	 * @return the wMedicalId
	 */
	public String getwMedicalId() {
		return wMedicalId;
	}
	/**
	 * @param wMedicalId the wMedicalId to set
	 */
	public void setwMedicalId(String wMedicalId) {
		this.wMedicalId = wMedicalId;
	}
	/**
	 * @return the wMedicalName
	 */
	public String getwMedicalName() {
		return wMedicalName;
	}
	/**
	 * @param wMedicalName the wMedicalName to set
	 */
	public void setwMedicalName(String wMedicalName) {
		this.wMedicalName = wMedicalName;
	}
	/**
	 * @return the wFunction
	 */
	public String getwFunction() {
		return wFunction;
	}
	/**
	 * @param wFunction the wFunction to set
	 */
	public void setwFunction(String wFunction) {
		this.wFunction = wFunction;
	}
	/**
	 * @return the wRegId
	 */
	public String getwRegId() {
		return wRegId;
	}
	/**
	 * @param wRegId the wRegId to set
	 */
	public void setwRegId(String wRegId) {
		this.wRegId = wRegId;
	}
	/**
	 * @return the wRegExpdate
	 */
	public Date getwRegExpdate() {
		return wRegExpdate;
	}
	/**
	 * @param wRegExpdate the wRegExpdate to set
	 */
	public void setwRegExpdate(Date wRegExpdate) {
		this.wRegExpdate = wRegExpdate;
	}
	/**
	 * @return the wVipprice
	 */
	public Float getwVipprice() {
		return wVipprice;
	}
	/**
	 * @param wVipprice the wVipprice to set
	 */
	public void setwVipprice(Float wVipprice) {
		this.wVipprice = wVipprice;
	}
	/**
	 * @return the wMinSaleprice
	 */
	public Float getwMinSaleprice() {
		return wMinSaleprice;
	}
	/**
	 * @param wMinSaleprice the wMinSaleprice to set
	 */
	public void setwMinSaleprice(Float wMinSaleprice) {
		this.wMinSaleprice = wMinSaleprice;
	}
	/**
	 * @return the wMinVipprice
	 */
	public Float getwMinVipprice() {
		return wMinVipprice;
	}
	/**
	 * @param wMinVipprice the wMinVipprice to set
	 */
	public void setwMinVipprice(Float wMinVipprice) {
		this.wMinVipprice = wMinVipprice;
	}
	/**
	 * @return the wMinSellprice
	 */
	public Float getwMinSellprice() {
		return wMinSellprice;
	}
	/**
	 * @param wMinSellprice the wMinSellprice to set
	 */
	public void setwMinSellprice(Float wMinSellprice) {
		this.wMinSellprice = wMinSellprice;
	}
	/**
	 * @return the wStandardSaleprice
	 */
	public Float getwStandardSaleprice() {
		return wStandardSaleprice;
	}
	/**
	 * @param wStandardSaleprice the wStandardSaleprice to set
	 */
	public void setwStandardSaleprice(Float wStandardSaleprice) {
		this.wStandardSaleprice = wStandardSaleprice;
	}
	/**
	 * @return the wStandardSellprice
	 */
	public Float getwStandardSellprice() {
		return wStandardSellprice;
	}
	/**
	 * @param wStandardSellprice the wStandardSellprice to set
	 */
	public void setwStandardSellprice(Float wStandardSellprice) {
		this.wStandardSellprice = wStandardSellprice;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getValidDate() {
		if(StringUtils.isNotBlank(this.validDate)){
			this.validDate = this.validDate.replaceAll("-","");
		}else{
			this.validDate = "";
		}
		return validDate;
	}

	public void setValidDate(String validDate) {
		if(validDate != null){
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				this.validDate = validDate.substring(0,10);
			} catch (Exception e) {
				this.validDate = "";
			}
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getSbId() {
		return sbId;
	}

	public void setSbId(String sbId) {
		this.sbId = sbId;
	}

	public String getProduceDate() {
		if(StringUtils.isNotBlank(this.produceDate)){
			this.produceDate = this.produceDate.replaceAll("-","");
		}else{
			this.produceDate = "";
		}
		return produceDate;
	}

	public void setProduceDate(String produceDate) {
		if(produceDate != null){
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				this.produceDate = produceDate.substring(0,10);
			} catch (Exception e) {
				this.produceDate = "";
			}
		}else{
			this.produceDate = "";
		}
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
	public WaresSalepriceGroup getWsg() {
		return wsg;
	}
	public void setWsg(WaresSalepriceGroup wsg) {
		this.wsg = wsg;
	}
	public WaresWholepriceGroup getWwg() {
		return wwg;
	}
	public void setWwg(WaresWholepriceGroup wwg) {
		this.wwg = wwg;
	}
	
	
}