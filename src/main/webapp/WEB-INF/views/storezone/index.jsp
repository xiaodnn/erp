<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_storezone" style="padding:5px;height:auto">
		<div id="storezone_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_storezone()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_storezone()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_storezone()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="s_szName" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_storezone()">查找</a>
		</div>
	</div>

	<table id="dg_storezone" class="easyui-datagrid" style="width:100%;height:auto;"
			 title="库区信息" toolbar="#tb_storezone"
			singleSelect="true" fitColumns="true" rownumbers="true" pagination="true" datapagesize="5">
		<thead>
			<tr>
				<th data-options="field:'szId',width:40">库区ID</th>
				<th data-options="field:'szCode',width:60">库区编码</th>
				<th data-options="field:'szName',width:80">库区名称</th>
				<th data-options="field:'shId',width:50">仓库ID</th>
				<th data-options="field:'szCreator',width:50">创建人</th>
				<th data-options="field:'szIntime',width:50,formatter:formatDatebox" >创建日期</th>
			</tr>
		</thead>
	</table>

	<div id="dlg_storezone" class="easyui-dialog" title="新增库区信息" style="width:500px;height:250px;padding:10px;"
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
				<form id="ff_storezone" class="easyui-form" method="post" action="/erp/storezone/save.yy" data-options="novalidate:false">
					<input type="hidden" id="szId" name="szId" />
					<table>
						<tr>
							<td>库区编码:</td>
							<td><input class="easyui-textbox" type="text" id="szCode" name="szCode" data-options="events:{blur:isExistId},required:true" /></td>
							<td>库区名称:</td>
							<td><input class="easyui-textbox" type="text" id="szName" name="szName" data-options="required:true,validType:{length:[0,20]}" /></td>
						</tr>
						<tr>
							<td>仓库ID:</td>
							<td><input class="easyui-textbox" type="text" id="shId" name="shId" data-options="required:false,validType:'number'" /></td>
							<td>创建人:</td>
							<td><input class="easyui-textbox" type="text" id="szCreator" name="szCreator"/></td>
						</tr>
					</table>
				</form>
	</div>

	<script>
	$(function(){
        init();
    });

	function init(){
        $('#dg_storezone').datagrid({
            url: '/erp/storezone/find_json.yy'
        });
	}

	function add_storezone(){
        dialog_open();
	}
	function modify_storezone(){
		var row = $('#dg_storezone').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
            dialog_open();
			$("#szId").val(row.szId);
            $("#szCode").textbox('setValue',row.szCode);
            $("#szName").textbox('setValue',row.szName);
            $("#shId").textbox('setValue',row.shId);
            $("#szCreator").textbox('setValue',row.szCreator);
		}
	}
	function del_storezone(){
		var row = $('#dg_storezone').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var szId = row.szId;
			$.post("/erp/storezone/del_json.yy",
					{szId:szId},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "库区已删除", 'error');
                            init();
						}
					}
				);
		}
	}
	
	function find_storezone(){
		var url = '/erp/storezone/find_json.yy?szName='+$("#szName").val() ;
		$('#dg_storezone').datagrid({
			url: url
		});
	}
    function dialog_open(){
        $('#dlg_storezone').dialog('open');
    }
	function dialog_close(){
        $('#dlg_storezone').dialog('close');
	}

    function isExistId(){
        var szCode = $('#szCode').val();
        $.post("/erp/storezone/checkCode_json.yy",
            {szCode:szCode},
            function(data){
                if(data == 1){
                    $.messager.alert('Info', "库区编号已存在", 'error');
                    $('#szCode').textbox('textbox').prop("isValid ",false);
                    $('#szCode').textbox('textbox').prop("invalidMessage ","库区编号已存在");
                }
            }
        );
    }

    function submit_form(){
        //第二种
        $('#ff_storezone').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
//                return $(this).form();
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                $.messager.alert('Info',rj.desc, 'Info');
                if(rj.status == 1){
                    dialog_close();
                    $("#ff_storezone").form('clear');
                    init();
                }
            }
        });

    }
	</script>