/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.WholesaleDetail;
import com.erp.service.IWholesaleDetailService;
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
@RequestMapping("wholesaledetail")
public class WholesaleDetailController extends BaseController {

    @Resource
    private IWholesaleDetailService wholesaleDetailService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/wholesaledetail/index");
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

        List<?> wholesaledetails = wholesaleDetailService.findByPage(page,rows);
        Integer total = wholesaleDetailService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(wholesaledetails);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<WholesaleDetail> findName(String name){
        if(name == null){
            name = "";
        }
        return wholesaleDetailService.findByName(name);
    }

    @RequestMapping("add")
    public ModelAndView add(String cid){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(cid)){
            cid = "@err";
        }
        map.put("cid", cid);
        return new ModelAndView("/wholesaledetail/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public WholesaleDetail addJson(Integer oId){
        WholesaleDetail wholesaledetail = null;
        if(oId != null && oId > 0){
            wholesaledetail = wholesaleDetailService.findById(oId);
        }
        return wholesaledetail;
    }
    /**
     * 保存机构信息
     * @param wholesaledetail
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(WholesaleDetail wholesaledetail){
        ResultJson rj = new ResultJson();
        try{
            if(wholesaledetail.getWsdId() != null && wholesaledetail.getWsdId() > 0){
                int n = wholesaleDetailService.modifyByIdNotNull(wholesaledetail);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改机构信息成功");
                }else{
                    rj.setDesc("修改机构信息失败");
                }
            }else{
                int n = wholesaleDetailService.saveNotNull(wholesaledetail);
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
        WholesaleDetail wholesaledetail = null;
        if(StringUtils.isNotBlank(oCode)){
            wholesaledetail = wholesaleDetailService.findByCode(oCode);
        }
        if(wholesaledetail != null && wholesaledetail.getWsdId() > 0){
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
            n = wholesaleDetailService.delById(oId);
        }
        return n;
    } 

}
