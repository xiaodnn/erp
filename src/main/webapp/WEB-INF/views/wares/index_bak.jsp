<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_wares" style="padding:5px;height:auto">
		<div id="wares_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_wares()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_wares()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_wares()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="tname" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_wares()">查找</a>
		</div>
	</div>
	<table id="dg_wares" class="easyui-datagrid" style="width:100%;height:100%;"
			 title="商品信息" toolbar="#tb_wares"
			singleSelect="true" fitColumns="true" rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="wId" width="60">商品编码</th>
				<th field="wClassid" width="80">品类编码</th>
				<th field="wType" align="right" width="70">商品类型</th>
				<th field="wGenname" align="right" width="70">通用名</th>
				<th field="wTraname" width="200">商品名</th>
				<th field="wZjm" width="50">商品助记码</th>
				<th field="wBarcode" width="60">商品条形码</th>
				<th field="wApprovalno" width="50">批准文号</th>
				<th field="wUnit" width="50">商品单位</th>
				<th field="wStandard" width="50">商品规格</th>
				<th field="wBusiness" width="50">生产企业</th>
				<th field="wPlace" width="50">生产产地</th>
				<th field="wStatus" width="50">商品状态</th>
				<th field="wCreator" width="50">创建人</th>
				<th field="wInitime" width="60">创建日期</th>
				<th field="wCostprice" width="50">成本价</th>
				<th field="wSaleprice" width="50">零售价</th>
				<th field="wSellprice" width="50">批发价</th>
			</tr>
		</thead>
	</table>
	<script>
	$(function(){
		//
		//alert('-----1111-----');
		/**
		$('#dg_wares').datagrid({
			url: '/erp/wares/all.yy'
		});
		*/
		$('#dg_wares').datagrid({
			url: '/erp/wares/all.yy'
		});
	    //alert("--1--title:"+$('#admin_tabs').tabs('exists','商品信息'));
	    /**
	    $('#wares_tool').tabs({
	    	tools:[{
	    		iconCls:'icon-add',
	    		handler:function(){
	    			alert('add')
	    		}
	    	},{
	    		iconCls:'icon-save',
	    		handler:function(){
	    			alert('save')
	    		}
	    	}]
	    });
	    */
	    /**
		 $('#tb').tabs({
		    	tools:"wares_tool"
		    });
	    */
	});
	function add_wares(){
		//$('#fm').form('submit',{url:'wares/add.yy'});
		/**
		var tab = $('#admin_tabs').tabs('getSelected');
		alert("---tab.id:"+tab.id+",len:"+tab.length);
		$('#admin_tabs').tabs('update', {
			tab:tab,
			options: {
				title:'添加商品信息',
				href:'/erp/wares/add.yy'
			}
		});
		*/
		//$('#admin_tabs').tabs('select','商品信息');
		var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
		//var index = $('#admin_tabs').tabs('getTabIndex',tab);
		//alert(index+"---wares");
		//$('#admin_tabs').tabs('select',index);
		tab.panel('refresh','/erp/wares/add.yy');
	}
	function modify_wares(){
		var row = $('#dg_wares').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
		    url = 'wares/add.yy?wid='+row.wId;
		    var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
			tab.panel('refresh',url);
			//$('#fm').form('submit',{url:url});
		}
	}
	function del_wares(){
		var row = $('#dg_wares').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var wid = row.wId;
			//$.messager.alert('Info',wid, 'info');
			$.post("/erp/wares/del_json.yy",
					{wid:wid},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "商品已删除", 'error');
							$('#dg_wares').datagrid({
								url: '/erp/wares/all.yy'
							});
						}
					}
				);
		    
		    
		}
	}
	
	function find_wares(){
		var url = '/erp/wares/find_json.yy?wTraname='+$("#tname").val() ;
		$('#dg_wares').datagrid({
			url: url
		});
	}
	</script>