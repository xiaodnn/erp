package com.erp.orm.entity;

import java.util.Date;

/**
 * 审核流程设置和单据映射
 */
public class MapApproveRecord {
    /**
     * 主键自增ID
     */
    private Integer marId;
    /**
     * 审核流程设置ID
     */
    private Integer aId;
    /**
     * 创建单据用户ID
     */
    private Integer uId;
    /**
     * 模块ID
     */
    private Integer mId;
    /**
     * 单据ID
     */
    private String rId;
    /**
     * 单据状态,0:无效,1:正常,2:审核中,3:审核完成,4:驳回,5:撤销,6:作废
     */
    private Byte marState;
    /**
     * 审核级别
     */
    private Byte marLevel;
    /**
     * 一审部门
     */
    private Integer marDid1;
    /**
     * 一审人
     */
    private Integer marUid1;
    /**
     * 二审部门
     */
    private Integer marDid2;
    /**
     * 二审人
     */
    private Integer marUid2;
    /**
     * 三审部门
     */
    private Integer marDid3;
    /**
     * 三审人
     */
    private Integer marUid3;
    /**
     * 四审部门
     */
    private Integer marDid4;
    /**
     * 四审人
     */
    private Integer marUid4;
    /**
     * 五审部门
     */
    private Integer marDid5;
    /**
     * 五审人
     */
    private Integer marUid5;
    /**
     * 六审部门
     */
    private Integer marDid6;
    /**
     * 六审人
     */
    private Integer marUid6;
    /**
     * 记录时间
     */
    private Date marIntime;

    public Integer getMarId() {
        return marId;
    }

    public void setMarId(Integer marId) {
        this.marId = marId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public Byte getMarState() {
        return marState;
    }

    public void setMarState(Byte marState) {
        this.marState = marState;
    }

    public Byte getMarLevel() {
        return marLevel;
    }

    public void setMarLevel(Byte marLevel) {
        this.marLevel = marLevel;
    }

    public Integer getMarDid1() {
        return marDid1;
    }

    public void setMarDid1(Integer marDid1) {
        this.marDid1 = marDid1;
    }

    public Integer getMarUid1() {
        return marUid1;
    }

    public void setMarUid1(Integer marUid1) {
        this.marUid1 = marUid1;
    }

    public Integer getMarDid2() {
        return marDid2;
    }

    public void setMarDid2(Integer marDid2) {
        this.marDid2 = marDid2;
    }

    public Integer getMarUid2() {
        return marUid2;
    }

    public void setMarUid2(Integer marUid2) {
        this.marUid2 = marUid2;
    }

    public Integer getMarDid3() {
        return marDid3;
    }

    public void setMarDid3(Integer marDid3) {
        this.marDid3 = marDid3;
    }

    public Integer getMarUid3() {
        return marUid3;
    }

    public void setMarUid3(Integer marUid3) {
        this.marUid3 = marUid3;
    }

    public Integer getMarDid4() {
        return marDid4;
    }

    public void setMarDid4(Integer marDid4) {
        this.marDid4 = marDid4;
    }

    public Integer getMarUid4() {
        return marUid4;
    }

    public void setMarUid4(Integer marUid4) {
        this.marUid4 = marUid4;
    }

    public Integer getMarDid5() {
        return marDid5;
    }

    public void setMarDid5(Integer marDid5) {
        this.marDid5 = marDid5;
    }

    public Integer getMarUid5() {
        return marUid5;
    }

    public void setMarUid5(Integer marUid5) {
        this.marUid5 = marUid5;
    }

    public Integer getMarDid6() {
        return marDid6;
    }

    public void setMarDid6(Integer marDid6) {
        this.marDid6 = marDid6;
    }

    public Integer getMarUid6() {
        return marUid6;
    }

    public void setMarUid6(Integer marUid6) {
        this.marUid6 = marUid6;
    }

    public Date getMarIntime() {
        return marIntime;
    }

    public void setMarIntime(Date marIntime) {
        this.marIntime = marIntime;
    }
}