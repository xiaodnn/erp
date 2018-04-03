<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>客户注册</title>
<style type="text/css">
html, body {
	margin: 0;
	padding: 0;
}
.zt {
	width: 1348px;
	height: 350px;
	padding-top: 30px;
}
.zt2 {
	width: 1348px;
	height: 660px;
	padding-top: 50px;
}
.zt3 {
	width: 1348px;
	height: 400px;
	text-align:left;
	padding-top: 30px;
}
.hang {
	width: 900PX;
	height: 30px;
	float: left;
}
.wb1 {
	width: 150px;
	text-align: right;
	display:block-inline;
	float: left;
}
.wbk {
	width: 150px;
	float: left;
	display:block-inline;
	text-align: left;
	margin-right: 10px;
}
.ts {
	width: 100px;
	text-align: left;
	float: left;
	display:block-inline;
}

</style>
<link rel="stylesheet" type="text/css" href="/erp/css/easyui.css">
<link rel="stylesheet" type="text/css" href="/erp/css/icon.css">
<link rel="stylesheet" type="text/css" href="/erp/css/demo.css">
<script type="text/javascript" src="/erp/js/jquery.min.js"></script>
<script type="text/javascript" src="/erp/js/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height: 60px; background: #B3DFDA; padding: 10px">north
		region</div>
	<div data-options="region:'west',split:true,title:'导航'"	style="width: 162px;">
		<div class="easyui-accordion" style="width: 155px;">
			<!-- 数据加载 -->
			<c:forEach items="${menus}" var="m" >
				<div title="${m.mName}" data-options="iconCls:'icon-ok'" style="overflow: auto; padding: 5px;">
					<ul class="easyui-tree">
						<c:forEach items="${m.childs}" var="c">
							<li>${c.cName}</li>
						</c:forEach>
					</ul>
				</div>
			</c:forEach>
		</div>
	</div>
	<div
		data-options="region:'east',split:true,collapsed:false,title:'East'"
		style="width: 100px; padding: 10px;">east region</div>
	<div data-options="region:'south',border:false"
		style="height: 50px; background: #A9FACD; padding: 10px;">south
		region</div>
	<div data-options="region:'center',title:'Center'">
	<!-- 开始 -->
	<form action="/erp/customer/reg.yy" method="post">
