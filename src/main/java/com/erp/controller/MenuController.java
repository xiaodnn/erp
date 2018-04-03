/**
 * 
 */
package com.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.erp.common.BaseController;
import com.erp.orm.entity.Menu;
import com.erp.orm.entity.MenuSub;
import com.erp.service.IMenuService;
import com.erp.utils.GsonUtils;
import com.erp.utils.Tree;

import net.sf.json.JSONObject;

/**
 *
 *
 * @author scy
 * @date 2016年2月17日
 */
@RestController
@RequestMapping("menu")
public class MenuController extends BaseController {

	@Resource
	private IMenuService menuService;
	
	/*
	@RequestMapping("index")
	public @ResponseBody ResultJson indexmenu(){
		ResultJson rj = new ResultJson();
		
//		Map<String, List<Menu>> map = new HashMap<String,List<Menu>>();
		
		List<Menu> menus = menuService.selectAll();
		
		List<Tree> trees = generateTree(menus);
//		map.put("menus", menus);
		
		rj.setData(trees);
		
		return rj;
	}

*/

	@RequestMapping("index")
	public void indexmenu(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		
		List<Menu> menus = menuService.selectAll();
		
		List<Tree> trees = generateTree(menus);
		
		String tree_json = GsonUtils.toJsonTree(trees);
		
		PrintWriter out = response.getWriter();
		out.println(tree_json);
		out.flush();
		out.close();
		
//		JSONObject jsonObject = JSONObject.fromObject(trees);
//		String tree_json = JSONArray.fromObject(trees).toString();
//		return tree_json;

	}

	/**
	@ResponseBody
	@RequestMapping(value="index", produces = "application/json; charset=utf-8")
	public String index(){
		List<Menu> menus = menuService.selectAll();
		
		List<Tree> trees = generateTree(menus);
		
		String tree_json = GsonUtils.toJsonTree(trees);
		
		return tree_json;
	}
	*/
	/**
	 * 转成easyUI中树结构
	 * @param menus
	 * @return
	 */
	private List<Tree> generateTree(List<Menu> menus) {
		List<Tree> tree = new ArrayList<Tree>();
		Tree t ;
		for(Menu m : menus){
			t = new Tree();
			t.setId(m.getmId());
			t.setText(m.getmName());
			if(m.getMenusub() !=null && !(m.getMenusub().isEmpty())){
				Tree tc ;
				List<Tree> children = new ArrayList<Tree>();
//				Attribute attribute;
//				List<Attribute> attributes = new ArrayList<Attribute>();
				JSONObject attributes = null ;
				for(MenuSub s:m.getMenusub()){
					attributes = new JSONObject();
					tc = new Tree();
					tc.setId(s.getMsId());
					tc.setText(s.getMsName());
					tc.setState("open");
					if(StringUtils.isNotBlank(s.getMsUrl())){
//						attribute = new Attribute();
//						attribute.setUrl(s.getMsUrl());
//						attributes.add(attribute);
						attributes.put("url", s.getMsUrl());
						tc.setAttributes(attributes);
					}
					children.add(tc);
				}
				t.setChildren(children);
			}
			tree.add(t);			
		}
		return tree;
	}


	@RequestMapping("add")
	public ModelAndView addmenu(Menu menu,String xinbie){
		Map<String,String> map = new HashMap<String,String>();
		if(menu == null || menu.getmName() == null || menu.getmName() == ""){
			map.put("msg", "菜单填写内容为空");
			return new ModelAndView("/menu/index",map);
		}
		menu.setmCreator(xinbie);
		int n = menuService.insert(menu);
		
		if(n == 1){
			map.put("msg", "菜单添加成功");
		}else{
			map.put("msg", "菜单添加失败");
		}
		
		return new ModelAndView("/menu/index",map);
	}
	
	@RequestMapping("del")
	public ModelAndView delmenu(Integer mid){
		Map<String,String> map = new HashMap<String,String>();
		if(mid == null || mid == 0){
			map.put("msg", "菜单填写内容为空");
			return new ModelAndView("/menu/index",map);
		}
		int n = menuService.deleteByMid(mid);
		
		if(n == 1){
			map.put("msg", "菜单添加成功");
		}else{
			map.put("msg", "菜单添加失败");
		}
		
		return new ModelAndView("/menu/index",map);
	}
	
	@RequestMapping("update")
	public ModelAndView updatemenu(Integer mid){
		Map<String,String> map = new HashMap<String,String>();
		if(mid == null || mid == 0){
			map.put("msg", "菜单填写内容为空");
			return new ModelAndView("/menu/index",map);
		}
		Menu menu = menuService.selectByPrimaryKey(mid);
		
		if(menu == null || menu.getmId() == null || menu.getmId() == 0){
			map.put("msg", "获取菜单信息失败");
		}
		
		return new ModelAndView("/menu/index",map);
	}
	
}
