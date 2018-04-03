/**
 * 
 */
package com.erp.dao.impl;

import javax.annotation.Resource;

import com.erp.dao.ICustomerBaseDao;
import com.erp.orm.entity.CustomerBase;
import com.erp.orm.inter.ICustomerBaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *
 * @author scy
 * @date 2016年3月10日
 */
@Repository("customerBaseDao")
public class CustomerBaseDaoImpl implements ICustomerBaseDao {

	@Resource
	private ICustomerBaseMapper customerBaseMapper;
	
//	/**
//	 * @return the customerBaseMapper
//	 */
//	public ICustomerBaseMapper getCustomerBaseMapper() {
//		return customerBaseMapper;
//	}
//
//	/**
//	 * @param customerBaseMapper the customerBaseMapper to set
//	 */
//	public void setCustomerBaseMapper(ICustomerBaseMapper customerBaseMapper) {
//		this.customerBaseMapper = customerBaseMapper;
//	}

	/* (non-Javadoc)
	 * @see com.erp.dao.ICustomerBaseDao#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer cId) {
		return customerBaseMapper.deleteByPrimaryKey(cId);
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.ICustomerBaseDao#insert(com.erp.orm.entity.CustomerBase)
	 */
	@Override
	public int insert(CustomerBase customerBase) {
		return customerBaseMapper.insert(customerBase);
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.ICustomerBaseDao#insertSelective(com.erp.orm.entity.CustomerBase)
	 */
	@Override
	public int insertSelective(CustomerBase customerBase) {
		return customerBaseMapper.insertSelective(customerBase);
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.ICustomerBaseDao#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public CustomerBase selectByPrimaryKey(Integer cId) {
		return customerBaseMapper.selectByPrimaryKey(cId);
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.ICustomerBaseDao#updateByPrimaryKeySelective(com.erp.orm.entity.CustomerBase)
	 */
	@Override
	public int updateByPrimaryKeySelective(CustomerBase customerBase) {
		return customerBaseMapper.updateByPrimaryKeySelective(customerBase);
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.ICustomerBaseDao#updateByPrimaryKey(com.erp.orm.entity.CustomerBase)
	 */
	@Override
	public int updateByPrimaryKey(CustomerBase customerBase) {
		return customerBaseMapper.updateByPrimaryKey(customerBase);
	}

	@Override
	public List<CustomerBase> selectByAll() {
		return customerBaseMapper.selectByAll();
	}

}
