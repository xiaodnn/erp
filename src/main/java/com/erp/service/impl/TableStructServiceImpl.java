package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.ITableStructDao;
import com.erp.orm.entity.TableStruct;
import com.erp.service.ITableStructService;

@Service("tableStructService")
public class TableStructServiceImpl implements  ITableStructService {
	@Resource
	private ITableStructDao tableStructDao;


	@Override
	public int delById(Integer tsId){
		return tableStructDao.deleteByPrimaryKey(tsId);
	}



	@Override
	public int save(TableStruct tableStruct){
		return tableStructDao.insert(tableStruct);
	}



	@Override
	public int saveNotNull(TableStruct tableStruct){
		return tableStructDao.insertSelective(tableStruct);
	}



	@Override
	public TableStruct findById(Integer tsId){
		return tableStructDao.selectByPrimaryKey(tsId);
	}



	@Override
	public int modifyByIdNotNull(TableStruct tableStruct){
		return tableStructDao.updateByPrimaryKeySelective(tableStruct);
	}

	@Override
	public int modifyById(TableStruct tableStruct){
		return tableStructDao.updateByPrimaryKey(tableStruct);
	}

	@Override
	public List<TableStruct> findByName(String name){
		return tableStructDao.selectByName(name);
	}

	@Override
	public List<TableStruct> findByPage(Integer page, Integer rows){
		return tableStructDao.selectByPage(page, rows);
	}

	@Override
	public Integer findCount( ){
		return tableStructDao.selectCount();
	}

	@Override
	public int createTable(String sql) {
		return tableStructDao.createTable(sql);
	}

	@Override
	public TableStruct findByTsMid(Integer tsMid) {
		return tableStructDao.selectByTsMid(tsMid);
	}


}
