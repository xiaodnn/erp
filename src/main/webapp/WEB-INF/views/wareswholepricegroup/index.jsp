<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_wareswholepricegroup" style="padding:5px;height:auto">
		<div id="wareswholepricegroup_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_wareswholepricegroup()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_wareswholepricegroup()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_wareswholepricegroup()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="s_wId" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_wareswholepricegroup()">查找</a>
		</div>
	</div>

	<table id="dg_wareswholepricegroup" class="easyui-datagrid" style="width:100%;height:100%;"
			 title="批发调价单" toolbar="#tb_wareswholepricegroup"
			singleSelect="true" fitColumns="true" rownumbers="true" pagination="true" datapagesize="5">
		<thead>
			<tr>
				<th data-options="field:'wpgId',width:40">ID</th>
				<th data-options="field:'wId',width:80">商品编码</th>
				<th data-options="field:'wTraname',width:80" formatter="formatWaresName">商品名称</th>
				<th data-options="field:'wWholeprice',width:50" >最新价</th>
				<th data-options="field:'uId',width:50" >调价ID</th>
				<th data-options="field:'uName',width:50" formatter="formatUserName">调价人</th>
				<th data-options="field:'intime',width:50" >调价时间</th>
			</tr>
		</thead>
	</table>

	<div id="dlg_wareswholepricegroup" class="easyui-dialog" title="新增库存信息" style="width:500px;height:250px;padding:10px;"
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
				<form id="ff_wareswholepricegroup" class="easyui-form" method="post" action="/erp/wareswholepricegroup/save.yy" data-options="novalidate:false">
					<input type="hidden" id="wpgId" name="wpgId" />
					<table>
						<tr>
							<td>商品编码:</td>
							<td colspan="3"><input class="easyui-combox" type="text" id="wId" name="wId" data-options="required:true,validType:{length:[0,40]}" /></td>
						</tr>
						<tr>
							<td>最新价:</td>
							<td><input class="easyui-textbox" type="text" id="wWholeprice" name="wWholeprice"/></td>
							<td>调价人:</td>
							<td><input class="easyui-textbox" type="text" id="uId" name="uId" /></td>
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
        $('#dg_wareswholepricegroup').datagrid({
            url: '/erp/wareswholepricegroup/find_json.yy',
            view: detailview,
            detailFormatter:function(index,row){
                return '<div style="padding:2px"><table class="ddv"></table></div>';
            },
            onExpandRow: function(index,row){
                var ddv = $(this).datagrid('getRowDetail',index).find('table.ddv');
                ddv.datagrid({
                    url:'/erp/wareswholepricegroupdetail/findsid_json.yy?sId='+row.sId,
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

	function add_wareswholepricegroup(){
        dialog_open();
	}
	function modify_wareswholepricegroup(){
		var row = $('#dg_wareswholepricegroup').datagrid('getSelected');
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
	function del_wareswholepricegroup(){
		var row = $('#dg_wareswholepricegroup').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var shId = row.shId;
			$.post("/erp/wareswholepricegroup/del_json.yy",
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
	
	function find_wareswholepricegroup(){
		var url = '/erp/wareswholepricegroup/find_json.yy?wId='+$("#wId").val() ;
		$('#dg_wareswholepricegroup').datagrid({
			url: url
		});
	}
    function dialog_open(){
        $('#dlg_wareswholepricegroup').dialog('open');
    }
	function dialog_close(){
        $('#dlg_wareswholepricegroup').dialog('close');
	}

    function isExistId(){
        var oCode = $('#oCode').val();
        $.post("/erp/wareswholepricegroup/checkCode_json.yy",
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
        $('#ff_wareswholepricegroup').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
//                return $(this).form();
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                $.messager.alert('Info',rj.desc, 'Info');
                if(rj.status == 1){
                    dialog_close();
                    $("#ff_wareswholepricegroup").form('clear');
                    init();
                }
            }
        });

    }
	</script>