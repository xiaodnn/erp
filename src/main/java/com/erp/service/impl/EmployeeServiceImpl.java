package com.erp.service.impl;

import com.erp.dao.IEmployeeDao;
import com.erp.orm.entity.Employee;
import com.erp.service.IEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by scy on 2017/4/20.
 */
@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

    @Resource
    private IEmployeeDao employeeDao;

//    public IEmployeeDao getEmployeeDao() {
//        return employeeDao;
//    }
//
//    public void setEmployeeDao(IEmployeeDao employeeDao) {
//        this.employeeDao = employeeDao;
//    }

    @Override
    public int delById(Integer eId) {
        return  employeeDao.deleteByPrimaryKey(eId) ;
    }

    @Override
    public int save(Employee employee) {
        return  employeeDao.insert(employee) ;
    }

    @Override
    public int saveNotNull(Employee employee) {
        return  employeeDao.insertSelective(employee) ;
    }

    @Override
    public Employee findById(Integer eId) {
        return  employeeDao.selectByPrimaryKey(eId) ;
    }

    @Override
    public Employee findByUid(Integer uId) {
        return employeeDao.selectByUid(uId);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeDao.selectByName(name);
    }

    @Override
    public List<Employee> findAll() {
        return  employeeDao.selectAll() ;
    }

    @Override
    public int modifyByIdNotNull(Employee employee) {
        return  employeeDao.updateByPrimaryKeySelective(employee) ;
    }

    @Override
    public int modifyById(Employee employee) {
        return  employeeDao.updateByPrimaryKey(employee) ;
    }
}
