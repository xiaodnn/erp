package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IDepartmentDao;
import com.erp.orm.entity.Department;
import com.erp.service.IDepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements  IDepartmentService {
	@Resource
	private IDepartmentDao departmentDao;

//	public IDepartmentDao getDepartmentDao() {
//		return departmentDao;
//	}
//
//	public void setDepartmentDao(IDepartmentDao departmentDao) {
//		this.departmentDao = departmentDao;
//	}

	@Override
	public int delById(Integer dId){
		return departmentDao.deleteByPrimaryKey(dId);
	}



	@Override
	public int save(Department department){
		return departmentDao.insert(department);
	}



	@Override
	public int saveNotNull(Department department){
		return departmentDao.insertSelective(department);
	}



	@Override
	public Department findById(Integer dId){
		return departmentDao.selectByPrimaryKey(dId);
	}



	@Override
	public int modifyByIdNotNull(Department department){
		return departmentDao.updateByPrimaryKeySelective(department);
	}



	@Override
	public int modifyById(Department department){
		return departmentDao.updateByPrimaryKey(department);
	}



	@Override
	public Department findByCode(String oCode){
		return departmentDao.selectByCode(oCode);
	}



	@Override
	public List<Department> findByPage(Integer page, Integer rows){
		return departmentDao.selectByPage(page, rows);
	}



	@Override
	public Integer findCount( ){
		return departmentDao.selectCount();
	}

	@Override
	public List<Department> findAll() {
		return departmentDao.selectAll();
	}


}
