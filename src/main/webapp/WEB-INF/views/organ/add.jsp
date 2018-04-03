<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<p style="font-weight: bold;color: red;">请完善机构信息，其中必填项，请认真填写。</p>
	<div style="margin:5px;"></div>
	<div class="easyui-panel" title="机构信息" style="width:100%;padding:3px;">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff_organ" class="easyui-form" method="post" action="/erp/organ/save.yy" data-options="novalidate:false">
	    	<table>
	    		<tr>
	    			<td>机构编码:</td>
	    			<td><input class="easyui-textbox" type="text" id="oCode" name="oCode" data-options="required:true" onblur="isExistId()"></input></td>
	    			<td>机构名称:</td>
	    			<td><input class="easyui-textbox" type="text" name="oName" data-options="required:true,validType:{length:[0,20]}"></input></td>
	    			<td>状态:</td>
	    			<td>
						<select style="width:100px;" class="easyui-combobox" name="oState" data-options="panelHeight:'auto'"><option value="1">正常</option><option value="0">作废</option></select>
					</td>
	    		</tr>
	    		<tr>
	    			<td>负责人:</td>
	    			<td><input class="easyui-textbox" type="text" name="oManager" data-options="required:false,validType:'number'"></input></td>
	    			<td>创建人:</td>
	    			<td><input class="easyui-textbox" type="text" name="oCreator" data-options="required:false"></input></td>
	    			<td>地址:</td>
	    			<td><input class="easyui-textbox" type="text" name="oAddress" data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
	    			<td>零售价格组:</td>
	    			<td><input class="easyui-textbox" type="text" name="oSaleprice" data-options="required:false"></input></td>
	    			<td>批发价格组:</td>
	    			<td><input class="easyui-textbox" type="text" name="oSellprice" data-options="required:false"></input></td>
	    			<td>创建时间:</td>
	    			<td><input class="easyui-textbox" type="text" name="oIntime" data-options="required:false"></input></td>
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
		var oCode = '${oCode}';
		if(oCode != "@err"){
			var url = '/erp/organ/add_json.yy?oCode='+oCode;
			$('#ff_organ').form('load', url);
			//$('#oCode').prop('readonly',true);
			//$('#oCode').validatebox({required: false});
			//$("#oCode").removeAttr("onblur");
		}
	});
		function submitForm(){
			//第二种
			$('#ff_organ').form('submit',{
				onSubmit:function(){
					return $(this).form('validate');
				},
			    success:function(data){
			    	var rj = eval('(' + data + ')');
			    	if(rj.status == 1){
			    		var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
						tab.panel('refresh','/erp/organ/index.yy');
			    	}else{
			    		$.messager.alert('Info', rj.desc, 'error');
			    	}
			    }
			});
			
		}
		function clearForm(){
			$('#ff_organ').form('clear');
		}
		
		function isExistId(){
			var oCode = $('#oCode').val();
			$.post("/erp/organ/checkWid_json.yy",
					{oCode:oCode},
					function(data){
						if(data == 1){
							$.messager.alert('Info', "机构编号已存在", 'error');
						}
					}
				);
		}
	</script>
