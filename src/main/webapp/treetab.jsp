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
       <div data-options="region:'north'" style="height:70px; text-align: center">
           <h1>EasySpring后台管理</h1>
       </div>
       <div data-options="region:'south',split:true" style="height:50px;"></div>
       <div data-options="region:'west',split:true,title:'菜单栏',iconCls:'icon-ok'" style="width:250px;">
           <div class="easyui-accordion" data-options="fit:true,border:false">
               <!-- 这里由于只有一个，所以不设置title-->
               <div data-options="fit:true,collapsible:false" style="padding:10px;"><!-- 每一个div都是accordion中依赖的panel -->
                    <ul class="westBar" id="admin">
                        <li id="adminUser"><span class="icon-search" style="height:16px;width:16px;display:inline-block"></span>用户管理</li>
                        <li id="adminRole"><span class="icon-search" style="height:16px;width:16px;display:inline-block"></span>角色管理</li>
                        <li id="adminPermission"><span class="icon-search" style="height:16px;width:16px;display:inline-block"></span>权限管理</li>
                    </ul>
               </div>
           </div>
       </div>
       <div data-options="region:'center',iconCls:'icon-ok'">
           <div id="admin_tabs" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
           </div>
       </div>
</body>
<script>
$(function(){
    $("ul.westBar li").on("click", function(){
        // 添加选中样式
        $("ul.westBar li").removeClass('active');
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