package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.WholesaleApply;

public interface IWholesaleApplyDao {
    int deleteByPrimaryKey(Integer waId);

    int insert(WholesaleApply wholesaleApply);

    int insertSelective(WholesaleApply wholesaleApply);

    WholesaleApply selectByPrimaryKey(Integer waId);

    int updateByPrimaryKeySelective(WholesaleApply wholesaleApply);

    int updateByPrimaryKey(WholesaleApply wholesaleApply);

	WholesaleApply selectByCode(String oCode);

	List<WholesaleApply> selectByPage(Integer page, Integer rows,Integer waId);

	Integer selectCount( );

    List<WholesaleApply> selectByName(String name);
}
