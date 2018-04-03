 /**
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.Store;
import com.erp.service.IStoreService;
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
@RequestMapping("store")
public class StoreController extends BaseController {

    @Resource
    private IStoreService storeService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/store/index");
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

        List<Store> stores = storeService.findByPage(page,rows);
        Integer total = storeService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(stores);
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
        return new ModelAndView("/store/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public Store addJson(Integer oId){
        Store store = null;
        if(oId != null && oId > 0){
            store = storeService.findById(oId);
        }
        return store;
    }
    /**
     * 保存机构信息
     * @param store
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(Store store){
        ResultJson rj = new ResultJson();
        try{
            if(store.getsId() != null && store.getsId() > 0){
                int n = storeService.modifyByIdNotNull(store);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改机构信息成功");
                }else{
                    rj.setDesc("修改机构信息失败");
                }
            }else{
                int n = storeService.saveNotNull(store);
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
        Store store = null;
        if(StringUtils.isNotBlank(oCode)){
            store = storeService.findByCode(oCode);
        }
        if(store != null && store.getsId() > 0){
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
            n = storeService.delById(oId);
        }
        return n;
    } 

}
