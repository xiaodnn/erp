package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IMapUserModuleDao;
import com.erp.orm.entity.MapUserModule;
import com.erp.service.IMapUserModuleService;

@Service("mapusermoduleService")
public class MapUserModuleServiceImpl implements  IMapUserModuleService {
	@Resource
	private IMapUserModuleDao mapUserModuleDao;

//	public IMapUserModuleDao getMapUserModuleDao() {
//		return mapUserModuleDao;
//	}
//
//	public void setMapUserModuleDao(IMapUserModuleDao mapUserModuleDao) {
//		this.mapUserModuleDao = mapUserModuleDao;
//	}

	@Override
	public int delById(Integer mumId){
		return mapUserModuleDao.deleteByPrimaryKey(mumId);
	}



	@Override
	public int save(MapUserModule mapUserModule){
		return mapUserModuleDao.insert(mapUserModule);
	}



	@Override
	public int saveNotNull(MapUserModule mapUserModule){
		return mapUserModuleDao.insertSelective(mapUserModule);
	}



	@Override
	public MapUserModule findById(Integer mumId){
		return mapUserModuleDao.selectByPrimaryKey(mumId);
	}



	@Override
	public int modifyByIdNotNull(MapUserModule mapUserModule){
		return mapUserModuleDao.updateByPrimaryKeySelective(mapUserModule);
	}



	@Override
	public int modifyById(MapUserModule mapUserModule){
		return mapUserModuleDao.updateByPrimaryKey(mapUserModule);
	}



	@Override
	public MapUserModule findByCode(String oCode){
		return mapUserModuleDao.selectByCode(oCode);
	}



	@Override
	public List<MapUserModule> findByPage(Integer page, Integer rows){
		return mapUserModuleDao.selectByPage(page, rows);
	}



	@Override
	public Integer findCount( ){
		return mapUserModuleDao.selectCount();
	}


}
