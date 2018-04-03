package com.erp.dao.impl;

import com.erp.orm.inter.IStoreBatchMapper;
import com.erp.dao.IStoreBatchDao;
import javax.annotation.Resource;


import com.erp.orm.entity.StoreBatch;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("storeBatchDao")
public class StoreBatchDaoImpl implements  IStoreBatchDao {
	@Resource
	private IStoreBatchMapper storeBatchMapper;

//	public IStoreBatchMapper getStoreBatchMapper() {
//		return storeBatchMapper;
//	}
//
//	public void setStoreBatchMapper(IStoreBatchMapper storeBatchMapper) {
//		this.storeBatchMapper = storeBatchMapper;
//	}

	@Override
	public int deleteByPrimaryKey(Integer sbId){
		return storeBatchMapper.deleteByPrimaryKey(sbId);
	}



	@Override
	public int insert(StoreBatch storeBatch){
		return storeBatchMapper.insert(storeBatch);
	}



	@Override
	public int insertSelective(StoreBatch storeBatch){
		return storeBatchMapper.insertSelective(storeBatch);
	}



	@Override
	public StoreBatch selectByPrimaryKey(Integer sbId){
		return storeBatchMapper.selectByPrimaryKey(sbId);
	}



	@Override
	public int updateByPrimaryKeySelective(StoreBatch storeBatch){
		return storeBatchMapper.updateByPrimaryKeySelective(storeBatch);
	}



	@Override
	public int updateByPrimaryKey(StoreBatch storeBatch){
		return storeBatchMapper.updateByPrimaryKey(storeBatch);
	}



	@Override
	public StoreBatch selectByCode(String oCode){
		return storeBatchMapper.selectByCode(oCode);
	}



	@Override
	public List<StoreBatch> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return storeBatchMapper.selectByPage(map);
	}

	@Override
	public Integer selectCount(){
		Map<String, Object> map = new HashMap<String,Object>();
		return storeBatchMapper.selectCount(map);
	}

	@Override
	public int updateAmountById(Integer sbId, Float amount) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sbId",sbId);
		map.put("amount",amount);
		return storeBatchMapper.updateAmountById(map);
	}

}
