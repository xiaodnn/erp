<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div id="tb_mapusermodule" style="padding:5px;height:auto">
		<div id="mapusermodule_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_mapusermodule()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_mapusermodule()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_mapusermodule()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="tname" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_mapusermodule()">查找</a>
		</div>
	</div>
	<table id="dg_mapusermodule" class="easyui-datagrid" style="width:100%;height:auto;"
			 title="用户权限设置" toolbar="#tb_mapusermodule"
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

	<div id="dlg_mapusermodule" class="easyui-dialog" title="新增用户权限设置" style="width:500px;height:250px;padding:10px;"
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

		<form id="ff_mapusermodule" class="easyui-form" method="post" action="/erp/mapusermodule/save.yy" data-options="novalidate:false">
			<div>
				用户:
				<input class="easyui-combobox"  id="uId" name="uId" data-options="
							url:'/erp/user/find_name.yy',
							method:'post',
							valueField: 'uId',
							textField: 'uName',
							panelHeight:'auto',
							required:true"/>
			</div>
			<div>
				<c:forEach items="${modules}" var="module">
					<div>
						<input id="mId" name="mId" type="checkbox" value="${module.mId}" />${module.mName}
					</div>
				</c:forEach>

			</div>
		</form>

	</div>

	<script>
	$(function(){
        //init();
	});
    function init(){
//        alert("dg_mapusermodule init");
        $('#dg_mapusermodule').datagrid({
            url: '/erp/mapusermodule/dg_all.yy'
        });
    }

    function dialog_open(){
//        alert("#dlg_mapusermodule");
        $('#dlg_mapusermodule').dialog('open');
    }
    function dialog_close(){
        $('#dlg_mapusermodule').dialog('close');
    }

	function add_mapusermodule(){
        dialog_open();
	}
	function modify_mapusermodule(){
        var row = $('#dg_mapusermodule').datagrid('getSelected');
        if (row== null){
            $.messager.alert('Info', "请选择需要更新的行", 'error');
            return ;
        }else {
            dialog_open();
            $("#oId").val(row.oId);
            $("#aOrgan").textbox('setValue', row.aOrgan);
            $("#aModule").textbox('setValue', row.aModule);
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
	function del_mapusermodule(){
		var row = $('#dg_mapusermodule').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var wid = row.aId;
			//$.messager.alert('Info',wid, 'info');
			$.post("/erp/mapusermodule/del_json.yy",
					{wid:wid},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "用户权限设置已删除", 'error');
							$('#dg_mapusermodule').datagrid({
								url: '/erp/mapusermodule/all.yy'
							});
						}
					}
				);
		}
	}
	
	function find_mapusermodule(){
		var url = '/erp/mapusermodule/find_json.yy?wTraname='+$("#tname").val() ;
		$('#dg_mapusermodule').datagrid({
			url: url
		});
	}
    function submit_form(){
        //第二种
        $('#ff_mapusermodule').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
//                return $(this).form();
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                $.messager.alert('Info',rj.desc, 'Info');
                if(rj.status == 1){
                    dialog_close();
                    $("#ff_mapusermodule").form('clear');
                    init();
                }
            }
        });
    }

	</script>