package com.erp.orm.inter;

import com.erp.orm.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeMapper")
public interface IEmployeeMapper {
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