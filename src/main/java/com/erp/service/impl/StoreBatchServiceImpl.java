package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IStoreBatchDao;
import com.erp.orm.entity.StoreBatch;
import com.erp.service.IStoreBatchService;

@Service("storeBatchService")
public class StoreBatchServiceImpl implements  IStoreBatchService {
	@Resource
	private IStoreBatchDao storeBatchDao;

//	public IStoreBatchDao getStoreBatchDao() {
//		return storeBatchDao;
//	}
//
//	public void setStoreBatchDao(IStoreBatchDao storeBatchDao) {
//		this.storeBatchDao = storeBatchDao;
//	}

	@Override
	public int delById(Integer sbId){
		return storeBatchDao.deleteByPrimaryKey(sbId);
	}



	@Override
	public int save(StoreBatch storeBatch){
		return storeBatchDao.insert(storeBatch);
	}



	@Override
	public int saveNotNull(StoreBatch storeBatch){
		return storeBatchDao.insertSelective(storeBatch);
	}



	@Override
	public StoreBatch findById(Integer sbId){
		return storeBatchDao.selectByPrimaryKey(sbId);
	}



	@Override
	public int modifyByIdNotNull(StoreBatch storeBatch){
		return storeBatchDao.updateByPrimaryKeySelective(storeBatch);
	}



	@Override
	public int modifyById(StoreBatch storeBatch){
		return storeBatchDao.updateByPrimaryKey(storeBatch);
	}



	@Override
	public StoreBatch findByCode(String oCode){
		return storeBatchDao.selectByCode(oCode);
	}

	@Override
	public List<StoreBatch> findByPage(Integer page, Integer rows){
		return storeBatchDao.selectByPage(page,rows);
	}

	@Override
	public Integer findCount(){
		return storeBatchDao.selectCount();
	}

	@Override
	public int modifyAmountById(Integer sbId, Float amount) {
		return storeBatchDao.updateAmountById(sbId, amount);
	}

}
