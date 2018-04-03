/**
 * 
 */
package com.erp.dao;

import com.erp.orm.entity.CustomerBase;

import java.util.List;

/**
 *
 *
 * @author scy
 * @date 2016年3月10日
 */
public interface ICustomerBaseDao {

	int deleteByPrimaryKey(Integer cId);

    int insert(CustomerBase customerBase);

    int insertSelective(CustomerBase customerBase);

    CustomerBase selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(CustomerBase customerBase);

    int updateByPrimaryKey(CustomerBase customerBase);

    List<CustomerBase> selectByAll();
}
