<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	    <form id="ff_wholesale" class="easyui-form" method="post" action="/erp/wholesale/save.yy" data-options="novalidate:false">
	    	<table>
	    		<tr>
	    			<td>批发单号:</td>
	    			<td><input class="easyui-textbox" id="wsId" name="wsId" data-options="readonly:true,width:200" /></td>
	    			<td>制单时间:</td>
	    			<td><input class="easyui-datebox" id="wsDate" name="wsDate" data-options="required:true,width:100"/></td>

					<td>制单人:</td>
					<td>
						<inpu style="width:200px;" class="easyui-combobox"  id="wsCreator" name="wsCreator" data-options="
							required:true,
							panelHeight: '125',
							width:'100'"/>
					</td>
	    		</tr>
				<tr>
					<td>客户名称:</td>
					<td>
						<select style="width:200px;" class="easyui-combobox" id="cbId" name="cbId" data-options="required:true,panelHeight:'auto'"></select>
					</td>
					<td></td>
					<td></td>
					<td>出库仓库:</td>
					<td>
						<select style="width:200px;" class="easyui-combobox" id="shId" name="shId" data-options="required:true,panelHeight:'auto'"></select>
					</td>
				</tr>
	    		<tr>
	    			<td>收货地址:</td>
	    			<td>
	    				<select style="width:200px;" class="easyui-combobox" id="cbStorehouse" name="cbStorehouse" data-options="required:true,panelHeight:'auto'"></select>
	    			</td>
					<td>提货方式:</td>
					<td>
						<select style="width:100px;" class="easyui-combobox" id="wsReceiveWay" name="wsReceiveWay">
							<option value="1">货运</option>
							<option value="2">自提</option>
							<option value="3">配送</option>
							<option value="4">提送</option>
						 </select>
					</td>
					<td>付款方式:</td>
					<td>
						<select style="width:200px;" class="easyui-combobox" id="wsPayWay" name="wsPayWay" data-options="panelHeight:'auto'">
							<option value="1">月结</option>
							<option value="2">货到付款</option>
							<option value="3">现金</option>
							<option value="4">刷卡</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>价格组ID:</td>
					<td>
						<select style="width:200px;" class="easyui-combobox" id="pId" name="pId" data-options="panelHeight:'auto'"></select>
					</td>
					<td>发票类型:</td>
					<td>
						<select style="width:100px;" class="easyui-combobox"  id="wsInvoiceType" name="wsInvoiceType" data-options="
							panelHeight: 'auto'">
							<option value="1">增值税专用发票</option>
							<option value="2">普通发票</option>
							<option value="3">定额发票</option>
							<option value="4">机打发票</option>
						</select>
					</td>
					<td>业务员:</td>
					<td>
						<select style="width:200px;" class="easyui-combobox" id="eId" name="eId" data-options="panelHeight:'auto'"></select>
					</td>
				</tr>
	    		<tr>
	    			<td>审核状态:</td>
	    			<td>
						<select style="width:200px;" class="easyui-combobox" name="wsState" data-options="panelHeight:'auto'">
							<option value="1">正常</option>
							<option value="2">审核中</option>
							<option value="3">审核完成</option>
							<option value="4">驳回</option>
							<option value="5">撤销</option>
							<option value="6">作废</option>
							<option value="0">无效</option>
						</select>
					</td>
	    			<td>审核时间:</td>
	    			<td><input class="easyui-datebox" name="whChtime" data-options="required:false,width:100"></input></td>
	    			<td>备注:</td>
	    			<td><input class="easyui-textbox" name="wsRemark" data-options="required:false,width:200"></input></td>
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
						<td id="td_approve_d5"></td>
						<td id="td_approve_u5" style="padding:5px 8px;"></td>
						<td id="td_approve_d6"></td>
						<td id="td_approve_u6" style="padding:5px 8px;"	></td>
					</tr>
	    		</table>
			<!--审核情况-->
			<!--
			<div style="text-align:center;padding:5px;width:60%;">
				<a id="a_approve" href="javascript:void(0)" class="easyui-linkbutton" onclick="showApproveDialog(1,'批发单据','${wsId}')" style="display: none;">审批</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清空</a>
			</div>
			-->
			<input type="hidden" id="moduleId" name="moduleId" value="${moduleId}" />
			<input type="hidden" id="add" name="add" />
			<input type="hidden" id="del" name="del" />
			<input type="hidden" id="modify" name="modify" />
	      </form>
	    </div>
	</div>
	<table id="dg_wholesale" class="easyui-datagrid" style="width:100%;height:auto;border-width:0;"
            data-options="
                singleSelect: true,
                rownumbers: true,
                toolbar: '#tb_wholesale',
                onClickCell: onClickCell,
                onEndEdit:onEndEdit,
				fitColumns:true,
				border:0">
        <thead>
            <tr>
                <th data-options="field:'wId',width:50,editor:'textbox',halign: 'center',hcolor:'#ff0000',styler:setReadColor">商品ID</th>
                <th data-options="field:'wTraname',width:120,editor:'textbox',halign: 'center',hcolor:'#ff0000'">商品名称</th>
                <th data-options="field:'wStandard',width:50,editor:'textbox',halign: 'center',styler:setReadColor">商品规格</th>
                <th data-options="field:'wUnit',width:40,editor:'textbox',halign: 'center',styler:setReadColor">单位</th>
				<th data-options="field:'wBusiness',width:130,editor:'textbox',halign: 'center',styler:setReadColor">生产厂家</th>
				<th data-options="field:'wPlace',width:50,editor:'textbox',halign: 'center',styler:setReadColor">产地</th>
				<th data-options="field:'wsdPrice',width:50,editor:'textbox',halign: 'center',hcolor:'#ff0000',styler:setReadColor">批发价</th>
				<th data-options="field:'batchNo',width:100,editor:'textbox',halign: 'center',styler:setReadColor">批号</th>
				<th data-options="field:'validDate',width:70,editor:'textbox',halign: 'center',styler:setColor" formatter="formatDateGrid">效期</th>
				<th data-options="field:'spCode',width:80,editor:'textbox',halign: 'center',styler:setReadColor">货位</th>
				<th data-options="field:'wsdAmount',width:50,editor:'textbox',halign: 'center',hcolor:'#ff0000'">数量</th>
				<th data-options="field:'wsdMoney',width:70,editor:'textbox',halign: 'center',hcolor:'#ff0000'">金额</th>
				<th data-options="field:'sbId',width:50,editor:'textbox',halign: 'center',styler:setReadColor">批次</th>
				<th data-options="field:'produceDate',width:70,editor:'textbox',halign: 'center'" formatter="formatDateGrid">生产日期</th>
				<th data-options="field:'wsdIndex',width:40,editor:'textbox',halign: 'center',styler:setReadColor">序号</th>
				<th data-options="field:'sId',width:40,editor:'textbox',halign: 'center',hidden:true">库存ID</th>
				<th data-options="field:'sdId',width:40,editor:'textbox',halign: 'center',hidden:true">库存明细ID</th>
			</tr>
        </thead>
    </table>
 
    <div id="tb_wholesale" style="height:auto">
        <a id="append_detail" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="appendDgDetail()">添加明细</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeDgDetail()">删除明细</a>
		<!--
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">保存</a>
    	-->
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="submitForm()">保存</a>
		<a id="a_approve" href="javascript:void(0)" class="easyui-linkbutton" onclick="showApproveDialog(1,'批发单据','${wsId}')" style="display: none;">审批</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-back',plain:true" onclick="callback('wholesale')">返回</a>
    </div>
    
    <div id="findWare_div" style="position:absolute;display:none;z-index:1;width:820px;height:auto;max-height: 200px;closable:true;background-color:#ffffff;overflow-y:auto;border:solid #E0ECFF 1px;">
		<div class="findWare_div_table">
			<div class="table-header-group">
				<ul>
					<li>商品ID</li>
					<li>商品名称</li>
					<li>商品规格</li>
					<li>单位</li>
					<li>生产厂家</li>
					<li>产地</li>
					<li>批号</li>
					<li>效期</li>
					<li>货位</li>
					<li>数量</li>
					<li>批次</li>
					<li>生产日期</li>
				</ul>
			</div>
			<div class="table-row-group">

			</div>
		</div>
	</div>

	<script type="text/javascript">
	$(function(){
		//$("#wsId").css("background","#F5F5F5");
		//$('#wsId').textbox('textbox').css('background','#F5F5F5');
        //加载客户:
        $("#cbId").combobox({
            url: '/erp/customer/find_json.yy',
            method: 'post',
            valueField: 'cbId',
            textField: 'cbFullname'
        });
		
		//$('#cbId').combobox('reload','/erp/customer/find_json.yy');
        //加载入库仓库
        $("#shId").combobox({
            url: '/erp/storehouse/find_json.yy',
            method: 'post',
            valueField: 'shId',
            textField: 'shName'
        });
        //加载制单人
        $("#wsCreator").combobox({
            url:'/erp/employee/find_json.yy',
            valueField: 'eId',
            textField: 'eName'
        });
        //加载业务员
        $("#eId").combobox({
            url:'/erp/employee/find_json.yy',
            valueField: 'eId',
            textField: 'eName'
        });
		var wsId = '${wsId}';
//		alert("--wsId:"+wsId);
		if(wsId == ""){//新增
            var mydate = new Date();
            $("#wsDate").val(mydate);
            //appendDgDetail();
            //$("#append_detail").click();
		}else{//不为空,既为修改
//            var url = '/erp/wholesale/add_json.yy?wsId='+wsId;
//            $('#ff_wholesale').form('load', url);
//            $('#wsId').prop('readonly',true);
//            $('#wsId').validatebox({required: false});
//            $("#wsId").removeAttr("onblur");
//
            var moduleId = '${moduleId}';
//            alert("---moduleId---"+moduleId);
			if(moduleId != ""){
                showApprove(moduleId,wsId);
            }

            // datagrid 填充
            $.post("/erp/wholesale/add_json.yy",
                {wsId:wsId},
                function(data){
//                    var wh = eval('(' + data + ')');
                    if(data){
                        //加载表单
                        $('#ff_wholesale').form('load', data);
                        $('#wsId').prop('readonly',true);
                        $('#wsId').validatebox({required: false});
                        $("#wsId").removeAttr("onblur");
                        //加载datagrid
                        $('#dg_wholesale').datagrid("loadData",data.details);

                    }
                }
            );

        }
	});
	//单击单元格事件
    function onClickCell(index, field){
        //alert("--1--onClickCell--"+index+","+field);
        if (editIndex != index){
            if (endEditing()){
                $('#dg_wholesale').datagrid('selectRow', index).datagrid('beginEdit', index);
//                var ed = $('#dg_wholesale').datagrid('getEditor', {index:index,field:field});
//                if (ed){
//                    $(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target);
////                    var obj = $(ed.target).textbox('textbox');
//                    if(field == 'wTraname'){
//                        ///alert("--2--onClickCell--"+index+","+field);
//                        $(ed.target).textbox('textbox').bind('keyup', function(e){
//                            if(e.keyCode != 8){//13回车键,8退格键
//                                var str = $(this).val();
//                                if(str != ""){
//                                    findWare($(this));
//                                }
//                            }
//                        });
//                    }else{
//                       // alert("--3--onClickCell--"+field+","+index);
//                    }
//                }
                setCell(index);
                bindCellKeyEvent(index,field);
                editIndex = index;
            } else {
                setTimeout(function(){
                    $('#dg_wholesale').datagrid('selectRow', editIndex);
                },0);
            }
        }
    }
    //结束编辑
    var editIndex = undefined;
    function endEditing(){
        if (editIndex == undefined){
            return true;
        }
        if ($('#dg_wholesale').datagrid('validateRow', editIndex)){
            $('#dg_wholesale').datagrid('endEdit', editIndex);
            editIndex = undefined;
            return true;
        } else {
            return false;
        }
    }
    /**
     * 输入商品编号或拼音查找商品信息
     */
    function findWare(ed){
        var zjm = $(ed).val();
        $.post("/erp/wares/find_ batch_house.yy",
            {zjm:zjm},
            function(data){
                if(data.length == 0){
                    $("#findWare_div").hide();
                    return ;
                }

//                $('#dg_findWare_div').datagrid("loadData",data);
                //alert(data);
//                $("#findWare_div").empty();
                $(".table-row-group").empty();
                //$("#findWare_div").css({position: "absolute",'top':top+10,'left':left,'z-index':2});
                var tbody = "";
                //1.清空原来的operType这个combobox中的选项
                //$("#wClassid").combobox("clear");

                //下面使用each进行遍历
                //var options01 = [{text : "等于", value : "eq"},{text : "不等于", value : "ne"}];
                $.each(data,function(n,obj) {
                	var bg =setBgColor(obj.validDate,"");
                	                
                    //tbody += "<option value="+ obj.wId +"> " + obj.wTraname +" - " + obj.wStandard +"</option>";
                    //tbody += "<p style='cursor:pointer' onclick=selectWid('"+ obj.wId +"','"+obj.wTraname+"','"+obj.wStandard+"','"+obj.wUnit+"','"+obj.wBusiness+"','"+obj.wPlace+"','"+obj.wCostprice+"','"+obj.batchNo+"','"+obj.validDate+"','"+obj.spCode+"','"+obj.amount+"','"+obj.sbId+"','"+obj.produceDate+"','"+obj.sId+"','"+obj.sdId+"')> " + obj.wId +" - " + obj.wTraname +" - " + obj.wStandard +" - " + obj.wUnit +" - " + obj.wBusiness +" - " + obj.wPlace +" - " + obj.batchNo +" - " + obj.validDate +" - " + obj.spCode +" - " + obj.amount +" - " + obj.sbId +" - " + obj.produceDate +"</p>";
//                    console.info("n:"+n);
                    tbody += "<ul style='background-color:"+bg+"' id='wares_ul_"+(n+1)+"' onclick=selectWid('"+ obj.wId +"','"+obj.wTraname+"','"+obj.wStandard+"','"+obj.wUnit+"','"+obj.wBusiness+"','"+obj.wPlace+"','"+obj.wCostprice+"','"+obj.batchNo+"','"+obj.validDate+"','"+obj.spCode+"','"+obj.amount+"','"+obj.sbId+"','"+obj.produceDate+"','"+obj.sId+"','"+obj.sdId+"')><li>" + obj.wId +"</li><li>" + obj.wTraname +"</li><li>" + obj.wStandard +"</li><li>" + obj.wUnit +"</li><li>" + obj.wBusiness +"</li><li>" + obj.wPlace +"</li><li>" + obj.batchNo +"</li><li>" + obj.validDate +"</li><li>" + obj.spCode +"</li><li>" + obj.amount +"</li><li>" + obj.sbId +"</li><li>" + obj.produceDate +"</li></ul>";

                });
                //$(ed).combobox({
                //	 panelHeight:'auto',
                //    data:data
                //  });
//                $("#findWare_div").append(tbody);
                $(".table-row-group").append(tbody);
                $("#findWare_div").show();//显示div
            }
        );
    }
    
    function setBgColor(vc,bg){
    	if(vc != undefined && vc != ""){
			var now = new Date();
			var vdt = new Date(vc.substr(0,4)+"-"+vc.substr(4,2)+"-"+vc.substr(6,2));
			var vms = vdt -now ;
			if(vms < 7776000000){//三个月
				//bg= 'background-color:#ff0000;color:#ffee00;';
				bg= '#ffee00';
			}
			if( vms < 15552000000){//半年			
				//bg = 'background-color:#ff0000;';
				bg = '#ff0000';
			}			
		}
		return bg;
    }
    
    //选中商品信息
    function selectWid(wId,wTraname,wStandard,wUnit,wBusiness,wPlace,wsdPrice,batchNo,validDate,spCode,wsdAmount,sbId,produceDate,sId,sdId){
//        alert("---wId:"+wId);
        var flag = findWid(wId,batchNo,sbId);//同一个品种、同一个批号、同一个批次才算是唯一
        if(flag >= 0){
        	// $.messager.alert('提示','【'+wTraname+'】已在明细中第 '+ (flag+1) +" 行.","warning");
            //$.messager.alert('提示','【'+wTraname+'】已在明细中第 '+ (flag+1) +" 行.","warning",function(data){
            	//$("#findWare_div").show();
                //var ul = $("#findWare_div").find("ul:eq(" + (flag+1) + ")");
    			//ul.css("background", "#E8F4FC").siblings().css("background", "");
    			//alert(data);
              //  return false;
            //});
            
        	$.messager.show({
				title:'提示',
				msg:'【'+wTraname+'】已在明细中第 '+ (flag+1) +" 行.",
				showType:'slide',
				showSpeed:1,
				timeout:1000,
				style:{
					right:'',
					bottom:''
				}
			});
        }else{        
	        var editors = $('#dg_wholesale').datagrid('getEditors', editIndex);
	        var o_wId		= editors[0];	//商品ID
	        var o_wTraname		= editors[1];	//商品名称
	        var o_wStandard		= editors[2];	//商品规格
	        var o_wUnit		= editors[3];	//单位
	        var o_wBusiness		= editors[4];	//生产厂家
	        var o_wPlace		= editors[5];	//产地
	        var o_wsdPrice	= editors[6];	//批发价
	        var o_batchNo		= editors[7];	//批号
	        var o_validDate		= editors[8];	//效期
	        var o_spCode		= editors[9];	//货位
	        var o_wsdAmount		= editors[10];	//申请数量
	        var o_wsdMoney		= editors[11];	//金额
	        var o_sbId		= editors[12];	//批次
	        var o_produceDate	= editors[13];	//效期
	        var o_sId	= editors[15];	//库存ID
	        var o_sdId	= editors[16];	//库存明细ID
	
	        $(o_wId.target).textbox('setValue',wId);
	        $(o_wTraname.target).textbox('setValue',wTraname);
	        $(o_wStandard.target).textbox('setValue',wStandard);
	        $(o_wUnit.target).textbox('setValue',wUnit);
	        $(o_wBusiness.target).textbox('setValue',wBusiness);
	        $(o_wPlace.target).textbox('setValue',wPlace);
	        $(o_wsdPrice.target).textbox('setValue',wsdPrice);
	        $(o_batchNo.target).textbox('setValue',batchNo);
	        $(o_validDate.target).textbox('setValue',validDate);
	        $(o_spCode.target).textbox('setValue',spCode);
	        $(o_wsdAmount.target).textbox('setValue',wsdAmount);
	        $(o_sbId.target).textbox('setValue',sbId);
	        $(o_produceDate.target).textbox('setValue',produceDate);
	        $(o_sId.target).textbox('setValue',sId);
	        $(o_sdId.target).textbox('setValue',sdId);
			//计算金额
	        if(wsdPrice.length > 0 && wsdAmount.length > 0){
	            var money = parseFloat(wsdPrice) * parseFloat(wsdAmount);
	            $(o_wsdMoney.target).textbox('setValue',money.toFixed(2));
			}
	
	//        $('#xx').textbox('textbox').attr('readonly',true);  //设置输入框为禁用
	        $(o_wStandard.target).attr('readonly',true);  //设置输入框为禁用
	        $("#findWare_div").hide();
	    }
    }
    //查找是否包含
    function findWid(wid,batchNo,sbId) {
        var rows = $('#dg_wholesale').datagrid('getRows')//获取当前页的数据行
        var len = rows.length
        if(len == 1){
            return -1;
        }
        for (var i = 0; i < rows.length; i++) {
            var nwid = rows[i]['wId'];
            var nbatchNo = rows[i]['batchNo'];
            var nsbId = rows[i]['sbId'];
//            alert(nwid);
            if(wid == nwid && batchNo == nbatchNo && sbId == nsbId){//获取指定列
                return i;
            }
        }
        return -1;
    }
    //增加行
    function appendDgDetail(){
    	//debugger;
        if (endEditing()){
            $('#dg_wholesale').datagrid('appendRow',{status:'P'});
            editIndex = $('#dg_wholesale').datagrid('getRows').length-1;
            $('#dg_wholesale').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
            setCell(editIndex);
//            $('#dg_wholesale').datagrid('addRow');
//          bindKeyEvent(editIndex,"wClassid");
            bindCellKeyEvent(editIndex,"wTraname");//商品名称
            bindCellKeyEvent(editIndex,"wsdPrice");//商品批发价格
            bindCellKeyEvent(editIndex,"wsdAmount");//数量
            bindCellKeyEvent(editIndex,"validDate");//数量
            bindCellKeyEvent(editIndex,"produceDate");//数量
            bindCellKeyEvent(editIndex,"wsdIndex");//序号
			//获取焦点
            var o_wTraname = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'wTraname'});
            $(o_wTraname.target).textbox('textbox').focus();
        }
    }

    function setCell(editIndex) {
        //设置商品ID为只读
        var o_wId = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'wId'});
        $(o_wId.target).textbox('textbox').attr('readonly',true);
        $(o_wId.target).textbox('textbox').css('background','#F5F5F5');
        //设置商品规格为只读
        var o_wStandard = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'wStandard'});
        $(o_wStandard.target).textbox('textbox').attr('readonly',true);
        $(o_wStandard.target).textbox('textbox').css('background','#F5F5F5');
        //设置单位为只读
        var o_wUnit = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'wUnit'});
        $(o_wUnit.target).textbox('textbox').attr('readonly',true);
        $(o_wUnit.target).textbox('textbox').css('background','#F5F5F5');
        //设置生产厂家为只读
        var o_wBusiness = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'wBusiness'});
        $(o_wBusiness.target).textbox('textbox').attr('readonly',true);
        $(o_wBusiness.target).textbox('textbox').css('background','#F5F5F5');
        //设置产地为只读
        var o_wPlace = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'wPlace'});
        $(o_wPlace.target).textbox('textbox').attr('readonly',true);
        $(o_wPlace.target).textbox('textbox').css('background','#F5F5F5');
        //设置批次为只读
        var o_sbId = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'sbId'});
        $(o_sbId.target).textbox('textbox').attr('readonly',true);
        $(o_sbId.target).textbox('textbox').css('background','#F5F5F5');
        //设置批号为只读
        var o_batchNo = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'batchNo'});
        $(o_batchNo.target).textbox('textbox').attr('readonly',true);
        $(o_batchNo.target).textbox('textbox').css('background','#F5F5F5');
		//设置效期为只读
        var o_validDate = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'validDate'});
        $(o_validDate.target).textbox('textbox').attr('readonly',true);
        $(o_validDate.target).textbox('textbox').attr('placeholder',"20170101");
        $(o_validDate.target).textbox('textbox').css('background','#F5F5F5');
        //设置货位为只读
        var o_spCode = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'spCode'});
        $(o_spCode.target).textbox('textbox').attr('readonly',true);
        $(o_spCode.target).textbox('textbox').css('background','#F5F5F5');
        //设置生产日期为只读
        var o_produceDate = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'produceDate'});
        $(o_produceDate.target).textbox('textbox').attr('readonly',true);
        $(o_produceDate.target).textbox('textbox').attr('placeholder',"20170101");
        $(o_produceDate.target).textbox('textbox').css('background','#F5F5F5');
		//序号
        var o_wsdIndex = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'wsdIndex'});
        $(o_wsdIndex.target).textbox('setValue',editIndex+1);
        $(o_wsdIndex.target).textbox('textbox').attr('readonly',true);
        $(o_wsdIndex.target).textbox('textbox').css('background','#F5F5F5');
    }
    //删除行
    function removeDgDetail(){
        if (editIndex == undefined){return}
        $('#dg_wholesale').datagrid('cancelEdit', editIndex)
            .datagrid('deleteRow', editIndex);
        editIndex = undefined;
    }
    //保存
    function accept(){
        var wsId = $('#wsId').val();
        if( $.trim(wsId).length == 0){
            $.messager.alert('提示', '清填写入库单号！');
            return false;
        }
        if (endEditing()){
            if ($('#dg_wholesale').datagrid('getChanges').length) {
//                    debugger;
                var inserted = $('#dg_wholesale').datagrid('getChanges', "inserted");
                var deleted = $('#dg_wholesale').datagrid('getChanges', 'deleted');
                var updated = $('#dg_wholesale').datagrid('getChanges', "updated");

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

                $.post('/erp/wholesaledetail/save.yy',
                    {wsId:wsId,
                        add:inserted,
                        del:deleted,
                        modify:updated
                    },
                    function(data) {
                        var rj = eval('(' + data + ')');
                        if(rj.status){
                            $.messager.alert('提示', rj.desc +',提交成功！');
                            $('#tb_wholesale').datagrid('acceptChanges');
                        }
                    }, 'JSON').error(function() {
                    $.messager.alert('提示', '提交错误了！');
                });
            }
        }
        //保存后
        $('#dg_wholesale').datagrid('acceptChanges');
    }
    //保存表单，同时保存明细
    function submitForm(){
        //第二种
        $('#ff_wholesale').form('submit',{
            onSubmit:function(){
//                $("#moduleId").val('${moduleId}');
//                var wsId = $('#wsId').val();
//                if( $.trim(wsId).length == 0){
//                    $.messager.alert('提示', '清填写入库单号！');
//                    return false;
//                }
                if (endEditing()) {
                    if ($('#dg_wholesale').datagrid('getChanges').length) {
//                    debugger;
                        var inserted = $('#dg_wholesale').datagrid('getChanges', "inserted");
                        var deleted = $('#dg_wholesale').datagrid('getChanges', 'deleted');
                        var updated = $('#dg_wholesale').datagrid('getChanges', "updated");

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
                        $("#add").val(inserted);
                        $("#del").val(deleted);
                        $("#modify").val(updated);
                    }
                }
                return $(this).form('validate');
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                if(rj.status == 1){
                    var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
                    tab.panel('refresh','/erp/wholesale/index.yy');
                }else{
                    $.messager.alert('Info', rj.desc, 'error');
                }
            }
        });
    }
    //清空表单
    function clearForm(){
        $('#ff_wholesale').form('clear');
    }

    //结束编辑
    function onEndEdit(index, row){
        var ed = $(this).datagrid('getEditor', {
            index: index,
            field: 'wTraname'
        });
        //row.wClassid = $(ed.target).combobox('getText');
    }

    //绑定明细行单元格事件
    var div_indexx = 0;//当前行
	function bindCellKeyEvent(index,field) {
		//debugger;
        var ed = $('#dg_wholesale').datagrid('getEditor', {index:index,field:field});
        if (ed){
            $(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target);
//            var obj = $(ed.target).textbox('textbox');
            if(field == 'wTraname'){
                $(ed.target).textbox('textbox').bind('keyup', function(event){
//                    debugger;
                    //var left1 = event.screenLeft;
                    //var top1 = event.screenTop;

//                    alert(event.clientX +","+ event.clientY+","+event.screenLeft+","+event.screenY);
//                    if(e.keyCode != 8){//13回车键,8退格键
					if(event.keyCode == 38) {//上
                        var flag = $("#findWare_div").is(":visible");
                        if (flag) {
                            div_indexx--;
                            if (div_indexx == 0) {
                                div_indexx = 1;
                            }
                            //var ul_next = $("#findWare_div").find("ul:eq(" + (div_indexx+1) + ")");
                            //var bg = ul_next.css("background-color");
                            //ul_next.css("background", bg).siblings().css("background", "");
                            //alert("上:"+bg);
                           // ul_next.css("background", bg);
                            var ul = $("#findWare_div").find("ul:eq(" + div_indexx + ")");
                           	var validdate = $(ul).find("li:eq(7)")[0].innerText;
                           	var bg =setBgColor(validdate,"#E8F4FC");
                           	//alert("上:"+bg);
                           	//var bg = ul.css("background-color");
                           	//var old_bg=setBgColor(validdate);//下一条                           	
							ul.css("background", bg).siblings().css("background", "");
							//ul.css("background", bg);
//                            type = li.attr("class");
							//console.info("上:"+div_indexx);
							return;
                        }
				 	}
                    if(event.keyCode == 40){//下
                        var flag = $("#findWare_div").is(":visible");
                        if (flag){
                            div_indexx ++;
                            var div_rows = $("#findWare_div ul").length;
//                            alert(div_rows);
                            if(div_indexx == div_rows){
                                div_indexx--;
                            }
                            
                            //var ul_pre = $("#findWare_div").find("ul:eq(" + (div_indexx-1) + ")");                            
                            //var bg = ul_pre.css("background-color");
                            //alert("下:"+bg);
                            //if(!(bg=="rbg(0,0,0)")){
                            	//ul_pre.css("background", bg).siblings().css("background", "");
                            //	ul_pre.css("background", bg);
                            //}
                            var ul = $("#findWare_div").find("ul:eq(" + div_indexx + ")");
                            
                            var validdate = $(ul).find("li:eq(7)")[0].innerText;
                            var bg =setBgColor(validdate,"#E8F4FC");
                            //alert("下:"+bg);
                            ul.css("background", bg).siblings().css("background", "");
                            //ul.css("background", bg);
//                            type = li.attr("class");
                            //console.info("下:"+div_indexx);
                            return;
                        }
                    }
                    if(event.keyCode == 13){
//						console.info("div_indexx:"+div_indexx);
						if (div_indexx > 0 ){
						    var div_ul_index = div_indexx;
                            div_indexx = 0;
                            $("#wares_ul_"+div_ul_index).click();
                            return ;
						}
					}

                    var str = $(this).val();
                    if(str != ""){
                    	var x = $(this).offset().left;
                    	var y = $(this).offset().top;
                        $("#findWare_div").css("left",x-50);
                        $("#findWare_div").css("top",y-8);
                        findWare($(this));
                    }else{
                        $("#findWare_div").hide();
                    }
//                    }
                });
            }else{//修改批发价格或数量时修改金额
                if(field == 'wsdPrice'){
                    $(ed.target).textbox('textbox').bind('keydown', function(e){
//                        if(e.keyCode != 8){//13回车键,8退格键
                        if(e.keyCode == 13){
                            var str = $(this).val();
                            if(str != "" && !isNaN(str)){
                                var o_amount = $('#dg_wholesale').datagrid('getEditor',{index:index,field:"wsdAmount"});
                                var o_money = $('#dg_wholesale').datagrid('getEditor',{index:index,field:"wsdMoney"});
                                var amount = $(o_amount.target).textbox('getValue');
                                var money = parseFloat(str) * parseFloat(amount);
                                $(o_money.target).textbox('setValue',money.toFixed(2));
                            }else{
                                $.messager.alert("错误","批发价为数字","error",function () {
                                    $(this).select();
                                });
                            }
                        }
                    });
                }else if(field == 'wsdAmount'){
                    $(ed.target).textbox('textbox').bind('keydown', function(e){
                        //if(e.keyCode != 8){//13回车键,8退格键
                        if(e.keyCode == 13){
                            var str = $(this).val();
                            if(str != "" && !isNaN(str)){
                                var o_price = $('#dg_wholesale').datagrid('getEditor',{index:index,field:"wsdPrice"});
                                var o_money = $('#dg_wholesale').datagrid('getEditor',{index:index,field:"wsdMoney"});

                                var price = $(o_price.target).textbox('getValue');
                                var money = parseFloat(str) * parseFloat(price);
                                $(o_money.target).textbox('setValue',money.toFixed(2));
                            }else{
                                $.messager.alert("错误","数量为数字","error",function () {
                                    $(this).select();
                                });

                            }
                        }
                    });
                }else if(field == 'validDate'){
                    $(ed.target).textbox('textbox').bind('blur', function(e){
                        var str = $(this).val();
                        if(str != ""){
                            var date_reg = /^[0-9]{4}[0-1]?[0-9]{1}[0-3]?[0-9]{1}$/;
                            if(!(date_reg.test(str))){
                                $.messager.alert("错误","抱歉，您输入的效期有误，正确格式应为:20170101","error",function () {
                                    $(ed.target).textbox('textbox').select();
                                });
                            }
                        }
                    });
                }else if(field == 'produceDate'){
                    $(ed.target).textbox('textbox').bind('blur', function(e){
                        var str = $(this).val();
                        if(str != ""){
                            var date_reg = /^[0-9]{4}[0-1]?[0-9]{1}[0-3]?[0-9]{1}$/;
                            if(!(date_reg.test(str))){
                                $.messager.alert("错误","抱歉，您输入的生产日期有误，正确格式应为:20170101","error",function () {
                                    $(ed.target).textbox('textbox').select();
                                });
                            }
                        }
                    });
                }else if(field == 'wsdIndex'){
                    $(ed.target).textbox('textbox').bind('keydown', function(e){
                        var str = $(this).val();
                        //debugger;
                        if(str != "" &&  !isNaN(str)){
                            if(e.keyCode == 13 || e.keyCode == 9){
                                $("#append_detail").click();
							}
                        }else{
                            $.messager.alert("错误","序号为数字","error",function () {
                                $(this).select();
                            });
						}
                    });
                }

            }
        }
    }

	function setColor(value,row,index){
		if(value != undefined && value != ""){
			var now = new Date();
			var vdt = new Date(value.substr(0,4)+"-"+value.substr(4,2)+"-"+value.substr(6,2));
			var vms = vdt -now ;
			if(vms < 7776000000){//三个月
				return 'background-color:#ff0000;color:#ffee00;';
			}
			if( vms < 15552000000){//半年			
				return 'background-color:#ffee00;color:#ff0000;';
			}
		}			
	}

	function setReadColor(value,row,index){
		return 'background-color:#F5F5F5;';
	}
	
    //绑定键盘事件
    //    function bindKeyEvent(index,field){
    ////        alert("---bindKeyEvent--"+index+","+field);
    //        $('#dg_wholesale').datagrid('appendRow',{status:'P'});
    //        editIndex = $('#dg_wholesale').datagrid('getRows').length-1;
    //        $('#dg_wholesale').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
    //
    //        var o_wId = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'wId'});
    //        $(o_wId.target).textbox('textbox').attr('readonly',true);
    //
    //        var o_sbId = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'sbId'});
    //        $(o_sbId.target).textbox('textbox').attr('readonly',true);
    //
    //        var o_batchNo = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'batchNo'});
    //        $(o_batchNo.target).textbox('textbox').attr('readonly',true);
    //
    //        var o_validDate = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'validDate'});
    //        $(o_validDate.target).textbox('textbox').attr('placeholder',"20170101");
    //
    //        var o_produceDate = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'produceDate'});
    //        $(o_produceDate.target).textbox('textbox').attr('placeholder',"20170101");
    //
    //        var o_wsdIndex = $('#dg_wholesale').datagrid('getEditor', {index:editIndex,field:'wsdIndex'});
    //        $(o_wsdIndex.target).textbox('setValue',editIndex+1);

    //            $('#dg_wholesale').datagrid('addRow');
    //          bindKeyEvent(editIndex,"wClassid");
    //        bindCell(editIndex,"wTraname");//商品名称
    //        bindCell(editIndex,"wsdPrice");//商品批发价格
    //        bindCell(editIndex,"wsdAmount");//数量
    //        bindCell(editIndex,"validDate");//数量
    //        bindCell(editIndex,"produceDate");//数量

    //        bindCell(index,field);
    //    }
    //检查入库单号是否存在
    //    function isExistId(){
    //        var wsId = $('#wsId').val();
    //        if(wsId != ""){
    //            $.post("/erp/wholesale/checkWid_json.yy",
    //                {wsId:wsId},
    //                function(data){
    //                    if(data == 1){
    //                        $.messager.alert('提示', "供应商编号已存在",'error',function () {
    //                            $('#wsId').textbox("textbox").select();
    //                        });
    //                    }
    //                }
    //            );
    //        }
    //    }
	</script>
