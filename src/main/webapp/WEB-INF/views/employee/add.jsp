<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<p style="font-weight: bold;color: red;">请完善员工信息，其中必填项，请认真填写。</p>
	<div style="margin:5px;"></div>
	<div class="easyui-panel" title="员工信息" style="width:100%;padding:3px;">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff_employee" class="easyui-form" method="post" action="/erp/employee/save.yy" data-options="novalidate:false">
	    	<table>
	    		<tr>
	    			<td>员工编码:</td>
	    			<td><input class="easyui-textbox" type="text" id="eId" name="eId" data-options="required:true" onblur="isExistId()"></input></td>
	    			<td>员工名称:</td>
	    			<td><input class="easyui-textbox" type="text" name="eName" data-options="required:true,validType:{length:[0,10]}"></input></td>
	    			<td>所在机构:</td>
	    			<td>
	    			<select style="width:100px;" class="easyui-combobox" name="eOid" data-options="panelHeight:'auto'"><option value="1001">一分店</option><option value="1002">二分店</option></select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>联系电话:</td>
	    			<td><input class="easyui-textbox" type="text" name="eMobile" data-options="required:false"></input></td>
	    			<td>生日:</td>
	    			<td><input class="easyui-textbox" type="text" name="eBirthday" data-options="required:false"></input></td>
					<td>性别:</td>
					<td><select style="width:100px;" class="easyui-combobox" name="eSex" data-options="panelHeight:'auto'"><option value="男">男</option><option value="女">女</option></select></td>
	    		</tr>
	    		<tr>
	    			<td>身份证号:</td>
	    			<td><input class="easyui-textbox" type="text" name="eIdcard" data-options="required:false,validType:'number'"></input></td>
	    			<td>状态:</td>
	    			<td><select style="width:100px;" class="easyui-combobox" name="eState" data-options="panelHeight:'auto'"><option value="1">有效</option><option value="0">失效</option></select></td>
	    			<td>地址:</td>
	    			<td><input class="easyui-textbox" type="text" name="eAddress" data-options="required:false"></input></td>
	    		</tr>

	    		</table>
	      </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清空</a>
	    </div>
	    </div>
	</div>
	<script>
	$(function(){
		var eid = '${eid}';
		//alert(eid);
		/*
		if(eid !=  0){
			var url = '/erp/employee/add_json.yy?eid='+eid;
			$('#ff_employee').form('load', url);
			$('#eId').prop('readonly',true);
			$('#eId').validatebox({required: false});
			$("#eId").removeAttr("onblur");
		}
		 */
        if(eid !=  0){
            var url = '/erp/employee/add_json.yy?eid='+eid;
            $('#ff_employee').form('load', url);
            $('#eId').prop('readonly',true);
            //$('#eId').validatebox({required: false});
            $("#eId").removeAttr("onblur");
        }
	});
		function submitForm(){
			//第二种
			$('#ff_employee').form('submit',{
				onSubmit:function(){
					//return $(this).form('validate');
                    return $(this).form();
				},
			    success:function(data){
			    	var rj = eval('(' + data + ')');
			    	if(rj.status == 1){
			    		var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
						tab.panel('refresh','/erp/employee/index.yy');
			    	}else{
			    		$.messager.alert('Info', rj.desc, 'error');
			    	}
			    }
			});
			
		}
		function clearForm(){
			$('#ff_employee').form('clear');
		}
		
		function isExistId(){
			var eid = $('#eId').val();
			$.post("/erp/employee/checkWid_json.yy",
					{eid:eid},
					function(data){
						if(data == 1){
							$.messager.alert('Info', "员工编号已存在", 'error');
						}
					}
				);
		}
	</script>
