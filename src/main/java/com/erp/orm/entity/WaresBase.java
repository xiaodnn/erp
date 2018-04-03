package com.erp.orm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *  商品基础信息
 *
 *
 * @author scy
 * @date 2017年1月1日
 */
@Entity
@Table(name="tb_wares_base")
public class WaresBase {
	/**
	 * 商品ID 主键
	 */
	@Id
	protected Integer wId;
	/**
	 * 品类编码
	 */
	@Column(name="w_classid")
	private String wClassid;
	/**
	 * 商品类型
	 */
	@Column(name="w_type")
	private String wType;
	/**
	 * 通用名
	 */
	@Column(name="w_genname")
	private String wGenname;
	/**
	 * 商品名
	 */
	@Column(name="w_traname")
	protected String wTraname;
	/**
	 * 商品助记码
	 */
	@Column(name="w_zjm")
	private String wZjm;
	/**
	 * 商品条形码
	 */
	@Column(name="w_barcode")
	private String wBarcode;
	/**
	 * 批准文号
	 */
	@Column(name="w_approvalno")
	private String wApprovalno;
	/**
	 * 商品单位
	 */
	@Column(name="w_unit")
	protected String wUnit;
	/**
	 * 商品规格
	 */
	@Column(name="w_standard")
	protected String wStandard;
	/**
	 * 生产企业
	 */
	@Column(name="w_business")
	protected String wBusiness;
	/**
	 * 生产产地
	 */
	@Column(name="w_place")
	protected String wPlace;
	/**
	 * 件装量
	 */
	@Column(name="w_max")
	private Float wMax = 0f;
	/**
	 * 件单位
	 */
	@Column(name="w_maxunit")
	private String wMaxunit;
	/**
	 * 最小包装
	 */
	@Column(name="w_min")
	private Float wMin = 0f;
	/**
	 * 最小包装单位
	 */
	@Column(name="w_minunit")
	private String wMinunit;
	/**
	 * 中包装
	 */
	@Column(name="w_mid")
	private Float wMid = 0f;
	/**
	 * 中包装单位
	 */
	@Column(name="w_midunit")
	private String wMidunit;
	/**
	 * 商品状态(0:不可用)
	 */
	@Column(name="w_status")
	private Byte wStatus;
	/**
	 * 创建人
	 */
	@Column(name="w_creator")
	private String wCreator;
	/**
	 * 创建日期
	 */
	@Column(name="w_initime")
	private Date wInitime;

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId == null ? 0 : wId;
    }

    public String getwClassid() {
        return wClassid;
    }

    public void setwClassid(String wClassid) {
        this.wClassid = wClassid == null ? null : wClassid.trim();
    }

    public String getwType() {
        return wType;
    }

    public void setwType(String wType) {
        this.wType = wType == null ? null : wType.trim();
    }

    public String getwGenname() {
        return wGenname;
    }

    public void setwGenname(String wGenname) {
        this.wGenname = wGenname == null ? null : wGenname.trim();
    }

    public String getwTraname() {
        return wTraname;
    }

    public void setwTraname(String wTraname) {
        this.wTraname = wTraname == null ? null : wTraname.trim();
    }

    public String getwZjm() {
        return wZjm;
    }

    public void setwZjm(String wZjm) {
        this.wZjm = wZjm == null ? null : wZjm.trim();
    }

    public String getwBarcode() {
        return wBarcode;
    }

    public void setwBarcode(String wBarcode) {
        this.wBarcode = wBarcode == null ? null : wBarcode.trim();
    }

    public String getwApprovalno() {
        return wApprovalno;
    }

    public void setwApprovalno(String wApprovalno) {
        this.wApprovalno = wApprovalno == null ? null : wApprovalno.trim();
    }

    public String getwUnit() {
        return wUnit;
    }

    public void setwUnit(String wUnit) {
        this.wUnit = wUnit == null ? null : wUnit.trim();
    }

    public String getwStandard() {
        return wStandard;
    }

    public void setwStandard(String wStandard) {
        this.wStandard = wStandard == null ? null : wStandard.trim();
    }

    public String getwBusiness() {
        return wBusiness;
    }

    public void setwBusiness(String wBusiness) {
        this.wBusiness = wBusiness == null ? null : wBusiness.trim();
    }

    public String getwPlace() {
        return wPlace;
    }

    public void setwPlace(String wPlace) {
        this.wPlace = wPlace == null ? null : wPlace.trim();
    }

    public Float getwMax() {
        return wMax;
    }

    public void setwMax(Float wMax) {
        this.wMax = wMax;
    }

    public String getwMaxunit() {
        return wMaxunit;
    }

    public void setwMaxunit(String wMaxunit) {
        this.wMaxunit = wMaxunit == null ? null : wMaxunit.trim();
    }

    public Float getwMin() {
        return wMin;
    }

    public void setwMin(Float wMin) {
        this.wMin = wMin;
    }

    public String getwMinunit() {
        return wMinunit;
    }

    public void setwMinunit(String wMinunit) {
        this.wMinunit = wMinunit == null ? null : wMinunit.trim();
    }

    public Float getwMid() {
        return wMid;
    }

    public void setwMid(Float wMid) {
        this.wMid = wMid;
    }

    public String getwMidunit() {
        return wMidunit;
    }

    public void setwMidunit(String wMidunit) {
        this.wMidunit = wMidunit == null ? null : wMidunit.trim();
    }

    public Byte getwStatus() {
        return wStatus;
    }

    public void setwStatus(Byte wStatus) {
        this.wStatus = wStatus;
    }

    public String getwCreator() {
        return wCreator;
    }

    public void setwCreator(String wCreator) {
        this.wCreator = wCreator == null ? null : wCreator.trim();
    }

    public Date getwInitime() {
        return wInitime;
    }

    public void setwInitime(Date wInitime) {
        this.wInitime = wInitime;
    }
}