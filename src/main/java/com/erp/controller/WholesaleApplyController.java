/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.model.JsonWholesaleApplyDetail;
import com.erp.orm.entity.WholesaleApplyDetail;
import com.erp.orm.entity.WholesaleApply;
import com.erp.service.IWholesaleApplyDetailService;
import com.erp.service.IWholesaleApplyService;
import com.erp.utils.DataGrid;
import com.erp.utils.GsonUtils;
import com.erp.utils.ResultJson;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 批发申请单
 * @author scy
 *
 */
@RestController
@RequestMapping("wholesaleapply")
public class WholesaleApplyController extends BaseController {

    @Resource
    private IWholesaleApplyService wholesaleApplyService;
    @Resource
    private IWholesaleApplyDetailService wholesaleApplyDetailService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/wholesaleapply/index");
    }

    @ResponseBody
    @RequestMapping("dg_find")
    public DataGrid dgFind(Integer page, Integer rows,Integer waId){
        if(page == null){
            page = 1;
        }
        page = page -1;

        if(rows == null){
            rows = Constant.ROWS;
        }

        List<WholesaleApply> wholesaleapplys = wholesaleApplyService.findByPage(page,rows,waId);
        Integer total = wholesaleApplyService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(wholesaleapplys);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<WholesaleApply> findName(String name){
        if(name == null){
            name = "";
        }
        return wholesaleApplyService.findByName(name);
    }

    @RequestMapping("add")
    public ModelAndView add(String waId,String moduleId){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(waId)){
            waId = "";//新增
        }
        map.put("waId", waId);

        if(StringUtils.isNotBlank(moduleId )){
            map.put("moduleId","3");
        }

        return new ModelAndView("/wholesaleapply/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public WholesaleApply addJson(Integer waId){
        WholesaleApply wholesaleapply = null;
        if(waId != null && waId > 0){
            wholesaleapply = wholesaleApplyService.findById(waId);
        }
        return wholesaleapply;
    }
    /**
     * 保存批发申请单信息
     * @param wholesaleApply
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(HttpServletRequest request , WholesaleApply wholesaleApply,String moduleId,String add, String del, String modify){
        ResultJson rj = new ResultJson();
        StringBuffer msg = new StringBuffer();
        try{
            if(wholesaleApply.getWaId() != null && wholesaleApply.getWaId() > 0) {
                WholesaleApply wa = wholesaleApplyService.findById(wholesaleApply.getWaId());
                if (wa != null && wa.getWaId() > 0) {
                    int n = wholesaleApplyService.modifyByIdNotNull(wholesaleApply);
                    if (n > 0) {
                        rj.setSuccess();
                        rj.setDesc("修改批发申请单信息成功");
                    } else {
                        rj.setDesc("修改批发申请单信息失败");
                    }
                }
            }else {
                int n = wholesaleApplyService.saveNotNull(wholesaleApply);
                if (n > 0) {
                    rj.setSuccess();
                    rj.setDesc("保存批发申请单信息成功");
                    msg.append("保存批发申请单信息成功.");
//				rj.setDesc("保存批发申请单信息成功");
//                    int mId = 3;//模板ID
                    int nn = addApprove(request, Integer.toString(wholesaleApply.getWaId()), Integer.parseInt(moduleId));//添加审批流程
                    switch (nn) {
                        case 1:
                            msg.append("保存批发申请单信息自动添加审批流程成功,单据ID:" + wholesaleApply.getWaId() + ",模块ID:" + moduleId + ".");
                            loggerInfo(this.getClass(), "保存批发申请单信息自动添加审批流程成功,单据ID:" + wholesaleApply.getWaId() + ",模块ID:" + moduleId);
                            break;
                        case 0:
                            msg.append("保存批发申请单信息自动添加审批流程失败,单据ID:" + wholesaleApply.getWaId() + ",模块ID:" + moduleId + ".");
                            loggerError(this.getClass(), "保存批发申请单信息自动添加审批流程失败,单据ID:" + wholesaleApply.getWaId() + ",模块ID:" + moduleId);
                            break;
                        default:
                            msg.append("保存批发申请单信息自动添加审批流程异常,单据ID:" + wholesaleApply.getWaId() + ",模块ID:" + moduleId + ".");
                            loggerError(this.getClass(), "保存批发申请单信息自动添加审批流程异常,单据ID:" + wholesaleApply.getWaId() + ",模块ID:" + moduleId);
                    }
                    //删除批发申请单明细
                    if (StringUtils.isNotBlank(del)) {
                        //把json字符串转换成对象
                        List<JsonWholesaleApplyDetail> listDeleted = GsonUtils.toToListWholesaleApplyDetail(del);//JSON.parseArray(deleted, WholesaleApplyDetail.class);
                        //下面就可以根据转换后的对象进行相应的操作了
                        if (listDeleted != null && !listDeleted.isEmpty()) {
                            int delnum = 0;
                            for (JsonWholesaleApplyDetail jwad : listDeleted) {
                                WholesaleApplyDetail wd = new WholesaleApplyDetail(jwad);
                                String wid = wd.getwId();
                                if (StringUtils.isNotBlank(wid)) {//商品ID
                                    delnum += wholesaleApplyDetailService.delByWaIdAndWid(wd.getWaId(), wid);//根据批发申请单ID和商品ID删除
                                }
                            }
                            msg.append("删除批发申请单明细记录:" + delnum + " 条.");
                        }
                    }
                    //添加批发申请单明细
                    if (StringUtils.isNotBlank(add)) {
                        //把json字符串转换成对象
                        List<JsonWholesaleApplyDetail> insertList = GsonUtils.toToListWholesaleApplyDetail(add);//JSON.parseArray(inserted, WholesaleApplyDetail.class);
                        if (insertList != null && !insertList.isEmpty()) {
                            int addnum = 0;
                            for (JsonWholesaleApplyDetail jwad : insertList) {
                                WholesaleApplyDetail wd = new WholesaleApplyDetail(jwad);
                                if (StringUtils.isNotBlank(wd.getwId())) {//商品ID
                                    wd.setWaId(wholesaleApply.getWaId().toString());//批发申请单ID
                                    addnum += wholesaleApplyDetailService.saveNotNull(wd);
                                }
                            }
                            msg.append("添加批发申请单明细记录:" + addnum + " 条.");
                        }
                    }
                    //修改批发申请单明细
                    if (StringUtils.isNotBlank(modify)) {
                        //把json字符串转换成对象
                        List<JsonWholesaleApplyDetail> listUpdated = GsonUtils.toToListWholesaleApplyDetail(modify);// JSON.parseArray(updated, WholesaleApplyDetail.class);
                        if (listUpdated != null && !listUpdated.isEmpty()) {
                            int mdfnum = 0;
                            for (JsonWholesaleApplyDetail jwad : listUpdated) {
                                WholesaleApplyDetail wd = new WholesaleApplyDetail(jwad);
                                if (StringUtils.isNotBlank(wd.getwId())) {//商品ID
                                    wd.setWaId(wholesaleApply.getWaId().toString());//批发申请单ID
                                    mdfnum += wholesaleApplyDetailService.modifyByIdNotNull(wd);
                                }
                            }
                            msg.append("修改批发申请单明细记录:" + mdfnum + " 条.");
                        }
                    }
                } else {
                    rj.setDesc("保存批发申请单信息失败");
                }
            }
        }catch(Exception e){
            rj.setException("保存批发申请单信息时");
        }
        return rj;
    }

    /**
     * 判断批发申请单编号是否存在
     * @param waId
     * @return
     */
    @ResponseBody
    @RequestMapping("checkWaId_json")
    public int checkWidJson(String waId){
        WholesaleApply wholesaleapply = null;
        if(StringUtils.isNotBlank(waId)){
            wholesaleapply = wholesaleApplyService.findById(Integer.parseInt(waId));
        }
        if(wholesaleapply != null && wholesaleapply.getWaId() > 0){

//        if(wholesaleapply != null && StringUtils.isNotBlank(wholesaleapply.getWaId())){
            return 1;
        }
        return 0;
    }

    /**
     * 删除批发申请单编号信息
     * @param waId
     * @return
     */
    @ResponseBody
    @RequestMapping("del_json")
    public int delJson(Integer waId){
        int n = 0;
        if(waId != null &&  waId > 0){
            n = wholesaleApplyService.delById(waId);
        }
        return n;
    } 

}
