package com.erp.service;


import java.util.List;

import com.erp.orm.entity.MapUserModule;

public interface IMapUserModuleService {
    int delById(Integer mumId);

    int save(MapUserModule mapUserModule);

    int saveNotNull(MapUserModule mapUserModule);

    MapUserModule findById(Integer mumId);

    int modifyByIdNotNull(MapUserModule mapUserModule);

    int modifyById(MapUserModule mapUserModule);

	MapUserModule findByCode(String oCode);

	List<MapUserModule> findByPage(Integer page, Integer rows);

	Integer findCount( );

}
