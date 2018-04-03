package com.erp.dao.impl;

import com.erp.orm.inter.IOrganMapper;
import com.erp.dao.IOrganDao;
import javax.annotation.Resource;


import com.erp.orm.entity.Organ;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository("organDao")
public class OrganDaoImpl implements  IOrganDao {
	@Resource
	private IOrganMapper organMapper;
//
//	public IOrganMapper getOrganMapper() {
//		return organMapper;
//	}
//
//	public void setOrganMapper(IOrganMapper organMapper) {
//		this.organMapper = organMapper;
//	}

	@Override
	public int deleteByPrimaryKey(Integer oId){
		return organMapper.deleteByPrimaryKey(oId);
	}



	@Override
	public int insert(Organ organ){
		return organMapper.insert(organ);
	}



	@Override
	public int insertSelective(Organ organ){
		return organMapper.insertSelective(organ);
	}



	@Override
	public Organ selectByPrimaryKey(Integer oId){
		return organMapper.selectByPrimaryKey(oId);
	}



	@Override
	public int updateByPrimaryKeySelective(Organ organ){
		return organMapper.updateByPrimaryKeySelective(organ);
	}



	@Override
	public int updateByPrimaryKey(Organ organ){
		return organMapper.updateByPrimaryKey(organ);
	}

	@Override
	public List<Organ> selectByName(String oName) {
		return organMapper.selectByName(oName);
	}

	@Override
	public Organ selectByCode(String oCode) {
		return organMapper.selectByCode(oCode);
	}

	@Override
	public List<?> selectByPage(Integer page, Integer rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return organMapper.selectByPage(map);
	}

	@Override
	public Integer selectCount() {
		Map<String,Object> map = new HashMap<>();
		return organMapper.selectCount(map);
	}

}
