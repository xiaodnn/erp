<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_storedetail" style="padding:5px;height:auto">
		<div id="storedetail_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_storedetail()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_storedetail()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_storedetail()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="s_shName" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_storedetail()">查找</a>
		</div>
	</div>

	<table id="dg_storedetail" class="easyui-datagrid" style="width:100%;height:100%;"
			 title="仓库信息" toolbar="#tb_storedetail"
			singleSelect="true" fitColumns="true" rownumbers="true" pagination="true" datapagesize="5">
		<thead>
			<tr>
				<th data-options="field:'shId',width:40">仓库ID</th>
				<th data-options="field:'shCode',width:60">仓库编码</th>
				<th data-options="field:'shName',width:80">仓库名称</th>
				<th data-options="field:'oId',width:60">机构ID</th>
				<th data-options="field:'shCreator',width:50">创建人</th>
				<th data-options="field:'shIntime',width:50,formatter:formatDatebox" >创建日期</th>
			</tr>
		</thead>
	</table>

	<div id="dlg_storedetail" class="easyui-dialog" title="新增仓库信息" style="width:500px;height:250px;padding:10px;"
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
				<form id="ff_storedetail" class="easyui-form" method="post" action="/erp/storedetail/save.yy" data-options="novalidate:false">
					<input type="hidden" id="shId" name="shId" />
					<table>
						<tr>
							<td>仓库编码:</td>
							<td><input class="easyui-textbox" type="text" id="shCode" name="shCode" data-options="events:{blur:isExistId},required:true" /></td>
							<td>仓库名称:</td>
							<td><input class="easyui-textbox" type="text" id="shName" name="shName" data-options="required:true,validType:{length:[0,20]}" /></td>
						</tr>
						<tr>
							<td>创建人:</td>
							<td><input class="easyui-textbox" type="text" id="shCreator" name="shCreator"/></td>
							<td>机构ID:</td>
							<td><input class="easyui-textbox" type="text" id="oId" name="oId" /></td>
						</tr>
					</table>
				</form>
	</div>

	<script>
	$(function(){
        init();
    });

	function init(){
        $('#dg_storedetail').datagrid({
            url: '/erp/storedetail/find_json.yy'
        });
	}

	function add_storedetail(){
        dialog_open();
	}
	function modify_storedetail(){
		var row = $('#dg_storedetail').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
            dialog_open();
			$("#shId").val(row.shId);
            $("#shCode").textbox('setValue',row.shCode);
            $("#shName").textbox('setValue',row.shName);
            $("#shCreator").textbox('setValue',row.shCreator);
            $("#oId").textbox('setValue',row.oId);

		}
	}
	function del_storedetail(){
		var row = $('#dg_storedetail').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var shId = row.shId;
			$.post("/erp/storedetail/del_json.yy",
					{shId:shId},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "仓库已删除", 'error');
                            init();
						}
					}
				);
		}
	}
	
	function find_storedetail(){
		var url = '/erp/storedetail/find_json.yy?shName='+$("#shName").val() ;
		$('#dg_storedetail').datagrid({
			url: url
		});
	}
    function dialog_open(){
        $('#dlg_storedetail').dialog('open');
    }
	function dialog_close(){
        $('#dlg_storedetail').dialog('close');
	}

    function isExistId(){
        var shCode = $('#shCode').val();
        $.post("/erp/storedetail/checkCode_json.yy",
            {shCode:shCode},
            function(data){
                if(data == 1){
                    $.messager.alert('Info', "仓库编号已存在", 'error');
                    $('#shCode').textbox('textbox').prop("isValid ",false);
                    $('#shCode').textbox('textbox').prop("invalidMessage ","仓库编号已存在");
                }
            }
        );
    }

    function submit_form(){
        //第二种
        $('#ff_storedetail').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
//                return $(this).form();
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                $.messager.alert('Info',rj.desc, 'Info');
                if(rj.status == 1){
                    dialog_close();
                    $("#ff_storedetail").form('clear');
                    init();
                }
            }
        });

    }
	</script>