/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.Module;
import com.erp.service.IModuleService;
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
 * 模块
 * @author scy
 *
 */
@RestController
@RequestMapping("module")
public class ModuleController extends BaseController {

    @Resource
    private IModuleService moduleService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/module/index");
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

        List<Module> modules = moduleService.findByPage(page,rows);
        Integer total = moduleService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(modules);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<Module> findName(String nikename){
        if(nikename == null){
            nikename = "";
        }
        return moduleService.findByNikename(nikename);
    }

    @RequestMapping("add")
    public ModelAndView add(String cid){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(cid)){
            cid = "@err";
        }
        map.put("cid", cid);
        return new ModelAndView("/module/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public Module addJson(Integer oId){
        Module module = null;
        if(oId != null && oId > 0){
            module = moduleService.findById(oId);
        }
        return module;
    }
    /**
     * 保存模块信息
     * @param module
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(Module module){
        ResultJson rj = new ResultJson();
        try{
            if(module.getmId() != null && module.getmId() > 0){
                int n = moduleService.modifyByIdNotNull(module);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改模块信息成功");
                }else{
                    rj.setDesc("修改模块信息失败");
                }
            }else{
                int n = moduleService.saveNotNull(module);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("保存模块信息成功");
                }else{
                    rj.setDesc("保存模块信息失败");
                }
            }

        }catch(Exception e){
            rj.setException("保存模块信息时");
        }
        return rj;
    }

    /**
     * 判断模块编号是否存在
     * @param nikename
     * @return
     */
    @ResponseBody
    @RequestMapping("checkOcode_json")
    public int checkWidJson(String nikename){
        List<Module> modules = null;
        if(StringUtils.isNotBlank(nikename)){
            modules = moduleService.findByNikename(nikename);
        }
        if(modules != null && !nikename.isEmpty() ){
            return 1;
        }
        return 0;
    }

    /**
     * 删除模块编号信息
     * @param oId
     * @return
     */
    @ResponseBody
    @RequestMapping("del_json")
    public int delJson(Integer oId){
        int n = 0;
        if(oId != null &&  oId > 0){
            n = moduleService.delById(oId);
        }
        return n;
    } 

}
