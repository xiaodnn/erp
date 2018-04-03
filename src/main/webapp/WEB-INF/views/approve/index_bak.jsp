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
<table id="dg_approve" class="easyui-datagrid" style="width:100%;height:100%;"
	   title="审核流程" toolbar="#tb_approve"
	   singleSelect="true" fitColumns="true" rownumbers="true" pagination="true">
	<thead>
	<tr>
		<th field="aId" width="60">ID</th>
		<th field="aOrgan" width="80">机构名称</th>
		<th field="aModule" align="right" width="70">模块ID</th>
		<th field="aLevel" align="right" width="70">级数</th>
		<th field="aLevelName1" width="100">一级审核职位</th>
		<th field="aLevelUid1" width="50">一级审核人</th>
		<th field="aLevelName2" width="100">二级审核职位</th>
		<th field="aLevelUid2" width="50">二级审核人</th>
		<th field="aLevelName3" width="100">三级审核职位</th>
		<th field="aLevelUid3" width="50">三级审核人</th>
		<th field="aLevelName4" width="100">四级审核职位</th>
		<th field="aLevelUid4" width="50">四级审核人</th>
		<th field="aLevelName5" width="100">五级审核职位</th>
		<th field="aLevelUid5" width="50">五级审核人</th>
		<th field="aLevelName6" width="100">六级审核职位</th>
		<th field="aLevelUid6" width="50">六级审核人</th>
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
				<td><input class="easyui-textbox" type="text" id="aOrgan" name="aOrgan" data-options="required:true"/></td>
				<td>模块名称:</td>
				<td><input class="easyui-textbox" type="text" name="aModule" data-options="required:true,validType:{length:[0,20]}" /></td>
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
				<td><select class="easyui-combobox" name="aLevelUid1" data-options="width:'60px',panelHeight:'auto'">
					<option value="1">a</option>
					<option value="2">b</option>
					<option value="3">c</option>
				</select></td>
				<td><input class="easyui-textbox" type="text" name="aLevelName1" data-options="required:true,width:'100px'"/></td>
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
        $('#dg_approve').datagrid({
            url: '/erp/approve/all.yy'
        });
    }
    function initCombox() {
        $('#aLevelUid').combobox('reload', '/erp/department/find_all.yy')
    }
    function dialog_open(){
        $('#dlg_approve').dialog('open');
    }
    function dialog_close(){
        $('#dlg_approve').dialog('close');
    }

    function add_approve(){
        //$('#admin_tabs').tabs('select','商品信息');
//		var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
//		tab.panel('refresh','/erp/approve/add.yy');
        dialog_open();
    }
    function modify_approve(){
//		var row = $('#dg_approve').datagrid('getSelected');
//		if (row== null){
//			$.messager.alert('Info', "请选择需要更新的行", 'error');
//			return ;
//		}else{
//		    url = '/erp/approve/add.yy?wid='+row.aId;
//		    var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
//			tab.panel('refresh',url);
//		}

        var row = $('#dg_approve').datagrid('getSelected');
        if (row== null){
            $.messager.alert('Info', "请选择需要更新的行", 'error');
            return ;
        }else {
            dialog_open();
            $("#oId").val(row.oId);
            $("#aOrgan").textbox('setValue', row.aOrgan);
            $("#oName").textbox('setValue', row.oName);
            $("#oSaleprice").textbox('setValue', row.oSaleprice);
            $("#oSellprice").textbox('setValue', row.oSellprice);
            $("#oManager").textbox('setValue', row.oManager);
            $("#oState").combobox('setValue', row.oState);
            $("#oCreator").textbox('setValue', row.oCreator);
            $("#oAddress").textbox('setValue', row.oAddress);
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

    function submitForm(){
        //第一种
        //$('#ff_approve').submit();
        //第二种
        $('#ff_approve').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                if(rj.status == 1){
                    var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
                    tab.panel('refresh','/erp/approve/index.yy');
                }else{
                    $.messager.alert('Info', rj.desc, 'error');
                }
            }
        });
    }

    function setLevel(record) {
        var n = record.value;
        var s = '<tr>';
        $("#tr_level").empty();
        //$("tr_level2").children().remove();
        for (var i = 1; i <= n; i++) {
            s += '<td><select class="easyui-combobox" name="aLevelUid' + i + '" data-options="width:\'60px\',panelHeight:auto">';
            s += '<option value="1">a' + i + '</option>';
            s += '<option value="2">b' + i + '</option>';
            s += '<option value="3">c' + i + '</option>';
            s += '</select></td>';
            s += '<td><input class="easyui-textbox" type="text" name="aLevelName'+i+'" data-options="required:true,width:\'100px\'"/></td>';
            if (i % 2 == 0) {
                s += '</tr><tr>';
            }
        }
        s += '</tr>';
        $("#tr_level").append(s);
    }
</script>