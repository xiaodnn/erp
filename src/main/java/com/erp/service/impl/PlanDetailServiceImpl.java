package com.erp.service.impl;

import com.erp.dao.IPlanDetailDao;
import com.erp.service.IPlanDetailService;
import javax.annotation.Resource;


import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.PlanDetail;

@Repository("planDetailService")
public class PlanDetailServiceImpl implements  IPlanDetailService {
	@Resource
	private IPlanDetailDao planDetailDao;


	@Override
	public int delById(Integer pdId){
		return planDetailDao.deleteByPrimaryKey(pdId);
	}



	@Override
	public int save(PlanDetail planDetail){
		return planDetailDao.insert(planDetail);
	}



	@Override
	public int saveNotNull(PlanDetail planDetail){
		return planDetailDao.insertSelective(planDetail);
	}



	@Override
	public PlanDetail findById(Integer pdId){
		return planDetailDao.selectByPrimaryKey(pdId);
	}



	@Override
	public int modifyByIdNotNull(PlanDetail planDetail){
		return planDetailDao.updateByPrimaryKeySelective(planDetail);
	}



	@Override
	public int modifyById(PlanDetail planDetail){
		return planDetailDao.updateByPrimaryKey(planDetail);
	}



	@Override
	public List<PlanDetail> findByName(String name){
		return planDetailDao.selectByName(name);
	}



	@Override
	public List<PlanDetail> findByPage(Integer page, Integer rows){
		return planDetailDao.selectByPage(page, rows);
	}



	@Override
	public Integer findCount( ){
		return planDetailDao.selectCount();
	}


}
