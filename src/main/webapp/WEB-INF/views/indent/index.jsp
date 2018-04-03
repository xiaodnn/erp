<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div id="tb_indent" style="padding:5px;height:auto">
		<div id="indent_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_indent()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_indent()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_indent()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="s_wId" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_indent()">查找</a>
		</div>
	</div>
	<table id="dg_indent" class="easyui-datagrid" style="width:100%;height:100%;" title="1111信息信息" data-options="toolbar:'#tb_indent',singleSelect:true,fitColumns:true,rownumbers:true,pagination:true,datapagesize:5">
		<thead>
			<tr>
				<th data-options="field:'iId',width:80">合同单号</th>
				<th data-options="field:'iInitime',width:80">制单时间</th>
				<th data-options="field:'oId',width:80">业务机构</th>
				<th data-options="field:'shId',width:80">仓库</th>
				<th data-options="field:'iCreator',width:80">制单人</th>
				<th data-options="field:'cId',width:80">供应商编码</th>
				<th data-options="field:'iState',width:80">审核状态</th>
				<th data-options="field:'iMemo',width:80">备注</th>
				<th data-options="field:'iChktime',width:80">审核时间</th>
			</tr>
		</thead>
	</table>
	<div id="dlg_indent" class="easyui-dialog" title="新增采购订单信息" style="width:500px;height:250px;padding:10px;"
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
		<form id="ff_indent" class="easyui-form" method="post" action="/erp/indent/save.yy" data-options="novalidate:false">
			<input type="hidden" id="iId" name="iId" value="${iId}" />
			<table>
				<tr>
					<td align="right">制单时间:</td>
					<td><input class="easyui-datebox" id="iInitime" name="iInitime" data-options="required:false" /></td>
					<td align="right">业务机构:</td>
					<td><input class="easyui-combobox" id="oId" name="oId" data-options="required:false" /></td>
				</tr>
				<tr>
					<td align="right">仓库:</td>
					<td><input class="easyui-combobox" id="shId" name="shId" data-options="required:false" /></td>
					<td align="right">制单人:</td>
					<td><input class="easyui-textbox" id="iCreator" name="iCreator" data-options="required:false" /></td>
				</tr>
				<tr>
					<td align="right">供应商编码:</td>
					<td><input class="easyui-combobox" id="cId" name="cId" data-options="required:false" /></td>
					<td align="right">审核状态:</td>
					<td><input class="easyui-combobox" id="iState" name="iState" data-options="required:false" /></td>
				</tr>
				<tr>
					<td align="right">备注:</td>
					<td><input class="easyui-textbox" id="iMemo" name="iMemo" data-options="required:false" /></td>
					<td align="right">审核时间:</td>
					<td><input class="easyui-datebox" id="iChktime" name="iChktime" data-options="required:false" /></td>
				</tr>
			</table>
		</form>
	</div>

<script>
	$(function(){
		init();
	});
	function init(){
		$('#dg_indent').datagrid({
			url:'/erp/indent/dg_find.yy'
		});
	}
	function add_indent(){
		dialog_open();
	}
	function modify_indent(){
		var row = $('#dg_indent').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
			dialog_open();
			$("#iId").val(row.iId);
		}
	}
	function del_indent(){
		var row = $('#dg_indent').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
			var id = row.iId;
			$.post("/erp/indent/del_json.yy",
			{id:id},
			function(data){
				if(data > 0){
					$.messager.alert('Info', "采购订单信息已删除", 'error');
					init();
				}
			}
		);}
	}
	function find_indent(){
		var url = '/erp/indent/dg_find.yy?id='+$("#iId").val() ;
		$('#dg_indent').datagrid({
			url: url
		});
	}
	function dialog_open(){
		$('#dlg_indent').dialog('open');
	}
	function dialog_close(){
		$('#dlg_indent').dialog('close');
	}
	function submit_form(){
		$('#ff_indent').form('submit',{
			onSubmit:function(){
				return $(this).form('validate');
			},
			success:function(data){
				var rj = eval('(' + data + ')');
				$.messager.alert('Info',rj.desc, 'Info');
				if(rj.status == 1){
					dialog_close();
					$("#ff_indent").form('clear');
					init();
				}
			}
		});
	}
</script>r
