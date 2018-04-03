package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IModuleDao;
import com.erp.orm.entity.Module;
import com.erp.service.IModuleService;

@Service("moduleService")
public class ModuleServiceImpl implements  IModuleService {
	@Resource
	private IModuleDao moduleDao;

//	public IModuleDao getModuleDao() {
//		return moduleDao;
//	}
//
//	public void setModuleDao(IModuleDao moduleDao) {
//		this.moduleDao = moduleDao;
//	}

	@Override
	public int delById(Integer mId){
		return moduleDao.deleteByPrimaryKey(mId);
	}



	@Override
	public int save(Module module){
		return moduleDao.insert(module);
	}



	@Override
	public int saveNotNull(Module module){
		return moduleDao.insertSelective(module);
	}



	@Override
	public Module findById(Integer mId){
		return moduleDao.selectByPrimaryKey(mId);
	}



	@Override
	public int modifyByIdNotNull(Module module){
		return moduleDao.updateByPrimaryKeySelective(module);
	}



	@Override
	public int modifyById(Module module){
		return moduleDao.updateByPrimaryKey(module);
	}

	@Override
	public List<Module> findByNikename(String nikename) {
		return moduleDao.selectByNikename(nikename);
	}

	@Override
	public List<Module> findByPage(Integer page, Integer rows){
		return moduleDao.selectByPage(page, rows);
	}



	@Override
	public Integer findCount( ){
		return moduleDao.selectCount();
	}


}
