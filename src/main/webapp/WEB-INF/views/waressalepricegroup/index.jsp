<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_waressalepricegroup" style="padding:5px;height:auto">
		<div id="waressalepricegroup_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_waressalepricegroup()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_waressalepricegroup()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_waressalepricegroup()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="s_wId" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_waressalepricegroup()">查找</a>
		</div>
	</div>

	<table id="dg_waressalepricegroup" class="easyui-datagrid" style="width:100%;height:100%;"
			 title="零售调价单" toolbar="#tb_waressalepricegroup"
			singleSelect="true" fitColumns="true" rownumbers="true" pagination="true" datapagesize="5">
		<thead>
			<tr>
				<th data-options="field:'spgId',width:40">零售价格组ID</th>
				<th data-options="field:'wId',width:60">商品ID</th>
				<th data-options="field:'wTraname',width:80" formatter="formatWaresName">商品名称</th>
				<th data-options="field:'wSaleprice',width:60">零售价</th>
				<th data-options="field:'wVipprice',width:50">会员价</th>
				<th data-options="field:'wPromoprice',width:50" >促销价</th>
				<th data-options="field:'wVippromoprice',width:50" >会员促销价</th>
				<th data-options="field:'wStatus',width:50" >状态</th>
				<th data-options="field:'wBegindate',width:50" >开始日期</th>
				<th data-options="field:'wEnddate',width:50" >结束日期</th>
				<th data-options="field:'uId',width:50" >用户ID</th>
				<th data-options="field:'uName',width:50" formatter="formatUserName">调价人</th>
				<th data-options="field:'intime',width:50" >创建时间</th>
			</tr>
		</thead>
	</table>

	<div id="dlg_waressalepricegroup" class="easyui-dialog" title="新增库存信息" style="width:500px;height:250px;padding:10px;"
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
				<form id="ff_waressalepricegroup" class="easyui-form" method="post" action="/erp/waressalepricegroup/save.yy" data-options="novalidate:false">
					<input type="hidden" id="spgId" name="spgId" />
					<table>
						<tr>
							<td>商品ID:</td>
							<td><input class="easyui-combox" type="text" id="wId" name="wId" data-options="events:{blur:isExistId},required:true" /></td>
							<td>零售价:</td>
							<td><input class="easyui-textbox" type="text" id="wSaleprice" name="wSaleprice" data-options="required:true,validType:{length:[0,20]}" /></td>
						</tr>
						<tr>
							<td>会员价:</td>
							<td><input class="easyui-textbox" type="text" id="wVipprice" name="wVipprice"/></td>
							<td>促销价:</td>
							<td><input class="easyui-textbox" type="text" id="wPromoprice" name=wPromoprice /></td>
						</tr>
						<tr>
							<td>会员促销价:</td>
							<td><input class="easyui-textbox" type="text" id="wVippromoprice" name="wVippromoprice"/></td>
							<td>状态:</td>
							<td><input class="easyui-textbox" type="text" id="wStatus" name="wStatus" /></td>
						</tr>
						<tr>
							<td>开始日期:</td>
							<td><input class="easyui-datebox" type="text" id="wBegindate" name="wBegindate"/></td>
							<td>结束日期:</td>
							<td><input class="easyui-datebox" type="text" id="wEnddate" name="wEnddate" /></td>
						</tr>
						<tr>
							<td>用户ID:</td>
							<td><input class="easyui-textbox" type="text" id="uId" name="uId"/></td>
							<td>创建时间:</td>
							<td><input class="easyui-datebox" type="text" id="intime" name="intime" /></td>
						</tr>
					</table>
				</form>
	</div>

	<script>
	$(function(){
		initWid(); 
        init();
    });
	function initWid(){
		$("#wId").combobox({
            url: '/erp/wares/find_json.yy',
            method: 'post',
            valueField: 'wId',
            textField: 'wTraname'
		});
		$("#uId").combobox({
            url: '/erp/user/find_name.yy',
            method: 'post',
            valueField: 'uId',
            textField: 'uName'
		});
	}
	//格式化部门名称
	function formatWaresName(val,row,index){
		//alert(row.waresBase.wTraname);
	    return row.waresBase.wTraname;
	}
	
	function formatUserName(val,row,index){
		//alert(row.user.uName);
	    return row.user.uName;
	}
	function init(){
        $('#dg_waressalepricegroup').datagrid({
            url: '/erp/waressalepricegroup/find_json.yy',
            view: detailview,
            detailFormatter:function(index,row){
                return '<div style="padding:2px"><table class="ddv"></table></div>';
            },
            onExpandRow: function(index,row){
                var ddv = $(this).datagrid('getRowDetail',index).find('table.ddv');
                ddv.datagrid({
                    url:'/erp/waressalepricegroupdetail/findsid_json.yy?sId='+row.sId,
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

	function add_waressalepricegroup(){
        dialog_open();
	}
	function modify_waressalepricegroup(){
		var row = $('#dg_waressalepricegroup').datagrid('getSelected');
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
	function del_waressalepricegroup(){
		var row = $('#dg_waressalepricegroup').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var shId = row.shId;
			$.post("/erp/waressalepricegroup/del_json.yy",
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
	
	function find_waressalepricegroup(){
		var url = '/erp/waressalepricegroup/find_json.yy?wId='+$("#wId").val() ;
		$('#dg_waressalepricegroup').datagrid({
			url: url
		});
	}
    function dialog_open(){
        $('#dlg_waressalepricegroup').dialog('open');
    }
	function dialog_close(){
        $('#dlg_waressalepricegroup').dialog('close');
	}

    function isExistId(){
        var oCode = $('#oCode').val();
        $.post("/erp/waressalepricegroup/checkCode_json.yy",
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
        $('#ff_waressalepricegroup').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
//                return $(this).form();
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                $.messager.alert('Info',rj.desc, 'Info');
                if(rj.status == 1){
                    dialog_close();
                    $("#ff_waressalepricegroup").form('clear');
                    init();
                }
            }
        });

    }
	</script>