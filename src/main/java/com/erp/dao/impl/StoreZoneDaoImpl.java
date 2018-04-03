package com.erp.dao.impl;

import com.erp.orm.inter.IStoreZoneMapper;
import com.erp.dao.IStoreZoneDao;
import javax.annotation.Resource;


import com.erp.orm.entity.StoreZone;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository("storeZoneDao")
public class StoreZoneDaoImpl implements  IStoreZoneDao {
	@Resource
	private IStoreZoneMapper storeZoneMapper;

//	public IStoreZoneMapper getStoreZoneMapper() {
//		return storeZoneMapper;
//	}
//
//	public void setStoreZoneMapper(IStoreZoneMapper storeZoneMapper) {
//		this.storeZoneMapper = storeZoneMapper;
//	}

	@Override
	public int deleteByPrimaryKey(Integer szId){
		return storeZoneMapper.deleteByPrimaryKey(szId);
	}



	@Override
	public int insert(StoreZone storeZone){
		return storeZoneMapper.insert(storeZone);
	}



	@Override
	public int insertSelective(StoreZone storeZone){
		return storeZoneMapper.insertSelective(storeZone);
	}



	@Override
	public StoreZone selectByPrimaryKey(Integer szId){
		return storeZoneMapper.selectByPrimaryKey(szId);
	}



	@Override
	public int updateByPrimaryKeySelective(StoreZone storeZone){
		return storeZoneMapper.updateByPrimaryKeySelective(storeZone);
	}



	@Override
	public int updateByPrimaryKey(StoreZone storeZone){
		return storeZoneMapper.updateByPrimaryKey(storeZone);
	}



	@Override
	public List<StoreZone> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return storeZoneMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount(){
		Map<String,Object> map = new HashMap<>();
		return storeZoneMapper.selectCount(map);
	}

	@Override
	public StoreZone selectByCode(String szCode) {
		return storeZoneMapper.selectByCode(szCode);
	}

}
