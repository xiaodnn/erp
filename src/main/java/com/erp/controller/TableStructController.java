/**
 * 
 */
package com.erp.controller;

import javax.annotation.Resource;

import com.erp.common.BaseController;
import com.erp.common.Constant;
import com.erp.orm.entity.TableStruct;
import com.erp.orm.entity.TableStructField;
import com.erp.service.ITableStructService;
import com.erp.utils.DataGrid;
import com.erp.utils.LoggerUtil;
import com.erp.utils.ResultJson;
import com.gen.AutoGenUtil;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 表结构信息
 * @author scy
 *
 */
@RestController
@RequestMapping("tablestruct")
public class TableStructController extends BaseController {

    @Resource
    private ITableStructService tablestructService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/tablestruct/index");
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

        List<?> tablestructs = tablestructService.findByPage(page,rows);
        Integer total = tablestructService.findCount();
        DataGrid dg = new DataGrid();
        dg.setRows(tablestructs);
        dg.setTotal(total);
        return dg;
    }

    @ResponseBody
    @RequestMapping("find_name")
    public List<TableStruct> findName(String name){
        if(name == null){
            name = "";
        }
        List<TableStruct> tableStructs = tablestructService.findByName(name);
        return tableStructs;
    }

    @ResponseBody
    @RequestMapping("find_id")
    public TableStruct findId(Integer id){
    	TableStruct tableStruct = null;
        if(id != null && id > 0){
        	tableStruct = tablestructService.findById(id);
        }
        return tableStruct;
    }

    
    @RequestMapping("add")
    public ModelAndView add(String id){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtils.isBlank(id)){
        	id = "";
        }
        map.put("id", id);
        return new ModelAndView("/tablestruct/add",map);
    }
    /**
     * 打开添加页面
     * @return
     */
    @ResponseBody
    @RequestMapping("add_json")
    public TableStruct addJson(Integer oId){
        TableStruct tablestruct = null;
        if(oId != null && oId > 0){
            tablestruct = tablestructService.findById(oId);
        }
        return tablestruct;
    }
    /**
     * 保存表结构信息信息
     * @param tablestruct
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultJson save(TableStruct tablestruct){
        ResultJson rj = new ResultJson();
        try{
            if(tablestruct.getTsId() != null && tablestruct.getTsId() > 0){
                int n = tablestructService.modifyByIdNotNull(tablestruct);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("修改表结构信息信息成功");
                }else{
                    rj.setDesc("修改表结构信息信息失败");
                }
            }else{
                int n = tablestructService.saveNotNull(tablestruct);
                if(n > 0){
                    rj.setSuccess();
                    rj.setDesc("保存表结构信息信息成功");
                }else{
                    rj.setDesc("保存表结构信息信息失败");
                }
            }

        }catch(Exception e){
            rj.setException("保存表结构信息信息时");
        }
        return rj;
    }

    /**
     * 判断表结构信息编号是否存在
     * @param oCode
     * @return
     */
    @ResponseBody
    @RequestMapping("checkOcode_json")
    public int checkWidJson(String name){
        List<TableStruct> tablestructs = null;
        if(StringUtils.isNotBlank(name)){
            tablestructs = tablestructService.findByName(name);
        }
        if(tablestructs != null && !tablestructs.isEmpty()){
            return 1;
        }
        return 0;
    }

    /**
     * 删除表结构信息编号信息
     * @param oId
     * @return
     */
    @ResponseBody
    @RequestMapping("del_json")
    public int delJson(Integer id){
        int n = 0;
        if(id != null &&  id > 0){
            n = tablestructService.delById(id);
        }
        return n;
    }
    
    @ResponseBody
    @RequestMapping("create_table")
    public ResultJson createTable(Integer id){
    	ResultJson rj = new ResultJson();
    	
    	TableStruct tsMain = null ;
    	TableStruct tsSub = null ;

        if(id != null && id > 0){
        	tsSub = tablestructService.findById(id);
        }
            
        if(tsSub != null){
        	if(tsSub.getTsType() == 2){//单据类型
        		tsMain = tablestructService.findById(tsSub.getTsMid());
        	}
        	String sql = createbale(tsSub);
        	//执行创建表 SQL
        	int n = tablestructService.createTable(sql);   
        	System.out.println("---create:"+n);
        	LoggerUtil.info(this.getClass(), "创建表SQL:"+sql);
        	String tableName = tsSub.getTsName();
        	//表名转实体名
        	String entityName =  "";
        	String []entityNames = tableName.split("_");
        	int len = entityNames.length;
        	for(int i=1;i< len ; i++){
        		entityName += entityNames[i].substring(0, 1).toUpperCase()+entityNames[i].substring(1);
        	}
        	
        	int nn = AutoGenUtil.genMapperToPage(tsMain,tsSub,tableName, entityName);
        	System.out.println("---gen:"+nn);
        	
        	
        	rj.setSuccess();
        }
    	return rj;
    }

	private String createbale(TableStruct ts) {
//-- 表结构信息表
//create table ts_table_struct(
//	ts_id int(2) auto_increment PRIMARY key comment '自增ID',
//	ts_name varchar(30) not null comment '表名',
//	ts_nikename varchar(50) not null comment '表简称',
//	ts_type tinyint(1) null comment '表类型',
//	ts_mId int(2) null comment '主表ID',
//	ts_remark varchar(100) null comment '备注',
//	intime datetime null default CURRENT_TIMESTAMP comment '创建时间' 
//)
		StringBuffer sql = new StringBuffer();
		sql.append(" create table ");
		sql.append( ts.getTsName());
		sql.append(" ( ");
		List<TableStructField> tsfs = ts.getTableStructFields();
		if(tsfs == null || tsfs.isEmpty()){
			return null;
		}
		int len = tsfs.size();
		for(int i = 0 ; i < len ; i++){
			TableStructField tsf = tsfs.get(i);
			//ts_id int(2) auto_increment PRIMARY key comment '自增ID',
			sql.append(tsf.getTsfName());//字段名
			sql.append(" ");
			//字段类型 长度
			if(tsf.getTsfType().indexOf("date")>=0){
				sql.append(tsf.getTsfType());//日期类型没有长度
				sql.append(" ");
			}else{
				sql.append(tsf.getTsfType());//类型
				sql.append("(");
				sql.append(tsf.getTsfLen());//长度
				sql.append(") ");			
			}
			//是否自增
			if((tsf.getTsfNikename()).indexOf("自增") >= 0){
				sql.append(" auto_increment ");
			}
			//是否允许为空
			if("key".equals(tsf.getTsfKey())){
				sql.append(" primary key ");
			}else if("1".equals(tsf.getTsfNotNull())){//非空
				sql.append(" not null ");
			}else{
				sql.append(" null ");
			}
			//是否有默认值
			if(StringUtils.isNotBlank(tsf.getTsfDefault())){
				sql.append(" default ");
				sql.append(tsf.getTsfDefault());
				sql.append(" ");				
			}
			sql.append(" comment '");
			sql.append(tsf.getTsfRemark());
			sql.append("' ");
			if(i < (len-1)){
				sql.append(" ,");
			}
		}		
		sql.append(" ) ");
		
		return sql.toString();
	}
	
	
	public static void main(String [] args){
//		String tableName = "tb_test_struct";
//    	
//    	String entityName =  ""; 
//    	
//    	String []entityNames = tableName.split("_");
//    	int len = entityNames.length;
//    	for(int i=1;i< len ; i++){
//    		entityName += entityNames[i].substring(0, 1).toUpperCase()+entityNames[i].substring(1);
//    	}
//    	System.out.println(entityName);
    	
    	
		String s = "domainObjectName=\"Test\"";
		int n1 = 0;
		int n2 = 0;
		int i = s.indexOf("domainObjectName");
		if(i >= 0){
			n1 = s.substring(i+1).indexOf("\"");
			n2 = s.indexOf("\"",n1+1);
			String ss = s.substring(n1, n2);
			System.out.println(ss);
		}
		
	}

}
