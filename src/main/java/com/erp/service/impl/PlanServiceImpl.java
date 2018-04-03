package com.erp.service.impl;

import com.erp.dao.IPlanDao;
import com.erp.service.IPlanService;
import javax.annotation.Resource;


import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.Plan;

@Repository("planService")
public class PlanServiceImpl implements  IPlanService {
	@Resource
	private IPlanDao planDao;


	@Override
	public int delById(Integer pId){
		return planDao.deleteByPrimaryKey(pId);
	}



	@Override
	public int save(Plan plan){
		return planDao.insert(plan);
	}



	@Override
	public int saveNotNull(Plan plan){
		return planDao.insertSelective(plan);
	}



	@Override
	public Plan findById(Integer pId){
		return planDao.selectByPrimaryKey(pId);
	}



	@Override
	public int modifyByIdNotNull(Plan plan){
		return planDao.updateByPrimaryKeySelective(plan);
	}



	@Override
	public int modifyById(Plan plan){
		return planDao.updateByPrimaryKey(plan);
	}



	@Override
	public List<Plan> findByName(String name){
		return planDao.selectByName(name);
	}



	@Override
	public List<Plan> findByPage(Integer page, Integer rows){
		return planDao.selectByPage(page, rows);
	}



	@Override
	public Integer findCount( ){
		return planDao.selectCount();
	}


}
