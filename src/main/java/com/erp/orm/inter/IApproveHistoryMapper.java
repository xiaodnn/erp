package com.erp.orm.inter;
import java.util.List;
import java.util.Map;


import com.erp.orm.entity.ApproveHistory;
import org.springframework.stereotype.Repository;

@Repository("approveHistoryMapper")
public interface IApproveHistoryMapper {

    int deleteByPrimaryKey(Integer ahId);

    int insert(ApproveHistory approveHistory);

    int insertSelective(ApproveHistory approveHistory);

    ApproveHistory selectByPrimaryKey(Integer ahId);

    int updateByPrimaryKeySelective(ApproveHistory approveHistory);

    int updateByPrimaryKey(ApproveHistory approveHistory);

	ApproveHistory selectByCode(String oCode);

	List<ApproveHistory> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

    List<ApproveHistory> selectByRid(String rId);
}