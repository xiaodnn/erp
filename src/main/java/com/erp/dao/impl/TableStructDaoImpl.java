package com.erp.dao.impl;

import com.erp.orm.inter.ITableStructMapper;
import com.erp.dao.ITableStructDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.TableStruct;

@Repository("tableStructDao")
public class TableStructDaoImpl implements  ITableStructDao {
	@Resource
	private ITableStructMapper tableStructMapper;


	@Override
	public int deleteByPrimaryKey(Integer tsId){
		return tableStructMapper.deleteByPrimaryKey(tsId);
	}



	@Override
	public int insert(TableStruct tableStruct){
		return tableStructMapper.insert(tableStruct);
	}



	@Override
	public int insertSelective(TableStruct tableStruct){
		return tableStructMapper.insertSelective(tableStruct);
	}



	@Override
	public TableStruct selectByPrimaryKey(Integer tsId){
		return tableStructMapper.selectByPrimaryKey(tsId);
	}



	@Override
	public int updateByPrimaryKeySelective(TableStruct tableStruct){
		return tableStructMapper.updateByPrimaryKeySelective(tableStruct);
	}



	@Override
	public int updateByPrimaryKey(TableStruct tableStruct){
		return tableStructMapper.updateByPrimaryKey(tableStruct);
	}



	@Override
	public List<TableStruct> selectByName(String name){
		return tableStructMapper.selectByName(name);
	}



	@Override
	public List<TableStruct> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return tableStructMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return tableStructMapper.selectCount(map);
	}



	@Override
	public int createTable(String sql) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("sql", sql);
		return tableStructMapper.createTable(map);
	}



	@Override
	public TableStruct selectByTsMid(Integer tsMid) {
		return tableStructMapper.selectByTsMid(tsMid);
	}


}
