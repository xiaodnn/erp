package com.erp.dao.impl;

import com.erp.orm.inter.IWaresWholepriceGroupMapper;
import com.erp.dao.IWaresWholepriceGroupDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.WaresWholepriceGroup;
import com.erp.orm.entity.WaresWholepriceGroupKey;

@Repository("waresWholepriceGroupDao")
public class WaresWholepriceGroupDaoImpl implements  IWaresWholepriceGroupDao {
	@Resource
	private IWaresWholepriceGroupMapper waresWholepriceGroupMapper;


	@Override
	public int deleteByPrimaryKey(WaresWholepriceGroupKey key){
		return waresWholepriceGroupMapper.deleteByPrimaryKey(key);
	}



	@Override
	public int insert(WaresWholepriceGroup waresWholepriceGroup){
		return waresWholepriceGroupMapper.insert(waresWholepriceGroup);
	}



	@Override
	public int insertSelective(WaresWholepriceGroup waresWholepriceGroup){
		return waresWholepriceGroupMapper.insertSelective(waresWholepriceGroup);
	}



	@Override
	public WaresWholepriceGroup selectByPrimaryKey(WaresWholepriceGroupKey key){
		return waresWholepriceGroupMapper.selectByPrimaryKey(key);
	}



	@Override
	public int updateByPrimaryKeySelective(WaresWholepriceGroup waresWholepriceGroup){
		return waresWholepriceGroupMapper.updateByPrimaryKeySelective(waresWholepriceGroup);
	}



	@Override
	public int updateByPrimaryKey(WaresWholepriceGroup waresWholepriceGroup){
		return waresWholepriceGroupMapper.updateByPrimaryKey(waresWholepriceGroup);
	}



	@Override
	public List<WaresWholepriceGroup> selectByName(String name){
		return waresWholepriceGroupMapper.selectByName(name);
	}



	@Override
	public List<WaresWholepriceGroup> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return waresWholepriceGroupMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return waresWholepriceGroupMapper.selectCount(map);
	}


}
