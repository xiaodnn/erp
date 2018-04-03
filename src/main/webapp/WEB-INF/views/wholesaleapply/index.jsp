<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_wholesaleapply" style="padding:5px;height:auto">
		<div id="wholesaleapply_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_wholesaleapply()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_wholesaleapply()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_wholesaleapply()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="cname" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_wholesaleapply()">查找</a>
		</div>
	</div>
	<table id="dg_wholesaleapply" class="easyui-datagrid" style="width:100%;height:auto;"
			 title="批发申请信息" toolbar="#tb_wholesaleapply"
			singleSelect="true" fitColumns="true" rownumbers="true" pagination="true">
		<thead>
			<tr align="center">
				<th field="waId" width="80">批发单号</th>
				<th field="waDate" width="80" formatter="formatDatebox">制单时间</th>
				<th field="shId" align="center" width="70">出库仓库</th>
				<th field="waCreator" width="50">制单人</th>
				<th field="cbId" align="center" width="70">客户名称</th>
				<th field="cbStorehouse" width="150">客户收货地址</th>
				<th field="waReceiveWay" width="150">提货方式</th>
				<th field="stateName" width="40">审核状态</th>
				<th field="waRemark" width="150">备注</th>
				<th field="intime" width="50" formatter="formatDatebox">制单时间</th>
			</tr>
		</thead>
	</table>
	<script>
	$(function(){
		$('#dg_wholesaleapply').datagrid({
			url: '/erp/wholesaleapply/dg_find.yy'
		});
	});
	
	function add_wholesaleapply(){
		var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
		tab.panel('refresh','/erp/wholesaleapply/add.yy');
	}
	function modify_wholesaleapply(){
		var row = $('#dg_wholesaleapply').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
		    url = '/erp/wholesaleapply/add.yy?waId='+row.waId;
		    var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
			tab.panel('refresh',url);
		}
	}
	function del_wholesaleapply(){
		var row = $('#dg_wholesaleapply').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var cid = row.cId;
			$.post("/erp/wholesaleapply/del_json.yy",
					{cid:wid},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "入库已删除", 'error');
							$('#dg_wholesaleapply').datagrid({
								url: '/erp/wholesaleapply/dg_find.yy'
							});
						}
					}
				);
		}
	}
	
	function find_wholesaleapply(){
		var url = '/erp/wholesaleapply/dg_find.yy?cname='+$("#cname").val() ;
		$('#dg_wholesaleapply').datagrid({
			url: url
		});
	}
	</script>
