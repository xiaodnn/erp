<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_wholesale" style="padding:5px;height:auto">
		<div id="wholesale_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_wholesale()">添加单据</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_wholesale()">修改单据</a>
			<!--<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_wholesale()">删除单据</a>-->
			&nbsp;&nbsp;&nbsp;&nbsp;
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="cname" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_wholesale()">查找</a>
		</div>
	</div>
	<table id="dg_wholesale" class="easyui-datagrid" style="width:100%;height:auto;"
			data-options="toolbar:'#tb_wholesale',singleSelect:true,fitColumns:true,rownumbers:true,pagination:true,onDblClickRow:dbclickrow">
		<thead>
			<tr align="center">
				<th field="wsId" width="80" halign="center">批发单号</th>
				<th field="wsDate" width="70" halign="center" formatter="formatDatebox">制单时间</th>
				<th field="shId" width="80" halign="center">出库仓库</th>
				<th field="wsCreator" width="50" halign="center">制单人</th>
				<th field="cbId" width="100" halign="center">客户名称</th>
				<th field="cbStorehouse" width="150" halign="center">客户收货地址</th>
				<th field="wsReceiveWay" width="40" halign="center">提货方式</th>
				<th field="stateName" width="40" halign="center">审核状态</th>
				<th field="wsRemark" width="150" halign="center">备注</th>
				<th field="intime" width="60" halign="center" formatter="formatDatebox">制单时间</th>
			</tr>
		</thead>
	</table>
	<script>
	$(function(){
		$('#dg_wholesale').datagrid({
			url: '/erp/wholesale/dg_find.yy'
		});
	});
	
	function add_wholesale(){
		var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
		tab.panel('refresh','/erp/wholesale/add.yy');
	}
	function modify_wholesale(){
		var row = $('#dg_wholesale').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
		    url = '/erp/wholesale/add.yy?wsId='+row.wsId;
		    var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
			tab.panel('refresh',url);
		}
	}
	function dbclickrow(index, row){
		modify_wholesale();
	}
	function del_wholesale(){
		var row = $('#dg_wholesale').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var wsId = row.wsId;
			$.post("/erp/wholesale/del_json.yy",
					{wsId:wsId},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "入库已删除", 'error');
							$('#dg_wholesale').datagrid({
								url: '/erp/wholesale/dg_find.yy'
							});
						}
					}
				);
		}
	}
	
	function find_wholesale(){
		var url = '/erp/wholesale/dg_find.yy?cname='+$("#cname").val() ;
		$('#dg_wholesale').datagrid({
			url: url
		});
	}
	</script>
