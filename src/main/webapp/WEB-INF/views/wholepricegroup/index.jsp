<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="tb_wholepricegroup" style="padding:5px;height:auto">
		<div id="wholepricegroup_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_wholepricegroup()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_wholepricegroup()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_wholepricegroup()"></a>
		</div>
		<div>
			日期: <input class="easyui-datebox" style="width:80px" />
			至:<input class="easyui-datebox" style="width:80px" />
			名称: <input class="easyui-textbox" style="width:100px" id="s_wId" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_wholepricegroup()">查找</a>
		</div>
	</div>

	<table id="dg_wholepricegroup" class="easyui-datagrid" style="width:100%;height:100%;"
			 title="批发价格组信息" data-options="toolbar:'#tb_wholepricegroup',singleSelect:true,fitColumns:true,rownumbers:true,pagination:true,datapagesize:5">
		<thead>
			<tr>
				<th data-options="field:'wpgId',width:40">批发价格组ID</th>
				<th data-options="field:'wpgName',width:160">批发价格组名称</th>
			</tr>
		</thead>
	</table>

	<div id="dlg_wholepricegroup" class="easyui-dialog" title="新增批发价格组信息" style="width:500px;height:250px;padding:10px;"
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
				<form id="ff_wholepricegroup" class="easyui-form" method="post" action="/erp/wholepricegroup/save.yy" data-options="novalidate:false">
					<input type="hidden" id="wpgId" name="wpgId" value="${wpgId}" />
					<table>
						<tr>
							<td>批发价格组:</td>
							<td><input class="easyui-textbox" type="text" id="wpgName" name="wpgName" data-options="required:true" /></td>
						</tr>
					</table>
				</form>
	</div>

	<script>
	$(function(){
        init();
    });

	function init(){
        $('#dg_wholepricegroup').datagrid({
            url: '/erp/wholepricegroup/dg_find.yy'
        });
	}

	function add_wholepricegroup(){
        dialog_open();
	}
	function modify_wholepricegroup(){
		var row = $('#dg_wholepricegroup').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
            dialog_open();
			$("#wpgId").val(row.wpgId);
            $("#wpgName").textbox('setValue',row.wpgName);
		}
	}
	function del_wholepricegroup(){
		var row = $('#dg_wholepricegroup').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var shId = row.shId;
			$.post("/erp/wholepricegroup/del_json.yy",
					{id:wpgId},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "批发价格组已删除", 'error');
                            init();
						}
					}
				);
		}
	}
	
	function find_wholepricegroup(){
		var url = '/erp/wholepricegroup/dg_find.yy?id='+$("#wpgId").val() ;
		$('#dg_wholepricegroup').datagrid({
			url: url
		});
	}
    function dialog_open(){
        $('#dlg_wholepricegroup').dialog('open');
    }
	function dialog_close(){
        $('#dlg_wholepricegroup').dialog('close');
	}

    function submit_form(){
        //第二种
        $('#ff_wholepricegroup').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
//                return $(this).form();
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                $.messager.alert('Info',rj.desc, 'Info');
                if(rj.status == 1){
                    dialog_close();
                    $("#ff_wholepricegroup").form('clear');
                    init();
                }
            }
        });

    }
	</script>