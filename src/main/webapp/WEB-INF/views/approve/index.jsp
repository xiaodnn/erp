<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_approve" style="padding:5px;height:auto">
		<div id="approve_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_approve()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_approve()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_approve()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="tname" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_approve()">查找</a>
		</div>
	</div>
	<table id="dg_approve" class="easyui-datagrid" style="width:100%;height:auto;"
			 title="审核流程" toolbar="#tb_approve"
			singleSelect="true" fitColumns="true" rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="aId" width="60">ID</th>
				<th field="aOrganName" width="80">机构名称</th>
				<th field="aModuleName" align="right" width="70">模块名称</th>
				<th field="aLevel" align="right" width="70">审核级数</th>
				<th field="dname1" width="80">一审部门</th>
				<th field="uname1" width="80">一审核人</th>
				<th field="dname2" width="80">二审部门</th>
				<th field="uname2" width="80">二审核人</th>
				<th field="dname3" width="80">三审部门</th>
				<th field="uname3" width="80">三审核人</th>
				<th field="dname4" width="80">四审部门</th>
				<th field="uname4" width="80">四审核人</th>
				<th field="dname5" width="80">五审部门</th>
				<th field="uname5" width="80">五审核人</th>
				<th field="dname6" width="80">六审部门</th>
				<th field="uname6" width="80">六审核人</th>
			</tr>
		</thead>
	</table>

	<div id="dlg_approve" class="easyui-dialog" title="新增审核流程" style="width:500px;height:250px;padding:10px;"
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

		<form id="ff_approve" class="easyui-form" method="post" action="/erp/approve/save.yy" data-options="novalidate:false">
			<input type="hidden" id="aId" name="aId" />
			<table>
				<!-- 基本信息 -->
				<tr>
					<td>机构名称:</td>
					<td><input class="easyui-combobox"  id="oId" name="oId" data-options="
							url:'/erp/organ/find_name.yy',
							method:'post',
							valueField: 'oId',
							textField: 'oName',
							panelHeight:'auto',
							required:true"/></td>
					<td>模块名称:</td>
					<td><input class="easyui-combobox" id="mId"  name="mId" data-options="
							url:'/erp/module/find_name.yy',
							method:'post',
							valueField: 'mId',
							textField: 'mName',
							panelHeight:'auto',
							required:true,
							validType:{length:[0,20]}" />
					</td>
				</tr>
				<tr>
					<td>审核级别:</td>
					<td>
						<select class="easyui-combobox" name="aLevel" data-options="width:'60px',panelHeight:'auto',onSelect:setLevel">
							<option value="1">一级</option>
							<option value="2">二级</option>
							<option value="3">三级</option>
							<option value="4">四级</option>
							<option value="5">五级</option>
							<option value="6">六级</option>
						</select>
					</td>
				</tr>
				<tbody id="tr_level">
				<tr>
					<td id="td_did1">
						<input class="easyui-combobox" id="aLevelDid1" name="aLevelDid1" style="width:75px;" data-options="
							url: '/erp/department/find_all.yy',
                        method: 'post',
							valueField: 'dId',
							textField: 'dName',
							required:true" />
					</td>
					<td id="td_uid1">
						<input class="easyui-combobox" id="aLevelUid1" name="aLevelUid1" data-options="
							url:'/erp/employee/find_json.yy',
							valueField: 'eId',
							textField: 'eName',
							hasDownArrow: false,
							panelHeight: '125',
							width:'70px',
							required:true"/>
					</td>
					<td id="td_did2">
						<input class="easyui-combobox" id="aLevelDid2" name="aLevelDid2" style="width:75px;" data-options="
							url: '/erp/department/find_all.yy',
                        method: 'post',
							valueField: 'dId',
							textField: 'dName'" />
					</td>
					<td id="td_uid2"><input class="easyui-combobox"  id="aLevelUid2" name="aLevelUid2" data-options="
							url:'/erp/employee/find_json.yy',
							valueField: 'eId',
							textField: 'eName',
							hasDownArrow: false,
							panelHeight: '125',
							width:'70px'"/></td>
				</tr>
				<tr>
					<td id="td_did3">
						<input class="easyui-combobox" id="aLevelDid3" name="aLevelDid3" style="width:75px;" data-options="
							url: '/erp/department/find_all.yy',
                        method: 'post',
							valueField: 'dId',
							textField: 'dName'" />
					</td>
					<td id="td_uid3"><input class="easyui-combobox"  id="aLevelUid3" name="aLevelUid3" data-options="
							url:'/erp/employee/find_json.yy',
							valueField: 'eId',
							textField: 'eName',
							hasDownArrow: false,
							panelHeight: '125',
							width:'70px'"/>
					</td>
					<td id="td_did4">
						<input class="easyui-combobox" id="aLevelDid4" name="aLevelDid4" style="width:75px;" data-options="
							url: '/erp/department/find_all.yy',
                        method: 'post',
							valueField: 'dId',
							textField: 'dName'" />
					</td>
					<td id="td_uid4"><input class="easyui-combobox"  id="aLevelUid4" name="aLevelUid4" data-options="
							url:'/erp/employee/find_json.yy',
							valueField: 'eId',
							textField: 'eName',
							hasDownArrow: false,
							panelHeight: '125',
							width:'70px'"/>
					</td>
				</tr>
				<tr>
					<td id="td_did5">
						<input class="easyui-combobox" id="aLevelDid5" name="aLevelDid5" style="width:75px;" data-options="
							url: '/erp/department/find_all.yy',
                        method: 'post',
							valueField: 'dId',
							textField: 'dName'" />
					</td>
					<td id="td_uid5"><input class="easyui-combobox"  id="aLevelUid5" name="aLevelUid5" data-options="
							url:'/erp/employee/find_json.yy',
							valueField: 'eId',
							textField: 'eName',
							hasDownArrow: false,
							panelHeight: '125',
							width:'70px'"/>
					</td>
					<td id="td_did6">
						<input class="easyui-combobox" id="aLevelDid6" name="aLevelDid6" style="width:75px;" data-options="
							url: '/erp/department/find_all.yy',
                        method: 'post',
							valueField: 'dId',
							textField: 'dName'" />
					</td>
					<td id="td_uid6"><input class="easyui-combobox"  id="aLevelUid6" name="aLevelUid6" data-options="
							url:'/erp/employee/find_json.yy',
							valueField: 'eId',
							textField: 'eName',
							hasDownArrow: false,
							panelHeight: '125',
							width:'70px'"/>
					</td>
				</tr>
				</tbody>
			</table>
		</form>

	</div>

	<script>
	$(function(){
        init();
        initCombox();
	});
    function init(){
//        alert("dg_approve init");
        $('#dg_approve').datagrid({
            url: '/erp/approve/dg_find.yy'
        });
    }
    function initCombox(){
        for(var i=2;i<=6;i++){
            $("#td_did"+i).hide();
            $("#td_uid"+i).hide();
        }
    }
    function dialog_open(){
//        alert("#dlg_approve");
        $('#dlg_approve').dialog('open');
    }
    function dialog_close(){
        $('#dlg_approve').dialog('close');
    }

	function add_approve(){
        dialog_open();
	}
	function modify_approve(){
        var row = $('#dg_approve').datagrid('getSelected');
        if (row== null){
            $.messager.alert('Info', "请选择需要更新的行", 'error');
            return ;
        }else {
            dialog_open();
            $("#oId").val(row.oId);
            $("#oId").textbox('setValue', row.oId);
            $("#mId").textbox('setValue', row.mId);
            $("#aLevel").textbox('setValue', row.aLevel);
            $("#aLevelDid1").textbox('setValue', row.aLevelDid1);
            $("#aLevelUid1").textbox('setValue', row.aLevelUid1);
            $("#aLevelDid2").combobox('setValue', row.aLevelDid2);
            $("#aLevelUid2").textbox('setValue', row.aLevelUid2);
            $("#aLevelDid3").textbox('setValue', row.aLevelDid3);
            $("#aLevelUid3").textbox('setValue', row.aLevelUid3);
            $("#aLevelDid4").textbox('setValue', row.aLevelDid4);
            $("#aLevelUid4").textbox('setValue', row.aLevelUid4);
            $("#aLevelDid5").combobox('setValue',row.aLevelDid5);
            $("#aLevelUid5").textbox('setValue', row.aLevelUid5);
            $("#aLevelDid6").textbox('setValue', row.aLevelDid6);
            $("#aLevelUid6").textbox('setValue', row.aLevelUid6);
        }
	}
	function del_approve(){
		var row = $('#dg_approve').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var wid = row.aId;
			//$.messager.alert('Info',wid, 'info');
			$.post("/erp/approve/del_json.yy",
					{wid:wid},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "商品已删除", 'error');
							$('#dg_approve').datagrid({
								url: '/erp/approve/all.yy'
							});
						}
					}
				);
		}
	}
	
	function find_approve(){
		var url = '/erp/approve/find_json.yy?wTraname='+$("#tname").val() ;
		$('#dg_approve').datagrid({
			url: url
		});
	}
    function submit_form(){
        //第二种
        $('#ff_approve').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
//                return $(this).form();
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                $.messager.alert('Info',rj.desc, 'Info');
                if(rj.status == 1){
                    dialog_close();
                    $("#ff_approve").form('clear');
                    init();
                }
            }
        });
    }

    function setLevel(record) {
        var n = record.value;
        n = parseInt(n);
        for(var i=1;i<=n;i++){
            $("#td_did"+i).show();
            $("#aLevelDid"+i).combobox({
                required:true
            });

            $("#td_uid"+i).show();
            $("#aLevelUid"+i).combobox({
                required:true
            });
        }
		var nn = n+1;
        for(var j=nn;j<=6;j++){
            $("#td_did"+j).hide();
            $("#aLevelDid"+i).combobox({
                required:false
            });

            $("#td_uid"+j).hide();
            $("#aLevelUid"+i).combobox({
                required:false
            });
        }
    }

	</script>