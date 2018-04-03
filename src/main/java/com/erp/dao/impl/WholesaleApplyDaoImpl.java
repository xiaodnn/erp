package com.erp.dao.impl;

import com.erp.orm.inter.IWholesaleApplyMapper;
import com.erp.dao.IWholesaleApplyDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import com.erp.orm.entity.WholesaleApply;
import org.springframework.stereotype.Repository;

@Repository("wholesaleApplyDao")
public class WholesaleApplyDaoImpl implements  IWholesaleApplyDao {
	@Resource
	private IWholesaleApplyMapper wholesaleApplyMapper;

//	public IWholesaleApplyMapper getWholesaleApplyMapper() {
//		return wholesaleApplyMapper;
//	}
//
//	public void setWholesaleApplyMapper(IWholesaleApplyMapper wholesaleApplyMapper) {
//		this.wholesaleApplyMapper = wholesaleApplyMapper;
//	}

	@Override
	public int deleteByPrimaryKey(Integer waId){
		return wholesaleApplyMapper.deleteByPrimaryKey(waId);
	}



	@Override
	public int insert(WholesaleApply wholesaleApply){
		return wholesaleApplyMapper.insert(wholesaleApply);
	}



	@Override
	public int insertSelective(WholesaleApply wholesaleApply){
		return wholesaleApplyMapper.insertSelective(wholesaleApply);
	}



	@Override
	public WholesaleApply selectByPrimaryKey(Integer waId){
		return wholesaleApplyMapper.selectByPrimaryKey(waId);
	}



	@Override
	public int updateByPrimaryKeySelective(WholesaleApply wholesaleApply){
		return wholesaleApplyMapper.updateByPrimaryKeySelective(wholesaleApply);
	}



	@Override
	public int updateByPrimaryKey(WholesaleApply wholesaleApply){
		return wholesaleApplyMapper.updateByPrimaryKey(wholesaleApply);
	}



	@Override
	public WholesaleApply selectByCode(String oCode){
		return wholesaleApplyMapper.selectByCode(oCode);
	}



	@Override
	public List<WholesaleApply> selectByPage(Integer page, Integer rows,Integer waId){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		map.put("waId",waId);
		return wholesaleApplyMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return wholesaleApplyMapper.selectCount(map);
	}

	@Override
	public List<WholesaleApply> selectByName(String name) {
		return wholesaleApplyMapper.selectByName(name);
	}


}
