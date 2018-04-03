package com.erp.dao.impl;

import com.erp.orm.inter.IWholepriceGroupMapper;
import com.erp.dao.IWholepriceGroupDao;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

import java.util.List;
import java.util.Map;


import com.erp.orm.entity.WholepriceGroup;

@Repository("wholepriceGroupDao")
public class WholepriceGroupDaoImpl implements  IWholepriceGroupDao {
	@Resource
	private IWholepriceGroupMapper wholepriceGroupMapper;


	@Override
	public int deleteByPrimaryKey(Integer wpgId){
		return wholepriceGroupMapper.deleteByPrimaryKey(wpgId);
	}



	@Override
	public int insert(WholepriceGroup wholepriceGroup){
		return wholepriceGroupMapper.insert(wholepriceGroup);
	}



	@Override
	public int insertSelective(WholepriceGroup wholepriceGroup){
		return wholepriceGroupMapper.insertSelective(wholepriceGroup);
	}



	@Override
	public WholepriceGroup selectByPrimaryKey(Integer wpgId){
		return wholepriceGroupMapper.selectByPrimaryKey(wpgId);
	}



	@Override
	public int updateByPrimaryKeySelective(WholepriceGroup wholepriceGroup){
		return wholepriceGroupMapper.updateByPrimaryKeySelective(wholepriceGroup);
	}



	@Override
	public int updateByPrimaryKey(WholepriceGroup wholepriceGroup){
		return wholepriceGroupMapper.updateByPrimaryKey(wholepriceGroup);
	}



	@Override
	public List<WholepriceGroup> selectByName(String name){
		return wholepriceGroupMapper.selectByName(name);
	}



	@Override
	public List<WholepriceGroup> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return wholepriceGroupMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return wholepriceGroupMapper.selectCount(map);
	}


}
