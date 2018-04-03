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
<!-- 
	<div class="easyui-panel" style="width:100%;padding:3px;border:none;" data-options="iconCls:'icon-ok'">
		
		<div style="padding:8px">
	    <form id="ff_tablestructfield" class="easyui-form" method="post" action="/erp/tablestructfield/save.yy" data-options="novalidate:false">
	    	<table>
				<tr>
					<td>表结构信息名称:</td>
					<td><input class="easyui-textbox" type="text" id="tsName" name="tsName" data-options="required:true" /></td>
					<td>表简称:</td>
					<td><input class="easyui-textbox" type="text" id="tsNikename" name="tsNikename" data-options="required:true" /></td>
					<td>表类型:</td>
					<td><input class="easyui-textbox" type="text" id="tsType" name="tsType" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>主表ID:</td>
					<td><input class="easyui-textbox" type="text" id="tsMid" name="tsMid" data-options="required:true" /></td>
					<td>备注:</td>
					<td colspan="3"><input class="easyui-textbox" type="text" id="tsRemark" name="tsRemark" data-options="required:true" /></td>							
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
			<input type="hidden" id="moduleId" name="moduleId" value="${moduleId}" />
			<input type="hidden" id="add" name="add" />
			<input type="hidden" id="del" name="del" />
			<input type="hidden" id="modify" name="modify" />
	      </form>
	    </div>
	    
	</div> -->
	<table id="dg_tablestructfield" class="easyui-datagrid" style="width:100%;height:auto;border-width:0;"
            data-options="
                singleSelect: true,
                rownumbers: true,
                toolbar: '#tb_tablestructfield',
                onEndEdit:onEndEdit,
				fitColumns:true,
				border:0">
        <thead>
            <tr>
            	<th data-options="field:'tsfId',width:40,editor:'textbox',halign: 'center'">表结构字段ID</th>
				<th data-options="field:'tsId',width:160,editor:'textbox',halign: 'center'">所属表ID</th>
				<th data-options="field:'tsfName',width:40,editor:'textbox',halign: 'center'">字段名</th>
				<th data-options="field:'tsfNikename',width:160,editor:'textbox',halign: 'center'">字段名描叙</th>
				<th data-options="field:'tsfType',width:40,editor:'textbox',halign: 'center'">字段类型</th>
				<th data-options="field:'tsfLen',width:160,editor:'textbox',halign: 'center'">字段长度</th>
				<th data-options="field:'tsfFormtype',width:40,editor:'textbox',halign: 'center'">表单中控件类</th>
				<th data-options="field:'tsfDefval',width:160,editor:'textbox',halign: 'center'">默认值</th>
				<th data-options="field:'tsfRemark',width:40,editor:'textbox',halign: 'center'">备注</th>
				<th data-options="field:'intime',width:160,editor:'textbox',halign: 'center',formatter:'formatDateGrid'">创建时间</th>
			</tr>
        </thead>
    </table>
 
    <div id="tb_tablestructfield" style="height:auto">
        <a id="append_detail" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="appendDgDetail()">添加明细</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="submitForm()">保存</a>
		<a id="a_approve" href="javascript:void(0)" class="easyui-linkbutton" onclick="showApproveDialog(1,'批发单据','${id}')" style="display: none;">审批</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-back',plain:true" onclick="callback('tablestructfield')">返回</a>
    </div>
	<script type="text/javascript">
	$(function(){
        //加载客户:
        $("#cbId").combobox({
            url: '/erp/customer/find_json.yy',
            method: 'post',
            valueField: 'cbId',
            textField: 'cbFullname'
        });
		
		var id = '${id}';
//		alert("--wsId:"+wsId);
		if(id == ""){//新增
            var mydate = new Date();
            $("#wsDate").val(mydate);
		}else{//不为空,既为修改
            var moduleId = '${moduleId}';
//            alert("---moduleId---"+moduleId);
			if(moduleId != ""){
                showApprove(moduleId,id);
            }

            // datagrid 填充
            $.post("/erp/tablestructfield/add_json.yy",
                {id:id},
                function(data){
//                    var wh = eval('(' + data + ')');
                    if(data){
                        //加载表单
                        $('#ff_tablestructfield').form('load', data);
                        $('#tsfId').prop('readonly',true);
                        $('#tsfId').validatebox({required: false});
                        $("#tsfId").removeAttr("onblur");
                        //加载datagrid
                        $('#dg_tablestructfield').datagrid("loadData",data.details);

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
                $('#dg_tablestructfield').datagrid('selectRow', index).datagrid('beginEdit', index);
                setCell(index);
                bindCellKeyEvent(index,field);
                editIndex = index;
            } else {
                setTimeout(function(){
                    $('#dg_tablestructfield').datagrid('selectRow', editIndex);
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
        if ($('#dg_tablestructfield').datagrid('validateRow', editIndex)){
            $('#dg_tablestructfield').datagrid('endEdit', editIndex);
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
	        var editors = $('#dg_tablestructfield').datagrid('getEditors', editIndex);
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
        var rows = $('#dg_tablestructfield').datagrid('getRows')//获取当前页的数据行
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
            $('#dg_tablestructfield').datagrid('appendRow',{status:'P'});
            editIndex = $('#dg_tablestructfield').datagrid('getRows').length-1;
            $('#dg_tablestructfield').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
            setCell(editIndex);
//            $('#dg_tablestructfield').datagrid('addRow');
//          bindKeyEvent(editIndex,"wClassid");
            bindCellKeyEvent(editIndex,"wTraname");//商品名称
            bindCellKeyEvent(editIndex,"wsdPrice");//商品批发价格
            bindCellKeyEvent(editIndex,"wsdAmount");//数量
            bindCellKeyEvent(editIndex,"validDate");//数量
            bindCellKeyEvent(editIndex,"produceDate");//数量
            bindCellKeyEvent(editIndex,"wsdIndex");//序号
			//获取焦点
            var o_wTraname = $('#dg_tablestructfield').datagrid('getEditor', {index:editIndex,field:'wTraname'});
            $(o_wTraname.target).textbox('textbox').focus();
        }
    }

    function setCell(editIndex) {
        //设置商品ID为只读
        var o_wId = $('#dg_tablestructfield').datagrid('getEditor', {index:editIndex,field:'wId'});
        $(o_wId.target).textbox('textbox').attr('readonly',true);
        $(o_wId.target).textbox('textbox').css('background','#F5F5F5');
        //设置商品规格为只读
        var o_wStandard = $('#dg_tablestructfield').datagrid('getEditor', {index:editIndex,field:'wStandard'});
        $(o_wStandard.target).textbox('textbox').attr('readonly',true);
        $(o_wStandard.target).textbox('textbox').css('background','#F5F5F5');
        //设置单位为只读
        var o_wUnit = $('#dg_tablestructfield').datagrid('getEditor', {index:editIndex,field:'wUnit'});
        $(o_wUnit.target).textbox('textbox').attr('readonly',true);
        $(o_wUnit.target).textbox('textbox').css('background','#F5F5F5');
        //设置生产厂家为只读
        var o_wBusiness = $('#dg_tablestructfield').datagrid('getEditor', {index:editIndex,field:'wBusiness'});
        $(o_wBusiness.target).textbox('textbox').attr('readonly',true);
        $(o_wBusiness.target).textbox('textbox').css('background','#F5F5F5');
        //设置产地为只读
        var o_wPlace = $('#dg_tablestructfield').datagrid('getEditor', {index:editIndex,field:'wPlace'});
        $(o_wPlace.target).textbox('textbox').attr('readonly',true);
        $(o_wPlace.target).textbox('textbox').css('background','#F5F5F5');
        //设置批次为只读
        var o_sbId = $('#dg_tablestructfield').datagrid('getEditor', {index:editIndex,field:'sbId'});
        $(o_sbId.target).textbox('textbox').attr('readonly',true);
        $(o_sbId.target).textbox('textbox').css('background','#F5F5F5');
        //设置批号为只读
        var o_batchNo = $('#dg_tablestructfield').datagrid('getEditor', {index:editIndex,field:'batchNo'});
        $(o_batchNo.target).textbox('textbox').attr('readonly',true);
        $(o_batchNo.target).textbox('textbox').css('background','#F5F5F5');
		//设置效期为只读
        var o_validDate = $('#dg_tablestructfield').datagrid('getEditor', {index:editIndex,field:'validDate'});
        $(o_validDate.target).textbox('textbox').attr('readonly',true);
        $(o_validDate.target).textbox('textbox').attr('placeholder',"20170101");
        $(o_validDate.target).textbox('textbox').css('background','#F5F5F5');
        //设置货位为只读
        var o_spCode = $('#dg_tablestructfield').datagrid('getEditor', {index:editIndex,field:'spCode'});
        $(o_spCode.target).textbox('textbox').attr('readonly',true);
        $(o_spCode.target).textbox('textbox').css('background','#F5F5F5');
        //设置生产日期为只读
        var o_produceDate = $('#dg_tablestructfield').datagrid('getEditor', {index:editIndex,field:'produceDate'});
        $(o_produceDate.target).textbox('textbox').attr('readonly',true);
        $(o_produceDate.target).textbox('textbox').attr('placeholder',"20170101");
        $(o_produceDate.target).textbox('textbox').css('background','#F5F5F5');
		//序号
        var o_wsdIndex = $('#dg_tablestructfield').datagrid('getEditor', {index:editIndex,field:'wsdIndex'});
        $(o_wsdIndex.target).textbox('setValue',editIndex+1);
        $(o_wsdIndex.target).textbox('textbox').attr('readonly',true);
        $(o_wsdIndex.target).textbox('textbox').css('background','#F5F5F5');
    }
    //删除行
    function removeDgDetail(){
        if (editIndex == undefined){return}
        $('#dg_tablestructfield').datagrid('cancelEdit', editIndex)
            .datagrid('deleteRow', editIndex);
        editIndex = undefined;
    }
   
    //保存表单，同时保存明细
    function submitForm(){
        //第二种
        $('#ff_tablestructfield').form('submit',{
            onSubmit:function(){
                if (endEditing()) {
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
                    tab.panel('refresh','/erp/tablestructfield/index.yy');
                }else{
                    $.messager.alert('Info', rj.desc, 'error');
                }
            }
        });
    }
    //清空表单
    function clearForm(){
        $('#ff_tablestructfield').form('clear');
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
        var ed = $('#dg_tablestructfield').datagrid('getEditor', {index:index,field:field});
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
                                var o_amount = $('#dg_tablestructfield').datagrid('getEditor',{index:index,field:"wsdAmount"});
                                var o_money = $('#dg_tablestructfield').datagrid('getEditor',{index:index,field:"wsdMoney"});
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
                                var o_price = $('#dg_tablestructfield').datagrid('getEditor',{index:index,field:"wsdPrice"});
                                var o_money = $('#dg_tablestructfield').datagrid('getEditor',{index:index,field:"wsdMoney"});

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
	
	</script>
