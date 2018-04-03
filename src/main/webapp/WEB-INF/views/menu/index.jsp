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
					<ul class="easyui-tree"  id="admin">
						<c:forEach items="${m.menusub}" var="s">
							<li id="${s.msUrlname}">${s.msName}</li>
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
		</div>
	</div>
	<div data-options="region:'center',iconCls:'icon-ok'">
	    <div id="admin_tabs" class="easyui-tabs" data-options="fit:true,border:false,plain:true"></div>
	</div>
</body>
<script>
$(function(){
    $("ul.easyui-tree li").on("click", function(){
        // 添加选中样式
        $("ul.easyui-tree li").removeClass('active');
        $(this).addClass('active');

        var id = $(this).attr('id');
        if($(this).hasClass('zdialog')){ // 这里可以扩展对话框菜单
            $('#' + id + '-dialog').dialog('open');
            return;
        }
        var id = $(this).attr('id');
        var title = $(this).text();
        var iconCls = $(this).find("span").attr('class');
        var parent = $(this).parent().attr('id');
        addTabs(id, title, iconCls, parent);
    })
});

function addTabs(id, title, iconCls, parent){
    if($('#admin_tabs').tabs('exists',title)){ // 处理已打开过的tab
        $('#admin_tabs').tabs('select',title);
        return;
    }
    if(!iconCls){
        iconCls = 'icon-ok';
    }
    $('#admin_tabs').tabs('add',{
        title: title,
        href: 'erp/	/' + id, // 这里用parent + id来定义url
        iconCls: iconCls,
        closable: true,
        onLoadError:function(data){
            // 这里对于非200状态码的都会加载不出来界面，而需要在这里手动处理
            var tab = $('#admin_tabs').tabs('getSelected');
            var body = tab.panel('body');
            if(data.status == 401){
                body.html(data.responseText)
            }else{
                body.html('<h1>加载出错</h1>');
            }
        }
    });
    
    /**
    $('#admin_tabs').tabs('add',{
        title: title,
        href: contextPath + '/' + parent + '/' + id, // 这里用parent + id来定义url
        iconCls: iconCls,
        closable: true,
        onLoadError:function(data){
            // 这里对于非200状态码的都会加载不出来界面，而需要在这里手动处理
            var tab = $('#admin_tabs').tabs('getSelected');
            var body = tab.panel('body');
            if(data.status == 401){
                body.html(data.responseText)
            }else{
                body.html('<h1>加载出错</h1>');
            }
        }
    });
    */
}
</script>

</html>