package com.erp.service.impl;

import com.erp.dao.IStoreDetailDao;
import com.erp.service.IStoreDetailService;
import javax.annotation.Resource;



import com.erp.orm.entity.StoreDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("storeDetailService")
public class StoreDetailServiceImpl implements  IStoreDetailService {
	@Resource
	private IStoreDetailDao storeDetailDao;

//	public IStoreDetailDao getStoreDetailDao() {
//		return storeDetailDao;
//	}
//
//	public void setStoreDetailDao(IStoreDetailDao storeDetailDao) {
//		this.storeDetailDao = storeDetailDao;
//	}

	@Override
	public int delById(Integer sdId){
		return storeDetailDao.deleteByPrimaryKey(sdId);
	}



	@Override
	public int save(StoreDetail storeDetail){
		return storeDetailDao.insert(storeDetail);
	}



	@Override
	public int saveNotNull(StoreDetail storeDetail){
		return storeDetailDao.insertSelective(storeDetail);
	}



	@Override
	public StoreDetail findById(Integer sdId){
		return storeDetailDao.selectByPrimaryKey(sdId);
	}



	@Override
	public int modifyByIdNotNull(StoreDetail storeDetail){
		return storeDetailDao.updateByPrimaryKeySelective(storeDetail);
	}



	@Override
	public int modifyById(StoreDetail storeDetail){
		return storeDetailDao.updateByPrimaryKey(storeDetail);
	}

	@Override
	public StoreDetail findByCode(String oCode) {
		return storeDetailDao.selectByCode(oCode);
	}

	@Override
	public List<StoreDetail> findByPage(Integer page, Integer rows) {
		return storeDetailDao.selectByPage(page,rows);
	}

	@Override
	public Integer findCount() {
		return storeDetailDao.selectCount();
	}

	/**
	 * 根据库存主表ID查询库存明细
	 *
	 * @param sId
	 * @return
	 */
	@Override
	public List<StoreDetail> findBySid(Integer sId) {
		return storeDetailDao.selectBySid(sId);
	}

	@Override
	public int modifyAmountById(Integer sdId, Float amount) {
		return storeDetailDao.updateAmountById(sdId, amount);
	}

}
