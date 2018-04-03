/**
 * 
 */
package com.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.WaresWholepriceGroup;
import com.erp.orm.entity.WaresWholepriceGroupKey;
import com.erp.service.IWaresWholepriceGroupService;
import com.erp.utils.DataGrid;
import com.erp.utils.ResultJson;

/**
 * 商品批发价格组
 * @author scy
 *
 */
@RestController
@RequestMapping("wareswholepricegroup")
public class WaresWholepriceGroupController extends BaseController {

    @Resource
    private IWaresWholepriceGroupService wareswholepricegroupService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/wareswholepricegroup/index");
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

        List<?> wareswholepricegroups = wareswholepricegroupService.findByPage(page,rows);
        Integer total = wareswholepricegroupService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(wareswholepricegroups);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<WaresWholepriceGroup> findName(String name){
        if(name == null){
            name = "";
        }
        return wareswholepricegroupService.findByName(name);
    }

    @RequestMapping("add")
    public ModelAndView add(String cid){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(cid)){
            cid = "@err";
        }
        map.put("cid", cid);
        return new ModelAndView("/wareswholepricegroup/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public WaresWholepriceGroup addJson(Integer wpgId,Integer wId){
        WaresWholepriceGroup wareswholepricegroup = null;
        if(wpgId != null && wpgId > 0 && wId != null && wId > 0){
        	WaresWholepriceGroupKey key = new WaresWholepriceGroupKey(wpgId,wId);
            wareswholepricegroup = wareswholepricegroupService.findById(key);
        }
        return wareswholepricegroup;
    }
    /**
     * 保存商品批发价格组信息
     * @param wareswholepricegroup
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(WaresWholepriceGroup wareswholepricegroup){
        ResultJson rj = new ResultJson();
        try{
            if(wareswholepricegroup != null && wareswholepricegroup.getWpgId() == null && wareswholepricegroup.getwId() > 0){
            	int n = wareswholepricegroupService.saveNotNull(wareswholepricegroup);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("保存商品批发价格组信息成功");
                }else{
                    rj.setDesc("保存商品批发价格组信息失败");
                }
            }else{
            	int n = wareswholepricegroupService.modifyByIdNotNull(wareswholepricegroup);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改商品批发价格组信息成功");
                }else{
                    rj.setDesc("修改商品批发价格组信息失败");
                }
            }

        }catch(Exception e){
            rj.setException("保存商品批发价格组信息时");
        }
        return rj;
    }

    /**
     * 判断商品批发价格组编号是否存在
     * @param oCode
     * @return
     */
    @ResponseBody
    @RequestMapping("checkName_json")
    public int checkWidJson(String name){
        List<WaresWholepriceGroup> wareswholepricegroups = null;
        if(StringUtils.isNotBlank(name)){
        	wareswholepricegroups = wareswholepricegroupService.findByName(name);
        }
        if(wareswholepricegroups != null && !wareswholepricegroups.isEmpty()){
            return 1;
        }
        return 0;
    }

    /**
     * 删除商品批发价格组编号信息
     * @param oId
     * @return
     */
    @ResponseBody
    @RequestMapping("del_json")
    public int delJson(Integer wpgId,Integer wId){
        int n = 0;
        if(wpgId != null && wpgId > 0 && wId != null && wId > 0){
        	WaresWholepriceGroupKey key = new WaresWholepriceGroupKey(wpgId,wId);
            n = wareswholepricegroupService.delById(key);
        }
        return n;
    } 

}
