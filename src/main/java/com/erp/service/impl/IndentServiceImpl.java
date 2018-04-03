package com.erp.service.impl;

import com.erp.dao.IIndentDao;
import com.erp.service.IIndentService;
import javax.annotation.Resource;


import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.Indent;

@Repository("indentService")
public class IndentServiceImpl implements  IIndentService {
	@Resource
	private IIndentDao indentDao;


	@Override
	public int delById(Integer iId){
		return indentDao.deleteByPrimaryKey(iId);
	}



	@Override
	public int save(Indent indent){
		return indentDao.insert(indent);
	}



	@Override
	public int saveNotNull(Indent indent){
		return indentDao.insertSelective(indent);
	}



	@Override
	public Indent findById(Integer iId){
		return indentDao.selectByPrimaryKey(iId);
	}



	@Override
	public int modifyByIdNotNull(Indent indent){
		return indentDao.updateByPrimaryKeySelective(indent);
	}



	@Override
	public int modifyById(Indent indent){
		return indentDao.updateByPrimaryKey(indent);
	}



	@Override
	public List<Indent> findByName(String name){
		return indentDao.selectByName(name);
	}



	@Override
	public List<Indent> findByPage(Integer page, Integer rows){
		return indentDao.selectByPage(page, rows);
	}



	@Override
	public Integer findCount( ){
		return indentDao.selectCount();
	}


}
