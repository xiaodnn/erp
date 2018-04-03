package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.WholesaleApplyDetail;

public interface IWholesaleApplyDetailDao {
    int deleteByPrimaryKey(Integer wadId);

    int insert(WholesaleApplyDetail wholesaleApplyDetail);

    int insertSelective(WholesaleApplyDetail wholesaleApplyDetail);

    WholesaleApplyDetail selectByPrimaryKey(Integer wadId);

    int updateByPrimaryKeySelective(WholesaleApplyDetail wholesaleApplyDetail);

    int updateByPrimaryKey(WholesaleApplyDetail wholesaleApplyDetail);

	WholesaleApplyDetail selectByCode(String oCode);

	List<WholesaleApplyDetail> selectByPage(Integer page, Integer rows,Integer waId);

	Integer selectCount( );

    List<WholesaleApplyDetail> selectByName(String name);

    int deleteByWaIdAndWid(String waId, String wId);
}
