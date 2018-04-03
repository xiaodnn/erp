package com.erp.service;


import java.util.List;

import com.erp.orm.entity.Approve;
import com.erp.orm.entity.MapApproveRecord;

public interface IMapApproveRecordService {
    int delById(Integer marId);

    int save(MapApproveRecord mapApproveRecord);

    int saveNotNull(MapApproveRecord mapApproveRecord);

    MapApproveRecord findById(Integer marId);

    int modifyByIdNotNull(MapApproveRecord mapApproveRecord);

    int modifyById(MapApproveRecord mapApproveRecord);

	MapApproveRecord findByCode(String oCode);

    MapApproveRecord findByMidAndRid(Integer mId,String rId);

	List<MapApproveRecord> findByPage(Integer page, Integer rows);

	Integer findCount( );

    /**
     * 根据单据ID，用户ID，审核流程添加审批单据
     * @param rId
     * @param uId
     * @param approve
     * @return
     */
    int saveNotNull(String rId, Integer uId, Approve approve);

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
    int modifyByApproveInfoToPass(Integer mId, String rId, int n, Integer eId, String eoId,Byte marState);

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
    int modifyByApproveInfoToReject(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState);
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
    int modifyByApproveInfoToCancelled(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState);
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
    int modifyByApproveInfoToRecall(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState);
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
    int modifyByApproveInfoToAbort(Integer mId, String rId, int n, Integer eId, String eoId, Byte marState);
}
