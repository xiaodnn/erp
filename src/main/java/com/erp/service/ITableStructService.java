package com.erp.service;


import java.util.List;

import com.erp.orm.entity.TableStruct;

public interface ITableStructService {
    int delById(Integer tsId);

    int save(TableStruct tableStruct);

    int saveNotNull(TableStruct tableStruct);

    TableStruct findById(Integer tsId);
    /**
     * 根据主表ID获取子表结构信息
     * @param tsMid
     * @return
     */
    TableStruct findByTsMid(Integer tsMid);    

    int modifyByIdNotNull(TableStruct tableStruct);

    int modifyById(TableStruct tableStruct);

	List<TableStruct> findByName(String name);

	List<TableStruct> findByPage(Integer page, Integer rows);

	Integer findCount( );

	int createTable(String sql);

}
