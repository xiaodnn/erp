package com.erp.dao.impl;

import com.erp.orm.inter.IWholesaleMapper;
import com.erp.dao.IWholesaleDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import com.erp.orm.entity.Wholesale;
import org.springframework.stereotype.Repository;

@Repository("wholesaleDao")
public class WholesaleDaoImpl implements  IWholesaleDao {
	@Resource
	private IWholesaleMapper wholesaleMapper;

//	public IWholesaleMapper getWholesaleMapper() {
//		return wholesaleMapper;
//	}
//
//	public void setWholesaleMapper(IWholesaleMapper wholesaleMapper) {
//		this.wholesaleMapper = wholesaleMapper;
//	}

	@Override
	public int deleteByPrimaryKey(Integer wsId){
		return wholesaleMapper.deleteByPrimaryKey(wsId);
	}



	@Override
	public int insert(Wholesale wholesale){
		return wholesaleMapper.insert(wholesale);
	}



	@Override
	public int insertSelective(Wholesale wholesale){
		return wholesaleMapper.insertSelective(wholesale);
	}



	@Override
	public Wholesale selectByPrimaryKey(Integer wsId){
		return wholesaleMapper.selectByPrimaryKey(wsId);
	}



	@Override
	public int updateByPrimaryKeySelective(Wholesale wholesale){
		return wholesaleMapper.updateByPrimaryKeySelective(wholesale);
	}



	@Override
	public int updateByPrimaryKey(Wholesale wholesale){
		return wholesaleMapper.updateByPrimaryKey(wholesale);
	}



	@Override
	public Wholesale selectByCode(String oCode){
		return wholesaleMapper.selectByCode(oCode);
	}



	@Override
	public List<Wholesale> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return wholesaleMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return wholesaleMapper.selectCount(map);
	}

	@Override
	public List<Wholesale> selectByName(String name) {
		return wholesaleMapper.selectByName(name);
	}


}
