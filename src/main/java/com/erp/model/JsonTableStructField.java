/**
 * 
 */
package com.erp.model;

/**
 * 表结构字段信息表
 * @author xiao
 *
 */
public class JsonTableStructField {
	/**
	 * 自增ID
	 */
    private String tsfId;
    /**
	 * 所属表ID
	 */
    private String tsId;
    /**
	 * 字段名
	 */
    private String tsfName;
    /**
	 * 字段名描叙
	 */
    private String tsfNikename;
    /**
	 * 字段类型
	 */
    private String tsfType;
    /**
	 * 字段长度
	 */
    private String tsfLen;
    /**
     * 主键或外键(主键:key;外键:foreign,外键表名)
     */
    private String tsfKey;
    /**
	 * 表单中控件类(文本框:text;下来列表:select;复选框:checkbox;单选框:radio;多行文本:multiple)
	 */
    private String tsfFormtype;
    /**
     * 是否显示
     */
//    private String tsfNotNull = "否";
    private String isnotnull = "否";
    
    /**
	 * 默认值
	 */
    private String tsfDefault;
    /**
	 * 备注
	 */
    private String tsfRemark;
    /**
	 * 创建时间
	 */
    private String intime;
    
	public String getTsfId() {
		return tsfId;
	}
	public void setTsfId(String tsfId) {
		this.tsfId = tsfId;
	}
	public String getTsId() {
		return tsId;
	}
	public void setTsId(String tsId) {
		this.tsId = tsId;
	}
	public String getTsfName() {
		return tsfName;
	}
	public void setTsfName(String tsfName) {
		this.tsfName = tsfName;
	}
	public String getTsfNikename() {
		return tsfNikename;
	}
	public void setTsfNikename(String tsfNikename) {
		this.tsfNikename = tsfNikename;
	}
	public String getTsfType() {
		return tsfType;
	}
	public void setTsfType(String tsfType) {
		this.tsfType = tsfType;
	}
	public String getTsfLen() {
		return tsfLen;
	}
	public void setTsfLen(String tsfLen) {
		this.tsfLen = tsfLen;
	}
	public String getTsfFormtype() {
		return tsfFormtype;
	}
	public void setTsfFormtype(String tsfFormtype) {
		this.tsfFormtype = tsfFormtype;
	}
	public String getTsfDefault() {
		return tsfDefault;
	}
	public void setTsfDefault(String tsfDefault) {
		this.tsfDefault = tsfDefault;
	}
	public String getTsfRemark() {
		return tsfRemark;
	}
	public void setTsfRemark(String tsfRemark) {
		this.tsfRemark = tsfRemark;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public String getTsfKey() {
		return tsfKey;
	}
	public void setTsfKey(String tsfKey) {
		this.tsfKey = tsfKey;
	}
	public String getIsnotnull() {
		return isnotnull;
	}
	public void setIsnotnull(String isnotnull) {
		this.isnotnull = isnotnull;
	}
	
//	public String getTsfNotNull() {
//		return tsfNotNull;
//	}
//	public void setTsfNotNull(String tsfNotNull) {
//		this.tsfNotNull = tsfNotNull;
//	}
	
}
