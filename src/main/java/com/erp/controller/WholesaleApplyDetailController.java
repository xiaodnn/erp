/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.WholesaleApplyDetail;
import com.erp.service.IWholesaleApplyDetailService;
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
@RequestMapping("wholesaleapplydetail")
public class WholesaleApplyDetailController extends BaseController {

    @Resource
    private IWholesaleApplyDetailService wholesaleApplyDetailService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/wholesaleapplydetail/index");
    }

    @ResponseBody
    @RequestMapping("dg_find")
    public DataGrid find(Integer page, Integer rows,Integer waId){
        if(page == null){
            page = 1;
        }
        page = page -1;

        if(rows == null){
            rows = Constant.ROWS;
        }

        List<?> wholesaleapplydetails = wholesaleApplyDetailService.findByPage(page,rows,waId);
        Integer total = wholesaleApplyDetailService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(wholesaleapplydetails);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<WholesaleApplyDetail> findName(String name){
        if(name == null){
            name = "";
        }
        return wholesaleApplyDetailService.findByName(name);
    }

    @RequestMapping("add")
    public ModelAndView add(String cid){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(cid)){
            cid = "@err";
        }
        map.put("cid", cid);
        return new ModelAndView("/wholesaleapplydetail/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public WholesaleApplyDetail addJson(Integer oId){
        WholesaleApplyDetail wholesaleapplydetail = null;
        if(oId != null && oId > 0){
            wholesaleapplydetail = wholesaleApplyDetailService.findById(oId);
        }
        return wholesaleapplydetail;
    }
    /**
     * 保存机构信息
     * @param wholesaleapplydetail
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(WholesaleApplyDetail wholesaleapplydetail){
        ResultJson rj = new ResultJson();
        try{
            if(wholesaleapplydetail.getWadId() != null && wholesaleapplydetail.getWadId() > 0){
                int n = wholesaleApplyDetailService.modifyByIdNotNull(wholesaleapplydetail);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改机构信息成功");
                }else{
                    rj.setDesc("修改机构信息失败");
                }
            }else{
                int n = wholesaleApplyDetailService.saveNotNull(wholesaleapplydetail);
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
        WholesaleApplyDetail wholesaleapplydetail = null;
        if(StringUtils.isNotBlank(oCode)){
            wholesaleapplydetail = wholesaleApplyDetailService.findByCode(oCode);
        }
        if(wholesaleapplydetail != null && wholesaleapplydetail.getWadId() > 0){
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
            n = wholesaleApplyDetailService.delById(oId);
        }
        return n;
    } 

}
