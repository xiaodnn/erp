package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.WholepriceGroup;

public interface IWholepriceGroupDao {
    int deleteByPrimaryKey(Integer wpgId);

    int insert(WholepriceGroup wholepriceGroup);

    int insertSelective(WholepriceGroup wholepriceGroup);

    WholepriceGroup selectByPrimaryKey(Integer wpgId);

    int updateByPrimaryKeySelective(WholepriceGroup wholepriceGroup);

    int updateByPrimaryKey(WholepriceGroup wholepriceGroup);

    List<WholepriceGroup> selectByName(String name);

	List<WholepriceGroup> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

}
