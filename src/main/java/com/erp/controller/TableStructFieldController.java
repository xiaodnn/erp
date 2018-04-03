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
import com.erp.model.JsonTableStructField;
import com.erp.orm.entity.TableStructField;
import com.erp.service.ITableStructFieldService;
import com.erp.utils.DataGrid;
import com.erp.utils.GsonUtils;
import com.erp.utils.ResultJson;

/**
 * 表结构字段信息
 * @author scy
 *
 */
@RestController
@RequestMapping("tablestructfield")
public class TableStructFieldController extends BaseController {

    @Resource
    private ITableStructFieldService tableStructFieldService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/tablestructfield/index");
    }

    @ResponseBody
    @RequestMapping("dg_find")
    public DataGrid find(Integer page, Integer rows){
        if(page == null){
            page = 1;
        }
        page = page -1;

        if(rows == null){
            rows = Constant.ROWS;
        }

        List<?> tablestructfields = tableStructFieldService.findByPage(page,rows);
        Integer total = tableStructFieldService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(tablestructfields);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<TableStructField> findName(String name){
        if(name == null){
            name = "";
        }
        return tableStructFieldService.findByName(name);
    }

    @RequestMapping("add")
    public ModelAndView add(String id){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(id)){
            id = "";
        }
        map.put("id", id);
        return new ModelAndView("/tablestructfield/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public TableStructField addJson(Integer id){
        TableStructField tablestructfield = null;
        if(id != null && id > 0){
            tablestructfield = tableStructFieldService.findById(id);
        }
        return tablestructfield;
    }
    /**
     * 保存表结构字段信息信息
     * @param tablestructfield
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(Integer tsId,String add, String del, String modify){
        ResultJson rj = new ResultJson();
        StringBuffer msg = new StringBuffer();
        try{
            if(tsId != null && tsId > 0){
            	//添加入库明细
				if(StringUtils.isNotBlank(add)){
					//把json字符串转换成对象
					List<JsonTableStructField> insertList = GsonUtils.jsonToJsonTableStructFieldList(add);//JSON.parseArray(inserted, TableStructField.class);
					if(insertList != null && !insertList.isEmpty()){
						int addnum = 0;
						for(JsonTableStructField jts : insertList){
							TableStructField ts = new TableStructField(jts);
							ts.setTsId(tsId);//入库ID
							addnum += tableStructFieldService.saveNotNull(ts);
						}
						msg.append("添加入库明细记录:"+ addnum +" 条.");
					}
				}
            	//删除入库明细
				if(StringUtils.isNotBlank(del)){
					//把json字符串转换成对象
					List<JsonTableStructField> listDeleted = GsonUtils.jsonToJsonTableStructFieldList(del) ;//JSON.parseArray(deleted, TableStructField.class);
					//下面就可以根据转换后的对象进行相应的操作了
					if(listDeleted != null && !listDeleted.isEmpty()) {
						int delnum = 0;
						for (JsonTableStructField jts : listDeleted) {
							TableStructField ts = new TableStructField(jts);
							delnum += tableStructFieldService.delById(ts.getTsfId());//根据入库单号和商品ID删除							
						}
						msg.append("删除入库明细记录:" + delnum + " 条.");
					}
				}
				
				//修改入库明细
				if(StringUtils.isNotBlank(modify)){
					//把json字符串转换成对象
					List<JsonTableStructField> listUpdated = GsonUtils.jsonToJsonTableStructFieldList(modify);// JSON.parseArray(updated, TableStructField.class);
					if(listUpdated != null && !listUpdated.isEmpty()) {
						int mdfnum = 0;
						for (JsonTableStructField jts : listUpdated) {
							TableStructField ts = new TableStructField(jts);
							ts.setTsId(tsId);//入库ID
							mdfnum += tableStructFieldService.modifyByIdNotNull(ts);
						}
						msg.append("修改入库明细记录:" + mdfnum+ " 条.");
					}
				}
            }
        }catch(Exception e){
        	loggerError(this.getClass(), "保存字段信息异常:", e);
            rj.setException("保存表结构字段信息信息时");
        }
        return rj;
    }

    /**
     * 判断表结构字段信息编号是否存在
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("checkName_json")
    public int checkWidJson(String name){
        List<TableStructField> tablestructfields = null;
        if(StringUtils.isNotBlank(name)){
        	tablestructfields = tableStructFieldService.findByName(name);
        }
        if(tablestructfields != null && !tablestructfields.isEmpty()){
            return 1;
        }
        return 0;
    }

    /**
     * 删除表结构字段信息编号信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("del_json")
    public int delJson(Integer id){
        int n = 0;
        if(id != null &&  id > 0){
            n = tableStructFieldService.delById(id);
        }
        return n;
    } 

}
