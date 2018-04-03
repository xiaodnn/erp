package com.erp.dao.impl;

import com.erp.orm.inter.IWaresSalepriceGroupMapper;
import com.erp.dao.IWaresSalepriceGroupDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.WaresSalepriceGroup;
import com.erp.orm.entity.WaresSalepriceGroupKey;

@Repository("waresSalepriceGroupDao")
public class WaresSalepriceGroupDaoImpl implements  IWaresSalepriceGroupDao {
	@Resource
	private IWaresSalepriceGroupMapper waresSalepriceGroupMapper;


	@Override
	public int deleteByPrimaryKey(WaresSalepriceGroupKey key){
		return waresSalepriceGroupMapper.deleteByPrimaryKey(key);
	}



	@Override
	public int insert(WaresSalepriceGroup waresSalepriceGroup){
		return waresSalepriceGroupMapper.insert(waresSalepriceGroup);
	}



	@Override
	public int insertSelective(WaresSalepriceGroup waresSalepriceGroup){
		return waresSalepriceGroupMapper.insertSelective(waresSalepriceGroup);
	}



	@Override
	public WaresSalepriceGroup selectByPrimaryKey(WaresSalepriceGroupKey key){
		return waresSalepriceGroupMapper.selectByPrimaryKey(key);
	}



	@Override
	public int updateByPrimaryKeySelective(WaresSalepriceGroup waresSalepriceGroup){
		return waresSalepriceGroupMapper.updateByPrimaryKeySelective(waresSalepriceGroup);
	}



	@Override
	public int updateByPrimaryKey(WaresSalepriceGroup waresSalepriceGroup){
		return waresSalepriceGroupMapper.updateByPrimaryKey(waresSalepriceGroup);
	}



	@Override
	public List<WaresSalepriceGroup> selectByName(String name){
		return waresSalepriceGroupMapper.selectByName(name);
	}



	@Override
	public List<WaresSalepriceGroup> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return waresSalepriceGroupMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return waresSalepriceGroupMapper.selectCount(map);
	}


}
