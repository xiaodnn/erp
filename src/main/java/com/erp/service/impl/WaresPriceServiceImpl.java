/**
 * 
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IWaresPriceDao;
import com.erp.orm.entity.WaresPrice;
import com.erp.service.IWaresPriceService;

/**
 * 商品价格信息
 *
 * @author scy
 * @date 2016年12月14日
 */
@Service("waresPriceService")
public class WaresPriceServiceImpl implements IWaresPriceService {

	@Resource
	private IWaresPriceDao waresPriceDao;
	
//	/**
//	 * @return the waresPriceDao
//	 */
//	public IWaresPriceDao getWaresPriceDao() {
//		return waresPriceDao;
//	}
//
//	/**
//	 * @param waresPriceDao the waresPriceDao to set
//	 */
//	public void setWaresPriceDao(IWaresPriceDao waresPriceDao) {
//		this.waresPriceDao = waresPriceDao;
//	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWaresPriceService#delById(java.lang.String)
	 */
	@Override
	public int delById(String wId) {
		
		return waresPriceDao.deleteByPrimaryKey(wId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWaresPriceService#save(com.erp.orm.entity.WaresPrice)
	 */
	@Override
	public int save(WaresPrice waresPrice) {
		
		return waresPriceDao.insert(waresPrice) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWaresPriceService#saveNotNull(com.erp.orm.entity.WaresPrice)
	 */
	@Override
	public int saveNotNull(WaresPrice waresPrice) {
		
		return waresPriceDao.insertSelective(waresPrice) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWaresPriceService#findById(java.lang.String)
	 */
	@Override
	public WaresPrice findById(String wId) {
		
		return waresPriceDao.selectByPrimaryKey(wId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWaresPriceService#modifyByIdNotNull(com.erp.orm.entity.WaresPrice)
	 */
	@Override
	public int modifyByIdNotNull(WaresPrice waresPrice) {
		
		return waresPriceDao.updateByPrimaryKeySelective(waresPrice) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IWaresPriceService#modifyById(com.erp.orm.entity.WaresPrice)
	 */
	@Override
	public int modifyById(WaresPrice waresPrice) {
		
		return waresPriceDao.updateByPrimaryKey(waresPrice) ;
	}

	@Override
	public int modifyByWid(String wid, Float wCostprice, Float wSaleprice) {
		return waresPriceDao.updateByWid(wid,wCostprice,wSaleprice);
	}

	@Override
	public int saveOrModify(WaresPrice waresPrice) {
		return waresPriceDao.insertOrUpdate(waresPrice);
	}

}
