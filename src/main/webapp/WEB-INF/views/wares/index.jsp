<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
	<div id="tb_wares" style="padding:5px;height:auto">
		<div id="wares_tool" style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add_wares()">添加商品</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="modify_wares()">修改商品</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del_wares()">删除商品</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
				日期: <input class="easyui-datebox" style="width:80px" />
				至:<input class="easyui-datebox" style="width:80px" />
				名称: <input class="easyui-textbox" style="width:100px" id="tname" />
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="find_wares()">查找</a>
		</div>
		
	</div>
	<table id="dg_wares" class="easyui-datagrid" style="width:100%;height:auto;"
			 toolbar="#tb_wares" data-options="singleSelect:true,fitColumns:true,rownumbers:true,pagination:true,onDblClickRow:dblClickRow"> 
		<thead>
			<tr>
				<th field="wId" width="60">商品编码</th>
				<th field="wClassid" width="60">品类编码</th>
				<th field="wType" align="right" width="60">商品类型</th>
				<th field="wGenname" align="right" width="80">通用名</th>
				<th field="wTraname" width="160">商品名</th>
				<th field="wZjm" width="50">商品助记码</th>
				<th field="wBarcode" width="60">商品条形码</th>
				<th field="wApprovalno" width="50">批准文号</th>
				<th field="wUnit" width="50">商品单位</th>
				<th field="wStandard" width="50">商品规格</th>
				<th field="wBusiness" width="50">生产企业</th>
				<th field="wPlace" width="50">生产产地</th>
				<th field="wStatus" width="50">商品状态</th>
				<th field="wCreator" width="50">创建人</th>
				<th field="wInitime" width="60" formatter="formatDatebox">创建日期</th>
				<th field="wCostprice" width="50">成本价</th>
				<th field="wSaleprice" width="50">零售价</th>
				<th field="wSellprice" width="50">批发价</th>
			</tr>
		</thead>
	</table>
	<div id="dlg_wares" class="easyui-dialog" title="新增商品信息" style="width:550px;height:550px;"
				 data-options="closed:true,
										buttons: [{
											text:'保存',
											iconCls:'icon-ok',
											handler:function(){
												submit_form();
											}
										},{
											text:'取消',
											iconCls:'icon-cancel',
											handler:function(){
												dialog_close();
											}
										}]">
		<div class="easyui-tabs" data-options="fit:true,plain:true,border:false" style="margin-top:5px;">
			<div title="基础信息" style="padding:10px;">
				<table>
					<!-- 基本信息 -->
					<tr>
						<td>商品编码:</td>
						<td><input class="easyui-validatebox" type="text" id="wId" name="wId" data-options="events:{blur:isExistId},required:true"/></td>
						<td>品类编码:</td>
						<td><input class="easyui-textbox" type="text" id="wClassid" name="wClassid" data-options="required:true,validType:{length:[0,20]}"/></td>
					</tr>
					<tr>
						<td>商品类型:</td>
						<td><input class="easyui-textbox" type="text" id="wType" name="wType" data-options="required:false"/></td>
						<td>通用名:</td>
						<td><input class="easyui-textbox" type="text" id="wGenname" name="wGenname" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>商品名:</td>
						<td><input class="easyui-textbox" type="text" id="wTraname" name="wTraname" data-options="required:false"/></td>
						<td>商品助记码:</td>
						<td><input class="easyui-textbox" type="text" id="wZjm" name="wZjm" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>商品条形码:</td>
						<td><input class="easyui-textbox" type="text" id="wBarcode" name="wBarcode" data-options="required:false,validType:'number'"/></td>
						<td>批准文号:</td>
						<td><input class="easyui-textbox" type="text" id="wApprovalno" name="wApprovalno" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>商品单位:</td>
						<td><input class="easyui-textbox" type="text" id="wUnit" name="wUnit" data-options="required:false"/></td>
						<td>商品规格:</td>
						<td><input class="easyui-textbox" type="text" id="wStandard" name="wStandard" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>生产企业:</td>
						<td><input class="easyui-textbox" type="text" id="wBusiness" name="wBusiness" data-options="required:false"/></td>
						<td>生产产地:</td>
						<td><input class="easyui-textbox" type="text" id="wPlace" name="wPlace" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>件装量:</td>
						<td><input class="easyui-textbox" type="text" id="wMax" name="wMax" data-options="required:false"/></td>
						<td>件单位:</td>
						<td><input class="easyui-textbox" type="text" id="wMaxunit" name="wMaxunit" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>最小包装:</td>
						<td><input class="easyui-textbox" type="text" id="wMin" name="wMin" data-options="required:false"/></td>
						<td>最小包装单位:</td>
						<td><input class="easyui-textbox" type="text" id="wMinunit" name="wMinunit" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>中包装:</td>
						<td><input class="easyui-textbox" type="text" id="wMid" name="wMid" data-options="required:false"/></td>
						<td>中包装单位:</td>
						<td><input class="easyui-textbox" type="text" id="wMidunit" name="wMidunit" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>商品状态:</td>
						<td><input class="easyui-textbox" type="text" id="wStatus" name="wStatus" data-options="required:false"/></td>
						<td>创建人:</td>
						<td><input class="easyui-textbox" type="text" id="wCreator" name="wCreator" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>创建时间:</td>
						<td><input class="easyui-datebox" type="text" id="wInitime" name="wInitime" data-options="required:false"/></td>
					</tr>
				</table>
			</div>
			<div title="零售价格信息" style="padding:10px;">
				<table>
					<tr>
						<td>成本价:</td>
						<td><input class="easyui-textbox" type="text" id="wCostprice" name="wCostprice" data-options="readonly:true"/></td>
						<td>零售价:</td>
						<td><input class="easyui-textbox" type="text" id="wsg.wSaleprice" name="wsg.wSaleprice" data-options="readonly:true"/></td>
					</tr>
					<tr>
						<td>会员价:</td>
						<td><input class="easyui-textbox" type="text" id="wsg.wVipprice" name="wsg.wVipprice" data-options="readonly:true"/></td>
						<td>批发价:</td>
						<td><input class="easyui-textbox" type="text" id="wsg.wSellprice" name="wsg.wSellprice" data-options="readonly:true"/></td>
					</tr>
					<tr>
						<td>拆零零售价:</td>
						<td><input class="easyui-textbox" type="text" id="wsg.wMinSaleprice" name="wsg.wMinSaleprice" data-options="readonly:true"/></td>
						<td>拆零会员价:</td>
						<td><input class="easyui-textbox" type="text" id="wsg.wMinVipprice" name="wsg.wMinVipprice" data-options="readonly:true"/></td>
					</tr>
					<tr>
						<td>拆零批发价:</td>
						<td><input class="easyui-textbox" type="text" id="wsg.wMinSellprice" name="wsg.wMinSellprice" data-options="readonly:true"/></td>
						<td>标准零售价:</td>
						<td><input class="easyui-textbox" type="text" id="wsg.wStandardSaleprice" name="wsg.wStandardSaleprice" data-options="readonly:true"/></td>
					</tr>
					<tr>
						<td>标准批发价:</td>
						<td><input class="easyui-textbox" type="text" id="wsg.wStandardSellprice" name="wsg.wStandardSellprice" data-options="readonly:true"/></td>
					</tr>
				</table>
			</div>
			<div title="批发价格信息" style="padding:10px;">
				<div style="margin-bottom:20px">
					<div class="div_table_tr">
						<span>成本价:</span>
						<span><input class="easyui-textbox" type="text" id="wCostprice" name="wCostprice" data-options="readonly:true"/></span>
						<span>零售价:</span>
						<span><input class="easyui-textbox" type="text" id="wwg.wSaleprice" name="wwg.wSaleprice" data-options="readonly:true"/></span>
					</div>
					<div class="div_table_tr">
						<span>会员价:</span>
						<span><input class="easyui-textbox" type="text" id="wVipprice" name="wVipprice" data-options="readonly:true"/></span>
						<span>批发价:</span>
						<span><input class="easyui-textbox" type="text" id="wSellprice" name="wSellprice" data-options="readonly:true"/></span>
					</div>
					<div class="div_table_tr">
						<span>拆零零售价:</span>
						<span><input class="easyui-textbox" type="text" id="wMinSaleprice" name="wMinSaleprice" data-options="readonly:true"/></span>
						<span>拆零会员价:</span>
						<span><input class="easyui-textbox" type="text" id="wMinVipprice" name="wMinVipprice" data-options="readonly:true"/></span>
					</div>
					<div class="div_table_tr">
						<span>拆零批发价:</span>
						<span><input class="easyui-textbox" type="text" id="wMinSellprice" name="wMinSellprice" data-options="readonly:true"/></span>
						<span>标准零售价:</span>
						<span><input class="easyui-textbox" type="text" id="wStandardSaleprice" name="wStandardSaleprice" data-options="readonly:true"/></span>
					</div>
					<div class="div_table_tr">
						<span>标准批发价:</span>
						<span><input class="easyui-textbox" type="text" id="wStandardSellprice" name="wStandardSellprice" data-options="readonly:true"/></span>
					</div>
				</div>
				
			</div>
			<div title="品类信息" style="padding:10px;">品类信息</div>
			<div title="扩展信息" style="padding:10px;">
				<table>
					<tr>
						<td>贮存条件:&nbsp;&nbsp;&nbsp;</td>
						<td><input class="easyui-textbox" type="text" id="wStoreage" name="wStoreage" data-options="required:false"/></td>
						<td>医保编码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><input class="easyui-textbox" type="text" id="wMedicalId" name="wMedicalId" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>功能疗效:</td>
						<td><input class="easyui-textbox" type="text" id="wFunction" name="wFunction" data-options="required:false"/></td>
						<td>医保名称:</td>
						<td><input class="easyui-textbox" type="text" id="wMedicalName" name="wMedicalName" data-options="required:false"/></td>
						
					</tr>
					<tr>
						<td>注册证号:</td>
						<td><input class="easyui-textbox" type="text" id="wRegId" name="wRegId" data-options="required:false"/></td>
						<td>注册证效期:</td>
						<td><input class="easyui-datebox" type="text" id="wRegExpdate" name="wRegExpdate" data-options="required:false"/></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	
	
	<script>
	$(function(){
		init();
	});
	function init() {
        $('#dg_wares').datagrid({
            url: '/erp/wares/dg_find.yy'
        });
    }
    function dialog_open(){
        $('#dlg_wares').dialog('open');
    }
    function dialog_close(){
        $('#dlg_wares').dialog('close');
    }
	function add_wares(){
        dialog_open();
	}
	function dblClickRow(index,data){
		if(data.wId > 0 ){
			editRow(data.wId);
		}else{
			$.messager.alert('Info', "请双击需要更新的行", 'error');
		}
	}
	
	function modify_wares(){
        var row = $('#dg_wares').datagrid('getSelected');
        if (row== null){
            $.messager.alert('Info', "请选择需要更新的行", 'error');
            return ;
        }else{
        	editRow(row.wId)
        }
	}
	
	function editRow(wId){
		$("#wId").val(wId);
        dialog_open();
        $.post("/erp/wares/findbyid_json.yy",
                {wId:wId},
                function(data){
                    if(data != ""){
                        $("#wClassid").textbox('setValue',data.wClassid);
                        $("#wType").textbox('setValue',data.wType);
                        $("#wGenname").textbox('setValue',data.wGenname);
                        $("#wTraname").textbox('setValue',data.wTraname);
                        $("#wZjm").textbox('setValue',data.wZjm);
                        $("#wBarcode").textbox('setValue',data.wBarcode);
                        $("#wApprovalno").textbox('setValue',data.wApprovalno);
                        $("#wUnit").textbox('setValue',data.wUnit);
                        $("#wStandard").textbox('setValue',data.wStandard);
                        $("#wBusiness").textbox('setValue',data.wBusiness);
                        $("#wPlace").textbox('setValue',data.wPlace);
                        $("#wMax").textbox('setValue',data.wMax);
                        $("#wMaxunit").textbox('setValue',data.wMaxunit);
                        $("#wMin").textbox('setValue',data.wMin);
                        $("#wMinunit").textbox('setValue',data.wMinunit);
                        $("#wMid").textbox('setValue',data.wMid);
                        $("#wMidunit").textbox('setValue',data.wMidunit);
                        $("#wStatus").textbox('setValue',data.wStatus);
                        $("#wCreator").textbox('setValue',data.wCreator);
                        $("#wStoreage").textbox('setValue',data.wStoreage);
                        $("#wMedicalId").textbox('setValue',data.wMedicalId);
                        $("#wMedicalName").textbox('setValue',data.wMedicalName);
                        $("#wFunction").textbox('setValue',data.wFunction);
                        $("#wRegId").textbox('setValue',data.wRegId);
                        $("#wRegExpdate").textbox('setValue',data.wRegExpdate);
                        $("#wCostprice").textbox('setValue',data.wCostprice);
                        $("#wSaleprice").textbox('setValue',data.wSaleprice);
                        $("#wVipprice").textbox('setValue',data.wVipprice);
                        $("#wSellprice").textbox('setValue',data.wSellprice);
                        $("#wMinSaleprice").textbox('setValue',data.wMinSaleprice);
                        $("#wMinVipprice").textbox('setValue',data.wMinVipprice);
                        $("#wMinSellprice").textbox('setValue',data.wMinSellprice);
                        $("#wStandardSaleprice").textbox('setValue',data.wStandardSaleprice);
                        $("#wStandardSellprice").textbox('setValue',data.wStandardSellprice);
                    }
                }
         );
	}
	
	function del_wares(){
        var row = $('#dg_wares').datagrid('getSelected');
        if (row== null){
            $.messager.alert('Info', "请选择需要删除的行", 'error');
            return ;
        }else{
            var eid = row.eId;
            $.post("/erp/wares/del_json.yy",
                {eid:eid},
                function(data){
                    if(data > 0){
                        $.messager.alert('Info', "商品已删除", 'error');
                        init();
                    }
                }
            );
        }
	}
	
	function find_wares(){
		var url = '/erp/wares/find_json.yy?wTraname='+$("#tname").val() ;
		$('#dg_wares').datagrid({
			url: url
		});
	}

    function submitForm(){
		//第二种
        $('#ff_wares').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                if(rj.status == 1){
                    dialog_close();
                    $("#ff_wares").form('clear');
                    init();
                }
            }
        });
    }

    function isExistId(){
        var wid = $('#wId').val();
        $.post("/erp/wares/checkId_json.yy",
            {wid:wid},
            function(data){
                if(data == 1){
//                    $.messager.alert('Info', "商品编号已存在", 'error');
                    $('#wId').attr("isValid ",false);
                    $('#wId').attr("missingMessage ","商品编号已存在");
                }else{
					$('#wId').attr("isValid ",true);
				}
            }
        );
    }
	</script>