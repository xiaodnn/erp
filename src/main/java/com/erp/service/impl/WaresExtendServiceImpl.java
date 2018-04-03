/**
 * 
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IWaresExtendDao;
import com.erp.orm.entity.WaresExtend;
import com.erp.service.IWaresExtendService;

/**
 * 商品扩展信息
 *
 * @author scy
 * @date 2016年12月14日
 */
@Service("waresExtendService")
public class WaresExtendServiceImpl implements IWaresExtendService {

	@Resource
	private IWaresExtendDao waresExtendDao;
	
//	/**
//	 * @return the waresExtendDao
//	 */
//	public IWaresExtendDao getWaresExtendDao() {
//		return waresExtendDao;
//	}
//
//	/**
//	 * @param waresExtendDao the waresExtendDao to set
//	 */
//	public void setWaresExtendDao(IWaresExtendDao waresExtendDao) {
//		this.waresExtendDao = waresExtendDao;
//	}

	@Override
	public int delById(String wId) {
		
		return waresExtendDao.deleteByPrimaryKey(wId) ;
	}

	@Override
	public int save(WaresExtend waresExtend) {
		
		return waresExtendDao.insert(waresExtend) ;
	}

	@Override
	public int saveNotNull(WaresExtend waresExtend) {
		
		return waresExtendDao.insertSelective(waresExtend) ;
	}

	@Override
	public WaresExtend findById(String wId) {
		
		return waresExtendDao.selectByPrimaryKey(wId) ;
	}

	@Override
	public int modifyByIdNotNull(WaresExtend waresExtend) {
		
		return waresExtendDao.updateByPrimaryKeySelective(waresExtend) ;
	}

	@Override
	public int modifyById(WaresExtend waresExtend) {
		
		return waresExtendDao.updateByPrimaryKey(waresExtend) ;
	}

}
