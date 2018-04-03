package com.erp.orm.entity;

import java.util.Date;
import java.util.List;

/**
 * 表结构信息表
 * @author xiao
 *
 */
public class TableStruct {
	/**
	 * 自增ID
	 */
    private Integer tsId;
    /**
	 * 表名
	 */
    private String tsName;
    /**
	 * 表简称
	 */
    private String tsNikename;
    /**
	 * 表类型(1:普通，2:单据)
	 */
    private Byte tsType;
    /**
	 * 主表ID
	 */
    private Integer tsMid;
    /**
	 * 备注
	 */
    private String tsRemark;
    /**
	 * 创建时间
	 */
    private Date intime;
    
    private List<TableStructField> tableStructFields;
    

    public Integer getTsId() {
        return tsId;
    }

    public void setTsId(Integer tsId) {
        this.tsId = tsId;
    }

    public String getTsName() {
        return tsName;
    }

    public void setTsName(String tsName) {
        this.tsName = tsName == null ? null : tsName.trim();
    }

    public String getTsNikename() {
        return tsNikename;
    }

    public void setTsNikename(String tsNikename) {
        this.tsNikename = tsNikename == null ? null : tsNikename.trim();
    }

    public Byte getTsType() {
        return tsType;
    }

    public void setTsType(Byte tsType) {
        this.tsType = tsType;
    }

    public Integer getTsMid() {
        return tsMid;
    }

    public void setTsMid(Integer tsMid) {
        this.tsMid = tsMid;
    }

    public String getTsRemark() {
        return tsRemark;
    }

    public void setTsRemark(String tsRemark) {
        this.tsRemark = tsRemark == null ? null : tsRemark.trim();
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

	public List<TableStructField> getTableStructFields() {
		return tableStructFields;
	}

	public void setTableStructFields(List<TableStructField> tableStructFields) {
		this.tableStructFields = tableStructFields;
	}
    
}