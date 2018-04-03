/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.SalepriceGroup;
import com.erp.service.ISalepriceGroupService;
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
 * 零售价格组
 * @author scy
 *
 */
@RestController
@RequestMapping("salepricegroup")
public class SalepriceGroupController extends BaseController {

    @Resource
    private ISalepriceGroupService salepricegroupService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/salepricegroup/index");
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

        List<SalepriceGroup> salepricegroups = salepricegroupService.findByPage(page,rows);
        Integer total = salepricegroupService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(salepricegroups);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<SalepriceGroup> findName(String name){
        if(name == null){
            name = "";
        }
        return salepricegroupService.findByName(name);
    }

    @RequestMapping("add")
    public ModelAndView add(String cid){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(cid)){
            cid = "@err";
        }
        map.put("cid", cid);
        return new ModelAndView("/salepricegroup/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public SalepriceGroup addJson(Integer oId){
        SalepriceGroup salepricegroup = null;
        if(oId != null && oId > 0){
            salepricegroup = salepricegroupService.findById(oId);
        }
        return salepricegroup;
    }
    /**
     * 保存零售价格组信息
     * @param salepricegroup
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(SalepriceGroup salepricegroup){
        ResultJson rj = new ResultJson();
        try{
            if(salepricegroup.getSpgId() != null && salepricegroup.getSpgId() > 0){
                int n = salepricegroupService.modifyByIdNotNull(salepricegroup);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改零售价格组信息成功");
                }else{
                    rj.setDesc("修改零售价格组信息失败");
                }
            }else{
                int n = salepricegroupService.saveNotNull(salepricegroup);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("保存零售价格组信息成功");
                }else{
                    rj.setDesc("保存零售价格组信息失败");
                }
            }

        }catch(Exception e){
            rj.setException("保存零售价格组信息时");
        }
        return rj;
    }

    /**
     * 判断零售价格组编号是否存在
     * @param oCode
     * @return
     */
    @ResponseBody
    @RequestMapping("checkName_json")
    public int checkWidJson(String name){
        List<SalepriceGroup> salepricegroups = null;
        if(StringUtils.isNotBlank(name)){
        	salepricegroups = salepricegroupService.findByName(name);
        }
        if(salepricegroups != null && !salepricegroups.isEmpty()){
            return 1;
        }
        return 0;
    }

    /**
     * 删除零售价格组编号信息
     * @param oId
     * @return
     */
    @ResponseBody
    @RequestMapping("del_json")
    public int delJson(Integer oId){
        int n = 0;
        if(oId != null &&  oId > 0){
            n = salepricegroupService.delById(oId);
        }
        return n;
    } 

}
