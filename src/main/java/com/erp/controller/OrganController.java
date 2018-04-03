/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.Organ;
import com.erp.service.IOrganService;
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
@RequestMapping("organ")
public class OrganController extends BaseController {

    @Resource
    private IOrganService organService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/organ/index");
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

        List<?> organs = organService.findByPage(page,rows);
        Integer total = organService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(organs);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<Organ> findName(String name){
        if(name == null){
            name = "";
        }
        return organService.findByName(name);
    }

    @RequestMapping("add")
    public ModelAndView add(String cid){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(cid)){
            cid = "@err";
        }
        map.put("cid", cid);
        return new ModelAndView("/organ/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public Organ addJson(Integer oId){
        Organ organ = null;
        if(oId != null && oId > 0){
            organ = organService.findById(oId);
        }
        return organ;
    }
    /**
     * 保存机构信息
     * @param organ
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(Organ organ){
        ResultJson rj = new ResultJson();
        try{
            if(organ.getoId() != null && organ.getoId() > 0){
                int n = organService.modifyByIdNotNull(organ);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改机构信息成功");
                }else{
                    rj.setDesc("修改机构信息失败");
                }
            }else{
                int n = organService.saveNotNull(organ);
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
        Organ organ = null;
        if(StringUtils.isNotBlank(oCode)){
            organ = organService.findByCode(oCode);
        }
        if(organ != null && organ.getoId() > 0){
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
            n = organService.delById(oId);
        }
        return n;
    } 

}
