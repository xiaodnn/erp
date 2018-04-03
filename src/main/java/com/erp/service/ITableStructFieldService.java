package com.erp.service;


import java.util.List;

import com.erp.orm.entity.TableStructField;

public interface ITableStructFieldService {
    int delById(Integer tsfId);

    int save(TableStructField tableStructField);

    int saveNotNull(TableStructField tableStructField);

    TableStructField findById(Integer tsfId);

    int modifyByIdNotNull(TableStructField tableStructField);

    int modifyById(TableStructField tableStructField);

	List<TableStructField> findByName(String name);

	List<TableStructField> findByPage(Integer page, Integer rows);

	Integer findCount( );

}
