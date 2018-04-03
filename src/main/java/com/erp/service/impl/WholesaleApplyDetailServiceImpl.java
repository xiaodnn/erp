package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IWholesaleApplyDetailDao;
import com.erp.orm.entity.WholesaleApplyDetail;
import com.erp.service.IWholesaleApplyDetailService;

@Service("wholesaleApplyDetailService")
public class WholesaleApplyDetailServiceImpl implements  IWholesaleApplyDetailService {
	@Resource
	private IWholesaleApplyDetailDao wholesaleApplyDetailDao;

//	public IWholesaleApplyDetailDao getWholesaleApplyDetailDao() {
//		return wholesaleApplyDetailDao;
//	}
//
//	public void setWholesaleApplyDetailDao(IWholesaleApplyDetailDao wholesaleApplyDetailDao) {
//		this.wholesaleApplyDetailDao = wholesaleApplyDetailDao;
//	}

	@Override
	public int delById(Integer wadId){
		return wholesaleApplyDetailDao.deleteByPrimaryKey(wadId);
	}

	@Override
	public int delByWaIdAndWid(String waId, String wId) {
		return wholesaleApplyDetailDao.deleteByWaIdAndWid(waId,wId);
	}


	@Override
	public int save(WholesaleApplyDetail wholesaleApplyDetail){
		return wholesaleApplyDetailDao.insert(wholesaleApplyDetail);
	}



	@Override
	public int saveNotNull(WholesaleApplyDetail wholesaleApplyDetail){
		return wholesaleApplyDetailDao.insertSelective(wholesaleApplyDetail);
	}



	@Override
	public WholesaleApplyDetail findById(Integer wadId){
		return wholesaleApplyDetailDao.selectByPrimaryKey(wadId);
	}



	@Override
	public int modifyByIdNotNull(WholesaleApplyDetail wholesaleApplyDetail){
		return wholesaleApplyDetailDao.updateByPrimaryKeySelective(wholesaleApplyDetail);
	}



	@Override
	public int modifyById(WholesaleApplyDetail wholesaleApplyDetail){
		return wholesaleApplyDetailDao.updateByPrimaryKey(wholesaleApplyDetail);
	}



	@Override
	public WholesaleApplyDetail findByCode(String oCode){
		return wholesaleApplyDetailDao.selectByCode(oCode);
	}



	@Override
	public List<WholesaleApplyDetail> findByPage(Integer page, Integer rows,Integer waId){
		return wholesaleApplyDetailDao.selectByPage(page, rows,waId);
	}



	@Override
	public Integer findCount( ){
		return wholesaleApplyDetailDao.selectCount();
	}

	@Override
	public List<WholesaleApplyDetail> findByName(String name) {
		return wholesaleApplyDetailDao.selectByName(name);
	}


}
