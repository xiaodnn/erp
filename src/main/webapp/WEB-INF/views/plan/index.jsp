<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div id="tb_plan" style="padding:5px;height:auto">
		<div id="plan_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_plan()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_plan()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_plan()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="s_wId" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_plan()">查找</a>
		</div>
	</div>
	<table id="dg_plan" class="easyui-datagrid" style="width:100%;height:100%;" title="1111信息信息" data-options="toolbar:'#tb_plan',singleSelect:true,fitColumns:true,rownumbers:true,pagination:true,datapagesize:5">
		<thead>
			<tr>
				<th data-options="field:'pId',width:80">计划单号</th>
				<th data-options="field:'pInitime',width:80">制单时间</th>
				<th data-options="field:'oId',width:80">计划机构</th>
				<th data-options="field:'pRid',width:80">计划仓库</th>
				<th data-options="field:'pCreator',width:80">制单人</th>
				<th data-options="field:'pCid',width:80">供应商ID</th>
				<th data-options="field:'pState',width:80">审核状态</th>
				<th data-options="field:'pMemo',width:80">备注</th>
				<th data-options="field:'pChktime',width:80">审核时间</th>
			</tr>
		</thead>
	</table>
	<div id="dlg_plan" class="easyui-dialog" title="新增采购计划信息" style="width:500px;height:250px;padding:10px;"
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
		<form id="ff_plan" class="easyui-form" method="post" action="/erp/plan/save.yy" data-options="novalidate:false">
			<input type="hidden" id="pId" name="pId" value="${pId}" />
			<table>
				<tr>
					<td align="right">制单时间:</td>
					<td><input class="easyui-datebox" id="pInitime" name="pInitime" data-options="required:false" /></td>
					<td align="right">计划机构:</td>
					<td><input class="easyui-combobox" id="oId" name="oId" data-options="required:false" /></td>
				</tr>
				<tr>
					<td align="right">计划仓库:</td>
					<td><input class="easyui-textbox" id="pRid" name="pRid" data-options="required:false" /></td>
					<td align="right">制单人:</td>
					<td><input class="easyui-combobox" id="pCreator" name="pCreator" data-options="required:false" /></td>
				</tr>
				<tr>
					<td align="right">供应商ID:</td>
					<td><input class="easyui-combobox" id="pCid" name="pCid" data-options="required:false" /></td>
					<td align="right">审核状态:</td>
					<td><input class="easyui-combobox" id="pState" name="pState" data-options="required:false" /></td>
				</tr>
				<tr>
					<td align="right">备注:</td>
					<td><input class="multiline" id="pMemo" name="pMemo" data-options="required:false" /></td>
					<td align="right">审核时间:</td>
					<td><input class="easyui-datebox" id="pChktime" name="pChktime" data-options="required:false" /></td>
				</tr>
			</table>
		</form>
	</div>

<script>
	$(function(){
		init();
	});
	function init(){
		$('#dg_plan').datagrid({
			url:'/erp/plan/dg_find.yy'
		});
	}
	function add_plan(){
		dialog_open();
	}
	function modify_plan(){
		var row = $('#dg_plan').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
			dialog_open();
			$("#pId").val(row.pId);
		}
	}
	function del_plan(){
		var row = $('#dg_plan').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
			var id = row.pId;
			$.post("/erp/plan/del_json.yy",
			{id:id},
			function(data){
				if(data > 0){
					$.messager.alert('Info', "采购计划信息已删除", 'error');
					init();
				}
			}
		);}
	}
	function find_plan(){
		var url = '/erp/plan/dg_find.yy?id='+$("#pId").val() ;
		$('#dg_plan').datagrid({
			url: url
		});
	}
	function dialog_open(){
		$('#dlg_plan').dialog('open');
	}
	function dialog_close(){
		$('#dlg_plan').dialog('close');
	}
	function submit_form(){
		$('#ff_plan').form('submit',{
			onSubmit:function(){
				return $(this).form('validate');
			},
			success:function(data){
				var rj = eval('(' + data + ')');
				$.messager.alert('Info',rj.desc, 'Info');
				if(rj.status == 1){
					dialog_close();
					$("#ff_plan").form('clear');
					init();
				}
			}
		});
	}
</script>r
