package com.erp.dao.impl;

import com.erp.orm.inter.IIndentMapper;
import com.erp.dao.IIndentDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.Indent;

@Repository("indentDao")
public class IndentDaoImpl implements  IIndentDao {
	@Resource
	private IIndentMapper indentMapper;


	@Override
	public int deleteByPrimaryKey(Integer iId){
		return indentMapper.deleteByPrimaryKey(iId);
	}



	@Override
	public int insert(Indent indent){
		return indentMapper.insert(indent);
	}



	@Override
	public int insertSelective(Indent indent){
		return indentMapper.insertSelective(indent);
	}



	@Override
	public Indent selectByPrimaryKey(Integer iId){
		return indentMapper.selectByPrimaryKey(iId);
	}



	@Override
	public int updateByPrimaryKeySelective(Indent indent){
		return indentMapper.updateByPrimaryKeySelective(indent);
	}



	@Override
	public int updateByPrimaryKey(Indent indent){
		return indentMapper.updateByPrimaryKey(indent);
	}



	@Override
	public List<Indent> selectByName(String name){
		return indentMapper.selectByName(name);
	}



	@Override
	public List<Indent> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return indentMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return indentMapper.selectCount(map);
	}


}
