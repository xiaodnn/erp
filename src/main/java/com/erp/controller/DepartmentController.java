/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.Department;
import com.erp.service.IDepartmentService;
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
 * 部门
 * @author scy
 *
 */
@RestController
@RequestMapping("department")
public class DepartmentController extends BaseController {

    @Resource
    private IDepartmentService departmentService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/department/index");
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

        List<Department> departments = departmentService.findByPage(page,rows);
        Integer total = departmentService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(departments);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_all")
    public List<Department>  findAll(){
        List<Department> departments = departmentService.findAll();
        return departments;
    }

    @RequestMapping("add")
    public ModelAndView add(String cid){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(cid)){
            cid = "@err";
        }
        map.put("cid", cid);
        return new ModelAndView("/department/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public Department addJson(Integer oId){
        Department department = null;
        if(oId != null && oId > 0){
            department = departmentService.findById(oId);
        }
        return department;
    }
    /**
     * 保存机构信息
     * @param department
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(Department department){
        ResultJson rj = new ResultJson();
        try{
            if(department.getdId() != null && department.getdId() > 0){
                int n = departmentService.modifyByIdNotNull(department);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改机构信息成功");
                }else{
                    rj.setDesc("修改机构信息失败");
                }
            }else{
                int n = departmentService.saveNotNull(department);
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
        Department department = null;
        if(StringUtils.isNotBlank(oCode)){
            department = departmentService.findByCode(oCode);
        }
        if(department != null && department.getdId() > 0){
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
            n = departmentService.delById(oId);
        }
        return n;
    } 

}
