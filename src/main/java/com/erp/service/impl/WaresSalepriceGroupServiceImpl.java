package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IWaresSalepriceGroupDao;
import com.erp.orm.entity.WaresSalepriceGroup;
import com.erp.orm.entity.WaresSalepriceGroupKey;
import com.erp.service.IWaresSalepriceGroupService;

@Service("waresSalepriceGroupService")
public class WaresSalepriceGroupServiceImpl implements  IWaresSalepriceGroupService {
	@Resource
	private IWaresSalepriceGroupDao waresSalepriceGroupDao;


	@Override
	public int delById(WaresSalepriceGroupKey key){
		return waresSalepriceGroupDao.deleteByPrimaryKey(key);
	}



	@Override
	public int save(WaresSalepriceGroup waresSalepriceGroup){
		return waresSalepriceGroupDao.insert(waresSalepriceGroup);
	}



	@Override
	public int saveNotNull(WaresSalepriceGroup waresSalepriceGroup){
		return waresSalepriceGroupDao.insertSelective(waresSalepriceGroup);
	}



	@Override
	public WaresSalepriceGroup findById(WaresSalepriceGroupKey key){
		return waresSalepriceGroupDao.selectByPrimaryKey(key);
	}



	@Override
	public int modifyByIdNotNull(WaresSalepriceGroup waresSalepriceGroup){
		return waresSalepriceGroupDao.updateByPrimaryKeySelective(waresSalepriceGroup);
	}



	@Override
	public int modifyById(WaresSalepriceGroup waresSalepriceGroup){
		return waresSalepriceGroupDao.updateByPrimaryKey(waresSalepriceGroup);
	}



	@Override
	public List<WaresSalepriceGroup> findByName(String name){
		return waresSalepriceGroupDao.selectByName(name);
	}



	@Override
	public List<WaresSalepriceGroup> findByPage(Integer page, Integer rows){
		return waresSalepriceGroupDao.selectByPage(page, rows);
	}



	@Override
	public Integer findCount( ){
		return waresSalepriceGroupDao.selectCount();
	}


}
