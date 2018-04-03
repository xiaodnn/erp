<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_store" style="padding:5px;height:auto">
		<div id="store_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_store()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_store()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_store()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="s_wId" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_store()">查找</a>
		</div>
	</div>

	<table id="dg_store" class="easyui-datagrid" style="width:100%;height:100%;"
			 title="仓库信息" toolbar="#tb_store"
			singleSelect="true" fitColumns="true" rownumbers="true" pagination="true" datapagesize="5">
		<thead>
			<tr>
				<th data-options="field:'sId',width:40">库存ID</th>
				<th data-options="field:'oCode',width:60">机构编码</th>
				<th data-options="field:'wId',width:80">商品编码</th>
				<th data-options="field:'amountSum',width:60">库存总数量</th>
				<th data-options="field:'pAmountSum',width:50">待出库总数量</th>
				<th data-options="field:'costPrice',width:50" >最新进价</th>
				<th data-options="field:'cId',width:50" >最新供应商</th>
			</tr>
		</thead>
	</table>

	<div id="dlg_store" class="easyui-dialog" title="新增库存信息" style="width:500px;height:250px;padding:10px;"
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
				<form id="ff_store" class="easyui-form" method="post" action="/erp/store/save.yy" data-options="novalidate:false">
					<input type="hidden" id="shId" name="shId" />
					<table>
						<tr>
							<td>机构编码:</td>
							<td><input class="easyui-textbox" type="text" id="oCode" name="oCode" data-options="events:{blur:isExistId},required:true" /></td>
							<td>商品编码:</td>
							<td><input class="easyui-textbox" type="text" id="wId" name="wId" data-options="required:true,validType:{length:[0,20]}" /></td>
						</tr>
						<tr>
							<td>库存总数量:</td>
							<td><input class="easyui-textbox" type="text" id="amountSum" name="amountSum"/></td>
							<td>待出库总数量:</td>
							<td><input class="easyui-textbox" type="text" id="pAmountSum" name="pAmountSum" /></td>
						</tr>
						<tr>
							<td>最新进价:</td>
							<td><input class="easyui-textbox" type="text" id="costPrice" name="costPrice"/></td>
							<td>最新供应商:</td>
							<td><input class="easyui-textbox" type="text" id="cId" name="cId" /></td>
						</tr>
					</table>
				</form>
	</div>

	<script>
	$(function(){
        init();
    });

	function init(){
        $('#dg_store').datagrid({
            url: '/erp/store/find_json.yy',
            view: detailview,
            detailFormatter:function(index,row){
                return '<div style="padding:2px"><table class="ddv"></table></div>';
            },
            onExpandRow: function(index,row){
                var ddv = $(this).datagrid('getRowDetail',index).find('table.ddv');
                ddv.datagrid({
                    url:'/erp/storedetail/findsid_json.yy?sId='+row.sId,
                    fitColumns:true,
                    singleSelect:true,
                    rownumbers:true,
                    loadMsg:'',
                    height:'auto',
                    columns:[[
                        {field:'sdId',title:'批次号',width:50},
                        {field:'oCode',title:'机构编码',width:80},
                        {field:'shCode',title:'仓库编码',width:80},
                        {field:'wId',title:'商品编码',width:100},
                        {field:'batchNo',title:'批号',width:100},
                        {field:'spCode',title:'货位号',width:100},
                        {field:'produceDate',title:'生产日期',width:100,formatter:formatDatebox},
                        {field:'validDate',title:'有效期',width:100,formatter:formatDatebox},
                        {field:'amount',title:'库存数量',width:80,align:'right'},
                        {field:'pAmount',title:'待出库数量',width:100,align:'right'}
                    ]],
                    onResize:function(){
                        $('#dg').datagrid('fixDetailRowHeight',index);
                    },
                    onLoadSuccess:function(){
                        setTimeout(function(){
                            $('#dg').datagrid('fixDetailRowHeight',index);
                        },0);
                    }
                });
                $('#dg').datagrid('fixDetailRowHeight',index);
            }
        });
	}

	function add_store(){
        dialog_open();
	}
	function modify_store(){
		var row = $('#dg_store').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
            dialog_open();
			$("#shId").val(row.shId);
            $("#oCode").textbox('setValue',row.oCode);
            $("#wId").textbox('setValue',row.wId);
            $("#amountSum").textbox('setValue',row.amountSum);
            $("#pAmountSum").textbox('setValue',row.pAmountSum);
            $("#costPrice").textbox('setValue',row.costPrice);
            $("#cId").textbox('setValue',row.cId);
		}
	}
	function del_store(){
		var row = $('#dg_store').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var shId = row.shId;
			$.post("/erp/store/del_json.yy",
					{shId:shId},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "库存已删除", 'error');
                            init();
						}
					}
				);
		}
	}
	
	function find_store(){
		var url = '/erp/store/find_json.yy?wId='+$("#wId").val() ;
		$('#dg_store').datagrid({
			url: url
		});
	}
    function dialog_open(){
        $('#dlg_store').dialog('open');
    }
	function dialog_close(){
        $('#dlg_store').dialog('close');
	}

    function isExistId(){
        var oCode = $('#oCode').val();
        $.post("/erp/store/checkCode_json.yy",
            {oCode:oCode},
            function(data){
                if(data == 1){
                    $.messager.alert('Info', "库存编号已存在", 'error');
                    $('#oCode').textbox('textbox').prop("isValid ",false);
                    $('#oCode').textbox('textbox').prop("invalidMessage ","库存编号已存在");
                }
            }
        );
    }

    function submit_form(){
        //第二种
        $('#ff_store').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
//                return $(this).form();
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                $.messager.alert('Info',rj.desc, 'Info');
                if(rj.status == 1){
                    dialog_close();
                    $("#ff_store").form('clear');
                    init();
                }
            }
        });

    }
	</script>