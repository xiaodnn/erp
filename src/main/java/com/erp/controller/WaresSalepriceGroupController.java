/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.WaresSalepriceGroup;
import com.erp.orm.entity.WaresSalepriceGroupKey;
import com.erp.service.IWaresSalepriceGroupService;
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
 * 商品零售价格组
 * @author scy
 *
 */
@RestController
@RequestMapping("waressalepricegroup")
public class WaresSalepriceGroupController extends BaseController {

    @Resource
    private IWaresSalepriceGroupService waressalepricegroupService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/waressalepricegroup/index");
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

        List<?> waressalepricegroups = waressalepricegroupService.findByPage(page,rows);
        Integer total = waressalepricegroupService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(waressalepricegroups);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<WaresSalepriceGroup> findName(String name){
        if(name == null){
            name = "";
        }
        return waressalepricegroupService.findByName(name);
    }

    @RequestMapping("add")
    public ModelAndView add(String cid){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(cid)){
            cid = "@err";
        }
        map.put("cid", cid);
        return new ModelAndView("/waressalepricegroup/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public WaresSalepriceGroup addJson(Integer spgId,Integer wId){
        WaresSalepriceGroup waressalepricegroup = null;
        if(spgId > 0&& wId > 0){
        	WaresSalepriceGroupKey key = new WaresSalepriceGroupKey(spgId,wId);
            waressalepricegroup = waressalepricegroupService.findById(key);
        }
        return waressalepricegroup;
    }
    /**
     * 保存商品零售价格组信息
     * @param waressalepricegroup
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(WaresSalepriceGroup waressalepricegroup){
        ResultJson rj = new ResultJson();
        try{
            if(waressalepricegroup.getSpgId() == null &&  waressalepricegroup.getSpgId() == null && waressalepricegroup.getwId() > 0){
                
                int n = waressalepricegroupService.saveNotNull(waressalepricegroup);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("保存商品零售价格组信息成功");
                }else{
                    rj.setDesc("保存商品零售价格组信息失败");
                }
                
            }else{
            	int n = waressalepricegroupService.modifyByIdNotNull(waressalepricegroup);
            	if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改商品零售价格组信息成功");
                }else{
                    rj.setDesc("修改商品零售价格组信息失败");
                }
            }

        }catch(Exception e){
            rj.setException("保存商品零售价格组信息时");
        }
        return rj;
    }

    /**
     * 判断商品零售价格组编号是否存在
     * @param oCode
     * @return
     */
    @ResponseBody
    @RequestMapping("checkName_json")
    public int checkWidJson(String name){
        List<WaresSalepriceGroup> waressalepricegroups = null;
        if(StringUtils.isNotBlank(name)){
        	waressalepricegroups = waressalepricegroupService.findByName(name);
        }
        if(waressalepricegroups != null && !waressalepricegroups.isEmpty() ){
            return 1;
        }
        return 0;
    }

    /**
     * 删除商品零售价格组编号信息
     * @param oId
     * @return
     */
    @ResponseBody
    @RequestMapping("del_json")
    public int delJson(Integer spgId,Integer wId){
        int n = 0;
        if(spgId > 0&& wId > 0){
        	WaresSalepriceGroupKey key = new WaresSalepriceGroupKey(spgId,wId);
            n = waressalepricegroupService.delById(key);
        }
        return n;
    } 

}
