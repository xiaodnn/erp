package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.MapApproveRecord;

public interface IMapApproveRecordDao {
    int deleteByPrimaryKey(Integer marId);

    int insert(MapApproveRecord mapApproveRecord);

    int insertSelective(MapApproveRecord mapApproveRecord);

    MapApproveRecord selectByPrimaryKey(Integer marId);

    int updateByPrimaryKeySelective(MapApproveRecord mapApproveRecord);

    int updateByPrimaryKey(MapApproveRecord mapApproveRecord);

	MapApproveRecord selectByCode(String oCode);

	List<MapApproveRecord> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

    MapApproveRecord selectByMidAndRid(Integer mId, String rId);

    /**
     * 审批通过操作
     * @param mId 模块ID
     * @param rId 单据ID
     * @param n 第几级审核
     * @param eId 员工ID
     * @param eoId 员工部门
     * @param marState 审批状态
     * @return
     */
    int updateByApproveInfoToPass(Integer mId, String rId, int n, Integer eId, String eoId,Byte marState );
    /**
     * 审批驳回操作
     * @param mId 模块ID
     * @param rId 单据ID
     * @param n 第几级审核
     * @param eId 员工ID
     * @param eoId 员工部门
     * @param marState 审批状态
     * @return
     */
    int updateByApproveInfoToReject(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState);
    /**
     * 审批作废操作
     * @param mId 模块ID
     * @param rId 单据ID
     * @param n 第几级审核
     * @param eId 员工ID
     * @param eoId 员工部门
     * @param marState 审批状态
     * @return
     */
    int updateByApproveInfoToCancelled(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState);
    /**
     * 审批撤回操作
     * @param mId 模块ID
     * @param rId 单据ID
     * @param n 第几级审核
     * @param eId 员工ID
     * @param eoId 员工部门
     * @param marState 审批状态
     * @return
     */
    int updateByApproveInfoToRecall(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState);
    /**
     * 审批终止操作
     * @param mId 模块ID
     * @param rId 单据ID
     * @param n 第几级审核
     * @param eId 员工ID
     * @param eoId 员工部门
     * @param marState 审批状态
     * @return
     */
    int updateByApproveInfoToAbort(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState);

}
