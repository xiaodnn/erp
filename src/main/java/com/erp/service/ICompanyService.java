/**
 * 
 */
package com.erp.service;

import java.util.List;

import com.erp.orm.entity.Company;

/**
 *
 *
 * @author scy
 * @date 2016年12月26日
 */
public interface ICompanyService {

    int delById(String cId);

    int save(Company company);

    int saveNotNull(Company company);

    Company findById(String cId);
    
    List<Company> finByName(String cname);

    int modifyByIdNotNull(Company company);

    int modifyById(Company company);

    List<Company> findByPage(Integer page, Integer rows);

    Integer findCount();
}
