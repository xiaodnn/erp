package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IWholesaleApplyDao;
import com.erp.orm.entity.WholesaleApply;
import com.erp.service.IWholesaleApplyService;

@Service("wholesaleApplyService")
public class WholesaleApplyServiceImpl implements  IWholesaleApplyService {
	@Resource
	private IWholesaleApplyDao wholesaleApplyDao;

//	public IWholesaleApplyDao getWholesaleApplyDao() {
//		return wholesaleApplyDao;
//	}
//
//	public void setWholesaleApplyDao(IWholesaleApplyDao wholesaleApplyDao) {
//		this.wholesaleApplyDao = wholesaleApplyDao;
//	}

	@Override
	public int delById(Integer waId){
		return wholesaleApplyDao.deleteByPrimaryKey(waId);
	}



	@Override
	public int save(WholesaleApply wholesaleApply){
		return wholesaleApplyDao.insert(wholesaleApply);
	}



	@Override
	public int saveNotNull(WholesaleApply wholesaleApply){
		return wholesaleApplyDao.insertSelective(wholesaleApply);
	}



	@Override
	public WholesaleApply findById(Integer waId){
		return wholesaleApplyDao.selectByPrimaryKey(waId);
	}



	@Override
	public int modifyByIdNotNull(WholesaleApply wholesaleApply){
		return wholesaleApplyDao.updateByPrimaryKeySelective(wholesaleApply);
	}



	@Override
	public int modifyById(WholesaleApply wholesaleApply){
		return wholesaleApplyDao.updateByPrimaryKey(wholesaleApply);
	}



	@Override
	public WholesaleApply findByCode(String oCode){
		return wholesaleApplyDao.selectByCode(oCode);
	}



	@Override
	public List<WholesaleApply> findByPage(Integer page, Integer rows,Integer waId){
		return wholesaleApplyDao.selectByPage(page, rows,waId);
	}



	@Override
	public Integer findCount( ){
		return wholesaleApplyDao.selectCount();
	}

	@Override
	public List<WholesaleApply> findByName(String name) {
		return wholesaleApplyDao.selectByName(name);
	}


}
