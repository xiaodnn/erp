 /**
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.StoreDetail;
import com.erp.service.IStoreDetailService;
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
@RequestMapping("storedetail")
public class StoreDetailController extends BaseController {

    @Resource
    private IStoreDetailService storeDetailService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/storedetail/index");
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

        List<StoreDetail> storedetails = storeDetailService.findByPage(page,rows);
        Integer total = storeDetailService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(storedetails);
        dg.setTotal(total);
        return dg;
    }

    /**
     * 根据库存ID，查询明细
     * @param sId
     * @return
     */
    @ResponseBody
    @RequestMapping("findsid_json")
    public List<StoreDetail> find_sid(Integer sId ){
        if(sId == null || sId<0){
            return null;
        }

        List<StoreDetail> storedetails = storeDetailService.findBySid(sId);
//        Integer total = storeDetailService.findCount();
//        DataGrid dg = new DataGrid();
//        dg.setRows(storedetails);
//        dg.setTotal(total);
//        return dg;
        return storedetails;
    }

    @RequestMapping("add")
    public ModelAndView add(String cid){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(cid)){
            cid = "@err";
        }
        map.put("cid", cid);
        return new ModelAndView("/storedetail/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public StoreDetail addJson(Integer oId){
        StoreDetail storedetail = null;
        if(oId != null && oId > 0){
            storedetail = storeDetailService.findById(oId);
        }
        return storedetail;
    }
    /**
     * 保存机构信息
     * @param storedetail
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(StoreDetail storedetail){
        ResultJson rj = new ResultJson();
        try{
            if(storedetail.getSdId() != null && storedetail.getSdId() > 0){
                int n = storeDetailService.modifyByIdNotNull(storedetail);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改机构信息成功");
                }else{
                    rj.setDesc("修改机构信息失败");
                }
            }else{
                int n = storeDetailService.saveNotNull(storedetail);
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
        StoreDetail storedetail = null;
        if(StringUtils.isNotBlank(oCode)){
            storedetail = storeDetailService.findByCode(oCode);
        }
        if(storedetail != null && storedetail.getSdId() > 0){
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
            n = storeDetailService.delById(oId);
        }
        return n;
    } 

}
