package com.erp.orm.inter;

import java.util.List;
import java.util.Map;

import com.erp.orm.entity.Approve;
import org.springframework.stereotype.Repository;
@Repository("approveMapper")
public interface IApproveMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Approve approve);

    int insertSelective(Approve approve);

    Approve selectByPrimaryKey(Integer aId);

    /**
     * 根据模块ID,查询需审批部门和人员信息
     * @param mId
     * @return
     */
    Approve selectByMid(Integer mId);

    Approve selectByOgranAndModule(Map<String, Integer> map);

    int updateByPrimaryKeySelective(Approve approve);

    int updateByPrimaryKey(Approve approve);

    /**
     * 根据机构ID、模块ID、用户ID 查询
     * @param map
     * @return
     */
    Approve selectByOrder(Map<String, Object> map);

	List<Approve> selectAll();

    List<Approve> selectByPage(Map<String,Integer> map);

    Integer selectCount(Map<String, Object> map);
}