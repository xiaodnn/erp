/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.erp.common.BaseController;
import com.erp.service.IParaService;

/**
 *
 * 系统参数
 * @author scy
 * @date 2016年12月6日
 */
@RestController
@RequestMapping("para")
public class ParaController extends BaseController {

	@Resource
	private IParaService paraService;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("index")
	public ModelAndView index(){
		
		return new ModelAndView("/para/index");
	}
	
}
