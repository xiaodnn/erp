package com.erp.service.impl;

import com.erp.dao.IOrganDao;
import com.erp.service.IOrganService;
import javax.annotation.Resource;



import com.erp.orm.entity.Organ;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("organService")
public class OrganServiceImpl implements  IOrganService {
	@Resource
	private IOrganDao organDao;
//
//	public IOrganDao getOrganDao() {
//		return organDao;
//	}
//
//	public void setOrganDao(IOrganDao organDao) {
//		this.organDao = organDao;
//	}

	@Override
	public int delById(Integer oId){
		return organDao.deleteByPrimaryKey(oId);
	}



	@Override
	public int save(Organ organ){
		return organDao.insert(organ);
	}



	@Override
	public int saveNotNull(Organ organ){
		return organDao.insertSelective(organ);
	}



	@Override
	public Organ findById(Integer oId){
		return organDao.selectByPrimaryKey(oId);
	}



	@Override
	public int modifyByIdNotNull(Organ organ){
		return organDao.updateByPrimaryKeySelective(organ);
	}



	@Override
	public int modifyById(Organ organ){
		return organDao.updateByPrimaryKey(organ);
	}

	@Override
	public Organ findByCode(String oCode) {
		return organDao.selectByCode(oCode);
	}

	@Override
	public List<?> findByPage(Integer page, Integer rows) {
		return organDao.selectByPage( page, rows);
	}

	@Override
	public Integer findCount() {
		return organDao.selectCount();
	}

	@Override
	public List<Organ> findByName(String oName) {
		return organDao.selectByName(oName);
	}

}
