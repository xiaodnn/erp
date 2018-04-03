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
 * 质量管理
 * 
 * @author scy
 * @date 2016年6月30日
 */
@RestController
@RequestMapping("quality")
public class QualityController extends BaseController {

	@RequestMapping("index")
	public ModelAndView index(CustomerBase customerBase){
		loggerInfo(this.getClass(),"打开质量管理首页");
		
		return new ModelAndView("/quality/add");
	}
}
