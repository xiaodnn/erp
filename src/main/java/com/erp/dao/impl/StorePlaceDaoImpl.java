package com.erp.dao.impl;

import com.erp.orm.inter.IStorePlaceMapper;
import com.erp.dao.IStorePlaceDao;
import javax.annotation.Resource;


import com.erp.orm.entity.StorePlace;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository("storeplaceDao")
public class StorePlaceDaoImpl implements IStorePlaceDao {
	@Resource
	private IStorePlaceMapper storeplaceMapper;

//	public IStorePlaceMapper getStoreplaceMapper() {
//		return storeplaceMapper;
//	}
//
//	public void setStoreplaceMapper(IStorePlaceMapper storeplaceMapper) {
//		this.storeplaceMapper = storeplaceMapper;
//	}

	@Override
	public int deleteByPrimaryKey(Integer spId){
		return storeplaceMapper.deleteByPrimaryKey(spId);
	}



	@Override
	public int insert(StorePlace storeplace){
		return storeplaceMapper.insert(storeplace);
	}



	@Override
	public int insertSelective(StorePlace storeplace){
		return storeplaceMapper.insertSelective(storeplace);
	}



	@Override
	public StorePlace selectByPrimaryKey(Integer spId){
		return storeplaceMapper.selectByPrimaryKey(spId);
	}



	@Override
	public int updateByPrimaryKeySelective(StorePlace storeplace){
		return storeplaceMapper.updateByPrimaryKeySelective(storeplace);
	}



	@Override
	public int updateByPrimaryKey(StorePlace storeplace){
		return storeplaceMapper.updateByPrimaryKey(storeplace);
	}

	@Override
	public List<StorePlace> selectByPage(Integer page, Integer rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return storeplaceMapper.selectByPage(map);
	}

	@Override
	public Integer selectCount() {
		Map<String,Object> map = new HashMap<>();
		return storeplaceMapper.selectCount(map);
	}

	@Override
	public StorePlace selectByCode(String shCode) {
		return storeplaceMapper. selectByCode(shCode);
	}

}
