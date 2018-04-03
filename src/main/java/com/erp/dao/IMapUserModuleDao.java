package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.MapUserModule;

public interface IMapUserModuleDao {
    int deleteByPrimaryKey(Integer mumId);

    int insert(MapUserModule mapUserModule);

    int insertSelective(MapUserModule mapUserModule);

    MapUserModule selectByPrimaryKey(Integer mumId);

    int updateByPrimaryKeySelective(MapUserModule mapUserModule);

    int updateByPrimaryKey(MapUserModule mapUserModule);

	MapUserModule selectByCode(String oCode);

	List<MapUserModule> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

}
