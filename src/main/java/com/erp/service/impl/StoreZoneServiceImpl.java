package com.erp.service.impl;

import com.erp.dao.IStoreZoneDao;
import com.erp.service.IStoreZoneService;
import javax.annotation.Resource;



import com.erp.orm.entity.StoreZone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("storezoneService")
public class StoreZoneServiceImpl implements  IStoreZoneService {
	@Resource
	private IStoreZoneDao storeZoneDao;

//	public IStoreZoneDao getStoreZoneDao() {
//		return storeZoneDao;
//	}
//
//	public void setStoreZoneDao(IStoreZoneDao storeZoneDao) {
//		this.storeZoneDao = storeZoneDao;
//	}

	@Override
	public int delById(Integer szId){
		return storeZoneDao.deleteByPrimaryKey(szId);
	}



	@Override
	public int save(StoreZone storeZone){
		return storeZoneDao.insert(storeZone);
	}



	@Override
	public int saveNotNull(StoreZone storeZone){
		return storeZoneDao.insertSelective(storeZone);
	}



	@Override
	public StoreZone findById(Integer szId){
		return storeZoneDao.selectByPrimaryKey(szId);
	}



	@Override
	public int modifyByIdNotNull(StoreZone storeZone){
		return storeZoneDao.updateByPrimaryKeySelective(storeZone);
	}



	@Override
	public int modifyById(StoreZone storeZone){
		return storeZoneDao.updateByPrimaryKey(storeZone);
	}



	@Override
	public List<StoreZone> findByPage(Integer page, Integer rows){
		return storeZoneDao.selectByPage(page,rows);
	}



	@Override
	public Integer findCount(){
		return storeZoneDao.selectCount();
	}

	@Override
	public StoreZone findByCode(String szCode) {
		return storeZoneDao.selectByCode(szCode);
	}

}
