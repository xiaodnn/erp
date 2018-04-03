package com.erp.orm.entity;

import java.util.Date;

/**
 * 商品扩展信息
 *
 *
 * @author scy
 * @date 2017年1月1日
 */
public class WaresExtend {
	/**
	 * 商品编号
	 */
    private String wId;
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

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId == null ? null : wId.trim();
    }

    public String getwStoreage() {
        return wStoreage;
    }

    public void setwStoreage(String wStoreage) {
        this.wStoreage = wStoreage == null ? null : wStoreage.trim();
    }

    public String getwMedicalId() {
        return wMedicalId;
    }

    public void setwMedicalId(String wMedicalId) {
        this.wMedicalId = wMedicalId == null ? null : wMedicalId.trim();
    }

    public String getwMedicalName() {
        return wMedicalName;
    }

    public void setwMedicalName(String wMedicalName) {
        this.wMedicalName = wMedicalName == null ? null : wMedicalName.trim();
    }

    public String getwFunction() {
        return wFunction;
    }

    public void setwFunction(String wFunction) {
        this.wFunction = wFunction == null ? null : wFunction.trim();
    }

    public String getwRegId() {
        return wRegId;
    }

    public void setwRegId(String wRegId) {
        this.wRegId = wRegId == null ? null : wRegId.trim();
    }

    public Date getwRegExpdate() {
        return wRegExpdate;
    }

    public void setwRegExpdate(Date wRegExpdate) {
        this.wRegExpdate = wRegExpdate;
    }
}