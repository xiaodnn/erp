package com.erp.orm.inter;
import java.util.List;
import java.util.Map;


import com.erp.orm.entity.Department;
import org.springframework.stereotype.Repository;

@Repository("departmentMapper")
public interface IDepartmentMapper {
    int deleteByPrimaryKey(Integer dId);

    int insert(Department department);

    int insertSelective(Department department);

    Department selectByPrimaryKey(Integer dId);

    int updateByPrimaryKeySelective(Department department);

    int updateByPrimaryKey(Department department);

	Department selectByCode(String oCode);

	List<Department> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

    List<Department> selectAll();

}