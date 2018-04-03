package com.erp.orm.inter;
import java.util.List;
import java.util.Map;


import com.erp.orm.entity.MapApproveRecord;
import org.springframework.stereotype.Repository;

@Repository("mapApproveRecordMapper")
public interface IMapApproveRecordMapper {
    int deleteByPrimaryKey(Integer marId);

    int insert(MapApproveRecord mapApproveRecord);

    int insertSelective(MapApproveRecord mapApproveRecord);

    MapApproveRecord selectByPrimaryKey(Integer marId);

    MapApproveRecord selectByMidAndRid(Map<String,Object> map);

    int updateByPrimaryKeySelective(MapApproveRecord mapApproveRecord);

    int updateByPrimaryKey(MapApproveRecord mapApproveRecord);

	MapApproveRecord selectByCode(String oCode);

	List<MapApproveRecord> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

    /**
     * 审批通过操作
     * @param map ( mId 模块ID, rId 单据ID,n 第几级审核, eId 员工ID,eoId 员工部门, marState 审批状态)
     * @return
     */
    int updateByApproveInfoToPass(Map<String, Object> map);
    /**
     * 审批驳回操作
     * @param map ( mId 模块ID, rId 单据ID,n 第几级审核, eId 员工ID,eoId 员工部门, marState 审批状态)
     * @return
     */
    int updateByApproveInfoToReject(Map<String, Object> map);
    /**
     * 审批作废操作
     * @param map ( mId 模块ID, rId 单据ID,n 第几级审核, eId 员工ID,eoId 员工部门, marState 审批状态)
     * @return
     */
    int updateByApproveInfoToCancelled(Map<String, Object> map);
    /**
     * 审批撤回操作
     * @parammap ( mId 模块ID, rId 单据ID,n 第几级审核, eId 员工ID,eoId 员工部门, marState 审批状态)
     * @return
     */
    int updateByApproveInfoToRecall(Map<String, Object> map);
    /**
     * 审批终止操作
     * @param map ( mId 模块ID, rId 单据ID,n 第几级审核, eId 员工ID,eoId 员工部门, marState 审批状态)
     * @return
     */
    int updateByApproveInfoToAbort(Map<String, Object> map);


}