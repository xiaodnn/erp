<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>菜单</title>
<link rel="stylesheet" type="text/css" href="/erp/css/easyui.css">
<link rel="stylesheet" type="text/css" href="/erp/css/icon.css">
<link rel="stylesheet" type="text/css" href="/erp/css/demo.css">
<link rel="stylesheet" type="text/css" href="/erp/css/style.css">
<script type="text/javascript" src="/erp/js/jquery.min.js"></script>
<script type="text/javascript" src="/erp/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/erp/js/datagrid-detailview.js"></script>
<script type="text/javascript" src="/erp/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/erp/js/common.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"	style="height: 0px; background: #B3DFDA; padding: 0px">
		<!-- <div style="height: 0px;background-size:100% 100%;"></div> -->
	</div>
	<div data-options="region:'west',split:true,title:'导航'" style="width: 162px;">
		<!--<div class="easyui-accordion" style="width: 155px;">-->
			<!-- 数据加载 -->
			<ul id="treeMenu" class="easyui-tree">
			</ul>
		<!--</div>-->
	</div>
	<div data-options="region:'east',split:false,collapsed:true,title:'East'" style="width: 100px; padding: 10px;">east region</div>
	<div data-options="region:'south',border:false"	style="height: 30px; background: #B3DFDA; padding: 1px;">south	region</div>
	 <div data-options="region:'center',iconCls:'icon-ok'">
		<div id="admin_tabs" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
			<div title="我的主页">
				<table id="dg_approvebills" class="easyui-datagrid" style="width:100%;height:auto;"
					   data-options="url:'/erp/approvebill/index.yy',method:'post',
					   title:'审批单据',singleSelect:true,fitColumns:true,rownumbers:true,pagination:true,onDblClickRow:ridHref">
					<thead>
					<tr align="center">
						<th field="mId" align="center" width="80">模板ID</th>
						<th field="mName" align="center" width="150">模板名称</th>
						<th data-options="field:'rId',width:'100'" align="center" >单据ID</th>
					</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>

	<!-- 审批 -->
	<div id="dlg_opapprove" class="easyui-dialog" title="审核操作" style="width:400px;height:350px;padding:10px;"
		 data-options="closed:true">

	</div>

</body>
<script type="text/javascript">
$(function(){
	//url的值是异步获取数据的页面地址
    $('#treeMenu').tree({
        url:'/erp/menu/index.yy',
        lines:true,
        onClick:function(node){
	       if (node.attributes !== undefined && node.attributes.url !== undefined) {
	    	   //alert(node.id+","+node.text+","+node.attributes.url);
	    	   addTabs(node.id,node.text,node.attributes.url);    
	       }
		}
    });
});

function addTabs(id, title, parent){
	//alert("-----id:"+id+",title:"+title+",parent:"+parent);
	//iconCls,
	//alert();
    if($('#admin_tabs').tabs('exists',title)){ // 处理已打开过的tab
        $('#admin_tabs').tabs('select',title);
        return;
    }
	/**
    if(!iconCls){
        iconCls = 'icon-ok';
    }
	*/
    $('#admin_tabs').tabs('add',{
        title: title,
        href: parent, // 这里用parent + id来定义url
        //iconCls: iconCls,
        closable: true,
        onLoadError:function(data){
            // 这里对于非200状态码的都会加载不出来界面，而需要在这里手动处理
            var tab = $('#admin_tabs').tabs('getSelected');
            var body = tab.panel('body');
            alert("---data.status:"+data.status);
            if(data.status == 401){
                body.html(data.responseText)
            }else{
                body.html('<h1>加载出错</h1>');
            }
        }
    });

	/**添加工具栏
    $('#admin_tabs').tabs({
    	tools:[{
    		iconCls:'icon-add',
    		handler:function(){
    			alert('add')
    		}
    	},{
    		iconCls:'icon-save',
    		handler:function(){
    			alert('save')
    		}
    	}]
    });
	*/
}

$("#admin_tabs").tabs({
    onSelect:function(title,index){
        //当前tab
        var current_tab = $('#admin_tabs').tabs('getSelected');
        var url = $(current_tab.panel('options')).attr('href');
//        alert(title+","+url);
        $('#admin_tabs').tabs('update', {
       	        tab: current_tab,
       	        options: {
       	            href: url
       	        }
       	});
//        current_tab.panel('refresh');
    }
});

function ridHref(index,row) {
    //return "<a onclick=goApprovePage('"+row.mUrl+row.rId+"')>"+row.rId+"</a>";
    goApprovePage(row.mUrl+row.rId);    
}

function goApprovePage(url) {
    var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
    tab.panel('refresh',url);
}
//返回到模块主页
function callback(moudle){
	var call_tab = $('#admin_tabs').tabs('getSelected');
    //var url = $(current_tab.panel('options')).attr('href');
    var url = "/erp/"+moudle+"/index.yy";
    //alert(url);
    call_tab.panel('refresh',url);
}
</script>
</html>