package com.erp.service.impl;

import com.erp.dao.IStoreDao;
import com.erp.service.IStoreService;
import javax.annotation.Resource;



import com.erp.orm.entity.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("storeService")
public class StoreServiceImpl implements  IStoreService {
	@Resource
	private IStoreDao storeDao;

//	public IStoreDao getStoreDao() {
//		return storeDao;
//	}
//
//	public void setStoreDao(IStoreDao storeDao) {
//		this.storeDao = storeDao;
//	}

	@Override
	public int delById(Integer sId){
		return storeDao.deleteByPrimaryKey(sId);
	}



	@Override
	public int save(Store store){
		return storeDao.insert(store);
	}



	@Override
	public int saveNotNull(Store store){
		return storeDao.insertSelective(store);
	}



	@Override
	public Store findById(Integer sId){
		return storeDao.selectByPrimaryKey(sId);
	}



	@Override
	public int modifyByIdNotNull(Store store){
		return storeDao.updateByPrimaryKeySelective(store);
	}



	@Override
	public int modifyById(Store store){
		return storeDao.updateByPrimaryKey(store);
	}

	@Override
	public Store findByCode(String oCode) {
		return storeDao.selectByCode(oCode);
	}

	@Override
	public List<Store> findByPage(Integer page, Integer rows) {
		return storeDao.selectByPage(page,rows);
	}

	@Override
	public Integer findCount() {
		return storeDao.selectCount();
	}

	@Override
	public int saveOrModify(Store store) {
		return storeDao.insertOrUpdate(store);
	}

	@Override
	public int modifyByWid(Store store) {
		return storeDao.updateByWid(store);
	}

	@Override
	public List<Store> findByWid(String wId) {
		return storeDao.selectByWid(wId);
	}

	@Override
	public int modifyAmountById(Integer sId, Float amount) {
		return storeDao.updateAmountById(sId, amount);
	}

}
