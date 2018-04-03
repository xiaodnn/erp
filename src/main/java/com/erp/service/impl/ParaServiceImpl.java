/**
 * 
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IParaDao;
import com.erp.orm.entity.Para;
import com.erp.service.IParaService;

/**
 *
 * 系统参数
 * @author scy
 * @date 2016年12月6日
 */
@Service("paraService")
public class ParaServiceImpl implements IParaService {

	@Resource
	private IParaDao paraDao;
	
//	/**
//	 * @return the paraDao
//	 */
//	public IParaDao getParaDao() {
//		return paraDao;
//	}
//
//	/**
//	 * @param paraDao the paraDao to set
//	 */
//	public void setParaDao(IParaDao paraDao) {
//		this.paraDao = paraDao;
//	}

	/* (non-Javadoc)
	 * @see com.erp.service.IParaService#delById(java.lang.Integer)
	 */
	@Override
	public int delById(Integer pId) {
		
		return paraDao.deleteByPrimaryKey(pId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IParaService#save(com.erp.orm.entity.Para)
	 */
	@Override
	public int save(Para para) {
		
		return paraDao.insert(para) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IParaService#saveNotNull(com.erp.orm.entity.Para)
	 */
	@Override
	public int saveNotNull(Para para) {
		
		return paraDao.insertSelective(para) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IParaService#findById(java.lang.Integer)
	 */
	@Override
	public Para findById(Integer pId) {
		
		return paraDao.selectByPrimaryKey(pId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IParaService#modifyByIdNotNull(com.erp.orm.entity.Para)
	 */
	@Override
	public int modifyByIdNotNull(Para para) {
		
		return paraDao.updateByPrimaryKeySelective(para) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IParaService#nodifyById(com.erp.orm.entity.Para)
	 */
	@Override
	public int modifyById(Para para) {
		
		return paraDao.updateByPrimaryKey(para) ;
	}

}
