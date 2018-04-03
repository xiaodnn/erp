package com.erp.dao.impl;

import com.erp.orm.inter.IPlanMapper;
import com.erp.dao.IPlanDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.Plan;

@Repository("planDao")
public class PlanDaoImpl implements  IPlanDao {
	@Resource
	private IPlanMapper planMapper;


	@Override
	public int deleteByPrimaryKey(Integer pId){
		return planMapper.deleteByPrimaryKey(pId);
	}



	@Override
	public int insert(Plan plan){
		return planMapper.insert(plan);
	}



	@Override
	public int insertSelective(Plan plan){
		return planMapper.insertSelective(plan);
	}



	@Override
	public Plan selectByPrimaryKey(Integer pId){
		return planMapper.selectByPrimaryKey(pId);
	}



	@Override
	public int updateByPrimaryKeySelective(Plan plan){
		return planMapper.updateByPrimaryKeySelective(plan);
	}



	@Override
	public int updateByPrimaryKey(Plan plan){
		return planMapper.updateByPrimaryKey(plan);
	}



	@Override
	public List<Plan> selectByName(String name){
		return planMapper.selectByName(name);
	}



	@Override
	public List<Plan> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return planMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return planMapper.selectCount(map);
	}


}
