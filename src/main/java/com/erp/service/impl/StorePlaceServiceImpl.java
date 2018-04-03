package com.erp.service.impl;

import com.erp.dao.IStorePlaceDao;
import com.erp.service.IStorePlaceService;
import javax.annotation.Resource;



import com.erp.orm.entity.StorePlace;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("storeplaceService")
public class StorePlaceServiceImpl implements IStorePlaceService {
	@Resource
	private IStorePlaceDao storeplaceDao;

//	public IStorePlaceDao getStoreplaceDao() {
//		return storeplaceDao;
//	}
//
//	public void setStoreplaceDao(IStorePlaceDao storeplaceDao) {
//		this.storeplaceDao = storeplaceDao;
//	}

	@Override
	public int delById(Integer spId){
		return storeplaceDao.deleteByPrimaryKey(spId);
	}



	@Override
	public int save(StorePlace storeplace){
		return storeplaceDao.insert(storeplace);
	}



	@Override
	public int saveNotNull(StorePlace storeplace){
		return storeplaceDao.insertSelective(storeplace);
	}



	@Override
	public StorePlace findById(Integer spId){
		return storeplaceDao.selectByPrimaryKey(spId);
	}



	@Override
	public int modifyByIdNotNull(StorePlace storeplace){
		return storeplaceDao.updateByPrimaryKeySelective(storeplace);
	}



	@Override
	public int modifyById(StorePlace storeplace){
		return storeplaceDao.updateByPrimaryKey(storeplace);
	}


	@Override
	public List<StorePlace> findByPage(Integer page, Integer rows) {
		return storeplaceDao.selectByPage(page,rows);
	}

	@Override
	public Integer findCount() {
		return storeplaceDao.selectCount();
	}

	@Override
	public StorePlace findByCode(String shCode) {
		return  storeplaceDao.selectByCode(shCode);
	}
}
