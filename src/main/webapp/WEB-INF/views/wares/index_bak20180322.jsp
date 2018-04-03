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
			 toolbar="#tb_wares" data-options="singleSelect:true,fitColumns:true,rownumbers:true,pagination:true"> 
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
	<div id="dlg_wares" class="easyui-dialog" title="新增商品信息" style="width:550px;height:550px;padding:10px;"
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
		<form id="ff_wares" class="easyui-form" method="post" action="/erp/wares/save.yy" data-options="novalidate:false">
			<fieldset style="border:solid 1px #aaa;margin-top:8px;position:relative;">
				<legend style="color:blue"><strong>基本信息</strong></legend>
				<table>
					<!-- 基本信息 -->
					<tr>
						<td>商品编码:</td>
						<td><input class="easyui-validatebox" type="text" id="wId" name="wId" data-options="events:{blur:isExistId},required:true"/></td>
						<td>品类编码:</td>
						<td><input class="easyui-textbox" type="text" name="wClassid" data-options="required:true,validType:{length:[0,20]}"/></td>
					</tr>
					<tr>
						<td>商品类型:</td>
						<td><input class="easyui-textbox" type="text" name="wType" data-options="required:false"/></td>
						<td>通用名:</td>
						<td><input class="easyui-textbox" type="text" name="wGenname" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>商品名:</td>
						<td><input class="easyui-textbox" type="text" name="wTraname" data-options="required:false"/></td>
						<td>商品助记码:</td>
						<td><input class="easyui-textbox" type="text" name="wZjm" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>商品条形码:</td>
						<td><input class="easyui-textbox" type="text" name="wBarcode" data-options="required:false,validType:'number'"/></td>
						<td>批准文号:</td>
						<td><input class="easyui-textbox" type="text" name="wApprovalno" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>商品单位:</td>
						<td><input class="easyui-textbox" type="text" name="wUnit" data-options="required:false"/></td>
						<td>商品规格:</td>
						<td><input class="easyui-textbox" type="text" name="wStandard" data-options="required:false"/></td>
						<!-- <td>
							<select class="easyui-combobox" name="wStandard" data-options="panelHeight:'auto'">
								<option value="ar">Arabic</option>
								<option value="bg">Bulgarian</option>
								<option value="ca">Catalan</option>
								<option value="zh-cht">Chinese Traditional</option>
								<option value="cs">Czech</option>
								<option value="da">Danish</option>
								<option value="nl">Dutch</option>
								<option value="en" selected="selected">English</option>
								<option value="et">Estonian</option>
								<option value="fi">Finnish</option>
							</select>
						</td> -->
					</tr>
					<tr>
						<td>生产企业:</td>
						<td><input class="easyui-textbox" type="text" name="wBusiness" data-options="required:false"/></td>
						<td>生产产地:</td>
						<td><input class="easyui-textbox" type="text" name="wPlace" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>件装量:</td>
						<td><input class="easyui-textbox" type="text" name="wMax" data-options="required:false"/></td>
						<td>件单位:</td>
						<td><input class="easyui-textbox" type="text" name="wMaxunit" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>最小包装:</td>
						<td><input class="easyui-textbox" type="text" name="wMin" data-options="required:false"/></td>
						<td>最小包装单位:</td>
						<td><input class="easyui-textbox" type="text" name="wMinunit" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>中包装:</td>
						<td><input class="easyui-textbox" type="text" name="wMid" data-options="required:false"/></td>
						<td>中包装单位:</td>
						<td><input class="easyui-textbox" type="text" name="wMidunit" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>商品状态:</td>
						<td><input class="easyui-textbox" type="text" name="wStatus" data-options="required:false"/></td>
						<td>创建人:</td>
						<td><input class="easyui-textbox" type="text" name="wCreator" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>创建时间:</td>
						<td><input class="easyui-datebox" type="text" name="wInitime" data-options="required:false"/></td>
					</tr>
				</table>
			</fieldset>

			<!-- 扩展信息 -->
			<fieldset style="border:solid 1px #aaa;margin-top:8px;position:relative;">
				<legend style="color:blue"><strong>扩展信息</strong></legend>
				<table>
					<tr>
						<td>贮存条件:&nbsp;&nbsp;&nbsp;</td>
						<td><input class="easyui-textbox" type="text" name="wStoreage" data-options="required:false"/></td>
						<td>医保编码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><input class="easyui-textbox" type="text" name="wMedicalId" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>功能疗效:</td>
						<td><input class="easyui-textbox" type="text" name="wFunction" data-options="required:false"/></td>
						<td>医保名称:</td>
						<td><input class="easyui-textbox" type="text" name="wMedicalName" data-options="required:false"/></td>
						
					</tr>
					<tr>
						<td>注册证号:</td>
						<td><input class="easyui-textbox" type="text" name="wRegId" data-options="required:false"/></td>
						<td>注册证效期:</td>
						<td><input class="easyui-datebox" type="text" name="wRegExpdate" data-options="required:false"/></td>
					</tr>
				</table>
			</fieldset>
			<!-- 价格信息 -->
			<fieldset style="border:solid 1px #aaa;margin-top:8px;position:relative;">
				<legend style="color:blue"><strong>价格信息</strong></legend>
				<table>
					<tr>
						<td>成本价:</td>
						<td><input class="easyui-textbox" type="text" name="wCostprice" data-options="required:false"/></td>
						<td>零售价:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><input class="easyui-textbox" type="text" name="wSaleprice" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>会员价:</td>
						<td><input class="easyui-textbox" type="text" name="wVipprice" data-options="required:false"/></td>
						<td>批发价:</td>
						<td><input class="easyui-textbox" type="text" name="wSellprice" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>拆零零售价:</td>
						<td><input class="easyui-textbox" type="text" name="wMinSaleprice" data-options="required:false"/></td>
						<td>拆零会员价:</td>
						<td><input class="easyui-textbox" type="text" name="wMinVipprice" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>拆零批发价:</td>
						<td><input class="easyui-textbox" type="text" name="wMinSellprice" data-options="required:false"/></td>
						<td>标准零售价:</td>
						<td><input class="easyui-textbox" type="text" name="wStandardSaleprice" data-options="required:false"/></td>
					</tr>
					<tr>
						<td>标准批发价:</td>
						<td><input class="easyui-textbox" type="text" name="wStandardSellprice" data-options="required:false"/></td>
					</tr>
				</table>
			</fieldset>
		</form>
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
	function modify_wares(){
        var row = $('#dg_wares').datagrid('getSelected');
        if (row== null){
            $.messager.alert('Info', "请选择需要更新的行", 'error');
            return ;
        }else{
            dialog_open();
            $("#wId").val(row.wId);
            $("#wClassid").textbox('setValue',row.wClassid);
            $("#wType").textbox('setValue',row.wType);
            $("#wGenname").textbox('setValue',row.wGenname);
            $("#wTraname").textbox('setValue',row.wTraname);
            $("#wZjm").textbox('setValue',row.wZjm);
            $("#wBarcode").textbox('setValue',row.wBarcode);
            $("#wApprovalno").textbox('setValue',row.wApprovalno);
            $("#wUnit").textbox('setValue',row.wUnit);
            $("#wStandard").combobox('setValue',row.wStandard);
            $("#wBusiness").textbox('setValue',row.wBusiness);
            $("#wPlace").textbox('setValue',row.wPlace);
            $("#wMax").textbox('setValue',row.wMax);
            $("#wMaxunit").textbox('setValue',row.wMaxunit);
            $("#wMin").textbox('setValue',row.wMin);
            $("#wMinunit").textbox('setValue',row.wMinunit);
            $("#wMid").textbox('setValue',row.wMid);
            $("#wMidunit").textbox('setValue',row.wMidunit);
            $("#wStatus").textbox('setValue',row.wStatus);
            $("#wCreator").textbox('setValue',row.wCreator);
            $("#wStoreage").textbox('setValue',row.wStoreage);
            $("#wMedicalId").textbox('setValue',row.wMedicalId);
            $("#wMedicalName").textbox('setValue',row.wMedicalName);
            $("#wFunction").textbox('setValue',row.wFunction);
            $("#wRegId").textbox('setValue',row.wRegId);
            $("#wRegExpdate").textbox('setValue',row.wRegExpdate);
            $("#wCostprice").textbox('setValue',row.wCostprice);
            $("#wSaleprice").textbox('setValue',row.wSaleprice);
            $("#wVipprice").textbox('setValue',row.wVipprice);
            $("#wSellprice").textbox('setValue',row.wSellprice);
            $("#wMinSaleprice").textbox('setValue',row.wMinSaleprice);
            $("#wMinVipprice").textbox('setValue',row.wMinVipprice);
            $("#wMinSellprice").textbox('setValue',row.wMinSellprice);
            $("#wStandardSaleprice").textbox('setValue',row.wStandardSaleprice);
            $("#wStandardSellprice").textbox('setValue',row.wStandardSellprice);
        }

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