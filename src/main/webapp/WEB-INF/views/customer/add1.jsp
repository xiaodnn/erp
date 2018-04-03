<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>供应商</title>
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
		<div>供应商信息</div>
		<div>
			<form action="">
				<div><span>名称</span><span><input type="text" id="dname" name="dname"/></span></div>
				<div><span>启用</span><span><input type="text" id="dvalid" name="dvalid"/></span></div>
				<div><span>电话</span><span><input type="text" id="dphone" name="dphone"/></span></div>
				<div><span>折扣率</span><span><input type="text" id="ddiscount" name="ddiscount"/></span></div>
				<div><span>信誉</span><span><input type="text" id="dcredit" name="dcredit"/></span></div>
				<div><span>类型</span><span><input type="text" id="dtype" name="dtype"/></span></div>
				<div><span>主营业务</span><span><input type="text" id="doperation" name="doperation"/></span></div>
				<div><span>传真</span><span><input type="text" id="dfax" name="dfax"/></span></div>
				<div><span>邮箱</span><span><input type="text" id="demail" name="demail"/></span></div>
				<div><span>网站</span><span><input type="text" id="dsite" name="dsite"/></span></div>
				<div><span>余额</span><span><input type="text" id="dbalance" name="dbalance"/></span></div>
				<div><span>备注</span><span><input type="text" id="dremarks" name="dremarks"/></span></div>
			</form>
		</div>	
	</div>
</body>
</html>