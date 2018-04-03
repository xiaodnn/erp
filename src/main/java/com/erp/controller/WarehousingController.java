/**
 * 
 */
package com.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.model.JsonWarehousingDetail;
import com.erp.orm.entity.Warehousing;
import com.erp.orm.entity.WarehousingDetail;
import com.erp.service.IWarehousingDetailService;
import com.erp.service.IWarehousingService;
import com.erp.utils.DataGrid;
import com.erp.utils.GsonUtils;
import com.erp.utils.ResultJson;

/**
 * 采购入库
 *
 * @author scy
 * @date 2017年1月2日
 */
@RestController
@RequestMapping("warehousing")
public class WarehousingController extends BaseController {

	@Resource
	private IWarehousingService warehousingService;
	@Resource
	private IWarehousingDetailService warehousingDetailService;

	@RequestMapping("index")
	public ModelAndView index(){
//		String moduleName = "warehousing_add";

		ModelMap model = new ModelMap();

//		int uid = 1001;
//		int organ = 1;
//		int module = 1;

//		Approve approve = approveService.findByOrder(uid,organ,module);
//		model.put("approve",approve);

		return new ModelAndView("/warehousing/index",model);
	}
	
	/**
	 * 获取所有入库信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("find_json")
	public List<Warehousing> findWarehousing(String whId,String whInitime,String whCreator){
		List<Warehousing> warehousings = warehousingService.findWarehousing(whId,whInitime,whCreator);
		return warehousings;
	}

	/**
	 * 获取所有入库信息,放入DataGrid中
	 * @return
	 */
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
		List<Warehousing> warehousings = warehousingService.findByPage(page,rows);
		Integer total = warehousingService.findCount();

