package com.erp.dao.impl;

import com.erp.orm.inter.ITableStructFieldMapper;
import com.erp.dao.ITableStructFieldDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.TableStructField;

@Repository("tableStructFieldDao")
public class TableStructFieldDaoImpl implements  ITableStructFieldDao {
	@Resource
	private ITableStructFieldMapper tableStructFieldMapper;


	@Override
	public int deleteByPrimaryKey(Integer tsfId){
		return tableStructFieldMapper.deleteByPrimaryKey(tsfId);
	}



	@Override
	public int insert(TableStructField tableStructField){
		return tableStructFieldMapper.insert(tableStructField);
	}



	@Override
	public int insertSelective(TableStructField tableStructField){
		return tableStructFieldMapper.insertSelective(tableStructField);
	}



	@Override
	public TableStructField selectByPrimaryKey(Integer tsfId){
		return tableStructFieldMapper.selectByPrimaryKey(tsfId);
	}



	@Override
	public int updateByPrimaryKeySelective(TableStructField tableStructField){
		return tableStructFieldMapper.updateByPrimaryKeySelective(tableStructField);
	}



	@Override
	public int updateByPrimaryKey(TableStructField tableStructField){
		return tableStructFieldMapper.updateByPrimaryKey(tableStructField);
	}



	@Override
	public List<TableStructField> selectByName(String name){
		return tableStructFieldMapper.selectByName(name);
	}



	@Override
	public List<TableStructField> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return tableStructFieldMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return tableStructFieldMapper.selectCount(map);
	}


}
