<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<p style="font-weight: bold;color: red;">请完善商品信息，其中必填项，请认真填写。</p>
	<div style="margin:5px;"></div>
	<div class="easyui-panel" title="商品信息" style="width:100%;padding:3px;">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff_wares" class="easyui-form" method="post" action="/erp/wares/save.yy" data-options="novalidate:false">
	    <fieldset style="border:solid 1px #aaa;margin-top:8px;position:relative;">
        <legend>基本信息</legend>
	    	<table>
	    	<!-- 基本信息 -->
	    		<tr>
	    			<td>商品编码:</td>
	    			<td><input class="easyui-validatebox" type="text" id="wId" name="wId" data-options="required:true" onblur="isExistId()"></input></td>
	    			<td>品类编码:</td>
	    			<td><input class="easyui-textbox" type="text" name="wClassid" data-options="required:true,validType:{length:[0,20]}"></input></td>
	    			<td>商品类型:</td>
	    			<td><input class="easyui-textbox" type="text" name="wType" data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
	    			<td>通用名:</td>
	    			<td><input class="easyui-textbox" type="text" name="wGenname" data-options="required:false"></input></td>
	    			<td>商品名:</td>
	    			<td><input class="easyui-textbox" type="text" name="wTraname" data-options="required:false"></input></td>
	    			<td>商品助记码:</td>
	    			<td><input class="easyui-textbox" type="text" name="wZjm" data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
	    			<td>商品条形码:</td>
	    			<td><input class="easyui-textbox" type="text" name="wBarcode" data-options="required:false,validType:'number'"></input></td>
	    			<td>批准文号:</td>
	    			<td><input class="easyui-textbox" type="text" name="wApprovalno" data-options="required:false"></input></td>
	    			<td>商品单位:</td>
	    			<td><input class="easyui-textbox" type="text" name="wUnit" data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
	    			<td>商品规格:</td>
	    			<td>
	    				<select class="easyui-combobox" name="wStandard" data-options="panelHeight:'auto'"><option value="ar">Arabic</option><option value="bg">Bulgarian</option><option value="ca">Catalan</option><option value="zh-cht">Chinese Traditional</option><option value="cs">Czech</option><option value="da">Danish</option><option value="nl">Dutch</option><option value="en" selected="selected">English</option><option value="et">Estonian</option><option value="fi">Finnish</option><option value="fr">French</option><option value="de">German</option><option value="el">Greek</option><option value="ht">Haitian Creole</option><option value="he">Hebrew</option><option value="hi">Hindi</option><option value="mww">Hmong Daw</option><option value="hu">Hungarian</option><option value="id">Indonesian</option><option value="it">Italian</option><option value="ja">Japanese</option><option value="ko">Korean</option><option value="lv">Latvian</option><option value="lt">Lithuanian</option><option value="no">Norwegian</option><option value="fa">Persian</option><option value="pl">Polish</option><option value="pt">Portuguese</option><option value="ro">Romanian</option><option value="ru">Russian</option><option value="sk">Slovak</option><option value="sl">Slovenian</option><option value="es">Spanish</option><option value="sv">Swedish</option><option value="th">Thai</option><option value="tr">Turkish</option><option value="uk">Ukrainian</option><option value="vi">Vietnamese</option></select>
	    			</td>
	    			<td>生产企业:</td>
	    			<td><input class="easyui-textbox" type="text" name="wBusiness" data-options="required:false"></input></td>
	    			<td>生产产地:</td>
	    			<td><input class="easyui-textbox" type="text" name="wPlace" data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
	    			<td>件装量:</td>
	    			<td><input class="easyui-textbox" type="text" name="wMax" data-options="required:false"></input></td>
	    			<td>件单位:</td>
	    			<td><input class="easyui-textbox" type="text" name="wMaxunit" data-options="required:false"></input></td>
	    			<td>最小包装:</td>
	    			<td><input class="easyui-textbox" type="text" name="wMin" data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
	    			<td>最小包装单位:</td>
	    			<td><input class="easyui-textbox" type="text" name="wMinunit" data-options="required:false"></input></td>
	    			<td>中包装:</td>
	    			<td><input class="easyui-textbox" type="text" name="wMid" data-options="required:false"></input></td>
	    			<td>中包装单位:</td>
	    			<td><input class="easyui-textbox" type="text" name="wMidunit" data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
	    			<td>商品状态:</td>
	    			<td><input class="easyui-textbox" type="text" name="wStatus" data-options="required:false"></input></td>
	    			<td>创建人:</td>
	    			<td><input class="easyui-textbox" type="text" name="wCreator" data-options="required:false"></input></td>
	    		</tr>
	    		</table>
	    		</fieldset>
	    		
	    		<!-- 扩展信息 -->
	    		<fieldset style="border:solid 1px #aaa;margin-top:8px;position:relative;">
        		<legend>扩展信息</legend>
	    		<table>
	    		<tr>
	    			<td>贮存条件:</td>
	    			<td><input class="easyui-textbox" type="text" name="wStoreage" data-options="required:false"></input></td>
	    			<td>医保编码:</td>
	    			<td><input class="easyui-textbox" type="text" name="wMedicalId" data-options="required:false"></input></td>
	    			<td>医保名称:</td>
	    			<td><input class="easyui-textbox" type="text" name="wMedicalName" data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
	    			<td>功能疗效:</td>
	    			<td><input class="easyui-textbox" type="text" name="wFunction" data-options="required:false"></input></td>
	    			<td>注册证号:</td>
	    			<td><input class="easyui-textbox" type="text" name="wRegId" data-options="required:false"></input></td>
	    			<td>注册证效期:</td>
	    			<td><input class="easyui-datebox" type="text" name="wRegExpdate" data-options="required:false"></input></td>
	    		</tr>
	    		</table>
	    		</fieldset>
	    		<!-- 价格信息 -->
	    		<fieldset style="border:solid 1px #aaa;margin-top:8px;position:relative;">
        		<legend>扩展信息</legend>
	    		<table>
	    		<tr>
	    			<td>成本价:</td>
	    			<td><input class="easyui-textbox" type="text" name="wCostprice" data-options="required:false"></input></td>
	    			<td>零售价:</td>
	    			<td><input class="easyui-textbox" type="text" name="wSaleprice" data-options="required:false"></input></td>
	    			<td>会员价:</td>
	    			<td><input class="easyui-textbox" type="text" name="wVipprice" data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
	    			<td>批发价:</td>
	    			<td><input class="easyui-textbox" type="text" name="wSellprice" data-options="required:false"></input></td>
	    			<td>拆零零售价:</td>
	    			<td><input class="easyui-textbox" type="text" name="wMinSaleprice" data-options="required:false"></input></td>
	    			<td>拆零会员价:</td>
	    			<td><input class="easyui-textbox" type="text" name="wMinVipprice" data-options="required:false"></input></td>
	    		</tr>
	    		<tr>
	    			<td>拆零批发价:</td>
	    			<td><input class="easyui-textbox" type="text" name="wMinSellprice" data-options="required:false"></input></td>
	    			<td>国家标准零售价:</td>
	    			<td><input class="easyui-textbox" type="text" name="wStandardSaleprice" data-options="required:false"></input></td>
	    			<td>国家标准批发价:</td>
	    			<td><input class="easyui-textbox" type="text" name="wStandardSellprice" data-options="required:false"></input></td>
	    		</tr>
	    	</table>
	    	 </fieldset>
	      </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清空</a>
	    </div>
	    </div>
	</div>
	<script>
	$(function(){
	    //alert("--2--title:"+$('#admin_tabs').tabs('exists','商品信息'));
	    //var tab = $('#admin_tabs').tabs('getSelected');
	    //alert("--tab:"+tab);
	    //tab.panel('setTitle','添加商品信息');
		
	    /**第一种
		$('#ff_wares').form({
		    url:'/erp/wares/save.yy',
		    onSubmit: function(){
				// do some check
				// return false to prevent submit;
		    },
		    success:function(data){
				alert(data)
		    }
		});
		*/
		var wid = '${wid}';
		if(wid != "@err"){
			var url = '/erp/wares/add_json.yy?wid='+wid;
			$('#ff_wares').form('load', url);
			//$('#wId').textbox('textbox').attr('readonly',true);  //设置输入框为禁用
			$('#wId').prop('readonly',true);
			$('#wId').validatebox({required: false});
			$("#wId").removeAttr("onblur");
			// 覆盖已绑定的onblur事件。此时仅弹出hi  
			    //$( '#input1').removeAttr('onblur').on('blur',showHi);  
			    // 添加onblur事件，以前绑定的仍存在。此时先弹出hello，再弹出hi  
			    //$( '#input1').on('blur',showHi); 
		}
	});
		function submitForm(){
			//第一种
			//$('#ff_wares').submit();
			//第二种
			$('#ff_wares').form('submit',{
				onSubmit:function(){
					return $(this).form('validate');
				},
			    success:function(data){
			    	var rj = eval('(' + data + ')');
			    	if(rj.status == 1){
			    		var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
						tab.panel('refresh','/erp/wares/index.yy');
			    	}else{
			    		$.messager.alert('Info', rj.desc, 'error');
			    	}
			    	
					//alert("---add data:"+data);
					//alert("---data.status:"+data.status);
					/**
					 var tab = $('#admin_tabs').tabs('getSelected');
			            var body = tab.panel('body');
			            //alert("--tab"+tab);
			            body.html(data)
			            */
			            /**
					$('#admin_tabs').tabs('update', {
						tab:tab,
						options: {
							href:'/erp/wares/index.yy'
						}
					});
			           */
			    }
			});
			
		}
		function clearForm(){
			$('#ff_wares').form('clear');
		}
		
		function isExistId(){
			var wid = $('#wId').val();
			//$.messager.alert('Info',wid, 'info');
			$.post("/erp/wares/checkWid_json.yy",
					{wid:wid},
					function(data){
						if(data == 1){
							$.messager.alert('Info', "商品编号已存在", 'error');
							//$('#wId').select();
							//$('#wId').focus();
						}
					}
				);
		}
	</script>
