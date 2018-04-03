package com.erp.dao;

import com.erp.orm.entity.Employee;

import java.util.List;

/**
 * Created by scy on 2017/4/20.
 */
public interface IEmployeeDao {

    int deleteByPrimaryKey(Integer eId);

    int insert(Employee employee);

    int insertSelective(Employee employee);

    Employee selectByPrimaryKey(Integer eId);

    Employee  selectByUid(Integer uId);

    List<Employee> selectByName(String name);

    List<Employee> selectAll();

    int updateByPrimaryKeySelective(Employee employee);

    int updateByPrimaryKey(Employee employee);
}
