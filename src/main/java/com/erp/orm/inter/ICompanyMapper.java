package com.erp.orm.inter;

import java.util.List;
import java.util.Map;

import com.erp.orm.entity.Company;
import org.springframework.stereotype.Repository;

@Repository("companyMapper")
public interface ICompanyMapper {
	
    int deleteByPrimaryKey(String cId);

    int insert(Company company);

    int insertSelective(Company company);

    Company selectByPrimaryKey(String cId);
    
    List<Company> selectByName(String cname);

    List<Company> selectByPage(Map<String,Integer> map);

    Integer selectCount(Map<String, Object> map);

    int updateByPrimaryKeySelective(Company company);

    int updateByPrimaryKey(Company company);
    
}