		DataGrid dg = new DataGrid();
		dg.setRows(warehousings);
		dg.setTotal(total);
		return dg;
	}
	/**
	 * 打开添加页面
	 * @return
	 */
	@RequestMapping("add")
	public ModelAndView add(String whId){
		Map<String,String> map = new HashMap<String,String>();
		if(StringUtils.isBlank(whId)){
			whId = "";//新增
		}
		map.put("whId", whId);

		map.put("moduleId","1");//模块中采购入库为1

		return new ModelAndView("/warehousing/add",map);
	}
	/**
	 * 打开添加页面
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add_json")
	public Warehousing addJson(String whId){
		Warehousing warehousing = null;
		if(StringUtils.isNotBlank(whId)){
			warehousing = warehousingService.findById(whId);
		}
		return warehousing;
	}
	/**
	 * 保存入库信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("save")
	public ResultJson save(HttpServletRequest request , Warehousing warehousing, String add, String del, String modify){
		loggerInfo(this.getClass(),"保存入库信息");
		ResultJson rj = new ResultJson();
		StringBuffer msg = new StringBuffer();
		try{
			//保存入库信息
			int n = warehousingService.saveNotNull(warehousing);
			if(n > 0){
				rj.setSuccess();
				msg.append("保存入库信息成功.");
//				rj.setDesc("保存入库信息成功");
				int mId = 1;//模板ID
				int nn = addApprove(request,warehousing.getWhId(),mId);//添加审批流程
				switch (nn){
					case 1:
						msg.append("保存入库信息自动添加审批流程成功,单据ID:"+ warehousing.getWhId()+",模块ID:"+mId+".");
						loggerInfo(this.getClass(),"保存入库信息自动添加审批流程成功,单据ID:"+ warehousing.getWhId()+",模块ID:"+mId);
						break;
					case 0:
						msg.append("保存入库信息自动添加审批流程失败,单据ID:"+ warehousing.getWhId()+",模块ID:"+mId+".");
						loggerError(this.getClass(),"保存入库信息自动添加审批流程失败,单据ID:"+ warehousing.getWhId()+",模块ID:"+mId);
						break;
						default:
							msg.append("保存入库信息自动添加审批流程异常,单据ID:"+ warehousing.getWhId()+",模块ID:"+mId+".");
							loggerError(this.getClass(),"保存入库信息自动添加审批流程异常,单据ID:"+ warehousing.getWhId()+",模块ID:"+mId);
				}
				//删除入库明细
				if(StringUtils.isNotBlank(del)){
					//把json字符串转换成对象
					List<JsonWarehousingDetail> listDeleted = GsonUtils.toToListWarehousingDetail(del) ;//JSON.parseArray(deleted, WarehousingDetail.class);
					//下面就可以根据转换后的对象进行相应的操作了
					if(listDeleted != null && !listDeleted.isEmpty()) {
						int delnum = 0;
						for (JsonWarehousingDetail jwd : listDeleted) {
							WarehousingDetail wd = new WarehousingDetail(jwd);
							String wid = wd.getwId();
							if (StringUtils.isNotBlank(wid)) {//商品ID
								delnum += warehousingDetailService.delById(wd.getWhId(),wid);//根据入库单号和商品ID删除
							}
						}
						msg.append("删除入库明细记录:" + delnum + " 条.");
					}
				}
				//添加入库明细
				if(StringUtils.isNotBlank(add)){
					//把json字符串转换成对象
					List<JsonWarehousingDetail> insertList = GsonUtils.toToListWarehousingDetail(add);//JSON.parseArray(inserted, WarehousingDetail.class);
					if(insertList != null && !insertList.isEmpty()){
						int addnum = 0;
						for(JsonWarehousingDetail jwd : insertList){
							WarehousingDetail wd = new WarehousingDetail(jwd);
							if(StringUtils.isNotBlank(wd.getwId()) ){//商品ID
								wd.setWhId(warehousing.getWhId());//入库ID
								addnum += warehousingDetailService.saveNotNull(wd);
							}
						}
						msg.append("添加入库明细记录:"+ addnum +" 条.");
					}
				}
				//修改入库明细
				if(StringUtils.isNotBlank(modify)){
					//把json字符串转换成对象
					List<JsonWarehousingDetail> listUpdated = GsonUtils.toToListWarehousingDetail(modify);// JSON.parseArray(updated, WarehousingDetail.class);
					if(listUpdated != null && !listUpdated.isEmpty()) {
						int mdfnum = 0;
						for (JsonWarehousingDetail jwd : listUpdated) {
							WarehousingDetail wd = new WarehousingDetail(jwd);
							if (StringUtils.isNotBlank(wd.getwId())) {//商品ID
								wd.setWhId(warehousing.getWhId());//入库ID
								mdfnum += warehousingDetailService.modifyByIdNotNull(wd);
							}
						}
						msg.append("修改入库明细记录:" + mdfnum+ " 条.");
					}
				}
			}else{
				msg.append("保存入库信息失败");
//				rj.setDesc("保存入库信息失败");
			}
//			rj.setDesc(msg.toString());
		}catch(Exception e){
			loggerError(this.getClass(),"保存入库信息时异常:"+e.getMessage());
			msg.append("保存入库信息时异常");
			rj.setException("保存入库信息时");
		}
		rj.setDesc(msg.toString());
		return rj;
	}
	
	/**
	 * 判断入库编号是否存在
	 * @param whId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkWid_json")
	public int checkWidJson(String whId){
		Warehousing warehousing = null;
		if(StringUtils.isNotBlank(whId)){
			warehousing = warehousingService.findById(whId);
		}
		if(warehousing != null && StringUtils.isNotBlank(warehousing.getWhId())){
			return 1;
		}
		return 0;
	}
	
	/**
	 * 删除入库编号信息
	 * @param whId
	 * @param wid
	 * @return
	 */
//	@ResponseBody
//	@RequestMapping("del_json")
//	public int delJson(String whId,String wid){
//		int n = 0;
//		if(StringUtils.isNotBlank(wid)){
//			n = warehousingService.delById(whId,wid);
//		}
//		return n;
//	}
}
