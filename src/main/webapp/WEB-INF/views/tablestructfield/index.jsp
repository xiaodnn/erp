<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<table>
		<tr>
			<td>表名:</td>
			<td>
				<select style="width:150px;" class="easyui-combobox" id="tsId" name="tsId" data-options="required:true,editable:false,panelHeight:'auto',onSelect:tsIdSelect">
				</select>
			</td>
			<td>表名称:</td>
			<td><input class="easyui-textbox" id="tsNikename" name="tsNikename" data-options="readonly:true" /></td>
			<td>表类型:</td>
			<td>
				<select  style="width:60px;" class="easyui-combobox" id="tsType" name="tsType" data-options="panelHeight:'auto'">
					<option value="1">普通</option>
					<option value="2">单据</option>
				</select>
			</td>						
			<td>主表:</td>
			<td>
				<select style="width:150px;" class="easyui-combobox" id="tsMid" name="tsMid" data-options="valueField:'tsId',textField:'tsName',editable:false,panelHeight:'auto'">
				</select>
			</td>		
			<td>备注:</td>
			<td><input class="easyui-textbox" type="text" id="tsRemark" name="tsRemark" data-options="readonly:true" /></td>							
		</tr>
	</table>
	<table id="dg_tablestructfield" class="easyui-datagrid" style="width:100%;height:auto;border-width:0;"
            data-options="
            	iconCls: 'icon-edit',
                singleSelect: true,
                rownumbers: true,
                toolbar: '#tb_tablestructfield',
                onClickRow: onClickRow">
        <thead>
            <tr>
				<th data-options="field:'tsfName',width:100,editor:'textbox',halign: 'center'">字段名</th>
				<th data-options="field:'tsfType',width:100,editor:'textbox',halign: 'center'">字段类型</th>
				<th data-options="field:'tsfLen',width:40,editor:'textbox',halign: 'center'">长度</th>
				<th data-options="field:'tsfKey',width:80,editor:'textbox',halign: 'center'">主外键</th>
				<th data-options="field:'tsfNikename',width:200,editor:'textbox',halign: 'center'">字段名描叙</th>
				<th data-options="field:'tsfFormtype',width:150,halign: 'center',
						formatter:function(value,row){
							return row.tsfFormtype;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'tsfFormtype',
								textField:'formtypeName',
								method:'get',
								url:'/erp/fromtype.json'
							}
						}">控件类型</th>
				<th data-options="field:'isnotnull',width:30,halign: 'center',align:'center',editor:{type:'checkbox',options:{on:'是',off:'否'}}">为空</th>
				<th data-options="field:'tsfDefault',width:100,editor:'textbox',halign: 'center'">默认值</th>
				<th data-options="field:'tsfRemark',width:200,editor:'textbox',halign: 'center'">备注</th>
				<th data-options="field:'intime',width:80,editor:'textbox',halign: 'center',formatter:formatDatebox">创建时间</th>
			</tr>
        </thead>
    </table>
 
    <div id="tb_tablestructfield" style="height:auto">
        <a id="append_detail" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="appendDgDetail()">添加明细</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="submit_form()">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-back',plain:true" onclick="callback('tablestructfield')">返回</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="create_table()">创建表</a>
    </div>

	<script>
	$(function(){
        init();
    });

	function init(){
		/*
        $('#dg_tablestructfield').datagrid({
            url: '/erp/tablestructfield/dg_find.yy'
        });
        */
        
      	//加载表名:
		$("#tsId").combobox({
            url: '/erp/tablestruct/find_name.yy',
            method: 'post',
            valueField: 'tsId',
            textField: 'tsName'
		});
		//加载主表名
		$("#tsMid").combobox({
            url: '/erp/tablestruct/find_name.yy',
            method: 'post',
            valueField: 'tsId',
            textField: 'tsName',
            loadFilter : function (data) {
                if (data && data instanceof Array) {
                    data.splice(0, 0, {tsId: '', tsName: '请选择'});// 此处空格用全角
                }
                return data;
            }
		});
		
		/*
		$.post("/erp/tablestruct/find_name.yy",
			{name:""},
			function(data){					
				if(data){
					$("#tsId").combobox("loadData",data);
					
					$("#tsId").combobox("loadData",data,{
						onChange:function(newValue,oldValue){
							tsIdSelect(newValue+","+oldValue)
						}
				    });
					
					//$("#tsMid").combobox("loadData",data);
					if (data && data instanceof Array) {
		                var mid_data = data.splice(0, 0, {tsId: '', tsName: '请选择'});// 此处空格用全角
		                $("#tsMid").combobox("loadData",mid_data);
		            }
				}
			}
		);
		*/
	}
	
	
	function tsIdSelect(rec){
		$.post("/erp/tablestruct/find_id.yy",
			{id:rec.tsId},
			function(data){
				if(data){
					$("#tsNikename").textbox("setValue",data.tsNikename);
					$("#tsType").combobox("select",data.tsType);
					$("#tsRemark").textbox("setValue",data.tsRemark);
					var fields = data.tableStructFields;
					//alert(fields);
					//alert(fields.length);
					if(fields != null && fields.length > 0){
						var field = fields[0];
						//alert(field.tsfName);
						if(field.tsfName != undefined && field.tsfName != null && field.tsfName != "" ){
							$("#dg_tablestructfield").datagrid("loadData",data.tableStructFields);//添加明细
						}else{
							$('#dg_tablestructfield').datagrid('loadData', { total: 0, rows: [] }); //清空 datagrid数据
						}
					}
					//$("#dg_tablestructfield").datagrid("loadData",data.tableStructFields);
				}
			}
		);
	}
	
	
	function add_tablestructfield(){
		var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
		tab.panel('refresh','/erp/tablestructfield/add.yy');
	}
	function modify_tablestructfield(){
		var row = $('#dg_tablestructfield').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要更新的行", 'error');
			return ;
		}else{
		    url = '/erp/tablestructfield/add.yy?wsId='+row.wsId;
		    var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
			tab.panel('refresh',url);
		}
	}
	function del_tablestructfield(){
		var row = $('#dg_tablestructfield').datagrid('getSelected');
		if (row== null){
			$.messager.alert('Info', "请选择需要删除的行", 'error');
			return ;
		}else{
		    var wsId = row.wsId;
			$.post("/erp/tablestructfield/del_json.yy",
					{wsId:wsId},
					function(data){
						if(data > 0){
							$.messager.alert('Info', "入库已删除", 'error');
							$('#dg_tablestructfield').datagrid({
								url: '/erp/tablestructfield/dg_find.yy'
							});
						}
					}
				);
		}
	}

    function submit_form(){
    	var id = $("#tsId").combobox("getValue");
    	if(id.length == 0){
			 $.messager.alert('提示', '请选择需要创建的表！');
			 return false;
		}
    	
        if (endEditing()){
            if ($('#dg_tablestructfield').datagrid('getChanges').length) {
//                    debugger;
                var inserted = $('#dg_tablestructfield').datagrid('getChanges', "inserted");
                var deleted = $('#dg_tablestructfield').datagrid('getChanges', 'deleted');
                var updated = $('#dg_tablestructfield').datagrid('getChanges', "updated");

                var effectRow = new Object();
                if (inserted.length) {
                    inserted = JSON.stringify(inserted);
                }
                if (deleted.length) {
                    deleted = JSON.stringify(deleted);
                }
                if (updated.length) {
                    updated = JSON.stringify(updated);
                }

                $.post('/erp/tablestructfield/save.yy',
                    {tsId:id,
                        add:inserted,
                        del:deleted,
                        modify:updated
                    },
                    function(data) {
                        var rj = eval('(' + data + ')');
                        if(rj.status){
                            $.messager.alert('提示', rj.desc +',提交成功！');
                            $('#tb_tablestructfield').datagrid('acceptChanges');
                        }
                    }, 'JSON').error(function() {
                    $.messager.alert('提示', '提交错误了！');
                });
            }
        }
        //保存后
        $('#dg_tablestructfield').datagrid('acceptChanges');
    }
    
    //结束编辑
    /*
    function onEndEdit(index, row){
        var ed = $(this).datagrid('getEditor', {
            index: index,
            field: 'wTraname'
        });
        //row.wClassid = $(ed.target).combobox('getText');
    }
*/
  //增加行
   function appendDgDetail(){
   	//debugger;
       if (endEditing()){
           $('#dg_tablestructfield').datagrid('appendRow',{status:'P'});
           editIndex = $('#dg_tablestructfield').datagrid('getRows').length-1;
           $('#dg_tablestructfield').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
          
           setCell(editIndex);
       }
   }
  
  function addTableName(tag){
	  
	  //加载入库机构:
		/* $(tag).combobox({
          url: '/erp/tablestruct/find_name.yy',
          method: 'post',
          valueField: 'tsId',
          textField: 'tsName'
		}); */
	  
  }
  
  //单击单元格事件
    function onClickCell(index, field){
        if (editIndex != index){
            if (endEditing()){
                $('#dg_tablestructfield').datagrid('selectRow', index).datagrid('beginEdit', index);
                var ed = $('#dg_tablestructfield').datagrid('getEditor', {index:index,field:field});
                if (ed){
                    $(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target);
                    var obj = $(ed.target).textbox('textbox');
                    if(field == 'wClassid' || field == 'wTraname'){
                        $(ed.target).textbox('textbox').bind('keyup', function(e){
                            if(e.keyCode != 8){//13回车键,8退格键
                                var str = $(this).val();
                                if(str != ""){
                                    findWare($(this));
                                }
                            }
                        });
                    }else{
                        //alert("---field-2--"+field+","+index);
                    }
                }
                editIndex = index;
            } else {
                setTimeout(function(){
                    $('#dg_tablestructfield').datagrid('selectRow', editIndex);
                },0);
            }
        }
    }
  
    //结束编辑
    /*
    var editIndex = undefined;
    function endEditing(){
        if (editIndex == undefined){
            return true;
        }
        if ($('#dg_tablestructfield').datagrid('validateRow', editIndex)){
            $('#dg_tablestructfield').datagrid('endEdit', editIndex);
            editIndex = undefined;
            return true;
        } else {
            return false;
        }
    }
	*/
    function setCell(editIndex) {
      
    }
    
    var editIndex = undefined;
	function endEditing(){
		if (editIndex == undefined){return true}
		if ($('#dg_tablestructfield').datagrid('validateRow', editIndex)){
			var ed_type = $('#dg_tablestructfield').datagrid('getEditor', {index:editIndex,field:'tsfFormtype'});
			var formtypeName = $(ed_type.target).combobox('getText');
			$('#dg_tablestructfield').datagrid('getRows')[editIndex]['formtypeName'] = formtypeName;
			
			var ed_time = $('#dg_tablestructfield').datagrid('getEditor', {index:editIndex,field:'intime'});
			var v_intime = $(ed_time.target).textbox('getValue');
			
			$('#dg_tablestructfield').datagrid('getRows')[editIndex]['intime'] = v_intime;
			
			$('#dg_tablestructfield').datagrid('endEdit', editIndex);
			editIndex = undefined;
			return true;
		} else {
			return false;
		}
	}
	function onClickRow(index){
		if (editIndex != index){
			if (endEditing()){
				$('#dg_tablestructfield').datagrid('selectRow', index)
						.datagrid('beginEdit', index);
				editIndex = index;
			} else {
				$('#dg_tablestructfield').datagrid('selectRow', editIndex);
			}
		}
	}
	
	function create_table(){
		var id = $("#tsId").combobox("getValue");
		if(id.length == 0){
			 $.messager.alert('提示', '请选择需要创建的表！');
			 return false;
		}
		$.post("/erp/tablestruct/create_table.yy",
				{id:id},
				function(data){
					if(data){
						if(data.state == 1){
							$.messager.alert('提示', '创建表成功！');
						}
					}
				}
			);
	}
	</script>