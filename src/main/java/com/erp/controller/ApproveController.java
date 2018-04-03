/**
 * 
 */
package com.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.utils.DataGrid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.erp.orm.entity.Approve;
import com.erp.service.IApproveService;
import com.erp.utils.ResultJson;

/**
 * 审核流程设置
 * @author scy
 *
 */
@RestController
@RequestMapping("approve")
public class ApproveController extends BaseController {

	@Resource
	private IApproveService approveService;
	
	@RequestMapping("index")
	public ModelAndView index(){
		return new ModelAndView("/approve/index");
	}
	
	/**
	 * 打开添加页面
	 * @return
	 */
	@RequestMapping("add")
	public ModelAndView add(String aid){
		Map<String,String> map = new HashMap<String,String>();
		if(StringUtils.isBlank(aid)){
			aid = "@err";
		}
		map.put("aid", aid);
		return new ModelAndView("/approve/add",map);
	}
	
	/**
	 * 打开添加页面
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add_json")
	public Approve addJson(String aId){
		Approve approve = null;
		if(StringUtils.isNotBlank(aId)){
			approve = approveService.findById(Integer.parseInt(aId));
		}
		return approve;
	}
	/**
	 * 审核流程
	 * @param approve
	 * @return
	 */
	@ResponseBody
	@RequestMapping("save")
	public ResultJson save(Approve approve){
		ResultJson rj = new ResultJson();
		try{
			int n = approveService.saveNotNull(approve);
			if(n > 0){
				rj.setSuccess();
				rj.setDesc("保存审核流程成功");
			}else{
				rj.setDesc("保存审核流程失败");
			}
		}catch(Exception e){
			rj.setException("保存审核流程时");
		}
		return rj;
	}
	
	/**
	 * 获取所有商品信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("all")
	public List<Approve> all(){
		List<Approve> approves = approveService.findAll();
//		String json = GsonUtils.toStr(wareses);
//		logger.info("------获取所有商品信息:"+json);
//		return json;
		return approves;
	}

	/**
	 * 获取所有商品信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("dg_find")
	public DataGrid dgfind(Integer page, Integer rows){

//		String json = GsonUtils.toStr(wareses);
//		logger.info("------获取所有商品信息:"+json);
//		return json;
//		return approves;
		if(page == null){
			page = 1;
		}
		page = page -1;

		if(rows == null){
			rows = Constant.ROWS;
		}

		List<Approve> approves = approveService.findByPage(page,rows);
		Integer total = approveService.findCount();
		DataGrid dg = new DataGrid();
		dg.setRows(approves);
		dg.setTotal(total);
		return dg;
	}

	/**
	 * 根据模块ID获取单据审批部门和审批人信息
	 * @param mId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("find_approve_info")
	public Approve findapproveinfo(Integer mId){
		if(mId != null && mId > 0){
			return approveService.findByMid(mId);
		}
		return null;
	}

}
