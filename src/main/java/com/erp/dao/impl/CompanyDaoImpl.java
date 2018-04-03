/**
 * 
 */
package com.erp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.erp.dao.ICompanyDao;
import com.erp.orm.entity.Company;
import com.erp.orm.inter.ICompanyMapper;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * @author scy
 * @date 2016年12月26日
 */
@Repository("companyDao")
public class CompanyDaoImpl implements ICompanyDao {
	
	@Resource
	private ICompanyMapper companyMapper;

//	/**
//	 * @return the companyMapper
//	 */
//	public ICompanyMapper getCompanyMapper() {
//		return companyMapper;
//	}
//
//	/**
//	 * @param companyMapper the companyMapper to set
//	 */
//	public void setCompanyMapper(ICompanyMapper companyMapper) {
//		this.companyMapper = companyMapper;
//	}

	/* (non-Javadoc)
	 * @see com.erp.dao.ICompanyDao#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String cId) {
		
		return companyMapper.deleteByPrimaryKey(cId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.ICompanyDao#insert(com.erp.orm.entity.Company)
	 */
	@Override
	public int insert(Company company) {
		
		return companyMapper.insert(company) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.ICompanyDao#insertSelective(com.erp.orm.entity.Company)
	 */
	@Override
	public int insertSelective(Company company) {
		
		return companyMapper.insertSelective(company) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.ICompanyDao#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Company selectByPrimaryKey(String cId) {
		
		return companyMapper.selectByPrimaryKey(cId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.ICompanyDao#selectByName(java.lang.String)
	 */
	@Override
	public List<Company> selectByName(String cname) {
		
		return companyMapper.selectByName(cname) ;
	}

	@Override
	public List<Company> selectByPage(Integer page, Integer rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return companyMapper.selectByPage(map);
	}

	@Override
	public Integer selectCount() {
		Map<String,Object> map = new HashMap<>();
		return companyMapper.selectCount(map);
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.ICompanyDao#updateByPrimaryKeySelective(com.erp.orm.entity.Company)
	 */
	@Override
	public int updateByPrimaryKeySelective(Company company) {
		
		return companyMapper.updateByPrimaryKeySelective(company) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.ICompanyDao#updateByPrimaryKey(com.erp.orm.entity.Company)
	 */
	@Override
	public int updateByPrimaryKey(Company company) {
		
		return companyMapper.updateByPrimaryKey(company) ;
	}

}
