package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.ISalepriceGroupDao;
import com.erp.orm.entity.SalepriceGroup;
import com.erp.service.ISalepriceGroupService;

@Service("salepriceGroupService")
public class SalepriceGroupServiceImpl implements  ISalepriceGroupService {
	@Resource
	private ISalepriceGroupDao salepriceGroupDao;


	@Override
	public int delById(Integer spgId){
		return salepriceGroupDao.deleteByPrimaryKey(spgId);
	}



	@Override
	public int save(SalepriceGroup salepriceGroup){
		return salepriceGroupDao.insert(salepriceGroup);
	}



	@Override
	public int saveNotNull(SalepriceGroup salepriceGroup){
		return salepriceGroupDao.insertSelective(salepriceGroup);
	}



	@Override
	public SalepriceGroup findById(Integer spgId){
		return salepriceGroupDao.selectByPrimaryKey(spgId);
	}



	@Override
	public int modifyByIdNotNull(SalepriceGroup salepriceGroup){
		return salepriceGroupDao.updateByPrimaryKeySelective(salepriceGroup);
	}



	@Override
	public int modifyById(SalepriceGroup salepriceGroup){
		return salepriceGroupDao.updateByPrimaryKey(salepriceGroup);
	}



	@Override
	public List<SalepriceGroup> findByName(String name){
		return salepriceGroupDao.selectByName(name);
	}



	@Override
	public List<SalepriceGroup> findByPage(Integer page, Integer rows){
		return salepriceGroupDao.selectByPage(page, rows);
	}



	@Override
	public Integer findCount( ){
		return salepriceGroupDao.selectCount();
	}


}
