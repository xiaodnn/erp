package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.TableStruct;

public interface ITableStructDao {
    int deleteByPrimaryKey(Integer tsId);

    int insert(TableStruct tableStruct);

    int insertSelective(TableStruct tableStruct);

    TableStruct selectByPrimaryKey(Integer tsId);

    int updateByPrimaryKeySelective(TableStruct tableStruct);

    int updateByPrimaryKey(TableStruct tableStruct);

	List<TableStruct> selectByName(String name);

	List<TableStruct> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

	int createTable(String sql);

	/**
	 * 根据主表ID获取子表结构信息
	 * @param tsMid
	 * @return
	 */
	TableStruct selectByTsMid(Integer tsMid);
}
