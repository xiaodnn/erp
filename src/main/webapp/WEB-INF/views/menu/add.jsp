<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>菜单添加</title>
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
		<div>添加二级菜单</div>
		<div>
			<form action="/menu/add.yy">
				<div><span>一级菜单</span>
				<span><select name ="pId">
					<option> </option>
				</select></span></div>
				<div><span>二级菜单名</span><span><input type="text" id="mName" name=mName value="${menu.mid}"/></span></div>
				<div><span>状态</span><span><input type="text" id="mState" name="mState"/></span></div>
				<div><span>顺序</span><span><input type="text" id="ddiscount" name="ddiscount"/></span></div>
				<div><span>创建人</span><span><input type="text" id="dcredit" name="xinbie"/></span></div>
				<div><span><input type="submit" id="dremarks" name="dremarks" value="添加"/></span></div>
			</form>
		</div>	
	</div>
</body>
</html>