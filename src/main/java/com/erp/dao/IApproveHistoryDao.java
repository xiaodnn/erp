package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.ApproveHistory;

public interface IApproveHistoryDao {
    int deleteByPrimaryKey(Integer ahId);

    int insert(ApproveHistory approveHistory);

    int insertSelective(ApproveHistory approveHistory);

    ApproveHistory selectByPrimaryKey(Integer ahId);

    int updateByPrimaryKeySelective(ApproveHistory approveHistory);

    int updateByPrimaryKey(ApproveHistory approveHistory);

	ApproveHistory selectByCode(String oCode);

	List<ApproveHistory> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

    List<ApproveHistory> selectByRid(String rId);
}
