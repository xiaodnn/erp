<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<p style="font-weight: bold;color: red;">请完善权限信息，其中必填项，请认真填写。</p>
	<div style="margin:5px;"></div>
	<div class="easyui-panel" title="审核流程" style="width:100%;padding:3px;">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff_approve" class="easyui-form" method="post" action="/erp/approve/save.yy" data-options="novalidate:false">
	    	<table>
	    	<!-- 基本信息 -->
	    		<tr>
	    			<td>机构名称:</td>
	    			<td><input class="easyui-textbox" type="text" id="aOrgan" name="aOrgan" data-options="required:true"></input></td>
	    			<td>模块名称:</td>
	    			<td><input class="easyui-textbox" type="text" name="aModule" data-options="required:true,validType:{length:[0,20]}"></input></td>
					<td>审核级别:</td>
	    			<td>
	    				<select class="easyui-combobox" name="aLevel" data-options="width:'100px',panelHeight:'auto',onSelect:setLevel">
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
	    			<tr><td><input class="easyui-textbox" type="text" name="aLevelName1" data-options="required:true,width:'100px'"></input></td>
	    			<td><select class="easyui-combobox" name="aLevelUid1" data-options="width:'100px',panelHeight:'auto'">
	    			<option value="1">a</option>
	    			<option value="2">b</option>
	    			<option value="3">c</option>
	    			</select></td>
					</tr>
	    		</tbody>
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
		var aId = '${aId}';
		if(aId != "@err"){
			var url = '/erp/approve/add_json.yy?aId='+aId;
			$('#ff_approve').form('load', url);
			//$('#aId').textbox('textbox').attr('readonly',true);  //设置输入框为禁用
			$('#aId').prop('readonly',true);
			$('#aId').validatebox({required: false});
			$("#aId").removeAttr("onblur");
			// 覆盖已绑定的onblur事件。此时仅弹出hi  
			    //$( '#input1').removeAttr('onblur').on('blur',showHi);  
			    // 添加onblur事件，以前绑定的仍存在。此时先弹出hello，再弹出hi  
			    //$( '#input1').on('blur',showHi); 
		}
	});
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
		function clearForm(){
			$('#ff_approve').form('clear');
		}

		function setLevel(record){
			var n = record.value;
			var s = '<tr>';
			$("#tr_level").empty();
			//$("tr_level2").children().remove();
			for(var i=1;i<=n;i++){
				if(i == 4){
					s +='</tr><tr>';
				}
				s += '<td><input class="easyui-textbox" type="text" name="aLevelName'+i+'" data-options="required:true,width:\'100px\'"></input></td>';
    			s += '<td><select class="easyui-combobox" name="aLevelUid'+i+'" data-options="width:\'100px\',panelHeight:auto">';
    			s += '<option value="1">a'+i+'</option>';
    			s += '<option value="2">b'+i+'</option>';
    			s += '<option value="3">c'+i+'</option>';
    			s += '</select></td>';
			}
			s += '</tr>';
			//alert(s);
			$("#tr_level").append(s);
			
		}
	</script>