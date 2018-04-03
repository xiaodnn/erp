package com.erp.dao.impl;

import com.erp.orm.inter.IStoreHouseMapper;
import com.erp.dao.IStoreHouseDao;
import javax.annotation.Resource;


import com.erp.orm.entity.StoreHouse;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository("storehouseDao")
public class StoreHouseDaoImpl implements IStoreHouseDao {
	@Resource
	private IStoreHouseMapper storehouseMapper;

//	public IStoreHouseMapper getStorehouseMapper() {
//		return storehouseMapper;
//	}
//
//	public void setStorehouseMapper(IStoreHouseMapper storehouseMapper) {
//		this.storehouseMapper = storehouseMapper;
//	}

	@Override
	public int deleteByPrimaryKey(Integer shId){
		return storehouseMapper.deleteByPrimaryKey(shId);
	}



	@Override
	public int insert(StoreHouse storehouse){
		return storehouseMapper.insert(storehouse);
	}



	@Override
	public int insertSelective(StoreHouse storehouse){
		return storehouseMapper.insertSelective(storehouse);
	}



	@Override
	public StoreHouse selectByPrimaryKey(Integer shId){
		return storehouseMapper.selectByPrimaryKey(shId);
	}

	@Override
	public List<StoreHouse> selectAll() {
		return storehouseMapper.selectAll();
	}


	@Override
	public int updateByPrimaryKeySelective(StoreHouse storehouse){
		return storehouseMapper.updateByPrimaryKeySelective(storehouse);
	}



	@Override
	public int updateByPrimaryKey(StoreHouse storehouse){
		return storehouseMapper.updateByPrimaryKey(storehouse);
	}

	@Override
	public StoreHouse selectByCode(String shCode) {
		return storehouseMapper.selectByCode(shCode);
	}

	@Override
	public Integer selectCount() {
		Map<String,Object> map = new HashMap<>();
		return storehouseMapper.selectCount(map);
	}

	@Override
	public List<StoreHouse> selectByPage(Integer page, Integer rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return storehouseMapper.selectByPage(map);
	}

}
