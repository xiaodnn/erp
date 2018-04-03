<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_company" style="padding:5px;height:auto">
		<div id="company_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_company()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_company()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_company()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="cname" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_company()">查找</a>
		</div>
	</div>
	<table id="dg_company" class="easyui-datagrid" style="width:100%;height:100%;"
			 title="供应商信息" toolbar="#tb_company"
			singleSelect="true" fitColumns="true" rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="cId" width="60">供应商编码</th>
				<th field="cName" width="80">供应商名称</th>
				<th field="cType" align="right" width="70">企业类型</th>
				<th field="cPaytype" align="right" width="70">结款类型</th>
				<th field="cManager" width="200">企业法人</th>
				<th field="cZone" width="50">企业地区</th>
				<th field="cAddress" width="60">企业地址</th>
				<th field="cOrderName" width="50">联系人</th>
				<th field="cOrderTel" width="50">联系电话</th>
				<th field="cOrderFax" width="50">联系传真</th>
				<th field="cOrderMobile" width="50">联系手机</th>
				<th field="cOrderEmail" width="50">企业邮箱</th>
				<th field="cOrderUrl" width="50">企业网址</th>
				<th field="cStatus" width="50">状态</th>
				<th field="cBuyer" width="60">采购员</th>
				<th field="cBankId" width="50">开户行账号</th>
				<th field="cBankName" width="50">开户行名称</th>
				<th field="cInitime" width="50">创建日期</th>
			</tr>
		</thead>
	</table>
	<script>
	$(function(){
		$('#dg_company').datagrid({
			url: '/erp/company/find_json.yy'
		});
	});
	
	function add_company(){
		//$('#admin_tabs').tabs('select','供应商信息');
		var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
		//var index = $('#admin_tabs').tabs('getTabIndex',tab);
		//alert(index+"---company");
		//$('#admin_tabs').tabs('select',index);
		tab.panel('refresh','/erp/company/add.yy');
	}
	function modify_company(){
		var row = $('#dg_company').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
		    url = 'company/add.yy?cid='+row.cId;
		    var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
			tab.panel('refresh',url);
		}
	}
	function del_company(){
		var row = $('#dg_company').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var cid = row.cId;
			$.post("/erp/company/del_json.yy",
					{cid:wid},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "供应商已删除", 'error');
							$('#dg_company').datagrid({
								url: '/erp/company/all.yy'
							});
						}
					}
				);
		}
	}
	
	function find_company(){
		var url = '/erp/company/find_json.yy?cname='+$("#cname").val() ;
		$('#dg_company').datagrid({
			url: url
		});
	}
	</script>