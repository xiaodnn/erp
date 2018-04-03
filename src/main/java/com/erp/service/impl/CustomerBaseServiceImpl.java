/**
 * 
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.ICustomerBaseDao;
import com.erp.orm.entity.CustomerBase;
import com.erp.service.ICustomerBaseService;

import java.util.List;

/**
 *
 *
 * @author scy
 * @date 2016年3月10日
 */
@Service("customerBaseService")
public class CustomerBaseServiceImpl implements ICustomerBaseService {

	@Resource	
	private ICustomerBaseDao customerBaseDao;
	
//	/**
//	 * @return the customerBaseDao
//	 */
//	public ICustomerBaseDao getCustomerBaseDao() {
//		return customerBaseDao;
//	}
//
//	/**
//	 * @param customerBaseDao the customerBaseDao to set
//	 */
//	public void setCustomerBaseDao(ICustomerBaseDao customerBaseDao) {
//		this.customerBaseDao = customerBaseDao;
//	}

	/* (non-Javadoc)
	 * @see com.erp.service.ICustomerBaseService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int delById(Integer cId) {
		return customerBaseDao.deleteByPrimaryKey(cId);
	}

	/* (non-Javadoc)
	 * @see com.erp.service.ICustomerBaseService#insert(com.erp.orm.entity.CustomerBase)
	 */
	@Override
	public int save(CustomerBase customerBase) {
		return customerBaseDao.insert(customerBase);
	}

	/* (non-Javadoc)
	 * @see com.erp.service.ICustomerBaseService#insertSelective(com.erp.orm.entity.CustomerBase)
	 */
	@Override
	public int saveNotNull(CustomerBase customerBase) {
		return customerBaseDao.insertSelective(customerBase);
	}

	/* (non-Javadoc)
	 * @see com.erp.service.ICustomerBaseService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public CustomerBase findById(Integer cId) {
		return customerBaseDao.selectByPrimaryKey(cId);
	}

	/* (non-Javadoc)
	 * @see com.erp.service.ICustomerBaseService#updateByPrimaryKeySelective(com.erp.orm.entity.CustomerBase)
	 */
	@Override
	public int modifyByIdNotNull(CustomerBase customerBase) {
		return customerBaseDao.updateByPrimaryKeySelective(customerBase);
	}

	/* (non-Javadoc)
	 * @see com.erp.service.ICustomerBaseService#updateByPrimaryKey(com.erp.orm.entity.CustomerBase)
	 */
	@Override
	public int modifyById(CustomerBase customerBase) {
		return customerBaseDao.updateByPrimaryKey(customerBase);
	}

	@Override
	public List<CustomerBase> findByAll() {
		return customerBaseDao.selectByAll();
	}

}
