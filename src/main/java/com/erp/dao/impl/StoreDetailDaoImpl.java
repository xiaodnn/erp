package com.erp.dao.impl;

import com.erp.orm.inter.IStoreDetailMapper;
import com.erp.dao.IStoreDetailDao;
import javax.annotation.Resource;


import com.erp.orm.entity.StoreDetail;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository("storeDetailDao")
public class StoreDetailDaoImpl implements  IStoreDetailDao {
	@Resource
	private IStoreDetailMapper storeDetailMapper;

//	public IStoreDetailMapper getStoreDetailMapper() {
//		return storeDetailMapper;
//	}
//
//	public void setStoreDetailMapper(IStoreDetailMapper storeDetailMapper) {
//		this.storeDetailMapper = storeDetailMapper;
//	}

	@Override
	public int deleteByPrimaryKey(Integer sdId){
		return storeDetailMapper.deleteByPrimaryKey(sdId);
	}



	@Override
	public int insert(StoreDetail storeDetail){
		return storeDetailMapper.insert(storeDetail);
	}



	@Override
	public int insertSelective(StoreDetail storeDetail){
		return storeDetailMapper.insertSelective(storeDetail);
	}



	@Override
	public StoreDetail selectByPrimaryKey(Integer sdId){
		return storeDetailMapper.selectByPrimaryKey(sdId);
	}



	@Override
	public int updateByPrimaryKeySelective(StoreDetail storeDetail){
		return storeDetailMapper.updateByPrimaryKeySelective(storeDetail);
	}



	@Override
	public int updateByPrimaryKey(StoreDetail storeDetail){
		return storeDetailMapper.updateByPrimaryKey(storeDetail);
	}

	@Override
	public StoreDetail selectByCode(String oCode) {
		return storeDetailMapper.selectByCode(oCode);
	}

	@Override
	public List<StoreDetail> selectByPage(Integer page, Integer rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return storeDetailMapper.selectByPage(map);
	}

	@Override
	public Integer selectCount() {
		Map<String,Object> map = new HashMap<>();
		return storeDetailMapper.selectCount(map);
	}

	@Override
	public List<StoreDetail> selectBySid(Integer sId) {
		return storeDetailMapper.selectBySid(sId);
	}

	@Override
	public int updateAmountById(Integer sdId, Float amount) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sdId",sdId);
		map.put("amount",amount);
		return storeDetailMapper.updateAmountById(map);
	}

}
