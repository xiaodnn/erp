/**
 * 
 */
package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.Company;

/**
 *
 *
 * @author scy
 * @date 2016年12月25日
 */
public interface ICompanyDao {

    int deleteByPrimaryKey(String cId);

    int insert(Company company);

    int insertSelective(Company company);

    Company selectByPrimaryKey(String cId);
    
    List<Company> selectByName(String cname);

    List<Company> selectByPage(Integer page, Integer rows);

    Integer selectCount();

    int updateByPrimaryKeySelective(Company company);

    int updateByPrimaryKey(Company company);
    
}
