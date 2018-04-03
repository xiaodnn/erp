<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>菜单</title>
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
						<c:forEach items="${m.menusub}" var="s">
							<li><a href="${s.msUrl}">${s.msName}</a></li>
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
	 <div data-options="region:'center',iconCls:'icon-ok'">
		<div id="admin_tabs" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
			<div title="我的主页" style="padding:10px;">
				jQuery easyui framework help you build your web page easily.
			</div>
			<div title="Contacts">
				No contact data.
			</div>
		</div>
	</div>
</body>
</html>