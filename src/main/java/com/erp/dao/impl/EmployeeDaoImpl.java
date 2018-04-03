package com.erp.dao.impl;

import com.erp.dao.IEmployeeDao;
import com.erp.orm.entity.Employee;
import com.erp.orm.inter.IEmployeeMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by scy on 2017/4/20.
 */
@Repository("employeeDao")
public class EmployeeDaoImpl implements IEmployeeDao {

    @Resource
    private IEmployeeMapper employeeMapper;

//    public IEmployeeMapper getEmployeeMapper() {
//        return employeeMapper;
//    }
//
//    public void setEmployeeMapper(IEmployeeMapper employeeMapper) {
//        this.employeeMapper = employeeMapper;
//    }

    @Override
    public int deleteByPrimaryKey(Integer eId) {
        return employeeMapper.deleteByPrimaryKey(eId) ;
    }

    @Override
    public int insert(Employee employee) {
        return employeeMapper.insert(employee) ;
    }

    @Override
    public int insertSelective(Employee employee) {
        return employeeMapper.insertSelective(employee) ;
    }

    @Override
    public Employee selectByPrimaryKey(Integer eId) {
        return employeeMapper.selectByPrimaryKey(eId);
    }

    @Override
    public Employee selectByUid(Integer uId) {
        return employeeMapper.selectByUid(uId);
    }

    @Override
    public List<Employee> selectByName(String name) {
        return employeeMapper.selectByName(name);
    }

    @Override
    public List<Employee> selectAll() {
        return employeeMapper.selectAll() ;
    }

    @Override
    public int updateByPrimaryKeySelective(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee) ;
    }

    @Override
    public int updateByPrimaryKey(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }
}
