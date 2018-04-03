package com.gen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.erp.orm.entity.TableStruct;
import com.erp.orm.entity.TableStructField;

public class GenPage {
	/**
	 * 自动生成页面文件
	 * @param tsMain 主单内容 (当为普通页面时为空)
	 * @param tsSub 普通页面时，为主单内容，单据页面时为单据页面中子信息
	 * @param rootPath
	 * @param name
	 */
	public static void createPage(TableStruct tsMain,TableStruct tsSub,String rootPath,String name){
		try{
			rootPath = rootPath.substring(0,rootPath.length()-4);//根路径
	        String viewsPath = "/webapp/WEB-INF/views/";//页面路径
			String desname = name.toLowerCase();//目标文件夹名称
			
			String path = rootPath+viewsPath+desname;
			File file = new File(path);
			if(!file.exists()){//目录不存在，则创建
				file.mkdirs();
				System.out.println("-------目录创建:"+path);
	        }
//			System.out.println("-------目录------------");
			//文件名
			String filename = "/index.jsp";
			if(tsSub != null && StringUtils.isNotBlank(tsSub.getTsName())){
				String s = "";
				if(tsSub.getTsType() == 1 ){//普通类型
					System.out.println("-------普通类型页面------");
					s = normalType(tsSub,desname);
				}else if(tsSub.getTsType() == 2){//单据类型
					System.out.println("-------单据类型页面------");
					s = billType(tsMain,tsSub,desname);
				}
				
				FileWriter writer = new FileWriter(path+filename);
				writer.write(s);				
				writer.flush();
				writer.close();
				System.out.println("--------页面创建完成:"+path+filename);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/**
	 * 普通页面
	 * @param tableStruct
	 */
	private static String normalType(TableStruct ts,String name) {
		StringBuffer s = new StringBuffer("");
		try{
			s.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>\r\n");			
			s.append("\t<div id=\"tb_bbbbb\" style=\"padding:5px;height:auto\">\r\n".replaceAll("bbbbb", name));
			s.append("\t\t<div id=\"bbbbb_tool\" style=\"margin-bottom:5px\">\r\n".replaceAll("bbbbb", name));
			s.append("\t\t\t<a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\" onclick=\"add_bbbbb()\"></a>\r\n".replaceAll("bbbbb", name));
			s.append("\t\t\t<a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onclick=\"modify_bbbbb()\"></a>\r\n".replaceAll("bbbbb", name));
			s.append("\t\t\t<a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onclick=\"del_bbbbb()\"></a>\r\n".replaceAll("bbbbb", name));
			s.append("\t\t</div>\r\n");
			s.append("\t\t<div>\r\n");
			s.append("\t\t\t日期: <input class=\"easyui-datebox\" style=\"width:80px\" />\r\n");
			s.append("\t\t\t至:<input class=\"easyui-datebox\" style=\"width:80px\" />\r\n");
			s.append("\t\t\t名称: <input class=\"easyui-textbox\" style=\"width:100px\" id=\"s_wId\" />\r\n");
			s.append("\t\t\t<a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-search\" onclick=\"find_bbbbb()\">查找</a>\r\n".replaceAll("bbbbb", name));
			s.append("\t\t</div>\r\n");
			s.append("\t</div>\r\n");
			s.append("\t<table id=\"dg_bbbbb\" class=\"easyui-datagrid\" style=\"width:100%;height:100%;\" title=\"1111信息信息\" data-options=\"toolbar:'#tb_bbbbb',singleSelect:true,fitColumns:true,rownumbers:true,pagination:true,datapagesize:5\">\r\n".replaceAll("bbbbb", name));
			s.append("\t\t<thead>\r\n");
			s.append("\t\t\t<tr>\r\n");
			//循环 datagrid 列
//			Field [] field = Class.forName(name).getClass().getDeclaredFields();//根据实体类名获取属性名称
			for(TableStructField tsf : ts.getTableStructFields()){
				s.append("\t\t\t\t<th data-options=\"field:'");				
				s.append(getFieldName(tsf.getTsfName()));
				s.append("',width:80\">");
				s.append(tsf.getTsfNikename());
				s.append("</th>\r\n");
			}
			s.append("\t\t\t</tr>\r\n");
			s.append("\t\t</thead>\r\n");
			s.append("\t</table>\r\n");
			
			s.append("\t<div id=\"dlg_bbbbb\" class=\"easyui-dialog\" title=\"新增aaaaa信息\" style=\"width:500px;height:250px;padding:10px;\"\r\n".replaceAll("bbbbb", name).replaceAll("aaaaa", ts.getTsNikename()));
			s.append("\t\tdata-options=\"closed:true,\r\n");
			s.append("\t\t\tbuttons: [{\r\n");
			s.append("\t\t\t\ttext:'保存',\r\n");
			s.append("\t\t\t\ticonCls:'icon-ok',\r\n");
			s.append("\t\t\t\thandler:function(){\r\n");
			s.append("\t\t\t\t\tsubmit_form();\r\n");
			s.append("\t\t\t\t}\r\n");
			s.append("\t\t\t},{\r\n");
			s.append("\t\t\t\ttext:'取消',\r\n");
			s.append("\t\t\t\thandler:function(){\r\n");
			s.append("\t\t\t\t\tdialog_close();\r\n");
			s.append("\t\t\t\t}\r\n");
			s.append("\t\t\t}]\">\r\n");
			s.append("\t\t<form id=\"ff_bbbbb\" class=\"easyui-form\" method=\"post\" action=\"/erp/bbbbb/save.yy\" data-options=\"novalidate:false\">\r\n".replaceAll("bbbbb", name));
			s.append("\t\t\t<input type=\"hidden\" id=\"");
			
			String idName = getFieldName(ts.getTableStructFields().get(0).getTsfName());
			s.append(idName);
			s.append("\" name=\"");
			s.append(idName);
			s.append("\" value=\"${");
			s.append(idName);
			s.append("}\" />\r\n");
			
			s.append("\t\t\t<table>\r\n");
			int i = 0 ;			
			List<TableStructField> tsfs = ts.getTableStructFields();
			
			int len = tsfs.size();
			s.append("\t\t\t\t<tr>\r\n");
			for(i=1;i<len;i++){
				TableStructField tsf = tsfs.get(i);				
				s.append("\t\t\t\t\t<td align=\"right\">");				
				s.append(tsf.getTsfNikename());//显示文字
				s.append(":</td>\r\n");
				s.append("\t\t\t\t\t<td><input class=\"");
				s.append(tsf.getTsfFormtype());//表单类型
				s.append("\" ");				
				String fieldname = getFieldName(tsf.getTsfName());//实体属性名
				s.append("id=\"");
				s.append(fieldname);
				s.append("\" name=\"");
				s.append(fieldname);
				s.append("\" data-options=\"required:");
				if("是".equals(tsf.getTsfNotNull())){//必填
					s.append("true");
				}else{//
					s.append("false");
				}				
				s.append("\" /></td>\r\n");
				if( i%2 == 0 || i == (len-1)){
					s.append("\t\t\t\t</tr>\r\n");					
					//结束
					if(i == (len-1)){
						s.append("\t\t\t</table>\r\n");
						break;
					}
					
					if(i < (len-1)){//还有列
						s.append("\t\t\t\t<tr>\r\n");
					}
				}
			}			
			s.append("\t\t</form>\r\n");
			s.append("\t</div>\r\n");
			s.append("\r\n");
			
			//js
			s.append("<script>\r\n");
			s.append("\t$(function(){\r\n");
			s.append("\t\tinit();\r\n");
			s.append("\t});\r\n");
			
			s.append("\tfunction init(){\r\n");
			s.append("\t\t$('#dg_bbbbb').datagrid({\r\n".replaceAll("bbbbb", name));			
			s.append("\t\t\turl:'/erp/bbbbb/dg_find.yy'\r\n".replaceAll("bbbbb", name));
			s.append("\t\t});\r\n");
			s.append("\t}\r\n");
			
			s.append("\tfunction add_bbbbb(){\r\n".replaceAll("bbbbb", name));
			s.append("\t\tdialog_open();\r\n");
			s.append("\t}\r\n");
			
			s.append("\tfunction modify_bbbbb(){\r\n".replaceAll("bbbbb", name));
			s.append("\t\tvar row = $('#dg_bbbbb').datagrid('getSelected');\r\n".replaceAll("bbbbb", name));
			s.append("\t\tif (row== null){\r\n");
			s.append("\t\t\t$.messager.alert('Info', \"请选择需要更新的行\", 'error');\r\n");
			s.append("\t\t\treturn ;\r\n");
			s.append("\t\t}else{\r\n");
			s.append("\t\t\tdialog_open();\r\n");
			s.append("\t\t\t$(\"#iiiii\").val(row.iiiii);\r\n".replaceAll("iiiii", idName));
			s.append("\t\t}\r\n");
			s.append("\t}\r\n");
			
			s.append("\tfunction del_bbbbb(){\r\n".replaceAll("bbbbb", name));
			s.append("\t\tvar row = $('#dg_bbbbb').datagrid('getSelected');\r\n".replaceAll("bbbbb", name));
			s.append("\t\tif (row== null){\r\n");
			s.append("\t\t\t$.messager.alert('Info', \"请选择需要删除的行\", 'error');\r\n");
			s.append("\t\t\treturn ;\r\n");
			s.append("\t\t}else{\r\n");
			s.append("\t\t\tvar id = row.iiiii;\r\n".replaceAll("iiiii", idName));
			s.append("\t\t\t$.post(\"/erp/bbbbb/del_json.yy\",\r\n".replaceAll("bbbbb", name));
			s.append("\t\t\t{id:id},\r\n");
			s.append("\t\t\tfunction(data){\r\n");
			s.append("\t\t\t\tif(data > 0){\r\n");
			s.append("\t\t\t\t\t$.messager.alert('Info', \"aaaaa信息已删除\", 'error');\r\n".replaceAll("aaaaa", ts.getTsNikename()));
			s.append("\t\t\t\t\tinit();\r\n");
			s.append("\t\t\t\t}\r\n");
			s.append("\t\t\t}\r\n");
			s.append("\t\t);}\r\n");
			s.append("\t}\r\n");
			
			s.append("\tfunction find_bbbbb(){\r\n".replaceAll("bbbbb", name));
			s.append("\t\tvar url = '/erp/bbbbb/dg_find.yy?id='+$(\"#iiiii\").val() ;\r\n".replaceAll("bbbbb", name).replaceAll("iiiii", idName));
			s.append("\t\t$('#dg_bbbbb').datagrid({\r\n".replaceAll("bbbbb", name));
			s.append("\t\t\turl: url\r\n");
			s.append("\t\t});\r\n");
			s.append("\t}\r\n");
			
			s.append("\tfunction dialog_open(){\r\n");
			s.append("\t\t$('#dlg_bbbbb').dialog('open');\r\n".replaceAll("bbbbb", name));		
			s.append("\t}\r\n");
			
			s.append("\tfunction dialog_close(){\r\n");
			s.append("\t\t$('#dlg_bbbbb').dialog('close');\r\n".replaceAll("bbbbb", name));
			s.append("\t}\r\n");
			
			s.append("\tfunction submit_form(){\r\n");
			s.append("\t\t$('#ff_bbbbb').form('submit',{\r\n".replaceAll("bbbbb", name));
			s.append("\t\t\tonSubmit:function(){\r\n");
			s.append("\t\t\t\treturn $(this).form('validate');\r\n");
			s.append("\t\t\t},\r\n");
			s.append("\t\t\tsuccess:function(data){\r\n");
			s.append("\t\t\t\tvar rj = eval('(' + data + ')');\r\n");
			s.append("\t\t\t\t$.messager.alert('Info',rj.desc, 'Info');\r\n");
			s.append("\t\t\t\tif(rj.status == 1){\r\n");
			s.append("\t\t\t\t\tdialog_close();\r\n");
			s.append("\t\t\t\t\t$(\"#ff_bbbbb\").form('clear');\r\n".replaceAll("bbbbb", name));
			s.append("\t\t\t\t\tinit();\r\n");
			s.append("\t\t\t\t}\r\n");
			s.append("\t\t\t}\r\n");
			s.append("\t\t});\r\n");
			s.append("\t}\r\n");
			s.append("</script>r\n"); 
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return s.toString();
	}

	/**
	 * 单据页面
	 * @param tableStruct
	 */
    private static String billType(TableStruct tsMain,TableStruct tsSub,String name) {
    	StringBuffer s = new StringBuffer("");
    	try{
    		//如批发销售单    		
    		s.append("<%@ page language=\"java\" contentType=\"text/html;charset=UTF-8\" pageEncoding=\"UTF-8\"%>\r\n");
    		s.append("<style>\r\n");
    		s.append("\t#findWare_div p{color:#000000}  \r\n");
    		s.append("\t#findWare_div p:hover{ color:#ff0000;}\r\n");
    		s.append("  \r\n");
    		s.append("\t.findWare_div_table{display:table;border-collapse:collapse;border:1px solid #E0ECFF;}  \r\n");
    		s.append("\t.findWare_div_table ul{\tmargin:0;padding:0;list-style:none;\tdisplay:table-row;height:25px;}\r\n");
    		s.append("\t.findWare_div_table ul:hover{background:#f6f6f6;}\r\n");
    		s.append("\t.findWare_div_table li{display:table-cell;padding:3px;border:1px solid #E0ECFF;}  \r\n");
    		s.append("\t.findWare_div_table .table-row-group{display:table-row-group;}\r\n");
    		s.append("\t.findWare_div_table .table-header-group{display:table-header-group;background:#eee;font-weight:bold;text-align: center;}\r\n");
    		s.append("\t.easyui-textbox{\r\n");
    		s.append("\t\tbackground-color:expression(this.readOnly==true?\"#eee\":\"#fff\");  \r\n");
    		s.append("\t} \r\n");
    		s.append("</style>  \r\n");
    		//主单信息--开始
    		s.append("\t<div class=\"easyui-panel\" style=\"width:100%;padding:3px;border:none;\" data-options=\"iconCls:'icon-ok'\">\r\n");
    		s.append("\t\t<div style=\"padding:8px\">  \r\n");
    		s.append("\t\t<form id=\"ff_bbbbb\" class=\"easyui-form\" method=\"post\" action=\"/erp/bbbbb/save.yy\" data-options=\"novalidate:false\"> \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t<table>\r\n");
    		//行-----开始
//    		for(TableStructField tsf : ts.getTableStructFields()){
//				s.append("\t\t\t\t<th data-options=\"field:'");				
//				s.append(getFieldName(tsf.getTsfName()));
//				s.append("',width:80\">");
//				s.append(tsf.getTsfNikename());
//				s.append("</th>\r\n");
//			}
    		
//    		TableStruct ts_main = tablestructService.findById(ts.getTsMid());
    		String IDNAME=null;//表中主键属性名称
    		if(tsMain != null && tsMain.getTableStructFields() != null){
    			List<TableStructField> tsfs = tsMain.getTableStructFields();
//    			IDNAME = getIdName(tsfs);//表中主键属性名称
	    		int len = tsfs.size();
	    		for( int i = 0 ;i<len;i++){
	    			TableStructField tsf = tsfs.get(i);
	    			if(i%3 == 0){
	    				s.append("\t\t\t\t<tr> \r\n");
	    			}
	    			String id = getFieldName(tsf.getTsfName());
	    			if("key".equals(tsf.getTsfKey())){
	    				IDNAME = id;
	    			}
		    		s.append("\t\t\t\t\t<td>"+tsf.getTsfNikename()+":</td>\r\n");
		    		s.append("\t\t\t\t\t<td><input class=\""+tsf.getTsfFormtype()+"\" id=\""+id+"\" name=\""+id+"\" data-options=\"readonly:true,width:200\" /></td> \r\n");
		    		
//		    		s.append("\t\t\t\t\t<td>制单时间:</td>\r\n");
//		    		s.append("\t\t\t\t\t<td><input class=\"easyui-datebox\" id=\"wsDate\" name=\"wsDate\" data-options=\"required:true,width:100\"/></td> \r\n");
//		    		s.append("\t\t\t\t\t<td>制单人:</td>  \r\n");
//		    		s.append("\t\t\t\t\t<td> \r\n");
//		    		s.append("\t\t\t\t\t\t<inpu style=\"width:200px;\" class=\"easyui-combobox\"  id=\"wsCreator\" name=\"wsCreator\" data-options=\"\r\n");
//		    		s.append("\t\t\t\t\t\t\trequired:true,\r\n");
//		    		s.append("\t\t\t\t\t\t\tpanelHeight: '125', \r\n");
//		    		s.append("\t\t\t\t\t\t\twidth:'100'\"/>\r\n");		    		
//		    		s.append("\t\t\t\t\t</td>\r\n");
		    		if((i+1)%3 == 0 || (i+1) == len){
		    			s.append("\t\t\t\t</tr>\r\n");
		    		}
	    		}
    		}
    		//行-----结束    		
//    		s.append("\t\t\t\t<tr> \r\n");
//    		s.append("\t\t\t\t\t<td>客户名称:</td>\r\n");
//    		s.append("\t\t\t\t\t<td> \r\n");
//    		s.append("\t\t\t\t\t\t<select style=\"width:200px;\" class=\"easyui-combobox\" id=\"cbId\" name=\"cbId\" data-options=\"required:true,panelHeight:'auto'\"></select>  \r\n");
//    		s.append("\t\t\t\t\t</td>\r\n");
//    		s.append("\t\t\t\t\t<td></td> \r\n");
//    		s.append("\t\t\t\t\t<td></td> \r\n");
//    		s.append("\t\t\t\t\t<td>出库仓库:</td>\r\n");
//    		s.append("\t\t\t\t\t<td> \r\n");
//    		s.append("\t\t\t\t\t\t<select style=\"width:200px;\" class=\"easyui-combobox\" id=\"shId\" name=\"shId\" data-options=\"required:true,panelHeight:'auto'\"></select>  \r\n");
//    		s.append("\t\t\t\t\t</td>\r\n");
//    		s.append("\t\t\t\t</tr>\r\n");
//    		s.append("\t\t\t\t<tr> \r\n");
//    		s.append("\t\t\t\t\t<td>收货地址:</td>\r\n");
//    		s.append("\t\t\t\t\t<td> \r\n");
//    		s.append("\t\t\t\t\t\t<select style=\"width:200px;\" class=\"easyui-combobox\" id=\"cbStorehouse\" name=\"cbStorehouse\" data-options=\"required:true,panelHeight:'auto'\"></select>\r\n");
//    		s.append("\t\t\t\t\t</td>\r\n");
//    		s.append("\t\t\t\t\t<td>提货方式:</td>\r\n");
//    		s.append("\t\t\t\t\t<td> \r\n");
//    		s.append("\t\t\t\t\t\t<select style=\"width:100px;\" class=\"easyui-combobox\" id=\"wsReceiveWay\" name=\"wsReceiveWay\">  \r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"1\">货运</option>\r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"2\">自提</option>\r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"3\">配送</option>\r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"4\">提送</option>\r\n");
//    		s.append("\t\t\t\t\t\t </select> \r\n");
//    		s.append("\t\t\t\t\t</td>\r\n");
//    		s.append("\t\t\t\t\t<td>付款方式:</td>\r\n");
//    		s.append("\t\t\t\t\t<td> \r\n");
//    		s.append("\t\t\t\t\t\t<select style=\"width:200px;\" class=\"easyui-combobox\" id=\"wsPayWay\" name=\"wsPayWay\" data-options=\"panelHeight:'auto'\"> \r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"1\">月结</option>\r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"2\">货到付款</option>  \r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"3\">现金</option>\r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"4\">刷卡</option>\r\n");
//    		s.append("\t\t\t\t\t\t</select>  \r\n");
//    		s.append("\t\t\t\t\t</td>\r\n");
//    		s.append("\t\t\t\t</tr>\r\n");
//    		s.append("\t\t\t\t<tr> \r\n");
//    		s.append("\t\t\t\t\t<td>价格组ID:</td>\r\n");
//    		s.append("\t\t\t\t\t<td> \r\n");
//    		s.append("\t\t\t\t\t\t<select style=\"width:200px;\" class=\"easyui-combobox\" id=\"pId\" name=\"pId\" data-options=\"panelHeight:'auto'\"></select>  \r\n");
//    		s.append("\t\t\t\t\t</td>\r\n");
//    		s.append("\t\t\t\t\t<td>发票类型:</td>\r\n");
//    		s.append("\t\t\t\t\t<td> \r\n");
//    		s.append("\t\t\t\t\t\t<select style=\"width:100px;\" class=\"easyui-combobox\"  id=\"wsInvoiceType\" name=\"wsInvoiceType\" data-options=\"  \r\n");
//    		s.append("\t\t\t\t\t\t\tpanelHeight: 'auto'\">  \r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"1\">增值税专用发票</option> \r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"2\">普通发票</option>  \r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"3\">定额发票</option>  \r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"4\">机打发票</option>  \r\n");
//    		s.append("\t\t\t\t\t\t</select>  \r\n");
//    		s.append("\t\t\t\t\t</td>\r\n");
//    		s.append("\t\t\t\t\t<td>业务员:</td>  \r\n");
//    		s.append("\t\t\t\t\t<td> \r\n");
//    		s.append("\t\t\t\t\t\t<select style=\"width:200px;\" class=\"easyui-combobox\" id=\"eId\" name=\"eId\" data-options=\"panelHeight:'auto'\"></select>  \r\n");
//    		s.append("\t\t\t\t\t</td>\r\n");
//    		s.append("\t\t\t\t</tr>\r\n");    		
//    		s.append("\t\t\t\t<tr> \r\n");
//    		s.append("\t\t\t\t\t<td>审核状态:</td>\r\n");
//    		s.append("\t\t\t\t\t<td> \r\n");
//    		s.append("\t\t\t\t\t\t<select style=\"width:200px;\" class=\"easyui-combobox\" name=\"wsState\" data-options=\"panelHeight:'auto'\">  \r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"1\">正常</option>\r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"2\">审核中</option> \r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"3\">审核完成</option>  \r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"4\">驳回</option>\r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"5\">撤销</option>\r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"6\">作废</option>\r\n");
//    		s.append("\t\t\t\t\t\t\t<option value=\"0\">无效</option>\r\n");
//    		s.append("\t\t\t\t\t\t</select>  \r\n");
//    		s.append("\t\t\t\t\t</td>\r\n");
//    		s.append("\t\t\t\t\t<td>审核时间:</td>\r\n");
//    		s.append("\t\t\t\t\t<td><input class=\"easyui-datebox\" name=\"whChtime\" data-options=\"required:false,width:100\"></input></td>\r\n");
//    		s.append("\t\t\t\t\t<td>备注:</td> \r\n");
//    		s.append("\t\t\t\t\t<td><input class=\"easyui-textbox\" name=\"wsRemark\" data-options=\"required:false,width:200\"></input></td>\r\n");
//    		s.append("\t\t\t\t</tr>\r\n");
    		s.append("\t\t\t\t\t<tr id=\"tr_approve1\" style=\"background-color:#dddddd;display: none;font-weight:bold;\"> \r\n");
    		s.append("\t\t\t\t\t\t<td id=\"td_approve_d1\"></td>\r\n");
    		s.append("\t\t\t\t\t\t<td id=\"td_approve_u1\" style=\"padding:5px 8px;\"></td> \r\n");
    		s.append("\t\t\t\t\t\t<td id=\"td_approve_d2\"></td>\r\n");
    		s.append("\t\t\t\t\t\t<td id=\"td_approve_u2\" style=\"padding:5px 8px;\"></td> \r\n");
    		s.append("\t\t\t\t\t\t<td id=\"td_approve_d3\"></td>\r\n");
    		s.append("\t\t\t\t\t\t<td id=\"td_approve_u3\" style=\"padding:5px 8px;\"></td> \r\n");
    		s.append("\t\t\t\t\t</tr>\r\n");
    		s.append("\t\t\t\t\t<tr id=\"tr_approve2\" style=\"background-color:#dddddd;display: none;font-weight:bold;\"> \r\n");
    		s.append("\t\t\t\t\t\t<td id=\"td_approve_d4\"></td>\r\n");
    		s.append("\t\t\t\t\t\t<td id=\"td_approve_u4\" style=\"padding:5px 8px;\"></td> \r\n");
    		s.append("\t\t\t\t\t\t<td id=\"td_approve_d5\" ></td>\r\n");
    		s.append("\t\t\t\t\t\t<td id=\"td_approve_u5\" style=\"padding:5px 8px;\"></td> \r\n");
    		s.append("\t\t\t\t\t\t<td id=\"td_approve_d6\" ></td>\r\n");
    		s.append("\t\t\t\t\t\t<td id=\"td_approve_u6\" style=\"padding:5px 8px;\"\t></td>  \r\n");
    		s.append("\t\t\t\t\t</tr>\r\n");
    		s.append("\t\t\t\t</table>  \r\n");
    		s.append("\t\t\t<!--审核情况-->  \r\n");
    		s.append("\t\t\t<input type=\"hidden\" id=\"moduleId\" name=\"moduleId\" value=\"${moduleId}\" />  \r\n");
    		s.append("\t\t\t<input type=\"hidden\" id=\"add\" name=\"add\" />  \r\n");
    		s.append("\t\t\t<input type=\"hidden\" id=\"del\" name=\"del\" />  \r\n");
    		s.append("\t\t\t<input type=\"hidden\" id=\"modify\" name=\"modify\" /> \r\n");
    		s.append("\t\t</form>  \r\n");
    		s.append("\t\t</div>\r\n");
    		s.append("\t</div>  \r\n");
    		//主单信息--结束
    		//子表结构信息
//    		TableStruct ts_sub = tablestructService.findByTsMid(ts_main.getTsId());
    		//子单据信息--开始
    		s.append("\t<table id=\"dg_bbbbb\" class=\"easyui-datagrid\" style=\"width:100%;height:auto;border-width:0;\"\r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\tdata-options=\"\r\n");
    		s.append("\t\t\t\tsingleSelect: true, \r\n");
    		s.append("\t\t\t\trownumbers: true,\r\n");
    		s.append("\t\t\t\ttoolbar: '#tb_bbbbb', \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\tonClickCell: onClickCell, \r\n");
    		s.append("\t\t\t\tonEndEdit:onEndEdit,\r\n");
    		s.append("\t\t\t\tfitColumns:true, \r\n");
    		s.append("\t\t\t\tborder:0\">\r\n");
    		if(tsSub != null && tsSub.getTableStructFields() != null){
    			List<TableStructField> tsfs = tsSub.getTableStructFields();
    			int len = tsfs.size();
    			
	    		s.append("\t\t<thead>  \r\n");
	    		s.append("\t\t\t<tr>\r\n");
	    		for(int i = 0 ;i < len ;i++ ){
	    			TableStructField tsf =tsfs.get(i);
	    			s.append("\t\t\t\t<th data-options=\"field:'"+getFieldName(tsf.getTsfName())+"',width:50,editor:'textbox',halign: 'center',hcolor:'#ff0000',styler:setReadColor\">"+tsf.getTsfNikename()+"</th>\r\n");
	    		}
//	    		s.append("\t\t\t\t<th data-options=\"field:'wTraname',width:120,editor:'textbox',halign: 'center',hcolor:'#ff0000'\">商品名称</th> \r\n");
//	    		s.append("\t\t\t\t<th data-options=\"field:'wStandard',width:50,editor:'textbox',halign: 'center',styler:setReadColor\">商品规格</th> \r\n");
//	    		s.append("\t\t\t\t<th data-options=\"field:'wUnit',width:40,editor:'textbox',halign: 'center',styler:setReadColor\">单位</th>\r\n");
//	    		s.append("\t\t\t\t<th data-options=\"field:'wBusiness',width:130,editor:'textbox',halign: 'center',styler:setReadColor\">生产厂家</th>\r\n");
//	    		s.append("\t\t\t\t<th data-options=\"field:'wPlace',width:50,editor:'textbox',halign: 'center',styler:setReadColor\">产地</th>  \r\n");
//	    		s.append("\t\t\t\t<th data-options=\"field:'wsdPrice',width:50,editor:'textbox',halign: 'center',hcolor:'#ff0000',styler:setReadColor\">批发价</th> \r\n");
//	    		s.append("\t\t\t\t<th data-options=\"field:'batchNo',width:100,editor:'textbox',halign: 'center',styler:setReadColor\">批号</th>\r\n");
//	    		s.append("\t\t\t\t<th data-options=\"field:'validDate',width:70,editor:'textbox',halign: 'center',styler:setColor\" formatter=\"formatDateGrid\">效期</th> \r\n");
//	    		s.append("\t\t\t\t<th data-options=\"field:'spCode',width:80,editor:'textbox',halign: 'center',styler:setReadColor\">货位</th>  \r\n");
//	    		s.append("\t\t\t\t<th data-options=\"field:'wsdAmount',width:50,editor:'textbox',halign: 'center',hcolor:'#ff0000'\">数量</th>  \r\n");
//	    		s.append("\t\t\t\t<th data-options=\"field:'wsdMoney',width:70,editor:'textbox',halign: 'center',hcolor:'#ff0000'\">金额</th>\r\n");
//	    		s.append("\t\t\t\t<th data-options=\"field:'sbId',width:50,editor:'textbox',halign: 'center',styler:setReadColor\">批次</th> \r\n");
//	    		s.append("\t\t\t\t<th data-options=\"field:'produceDate',width:70,editor:'textbox',halign: 'center'\" formatter=\"formatDateGrid\">生产日期</th>\r\n");
//	    		s.append("\t\t\t\t<th data-options=\"field:'wsdIndex',width:40,editor:'textbox',halign: 'center',styler:setReadColor\">序号</th>\r\n");
//	    		s.append("\t\t\t\t<th data-options=\"field:'sId',width:40,editor:'textbox',halign: 'center',hidden:true\">库存ID</th>\r\n");
//	    		s.append("\t\t\t\t<th data-options=\"field:'sdId',width:40,editor:'textbox',halign: 'center',hidden:true\">库存明细ID</th>\r\n");
	    		s.append("\t\t\t</tr>  \r\n");
	    		s.append("\t\t</thead> \r\n");    		
    		}
    		s.append("\t</table>\r\n");
    		s.append("  \r\n");
    		//子单据信息--结束
    		s.append("\t<div id=\"tb_bbbbb\" style=\"height:auto\">\r\n".replaceAll("bbbbb", name));
    		s.append("\t\t<a id=\"append_detail\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-add',plain:true\" onclick=\"appendDgDetail()\">添加明细</a>\r\n");
    		s.append("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove',plain:true\" onclick=\"removeDgDetail()\">删除明细</a>\r\n");
    		s.append("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-save',plain:true\" onclick=\"submitForm()\">保存</a>\r\n");
    		s.append("\t\t<a id=\"a_approve\" href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"showApproveDialog(1,'"+tsMain.getTsNikename()+"','${"+IDNAME+"}')\" style=\"display: none;\">审批</a>\r\n");
    		s.append("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-back',plain:true\" onclick=\"callback('bbbbb')\">返回</a> \r\n".replaceAll("bbbbb", name));
    		s.append("\t</div>  \r\n");
    		/*
    		s.append("\t\r\n");
    		s.append("\t<div id=\"findWare_div\" style=\"position:absolute;display:none;z-index:1;width:820px;height:auto;max-height: 200px;closable:true;background-color:#ffffff;overflow-y:auto;border:solid #E0ECFF 1px;\"> \r\n");
    		s.append("\t\t<div class=\"findWare_div_table\"> \r\n");
    		s.append("\t\t\t<div class=\"table-header-group\">  \r\n");
    		s.append("\t\t\t\t<ul> \r\n");
    		s.append("\t\t\t\t\t<li>商品ID</li>\r\n");
    		s.append("\t\t\t\t\t<li>商品名称</li> \r\n");
    		s.append("\t\t\t\t\t<li>商品规格</li> \r\n");
    		s.append("\t\t\t\t\t<li>单位</li>\r\n");
    		s.append("\t\t\t\t\t<li>生产厂家</li> \r\n");
    		s.append("\t\t\t\t\t<li>产地</li>\r\n");
    		s.append("\t\t\t\t\t<li>批号</li>\r\n");
    		s.append("\t\t\t\t\t<li>效期</li>\r\n");
    		s.append("\t\t\t\t\t<li>货位</li>\r\n");
    		s.append("\t\t\t\t\t<li>数量</li>\r\n");
    		s.append("\t\t\t\t\t<li>批次</li>\r\n");
    		s.append("\t\t\t\t\t<li>生产日期</li> \r\n");
    		s.append("\t\t\t\t</ul>\r\n");
    		s.append("\t\t\t</div> \r\n");
    		s.append("\t\t\t<div class=\"table-row-group\">  \r\n");
    		s.append("  \r\n");
    		s.append("\t\t\t</div> \r\n");
    		s.append("\t\t</div>\r\n");
    		s.append("\t</div>  \r\n");
    		s.append("  \r\n");
    		*/
    		s.append("\t<script type=\"text/javascript\"> \r\n");
    		s.append("\t$(function(){\r\n");
    		/*
    		s.append("\t\t//加载客户:\r\n");
    		s.append("\t\t$(\"#cbId\").combobox({\r\n");
    		s.append("\t\t\turl: '/erp/customer/find_json.yy',\r\n");
    		s.append("\t\t\tmethod: 'post',  \r\n");
    		s.append("\t\t\tvalueField: 'cbId',\r\n");
    		s.append("\t\t\ttextField: 'cbFullname'  \r\n");
    		*/
    		s.append("\t\t});\r\n");
    		s.append("\t\t\r\n");
    		/*
    		s.append("\t\t//加载入库仓库\r\n");
    		s.append("\t\t$(\"#shId\").combobox({\r\n");
    		s.append("\t\t\turl: '/erp/storehouse/find_json.yy', \r\n");
    		s.append("\t\t\tmethod: 'post',  \r\n");
    		s.append("\t\t\tvalueField: 'shId',\r\n");
    		s.append("\t\t\ttextField: 'shName'\r\n");
    		s.append("\t\t});\r\n");
    		s.append("\t\t//加载制单人  \r\n");
    		s.append("\t\t$(\"#wsCreator\").combobox({ \r\n");
    		s.append("\t\t\turl:'/erp/employee/find_json.yy', \r\n");
    		s.append("\t\t\tvalueField: 'eId', \r\n");
    		s.append("\t\t\ttextField: 'eName' \r\n");
    		s.append("\t\t});\r\n");
    		s.append("\t\t//加载业务员  \r\n");
    		s.append("\t\t$(\"#eId\").combobox({ \r\n");
    		s.append("\t\t\turl:'/erp/employee/find_json.yy', \r\n");
    		s.append("\t\t\tvalueField: 'eId', \r\n");
    		s.append("\t\t\ttextField: 'eName' \r\n");
    		s.append("\t\t});\r\n");
    		s.append("\t\tvar wsId = '${wsId}';\r\n");
    		s.append("\t\tif(wsId == \"\"){//新增\r\n");
    		s.append("\t\t\tvar mydate = new Date(); \r\n");
    		s.append("\t\t\t$(\"#wsDate\").val(mydate);\r\n");
    		s.append("\t\t}else{//不为空,既为修改 \r\n");
    		s.append("\t\t\tvar moduleId = '${moduleId}';  \r\n");
    		s.append("\t\t\tif(moduleId != \"\"){\r\n");
    		s.append("\t\t\t\tshowApprove(moduleId,wsId);  \r\n");
    		s.append("\t\t\t}\r\n");
    		s.append("\t\t\t// datagrid 填充 \r\n");
    		s.append("\t\t\t$.post(\"/erp/bbbbb/add_json.yy\", \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\t{wsId:wsId},\r\n");
    		s.append("\t\t\t\tfunction(data){\r\n");
    		s.append("\t\t\t\t\tif(data){ \r\n");
    		s.append("\t\t\t\t\t\t//加载表单 \r\n");
    		s.append("\t\t\t\t\t\t$('#ff_bbbbb').form('load', data); \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\t\t\t$('#wsId').prop('readonly',true);\r\n");
    		s.append("\t\t\t\t\t\t$('#wsId').validatebox({required: false});\r\n");
    		s.append("\t\t\t\t\t\t$(\"#wsId\").removeAttr(\"onblur\"); \r\n");
    		s.append("\t\t\t\t\t\t//加载datagrid  \r\n");
    		s.append("\t\t\t\t\t\t$('#dg_bbbbb').datagrid(\"loadData\",data.details); \r\n".replaceAll("bbbbb", name));
    		s.append("  \r\n");
    		s.append("\t\t\t\t\t}  \r\n");
    		s.append("\t\t\t\t} \r\n");
    		s.append("\t\t\t);  \r\n");
    		s.append("  \r\n");
    		s.append("\t\t}  \r\n");
    		s.append("\t});  \r\n");
    		s.append("\t//单击单元格事件\r\n");
    		s.append("\tfunction onClickCell(index, field){\r\n");
    		s.append("\t\tif (editIndex != index){\r\n");
    		s.append("\t\t\tif (endEditing()){ \r\n");
    		s.append("\t\t\t\t$('#dg_bbbbb').datagrid('selectRow', index).datagrid('beginEdit', index); \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\tsetCell(index);\r\n");
    		s.append("\t\t\t\tbindCellKeyEvent(index,field);  \r\n");
    		s.append("\t\t\t\teditIndex = index;  \r\n");
    		s.append("\t\t\t} else { \r\n");
    		s.append("\t\t\t\tsetTimeout(function(){ \r\n");
    		s.append("\t\t\t\t\t$('#dg_bbbbb').datagrid('selectRow', editIndex);  \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\t},0);\r\n");
    		s.append("\t\t\t}\r\n");
    		s.append("\t\t}  \r\n");
    		s.append("\t} \r\n");
    		s.append("\t//结束编辑 \r\n");
    		s.append("\tvar editIndex = undefined;\r\n");
    		s.append("\tfunction endEditing(){ \r\n");
    		s.append("\t\tif (editIndex == undefined){  \r\n");
    		s.append("\t\t\treturn true;\r\n");
    		s.append("\t\t}  \r\n");
    		s.append("\t\tif ($('#dg_bbbbb').datagrid('validateRow', editIndex)){ \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t$('#dg_bbbbb').datagrid('endEdit', editIndex);\r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\teditIndex = undefined;\r\n");
    		s.append("\t\t\treturn true;\r\n");
    		s.append("\t\t} else { \r\n");
    		s.append("\t\t\treturn false; \r\n");
    		s.append("\t\t}  \r\n");
    		s.append("\t} \r\n");
    		s.append("\t/**  \r\n");
    		s.append("\t * 输入商品编号或拼音查找商品信息  \r\n");
    		s.append("\t *  \r\n");
    		s.append("\tfunction findWare(ed){ \r\n");
    		s.append("\t\tvar zjm = $(ed).val();  \r\n");
    		s.append("\t\t$.post(\"/erp/wares/find_ batch_house.yy\",\r\n");
    		s.append("\t\t\t{zjm:zjm},  \r\n");
    		s.append("\t\t\tfunction(data){  \r\n");
    		s.append("\t\t\t\tif(data.length == 0){  \r\n");
    		s.append("\t\t\t\t\t$(\"#findWare_div\").hide(); \r\n");
    		s.append("\t\t\t\t\treturn ;\r\n");
    		s.append("\t\t\t\t} \r\n");
    		s.append("\t\t\t\t$(\".table-row-group\").empty();  \r\n");
    		s.append("\t\t\t\tvar tbody = \"\";\r\n");
    		s.append("\t\t\t\t//1.清空原来的operType这个combobox中的选项 \r\n");
    		s.append("\t\t\t\t//下面使用each进行遍历 \r\n");
    		s.append("\t\t\t\t$.each(data,function(n,obj) {\r\n");
    		s.append("\t\t\t\t\tvar bg =setBgColor(obj.validDate,\"\"); \r\n");
    		s.append("\t\t\t\t\ttbody += \"<ul style='background-color:\"+bg+\"' id='wares_ul_\"+(n+1)+\"' onclick=selectWid('\"+ obj.wId +\"','\"+obj.wTraname+\"','\"+obj.wStandard+\"','\"+obj.wUnit+\"','\"+obj.wBusiness+\"','\"+obj.wPlace+\"','\"+obj.wCostprice+\"','\"+obj.batchNo+\"','\"+obj.validDate+\"','\"+obj.spCode+\"','\"+obj.amount+\"','\"+obj.sbId+\"','\"+obj.produceDate+\"','\"+obj.sId+\"','\"+obj.sdId+\"')><li>\" + obj.wId +\"</li><li>\" + obj.wTraname +\"</li><li>\" + obj.wStandard +\"</li><li>\" + obj.wUnit +\"</li><li>\" + obj.wBusiness +\"</li><li>\" + obj.wPlace +\"</li><li>\" + obj.batchNo +\"</li><li>\" + obj.validDate +\"</li><li>\" + obj.spCode +\"</li><li>\" + obj.amount +\"</li><li>\" + obj.sbId +\"</li><li>\" + obj.produceDate +\"</li></ul>\";\r\n");
    		s.append("  \r\n");
    		s.append("\t\t\t\t});  \r\n");
    		s.append("\t\t\t\t$(\".table-row-group\").append(tbody); \r\n");
    		s.append("\t\t\t\t$(\"#findWare_div\").show();//显示div\r\n");
    		s.append("\t\t\t}\r\n");
    		s.append("\t\t); \r\n");
    		s.append("\t} \r\n");
    		s.append("\t\r\n");
    		s.append("\tfunction setBgColor(vc,bg){  \r\n");
    		s.append("\t\tif(vc != undefined && vc != \"\"){ \r\n");
    		s.append("\t\t\tvar now = new Date(); \r\n");
    		s.append("\t\t\tvar vdt = new Date(vc.substr(0,4)+\"-\"+vc.substr(4,2)+\"-\"+vc.substr(6,2));  \r\n");
    		s.append("\t\t\tvar vms = vdt -now ;  \r\n");
    		s.append("\t\t\tif(vms < 7776000000){//三个月  \r\n");
    		s.append("\t\t\t\tbg= '#ffee00'; \r\n");
    		s.append("\t\t\t}\r\n");
    		s.append("\t\t\tif( vms < 15552000000){//半年  \r\n");
    		s.append("\t\t\t\tbg = '#ff0000';\r\n");
    		s.append("\t\t\t}\t\t\t\r\n");
    		s.append("\t\t}  \r\n");
    		s.append("\t\treturn bg; \r\n");
    		s.append("\t} \r\n");
    		s.append("\t\r\n");
    		s.append("\t//选中商品信息  \r\n");
    		s.append("\tfunction selectWid(wId,wTraname,wStandard,wUnit,wBusiness,wPlace,wsdPrice,batchNo,validDate,spCode,wsdAmount,sbId,produceDate,sId,sdId){\r\n");
    		s.append("\t\tvar flag = findWid(wId,batchNo,sbId);//同一个品种、同一个批号、同一个批次才算是唯一  \r\n");
    		s.append("\t\tif(flag >= 0){\r\n");
    		s.append("\t\t\t$.messager.show({\r\n");
    		s.append("\t\t\t\ttitle:'提示',  \r\n");
    		s.append("\t\t\t\tmsg:'【'+wTraname+'】已在明细中第 '+ (flag+1) +\" 行.\",  \r\n");
    		s.append("\t\t\t\tshowType:'slide',\r\n");
    		s.append("\t\t\t\tshowSpeed:1,\r\n");
    		s.append("\t\t\t\ttimeout:1000,  \r\n");
    		s.append("\t\t\t\tstyle:{\r\n");
    		s.append("\t\t\t\t\tright:'', \r\n");
    		s.append("\t\t\t\t\tbottom:'' \r\n");
    		s.append("\t\t\t\t} \r\n");
    		s.append("\t\t\t}); \r\n");
    		s.append("\t\t}else{\t\t \r\n");
    		s.append("\t\t\tvar editors = $('#dg_bbbbb').datagrid('getEditors', editIndex);  \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\tvar o_wId\t\t= editors[0];\t//商品ID \r\n");
    		s.append("\t\t\tvar o_wTraname\t\t= editors[1];\t//商品名称  \r\n");
    		s.append("\t\t\tvar o_wStandard\t\t= editors[2];\t//商品规格 \r\n");
    		s.append("\t\t\tvar o_wUnit\t\t= editors[3];\t//单位 \r\n");
    		s.append("\t\t\tvar o_wBusiness\t\t= editors[4];\t//生产厂家 \r\n");
    		s.append("\t\t\tvar o_wPlace\t\t= editors[5];\t//产地\r\n");
    		s.append("\t\t\tvar o_wsdPrice\t= editors[6];\t//批发价\r\n");
    		s.append("\t\t\tvar o_batchNo\t\t= editors[7];\t//批号 \r\n");
    		s.append("\t\t\tvar o_validDate\t\t= editors[8];\t//效期  \r\n");
    		s.append("\t\t\tvar o_spCode\t\t= editors[9];\t//货位\r\n");
    		s.append("\t\t\tvar o_wsdAmount\t\t= editors[10];\t//申请数量\r\n");
    		s.append("\t\t\tvar o_wsdMoney\t\t= editors[11];\t//金额  \r\n");
    		s.append("\t\t\tvar o_sbId\t\t= editors[12];\t//批次 \r\n");
    		s.append("\t\t\tvar o_produceDate\t= editors[13];\t//效期 \r\n");
    		s.append("\t\t\tvar o_sId\t= editors[15];\t//库存ID  \r\n");
    		s.append("\t\t\tvar o_sdId\t= editors[16];\t//库存明细ID  \r\n");
    		s.append("\t\r\n");
    		s.append("\t\t\t$(o_wId.target).textbox('setValue',wId);  \r\n");
    		s.append("\t\t\t$(o_wTraname.target).textbox('setValue',wTraname);\r\n");
    		s.append("\t\t\t$(o_wStandard.target).textbox('setValue',wStandard); \r\n");
    		s.append("\t\t\t$(o_wUnit.target).textbox('setValue',wUnit); \r\n");
    		s.append("\t\t\t$(o_wBusiness.target).textbox('setValue',wBusiness); \r\n");
    		s.append("\t\t\t$(o_wPlace.target).textbox('setValue',wPlace);  \r\n");
    		s.append("\t\t\t$(o_wsdPrice.target).textbox('setValue',wsdPrice);\r\n");
    		s.append("\t\t\t$(o_batchNo.target).textbox('setValue',batchNo);\r\n");
    		s.append("\t\t\t$(o_validDate.target).textbox('setValue',validDate); \r\n");
    		s.append("\t\t\t$(o_spCode.target).textbox('setValue',spCode);  \r\n");
    		s.append("\t\t\t$(o_wsdAmount.target).textbox('setValue',wsdAmount); \r\n");
    		s.append("\t\t\t$(o_sbId.target).textbox('setValue',sbId);\r\n");
    		s.append("\t\t\t$(o_produceDate.target).textbox('setValue',produceDate);  \r\n");
    		s.append("\t\t\t$(o_sId.target).textbox('setValue',sId);  \r\n");
    		s.append("\t\t\t$(o_sdId.target).textbox('setValue',sdId);\r\n");
    		s.append("\t\t\t//计算金额  \r\n");
    		s.append("\t\t\tif(wsdPrice.length > 0 && wsdAmount.length > 0){\r\n");
    		s.append("\t\t\t\tvar money = parseFloat(wsdPrice) * parseFloat(wsdAmount); \r\n");
    		s.append("\t\t\t\t$(o_wsdMoney.target).textbox('setValue',money.toFixed(2));\r\n");
    		s.append("\t\t\t}\r\n");
    		s.append("\t\t\t$(o_wStandard.target).attr('readonly',true);  //设置输入框为禁用  \r\n");
    		s.append("\t\t\t$(\"#findWare_div\").hide();  \r\n");
    		s.append("\t\t}  \r\n");
    		s.append("\t} \r\n");
    		s.append("\t//查找是否包含  \r\n");
    		s.append("\tfunction findWid(wid,batchNo,sbId) {  \r\n");
    		s.append("\t\tvar rows = $('#dg_bbbbb').datagrid('getRows')//获取当前页的数据行  \r\n".replaceAll("bbbbb", name));
    		s.append("\t\tvar len = rows.length\r\n");
    		s.append("\t\tif(len == 1){ \r\n");
    		s.append("\t\t\treturn -1;  \r\n");
    		s.append("\t\t}  \r\n");
    		s.append("\t\tfor (var i = 0; i < rows.length; i++) {\r\n");
    		s.append("\t\t\tvar nwid = rows[i]['wId'];  \r\n");
    		s.append("\t\t\tvar nbatchNo = rows[i]['batchNo'];\r\n");
    		s.append("\t\t\tvar nsbId = rows[i]['sbId'];\r\n");
    		s.append("\t\t\tif(wid == nwid && batchNo == nbatchNo && sbId == nsbId){//获取指定列 \r\n");
    		s.append("\t\t\t\treturn i; \r\n");
    		s.append("\t\t\t}\r\n");
    		s.append("\t\t}  \r\n");
    		s.append("\t\treturn -1; \r\n");
    		s.append("\t} \r\n");
    		s.append("\t//增加行\r\n");
    		s.append("\tfunction appendDgDetail(){\r\n");
    		s.append("\t\tif (endEditing()){ \r\n");
    		s.append("\t\t\t$('#dg_bbbbb').datagrid('appendRow',{status:'P'}); \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\teditIndex = $('#dg_bbbbb').datagrid('getRows').length-1;\r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t$('#dg_bbbbb').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex); \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\tsetCell(editIndex);\r\n");
    		s.append("\t\t\tbindCellKeyEvent(editIndex,\"wTraname");//商品名称 \r\n");
    		s.append("\t\t\tbindCellKeyEvent(editIndex,\"wsdPrice");//商品批发价格\r\n");
    		s.append("\t\t\tbindCellKeyEvent(editIndex,\"wsdAmount");//数量  \r\n");
    		s.append("\t\t\tbindCellKeyEvent(editIndex,\"validDate");//数量  \r\n");
    		s.append("\t\t\tbindCellKeyEvent(editIndex,\"produceDate");//数量\r\n");
    		s.append("\t\t\tbindCellKeyEvent(editIndex,\"wsdIndex");//序号\r\n");
    		s.append("\t\t\t//获取焦点  \r\n");
    		s.append("\t\t\tvar o_wTraname = $('#dg_bbbbb').datagrid('getEditor', {index:editIndex,field:'wTraname'});\r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t$(o_wTraname.target).textbox('textbox').focus();\r\n");
    		s.append("\t\t}  \r\n");
    		s.append("\t} \r\n");
    		s.append("  \r\n");
    		s.append("\tfunction setCell(editIndex) {\r\n");
    		s.append("\t\t//设置商品ID为只读 \r\n");
    		s.append("\t\tvar o_wId = $('#dg_bbbbb').datagrid('getEditor', {index:editIndex,field:'wId'}); \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t$(o_wId.target).textbox('textbox').attr('readonly',true);\r\n");
    		s.append("\t\t$(o_wId.target).textbox('textbox').css('background','#F5F5F5');  \r\n");
    		s.append("\t\t//设置商品规格为只读 \r\n");
    		s.append("\t\tvar o_wStandard = $('#dg_bbbbb').datagrid('getEditor', {index:editIndex,field:'wStandard'});\r\n".replaceAll("bbbbb", name));
    		s.append("\t\t$(o_wStandard.target).textbox('textbox').attr('readonly',true);  \r\n");
    		s.append("\t\t$(o_wStandard.target).textbox('textbox').css('background','#F5F5F5');  \r\n");
    		s.append("\t\t//设置单位为只读\r\n");
    		s.append("\t\tvar o_wUnit = $('#dg_bbbbb').datagrid('getEditor', {index:editIndex,field:'wUnit'});\r\n".replaceAll("bbbbb", name));
    		s.append("\t\t$(o_wUnit.target).textbox('textbox').attr('readonly',true); \r\n");
    		s.append("\t\t$(o_wUnit.target).textbox('textbox').css('background','#F5F5F5');\r\n");
    		s.append("\t\t//设置生产厂家为只读 \r\n");
    		s.append("\t\tvar o_wBusiness = $('#dg_bbbbb').datagrid('getEditor', {index:editIndex,field:'wBusiness'});\r\n".replaceAll("bbbbb", name));
    		s.append("\t\t$(o_wBusiness.target).textbox('textbox').attr('readonly',true);  \r\n");
    		s.append("\t\t$(o_wBusiness.target).textbox('textbox').css('background','#F5F5F5');  \r\n");
    		s.append("\t\t//设置产地为只读\r\n");
    		s.append("\t\tvar o_wPlace = $('#dg_bbbbb').datagrid('getEditor', {index:editIndex,field:'wPlace'}); \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t$(o_wPlace.target).textbox('textbox').attr('readonly',true);\r\n");
    		s.append("\t\t$(o_wPlace.target).textbox('textbox').css('background','#F5F5F5');  \r\n");
    		s.append("\t\t//设置批次为只读\r\n");
    		s.append("\t\tvar o_sbId = $('#dg_bbbbb').datagrid('getEditor', {index:editIndex,field:'sbId'});  \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t$(o_sbId.target).textbox('textbox').attr('readonly',true);  \r\n");
    		s.append("\t\t$(o_sbId.target).textbox('textbox').css('background','#F5F5F5'); \r\n");
    		s.append("\t\t//设置批号为只读\r\n");
    		s.append("\t\tvar o_batchNo = $('#dg_bbbbb').datagrid('getEditor', {index:editIndex,field:'batchNo'}); \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t$(o_batchNo.target).textbox('textbox').attr('readonly',true); \r\n");
    		s.append("\t\t$(o_batchNo.target).textbox('textbox').css('background','#F5F5F5'); \r\n");
    		s.append("\t\t//设置效期为只读\r\n");
    		s.append("\t\tvar o_validDate = $('#dg_bbbbb').datagrid('getEditor', {index:editIndex,field:'validDate'});\r\n".replaceAll("bbbbb", name));
    		s.append("\t\t$(o_validDate.target).textbox('textbox').attr('readonly',true);  \r\n");
    		s.append("\t\t$(o_validDate.target).textbox('textbox').attr('placeholder',\"20170101\");  \r\n");
    		s.append("\t\t$(o_validDate.target).textbox('textbox').css('background','#F5F5F5');  \r\n");
    		s.append("\t\t//设置货位为只读\r\n");
    		s.append("\t\tvar o_spCode = $('#dg_bbbbb').datagrid('getEditor', {index:editIndex,field:'spCode'}); \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t$(o_spCode.target).textbox('textbox').attr('readonly',true);\r\n");
    		s.append("\t\t$(o_spCode.target).textbox('textbox').css('background','#F5F5F5');  \r\n");
    		s.append("\t\t//设置生产日期为只读 \r\n");
    		s.append("\t\tvar o_produceDate = $('#dg_bbbbb').datagrid('getEditor', {index:editIndex,field:'produceDate'}); \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t$(o_produceDate.target).textbox('textbox').attr('readonly',true);\r\n");
    		s.append("\t\t$(o_produceDate.target).textbox('textbox').attr('placeholder',\"20170101\");\r\n");
    		s.append("\t\t$(o_produceDate.target).textbox('textbox').css('background','#F5F5F5');\r\n");
    		s.append("\t\t//序号\r\n");
    		s.append("\t\tvar o_wsdIndex = $('#dg_bbbbb').datagrid('getEditor', {index:editIndex,field:'wsdIndex'});  \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t$(o_wsdIndex.target).textbox('setValue',editIndex+1);  \r\n");
    		s.append("\t\t$(o_wsdIndex.target).textbox('textbox').attr('readonly',true);\r\n");
    		s.append("\t\t$(o_wsdIndex.target).textbox('textbox').css('background','#F5F5F5');\r\n");
    		s.append("\t} \r\n");
    		s.append("\t//删除行\r\n");
    		s.append("\tfunction removeDgDetail(){\r\n");
    		s.append("\t\tif (editIndex == undefined){return} \r\n");
    		s.append("\t\t$('#dg_bbbbb').datagrid('cancelEdit', editIndex)\r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t.datagrid('deleteRow', editIndex);\r\n");
    		s.append("\t\teditIndex = undefined;  \r\n");
    		s.append("\t} \r\n");
    		s.append("\t//保存  \r\n");
    		s.append("\tfunction accept(){\r\n");
    		s.append("\t\tvar wsId = $('#wsId').val();  \r\n");
    		s.append("\t\tif( $.trim(wsId).length == 0){\r\n");
    		s.append("\t\t\t$.messager.alert('提示', '清填写入库单号！');\r\n");
    		s.append("\t\t\treturn false; \r\n");
    		s.append("\t\t}  \r\n");
    		s.append("\t\tif (endEditing()){ \r\n");
    		s.append("\t\t\tif ($('#dg_bbbbb').datagrid('getChanges').length) {\r\n".replaceAll("bbbbb", name));
    		s.append("//\t\t\t\t\tdebugger;  \r\n");
    		s.append("\t\t\t\tvar inserted = $('#dg_bbbbb').datagrid('getChanges', \"inserted\"); \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\tvar deleted = $('#dg_bbbbb').datagrid('getChanges', 'deleted');\r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\tvar updated = $('#dg_bbbbb').datagrid('getChanges', \"updated\");\r\n".replaceAll("bbbbb", name));
    		s.append("  \r\n");
    		s.append("\t\t\t\tvar effectRow = new Object();\r\n");
    		s.append("\t\t\t\tif (inserted.length) { \r\n");
    		s.append("\t\t\t\t\tinserted = JSON.stringify(inserted);  \r\n");
    		s.append("\t\t\t\t} \r\n");
    		s.append("\t\t\t\tif (deleted.length) {  \r\n");
    		s.append("\t\t\t\t\tdeleted = JSON.stringify(deleted); \r\n");
    		s.append("\t\t\t\t} \r\n");
    		s.append("\t\t\t\tif (updated.length) {  \r\n");
    		s.append("\t\t\t\t\tupdated = JSON.stringify(updated); \r\n");
    		s.append("\t\t\t\t} \r\n");
    		s.append("  \r\n");
    		s.append("\t\t\t\t$.post('/erp/bbbbbdetail/save.yy',  \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\t\t{wsId:wsId,  \r\n");
    		s.append("\t\t\t\t\t\tadd:inserted,\r\n");
    		s.append("\t\t\t\t\t\tdel:deleted, \r\n");
    		s.append("\t\t\t\t\t\tmodify:updated  \r\n");
    		s.append("\t\t\t\t\t}, \r\n");
    		s.append("\t\t\t\t\tfunction(data) {  \r\n");
    		s.append("\t\t\t\t\t\tvar rj = eval('(' + data + ')'); \r\n");
    		s.append("\t\t\t\t\t\tif(rj.status){  \r\n");
    		s.append("\t\t\t\t\t\t\t$.messager.alert('提示', rj.desc +',提交成功！'); \r\n");
    		s.append("\t\t\t\t\t\t\t$('#tb_bbbbb').datagrid('acceptChanges');\r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t}, 'JSON').error(function() { \r\n");
    		s.append("\t\t\t\t\t$.messager.alert('提示', '提交错误了！');\r\n");
    		s.append("\t\t\t\t});  \r\n");
    		s.append("\t\t\t}\r\n");
    		s.append("\t\t}  \r\n");
    		s.append("\t\t//保存后 \r\n");
    		s.append("\t\t$('#dg_bbbbb').datagrid('acceptChanges');  \r\n".replaceAll("bbbbb", name));
    		s.append("\t} \r\n");
    		s.append("\t//保存表单，同时保存明细  \r\n");
    		s.append("\tfunction submitForm(){ \r\n");
    		s.append("\t\t//第二种 \r\n");
    		s.append("\t\t$('#ff_bbbbb').form('submit',{  \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\tonSubmit:function(){  \r\n");
    		s.append("\t\t\t\tif (endEditing()) { \r\n");
    		s.append("\t\t\t\t\tif ($('#dg_bbbbb').datagrid('getChanges').length) { \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\t\t\tvar inserted = $('#dg_bbbbb').datagrid('getChanges', \"inserted\");\r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\t\t\tvar deleted = $('#dg_bbbbb').datagrid('getChanges', 'deleted');  \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\t\t\tvar updated = $('#dg_bbbbb').datagrid('getChanges', \"updated\");  \r\n".replaceAll("bbbbb", name));
    		s.append("  \r\n");
    		s.append("\t\t\t\t\t\tvar effectRow = new Object();  \r\n");
    		s.append("\t\t\t\t\t\tif (inserted.length) {\r\n");
    		s.append("\t\t\t\t\t\t\tinserted = JSON.stringify(inserted); \r\n");
    		s.append("\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t\tif (deleted.length) { \r\n");
    		s.append("\t\t\t\t\t\t\tdeleted = JSON.stringify(deleted);\r\n");
    		s.append("\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t\tif (updated.length) { \r\n");
    		s.append("\t\t\t\t\t\t\tupdated = JSON.stringify(updated);\r\n");
    		s.append("\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t\t$(\"#add\").val(inserted); \r\n");
    		s.append("\t\t\t\t\t\t$(\"#del\").val(deleted);  \r\n");
    		s.append("\t\t\t\t\t\t$(\"#modify\").val(updated);  \r\n");
    		s.append("\t\t\t\t\t}  \r\n");
    		s.append("\t\t\t\t} \r\n");
    		s.append("\t\t\t\treturn $(this).form('validate');\r\n");
    		s.append("\t\t\t},  \r\n");
    		s.append("\t\t\tsuccess:function(data){  \r\n");
    		s.append("\t\t\t\tvar rj = eval('(' + data + ')');\r\n");
    		s.append("\t\t\t\tif(rj.status == 1){ \r\n");
    		s.append("\t\t\t\t\tvar tab = $('#admin_tabs').tabs('getSelected');  // get selected panel \r\n");
    		s.append("\t\t\t\t\ttab.panel('refresh','/erp/bbbbb/index.yy');  \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\t}else{ \r\n");
    		s.append("\t\t\t\t\t$.messager.alert('Info', rj.desc, 'error'); \r\n");
    		s.append("\t\t\t\t} \r\n");
    		s.append("\t\t\t}\r\n");
    		s.append("\t\t});\r\n");
    		s.append("\t} \r\n");
    		s.append("\t//清空表单 \r\n");
    		s.append("\tfunction clearForm(){\r\n");
    		s.append("\t\t$('#ff_bbbbb').form('clear');\r\n".replaceAll("bbbbb", name));
    		s.append("\t} \r\n");
    		s.append("  \r\n");
    		s.append("\t//结束编辑 \r\n");
    		s.append("\tfunction onEndEdit(index, row){ \r\n");
    		s.append("\t\tvar ed = $(this).datagrid('getEditor', { \r\n");
    		s.append("\t\t\tindex: index, \r\n");
    		s.append("\t\t\tfield: 'wTraname'\r\n");
    		s.append("\t\t});\r\n");
    		s.append("\t} \r\n");
    		s.append("  \r\n");
    		s.append("\t//绑定明细行单元格事件 \r\n");
    		s.append("\tvar div_indexx = 0;//当前行  \r\n");
    		s.append("\tfunction bindCellKeyEvent(index,field) { \r\n");
    		s.append("\t\tvar ed = $('#dg_bbbbb').datagrid('getEditor', {index:index,field:field});\r\n".replaceAll("bbbbb", name));
    		s.append("\t\tif (ed){ \r\n");
    		s.append("\t\t\t$(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target);\r\n");
    		s.append("\t\t\tif(field == 'wTraname'){ \r\n");
    		s.append("\t\t\t\t$(ed.target).textbox('textbox').bind('keyup', function(event){  \r\n");
    		s.append("\t\t\t\t\tif(event.keyCode == 38) {//上 \r\n");
    		s.append("\t\t\t\t\t\tvar flag = $(\"#findWare_div\").is(\":visible\");  \r\n");
    		s.append("\t\t\t\t\t\tif (flag) {\r\n");
    		s.append("\t\t\t\t\t\t\tdiv_indexx--; \r\n");
    		s.append("\t\t\t\t\t\t\tif (div_indexx == 0) { \r\n");
    		s.append("\t\t\t\t\t\t\t\tdiv_indexx = 1;\r\n");
    		s.append("\t\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t\t\tvar ul = $(\"#findWare_div\").find(\"ul:eq(\" + div_indexx + \")\");  \r\n");
    		s.append("\t\t\t\t\t\t\tvar validdate = $(ul).find(\"li:eq(7)\")[0].innerText;\r\n");
    		s.append("\t\t\t\t\t\t\tvar bg =setBgColor(validdate,\"#E8F4FC\");\t\t\t \t\r\n");
    		s.append("\t\t\t\t\t\t\tul.css(\"background\", bg).siblings().css(\"background\", \"\");\r\n");
    		s.append("\t\t\t\t\t\t\treturn;  \r\n");
    		s.append("\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t \t} \r\n");
    		s.append("\t\t\t\t\tif(event.keyCode == 40){//下  \r\n");
    		s.append("\t\t\t\t\t\tvar flag = $(\"#findWare_div\").is(\":visible\");  \r\n");
    		s.append("\t\t\t\t\t\tif (flag){ \r\n");
    		s.append("\t\t\t\t\t\t\tdiv_indexx ++;\r\n");
    		s.append("\t\t\t\t\t\t\tvar div_rows = $(\"#findWare_div ul\").length; \r\n");
    		s.append("\t\t\t\t\t\t\tif(div_indexx == div_rows){  \r\n");
    		s.append("\t\t\t\t\t\t\t\tdiv_indexx--;  \r\n");
    		s.append("\t\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t\t\t \r\n");
    		s.append("\t\t\t\t\t\t\tvar ul = $(\"#findWare_div\").find(\"ul:eq(\" + div_indexx + \")\");  \r\n");
    		s.append("\t\t\t\t\t\t\t \r\n");
    		s.append("\t\t\t\t\t\t\tvar validdate = $(ul).find(\"li:eq(7)\")[0].innerText;\r\n");
    		s.append("\t\t\t\t\t\t\tvar bg =setBgColor(validdate,\"#E8F4FC\");\r\n");
    		s.append("\t\t\t\t\t\t\tul.css(\"background\", bg).siblings().css(\"background\", \"\");\r\n");
    		s.append("\t\t\t\t\t\t\treturn;  \r\n");
    		s.append("\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t}  \r\n");
    		s.append("\t\t\t\t\tif(event.keyCode == 13){\r\n");
    		s.append("\t\t\t\t\t\tif (div_indexx > 0 ){ \r\n");
    		s.append("\t\t\t\t\t\t\tvar div_ul_index = div_indexx; \r\n");
    		s.append("\t\t\t\t\t\t\tdiv_indexx = 0;  \r\n");
    		s.append("\t\t\t\t\t\t\t$(\"#wares_ul_\"+div_ul_index).click();\r\n");
    		s.append("\t\t\t\t\t\t\treturn ; \r\n");
    		s.append("\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t}  \r\n");
    		s.append("  \r\n");
    		s.append("\t\t\t\t\tvar str = $(this).val();\r\n");
    		s.append("\t\t\t\t\tif(str != \"\"){ \r\n");
    		s.append("\t\t\t\t\t\tvar x = $(this).offset().left; \r\n");
    		s.append("\t\t\t\t\t\tvar y = $(this).offset().top;  \r\n");
    		s.append("\t\t\t\t\t\t$(\"#findWare_div\").css(\"left\",x-50);\r\n");
    		s.append("\t\t\t\t\t\t$(\"#findWare_div\").css(\"top\",y-8);  \r\n");
    		s.append("\t\t\t\t\t\tfindWare($(this)); \r\n");
    		s.append("\t\t\t\t\t}else{  \r\n");
    		s.append("\t\t\t\t\t\t$(\"#findWare_div\").hide();  \r\n");
    		s.append("\t\t\t\t\t}  \r\n");
    		s.append("//\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t});  \r\n");
    		s.append("\t\t\t}else{//修改批发价格或数量时修改金额 \r\n");
    		s.append("\t\t\t\tif(field == 'wsdPrice'){  \r\n");
    		s.append("\t\t\t\t\t$(ed.target).textbox('textbox').bind('keydown', function(e){  \r\n");
    		s.append("//\t\t\t\t\t\tif(e.keyCode != 8){//13回车键,8退格键\r\n");
    		s.append("\t\t\t\t\t\tif(e.keyCode == 13){  \r\n");
    		s.append("\t\t\t\t\t\t\tvar str = $(this).val();  \r\n");
    		s.append("\t\t\t\t\t\t\tif(str != \"\" && !isNaN(str)){\r\n");
    		s.append("\t\t\t\t\t\t\t\tvar o_amount = $('#dg_bbbbb').datagrid('getEditor',{index:index,field:\"wsdAmount\"}); \r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\t\t\t\t\tvar o_money = $('#dg_bbbbb').datagrid('getEditor',{index:index,field:\"wsdMoney\"});\r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\t\t\t\t\tvar amount = $(o_amount.target).textbox('getValue'); \r\n");
    		s.append("\t\t\t\t\t\t\t\tvar money = parseFloat(str) * parseFloat(amount); \r\n");
    		s.append("\t\t\t\t\t\t\t\t$(o_money.target).textbox('setValue',money.toFixed(2)); \r\n");
    		s.append("\t\t\t\t\t\t\t}else{\r\n");
    		s.append("\t\t\t\t\t\t\t\t$.messager.alert(\"错误\",\"批发价为数字\",\"error\",function () {  \r\n");
    		s.append("\t\t\t\t\t\t\t\t\t$(this).select();  \r\n");
    		s.append("\t\t\t\t\t\t\t\t}); \r\n");
    		s.append("\t\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t});\r\n");
    		s.append("\t\t\t\t}else if(field == 'wsdAmount'){ \r\n");
    		s.append("\t\t\t\t\t$(ed.target).textbox('textbox').bind('keydown', function(e){  \r\n");
    		s.append("\t\t\t\t\t\t//if(e.keyCode != 8){//13回车键,8退格键\r\n");
    		s.append("\t\t\t\t\t\tif(e.keyCode == 13){  \r\n");
    		s.append("\t\t\t\t\t\t\tvar str = $(this).val();  \r\n");
    		s.append("\t\t\t\t\t\t\tif(str != \"\" && !isNaN(str)){\r\n");
    		s.append("\t\t\t\t\t\t\t\tvar o_price = $('#dg_bbbbb').datagrid('getEditor',{index:index,field:\"wsdPrice\"});\r\n".replaceAll("bbbbb", name));
    		s.append("\t\t\t\t\t\t\t\tvar o_money = $('#dg_bbbbb').datagrid('getEditor',{index:index,field:\"wsdMoney\"});\r\n".replaceAll("bbbbb", name));
    		s.append("  \r\n");
    		s.append("\t\t\t\t\t\t\t\tvar price = $(o_price.target).textbox('getValue');\r\n");
    		s.append("\t\t\t\t\t\t\t\tvar money = parseFloat(str) * parseFloat(price);\r\n");
    		s.append("\t\t\t\t\t\t\t\t$(o_money.target).textbox('setValue',money.toFixed(2)); \r\n");
    		s.append("\t\t\t\t\t\t\t}else{\r\n");
    		s.append("\t\t\t\t\t\t\t\t$.messager.alert(\"错误\",\"数量为数字\",\"error\",function () { \r\n");
    		s.append("\t\t\t\t\t\t\t\t\t$(this).select();  \r\n");
    		s.append("\t\t\t\t\t\t\t\t}); \r\n");
    		s.append("  \r\n");
    		s.append("\t\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t});\r\n");
    		s.append("\t\t\t\t}else if(field == 'validDate'){ \r\n");
    		s.append("\t\t\t\t\t$(ed.target).textbox('textbox').bind('blur', function(e){  \r\n");
    		s.append("\t\t\t\t\t\tvar str = $(this).val(); \r\n");
    		s.append("\t\t\t\t\t\tif(str != \"\"){  \r\n");
    		s.append("\t\t\t\t\t\t\tvar date_reg = /^[0-9]{4}[0-1]?[0-9]{1}[0-3]?[0-9]{1}$/;  \r\n");
    		s.append("\t\t\t\t\t\t\tif(!(date_reg.test(str))){\r\n");
    		s.append("\t\t\t\t\t\t\t\t$.messager.alert(\"错误\",\"抱歉，您输入的效期有误，正确格式应为:20170101\",\"error\",function () { \r\n");
    		s.append("\t\t\t\t\t\t\t\t\t$(ed.target).textbox('textbox').select();\r\n");
    		s.append("\t\t\t\t\t\t\t\t}); \r\n");
    		s.append("\t\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t});\r\n");
    		s.append("\t\t\t\t}else if(field == 'produceDate'){  \r\n");
    		s.append("\t\t\t\t\t$(ed.target).textbox('textbox').bind('blur', function(e){  \r\n");
    		s.append("\t\t\t\t\t\tvar str = $(this).val(); \r\n");
    		s.append("\t\t\t\t\t\tif(str != \"\"){  \r\n");
    		s.append("\t\t\t\t\t\t\tvar date_reg = /^[0-9]{4}[0-1]?[0-9]{1}[0-3]?[0-9]{1}$/;  \r\n");
    		s.append("\t\t\t\t\t\t\tif(!(date_reg.test(str))){\r\n");
    		s.append("\t\t\t\t\t\t\t\t$.messager.alert(\"错误\",\"抱歉，您输入的生产日期有误，正确格式应为:20170101\",\"error\",function () {\r\n");
    		s.append("\t\t\t\t\t\t\t\t\t$(ed.target).textbox('textbox').select();\r\n");
    		s.append("\t\t\t\t\t\t\t\t}); \r\n");
    		s.append("\t\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t});\r\n");
    		s.append("\t\t\t\t}else if(field == 'wsdIndex'){  \r\n");
    		s.append("\t\t\t\t\t$(ed.target).textbox('textbox').bind('keydown', function(e){  \r\n");
    		s.append("\t\t\t\t\t\tvar str = $(this).val(); \r\n");
    		s.append("\t\t\t\t\t\t//debugger;\r\n");
    		s.append("\t\t\t\t\t\tif(str != \"\" &&  !isNaN(str)){ \r\n");
    		s.append("\t\t\t\t\t\t\tif(e.keyCode == 13 || e.keyCode == 9){  \r\n");
    		s.append("\t\t\t\t\t\t\t\t$(\"#append_detail\").click(); \r\n");
    		s.append("\t\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t\t}else{\r\n");
    		s.append("\t\t\t\t\t\t\t$.messager.alert(\"错误\",\"序号为数字\",\"error\",function () {\r\n");
    		s.append("\t\t\t\t\t\t\t\t$(this).select(); \r\n");
    		s.append("\t\t\t\t\t\t\t}); \r\n");
    		s.append("\t\t\t\t\t\t}\r\n");
    		s.append("\t\t\t\t\t});\r\n");
    		s.append("\t\t\t\t} \r\n");
    		s.append("  \r\n");
    		s.append("\t\t\t}\r\n");
    		s.append("\t\t}  \r\n");
    		s.append("\t} \r\n");
    		s.append("  \r\n");
    		s.append("\tfunction setColor(value,row,index){\r\n");
    		s.append("\t\tif(value != undefined && value != \"\"){ \r\n");
    		s.append("\t\t\tvar now = new Date(); \r\n");
    		s.append("\t\t\tvar vdt = new Date(value.substr(0,4)+\"-\"+value.substr(4,2)+\"-\"+value.substr(6,2)); \r\n");
    		s.append("\t\t\tvar vms = vdt -now ;  \r\n");
    		s.append("\t\t\tif(vms < 7776000000){//三个月  \r\n");
    		s.append("\t\t\t\treturn 'background-color:#ff0000;color:#ffee00;';  \r\n");
    		s.append("\t\t\t}\r\n");
    		s.append("\t\t\tif( vms < 15552000000){//半年\t\t\t  \r\n");
    		s.append("\t\t\t\treturn 'background-color:#ffee00;color:#ff0000;';  \r\n");
    		s.append("\t\t\t}\r\n");
    		s.append("\t\t}\t\t\t  \r\n");
    		s.append("\t} \r\n");
    		s.append("  \r\n");
    		s.append("\tfunction setReadColor(value,row,index){  \r\n");
    		s.append("\t\treturn 'background-color:#F5F5F5;'; \r\n");
    		s.append("\t} \r\n");
    		s.append("\t\r\n");
    		*/
    		s.append("\t</script>  \r\n");
    		s.append("  \r\n");
		}catch(Exception e){
			e.printStackTrace();
		}
    	
    	return s.toString();
	}
    /**
     * 获取表结构中主键字段名
     * @param tsfs
     * @return
     */
    private static String getIdName(List<TableStructField> tsfs) {
    	String idname = null;
    	if(!tsfs.isEmpty()){    		
    		for(TableStructField tsf : tsfs){
    			if("key".equals(tsf.getTsfKey())){
    				idname = getFieldName(tsf.getTsfName());
    				break;
    			}
    		}
    	}
    	return idname;
	}
    /**
     * 获取字段名在实体类中属性名称
     * @param tableFieldName
     * @return
     */
	public static String getFieldName(String tableFieldName){
    	//表名转实体名
    	
    	String []entityNames = tableFieldName.split("_");
    	int len = entityNames.length;
    	String entityName =  entityNames[0].toLowerCase();
    	for(int i=1;i< len ; i++){
    		entityName += entityNames[i].substring(0, 1).toUpperCase()+entityNames[i].substring(1);
    	}
    	return entityName;
    }

	
	/**
     * 根据 mapusermodule 文件夹复制 当前生成的 页面目录和文件
     * @param name
     */
    public static void copyPage(String rootPath,String name) throws Exception{
        try {
            //获取要读内容文件
//            File directory = new File(".");
//            String path = directory.getCanonicalPath(); //得到的是当前标准的路径

        	rootPath = rootPath.substring(0,rootPath.length()-4);
            String viewsPath = "/webapp/WEB-INF/views";//页面路径

            String srcname = "mapusermodule";//源文件夹名称
            String desname = name.toLowerCase();//目标文件夹名称


            copy(rootPath+viewsPath+srcname ,rootPath+viewsPath+desname,srcname,desname);
            System.out.println("文件拷贝完成!");

        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("生成页面时异常:",e);
        }
    }

    /**
     * 复制文件夹包含文件
     * @param src
     * @param des
     */
    private static void copy(String src, String des, String srcname,String desname) throws Exception{
        File file1=new File(src);
        File[] fs=file1.listFiles();
        File file2=new File(des);
        if(!file2.exists()){
            file2.mkdirs();
        }
        for (File f : fs) {
            if(f.isFile()){
                fileCopy(f.getPath(),des+"/"+f.getName(),srcname,desname); //调用文件拷贝的方法
            }else if(f.isDirectory()){
                copy(f.getPath(),des+"/"+f.getName(),srcname,desname);
            }
        }
    }

    /**
     * 文件拷贝的方法
     */
    private static void fileCopy(String src, String des, String srcname,String desname) throws Exception {

        BufferedReader br=null;
        PrintStream ps=null;

        try {
            br=new BufferedReader(new InputStreamReader(new FileInputStream(src)));
            ps=new PrintStream(new FileOutputStream(des));
            String s=null;
            while((s=br.readLine())!=null){
                if( s.indexOf(srcname) >= 0){
                    s= s.replace(srcname,desname);
                }
                ps.println(s);
                ps.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("生成页面文件拷贝的方法时异常:",e);
        }finally{

            try {
                if(br!=null)  br.close();
                if(ps!=null)  ps.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new Exception("生成页面文件拷贝的方法关闭文件流时异常:",e);
            }
        }
    }
}
