package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.Department;

public interface IDepartmentDao {
    int deleteByPrimaryKey(Integer dId);

    int insert(Department department);

    int insertSelective(Department department);

    Department selectByPrimaryKey(Integer dId);

    int updateByPrimaryKeySelective(Department department);

    int updateByPrimaryKey(Department department);

	Department selectByCode(String oCode);

	List<Department> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

    List<Department> selectAll();
}
