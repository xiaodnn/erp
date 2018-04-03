package com.erp.service;


import java.util.List;

import com.erp.orm.entity.Department;

public interface IDepartmentService {
    int delById(Integer dId);

    int save(Department department);

    int saveNotNull(Department department);

    Department findById(Integer dId);

    int modifyByIdNotNull(Department department);

    int modifyById(Department department);

	Department findByCode(String oCode);

	List<Department> findByPage(Integer page, Integer rows);

	Integer findCount( );

    List<Department> findAll();
}
