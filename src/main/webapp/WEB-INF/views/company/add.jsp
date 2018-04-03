<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<p style="font-weight: bold;color: red;">请完善供应商信息，其中必填项，请认真填写。</p>
	<div style="margin:5px;"></div>
	<div class="easyui-panel" title="供应商信息" style="width:100%;padding:3px;">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff_company" class="easyui-form" method="post" action="/erp/company/save.yy" data-options="novalidate:false">
	    	<table>
	    		<tr>
	    			<td>供应商编码:</td>
	    			<td><input class="easyui-textbox" type="text" id="cId" name="cId" data-options="required:true" onblur="isExistId()"></input></td>
	    			<td>供应商名称:</td>
	    			<td><input class="easyui-textbox" type="text" name="cName" data-options="required:true,validType:{length:[0,20]}"></input></td>
	    			<td>企业类型:</td>
	    			<td>
	    			<select style="width:100px;" class="easyui-combobox" name="cType" data-options="panelHeight:'auto'"><option value="manage">经营</option><option value="manufacture">生产</option></select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>结款类型:</td>
	    			<td>
	    				<select style="width:100px;" class="easyui-combobox" name="cPaytype" data-options="panelHeight:'auto'"><option value="cash">现金</option><option value="cheque">支票</option><option value="monthly">月结</option></select>
	    			</td>
	    			<td>企业法人:</td>
	    			<td><input class="easyui-textbox" type="text" name="cManager" data-options="required:false"></input></td>
	    			<td>企业地区:</td>
	    			<td><input class="easyui-textbox" type="text" name="cZone" data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
	    			<td>企业地址:</td>
	    			<td><input class="easyui-textbox" type="text" name="cAddress" data-options="required:false,validType:'number'"></input></td>
	    			<td>联系人:</td>
	    			<td><input class="easyui-textbox" type="text" name="cOrderName" data-options="required:false"></input></td>
	    			<td>联系电话:</td>
	    			<td><input class="easyui-textbox" type="text" name="cOrderTel" data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
	    			<td>联系传真:</td>
	    			<td><input class="easyui-textbox" type="text" name="cOrderFax" data-options="required:false"></input></td>
	    			<td>联系手机:</td>
	    			<td><input class="easyui-textbox" type="text" name="cOrderMobile" data-options="required:false"></input></td>
	    			<td>企业邮箱:</td>
	    			<td><input class="easyui-textbox" type="text" name="cOrderEmail" data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
	    			<td>企业网址:</td>
	    			<td><input class="easyui-textbox" type="text" name="cOrderUrl" data-options="required:false"></input></td>
	    			<td>状态:</td>
	    			<td>
	    			<select style="width:100px;" class="easyui-combobox" name="cStatus" data-options="panelHeight:'auto'"><option value="1">正常</option><option value="0">作废</option></select>
	    			</td>
	    			<td>采购员:</td>
	    			<td><input class="easyui-textbox" type="text" name="cBuyer" data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
	    			<td>开户行账号:</td>
	    			<td><input class="easyui-textbox" type="text" name="cBankId" data-options="required:false"></input></td>
	    			<td>开户行名称:</td>
	    			<td><input class="easyui-textbox" type="text" name="cBankName" data-options="required:false"></input></td>
	    			<td>备注:</td>
	    			<td><input class="easyui-textbox" type="text" name="cMemo" data-options="required:false"></input></td>
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
		var cid = '${cid}';
		if(cid != "@err"){
			var url = '/erp/company/add_json.yy?cid='+cid;
			$('#ff_company').form('load', url);
			$('#cId').prop('readonly',true);
			$('#cId').validatebox({required: false});
			$("#cId").removeAttr("onblur");
		}
	});
		function submitForm(){
			//第二种
			$('#ff_company').form('submit',{
				onSubmit:function(){
					return $(this).form('validate');
				},
			    success:function(data){
			    	var rj = eval('(' + data + ')');
			    	if(rj.status == 1){
			    		var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
						tab.panel('refresh','/erp/company/index.yy');
			    	}else{
			    		$.messager.alert('Info', rj.desc, 'error');
			    	}
			    }
			});
			
		}
		function clearForm(){
			$('#ff_company').form('clear');
		}
		
		function isExistId(){
			var cid = $('#cId').val();
			$.post("/erp/company/checkWid_json.yy",
					{cid:cid},
					function(data){
						if(data == 1){
							$.messager.alert('Info', "供应商编号已存在", 'error');
						}
					}
				);
		}
	</script>
