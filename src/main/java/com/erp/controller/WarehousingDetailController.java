/**
 * 
 */
package com.erp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.erp.common.BaseController;
import com.erp.model.JsonWarehousingDetail;
import com.erp.orm.entity.WarehousingDetail;
import com.erp.service.IWarehousingDetailService;
import com.erp.utils.GsonUtils;
import com.erp.utils.ResultJson;

/**
 * 入库明细管理
 *
 * @author scy
 * @date 2017年1月2日
 */
@RestController
@RequestMapping("warehousingdetail")
public class WarehousingDetailController extends BaseController {

	@Resource
	private IWarehousingDetailService warehousingDetailService;

	@ResponseBody
	@RequestMapping("save")
	public ResultJson editCommit(String whId, String add, String del, String modify){
		ResultJson rj = new ResultJson();
		//获取编辑数据 这里获取到的是json字符串
//		String deleted = req.getParameter("deleted");
//		String inserted = req.getParameter("inserted");
//		String updated = req.getParameter("updated");

		StringBuffer msg = new StringBuffer();
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
						delnum += warehousingDetailService.delById(whId,wid);//根据入库单号和商品ID删除
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
						wd.setWhId(whId);//入库ID
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
						wd.setWhId(whId);//入库ID
						mdfnum += warehousingDetailService.modifyByIdNotNull(wd);
					}
				}
				msg.append("修改入库明细记录:" + mdfnum+ " 条.");
			}
		}
		rj.setDesc(msg.toString());
		rj.setSuccess();
		return rj;
	}
}
