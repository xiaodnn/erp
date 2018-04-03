package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.ITableStructFieldDao;
import com.erp.orm.entity.TableStructField;
import com.erp.service.ITableStructFieldService;

@Service("tableStructFieldService")
public class TableStructFieldServiceImpl implements  ITableStructFieldService {
	@Resource
	private ITableStructFieldDao tableStructFieldDao;


	@Override
	public int delById(Integer tsfId){
		return tableStructFieldDao.deleteByPrimaryKey(tsfId);
	}



	@Override
	public int save(TableStructField tableStructField){
		return tableStructFieldDao.insert(tableStructField);
	}



	@Override
	public int saveNotNull(TableStructField tableStructField){
		return tableStructFieldDao.insertSelective(tableStructField);
	}



	@Override
	public TableStructField findById(Integer tsfId){
		return tableStructFieldDao.selectByPrimaryKey(tsfId);
	}



	@Override
	public int modifyByIdNotNull(TableStructField tableStructField){
		return tableStructFieldDao.updateByPrimaryKeySelective(tableStructField);
	}



	@Override
	public int modifyById(TableStructField tableStructField){
		return tableStructFieldDao.updateByPrimaryKey(tableStructField);
	}



	@Override
	public List<TableStructField> findByName(String name){
		return tableStructFieldDao.selectByName(name);
	}



	@Override
	public List<TableStructField> findByPage(Integer page, Integer rows){
		return tableStructFieldDao.selectByPage(page, rows);
	}



	@Override
	public Integer findCount( ){
		return tableStructFieldDao.selectCount();
	}


}
