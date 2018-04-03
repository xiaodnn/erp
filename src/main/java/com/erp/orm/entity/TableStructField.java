package com.erp.orm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.erp.model.JsonTableStructField;

/**
 * 表结构字段信息表
 * @author xiao
 *
 */
public class TableStructField {
	/**
	 * 自增ID
	 */
    private Integer tsfId;
    /**
	 * 所属表ID
	 */
    private Integer tsId;
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
     * 是否显示(默认显示:0)
     */
    private Byte tsfNotNull = 0;
    
    private String isnotnull = "否";
    /**
	 * 默认值 default
	 */
    private String tsfDefault;
    /**
	 * 备注
	 */
    private String tsfRemark;
    /**
	 * 创建时间
	 */
    private Date intime;
    
    public TableStructField() {

	}

    public TableStructField(JsonTableStructField jts) {
    	if(StringUtils.isNotBlank(jts.getTsfId())){
    		this.tsfId = Integer.parseInt(jts.getTsfId());
    	}
    	if(StringUtils.isNotBlank(jts.getTsId())){
    		this.tsId = Integer.parseInt(jts.getTsId());
    	}
    	this.tsfName = jts.getTsfName();
    	this.tsfNikename = jts.getTsfNikename();
    	this.tsfType = jts.getTsfType();
    	this.tsfLen = jts.getTsfLen();
    	this.tsfKey = jts.getTsfKey();
    	this.tsfFormtype = jts.getTsfFormtype();
    	if(StringUtils.isNotBlank(jts.getIsnotnull())){
    		if("是".equals(jts.getIsnotnull())){
    			this.tsfNotNull = 1;
    			this.isnotnull ="是";
    		}else{
    			this.tsfNotNull = 0;
    			this.isnotnull ="否";
    		}    		
    	}
    	
    	this.tsfDefault =jts.getTsfDefault();
    	this.tsfRemark = jts.getTsfRemark();
    	if(StringUtils.isNotBlank(jts.getIntime())){
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		this.intime = null;
    		try{
    			this.intime = sdf.parse(jts.getIntime());
    		}catch(Exception e){
    			this.intime = null;
    			//loggerError(this.getClass(), "表结构字段信息表转日期类型异常:"+e.getMessage());
    		}
    	}
	}

	public Integer getTsfId() {
        return tsfId;
    }

    public void setTsfId(Integer tsfId) {
        this.tsfId = tsfId;
    }

    public Integer getTsId() {
        return tsId;
    }

    public void setTsId(Integer tsId) {
        this.tsId = tsId;
    }

    public String getTsfName() {
        return tsfName;
    }

    public void setTsfName(String tsfName) {
        this.tsfName = tsfName == null ? null : tsfName.trim();
    }

    public String getTsfNikename() {
        return tsfNikename;
    }

    public void setTsfNikename(String tsfNikename) {
        this.tsfNikename = tsfNikename == null ? null : tsfNikename.trim();
    }

    public String getTsfType() {
        return tsfType;
    }

    public void setTsfType(String tsfType) {
        this.tsfType = tsfType == null ? null : tsfType.trim();
    }

    public String getTsfLen() {
        return tsfLen;
    }

    public void setTsfLen(String tsfLen) {
        this.tsfLen = tsfLen == null ? null : tsfLen.trim();
    }

    public String getTsfFormtype() {
        return tsfFormtype;
    }

    public void setTsfFormtype(String tsfFormtype) {
        this.tsfFormtype = tsfFormtype == null ? null : tsfFormtype.trim();
    }

    public String getTsfDefault() {
        return tsfDefault;
    }

    public void setTsfDefault(String tsfDefault) {
        this.tsfDefault = tsfDefault == null ? null : tsfDefault.trim();
    }

    public String getTsfRemark() {
        return tsfRemark;
    }

    public void setTsfRemark(String tsfRemark) {
        this.tsfRemark = tsfRemark == null ? null : tsfRemark.trim();
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

	public String getTsfKey() {
		return tsfKey;
	}

	public void setTsfKey(String tsfKey) {
		this.tsfKey = tsfKey;
	}

	public Byte getTsfNotNull() {		
		return tsfNotNull;
	}

	public void setTsfNotNull(Byte tsfNotNull) {
		this.tsfNotNull = tsfNotNull;
	}

	public String getIsnotnull() {
		if(tsfNotNull == 1){
			this.isnotnull = "是";
		}else{
			this.isnotnull = "否";
		}
		return isnotnull;
	}

	public void setIsnotnull(String isnotnull) {
		if("是".equals(isnotnull)){
			this.tsfNotNull = 1;
		}else{
			this.tsfNotNull = 0;
		}
//		if(tsfNotNull == 1){
//			this.isnotnull = "是";
//		}else{
//			this.isnotnull = "否";
//		}
		this.isnotnull = isnotnull;
	}
	
}