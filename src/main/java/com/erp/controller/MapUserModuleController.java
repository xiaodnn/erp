/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.MapUserModule;
import com.erp.orm.entity.Module;
import com.erp.service.IMapUserModuleService;
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
 * 用户权限设置
 * @author scy
 *
 */
@RestController
@RequestMapping("mapusermodule")
public class MapUserModuleController extends BaseController {

    @Resource
    private IMapUserModuleService mapusermoduleService;
    @Resource
    private IModuleService moduleService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        List<Module> modules = moduleService.findByNikename("");
        Map<String,List<Module>> map = new HashMap<String,List<Module>>();
        map.put("modules",modules);
        return new ModelAndView("/mapusermodule/index",map);
    }

    @ResponseBody
    @RequestMapping("dg_all")
    public DataGrid find(Integer page, Integer rows){
        if(page == null){
            page = 1;
        }
        page = page -1;

        if(rows == null){
            rows = Constant.ROWS;
        }

        List<MapUserModule> mapusermodules = mapusermoduleService.findByPage(page,rows);
        Integer total = mapusermoduleService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(mapusermodules);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<MapUserModule> findName(String name){
        if(name == null){
            name = "";
        }
//        return mapusermoduleService.findByName(name);
        return null;
    }


    @RequestMapping("add")
    public ModelAndView add(String cid){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(cid)){
            cid = "@err";
        }
        map.put("cid", cid);
        return new ModelAndView("/mapusermodule/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public MapUserModule addJson(Integer oId){
        MapUserModule mapusermodule = null;
        if(oId != null && oId > 0){
            mapusermodule = mapusermoduleService.findById(oId);
        }
        return mapusermodule;
    }
    /**
     * 保存用户和模块映射信息
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(Integer uId,Integer[] mId){
        ResultJson rj = new ResultJson();
        try{
//            if(uId != null && uId > 0){
//                int n = mapusermoduleService.modifyByIdNotNull(mapusermodule);
//                if(n > 0){
//                    rj.setSuccess();
//                    rj.setDesc("修改用户和模块映射信息成功");
//                }else{
//                    rj.setDesc("修改用户和模块映射信息失败");
//                }
//            }else{
            if(mId != null && mId.length > 0) {

                MapUserModule mapusermodule = null;
                int n = 0;
                for(int i = 0 ;i<mId.length ;i++) {
                    mapusermodule = new MapUserModule();
                    mapusermodule.setuId(uId);
                    mapusermodule.setmId(mId[i]);
                    mapusermodule.setMumState((byte) 1);

                    n = mapusermoduleService.saveNotNull(mapusermodule);
                }
                if (n > 0) {
                    rj.setSuccess();
                    rj.setDesc("保存用户和模块映射信息成功");
                } else {
                    rj.setDesc("保存用户和模块映射信息失败");
                }
            }
//            }

        }catch(Exception e){
            loggerError(this.getClass(),"保存用户和模块映射信息时异常:",e);
            rj.setException("保存用户和模块映射信息时");
        }
        return rj;
    }

    /**
     * 判断用户和模块映射是否存在
     * @param oCode
     * @return
     */
    @ResponseBody
    @RequestMapping("checkOcode_json")
    public int checkWidJson(String oCode){
        MapUserModule mapusermodule = null;
        if(StringUtils.isNotBlank(oCode)){
            mapusermodule = mapusermoduleService.findByCode(oCode);
        }
        if(mapusermodule != null && mapusermodule.getMumId() > 0){
            return 1;
        }
        return 0;
    }

    /**
     * 删除用户和模块映射信息
     * @param oId
     * @return
     */
    @ResponseBody
    @RequestMapping("del_json")
    public int delJson(Integer oId){
        int n = 0;
        if(oId != null &&  oId > 0){
            n = mapusermoduleService.delById(oId);
        }
        return n;
    } 

}
