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
	<table id="dg_company" class="easyui-datagrid" style="width:100%;height:auto;"
			 title="供应商信息" toolbar="#tb_company" data-options="singleSelect:true,fitColumns:true,rownumbers:true,pagination:true">
		<thead>
			<tr>
				<th field="cId" width="60">供应商编码</th>
				<th field="cName" width="150">供应商名称</th>
				<th field="cType" align="right" width="70">企业类型</th>
				<th field="cPaytype" align="right" width="60">结款类型</th>
				<th field="cManager" width="50">企业法人</th>
				<th field="cZone" width="50">企业地区</th>
				<th field="cAddress" width="150">企业地址</th>
				<th field="cOrderName" width="50">联系人</th>
				<th field="cOrderTel" width="100">联系电话</th>
				<th field="cOrderFax" width="100">联系传真</th>
				<th field="cOrderMobile" width="100">联系手机</th>
				<th field="cOrderEmail" width="100">企业邮箱</th>
				<th field="cOrderUrl" width="100">企业网址</th>
				<th field="cStatus" width="40">状态</th>
				<th field="cBuyer" width="50">采购员</th>
				<th field="cBankId" width="50">开户行账号</th>
				<th field="cBankName" width="50">开户行名称</th>
				<th field="cInitime" width="70" formatter="formatDatebox">创建日期</th>
			</tr>
		</thead>
	</table>
	<div id="dlg_company" class="easyui-dialog" title="新增供应商信息" style="width:500px;height:380px;padding:10px;"
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
		<form id="ff_company" class="easyui-form" method="post" action="/erp/company/save.yy" data-options="novalidate:false">
			<table>
				<tr>
					<td>供应商编码:</td>
					<td><input class="easyui-textbox" type="text" id="cId" name="cId" data-options="events:{blur:isExistId},required:true" /></td>
					<td>供应商名称:</td>
					<td><input class="easyui-textbox" type="text" name="cName" data-options="required:true,validType:{length:[0,20]}"/></td>
				</tr>
				<tr>
					<td>企业类型:</td>
					<td>
						<select style="width:100px;" class="easyui-combobox" name="cType" data-options="panelHeight:'auto'">
							<option value="manage">经营</option>
							<option value="manufacture">生产</option>
						</select>
					</td>
					<td>结款类型:</td>
					<td>
						<select style="width:100px;" class="easyui-combobox" name="cPaytype" data-options="panelHeight:'auto'"><option value="cash">现金</option><option value="cheque">支票</option><option value="monthly">月结</option></select>
					</td>
				</tr>
				<tr>
					<td>企业法人:</td>
					<td><input class="easyui-textbox" type="text" name="cManager" data-options="required:false"/></td>
					<td>企业地区:</td>
					<td><input class="easyui-textbox" type="text" name="cZone" data-options="required:false"/></td>
				</tr>
				<tr>
					<td>企业地址:</td>
					<td><input class="easyui-textbox" type="text" name="cAddress" data-options="required:false,validType:'number'"/></td>
					<td>联系人:</td>
					<td><input class="easyui-textbox" type="text" name="cOrderName" data-options="required:false"/></td>
				</tr>
				<tr>
					<td>联系电话:</td>
					<td><input class="easyui-textbox" type="text" name="cOrderTel" data-options="required:false"/></td>
					<td>联系传真:</td>
					<td><input class="easyui-textbox" type="text" name="cOrderFax" data-options="required:false"/></td>
				</tr>
				<tr>
					<td>联系手机:</td>
					<td><input class="easyui-textbox" type="text" name="cOrderMobile" data-options="required:false"/></td>
					<td>企业邮箱:</td>
					<td><input class="easyui-textbox" type="text" name="cOrderEmail" data-options="required:false"/></td>
				</tr>
				<tr>
					<td>企业网址:</td>
					<td><input class="easyui-textbox" type="text" name="cOrderUrl" data-options="required:false"/></td>
					<td>状态:</td>
					<td>
						<select style="width:100px;" class="easyui-combobox" name="cStatus" data-options="panelHeight:'auto'"><option value="1">正常</option><option value="0">作废</option></select>
					</td>
				</tr>
				<tr>
					<td>采购员:</td>
					<td><input class="easyui-textbox" type="text" name="cBuyer" data-options="required:false"/></td>
					<td>开户行账号:</td>
					<td><input class="easyui-textbox" type="text" name="cBankId" data-options="required:false"/></td>
				</tr>
				<tr>
					<td>开户行名称:</td>
					<td><input class="easyui-textbox" type="text" name="cBankName" data-options="required:false"/></td>
					<td>备注:</td>
					<td><input class="easyui-textbox" type="text" name="cMemo" data-options="required:false"/></td>
				</tr>
			</table>
		</form>
	</div>
	<script>
	$(function(){
		init();
	});
	function init() {
        $('#dg_company').datagrid({
            url: '/erp/company/dg_find.yy'
        });
    }
    function dialog_open(){
        $('#dlg_company').dialog('open');
    }
    function dialog_close(){
        $('#dlg_company').dialog('close');
    }
	function add_company(){
        dialog_open();
	}
	function modify_company(){
		var row = $('#dg_company').datagrid('getSelected');
        if (row== null){
            $.messager.alert('Info', "请选择需要更新的行", 'error');
            return ;
        }else{
            dialog_open();
            $("#cId").val(row.cId);
            $("#cName").textbox('setValue',row.cName);
            $("#cType").combobox('setValue',row.cType);
            $("#cPaytype").combobox('setValue',row.cPaytype);
            $("#cManager").textbox('setValue',row.cManager);
            $("#cZone").textbox('setValue',row.cZone);
            $("#cAddress").textbox('setValue',row.cAddress);
            $("#cOrderName").textbox('setValue',row.cOrderName);
            $("#cOrderTel").textbox('setValue',row.cOrderTel);
            $("#cOrderFax").textbox('setValue',row.cOrderFax);
            $("#cOrderMobile").textbox('setValue',row.cOrderMobile);
            $("#cOrderEmail").textbox('setValue',row.cOrderEmail);
            $("#cOrderUrl").textbox('setValue',row.cOrderUrl);
            $("#cStatus").combobox('setValue',row.cStatus);
            $("#cBuyer").textbox('setValue',row.cBuyer);
            $("#cBankId").textbox('setValue',row.cBankId);
            $("#cBankName").textbox('setValue',row.cBankName);
            $("#cMemo").textbox('setValue',row.cMemo);
        }
	}
	function del_company(){
        var row = $('#dg_company').datagrid('getSelected');
        if (row== null){
            $.messager.alert('Info', "请选择需要删除的行", 'error');
            return ;
        }else{
            var eid = row.eId;
            $.post("/erp/company/del_json.yy",
                {eid:eid},
                function(data){
                    if(data > 0){
                        $.messager.alert('Info', "供应商已删除", 'error');
                        init();
                    }
                }
            );
        }
	}
	
	function find_company(){
		var url = '/erp/company/dg_find.yy?cName='+$("#cName").val() ;
		$('#dg_company').datagrid({
			url: url
		});
	}
    function isExistId(){
        var cid = $('#cId').val();
        $.post("/erp/company/checkId_json.yy",
            {cid:cid},
            function(data){
                if(data == 1){
                    $('#cId').attr("isValid ",false);
                    $('#cId').attr("missingMessage ","供应商编号已存在");
                }else{
                    $('#cId').attr("isValid ",true);
                }
            }
        );
    }

    function submitForm(){
        //第二种
        $('#ff_company').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                if(rj.status == 1){
                    dialog_close();
                    $("#ff_company").form('clear');
                    init();
                }
            }
        });
    }
	</script>