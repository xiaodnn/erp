package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IWholesaleDetailDao;
import com.erp.orm.entity.WholesaleDetail;
import com.erp.service.IWholesaleDetailService;

@Service("wholesaleDetailService")
public class WholesaleDetailServiceImpl implements  IWholesaleDetailService {
	@Resource
	private IWholesaleDetailDao wholesaleDetailDao;

//	public IWholesaleDetailDao getWholesaleDetailDao() {
//		return wholesaleDetailDao;
//	}
//
//	public void setWholesaleDetailDao(IWholesaleDetailDao wholesaleDetailDao) {
//		this.wholesaleDetailDao = wholesaleDetailDao;
//	}

	@Override
	public int delById(Integer wsdId){
		return wholesaleDetailDao.deleteByPrimaryKey(wsdId);
	}



	@Override
	public int save(WholesaleDetail wholesaleDetail){
		return wholesaleDetailDao.insert(wholesaleDetail);
	}



	@Override
	public int saveNotNull(WholesaleDetail wholesaleDetail){
		return wholesaleDetailDao.insertSelective(wholesaleDetail);
	}



	@Override
	public WholesaleDetail findById(Integer wsdId){
		return wholesaleDetailDao.selectByPrimaryKey(wsdId);
	}



	@Override
	public int modifyByIdNotNull(WholesaleDetail wholesaleDetail){
		return wholesaleDetailDao.updateByPrimaryKeySelective(wholesaleDetail);
	}



	@Override
	public int modifyById(WholesaleDetail wholesaleDetail){
		return wholesaleDetailDao.updateByPrimaryKey(wholesaleDetail);
	}



	@Override
	public WholesaleDetail findByCode(String oCode){
		return wholesaleDetailDao.selectByCode(oCode);
	}



	@Override
	public List<WholesaleDetail> findByPage(Integer page, Integer rows){
		return wholesaleDetailDao.selectByPage(page, rows);
	}



	@Override
	public Integer findCount( ){
		return wholesaleDetailDao.selectCount();
	}

	@Override
	public List<WholesaleDetail> findByName(String name) {
		return wholesaleDetailDao.selectByName(name);
	}

	@Override
	public int delByWsId(Integer wsId) {
		return wholesaleDetailDao.deleteByWsId(wsId);
	}

	@Override
	public int delByWsIdAndWidAndBatchnoAndSbid(Integer wsId, Integer wId, String batchNo, Integer sbId) {
		return wholesaleDetailDao.deleteByWsIdAndWidAndBatchnoAndSbid(wsId,wId,batchNo,sbId);
	}


}
