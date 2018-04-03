package com.erp.dao.impl;

import com.erp.orm.inter.IDepartmentMapper;
import com.erp.dao.IDepartmentDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import com.erp.orm.entity.Department;
import org.springframework.stereotype.Repository;

@Repository("departmentDao")
public class DepartmentDaoImpl implements  IDepartmentDao {
	@Resource
	private IDepartmentMapper departmentMapper;

//	public IDepartmentMapper getDepartmentMapper() {
//		return departmentMapper;
//	}
//
//	public void setDepartmentMapper(IDepartmentMapper departmentMapper) {
//		this.departmentMapper = departmentMapper;
//	}

	@Override
	public int deleteByPrimaryKey(Integer dId){
		return departmentMapper.deleteByPrimaryKey(dId);
	}



	@Override
	public int insert(Department department){
		return departmentMapper.insert(department);
	}



	@Override
	public int insertSelective(Department department){
		return departmentMapper.insertSelective(department);
	}



	@Override
	public Department selectByPrimaryKey(Integer dId){
		return departmentMapper.selectByPrimaryKey(dId);
	}



	@Override
	public int updateByPrimaryKeySelective(Department department){
		return departmentMapper.updateByPrimaryKeySelective(department);
	}



	@Override
	public int updateByPrimaryKey(Department department){
		return departmentMapper.updateByPrimaryKey(department);
	}



	@Override
	public Department selectByCode(String oCode){
		return departmentMapper.selectByCode(oCode);
	}



	@Override
	public List<Department> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return departmentMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return departmentMapper.selectCount(map);
	}

	@Override
	public List<Department> selectAll() {
		return departmentMapper.selectAll();
	}


}
