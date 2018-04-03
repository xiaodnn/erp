<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_warehousing" style="padding:5px;height:auto">
		<div id="warehousing_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_warehousing()" title="添加单据"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_warehousing()" title="修改单据"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_warehousing()" title="删除单据"></a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="cname" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_warehousing()">查找</a>
		</div>
	</div>
	<table id="dg_warehousing" class="easyui-datagrid" style="width:100%;height:auto;"
			 toolbar="#tb_warehousing"
			singleSelect="true" fitColumns="true" rownumbers="true" pagination="true">
		<thead>
			<tr align="center">
				<th field="whId" width="80">入库单号</th>
				<th field="whInitime" width="80" formatter="formatDatebox">制单时间</th>
				<th field="whOrgan" align="center" width="70">入库机构</th>
				<th field="whRid" align="center" width="70">入库仓库</th>
				<th field="whCreator" width="50">经手人</th>
				<th field="whCid" width="150">供应商</th>
				<th field="stateName" width="40">审核状态</th>
				<th field="whMemo" width="150">备注</th>
				<th field="whChtime" width="50" formatter="formatDatebox">审核时间</th>
			</tr>
		</thead>
	</table>
	<script>
	$(function(){
		$('#dg_warehousing').datagrid({
			url: '/erp/warehousing/dg_find.yy'
		});
	});
	
	function add_warehousing(){
		var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
		tab.panel('refresh','/erp/warehousing/add.yy');
	}
	function modify_warehousing(){
		var row = $('#dg_warehousing').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
		    url = '/erp/warehousing/add.yy?whId='+row.whId;
		    var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
			tab.panel('refresh',url);
		}
	}
	function del_warehousing(){
		var row = $('#dg_warehousing').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var cid = row.cId;
			$.post("/erp/warehousing/del_json.yy",
					{cid:wid},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "入库已删除", 'error');
							$('#dg_warehousing').datagrid({
								url: '/erp/warehousing/dg_find.yy'
							});
						}
					}
				);
		}
	}
	
	function find_warehousing(){
		var url = '/erp/warehousing/dg_find.yy?cname='+$("#cname").val() ;
		$('#dg_warehousing').datagrid({
			url: url
		});
	}
	</script>