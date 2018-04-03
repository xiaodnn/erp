/**
 * 
 */
package com.erp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.erp.common.BaseController;
import com.erp.orm.entity.Distributor;

/**
 *
 * 供应商
 * @author scy
 * @date 2016年2月20日
 */
@RestController
@RequestMapping("distributor")
public class DistributorController extends BaseController {
	
	@RequestMapping("index")
	public ModelAndView index(){
		
		loggerInfo(this.getClass(),"打开供应商首页");
		
		return new ModelAndView("/distributor/index");
	}
	
	@RequestMapping("add")
	public ModelAndView adddistributor(Distributor distributor){
		
		
		return new ModelAndView("/distributor/index");
		
	}

}
