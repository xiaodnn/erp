 /**
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.StoreZone;
import com.erp.service.IStoreZoneService;
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
 * 库区信息
 * @author scy
 *
 */
@RestController
@RequestMapping("storezone")
public class StoreZoneController extends BaseController {

    @Resource
    private IStoreZoneService storezoneService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/storezone/index");
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

        List<StoreZone> storezones = storezoneService.findByPage(page,rows);
        Integer total = storezoneService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(storezones);
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
        return new ModelAndView("/storezone/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public StoreZone addJson(Integer oId){
        StoreZone storezone = null;
        if(oId != null && oId > 0){
            storezone = storezoneService.findById(oId);
        }
        return storezone;
    }
    /**
     * 保存机构信息
     * @param storezone
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(StoreZone storezone){
        ResultJson rj = new ResultJson();
        try{
            if(storezone.getSzId() != null && storezone.getSzId() > 0){
                int n = storezoneService.modifyByIdNotNull(storezone);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改机构信息成功");
                }else{
                    rj.setDesc("修改机构信息失败");
                }
            }else{
                int n = storezoneService.saveNotNull(storezone);
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
     * @param szCode
     * @return
     */
    @ResponseBody
    @RequestMapping("checkCode_json")
    public int checkWidJson(String szCode){
        StoreZone storezone = null;
        if(StringUtils.isNotBlank(szCode)){
            storezone = storezoneService.findByCode(szCode);
        }
        if(storezone != null && storezone.getSzId() > 0){
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
            n = storezoneService.delById(oId);
        }
        return n;
    } 

}
