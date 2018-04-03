/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.erp.common.BaseController;
import com.erp.orm.entity.CustomerBase;
import com.erp.service.ICustomerBaseService;

import java.util.List;

/**
 *
 * 客户
 * @author scy
 * @date 2016年3月9日
 */
@RestController
@RequestMapping("customer")
public class CustomerController extends BaseController {

	@Resource
	private ICustomerBaseService customerBaseService;
	
	@RequestMapping("reg_index")
	public ModelAndView index(CustomerBase customerBase){
		loggerInfo(this.getClass(),"打开客户首页");
		
		return new ModelAndView("/customer/add");
	}
	
	@RequestMapping("reg")
	public ModelAndView reg(CustomerBase customerBase){
		loggerInfo(this.getClass(),"打开客户首页");
		
		if(customerBase != null){
			int n = customerBaseService.saveNotNull(customerBase);
			if(n == 1){
				customerBase.getCbId();
				
			}
			loggerInfo(this.getClass(),"你很勇敢:"+n);
		}
		return new ModelAndView("/customer/add");
	}

	@RequestMapping("find_json")
	public List<CustomerBase> findJson(){
		loggerInfo(this.getClass(),"仓库列表JSON");
		return customerBaseService.findByAll();
	}


}
