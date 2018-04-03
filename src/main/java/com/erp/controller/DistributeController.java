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
import com.erp.service.IDistributeService;

/**
 * 配送管理
 *
 * @author scy
 * @date 2016年6月30日
 */
@RestController
@RequestMapping("distribute")
public class DistributeController extends BaseController {

	@Resource
	private IDistributeService distributeService;

	@RequestMapping("index")
	public ModelAndView index(CustomerBase customerBase){
		loggerInfo(this.getClass(),"打开配送管理首页");
		
		return new ModelAndView("/distribute/add");
	}
}
