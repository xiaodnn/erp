package com.erp.dao.impl;

import com.erp.orm.inter.IModuleMapper;
import com.erp.dao.IModuleDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import com.erp.orm.entity.Module;
import org.springframework.stereotype.Repository;

@Repository("moduleDao")
public class ModuleDaoImpl implements  IModuleDao {
	@Resource
	private IModuleMapper moduleMapper;

//	public IModuleMapper getModuleMapper() {
//		return moduleMapper;
//	}
//
//	public void setModuleMapper(IModuleMapper moduleMapper) {
//		this.moduleMapper = moduleMapper;
//	}

	@Override
	public int deleteByPrimaryKey(Integer mId){
		return moduleMapper.deleteByPrimaryKey(mId);
	}



	@Override
	public int insert(Module module){
		return moduleMapper.insert(module);
	}



	@Override
	public int insertSelective(Module module){
		return moduleMapper.insertSelective(module);
	}



	@Override
	public Module selectByPrimaryKey(Integer mId){
		return moduleMapper.selectByPrimaryKey(mId);
	}



	@Override
	public int updateByPrimaryKeySelective(Module module){
		return moduleMapper.updateByPrimaryKeySelective(module);
	}

	@Override
	public int updateByPrimaryKey(Module module){
		return moduleMapper.updateByPrimaryKey(module);
	}

	@Override
	public List<Module> selectByNikename(String nikename) {
		return moduleMapper.selectByNikename(nikename);
	}

	@Override
	public List<Module> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return moduleMapper.selectByPage(map);
	}

	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return moduleMapper.selectCount(map);
	}


}
