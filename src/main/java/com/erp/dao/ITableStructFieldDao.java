package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.TableStructField;

public interface ITableStructFieldDao {
    int deleteByPrimaryKey(Integer tsfId);

    int insert(TableStructField tableStructField);

    int insertSelective(TableStructField tableStructField);

    TableStructField selectByPrimaryKey(Integer tsfId);

    int updateByPrimaryKeySelective(TableStructField tableStructField);

    int updateByPrimaryKey(TableStructField tableStructField);

	List<TableStructField> selectByName(String name);

	List<TableStructField> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

}
