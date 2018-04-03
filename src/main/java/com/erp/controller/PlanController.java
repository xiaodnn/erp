/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.Plan;
import com.erp.service.IPlanService;
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
@RequestMapping("plan")
public class PlanController extends BaseController {

    @Resource
    private IPlanService planService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/plan/index");
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

        List<?> plans = planService.findByPage(page,rows);
        Integer total = planService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(plans);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<Plan> findName(String name){
        if(name == null){
            name = "";
        }
        return planService.findByName(name);
    }

    @RequestMapping("add")
    public ModelAndView add(String id){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(id)){
            id = "@err";
        }
        map.put("id", id);
        return new ModelAndView("/plan/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public Plan addJson(Integer pId){
        Plan plan = null;
        if(pId != null && pId > 0){//1.oId != null && oId > 0  2.StringUtils.isNotBlank(iidd)
            plan = planService.findById(pId);
        }
        return plan;
    }
    /**
     * 保存机构信息
     * @param plan
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(Plan plan){
        ResultJson rj = new ResultJson();
        try{
        	//判断主键是否为空
            if(plan.getpId() != null && plan.getpId() > 0){
                int n = planService.modifyByIdNotNull(plan);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改机构信息成功");
                }else{
                    rj.setDesc("修改机构信息失败");
                }
            }else{
                int n = planService.saveNotNull(plan);
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
        Plan plan = null;
        if(StringUtils.isNotBlank(oCode)){
           // plan = planService.findByCode(oCode);
        }
        if(plan != null && plan.getpId() > 0){
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
    public int delJson(Integer pId){
        int n = 0;
        if(pId != null && pId > 0 ){//1.oId != null && oId > 0  2.StringUtils.isNotBlank(iidd)
            n = planService.delById(pId);
        }
        return n;
    } 

}
