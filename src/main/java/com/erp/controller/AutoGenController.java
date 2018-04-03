/**
 * 
 */
package com.erp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.erp.utils.ResultJson;
import com.gen.AutoGenUtil;

/**
 * 自动生成功能
 * @author scy
 *
 */
@RestController
@RequestMapping("autogen")
public class AutoGenController{

	@RequestMapping("index")
	public ModelAndView login(HttpServletRequest request){

		return  new ModelAndView("/autogen/index");
	}

	/**
	 * 自动生成功能
	 * @param tableName
	 * @param entityName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("gen")
	public ResultJson findName(String tableName,String entityName){

		ResultJson rj = new ResultJson();

		if(tableName == null || "".equals(tableName)){
			rj.setDesc("表名不能为空");
			return rj;
	}
		if(entityName == null || "".equals(entityName)){
			rj.setDesc("实体类名不能为空");
			return rj;
		}

		int n = AutoGenUtil.genMapperToPage(null,null,tableName,entityName);
		if(n > 0){
			rj.setSuccess();
			rj.setDesc("自动生成功能执行成功");
		}else{
			rj.setDesc("自动生成功能执行出现异常");
		}
		return rj;
	}
}
