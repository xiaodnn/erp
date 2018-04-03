<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div id="tb_tablestruct" style="padding:5px;height:auto">
		<div id="tablestruct_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_tablestruct()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_tablestruct()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_tablestruct()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="s_wId" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_tablestruct()">查找</a>
		</div>
	</div>

	<table id="dg_tablestruct" class="easyui-datagrid" style="width:100%;height:100%;"
			 title="表结构信息信息" data-options="toolbar:'#tb_tablestruct',singleSelect:true,fitColumns:true,rownumbers:true,pagination:true,datapagesize:5">
		<thead>
			<tr>
				<th data-options="field:'tsId',width:40">表ID</th>
				<th data-options="field:'tsName',width:160">表名</th>
				<th data-options="field:'tsNikename',width:160">表名称</th>
				<th data-options="field:'tsType',width:160">表类型</th>
				<th data-options="field:'tsMid',width:160">主表ID</th>
				<th data-options="field:'tsRemark',width:160">备注</th>
				<th data-options="field:'intime',width:160">创建时间</th>
			</tr>
		</thead>
	</table>

	<div id="dlg_tablestruct" class="easyui-dialog" title="新增表结构信息信息" style="width:500px;height:250px;padding:10px;"
		 data-options="closed:true,
						buttons: [{
							text:'保存',
							iconCls:'icon-ok',
							handler:function(){
								submit_form();
							}
						},{
							text:'取消',
							handler:function(){
								dialog_close();
							}
						}]">
				<form id="ff_tablestruct" class="easyui-form" method="post" action="/erp/tablestruct/save.yy" data-options="novalidate:false">
					<input type="hidden" id="tsId" name="tsId" value="${tsId}" />
					<table>
						<tr>
							<td align="right">表名:</td>
							<td><input class="easyui-textbox" type="text" id="tsName" name="tsName" data-options="required:true" /></td>
							<td>表名称:</td>
							<td><input class="easyui-textbox" type="text" id="tsNikename" name="tsNikename" data-options="required:true" /></td>
						</tr>
						<tr>
							<td align="right">表类型:</td>
							<td><select  style="width:100px;" class="easyui-combobox" id="tsType" name="tsType" data-options="required:true,panelHeight:'auto'">
									<option value="1">普通</option>
									<option value="2">单据</option>
								</select>
							</td>						
							<td>主表ID:</td>
							<td><input class="easyui-textbox" type="text" id="tsMid" name="tsMid" /></td>
						</tr>
						<tr>
							<td align="right">备注:</td>
							<td colspan="3"><input class="easyui-textbox" type="text" id="tsRemark" name="tsRemark" /></td>							
						</tr>
					</table>
				</form>
	</div>

	<script>
	$(function(){
        init();
    });

	function init(){
        $('#dg_tablestruct').datagrid({
            url: '/erp/tablestruct/dg_find.yy'
        });
	}

	function add_tablestruct(){
        dialog_open();
	}
	function modify_tablestruct(){
		var row = $('#dg_tablestruct').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
            dialog_open();
			$("#tsId").val(row.tsId);
            $("#wpgName").textbox('setValue',row.wpgName);
		}
	}
	function del_tablestruct(){
		var row = $('#dg_tablestruct').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var shId = row.shId;
			$.post("/erp/tablestruct/del_json.yy",
					{id:tsId},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "111信息已删除", 'error');
                            init();
						}
					}
				);
		}
	}
	
	function find_tablestruct(){
		var url = '/erp/tablestruct/dg_find.yy?id='+$("#tsId").val() ;
		$('#dg_tablestruct').datagrid({
			url: url
		});
	}
    function dialog_open(){
        $('#dlg_tablestruct').dialog('open');
    }
	function dialog_close(){
        $('#dlg_tablestruct').dialog('close');
	}

    function submit_form(){
        //第二种
        $('#ff_tablestruct').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                $.messager.alert('Info',rj.desc, 'Info');
                if(rj.status == 1){
                    dialog_close();
                    $("#ff_tablestruct").form('clear');
                    init();
                }
            }
        });
    }
	</script>