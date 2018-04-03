/**
 * 
 */
package com.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.Wholesale;
import com.erp.service.IWholesaleDetailService;
import com.erp.service.IWholesaleService;
import com.erp.utils.DataGrid;
import com.erp.utils.LoggerUtil;
import com.erp.utils.ResultJson;

/**
 * 机构
 * @author scy
 *
 */
@RestController
@RequestMapping("wholesale")
public class WholesaleController extends BaseController {

    @Resource
    private IWholesaleService wholesaleService;
    @Resource
    private IWholesaleDetailService wholesaleDetailService;
    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/wholesale/index");
    }

    @ResponseBody
    @RequestMapping("dg_find")
    public DataGrid find(Integer page, Integer rows){
        if(page == null){
            page = 1;
        }
        page = page -1;

        if(rows == null){
            rows = Constant.ROWS;
        }

        List<?> wholesales = wholesaleService.findByPage(page,rows);
        Integer total = wholesaleService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(wholesales);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<Wholesale> findName(String name){
        if(name == null){
            name = "";
        }
        return wholesaleService.findByName(name);
    }

    @RequestMapping("add")
    public ModelAndView add(String wsId){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(wsId)){
            wsId = "";//新增
        }
        map.put("wsId", wsId);

//        if(StringUtils.isNotBlank(moduleId )){
        map.put("moduleId","4");
//        }

        return new ModelAndView("/wholesale/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public Wholesale addJson(Integer wsId){
        Wholesale wholesale = null;
        if(wsId != null && wsId > 0){
            wholesale = wholesaleService.findById(wsId);
        }
        return wholesale;
    }
    /**
     * 保存机构信息
     * @param wholesale
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(HttpServletRequest request ,Wholesale wholesale,String moduleId, String add, String del, String modify){
        ResultJson rj = new ResultJson();
        StringBuffer msg = new StringBuffer();
        try{
            if(wholesale.getWsId() != null && wholesale.getWsId() > 0) {//修改操作
//                Wholesale wa = wholesaleService.findById(wholesale.getWsId());
//                if (wa != null && wa.getWsId() > 0) {
//                    int n = wholesaleService.modifyByIdNotNull(wholesale);
                rj = wholesaleService.modifyByIdNotNull(wholesale);
//                    if (n > 0) {
//                        rj.setSuccess();
//                        rj.setDesc("修改批发销售单信息成功");
//                    } else {
//                        rj.setDesc("修改批发销售单信息失败");
//                    }
//                }
            }else {
//                int n = wholesaleService.saveNotNull(wholesale);
                rj  = wholesaleService.saveNotNull(wholesale, add, del, modify);
//                if (n > 0) {
//                    rj.setSuccess();
//                    rj.setDesc("保存批发销售单信息成功");
//                    msg.append("保存批发销售单信息成功.");
////				rj.setDesc("保存批发销售单信息成功");
////                    int mId = 3;//模板ID
                if(rj.getStatus() == 1 ) {
                    int nn = addApprove(request, Integer.toString(wholesale.getWsId()), Integer.parseInt(moduleId));//添加审批流程
                    switch (nn) {
                        case 1:
                            msg.append("保存批发销售单信息自动添加审批流程成功,单据ID:" + wholesale.getWsId() + ",模块ID:" + moduleId + ".");
                            loggerInfo(this.getClass(), "保存批发销售单信息自动添加审批流程成功,单据ID:" + wholesale.getWsId() + ",模块ID:" + moduleId);
                            break;
                        case 0:
                            msg.append("保存批发销售单信息自动添加审批流程失败,单据ID:" + wholesale.getWsId() + ",模块ID:" + moduleId + ".");
                            loggerError(this.getClass(), "保存批发销售单信息自动添加审批流程失败,单据ID:" + wholesale.getWsId() + ",模块ID:" + moduleId);
                            break;
                        default:
                            msg.append("保存批发销售单信息自动添加审批流程异常,单据ID:" + wholesale.getWsId() + ",模块ID:" + moduleId + ".");
                            loggerError(this.getClass(), "保存批发销售单信息自动添加审批流程异常,单据ID:" + wholesale.getWsId() + ",模块ID:" + moduleId);
                    }
                }
//                    //删除批发销售单明细
//                    if (StringUtils.isNotBlank(del)) {
//                        //把json字符串转换成对象
//                        List<JsonWholesaleDetail> listDeleted = GsonUtils.toToListWholesaleDetail(del);//JSON.parseArray(deleted, WholesaleDetail.class);
//                        //下面就可以根据转换后的对象进行相应的操作了
//                        if (listDeleted != null && !listDeleted.isEmpty()) {
//                            int delnum = 0;
//                            for (JsonWholesaleDetail jwd : listDeleted) {
//                                WholesaleDetail wd = new WholesaleDetail(jwd);
//                                Integer wId = wd.getwId();
//                                if (wId != null && wId > 0 ) {//商品ID
//                                    delnum += wholesaleDetailService.delByWsIdAndWidAndBatchnoAndSbid(wholesale.getWsId(), wId,wd.getBatchNo(),wd.getSbId());//根据批发销售单ID和商品ID删除
//                                }
//                            }
//                            msg.append("删除批发销售单明细记录:" + delnum + " 条.");
//                        }
//                    }
//                    //添加批发销售单明细
//                    if (StringUtils.isNotBlank(add)) {
//                        //把json字符串转换成对象
//                        List<JsonWholesaleDetail> insertList = GsonUtils.toToListWholesaleDetail(add);//JSON.parseArray(inserted, WholesaleDetail.class);
//                        if (insertList != null && !insertList.isEmpty()) {
//                            int addnum = 0;
//                            for (JsonWholesaleDetail jwd : insertList) {
//                                WholesaleDetail wd = new WholesaleDetail(jwd);
//                                if (StringUtils.isNotBlank(jwd.getwId())) {//商品ID
//                                    wd.setWsId(wholesale.getWsId());//批发销售单ID
//                                    addnum += wholesaleDetailService.saveNotNull(wd);
//                                }
//                            }
//                            msg.append("添加批发销售单明细记录:" + addnum + " 条.");
//                        }
//                    }
//                    //修改批发销售单明细
//                    if (StringUtils.isNotBlank(modify)) {
//                        //把json字符串转换成对象
//                        List<JsonWholesaleDetail> listUpdated = GsonUtils.toToListWholesaleDetail(modify);// JSON.parseArray(updated, WholesaleDetail.class);
//                        if (listUpdated != null && !listUpdated.isEmpty()) {
//                            int mdfnum = 0;
//                            for (JsonWholesaleDetail jwd : listUpdated) {
//                                WholesaleDetail wd = new WholesaleDetail(jwd);
//                                if (StringUtils.isNotBlank(jwd.getwId())) {//商品ID
//                                    wd.setWsId(wholesale.getWsId());//批发销售单ID
//                                    mdfnum += wholesaleDetailService.modifyByIdNotNull(wd);
//                                }
//                            }
//                            msg.append("修改批发销售单明细记录:" + mdfnum + " 条.");
//                        }
//                    }
//                } else {
//                    rj.setDesc("保存批发销售单信息失败");
//                }
            }
        }catch(Exception e){
            loggerError(this.getClass(),e.getMessage());
            rj.setException("保存机构信息时");
        }
        return rj;
    }

    /**
     * 判断机构编号是否存在
     * @param oCode
     * @return
     */
    @ResponseBody
    @RequestMapping("checkOcode_json")
    public int checkWidJson(String oCode){
        Wholesale wholesale = null;
        if(StringUtils.isNotBlank(oCode)){
            wholesale = wholesaleService.findByCode(oCode);
        }
        if(wholesale != null && wholesale.getWsId() > 0){
            return 1;
        }
        return 0;
    }

    /**
     * 删除机构编号信息
     * @param wsId
     * @return
     */
    @ResponseBody
    @RequestMapping("del_json")
    public int delJson(Integer wsId){
        int n = 0;
        if(wsId != null &&  wsId > 0){
            try {
                n = wholesaleService.delById(wsId);
                int nn =  wholesaleDetailService.delByWsId(wsId);
                if(nn > 0){
                	LoggerUtil.info(this.getClass(),"删除明细成功");
                }
            } catch (Exception e) {
                loggerError(this.getClass(), e.getMessage());
                n = 0;
            }

        }
        return n;
    } 

}
