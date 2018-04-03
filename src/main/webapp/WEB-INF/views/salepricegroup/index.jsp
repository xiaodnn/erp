<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_salepricegroup" style="padding:5px;height:auto">
		<div id="salepricegroup_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_salepricegroup()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_salepricegroup()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_salepricegroup()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="s_wId" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_salepricegroup()">查找</a>
		</div>
	</div>

	<table id="dg_salepricegroup" class="easyui-datagrid" style="width:100%;height:100%;"
			 title="零售价格组" toolbar="#tb_salepricegroup"
			singleSelect="true" fitColumns="true" rownumbers="true" pagination="true" datapagesize="5">
		<thead>
			<tr>
				<th data-options="field:'spgId',width:20">价格组编码</th>
				<th data-options="field:'spgName',width:40">价格组名称</th>
			</tr>
		</thead>
	</table>

	<div id="dlg_salepricegroup" class="easyui-dialog" title="新增零售价格组信息" style="width:500px;height:250px;padding:10px;"
		 data-options="closed:true,
						buttons: [{
							text:'保存',
							iconCls:'icon-ok',
							handler:function(){
								submit_form();
							}
						},{
							text:'取消',
							iconCls:'icon-cancel',
							handler:function(){
								dialog_close();
							}
						}]">
				<form id="ff_salepricegroup" class="easyui-form" method="post" action="/erp/salepricegroup/save.yy" data-options="novalidate:false">
					<input type="hidden" id="spgId" name="spgId" />
					<table>
						<tr>
							<td>零售价格组名称:</td>
							<td><input class="easyui-textbox" type="text" id="spgName" name="spgName" data-options="required:true" /></td>
						</tr>
					</table>
				</form>
	</div>

	<script>
	$(function(){
        init();
    });

	function init(){
        $('#dg_salepricegroup').datagrid({
            url: '/erp/salepricegroup/find_json.yy'
        });
	}

	function add_salepricegroup(){
        dialog_open();
	}
	function modify_salepricegroup(){
		var row = $('#dg_salepricegroup').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
            dialog_open();
			$("#spgId").val(row.spgId);
            $("#spgName").textbox('setValue',row.spgName);
		}
	}
	function del_salepricegroup(){
		var row = $('#dg_salepricegroup').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var spgId = row.spgId;
			$.post("/erp/salepricegroup/del_json.yy",
					{id:spgId},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "零售价格组信息已删除", 'error');
                            init();
						}
					}
				);
		}
	}
	
	function find_salepricegroup(){
		var url = '/erp/salepricegroup/find_json.yy?wId='+$("#wId").val() ;
		$('#dg_salepricegroup').datagrid({
			url: url
		});
	}
    function dialog_open(){
        $('#dlg_salepricegroup').dialog('open');
    }
	function dialog_close(){
        $('#dlg_salepricegroup').dialog('close');
	}

    function isExistId(){
        var oCode = $('#oCode').val();
        $.post("/erp/salepricegroup/checkCode_json.yy",
            {oCode:oCode},
            function(data){
                if(data == 1){
                    $.messager.alert('Info', "零售价格组编号已存在", 'error');
                    $('#oCode').textbox('textbox').prop("isValid ",false);
                    $('#oCode').textbox('textbox').prop("invalidMessage ","零售价格组编号已存在");
                }
            }
        );
    }

    function submit_form(){
        //第二种
        $('#ff_salepricegroup').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
//                return $(this).form();
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                $.messager.alert('Info',rj.desc, 'Info');
                if(rj.status == 1){
                    dialog_close();
                    $("#ff_salepricegroup").form('clear');
                    init();
                }
            }
        });

    }
	</script>