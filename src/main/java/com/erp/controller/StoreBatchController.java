 /**
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.StoreBatch;
import com.erp.service.IStoreBatchService;
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
@RequestMapping("storebatch")
public class StoreBatchController extends BaseController {

    @Resource
    private IStoreBatchService storeBatchService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/storebatch/index");
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

        List<StoreBatch> storebatchs = storeBatchService.findByPage(page,rows);
        Integer total = storeBatchService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(storebatchs);
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
        return new ModelAndView("/storebatch/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public StoreBatch addJson(Integer oId){
        StoreBatch storebatch = null;
        if(oId != null && oId > 0){
            storebatch = storeBatchService.findById(oId);
        }
        return storebatch;
    }
    /**
     * 保存机构信息
     * @param storebatch
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(StoreBatch storebatch){
        ResultJson rj = new ResultJson();
        try{
            if(storebatch.getSbId() != null && storebatch.getSbId() > 0){
                int n = storeBatchService.modifyByIdNotNull(storebatch);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改机构信息成功");
                }else{
                    rj.setDesc("修改机构信息失败");
                }
            }else{
                int n = storeBatchService.saveNotNull(storebatch);
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
        StoreBatch storebatch = null;
        if(StringUtils.isNotBlank(oCode)){
            storebatch = storeBatchService.findByCode(oCode);
        }
        if(storebatch != null && storebatch.getSbId() > 0){
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
            n = storeBatchService.delById(oId);
        }
        return n;
    } 

}
