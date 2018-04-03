package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.Module;

public interface IModuleDao {
    int deleteByPrimaryKey(Integer mId);

    int insert(Module module);

    int insertSelective(Module module);

    Module selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Module module);

    int updateByPrimaryKey(Module module);

    List<Module> selectByNikename(String nikename);

	List<Module> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

}
