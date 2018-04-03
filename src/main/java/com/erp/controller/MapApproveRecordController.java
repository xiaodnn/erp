/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.erp.service.ApproveOperateComm;
import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.*;
import com.erp.service.IApproveService;
import com.erp.service.IMapApproveRecordService;
import com.erp.utils.DataGrid;
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
 * 机构
 * @author scy
 *
 */
@RestController
@RequestMapping("mapapproverecord")
public class MapApproveRecordController extends BaseController {

    @Resource
    private IMapApproveRecordService mapapproverecordService;
    @Resource
    private IApproveService approveService;
    @Resource
    private ApproveOperateComm approveOperateComm;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/mapapproverecord/index");
    }

    @ResponseBody
    @RequestMapping("find_json")
    public DataGrid find(Integer page, Integer rows){
        if(page == null){
            page = 1;
        }
        page = page -1;

        if(rows == null){
            rows = Constant.ROWS;
        }

        List<?> mapapproverecords = mapapproverecordService.findByPage(page,rows);
        Integer total = mapapproverecordService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(mapapproverecords);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<MapApproveRecord> findName(String name){
        if(name == null){
            name = "";
        }
//        return mapapproverecordService.findByName(name);
        return null;
    }

    @RequestMapping("add")
    public ModelAndView add(String cid){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(cid)){
            cid = "@err";
        }
        map.put("cid", cid);
        return new ModelAndView("/mapapproverecord/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public MapApproveRecord addJson(Integer oId){
        MapApproveRecord mapapproverecord = null;
        if(oId != null && oId > 0){
            mapapproverecord = mapapproverecordService.findById(oId);
        }
        return mapapproverecord;
    }
    /**
     * 保存机构信息
     * @param mapapproverecord
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(MapApproveRecord mapapproverecord){
        ResultJson rj = new ResultJson();
        try{
            if(mapapproverecord.getMarId() != null && mapapproverecord.getMarId() > 0){
                int n = mapapproverecordService.modifyByIdNotNull(mapapproverecord);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改机构信息成功");
                }else{
                    rj.setDesc("修改机构信息失败");
                }
            }else{
                int n = mapapproverecordService.saveNotNull(mapapproverecord);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("保存机构信息成功");
                }else{
                    rj.setDesc("保存机构信息失败");
                }
            }

        }catch(Exception e){
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
        MapApproveRecord mapapproverecord = null;
        if(StringUtils.isNotBlank(oCode)){
            mapapproverecord = mapapproverecordService.findByCode(oCode);
        }
        if(mapapproverecord != null && mapapproverecord.getMarId() > 0){
            return 1;
        }
        return 0;
    }

    /**
     * 删除机构编号信息
     * @param oId
     * @return
     */
    @ResponseBody
    @RequestMapping("del_json")
    public int delJson(Integer oId){
        int n = 0;
        if(oId != null &&  oId > 0){
            n = mapapproverecordService.delById(oId);
        }
        return n;
    }
    /**
     * 根据模块ID和单据ID获取单据审批部门和审批人信息
     * @param mId 模块ID
     * @param rId 单据ID
     * @return
     */
    @ResponseBody
    @RequestMapping("find_map_approve_info")
    public Map<String,Object> findapproveinfo(Integer mId,String rId){

        if(mId != null && mId > 0 && StringUtils.isNotBlank(rId)){
            Map<String,Object> map = new HashMap<String,Object>();
            Approve approve = approveService.findByMid(mId);
            MapApproveRecord mapApproveRecord = mapapproverecordService.findByMidAndRid(mId,rId);
            map.put("approve",approve);
            map.put("mapApproveRecord",mapApproveRecord);
            return map;
        }
        return null;
    }

    /**
     * 审批操作
     * @param mId 模块ID
     * @param mName 模块名称
     * @param rId 单据ID
     * @param remark 审批简述
     * @param state 审批意见:1:通过,2:驳回,3:作废,4:撤回,5:终止
     * @return
     */
    @ResponseBody
    @RequestMapping("approve_operate")
    public ResultJson approveOperate(HttpServletRequest request,Integer mId, String mName, String rId, String remark, Byte state){

        ResultJson rj = approveOperateComm.approveOperate(request,mId,mName,rId,remark,state);

        return rj;
    }

}
