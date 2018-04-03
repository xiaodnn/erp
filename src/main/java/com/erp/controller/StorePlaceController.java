 /**
  *
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.StorePlace;
import com.erp.service.IStorePlaceService;
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
 * 货位信息
 * @author scy
 *
 */
@RestController
@RequestMapping("storeplace")
public class StorePlaceController extends BaseController {

    @Resource
    private IStorePlaceService storeplaceService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/storeplace/index");
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

        List<StorePlace> storeplaces = storeplaceService.findByPage(page,rows);
        Integer total = storeplaceService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(storeplaces);
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
        return new ModelAndView("/storeplace/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public StorePlace addJson(Integer oId){
        StorePlace storeplace = null;
        if(oId != null && oId > 0){
            storeplace = storeplaceService.findById(oId);
        }
        return storeplace;
    }
    /**
     * 保存机构信息
     * @param storeplace
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(StorePlace storeplace){
        ResultJson rj = new ResultJson();
        try{
            if(storeplace.getSpId() != null && storeplace.getSpId() > 0){
                int n = storeplaceService.modifyByIdNotNull(storeplace);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改机构信息成功");
                }else{
                    rj.setDesc("修改机构信息失败");
                }
            }else{
                int n = storeplaceService.saveNotNull(storeplace);
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
     * @param spCode
     * @return
     */
    @ResponseBody
    @RequestMapping("checkOcode_json")
    public int checkWidJson(String spCode){
        StorePlace storeplace = null;
        if(StringUtils.isNotBlank(spCode)){
            storeplace = storeplaceService.findByCode(spCode);
        }
        if(storeplace != null && storeplace.getSpId() > 0){
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
            n = storeplaceService.delById(oId);
        }
        return n;
    } 

}
