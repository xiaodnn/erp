<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	#findWare_div p{color:#000000}  
	#findWare_div p:hover{ color:#ff0000;}
  
	.findWare_div_table{display:table;border-collapse:collapse;border:1px solid #E0ECFF;}  
	.findWare_div_table ul{	margin:0;padding:0;list-style:none;	display:table-row;height:25px;}
	.findWare_div_table ul:hover{background:#f6f6f6;}
	.findWare_div_table li{display:table-cell;padding:3px;border:1px solid #E0ECFF;}  
	.findWare_div_table .table-row-group{display:table-row-group;}
	.findWare_div_table .table-header-group{display:table-header-group;background:#eee;font-weight:bold;text-align: center;}
	.easyui-textbox{
		background-color:expression(this.readOnly==true?"#eee":"#fff");  
	} 
</style>  
	<div class="easyui-panel" style="width:100%;padding:3px;border:none;" data-options="iconCls:'icon-ok'">
		<div style="padding:8px">  
		<form id="ff_plandetail" class="easyui-form" method="post" action="/erp/plandetail/save.yy" data-options="novalidate:false"> 
			<table>
				<tr> 
					<td>计划单号:</td>
					<td><input class="easyui-textbox" id="pId" name="pId" data-options="readonly:true,width:200" /></td> 
					<td>制单时间:</td>
					<td><input class="easyui-datebox" id="pInitime" name="pInitime" data-options="readonly:true,width:200" /></td> 
					<td>计划机构:</td>
					<td><input class="easyui-combobox" id="oId" name="oId" data-options="readonly:true,width:200" /></td> 
				</tr>
				<tr> 
					<td>计划仓库:</td>
					<td><input class="easyui-textbox" id="pRid" name="pRid" data-options="readonly:true,width:200" /></td> 
					<td>制单人:</td>
					<td><input class="easyui-combobox" id="pCreator" name="pCreator" data-options="readonly:true,width:200" /></td> 
					<td>供应商ID:</td>
					<td><input class="easyui-combobox" id="pCid" name="pCid" data-options="readonly:true,width:200" /></td> 
				</tr>
				<tr> 
					<td>审核状态:</td>
					<td><input class="easyui-combobox" id="pState" name="pState" data-options="readonly:true,width:200" /></td> 
					<td>备注:</td>
					<td><input class="multiline" id="pMemo" name="pMemo" data-options="readonly:true,width:200" /></td> 
					<td>审核时间:</td>
					<td><input class="easyui-datebox" id="pChktime" name="pChktime" data-options="readonly:true,width:200" /></td> 
				</tr>
					<tr id="tr_approve1" style="background-color:#dddddd;display: none;font-weight:bold;"> 
						<td id="td_approve_d1"></td>
						<td id="td_approve_u1" style="padding:5px 8px;"></td> 
						<td id="td_approve_d2"></td>
						<td id="td_approve_u2" style="padding:5px 8px;"></td> 
						<td id="td_approve_d3"></td>
						<td id="td_approve_u3" style="padding:5px 8px;"></td> 
					</tr>
					<tr id="tr_approve2" style="background-color:#dddddd;display: none;font-weight:bold;"> 
						<td id="td_approve_d4"></td>
						<td id="td_approve_u4" style="padding:5px 8px;"></td> 
						<td id="td_approve_d5" ></td>
						<td id="td_approve_u5" style="padding:5px 8px;"></td> 
						<td id="td_approve_d6" ></td>
						<td id="td_approve_u6" style="padding:5px 8px;"	></td>  
					</tr>
				</table>  
			<!--审核情况-->  
			<input type="hidden" id="moduleId" name="moduleId" value="${moduleId}" />  
			<input type="hidden" id="add" name="add" />  
			<input type="hidden" id="del" name="del" />  
			<input type="hidden" id="modify" name="modify" /> 
		</form>  
		</div>
	</div>  
	<table id="dg_plandetail" class="easyui-datagrid" style="width:100%;height:auto;border-width:0;"
			data-options="
				singleSelect: true, 
				rownumbers: true,
				toolbar: '#tb_plandetail', 
				onClickCell: onClickCell, 
				onEndEdit:onEndEdit,
				fitColumns:true, 
				border:0">
		<thead>  
			<tr>
				<th data-options="field:'pdId',width:50,editor:'textbox',halign: 'center',hcolor:'#ff0000',styler:setReadColor">计划明细ID</th>
				<th data-options="field:'pId',width:50,editor:'textbox',halign: 'center',hcolor:'#ff0000',styler:setReadColor">计划单号</th>
				<th data-options="field:'pdWid',width:50,editor:'textbox',halign: 'center',hcolor:'#ff0000',styler:setReadColor">商品编号</th>
				<th data-options="field:'pdPrice',width:50,editor:'textbox',halign: 'center',hcolor:'#ff0000',styler:setReadColor">计划进价</th>
				<th data-options="field:'pdAmount',width:50,editor:'textbox',halign: 'center',hcolor:'#ff0000',styler:setReadColor">计划数量</th>
				<th data-options="field:'pdMemo',width:50,editor:'textbox',halign: 'center',hcolor:'#ff0000',styler:setReadColor">备注</th>
				<th data-options="field:'pdInitime',width:50,editor:'textbox',halign: 'center',hcolor:'#ff0000',styler:setReadColor">创建时间</th>
			</tr>  
		</thead> 
	</table>
  
	<div id="tb_plandetail" style="height:auto">
		<a id="append_detail" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="appendDgDetail()">添加明细</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeDgDetail()">删除明细</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="submitForm()">保存</a>
		<a id="a_approve" href="javascript:void(0)" class="easyui-linkbutton" onclick="showApproveDialog(1,'采购计划','${pId}')" style="display: none;">审批</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-back',plain:true" onclick="callback('plandetail')">返回</a> 
	</div>  
	<script type="text/javascript"> 
	$(function(){
		});
		
	</script>  
  
