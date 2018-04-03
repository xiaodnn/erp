/**
 *
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.StoreHouse;
import com.erp.service.IStoreHouseService;
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
 * 仓库信息
 * @author scy
 *
 */
@RestController
@RequestMapping("storehouse")
public class StoreHouseController extends BaseController {

    @Resource
    private IStoreHouseService storehouseService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/storehouse/index");
    }

    @ResponseBody
    @RequestMapping("find_json")
    public List<StoreHouse>  findJson(){
        List<StoreHouse> storehouses = storehouseService.findAll();

        return storehouses;
    }


    @ResponseBody
    @RequestMapping("dg_find")
    public DataGrid dgfind(Integer page, Integer rows){
        if(page == null){
            page = 1;
        }
        page = page -1;

        if(rows == null){
            rows = Constant.ROWS;
        }

        List<StoreHouse> storehouses = storehouseService.findByPage(page,rows);
        Integer total = storehouseService.findCount();

        DataGrid dg = new DataGrid();
        dg.setRows(storehouses);
        dg.setTotal(total);
        return dg;
    }


    @RequestMapping("add")
    public ModelAndView add(String cid){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(cid)){
            cid = "@err";
        }
        map.put("cid", cid);
        return new ModelAndView("/storehouse/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public StoreHouse addJson(Integer oId){
        StoreHouse storehouse = null;
        if(oId != null && oId > 0){
            storehouse = storehouseService.findById(oId);
        }
        return storehouse;
    }
    /**
     * 保存机构信息
     * @param storehouse
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(StoreHouse storehouse){
        ResultJson rj = new ResultJson();
        try{
            if(storehouse.getShId() != null && storehouse.getShId() > 0){
                int n = storehouseService.modifyByIdNotNull(storehouse);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改机构信息成功");
                }else{
                    rj.setDesc("修改机构信息失败");
                }
            }else{
                int n = storehouseService.saveNotNull(storehouse);
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
     * @param shCode
     * @return
     */
    @ResponseBody
    @RequestMapping("checkShCode_json")
    public int checkWidJson(String shCode){
        StoreHouse storehouse = null;
        if(StringUtils.isNotBlank(shCode)){
            storehouse = storehouseService.findByCode(shCode);
        }
        if(storehouse != null && storehouse.getoId() > 0){
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
            n = storehouseService.delById(oId);
        }
        return n;
    } 

}
