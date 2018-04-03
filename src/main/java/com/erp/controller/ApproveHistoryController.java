/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.ApproveHistory;
import com.erp.service.IApproveHistoryService;
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
@RequestMapping("approvehistory")
public class ApproveHistoryController extends BaseController {

    @Resource
    private IApproveHistoryService approvehistoryService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/approvehistory/index");
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

        List<?> approvehistorys = approvehistoryService.findByPage(page,rows);
        Integer total = approvehistoryService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(approvehistorys);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_rid")
    public List<ApproveHistory> findRid(String rId){
        if(rId == null){
            rId = "";
        }
        return approvehistoryService.findByRid(rId);
    }

    @RequestMapping("add")
    public ModelAndView add(String cid){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(cid)){
            cid = "@err";
        }
        map.put("cid", cid);
        return new ModelAndView("/approvehistory/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public ApproveHistory addJson(Integer oId){
        ApproveHistory approvehistory = null;
        if(oId != null && oId > 0){
            approvehistory = approvehistoryService.findById(oId);
        }
        return approvehistory;
    }
    /**
     * 保存机构信息
     * @param approvehistory
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(ApproveHistory approvehistory){
        ResultJson rj = new ResultJson();
        try{
            if(approvehistory.getAhId() != null && approvehistory.getAhId() > 0){
                int n = approvehistoryService.modifyByIdNotNull(approvehistory);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改机构信息成功");
                }else{
                    rj.setDesc("修改机构信息失败");
                }
            }else{
                int n = approvehistoryService.saveNotNull(approvehistory);
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
        ApproveHistory approvehistory = null;
        if(StringUtils.isNotBlank(oCode)){
            approvehistory = approvehistoryService.findByCode(oCode);
        }
        if(approvehistory != null && approvehistory.getAhId() > 0){
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
            n = approvehistoryService.delById(oId);
        }
        return n;
    } 

}
