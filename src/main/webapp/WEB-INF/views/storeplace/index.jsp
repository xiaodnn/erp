<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_storeplace" style="padding:5px;height:auto">
		<div id="storeplace_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_storeplace()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_storeplace()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_storeplace()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="s_spName" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_storeplace()">查找</a>
		</div>
	</div>

	<table id="dg_storeplace" class="easyui-datagrid" style="width:100%;height:auto;"
			 title="货位信息" toolbar="#tb_storeplace"
			singleSelect="true" fitColumns="true" rownumbers="true" pagination="true" datapagesize="5">
		<thead>
			<tr>
				<th data-options="field:'spId',width:40">货位ID</th>
				<th data-options="field:'spCode',width:60">货位编码</th>
				<th data-options="field:'spName',width:80">货位名称</th>
				<th data-options="field:'szId',width:50">库区ID</th>
			</tr>
		</thead>
	</table>

	<div id="dlg_storeplace" class="easyui-dialog" title="新增货位信息" style="width:500px;height:250px;padding:10px;"
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
				<form id="ff_storeplace" class="easyui-form" method="post" action="/erp/storeplace/save.yy" data-options="novalidate:false">
					<input type="hidden" id="spId" name="spId" />
					<table>
						<tr>
							<td>货位编码:</td>
							<td><input class="easyui-textbox" type="text" id="spCode" name="spCode" data-options="events:{blur:isExistId},required:true" /></td>
							<td>货位名称:</td>
							<td><input class="easyui-textbox" type="text" id="spName" name="spName" data-options="required:true,validType:{length:[0,20]}" /></td>
						</tr>
						<tr>
							<td>库区ID:</td>
							<td><input class="easyui-textbox" type="text" id="szId" name="szId" data-options="required:false,validType:'number'" /></td>
						</tr>
					</table>
				</form>
	</div>

	<script>
	$(function(){
        init();
    });

	function init(){
        $('#dg_storeplace').datagrid({
            url: '/erp/storeplace/find_json.yy'
        });
	}

	function add_storeplace(){
        dialog_open();
	}
	function modify_storeplace(){
		var row = $('#dg_storeplace').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
            dialog_open();
			$("#spId").val(row.spId);
            $("#spCode").textbox('setValue',row.spCode);
            $("#spName").textbox('setValue',row.spName);
            $("#szId").textbox('setValue',row.szId);
		}
	}
	function del_storeplace(){
		var row = $('#dg_storeplace').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var spId = row.spId;
			$.post("/erp/storeplace/del_json.yy",
					{spId:spId},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "货位已删除", 'error');
                            init();
						}
					}
				);
		}
	}
	
	function find_storeplace(){
		var url = '/erp/storeplace/find_json.yy?spName='+$("#spName").val() ;
		$('#dg_storeplace').datagrid({
			url: url
		});
	}
    function dialog_open(){
        $('#dlg_storeplace').dialog('open');
    }
	function dialog_close(){
        $('#dlg_storeplace').dialog('close');
	}

    function isExistId(){
        var spCode = $('#spCode').val();
        $.post("/erp/storeplace/checkCode_json.yy",
            {spCode:spCode},
            function(data){
                if(data == 1){
                    $.messager.alert('Info', "货位编号已存在", 'error');
                    $('#spCode').textbox('textbox').prop("isValid ",false);
                    $('#spCode').textbox('textbox').prop("invalidMessage ","货位编号已存在");
                }
            }
        );
    }

    function submit_form(){
        //第二种
        $('#ff_storeplace').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
//                return $(this).form();
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                $.messager.alert('Info',rj.desc, 'Info');
                if(rj.status == 1){
                    dialog_close();
                    $("#ff_storeplace").form('clear');
                    init();
                }
            }
        });

    }
	</script>