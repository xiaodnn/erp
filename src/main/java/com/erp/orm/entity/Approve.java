package com.erp.orm.entity;

import java.util.Date;

/**
 * 审核流程设置
 * @author scy
 *
 */
public class Approve {
	
	/**
	 * 主键ID
	 */
    private Integer aId;
    /**
     * 机构id
     */
    private Integer oId;
    /**
     * 机构名称
     */
    private String aOrganName;
    /**
     * 模块id
     */
    private Integer mId;
    /**
     * 模块名称
     */
    private String aModuleName;
    /**
     * 几级审核(最多6级)
     */
    private Byte aLevel;
    /**
     * 状态,0:无效,1:正常,2:审核中,3:审核完成,4:驳回,5:撤销,6:作废
     */
    private Byte aState;
    /**
     * 添加时间
     */
    private Date aIntime;
    /**
     * 添加人
     */
    private String aCreator;
    /**
     * 一审核人id
     */
    private Integer aLevelUid1;
    /**
     * 一审核人姓名
     */
    private String uname1;
    /**
     * 一审核部门ID
     */
    private Integer aLevelDid1;
    /**
     * 一审核部门名称
     */
    private String dname1;
    /**
     * 二审核人id
     */
    private Integer aLevelUid2;
    /**
     * 二审核人姓名
     */
    private String uname2;
    /**
     * 二审核部门ID
     */
    private Integer aLevelDid2;
    /**
     * 二审核部门名称
     */
    private String dname2;
    /**
     * 三审核人id
     */
    private Integer aLevelUid3;
    /**
     * 三审核人姓名
     */
    private String uname3;
    /**
     * 三审核部门ID
     */
    private Integer aLevelDid3;
    /**
     * 三审核部门名称
     */
    private String dname3;
    /**
     * 四审核人id
     */
    private Integer aLevelUid4;
    /**
     * 四审核人姓名
     */
    private String uname4;
    /**
     * 四审核部门ID
     */
    private Integer aLevelDid4;
    /**
     * 四审核部门名称
     */
    private String dname4;
    /**
     * 五审核人id
     */
    private Integer aLevelUid5;
    /**
     * 五审核人姓名
     */
    private String uname5;
    /**
     * 五审核部门ID
     */
    private Integer aLevelDid5;
    /**
     * 五审核部门名称
     */
    private String dname5;
    /**
     * 六审核人id
     */
    private Integer aLevelUid6;
    /**
     * 六审核人姓名
     */
    private String uname6;
    /**
     * 六审核部门ID
     */
    private Integer aLevelDid6;
    /**
     * 六审核部门名称
     */
    private String dname6;


    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Byte getaLevel() {
        return aLevel;
    }

    public void setaLevel(Byte aLevel) {
        this.aLevel = aLevel;
    }

    public Byte getaState() {
        return aState;
    }

    public void setaState(Byte aState) {
        this.aState = aState;
    }

    public Date getaIntime() {
        return aIntime;
    }

    public void setaIntime(Date aIntime) {
        this.aIntime = aIntime;
    }

    public String getaCreator() {
        return aCreator;
    }

    public void setaCreator(String aCreator) {
        this.aCreator = aCreator == null ? null : aCreator.trim();
    }

    public Integer getaLevelUid1() {
        return aLevelUid1;
    }

    public void setaLevelUid1(Integer aLevelUid1) {
        this.aLevelUid1 = aLevelUid1;
    }

    public String getUname1() {
        return uname1;
    }

    public void setUname1(String uname1) {
        this.uname1 = uname1;
    }

    public Integer getaLevelDid1() {
        return aLevelDid1;
    }

    public void setaLevelDid1(Integer aLevelDid1) {
        this.aLevelDid1 = aLevelDid1;
    }

    public String getDname1() {
        return dname1;
    }

    public void setDname1(String dname1) {
        this.dname1 = dname1;
    }

    public Integer getaLevelUid2() {
        return aLevelUid2;
    }

    public void setaLevelUid2(Integer aLevelUid2) {
        this.aLevelUid2 = aLevelUid2;
    }

    public String getUname2() {
        return uname2;
    }

    public void setUname2(String uname2) {
        this.uname2 = uname2;
    }

    public Integer getaLevelDid2() {
        return aLevelDid2;
    }

    public void setaLevelDid2(Integer aLevelDid2) {
        this.aLevelDid2 = aLevelDid2;
    }

    public String getDname2() {
        return dname2;
    }

    public void setDname2(String dname2) {
        this.dname2 = dname2;
    }

    public Integer getaLevelUid3() {
        return aLevelUid3;
    }

    public void setaLevelUid3(Integer aLevelUid3) {
        this.aLevelUid3 = aLevelUid3;
    }

    public String getUname3() {
        return uname3;
    }

    public void setUname3(String uname3) {
        this.uname3 = uname3;
    }

    public Integer getaLevelDid3() {
        return aLevelDid3;
    }

    public void setaLevelDid3(Integer aLevelDid3) {
        this.aLevelDid3 = aLevelDid3;
    }

    public String getDname3() {
        return dname3;
    }

    public void setDname3(String dname3) {
        this.dname3 = dname3;
    }

    public Integer getaLevelUid4() {
        return aLevelUid4;
    }

    public void setaLevelUid4(Integer aLevelUid4) {
        this.aLevelUid4 = aLevelUid4;
    }

    public String getUname4() {
        return uname4;
    }

    public void setUname4(String uname4) {
        this.uname4 = uname4;
    }

    public Integer getaLevelDid4() {
        return aLevelDid4;
    }

    public void setaLevelDid4(Integer aLevelDid4) {
        this.aLevelDid4 = aLevelDid4;
    }

    public String getDname4() {
        return dname4;
    }

    public void setDname4(String dname4) {
        this.dname4 = dname4;
    }

    public Integer getaLevelUid5() {
        return aLevelUid5;
    }

    public void setaLevelUid5(Integer aLevelUid5) {
        this.aLevelUid5 = aLevelUid5;
    }

    public String getUname5() {
        return uname5;
    }

    public void setUname5(String uname5) {
        this.uname5 = uname5;
    }

    public Integer getaLevelDid5() {
        return aLevelDid5;
    }

    public void setaLevelDid5(Integer aLevelDid5) {
        this.aLevelDid5 = aLevelDid5;
    }

    public String getDname5() {
        return dname5;
    }

    public void setDname5(String dname5) {
        this.dname5 = dname5;
    }

    public Integer getaLevelUid6() {
        return aLevelUid6;
    }

    public void setaLevelUid6(Integer aLevelUid6) {
        this.aLevelUid6 = aLevelUid6;
    }

    public String getUname6() {
        return uname6;
    }

    public void setUname6(String uname6) {
        this.uname6 = uname6;
    }

    public Integer getaLevelDid6() {
        return aLevelDid6;
    }

    public void setaLevelDid6(Integer aLevelDid6) {
        this.aLevelDid6 = aLevelDid6;
    }

    public String getDname6() {
        return dname6;
    }

    public void setDname6(String dname6) {
        this.dname6 = dname6;
    }

    public String getaOrganName() {
        return aOrganName;
    }

    public void setaOrganName(String aOrganName) {
        this.aOrganName = aOrganName;
    }

    public String getaModuleName() {
        return aModuleName;
    }

    public void setaModuleName(String aModuleName) {
        this.aModuleName = aModuleName;
    }
}