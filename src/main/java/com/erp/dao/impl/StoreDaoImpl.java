package com.erp.dao.impl;

import com.erp.orm.inter.IStoreMapper;
import com.erp.dao.IStoreDao;
import javax.annotation.Resource;


import com.erp.orm.entity.Store;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("storeDao")
public class StoreDaoImpl implements  IStoreDao {

	@Resource
	private IStoreMapper storeMapper;

//	public IStoreMapper getStoreMapper() {
//		return storeMapper;
//	}
//
//	public void setStoreMapper(IStoreMapper storeMapper) {
//		this.storeMapper = storeMapper;
//	}

	@Override
	public int deleteByPrimaryKey(Integer sId){
		return storeMapper.deleteByPrimaryKey(sId);
	}



	@Override
	public int insert(Store store){
		return storeMapper.insert(store);
	}



	@Override
	public int insertSelective(Store store){
		return storeMapper.insertSelective(store);
	}



	@Override
	public Store selectByPrimaryKey(Integer sId){
		return storeMapper.selectByPrimaryKey(sId);
	}



	@Override
	public int updateByPrimaryKeySelective(Store store){
		return storeMapper.updateByPrimaryKeySelective(store);
	}



	@Override
	public int updateByPrimaryKey(Store store){
		return storeMapper.updateByPrimaryKey(store);
	}

	@Override
	public List<Store> selectByPage(Integer page, Integer rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return storeMapper.selectByPage(map);
	}

	@Override
	public Store selectByCode(String spCode) {
		return storeMapper.selectByCode(spCode);
	}

	@Override
	public Integer selectCount() {
		Map<String, Object> map = new HashMap<String,Object>();
		return storeMapper.selectCount(map);
	}

	@Override
	public int insertOrUpdate(Store store) {
		return storeMapper.insertOrUpdate(store);
	}

	@Override
	public int updateByWid(Store store) {
		return storeMapper.updateByWid(store);
	}

	@Override
	public List<Store> selectByWid(String wId) {
		return storeMapper.selectByWid(wId);
	}

	@Override
	public int updateAmountById(Integer sId, Float amount) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sId",sId);
		map.put("amount",amount);
		return storeMapper.updateAmountById(map);
	}


}
