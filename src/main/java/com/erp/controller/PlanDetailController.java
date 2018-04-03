/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.PlanDetail;
import com.erp.service.IPlanDetailService;
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
@RequestMapping("plandetail")
public class PlanDetailController extends BaseController {

    @Resource
    private IPlanDetailService plandetailService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/plandetail/index");
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

        List<?> plandetails = plandetailService.findByPage(page,rows);
        Integer total = plandetailService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(plandetails);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<PlanDetail> findName(String name){
        if(name == null){
            name = "";
        }
        return plandetailService.findByName(name);
    }

    @RequestMapping("add")
    public ModelAndView add(String id){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(id)){
            id = "@err";
        }
        map.put("id", id);
        return new ModelAndView("/plandetail/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public PlanDetail addJson(Integer iidd){
        PlanDetail plandetail = null;
        if(iidd != null && iidd > 0){//1.oId != null && oId > 0  2.StringUtils.isNotBlank(iidd)
            plandetail = plandetailService.findById(iidd);
        }
        return plandetail;
    }
    /**
     * 保存机构信息
     * @param plandetail
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(PlanDetail plandetail){
        ResultJson rj = new ResultJson();
        try{
        	//判断主键是否为空
            if(plandetail.getPdId()!= null && plandetail.getPdId() > 0){
                int n = plandetailService.modifyByIdNotNull(plandetail);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改机构信息成功");
                }else{
                    rj.setDesc("修改机构信息失败");
                }
            }else{
                int n = plandetailService.saveNotNull(plandetail);
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
        PlanDetail plandetail = null;
        if(StringUtils.isNotBlank(oCode)){
            //plandetail = plandetailService.findByCode(oCode);
        }
        if(plandetail != null && plandetail.getPdId() > 0){
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
    public int delJson(Integer iidd){
        int n = 0;
        if(iidd != null && iidd > 0){//1.oId != null && oId > 0  2.StringUtils.isNotBlank(iidd)
            n = plandetailService.delById(iidd);
        }
        return n;
    } 

}
