package com.erp.dao.impl;

import com.erp.orm.inter.IMapUserModuleMapper;
import com.erp.dao.IMapUserModuleDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import com.erp.orm.entity.MapUserModule;
import org.springframework.stereotype.Repository;

@Repository("mapUserModuleDao")
public class MapUserModuleDaoImpl implements  IMapUserModuleDao {
	@Resource
	private IMapUserModuleMapper mapUserModuleMapper;

//	public IMapUserModuleMapper getMapUserModuleMapper() {
//		return mapUserModuleMapper;
//	}
//
//	public void setMapUserModuleMapper(IMapUserModuleMapper mapUserModuleMapper) {
//		this.mapUserModuleMapper = mapUserModuleMapper;
//	}

	@Override
	public int deleteByPrimaryKey(Integer mumId){
		return mapUserModuleMapper.deleteByPrimaryKey(mumId);
	}



	@Override
	public int insert(MapUserModule mapUserModule){
		return mapUserModuleMapper.insert(mapUserModule);
	}



	@Override
	public int insertSelective(MapUserModule mapUserModule){
		return mapUserModuleMapper.insertSelective(mapUserModule);
	}



	@Override
	public MapUserModule selectByPrimaryKey(Integer mumId){
		return mapUserModuleMapper.selectByPrimaryKey(mumId);
	}



	@Override
	public int updateByPrimaryKeySelective(MapUserModule mapUserModule){
		return mapUserModuleMapper.updateByPrimaryKeySelective(mapUserModule);
	}



	@Override
	public int updateByPrimaryKey(MapUserModule mapUserModule){
		return mapUserModuleMapper.updateByPrimaryKey(mapUserModule);
	}



	@Override
	public MapUserModule selectByCode(String oCode){
		return mapUserModuleMapper.selectByCode(oCode);
	}



	@Override
	public List<MapUserModule> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return mapUserModuleMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return mapUserModuleMapper.selectCount(map);
	}


}
