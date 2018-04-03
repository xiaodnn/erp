/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.Indent;
import com.erp.service.IIndentService;
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
 * 采购合同
 * @author scy
 *
 */
@RestController
@RequestMapping("indent")
public class IndentController extends BaseController {

    @Resource
    private IIndentService indentService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/indent/index");
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

        List<?> indents = indentService.findByPage(page,rows);
        Integer total = indentService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(indents);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<Indent> findName(String name){
        if(name == null){
            name = "";
        }
        return indentService.findByName(name);
    }

    @RequestMapping("add")
    public ModelAndView add(String id){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(id)){
            id = "@err";
        }
        map.put("id", id);
        return new ModelAndView("/indent/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public Indent addJson(Integer iId){
        Indent indent = null;
        if(iId != null && iId > 0){//1.oId != null && oId > 0  2.StringUtils.isNotBlank(iidd)
            indent = indentService.findById(iId);
        }
        return indent;
    }
    /**
     * 保存机构信息
     * @param indent
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(Indent indent){
        ResultJson rj = new ResultJson();
        try{
        	//判断主键是否为空
            if(indent.getiId() != null && indent.getiId() > 0){
                int n = indentService.modifyByIdNotNull(indent);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改机构信息成功");
                }else{
                    rj.setDesc("修改机构信息失败");
                }
            }else{
                int n = indentService.saveNotNull(indent);
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
        Indent indent = null;
        if(StringUtils.isNotBlank(oCode)){
            //indent = indentService.findByCode(oCode);
        }
        if(indent != null && indent.getoId() > 0){
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
    public int delJson(Integer iId){
        int n = 0;
        if(iId != null && iId > 0){//1.oId != null && oId > 0  2.StringUtils.isNotBlank(iidd)
            n = indentService.delById(iId);
        }
        return n;
    } 

}
