/**
 * 
 */
package com.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.erp.common.Constant;
import com.erp.orm.entity.*;
import com.erp.utils.DataGrid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.erp.common.BaseController;
import com.erp.service.IWaresService;
import com.erp.utils.ResultJson;

/**
 * 商品信息
 *
 * @author scy
 * @date 2016年9月29日
 */
@RestController
@RequestMapping("wares")
public class WaresController extends BaseController {

	@Resource
	private IWaresService waresService;
	
	@RequestMapping("index")
	public ModelAndView index(){
//		Map<String,List<Wares>> map = new HashMap<String,List<Wares>>();
//		
//		List<Wares> wareses = waresService.findAll();
//		map.put("wareses", wareses);
		
		return new ModelAndView("/wares/index");
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
		List<Wares> wares = waresService.findByPage(page,rows);
		Integer total = waresService.findCount();

		DataGrid dg = new DataGrid();
		dg.setRows(wares);
		dg.setTotal(total);
		return dg;
	}
	/**
	 * 获取所有商品信息
	 * @return
	 */
//	@ResponseBody
//	@RequestMapping("find_json")
//	public List<Wares> find(){
//		List<Wares> wareses = waresService.findAll();
////		String json = GsonUtils.toStr(wareses);
////		logger.info("------获取所有商品信息:"+json);
////		return json;
//
//		return wareses;
//	}

	/**
	 * 根据商品名称获取商品信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("find_json")
	public List<Wares> findWares(String wTraname){
		if(wTraname == null){
			wTraname = "";
		}
		List<Wares> wareses = waresService.findByName(wTraname);
//		String json = GsonUtils.toStr(wareses);
//		logger.info("------获取所有商品信息:"+json);
//		return json;
		return wareses;
	}

	/**
	 * 根据商品ID获取商品信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findbyid_json")
	public Wares findByIdWares(String wId){
		Wares warese = waresService.findById(wId);
//		String json = GsonUtils.toStr(wareses);
//		logger.info("------获取所有商品信息:"+json);
//		return json;
		return warese;
	}
	

	/**
	 * 打开添加页面
	 * @return
	 */
	@RequestMapping("add")
	public ModelAndView add(String wid){
		Map<String,String> map = new HashMap<String,String>();
		if(StringUtils.isBlank(wid)){
			wid = "@err";
		}
		map.put("wid", wid);
		return new ModelAndView("/wares/add",map);
	}
	/**
	 * 打开添加页面
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add_json")
	public Wares addJson(String wid){
		Wares wares = null;
		if(StringUtils.isNotBlank(wid)){
			wares = waresService.findById(wid);
		}
		return wares;
	}
	/**
	 * 保存商品信息
	 * @param base
	 * @param extend
	 * @param price
	 * @return
	 */
	@ResponseBody
	@RequestMapping("save")
	public ResultJson save(WaresBase base,WaresExtend extend,WaresPrice price){
		ResultJson rj = new ResultJson();
//		Wares wares = new Wares();
//		wares.setBase(base);
//		wares.setExtend(extend);
//		wares.setPrice(price);
		try{
			int n = waresService.saveNotNull(base,extend,price);
			if(n > 0){
				rj.setSuccess();
				rj.setDesc("保存商品信息成功");
			}else{
				rj.setDesc("保存商品信息失败");
			}
		}catch(Exception e){
			rj.setException("保存商品信息时");
		}
		return rj;
//		Map<String,Integer> map = new HashMap<String,Integer>();
//		map.put("n", n);
//		return new ModelAndView("/wares/index",map);
		
//		return new ModelAndView("/wares/index");
	}
	
	/**
	 * 判断商品编号是否存在
	 * @param wid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkWid_json")
	public int checkWidJson(String wid){
		Wares wares = null;
		if(StringUtils.isNotBlank(wid)){
			wares = waresService.findById(wid);
		}
		if(wares != null && StringUtils.isNotBlank(wares.getwId())){
			return 1;
		}
		return 0;
	}
	
	/**
	 * 删除商品编号信息
	 * @param wid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("del_json")
	public int delJson(String wid){
		int n = 0;
		if(StringUtils.isNotBlank(wid)){
			n = waresService.delById(wid);
		}
		return n;
	}

	/**
	 * 采购入库单中
	 * 根据商品名称获取商品信息
	 * @param str 商品助记码/商品名/品类编码
	 * @return
	 */
	@ResponseBody
	@RequestMapping("find_house")
	public List<Wares> findWaresHouse(String str){
		List<Wares> wareses = waresService.findByNameOrId(str);
//		List<Options> options = new ArrayList<Options>();
//		if(wareses != null && !wareses.isEmpty()){
//			for( Wares w: wareses){
//				Options option = new Options();
//				option.setValue(w.getwId());
//				option.setText(w.getwTraname()+"-"+w.getwStandard()+"-"+w.getwBusiness()+"-"+w.getwUnit());
//				options.add(option);
//			}
//		}
//		return options;
		return wareses;
	}

	/**
	 * 批发销售单中
	 * 根据商品名称助记码获取商品信息、批次信息、库存明细信息
	 * @param zjm 商品助记码/商品名/品类编码
	 * @return
	 */
	@ResponseBody
	@RequestMapping("find_ batch_house")
	public List<Wares> findWaresAndBatchAndHouse(String zjm){
		return waresService.findByZjmOrId(zjm);
	}
	
}
