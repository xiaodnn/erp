package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.Wholesale;

public interface IWholesaleDao {
    int deleteByPrimaryKey(Integer wsId);

    int insert(Wholesale wholesale);

    int insertSelective(Wholesale wholesale);

    Wholesale selectByPrimaryKey(Integer wsId);

    int updateByPrimaryKeySelective(Wholesale wholesale);

    int updateByPrimaryKey(Wholesale wholesale);

	Wholesale selectByCode(String oCode);

	List<Wholesale> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

    List<Wholesale> selectByName(String name);
}
