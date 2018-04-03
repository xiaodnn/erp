<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	#findWare_div p{color:#000000}
	#findWare_div p:hover{ color:#ff0000;}
</style>
	<p style="font-weight: bold;color: red;">请完善批发申请信息，其中必填项，请认真填写。</p>
	<div style="margin:5px;"></div>
	<div class="easyui-panel" title="批发申请" style="width:100%;padding:3px;" data-options="iconCls:'icon-ok'">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff_wholesaleapply" class="easyui-form" method="post" action="/erp/wholesaleapply/save.yy" data-options="novalidate:false">
			<table>
				<tr>
					<td>批发单号:</td>
					<td><input class="easyui-textbox" id="waId" name="waId" data-options="readonly:true" /></td>
					<td>制单时间:</td>
					<td><input class="easyui-datebox" id="waDate" name="waDate" data-options="required:true,width:100"/></td>

					<td>制单人:</td>
					<td>
						<input style="width:100px;" class="easyui-combobox"  id="waCreator" name="waCreator" data-options="
							hasDownArrow: false,
							panelHeight: '125'"/>
					</td>
				</tr>
				<tr>
					<td>客户名称:</td>
					<td>
						<select style="width:200px;" class="easyui-combobox" id="cbId" name="cbId" data-options="panelHeight:'auto'"></select>
					</td>
					<td>付款方式:</td>
					<td>
						<select style="width:100px;" class="easyui-combobox" id="waPayWay" name="waPayWay" data-options="panelHeight:'auto'">
							<option value="1">月结</option>
							<option value="2">货到付款</option>
							<option value="3">现金</option>
							<option value="4">刷卡</option>
						</select>
					</td>
					<td>出库仓库:</td>
					<td>
						<select style="width:100px;" class="easyui-combobox" id="shId" name="shId" data-options="panelHeight:'auto'"></select>
					</td>
				</tr>
				<tr>
					<td>发票类型:</td>
					<td>
						<select style="width:200px;" class="easyui-combobox"  id="waInvoiceType" name="waInvoiceType" data-options="panelHeight: 'auto'">
							<option value="1">增值税专用发票</option>
							<option value="2">普通发票</option>
							<option value="3">定额发票</option>
							<option value="4">机打发票</option>
						</select>
					</td>
					<td>价格组ID:</td>
					<td>
						<select style="width:100px;" class="easyui-combobox" id="pId" name="pId" data-options="panelHeight:'auto'"></select>
					</td>

				</tr>
				<tr>

					<td>提货方式:</td>
					<td>
						<select style="width:100px;" class="easyui-combobox"  id="waReceiveWay" name="waReceiveWay" data-options="
							panelHeight: 'auto',
							width:'100'">
							<option value="1">货运</option>
							<option value="2">自提</option>
							<option value="3">配送</option>
							<option value="4">提送</option>
						</select>
					</td>

					<td>业务员:</td>
					<td>
						<select style="width:100px;" class="easyui-combobox" id="eId" name="eId" data-options="hasDownArrow: false,
							panelHeight: 'auto'"></select>
					</td>
				</tr>
				<tr>
					<td>收货地址:</td>
					<td>
						<input class="easyui-textbox" id="cbStorehouse" name="cbStorehouse" data-options="width:'200'"></select>
					</td>
					<td>审核状态:</td>
					<td>
						<select style="width:100px;" class="easyui-combobox" name="waState" data-options="panelHeight:'auto'">
							<option value="1">正常</option>
							<option value="2">审核中</option>
							<option value="3">审核完成</option>
							<option value="4">驳回</option>
							<option value="5">撤销</option>
							<option value="6">作废</option>
							<option value="0">无效</option>
						</select>
					</td>
					<td>备注:</td>
					<td><input class="easyui-textbox" name="waRemark" data-options="required:false,width:200" /></td>
				</tr>
				<tr id="tr_approve1" style="background-color:#F9F9F9;display: none;font-weight:bold;">
					<td id="td_approve_d1"></td>
					<td id="td_approve_u1" style="padding:5px 8px;"></td>
					<td id="td_approve_d2"></td>
					<td id="td_approve_u2" style="padding:5px 8px;"></td>
					<td id="td_approve_d3"></td>
					<td id="td_approve_u3" style="padding:5px 8px;"></td>
				</tr>
				<tr id="tr_approve2" style="background-color:#F9F9F9;display: none;font-weight:bold;">
					<td id="td_approve_d4"></td>
					<td id="td_approve_u4" style="padding:5px 8px;"></td>
					<td id="td_approve_d5"></td>
					<td id="td_approve_u5" style="padding:5px 8px;"></td>
					<td id="td_approve_d6"></td>
					<td id="td_approve_u6" style="padding:5px 8px;"	></td>
				</tr>
			</table>
			<!--审核情况-->
			<div style="text-align:center;padding:5px;width:60%;">
				<a id="a_approve" href="javascript:void(0)" class="easyui-linkbutton" onclick="showApproveDialog(${moduleId},'批发申请单据','${waId}')" style="display: none;">审批</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清空</a>
			</div>
			<input type="hidden" id="moduleId" name="moduleId" />
			<input type="hidden" id="add" name="add" />
			<input type="hidden" id="del" name="del" />
			<input type="hidden" id="modify" name="modify" />
	      </form>
	    </div>
	</div>
	<table id="dg_wholesaleapply" class="easyui-datagrid" title="批发申请明细" style="width:100%;height:auto;"
            data-options="
                iconCls: 'icon-edit',
                singleSelect: true,
                rownumbers: true,
                toolbar: '#tb_wholesaleapply',
                onClickCell: onClickCell,
                onEndEdit:onEndEdit,
				fitColumns:true">
        <thead>
            <tr>
                <th data-options="field:'wId',width:50,editor:'textbox'">商品ID</th>
                <th data-options="field:'wTraname',width:200,editor:'textbox'">商品名称</th>
                <th data-options="field:'wStandard',width:80,editor:'textbox'">商品规格</th>
                <th data-options="field:'wUnit',width:50,editor:'textbox'">单位</th>
				<th data-options="field:'wBusiness',width:200,editor:'textbox'">生产厂家</th>
				<th data-options="field:'wPlace',width:50,editor:'textbox'">产地</th>
				<th data-options="field:'wdSaleprice',width:50,editor:'textbox'">售价</th>
				<th data-options="field:'wdCostprice',width:50,editor:'textbox'">进价</th>
				<th data-options="field:'wadApplyAmount',width:50,editor:'textbox'">申请数量</th>
				<th data-options="field:'wadApplyPrice',width:50,editor:'textbox'">申请批发价</th>
				<th data-options="field:'wadAmount',width:50,editor:'textbox'">批准数量</th>
				<th data-options="field:'wadPrice',width:50,editor:'textbox'">批准批发价</th>
				<th data-options="field:'wadMoney',width:40,editor:'textbox'">金额</th>
				<th data-options="field:'wadIndex',width:30,editor:'textbox'">序号</th>
            </tr>
        </thead>
    </table>
 
    <div id="tb_wholesaleapply" style="height:auto">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">保存</a>
    </div>
    
    <div id="findWare_div" style="display:none;width:400px;height:200px;padding:10px;closable:true;background-color:#E0ECFF;overflow-y:auto;position:absolute;left:18%;top:55%;border:solid #000 1px;">
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
		//加载入库仓库
        $("#shId").combobox({
        	url: '/erp/storehouse/find_json.yy',
            method: 'post',
            valueField: 'shId',
            textField: 'shName'
		});
        //加载制单人
        $("#waCreator").combobox({
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

		var waId = '${waId}';
//		alert("--waId:"+waId);
		if(waId == ""){//新增
            var mydate = new Date();
            $("#waDate").val(mydate);
		}else{//不为空,既为修改
//            var url = '/erp/wholesaleapply/add_json.yy?waId='+waId;
//            $('#ff_wholesaleapply').form('load', url);
//            $('#waId').prop('readonly',true);
//            $('#waId').validatebox({required: false});
//            $("#waId").removeAttr("onblur");
//
            var moduleId = '${moduleId}';
//            alert("---isApprove---"+isApprove);
			if(moduleId != ""){
                showApprove(moduleId,waId);
            }

            // datagrid 填充
            $.post("/erp/wholesaleapply/add_json.yy",
                {waId:waId},
                function(data){
//                    var wh = eval('(' + data + ')');
                    if(data){
                        //加载表单
                        $('#ff_wholesaleapply').form('load', data);
                        $('#waId').prop('readonly',true);
                        $('#waId').validatebox({required: false});
                        $("#waId").removeAttr("onblur");
                        //加载datagrid
//                        $('#dg_wholesaleapply').datagrid("loadData",data.wholesaleapplyDetails);
                        $('#dg_wholesaleapply').datagrid({
                            queryParams: {
                                waId:waId
                            },
                            url: '/erp/wholesaleapplydetail/dg_find.yy'
                        });
                    }
                }
            );

        }
	});
	//单击单元格事件
    function onClickCell(index, field){
        if (editIndex != index){
            if (endEditing()){
                $('#dg_wholesaleapply').datagrid('selectRow', index).datagrid('beginEdit', index);
                var ed = $('#dg_wholesaleapply').datagrid('getEditor', {index:index,field:field});
                if (ed){
                    $(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target);
                    var obj = $(ed.target).textbox('textbox');
                    if(field == 'wTraname'){
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
                    $('#dg_wholesaleapply').datagrid('selectRow', editIndex);
                },0);
            }
        }
    }
    //结束编辑
    function onEndEdit(index, row){
        var ed = $(this).datagrid('getEditor', {
            index: index,
            field: 'wTraname'
//            field: 'wClassid'
        });
        //row.wClassid = $(ed.target).combobox('getText');
    }


    //结束编辑
    var editIndex = undefined;
    function endEditing(){
        if (editIndex == undefined){
            return true;
        }
        if ($('#dg_wholesaleapply').datagrid('validateRow', editIndex)){
            $('#dg_wholesaleapply').datagrid('endEdit', editIndex);
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
        var str = $(ed).val();
        $.post("/erp/wares/find_house.yy",
            {str:str},
            function(data){
               // alert("--data:"+data);
                if(data.length == 0){
                    $("#findWare_div").hide();
                    return ;
                }
                //alert(data);
                $("#findWare_div").empty();
                //$("#findWare_div").css({position: "absolute",'top':top+10,'left':left,'z-index':2});
                var tbody = "";
                //1.清空原来的operType这个combobox中的选项
                //$("#wClassid").combobox("clear");

                //下面使用each进行遍历
                //var options01 = [{text : "等于", value : "eq"},{text : "不等于", value : "ne"}];
                $.each(data,function(n,obj) {
                    //tbody += "<option value="+ obj.wId +"> " + obj.wTraname +" - " + obj.wStandard +"</option>";
                    tbody += "<p style='cursor:pointer' onclick=selectWid('"+ obj.wId +"','"+obj.wTraname+"','"+obj.wStandard+"','"+obj.wUnit+"','"+obj.wBusiness+"','"+obj.wPlace+"','"+obj.wSaleprice+"','"+obj.wCostprice+"')> " + obj.wTraname +" - " + obj.wStandard +" - " + obj.wPlace +" - " + obj.wBusiness +"</p>";
                });
                //$(ed).combobox({
                //	 panelHeight:'auto',
                //    data:data
                //  });
                $("#findWare_div").append(tbody);
                $("#findWare_div").show();//显示div
            }
        );
    }
    //选中商品信息
    function selectWid(wId,wTraname,wStandard,wUnit,wBusiness,wPlace,wSaleprice,wCostprice){
//        alert("---wId:"+wId);
        var flag = fiindWid(wId);
        if(flag >= 0){
            $.messager.alert('提示',wId+"-"+wTraname+',该商品已经存在明细列表中第 '+ (flag+1) +" 行.");
            return false;
        }
        var editors = $('#dg_wholesaleapply').datagrid('getEditors', editIndex);
        var o_wId = editors[0];
        var o_wTraname = editors[1];
        var o_wStandard = editors[2];
        var o_wUnit = editors[3];
        var o_wBusiness = editors[4];
        var o_wPlace = editors[5];
        var o_wSaleprice = editors[6];
        var o_wCostprice = editors[7];

//		alert(wSaleprice+","+wCostprice);
        $(o_wId.target).textbox('setValue',wId);
        $(o_wTraname.target).textbox('setValue',wTraname);
        $(o_wStandard.target).textbox('setValue',wStandard);
        $(o_wUnit.target).textbox('setValue',wUnit);
        $(o_wBusiness.target).textbox('setValue',wBusiness);
        $(o_wPlace.target).textbox('setValue',wPlace);
        $(o_wSaleprice.target).textbox('setValue',wSaleprice);
        $(o_wCostprice.target).textbox('setValue',wCostprice);

//        $('#xx').textbox('textbox').attr('readonly',true);  //设置输入框为禁用
        $(o_wStandard.target).attr('readonly',true);  //设置输入框为禁用
        $("#findWare_div").hide();
    }
    //查找是否包含
    function fiindWid(wid) {
        var rows = $('#dg_wholesaleapply').datagrid('getRows')//获取当前页的数据行
        var len = rows.length
        if(len == 1){
            return -1;
        }
        for (var i = 0; i < rows.length; i++) {
            var nwid = rows[i]['wId'];
//            alert(nwid);
            if(wid == nwid){//获取指定列
                return i;
            }
        }
        return -1;
    }
    //增加行
    function append(){
        if (endEditing()){
            $('#dg_wholesaleapply').datagrid('appendRow',{status:'P'});
            editIndex = $('#dg_wholesaleapply').datagrid('getRows').length-1;
            $('#dg_wholesaleapply').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
//            $('#dg_wholesaleapply').datagrid('addRow');
//            bindKeyEvent(editIndex,"wClassid");
            bindKeyEvent(editIndex,"wTraname");
        }
    }
    //删除行
    function removeit(){
        if (editIndex == undefined){return}
        $('#dg_wholesaleapply').datagrid('cancelEdit', editIndex)
            .datagrid('deleteRow', editIndex);
        editIndex = undefined;
    }
    //保存
    function accept(){
//        var waId = $('#waId').val();
//        if( $.trim(waId).length == 0){
//            $.messager.alert('提示', '清填写入库单号！');
//            return false;
//        }
        if (endEditing()){
            if ($('#dg_wholesaleapply').datagrid('getChanges').length) {
//                    debugger;
                var inserted = $('#dg_wholesaleapply').datagrid('getChanges', "inserted");
                var deleted = $('#dg_wholesaleapply').datagrid('getChanges', 'deleted');
                var updated = $('#dg_wholesaleapply').datagrid('getChanges', "updated");

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

                $.post('/erp/wholesaleapply/save.yy',
                    {waId:waId,
                        add:inserted,
                        del:deleted,
                        modify:updated
                    },
                    function(data) {
                        var rj = eval('(' + data + ')');
                        if(rj.status){
                            $.messager.alert('提示', rj.desc +',提交成功！');
                            $('#tb_wholesaleapply').datagrid('acceptChanges');
                        }
                    }, 'JSON').error(function() {
                    $.messager.alert('提示', '提交错误了！');
                });
            }
        }
        //保存后
        $('#dg_wholesaleapply').datagrid('acceptChanges');
    }
    //保存表单，同时保存明细
    function submitForm(){
        //第二种
        $('#ff_wholesaleapply').form('submit',{
            onSubmit:function(){
                $("#moduleId").val('${moduleId}');
//                var waId = $('#waId').val();
//                alert(waId);
//                debugger;
//                if( $.trim(waId).length == 0){
//                    $.messager.alert('提示', '清填写入库单号！');
//                    return false;
//                }
                if (endEditing()) {
                    if ($('#dg_wholesaleapply').datagrid('getChanges').length) {
//                    debugger;
                        var inserted = $('#dg_wholesaleapply').datagrid('getChanges', "inserted");
                        var deleted = $('#dg_wholesaleapply').datagrid('getChanges', 'deleted');
                        var updated = $('#dg_wholesaleapply').datagrid('getChanges', "updated");

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
//                return $(this).form();
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                if(rj.status == 1){
                    var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
                    tab.panel('refresh','/erp/wholesaleapply/index.yy');
                }else{
                    $.messager.alert('Info', rj.desc, 'error');
                }
            }
        });
    }
    //清空表单
    function clearForm(){
        $('#ff_wholesaleapply').form('clear');
    }
    //检查入库单号是否存在
    //    function isExistId(){
    //        var waId = $('#waId').val();
    //        if(waId != ""){
    //            $.post("/erp/wholesaleapply/checkWaId_json.yy",
    //                {waId:waId},
    //                function(data){
    //                    if(data == 1){
    //                        $.messager.alert('提示', "供应商编号已存在",'error',function () {
    //                            $('#waId').textbox("textbox").select();
    //                        });
    //                    }
    //                }
    //            );
    //        }
    //    }
    //绑定键盘事件
    function bindKeyEvent(index,field){
        var ed = $('#dg_wholesaleapply').datagrid('getEditor', {index:index,field:field});
        if (ed){
            $(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target);
            var obj = $(ed.target).textbox('textbox');
//            if(field == 'wClassid' || field == 'wTraname'){
            if(field == 'wTraname'){
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
    }



	</script>
