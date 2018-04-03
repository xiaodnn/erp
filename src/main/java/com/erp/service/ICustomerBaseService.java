/**
 * 
 */
package com.erp.service;

import com.erp.orm.entity.CustomerBase;

import java.util.List;

/**
 *
 *
 * @author scy
 * @date 2016年3月10日
 */
public interface ICustomerBaseService {

	int delById(Integer cId);

    int save(CustomerBase customerBase);

    int saveNotNull(CustomerBase customerBase);

    CustomerBase findById(Integer cId);

    int modifyByIdNotNull(CustomerBase customerBase);

    int modifyById(CustomerBase customerBase);

    List<CustomerBase> findByAll();
}
