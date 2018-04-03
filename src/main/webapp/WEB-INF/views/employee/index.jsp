<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_employee" style="padding:5px;height:auto">
		<div id="employee_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_employee()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_employee()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_employee()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="cname" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_employee()">查找</a>
		</div>
	</div>
	<table id="dg_employee" class="easyui-datagrid" style="width:100%;height:100%;"
			 title="员工信息" toolbar="#tb_employee"
			singleSelect="true" fitColumns="true" rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="eId" width="60">员工ID</th>
				<th field="eName" width="80">员工姓名</th>
				<th field="eOid" width="50">所在机构</th>
				<th field="eMobile" width="50">联系电话</th>
				<th field="eBirthday" width="50">生日</th>
				<th field="eSex" width="50">性别</th>
				<th field="eIdcard" width="50">身份证号</th>
				<th field="eState" width="50">状态</th>
				<th field="eAddress" width="60">地址</th>
				<th field="eIntime" width="50">创建日期</th>
			</tr>
		</thead>
	</table>
	<div id="dlg_employee" class="easyui-dialog" title="新增员工信息" style="width:500px;height:250px;padding:10px;"
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
		<form id="ff_employee" class="easyui-form" method="post" action="/erp/employee/save.yy" data-options="novalidate:false">
			<table>
				<tr><input type="hidden" id="eId" name="eId"/>
					<td>员工名称:</td>
					<td><input class="easyui-textbox" type="text" name="eName" data-options="required:true,validType:{length:[0,10]}"/></td>
					<td>所在机构:</td>
					<td>
						<input style="width:100px;" class="easyui-combobox" name="eOid" data-options="
							url:'/erp/organ/find_name.yy',
							method:'post',
							valueField: 'oId',
							textField: 'oName',
							panelHeight:'auto'"/>
					</td>
				</tr>
				<tr>
					<td>联系电话:</td>
					<td><input class="easyui-textbox" type="text" name="eMobile" data-options="required:false"/></td>
					<td>生日:</td>
					<td><input class="easyui-datebox" name="eBirthday" style="width:100px" /></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td><select style="width:100px;" class="easyui-combobox" name="eSex" data-options="panelHeight:'auto'"><option value="男">男</option><option value="女">女</option></select></td>
					<td>身份证号:</td>
					<td><input class="easyui-textbox" type="text" name="eIdcard" data-options="required:false,validType:'number'"/></td>
				</tr>
				<tr>
					<td>状态:</td>
					<td><select style="width:100px;" class="easyui-combobox" name="eState" data-options="panelHeight:'auto'"><option value="1">有效</option><option value="0">失效</option></select></td>
					<td>地址:</td>
					<td><input class="easyui-textbox" type="text" name="eAddress" data-options="required:false"></input></td>
				</tr>

			</table>
		</form>
	</div>
	<script>
	$(function(){
        init();
	});
    function init(){
        $('#dg_employee').datagrid({
            url: '/erp/employee/find_json.yy'
        });
    }
    function dialog_open(){
        $('#dlg_employee').dialog('open');
    }
    function dialog_close(){
        $('#dlg_employee').dialog('close');
    }
	function add_employee(){
        dialog_open();
	}
	function modify_employee(){
		var row = $('#dg_employee').datagrid('getSelected');
        if (row== null){
            $.messager.alert('Info', "请选择需要更新的行", 'error');
            return ;
        }else{
            dialog_open();
            $("#eId").val(row.oId);
            $("#eName").textbox('setValue',row.eName);
            $("#eOid").combobox('setValue',row.eOid);
            $("#eMobile").textbox('setValue',row.eMobile);
            $("#eBirthday").textbox('setValue',row.eBirthday);
            $("#eSex").textbox('setValue',row.eSex);
            $("#eIdcard").textbox('setValue',row.eIdcard);
            $("#eState").combobox('setValue',row.eState);
            $("#eAddress").textbox('setValue',row.eAddress);
        }
	}
	function del_employee(){
		var row = $('#dg_employee').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var eid = row.eId;
			$.post("/erp/employee/del_json.yy",
					{eid:eid},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "员工已删除", 'error');
                            init();
						}
					}
				);
		}
	}
	
	function find_employee(){
		var url = '/erp/employee/find_json.yy?cname='+$("#cname").val() ;
		$('#dg_employee').datagrid({
			url: url
		});
	}

    function submit_form(){
        //第二种
        $('#ff_employee').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
//                return $(this).form();
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                if(rj.status == 1){
                    dialog_close();
                    $("#ff_employee").form('clear');
                    init();
                }
            }
        });
    }

	</script>