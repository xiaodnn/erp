<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	#findWare_div p{color:#000000}
	#findWare_div p:hover{ color:#ff0000;}
</style>
	<p style="font-weight: bold;color: red;">请完善采购入库信息，其中必填项，请认真填写。</p>
	<div style="margin:5px;"></div>
	<div class="easyui-panel" title="采购入库" style="width:100%;padding:3px;" data-options="iconCls:'icon-ok'">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff_warehousing" class="easyui-form" method="post" action="/erp/warehousing/save.yy" data-options="novalidate:false">
	    	<table>
	    		<tr>
	    			<td>入库单号:</td>
	    			<td><input class="easyui-textbox" id="whId" name="whId" data-options="events:{blur:isExistId},required:true" /></td>
	    			<td>制单时间:</td>
	    			<td><input class="easyui-datebox" id="whInitime" name="whInitime" data-options="required:true,width:100,formatter:formatDatebox"/></td>
	    			<td>入库机构:</td>
	    			<td>
	    			<select style="width:200px;" class="easyui-combobox" id="oId" name="oId" data-options="panelHeight:'auto'"></select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>入库仓库:</td>
	    			<td>
	    				<select style="width:100px;" class="easyui-combobox" id="shId" name="shId" data-options="panelHeight:'auto'"></select>
	    			</td>
					<td>制单人:</td>
					<td>
						<select style="width:100px;" class="easyui-combobox"  id="whCreator" name="whCreator" data-options="
							hasDownArrow: false,
							panelHeight: '125',
							width:'100'"/>
					</td>
	    			<td>供应商:</td>
	    			<td><select style="width:200px;" class="easyui-combobox" id="cId" name="cId" data-options="panelHeight:'auto'" /></td>
	    		</tr>
	    		<tr>
	    			<td>审核状态:</td>
	    			<td>
						<select style="width:100px;" class="easyui-combobox" name="whState" data-options="panelHeight:'auto'">
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
	    			<td><input class="easyui-textbox" name="whChtime" data-options="required:false,width:100"></input></td>
	    			<td>备注:</td>
	    			<td><input class="easyui-textbox" name="whMemo" data-options="required:false,width:200"></input></td>
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
			<div style="text-align:center;padding:5px;width:60%;">
				<a id="a_approve" href="javascript:void(0)" class="easyui-linkbutton" onclick="showApproveDialog(${moduleId},'采购入库单据','${whId}')" style="display: none;">审批</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清空</a>
			</div>
			<input type="hidden" id="add" name="add" />
			<input type="hidden" id="del" name="del" />
			<input type="hidden" id="modify" name="modify" />
	      </form>
	    </div>
	</div>
	<table id="dg_warehousing" class="easyui-datagrid" title="采购入库明细" style="width:100%;height:auto;"
            data-options="
                iconCls: 'icon-edit',
                singleSelect: true,
                rownumbers: true,
                toolbar: '#tb_warehousing',
                onClickCell: onClickCell,
                onEndEdit:onEndEdit,
				fitColumns:true">
        <thead>
            <tr>
                <th data-options="field:'wId',width:60,editor:'textbox'">商品ID</th>
                <th data-options="field:'wClassid',width:70,editor:'textbox',padding:0">商品编号</th>
                <th data-options="field:'wTraname',width:100,editor:'textbox'">商品名称</th>
                <th data-options="field:'wStandard',width:80,editor:'textbox'">商品规格</th>
                <th data-options="field:'wUnit',width:50,editor:'textbox'">单位</th>
				<th data-options="field:'wBusiness',width:150,editor:'textbox'">生产厂家</th>
				<th data-options="field:'wPlace',width:50,editor:'textbox'">产地</th>
				<th data-options="field:'wApprovalno',width:80,editor:'textbox'">批准文号</th>
				<th data-options="field:'wdSaleprice',width:50,editor:'textbox'">售价</th>
				<th data-options="field:'wdCostprice',width:50,editor:'textbox'">进价</th>
				<th data-options="field:'wdAmount',width:50,editor:'textbox'">数量</th>
				<th data-options="field:'wdDiscount',width:40,editor:'textbox'">折扣</th>
				<th data-options="field:'wdDiscPrice',width:50,editor:'textbox'">折扣价</th>
				<th data-options="field:'wdBatchNo',width:120,editor:'textbox'">批号</th>
				<th data-options="field:'wdIndate',width:90,editor:'textbox'">有效期</th>
				<th data-options="field:'wdDate',width:90,editor:'textbox'">生产日期</th>
				<th data-options="field:'wdAllocation',width:80,editor:'textbox'">货位</th>
				<th data-options="field:'wdIndex',width:50,editor:'textbox'">序号</th>
            </tr>
        </thead>
    </table>
 
    <div id="tb_warehousing" style="height:auto">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">保存</a>
    </div>
    
    <div id="findWare_div" style="display:none;width:400px;height:200px;padding:10px;closable:true;background-color:#E0ECFF;overflow-y:auto;position:absolute;left:18%;top:55%;border:solid #000 1px;">
	</div>

	<script type="text/javascript">
	$(function(){
	    //加载入库机构:
		$("#oId").combobox({
            url: '/erp/organ/find_name.yy',
            method: 'post',
            valueField: 'oId',
            textField: 'oName'
		});
		//加载入库仓库
        $("#shId").combobox({
        	url: '/erp/storehouse/find_json.yy',
            method: 'post',
            valueField: 'shId',
            textField: 'shName'
		});
        //加载制单人
        $("#whCreator").combobox({
            url:'/erp/employee/find_json.yy',
            valueField: 'eId',
            textField: 'eName'
		});
        //加载供应商
        $("#cId").combobox({
            url: '/erp/company/find_json.yy',
            method: 'post',
            valueField: 'cId',
            textField: 'cName'
        });

		var whId = '${whId}';
//		alert("--whId:"+whId);
		if(whId == ""){//新增
            var mydate = new Date();
            $("#whInitime").val(mydate);
		}else{//不为空,既为修改
//            var url = '/erp/warehousing/add_json.yy?whId='+whId;
//            $('#ff_warehousing').form('load', url);
//            $('#whId').prop('readonly',true);
//            $('#whId').validatebox({required: false});
//            $("#whId").removeAttr("onblur");
//
            var moduleId = '${moduleId}';
//            alert("---moduleId---"+moduleId);
			if(moduleId != ""){
                showApprove(moduleId,whId);
            }

            // datagrid 填充
            $.post("/erp/warehousing/add_json.yy",
                {whId:whId},
                function(data){
//                    var wh = eval('(' + data + ')');
//                    debugger;
                    if(data){
                        //加载表单
                        $('#ff_warehousing').form('load', data);
                        $('#whId').prop('readonly',true);
                        $('#whId').validatebox({required: false});
                        $("#whId").removeAttr("onblur");
                        //加载datagrid
                        $('#dg_warehousing').datagrid("loadData",data.warehousingDetails);

                    }
                }
            );

        }
	});
	//单击单元格事件
    function onClickCell(index, field){
        if (editIndex != index){
            if (endEditing()){
                $('#dg_warehousing').datagrid('selectRow', index).datagrid('beginEdit', index);
                var ed = $('#dg_warehousing').datagrid('getEditor', {index:index,field:field});
                if (ed){
                    $(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target);
                    var obj = $(ed.target).textbox('textbox');
                    if(field == 'wClassid' || field == 'wTraname'){
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
                    $('#dg_warehousing').datagrid('selectRow', editIndex);
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
        if ($('#dg_warehousing').datagrid('validateRow', editIndex)){
            $('#dg_warehousing').datagrid('endEdit', editIndex);
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
                    tbody += "<p style='cursor:pointer' onclick=selectWid('"+ obj.wId +"','"+obj.wClassid +"','"+obj.wTraname+"','"+obj.wStandard+"','"+obj.wUnit+"','"+obj.wBusiness+"','"+obj.wPlace+"','"+obj.wSaleprice+"','"+obj.wCostprice+"','"+obj.wApprovalno+"')> " + obj.wTraname +" - " + obj.wStandard +" - " + obj.wPlace +" - " + obj.wBusiness +"</p>";
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
    function selectWid(wId,wClassid,wTraname,wStandard,wUnit,wBusiness,wPlace,wSaleprice,wCostprice,wApprovalno){
//        alert("---wId:"+wId);
        var flag = fiindWid(wId);
        if(flag >= 0){
            $.messager.alert('提示',wClassid+"-"+wTraname+',该商品已经存在明细列表中第 '+ (flag+1) +" 行.");
            return false;
        }
        var editors = $('#dg_warehousing').datagrid('getEditors', editIndex);
        var o_wId = editors[0];
        var o_wClassid = editors[1];
        var o_wTraname = editors[2];
        var o_wStandard = editors[3];
        var o_wUnit = editors[4];
        var o_wBusiness = editors[5];
        var o_wPlace = editors[6];
        var o_wApprovalno = editors[7];
        var o_wSaleprice = editors[8];
        var o_wCostprice = editors[9];

        $(o_wId.target).textbox('setValue',wId);
        $(o_wClassid.target).textbox('setValue',wClassid);
        $(o_wTraname.target).textbox('setValue',wTraname);
        $(o_wStandard.target).textbox('setValue',wStandard);
        $(o_wUnit.target).textbox('setValue',wUnit);
        $(o_wBusiness.target).textbox('setValue',wBusiness);
        $(o_wPlace.target).textbox('setValue',wPlace);
        $(o_wApprovalno.target).textbox('setValue',wApprovalno);
        $(o_wSaleprice.target).textbox('setValue',wSaleprice);
        $(o_wCostprice.target).textbox('setValue',wCostprice);
//        $('#xx').textbox('textbox').attr('readonly',true);  //设置输入框为禁用
        $(o_wStandard.target).attr('readonly',true);  //设置输入框为禁用
        $("#findWare_div").hide();
    }
    //查找是否包含
    function fiindWid(wid) {
        var rows = $('#dg_warehousing').datagrid('getRows')//获取当前页的数据行
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
            $('#dg_warehousing').datagrid('appendRow',{status:'P'});
            editIndex = $('#dg_warehousing').datagrid('getRows').length-1;
            $('#dg_warehousing').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
//            $('#dg_warehousing').datagrid('addRow');
            bindKeyEvent(editIndex,"wClassid");
            bindKeyEvent(editIndex,"wTraname");
        }
    }
    //删除行
    function removeit(){
        if (editIndex == undefined){return}
        $('#dg_warehousing').datagrid('cancelEdit', editIndex)
            .datagrid('deleteRow', editIndex);
        editIndex = undefined;
    }
    //保存
    function accept(){
        var whId = $('#whId').val();
        if( $.trim(whId).length == 0){
            $.messager.alert('提示', '清填写入库单号！');
            return false;
        }
        if (endEditing()){
            if ($('#dg_warehousing').datagrid('getChanges').length) {
//                    debugger;
                var inserted = $('#dg_warehousing').datagrid('getChanges', "inserted");
                var deleted = $('#dg_warehousing').datagrid('getChanges', 'deleted');
                var updated = $('#dg_warehousing').datagrid('getChanges', "updated");

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

                $.post('/erp/warehousingdetail/save.yy',
                    {whId:whId,
                        add:inserted,
                        del:deleted,
                        modify:updated
                    },
                    function(data) {
                        var rj = eval('(' + data + ')');
                        if(rj.status){
                            $.messager.alert('提示', rj.desc +',提交成功！');
                            $('#tb_warehousing').datagrid('acceptChanges');
                        }
                    }, 'JSON').error(function() {
                    $.messager.alert('提示', '提交错误了！');
                });
            }
        }
        //保存后
        $('#dg_warehousing').datagrid('acceptChanges');
    }
    //保存表单，同时保存明细
    function submitForm(){
        //第二种
        $('#ff_warehousing').form('submit',{
            onSubmit:function(){
                var whId = $('#whId').val();
                if( $.trim(whId).length == 0){
                    $.messager.alert('提示', '清填写入库单号！');
                    return false;
                }
                if (endEditing()) {
                    if ($('#dg_warehousing').datagrid('getChanges').length) {
//                    debugger;
                        var inserted = $('#dg_warehousing').datagrid('getChanges', "inserted");
                        var deleted = $('#dg_warehousing').datagrid('getChanges', 'deleted');
                        var updated = $('#dg_warehousing').datagrid('getChanges', "updated");

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
                    tab.panel('refresh','/erp/warehousing/index.yy');
                }else{
                    $.messager.alert('Info', rj.desc, 'error');
                }
            }
        });
    }
    //清空表单
    function clearForm(){
        $('#ff_warehousing').form('clear');
    }
    //检查入库单号是否存在
    function isExistId(){
        var whId = $('#whId').val();
        if(whId != ""){
            $.post("/erp/warehousing/checkWid_json.yy",
                {whId:whId},
                function(data){
                    if(data == 1){
                        $.messager.alert('提示', "供应商编号已存在",'error',function () {
                            $('#whId').textbox("textbox").select();
                        });
                    }
                }
            );
        }
    }
    //绑定键盘事件
    function bindKeyEvent(index,field){
        var ed = $('#dg_warehousing').datagrid('getEditor', {index:index,field:field});
        if (ed){
            $(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target);
            var obj = $(ed.target).textbox('textbox');
            if(field == 'wClassid' || field == 'wTraname'){
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
    //结束编辑
    function onEndEdit(index, row){
        var ed = $(this).datagrid('getEditor', {
            index: index,
            field: 'wClassid'
        });
        //row.wClassid = $(ed.target).combobox('getText');
    }

	</script>
