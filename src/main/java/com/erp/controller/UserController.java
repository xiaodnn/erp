/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.erp.common.BaseController;
import com.erp.orm.entity.User;
import com.erp.utils.MD5Util;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.erp.service.IUserService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 用户
 * @author scy
 *
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController{

	@Resource
	private IUserService userService;

	@RequestMapping("login")
	public ModelAndView login(HttpServletRequest request, User user){

		if(user == null || user.getuName() == null || "".equals(user.getuName()) || user.getuPassword() == null || "".equals(user.getuPassword())){
			return  new ModelAndView("../index");
		}
		System.out.println("---uname:"+user.getuName()+",upwd:"+user.getuPassword());

		loggerInfo(this.getClass(),"-----login------");
		User user_find = userService.findByName(user.getuName());
		if(user_find != null){
			if(MD5Util.getMd5(user.getuPassword()).equals(user_find.getuPassword())){
				//把用户对象放入到session中，将会触发LoginListenner中的attributeAdded事件
				HttpSession session = request.getSession();
				session.setAttribute("user_"+session.getId(), user_find);

				return new ModelAndView("index");
			}
		}

		return  new ModelAndView("index");
	}

	@ResponseBody
	@RequestMapping("find_name")
	public List<User> findName(String name){
		if(name == null){
			name = "";
		}
		return userService.findAll();
	}
}
