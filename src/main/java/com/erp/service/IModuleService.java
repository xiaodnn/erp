package com.erp.service;


import java.util.List;

import com.erp.orm.entity.Module;

public interface IModuleService {
    int delById(Integer mId);

    int save(Module module);

    int saveNotNull(Module module);

    Module findById(Integer mId);

    int modifyByIdNotNull(Module module);

    int modifyById(Module module);

    List<Module> findByNikename(String nikename);

	List<Module> findByPage(Integer page, Integer rows);

	Integer findCount( );

}
