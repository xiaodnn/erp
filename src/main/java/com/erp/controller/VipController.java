/**
 * 
 */
package com.erp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.erp.common.BaseController;
import com.erp.orm.entity.CustomerBase;

/**
 * 会员管理
 *
 * @author scy
 * @date 2016年6月30日
 */
@RestController
@RequestMapping("vip")
public class VipController extends BaseController {

	
	@RequestMapping("index")
	public ModelAndView index(CustomerBase customerBase){
		loggerInfo(this.getClass(),"打开会员管理首页");
		
		return new ModelAndView("/vip/add");
	}
}
