/**
 * 
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IWarehousingDetailDao;
import com.erp.orm.entity.WarehousingDetail;
import com.erp.service.IWarehousingDetailService;

/**
 * 入库信息明细
 *
 * @author scy
 * @date 2017年1月2日
 */
@Service("warehousingDetailService")
public class WarehousingDetailServiceImpl implements IWarehousingDetailService {
	
	@Resource
	private IWarehousingDetailDao warehousingDetailDao;
	
//	/**
//	 * @return the warehousingDetailDao
//	 */
//	public IWarehousingDetailDao getWarehousingDetailDao() {
//		return warehousingDetailDao;
//	}
//
//	/**
//	 * @param warehousingDetailDao the warehousingDetailDao to set
//	 */
//	public void setWarehousingDetailDao(IWarehousingDetailDao warehousingDetailDao) {
//		this.warehousingDetailDao = warehousingDetailDao;
//	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWarehousingDetailService#delById(java.lang.Integer)
	 */
	@Override
	public int delById(String whId,String wId) {
		
		return warehousingDetailDao.deleteByPrimaryKey( whId, wId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWarehousingDetailService#save(com.erp.orm.entity.WarehousingDetail)
	 */
	@Override
	public int save(WarehousingDetail warehousingDetail) {
		
		return warehousingDetailDao.insert(warehousingDetail) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWarehousingDetailService#saveNotNull(com.erp.orm.entity.WarehousingDetail)
	 */
	@Override
	public int saveNotNull(WarehousingDetail warehousingDetail) {
		
		return warehousingDetailDao.insertSelective(warehousingDetail) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWarehousingDetailService#findById(java.lang.Integer)
	 */
	@Override
	public WarehousingDetail findById(Integer wdId) {
		
		return warehousingDetailDao.selectByPrimaryKey(wdId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWarehousingDetailService#modifyByIdNotNull(com.erp.orm.entity.WarehousingDetail)
	 */
	@Override
	public int modifyByIdNotNull(WarehousingDetail warehousingDetail) {
		
		return warehousingDetailDao.updateByPrimaryKeySelective(warehousingDetail) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWarehousingDetailService#modifyById(com.erp.orm.entity.WarehousingDetail)
	 */
	@Override
	public int modifyById(WarehousingDetail warehousingDetail) {
		
		return warehousingDetailDao.updateByPrimaryKey(warehousingDetail) ;
	}

}
