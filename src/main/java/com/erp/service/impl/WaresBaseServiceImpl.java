/**
 * 
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IWaresBaseDao;
import com.erp.orm.entity.WaresBase;
import com.erp.service.IWaresBaseService;

/**
 * 商品基本信息
 *
 * @author scy
 * @date 2016年12月14日
 */
@Service("waresBaseService")
public class WaresBaseServiceImpl implements IWaresBaseService {

	@Resource
	private IWaresBaseDao waresBaseDao;
	
//	/**
//	 * @return the waresBaseDao
//	 */
//	public IWaresBaseDao getWaresBaseDao() {
//		return waresBaseDao;
//	}
//
//	/**
//	 * @param waresBaseDao the waresBaseDao to set
//	 */
//	public void setWaresBaseDao(IWaresBaseDao waresBaseDao) {
//		this.waresBaseDao = waresBaseDao;
//	}

	@Override
	public int delByPrimaryKey(String wId) {
		
		return waresBaseDao.deleteByPrimaryKey(wId) ;
	}

	@Override
	public int save(WaresBase waresBase) {
		
		return waresBaseDao.insert(waresBase) ;
	}

	@Override
	public int saveNotNull(WaresBase waresBase) {
		
		return waresBaseDao.insertSelective(waresBase) ;
	}

	@Override
	public WaresBase findById(String wId) {
		
		return waresBaseDao.selectByPrimaryKey(wId) ;
	}

	@Override
	public int modifyByIdNotNull(WaresBase waresBase) {
		
		return waresBaseDao.updateByPrimaryKeySelective(waresBase) ;
	}

	@Override
	public int modifyById(WaresBase waresBase) {
		
		return waresBaseDao.updateByPrimaryKey(waresBase) ;
	}

}
