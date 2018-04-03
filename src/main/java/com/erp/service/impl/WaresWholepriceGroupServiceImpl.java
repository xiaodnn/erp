package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IWaresWholepriceGroupDao;
import com.erp.orm.entity.WaresWholepriceGroup;
import com.erp.orm.entity.WaresWholepriceGroupKey;
import com.erp.service.IWaresWholepriceGroupService;

@Service("waresWholepriceGroupService")
public class WaresWholepriceGroupServiceImpl implements  IWaresWholepriceGroupService {
	@Resource
	private IWaresWholepriceGroupDao waresWholepriceGroupDao;


	@Override
	public int delById(WaresWholepriceGroupKey key){
		return waresWholepriceGroupDao.deleteByPrimaryKey(key);
	}



	@Override
	public int save(WaresWholepriceGroup waresWholepriceGroup){
		return waresWholepriceGroupDao.insert(waresWholepriceGroup);
	}



	@Override
	public int saveNotNull(WaresWholepriceGroup waresWholepriceGroup){
		return waresWholepriceGroupDao.insertSelective(waresWholepriceGroup);
	}



	@Override
	public WaresWholepriceGroup findById(WaresWholepriceGroupKey key){
		return waresWholepriceGroupDao.selectByPrimaryKey(key);
	}



	@Override
	public int modifyByIdNotNull(WaresWholepriceGroup waresWholepriceGroup){
		return waresWholepriceGroupDao.updateByPrimaryKeySelective(waresWholepriceGroup);
	}



	@Override
	public int modifyById(WaresWholepriceGroup waresWholepriceGroup){
		return waresWholepriceGroupDao.updateByPrimaryKey(waresWholepriceGroup);
	}



	@Override
	public List<WaresWholepriceGroup> findByName(String name){
		return waresWholepriceGroupDao.selectByName(name);
	}



	@Override
	public List<WaresWholepriceGroup> findByPage(Integer page, Integer rows){
		return waresWholepriceGroupDao.selectByPage(page, rows);
	}



	@Override
	public Integer findCount( ){
		return waresWholepriceGroupDao.selectCount();
	}


}
