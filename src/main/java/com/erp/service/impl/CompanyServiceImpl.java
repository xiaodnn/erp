/**
 * 
 */
package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.erp.dao.ICompanyDao;
import com.erp.orm.entity.Company;
import com.erp.service.ICompanyService;

/**
 *
 *
 * @author scy
 * @date 2016年12月26日
 */
@Service("companyService")
public class CompanyServiceImpl implements ICompanyService {

	@Resource
	private ICompanyDao companyDao;
	
//	/**
//	 * @return the companyDao
//	 */
//	public ICompanyDao getCompanyDao() {
//		return companyDao;
//	}
//
//	/**
//	 * @param companyDao the companyDao to set
//	 */
//	public void setCompanyDao(ICompanyDao companyDao) {
//		this.companyDao = companyDao;
//	}

	/* (non-Javadoc)
	 * @see com.erp.service.ICompanyService#delById(java.lang.String)
	 */
	@Override
	public int delById(String cId) {
		
		return companyDao.deleteByPrimaryKey(cId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.ICompanyService#save(com.erp.orm.entity.Company)
	 */
	@Override
	public int save(Company company) {
		
		return companyDao.insert(company) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.ICompanyService#saveNotNull(com.erp.orm.entity.Company)
	 */
	@Override
	public int saveNotNull(Company company) {
		if(StringUtils.isNotBlank(company.getcId())){
			return companyDao.updateByPrimaryKeySelective(company);
		}else{
			return companyDao.insertSelective(company) ;
		}
	}

	/* (non-Javadoc)
	 * @see com.erp.service.ICompanyService#findById(java.lang.String)
	 */
	@Override
	public Company findById(String cId) {
		
		return companyDao.selectByPrimaryKey(cId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.ICompanyService#finByName(java.lang.String)
	 */
	@Override
	public List<Company> finByName(String cname) {
		
		return companyDao.selectByName(cname) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.ICompanyService#modifyByIdNotNull(com.erp.orm.entity.Company)
	 */
	@Override
	public int modifyByIdNotNull(Company company) {
		
		return companyDao.updateByPrimaryKeySelective(company) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.ICompanyService#modifyById(com.erp.orm.entity.Company)
	 */
	@Override
	public int modifyById(Company company) {
		
		return companyDao.updateByPrimaryKey(company) ;
	}

	@Override
	public List<Company> findByPage(Integer page, Integer rows) {
		return companyDao.selectByPage(page,rows);
	}

	@Override
	public Integer findCount() {
		return companyDao.selectCount();
	}

}