<div class="easyui-tabs">

	<div title="基础信息" style="padding:10px">
		<div class="hang">
						<span class="wb1">名称：</span>
						<span class="wbk"> <input name="cbFullname" type="text"  id="cbFullname" /></span>
						<span id="wb" class="ts"><font color="red">* </font></span> 
						<span class="wb1">简称：	</span>
						<span class="wbk"> <input name="cbShortname" type="text"  id="cbShortname" /></span>
						<span id="wb" class="ts"> <font color="red">* </font></span>
		</div>
				<div class="hang">
					<span class="wb1">法人代表：</span>
					<span class="wbk"><input name="cbAgentname" type="text"  id="cbAgentname" /></span>
					<span id="wb" class="ts"><font color="red">*</font></span>
					<span class="wb1">企业负责人：</span>
					<span class="wbk"><input name="cbBusname" type="text" id="cbBusname" /></span> 
					<span id="wb" class="ts"><font color="red">*</font></span>
	</div>
				<div class="hang">
					<span class="wb1">质量负责人：</span>
					<span class="wbk"><input name="cbGspname" type="text" id="cbGspname" /></span>
					<span id="wb" class="ts"><font color="red">*</font></span>
					<span class="wb1">注册资金：</span>
					<span class="wbk"> <input name="cbRegister" type="text" id="cbRegister" /></span> 
					<span id="wb" class="ts">（单位：万元）<font color="red">*</font></span>
				</div>
				<div class="hang">
					<span id="wb" class="wb1">经济性质：</span>
					<span class= "wbk"> <select name="cbEconomic" id="cbEconomic">
								<option>有限责任公司</option>
								<option>股份有限公司</option>
								<option>私营独资企业</option>
								<option>私营合资企业</option>
								<option>国有企业</option>
								<option>集体企业</option>
					</select>&nbsp;<font color="red">*</font> </span>
					<span class = "ts">&nbsp;</span>
					<span id="wb" class="wb1">经营方式：</span>
					<span class = "wbk"> <select name="cbOperate" id="cbOperate">
								<option>批发</option>
								<option>自产自销</option>
								<option>零售</option>
								<option>零售（连锁）</option>
								<option>诊所</option>
								<option>医院</option>
								<option>门诊部</option>
								<option>医疗机构</option>
								<option>连锁</option>
					</select></span>
				</div>
				<div class="hang">
					<span class="wb1">地址：</span>
					<span class="wbk"><input name="cbAddress" type="text" id="cbAddress"></span>
					<span class= "ts">&nbsp;</span>
					<span id="wb" class="wb1">仓库地址：</span> 
					<span class  ="wbk"><input name="cbStorehouse" type="text" id="cbStorehouse"> </span>
					<span class="ts"><font color="red">*</font></span>		
				</div>
				<div class = "hang">
					<span id="wb" class="wb1">省份：</span>
					<span class="wbk"><select name="cbProvince" id="cbProvince" >
							<option value="120">山东</option>
							<option value="010">10-北京</option>
							<option value="020">20-上海</option>
							<option value="030">30-天津</option>
							<option value="040">40-内蒙古</option>
							<option value="050">50-山西</option>
							<option value="060">60-河北</option>
							<option value="070">70-辽宁</option>
							<option value="080">80-吉林</option>
							<option value="090">90-黑龙江</option>
							<option value="100">江苏</option>
							<option value="110">安徽</option>
							<option value="130">浙江</option>
							<option value="140">江西</option>
							<option value="150">福建</option>
							<option value="160">湖南</option>
							<option value="170">湖北</option>
							<option value="180">河南</option>
							<option value="190">广东</option>
							<option value="200">海南</option>
							<option value="210">广西</option>
							<option value="220">贵州</option>
							<option value="230">四川</option>
							<option value="240">云南</option>
							<option value="250">陕西</option>
							<option value="260">甘肃</option>
							<option value="270">宁夏</option>
							<option value="280">青海</option>
							<option value="290">新疆</option>
							<option value="300">西藏</option>
							<option value="310">台湾</option>
					</select></span>
					<span class = "ts">&nbsp;</span>
					<span id="wb" class="wb1">城市：</span> 
					<span id="wb" class="wbk"><input name="cbCity" id="cbCity" type="text"></span> 
				</div>
				<div class= "hang">
					<span id="wb" class="wb1">联系人：</span> 
					<span class="wbk"> <input name="cbLinkman" type="text" id="cbLinkman" ></span>
					<span class="ts"><font color="red">*</font></span>
					<span id="wb" class="wb1">联系人电话：</span> 
					<span class="wbk"><input name="cbPhone" type="text" id="cbPhone"  maxlength="13">
					</span> 
					<span class="ts">（区号-号码）<font color="red">*</font></span>
	</div>
			<div class="hang">
				<span class="wb1" id="dh">电话：</span>
				<span class="wbk"><input name="text3" type="text" id="dh"></span>
				<span class="ts"><font color="red">*</font></span>
				<span class="wb1" id="yx">E-mail：</span>
				<span class="wbk"><input name="cbEmail" type="text"  id="cbEmail"></span>
				<span class="ts">（区号-号码）<font color="red">*</font></span>
	</div>
			<div class="hang">
				<span id="wb" class="wb1">传真号码：</span> 
				<span id="wb" class="wbk"><input name="cbFax" type="text" id="cbFax" maxlength="13"></span> 
				<span class="ts">（区号-号码）<font color="red">*</font></span> 
				<span id="wb" class="wb1">邮政编码：</span>
				<span id="wb" class="wbk"><input name="cbPostcode" type="text" id="cbPostcode" maxlength="6"></span> 
				<span class="ts"><font color="red">*</font></span>
			</div>
			<div class="hang">
				<span id="wb" class="wb1">税号：</span> 
				<span id="wb" class="wbk"><input name="cbTaxcode" type="text" id="cbTaxcode"></span>
				<span class="ts"> <font color="red">*</font></span>
				<span class="wb1">是否免税客户：</span>
				<span ><select class="wbk" name="" id="">
							<option>是</option>
							<option>否</option>
					</select></span>
					<span class="ts"> &nbsp;<font color="red">*</font></span>
			</div>
	</div>
	<div title="质量信息" style="padding:10px">
		<div class="hang">
					<span class="wb1"> 客户业务员：</span>
					<span class="wbk"><input type="text"></span>
					<span class="ts"><font color="red">*</font></span>
					<span class="wb1"> 客户业务员：</span>
					<span class="wbk"><input type="text"></span>
					<span class="ts"><font color="red">*</font></span>
				</div>
				<div class="hang">
					<span class="wb1">授权委托书起始日期：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
					<span class="wb1"> 客户业务员：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
				</div>
				<div class="hang">
					<span class="wb1"> 客户提货员：</span>
					<span class="wbk"><input type="text"></span>
					<span class="ts"><font color="red">*</font></span>
					<span class="wb1"> 提货员身份证号：</span>
					<span class="wbk"><input type="text"></span>
					<span class="ts"><font color="red">*</font></span>
				</div>
				<div class="hang">
					<span class="wb1">授权委托书起始日期：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
					<span class="wb1"> 授权委托书截止日期：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
				</div>
				<div class="hang">
					<span class="wb1"> 客户含麻黄碱制剂采购员：</span>
					<span class="wbk"><input type="text"></span>
					<span class="ts"><font color="red">*</font></span>
					<span class="wb1"> 采购员身份证号：</span>
					<span class="wbk"><input type="text"></span>
					<span class="ts"><font color="red">*</font></span>
				</div>
				<div class="hang">
					<span class="wb1">授权委托书起始日期：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
					<span class="wb1">授权委托书截止日期：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
				</div>
				<div class="hang">
					<span class="wb1">组织机构代码证号：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp; </span>
					<span class="wb1">组织机构代码证效期：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
				</div>
				<div class="hang">
					<span class="wb1">营业执照注册号：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp; </span>
					<span class="wb1">营业执照效期：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
				</div>
				<div class="hang">
					<span class="wb1">药品经营许可证号：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp; </span>
					<span class="wb1">药品经营许可证期限：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
				</div>
				<div class="hang">
					<span class="wb1">药品经营许可证发证机关：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp; </span>
					<span class="wb1">药品经营许可证发证日期：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
				</div>
				<div class="hang">
					<span class="wb1">医疗器械许可证号：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp; </span>
					<span class="wb1">医疗器械许可证效期：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
				</div>
				<div class="hang">
					<span class="wb1">食品流通许可证号码：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp; </span>
					<span class="wb1">食品流通许可证效期：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
				</div>
				<div class="hang">
					<span class="wb1">生产经营许证号码：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp; </span>
					<span class="wb1">生产经营许可证期限：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
				</div>
				<div class="hang">
					<span class="wb1">医疗机构执业许可证号：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp; </span>
					<span class="wb1">医疗机构执业许可证效期：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
				</div>
				<div class="hang">
					<span class="wb1">保健食品证书号码：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp; </span>
					<span class="wb1">保健食品证书效期：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
				</div>
				<div class="hang">
					<span class="wb1">批次检单打印标志：</span>
					<span ><span ><select class="wbk">
							<option>是</option>
							<option>否</option>
					</select></span></span>
					<span class="ts">&nbsp; </span>
					<span class="wb1">保健食品证书效期：</span>
					<span ><select class="wbk">
							<option>是</option>
							<option>否</option>
					</select></span>
					<span class="ts"></span>
				</div>
				<div class="hang">
					<span class="wb1">GSP证书号：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp; </span>
					<span class="wb1">GSP证书效期：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
				</div>
				<div class="hang">
					<span class="wb1">GSP发证机关：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp; </span>
					<span class="wb1">质量保证协议效期：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
				</div>
				<div class="hang">
					<span class="wb1">GSP发证日期</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp;</span>
				</div>
				<div class="hang">
					<span class="wb1">GSP发证机关：</span>
					<span ><input type="text" class="wbk"></span>
					<span class="ts">&nbsp; </span>
				</div>
	</div>
	<div title="准备下述资料" style="padding:10px">
		<div  style="text-align: center">
					<span><input type="file"></span>
					<span><input type="submit" value="添加文件"></span>
				</div>
			<div style="width:500px;height:150px;float:left;text-align:right">
							<br>
							  <br>
							文<br>
							件<br>
							列<br>
							表<br>
					：<br>
			</div >
			<div style="width:790px;height:180px;float:left;text-align:left">
					<textarea rows="10" cols="30"></textarea>
		</div>
				<div  style="text-align: center">
					<span><input type="submit" value="删除文件"></span>
					<span><input type="submit" value="完成上传"></span>
				</div>
				<div  style="text-align: center">
					<span>温馨提示：1、单张图片最大10M</span>
				</div>
				<div  style="text-align: center">
					<span>2、支持jpg，png，bmp，gif，jpeg格式</span>
				</div>
				<div  style="text-align: center">
					<span>3、请将相关的证件图片上传上来：商品条码、中包装条码、大包装条码、批准文号、</span>
				</div>
				<div  style="text-align: center">
					<span>GMP证书、执行标准、注册商标、产品包装、产品说明书</span>
				</div>
	</div>
</div>
	<input type="submit" value="提交" />
</form>
	<!-- 结束 -->
	</div>
</body>
</html>