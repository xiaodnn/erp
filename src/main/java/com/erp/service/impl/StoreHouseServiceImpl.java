package com.erp.service.impl;

import com.erp.dao.IStoreHouseDao;
import com.erp.service.IStoreHouseService;
import javax.annotation.Resource;



import com.erp.orm.entity.StoreHouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("storehouseService")
public class StoreHouseServiceImpl implements IStoreHouseService {
	@Resource
	private IStoreHouseDao storehouseDao;

//	public IStoreHouseDao getStorehouseDao() {
//		return storehouseDao;
//	}
//
//	public void setStorehouseDao(IStoreHouseDao storehouseDao) {
//		this.storehouseDao = storehouseDao;
//	}

	@Override
	public int delById(Integer shId){
		return storehouseDao.deleteByPrimaryKey(shId);
	}



	@Override
	public int save(StoreHouse storehouse){
		return storehouseDao.insert(storehouse);
	}



	@Override
	public int saveNotNull(StoreHouse storehouse){
		return storehouseDao.insertSelective(storehouse);
	}



	@Override
	public StoreHouse findById(Integer shId){
		return storehouseDao.selectByPrimaryKey(shId);
	}

	@Override
	public List<StoreHouse> findAll() {
		return storehouseDao.selectAll();
	}


	@Override
	public int modifyByIdNotNull(StoreHouse storehouse){
		return storehouseDao.updateByPrimaryKeySelective(storehouse);
	}



	@Override
	public int modifyById(StoreHouse storehouse){
		return storehouseDao.updateByPrimaryKey(storehouse);
	}

	@Override
	public List<StoreHouse> findByPage(Integer page, Integer rows) {
		return storehouseDao.selectByPage(page,rows);
	}

	@Override
	public Integer findCount() {
		return storehouseDao.selectCount();
	}

	@Override
	public StoreHouse findByCode(String shCode) {
		return  storehouseDao.selectByCode(shCode);
	}

}
