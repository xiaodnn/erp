/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.WholepriceGroup;
import com.erp.service.IWholepriceGroupService;
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
 * 批发价格组
 * @author scy
 *
 */
@RestController
@RequestMapping("wholepricegroup")
public class WholepriceGroupController extends BaseController {

    @Resource
    private IWholepriceGroupService wholepricegroupService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/wholepricegroup/index");
    }

    @ResponseBody
    @RequestMapping("dg_find")
    public DataGrid find(Integer page, Integer rows,Integer id){
        if(page == null){
            page = 1;
        }
        page = page -1;

        if(rows == null){
            rows = Constant.ROWS;
        }

        List<?> wholepricegroups = wholepricegroupService.findByPage(page,rows);
        Integer total = wholepricegroupService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(wholepricegroups);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<WholepriceGroup> findName(String name){
        if(name == null){
            name = "";
        }
        return wholepricegroupService.findByName(name);
    }

    @RequestMapping("add")
    public ModelAndView add(String id){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(id)){
        	id = "";
        }
        map.put("wpgId", id);
        return new ModelAndView("/wholepricegroup/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public WholepriceGroup addJson(Integer id){
        WholepriceGroup wholepricegroup = null;
        if(id != null && id > 0){
            wholepricegroup = wholepricegroupService.findById(id);
        }
        return wholepricegroup;
    }
    /**
     * 保存批发价格组信息
     * @param wholepricegroup
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(WholepriceGroup wholepricegroup){
        ResultJson rj = new ResultJson();
        try{
            if(wholepricegroup.getWpgId() != null && wholepricegroup.getWpgId() > 0){
                int n = wholepricegroupService.modifyByIdNotNull(wholepricegroup);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改批发价格组信息成功");
                }else{
                    rj.setDesc("修改批发价格组信息失败");
                }
            }else{
                int n = wholepricegroupService.saveNotNull(wholepricegroup);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("保存批发价格组信息成功");
                }else{
                    rj.setDesc("保存批发价格组信息失败");
                }
            }

        }catch(Exception e){
            rj.setException("保存批发价格组信息时");
        }
        return rj;
    }

    /**
     * 删除批发价格组编号信息
     * @param oId
     * @return
     */
    @ResponseBody
    @RequestMapping("del_json")
    public int delJson(Integer id){
        int n = 0;
        if(id != null &&  id > 0){
            n = wholepricegroupService.delById(id);
        }
        return n;
    } 

}
