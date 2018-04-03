package com.erp.dao.impl;

import com.erp.orm.inter.IPlanDetailMapper;
import com.erp.dao.IPlanDetailDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.PlanDetail;

@Repository("planDetailDao")
public class PlanDetailDaoImpl implements  IPlanDetailDao {
	@Resource
	private IPlanDetailMapper planDetailMapper;


	@Override
	public int deleteByPrimaryKey(Integer pdId){
		return planDetailMapper.deleteByPrimaryKey(pdId);
	}



	@Override
	public int insert(PlanDetail planDetail){
		return planDetailMapper.insert(planDetail);
	}



	@Override
	public int insertSelective(PlanDetail planDetail){
		return planDetailMapper.insertSelective(planDetail);
	}



	@Override
	public PlanDetail selectByPrimaryKey(Integer pdId){
		return planDetailMapper.selectByPrimaryKey(pdId);
	}



	@Override
	public int updateByPrimaryKeySelective(PlanDetail planDetail){
		return planDetailMapper.updateByPrimaryKeySelective(planDetail);
	}



	@Override
	public int updateByPrimaryKey(PlanDetail planDetail){
		return planDetailMapper.updateByPrimaryKey(planDetail);
	}



	@Override
	public List<PlanDetail> selectByName(String name){
		return planDetailMapper.selectByName(name);
	}



	@Override
	public List<PlanDetail> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return planDetailMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return planDetailMapper.selectCount(map);
	}


}
