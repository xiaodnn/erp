<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_organ" style="padding:5px;height:auto">
		<div id="organ_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_organ()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_organ()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_organ()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="s_oName" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_organ()">查找</a>
		</div>
	</div>

	<table id="dg_organ" class="easyui-datagrid" style="width:100%;height:auto;"
			 title="机构信息" toolbar="#tb_organ"
			singleSelect="true" fitColumns="true" rownumbers="true" pagination="true" datapagesize="5">
		<thead>
			<tr>
				<th data-options="field:'oId',width:40">机构ID</th>
				<th data-options="field:'oCode',width:60">机构编码</th>
				<th data-options="field:'oName',width:80">机构名称</th>
				<th data-options="field:'oAddress',width:160">地址</th>
				<th data-options="field:'oState',width:40">状态</th>
				<th data-options="field:'oManager',width:50">负责人</th>
				<th data-options="field:'oSaleprice',width:50">零售价格组</th>
				<th data-options="field:'oSellprice',width:50">批发价格组</th>
				<th data-options="field:'oCreator',width:50">创建人</th>
				<th data-options="field:'oIntime',width:50,formatter:formatDatebox" >创建日期</th>
			</tr>
		</thead>
	</table>

	<div id="dlg_organ" class="easyui-dialog" title="新增机构信息" style="width:500px;height:250px;padding:10px;"
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
				<form id="ff_organ" class="easyui-form" method="post" action="/erp/organ/save.yy" data-options="novalidate:false">
					<input type="hidden" id="oId" name="oId" />
					<table>
						<tr>
							<td>机构编码:</td>
					<td><input class="easyui-textbox" type="text" id="oCode" name="oCode" data-options="events:{blur:isExistId},required:true,validType:{length:[4]}" /></td>
					<td>机构名称:</td>
					<td><input class="easyui-textbox" type="text" id="oName" name="oName" data-options="required:true,validType:{length:[0,20]}" /></td>
				</tr>
				<tr>
					<td>零售价格组:</td>
					<td><input class="easyui-textbox" type="text" id="oSaleprice" name="oSaleprice" data-options="required:false" /></td>
					<td>批发价格组:</td>
					<td><input class="easyui-textbox" type="text" id="oSellprice" name="oSellprice" data-options="required:false" /></td>
				</tr>
				<tr>
					<td>负责人:</td>
					<td><input class="easyui-textbox" type="text" id="oManager" name="oManager" data-options="required:false,validType:'number'" /></td>
					<td>状态:</td>
					<td>
						<select style="width:100px;" class="easyui-combobox" id="oState" name="oState" data-options="panelHeight:'auto'"><option value="1">正常</option><option value="0">作废</option></select>
					</td>
				</tr>
				<tr>
					<td>创建人:</td>
					<td><input class="easyui-textbox" type="text" id="oCreator" name="oCreator"/></td>
					<td>地址:</td>
					<td><input class="easyui-textbox" type="text" id="oAddress" name="oAddress" /></td>
				</tr>
			</table>
		</form>
	</div>

	<script>
	$(function(){
        init();
    });

	function init(){
        $('#dg_organ').datagrid({
            url: '/erp/organ/find_json.yy'
        });
	}

	function add_organ(){
		//$('#admin_tabs').tabs('select','机构信息');
//		var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
		//var index = $('#admin_tabs').tabs('getTabIndex',tab);
		//alert(index+"---organ");
		//$('#admin_tabs').tabs('select',index);
//		tab.panel('refresh','/erp/organ/add.yy');
//        $('#dlg_organ').dialog('open');
        dialog_open();
	}
	function modify_organ(){
		var row = $('#dg_organ').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
//		    url = '/erp/organ/add.yy?oId='+row.oId;
//		    var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
//			tab.panel('refresh',url);
//            $.post("/erp/organ/add.yy",
//                {oId:row.oId},
//                function(data){
//                    var rj = eval('(' + data + ')');
//                    if(rj.status == 1){
//                        var organ = rj.data;
            dialog_open();
			$("#oId").val(row.oId);
            $("#oCode").textbox('setValue',row.oCode);
            $("#oName").textbox('setValue',row.oName);
            $("#oSaleprice").textbox('setValue',row.oSaleprice);
            $("#oSellprice").textbox('setValue',row.oSellprice);
            $("#oManager").textbox('setValue',row.oManager);
            $("#oState").combobox('setValue',row.oState);
            $("#oCreator").textbox('setValue',row.oCreator);
            $("#oAddress").textbox('setValue',row.oAddress);
//                    }else{
//                        $.messager.alert('Info', rj.desc, 'error');
//                    }
//                }
//            );

		}
	}
	function del_organ(){
		var row = $('#dg_organ').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var oId = row.oId;
			$.post("/erp/organ/del_json.yy",
					{oId:oId},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "机构已删除", 'error');
                            init();
						}
					}
				);
		}
	}
	
	function find_organ(){
		var url = '/erp/organ/find_json.yy?oName='+$("#oName").val() ;
		$('#dg_organ').datagrid({
			url: url
		});
	}
    function dialog_open(){
        $('#dlg_organ').dialog('open');
    }
	function dialog_close(){
        $('#dlg_organ').dialog('close');
	}

    function isExistId(){
        var oCode = $('#oCode').val();
        $.post("/erp/organ/checkOcode_json.yy",
            {oCode:oCode},
            function(data){
            	alert(data);
                if(data == 1){
//                    $.messager.alert('Info', "机构编号已存在", 'error');
                    $('#oCode').attr("isValid ",false);
                    $('#oCode').attr("missingMessage ","机构编号已存在");
                }else{
                    $('#oCode').attr("isValid ",true);
				}
            }
        );
    }

    function submit_form(){
        //第二种
        $('#ff_organ').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
//                return $(this).form();
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                $.messager.alert('Info',rj.desc, 'Info');
                if(rj.status == 1){
                    dialog_close();
                    $("#ff_organ").form('clear');
                    init();
                }
            }
        });
    }
	</script>