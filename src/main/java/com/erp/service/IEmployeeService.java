package com.erp.service;

import com.erp.orm.entity.Employee;

import java.util.List;

/**
 * Created by scy on 2017/4/20.
 */
public interface IEmployeeService {

    int delById(Integer eId);

    int save(Employee employee);

    int saveNotNull(Employee employee);

    Employee findById(Integer eId);

    Employee findByUid(Integer uId);

    List<Employee> findByName(String name);

    List<Employee> findAll();

    int modifyByIdNotNull(Employee employee);

    int modifyById(Employee employee);

}
