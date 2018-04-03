package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IWholepriceGroupDao;
import com.erp.orm.entity.WholepriceGroup;
import com.erp.service.IWholepriceGroupService;

@Service("wholepricegroupService")
public class WholepriceGroupServiceImpl implements  IWholepriceGroupService {
	@Resource
	private IWholepriceGroupDao wholepriceGroupDao;


	@Override
	public int delById(Integer wpgId){
		return wholepriceGroupDao.deleteByPrimaryKey(wpgId);
	}



	@Override
	public int save(WholepriceGroup wholepriceGroup){
		return wholepriceGroupDao.insert(wholepriceGroup);
	}



	@Override
	public int saveNotNull(WholepriceGroup wholepriceGroup){
		return wholepriceGroupDao.insertSelective(wholepriceGroup);
	}



	@Override
	public WholepriceGroup findById(Integer wpgId){
		return wholepriceGroupDao.selectByPrimaryKey(wpgId);
	}



	@Override
	public int modifyByIdNotNull(WholepriceGroup wholepriceGroup){
		return wholepriceGroupDao.updateByPrimaryKeySelective(wholepriceGroup);
	}



	@Override
	public int modifyById(WholepriceGroup wholepriceGroup){
		return wholepriceGroupDao.updateByPrimaryKey(wholepriceGroup);
	}



	@Override
	public List<WholepriceGroup> findByName(String name){
		return wholepriceGroupDao.selectByName(name);
	}



	@Override
	public List<WholepriceGroup> findByPage(Integer page, Integer rows){
		return wholepriceGroupDao.selectByPage(page, rows);
	}



	@Override
	public Integer findCount( ){
		return wholepriceGroupDao.selectCount();
	}


}
