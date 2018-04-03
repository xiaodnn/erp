/**
 * 
 */
package com.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.erp.common.Constant;
import com.erp.utils.DataGrid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.erp.common.BaseController;
import com.erp.orm.entity.Company;
import com.erp.service.ICompanyService;
import com.erp.utils.ResultJson;

/**
 * 供应商信息
 *
 * @author scy
 * @date 2016年12月26日
 */
@RestController
@RequestMapping("company")
public class CompanyController extends BaseController {

	@Resource
	private ICompanyService companyService;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("index")
	public ModelAndView index(){
		return new ModelAndView("/company/index");
	}


	@ResponseBody
	@RequestMapping("dg_find")
	public DataGrid dgfind(Integer page, Integer rows){
		if(page == null){
			page = 1;
		}
		page = page -1;

		if(rows == null){
			rows = Constant.ROWS;
		}
		List<Company> companys = companyService.findByPage(page,rows);
		Integer total = companyService.findCount();

		DataGrid dg = new DataGrid();
		dg.setRows(companys);
		dg.setTotal(total);
		return dg;
	}
	@ResponseBody
	@RequestMapping("find_json")
	public List<Company> find(String cname){
		if(cname == null){
			cname = "";
		}
		return companyService.finByName(cname);
	}
	
	@RequestMapping("add")
	public ModelAndView add(String cid){
		Map<String,String> map = new HashMap<String,String>();
		if(StringUtils.isBlank(cid)){
			cid = "@err";
		}
		map.put("cid", cid);
		return new ModelAndView("/company/add",map);
	}
	/**
	 * 打开添加页面
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add_json")
	public Company addJson(String cid){
		Company company = null;
		if( StringUtils.isNotBlank(cid)){
			company = companyService.findById(cid);
		}
		return company;
	}
	/**
	 * 保存供应商信息
	 * @param company
	 * @return
	 */
	@ResponseBody
	@RequestMapping("save")
	public ResultJson save(Company company){
		ResultJson rj = new ResultJson();
		try{
			int n = companyService.saveNotNull(company);
			if(n > 0){
				rj.setSuccess();
				rj.setDesc("保存供应商信息成功");
			}else{
				rj.setDesc("保存供应商信息失败");
			}
		}catch(Exception e){
			rj.setException("保存供应商信息时");
		}
		return rj;
	}
	
	/**
	 * 判断供应商编号是否存在
	 * @param cid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkWid_json")
	public int checkWidJson(String cid){
		Company company = null;
		if(StringUtils.isNotBlank(cid)){
			company = companyService.findById(cid);
		}
		if(company != null && StringUtils.isNotBlank(company.getcId())){
			return 1;
		}
		return 0;
	}
	
	/**
	 * 删除供应商编号信息
	 * @param cid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("del_json")
	public int delJson(String cid){
		int n = 0;
		if(StringUtils.isNotBlank(cid)){
			n = companyService.delById(cid);
		}
		return n;
	}
}

