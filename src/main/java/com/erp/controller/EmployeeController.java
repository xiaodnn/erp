/**
 * 
 */
package com.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.erp.common.BaseController;
import com.erp.orm.entity.Employee;
import com.erp.service.IEmployeeService;
import com.erp.utils.ResultJson;

/**
 * 员工信息
 * @author scy
 *
 */
@RestController
@RequestMapping("employee")
public class EmployeeController  extends BaseController {

	@Resource
	private IEmployeeService employeeService;

	/**
	 * 员工信息首页
	 * @return
	 */
	@RequestMapping("index")
	public ModelAndView index(){
		return new ModelAndView("/employee/index");
	}

	@ResponseBody
	@RequestMapping("find_json")
	public List<Employee> find(String ename){
		if(ename == null){
			ename = "";
		}
		return employeeService.findByName(ename);
	}

	@RequestMapping("add")
	public ModelAndView add(Integer eid){
		Map<String,Integer> map = new HashMap<String,Integer>();
		if(eid == null || eid == 0){
//			eid = "@err";
			eid = 0;
		}
		map.put("eid", eid);
		return new ModelAndView("/employee/add",map);
	}
	/**
	 * 打开添加页面
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add_json")
	public Employee addJson(Integer eid){
		Employee employee = null;
//		if( StringUtils.isNotBlank(eid)){
		if(eid != null && eid > 0 ){
			employee = employeeService.findById(eid);
		}
		return employee;
	}
	/**
	 * 保存员工信息
	 * @param employee
	 * @return
	 */
	@ResponseBody
	@RequestMapping("save")
	public ResultJson save(Employee employee){
		ResultJson rj = new ResultJson();
		try{
			int n = employeeService.saveNotNull(employee);
			if(n > 0){
				rj.setSuccess();
				rj.setDesc("保存员工信息成功");
			}else{
				rj.setDesc("保存员工信息失败");
			}
		}catch(Exception e){
			rj.setException("保存员工信息时");
		}
		return rj;
	}

	/**
	 * 判断员工编号是否存在
	 * @param eid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkWid_json")
	public int checkWidJson(Integer eid){
		Employee employee = null;
//		if(StringUtils.isNotBlank(eid)){
		if(eid != null && eid > 0){
			employee = employeeService.findById(eid);
		}
//		if(employee != null && StringUtils.isNotBlank(employee.geteId())){
		if(employee != null && employee.geteId() != null && employee.geteId() > 0 ){
			return 1;
		}
		return 0;
	}

	/**
	 * 删除员工编号信息
	 * @param eid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("del_json")
	public int delJson(Integer eid){
		int n = 0;
//		if(StringUtils.isNotBlank(eid)){
		if(eid != null && eid > 0 ){
			n = employeeService.delById(eid);
		}
		return n;
	}
}
