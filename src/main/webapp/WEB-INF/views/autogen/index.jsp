<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic TextBox - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="/erp/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="/erp/css/icon.css">
    <link rel="stylesheet" type="text/css" href="/erp/css/demo.css">
    <script type="text/javascript" src="/erp/js/jquery.min.js"></script>
    <script type="text/javascript" src="/erp/js/jquery.easyui.min.js"></script>
</head>
<body>
<div style="margin:100px auto;width:400px;">
<div class="easyui-panel" title="自动生成功能" style="margin:0 auto;width:300px;padding:30px 60px;">
    <form id="ff_autogen" method="post" action="/erp/autogen/gen.yy" data-options="novalidate:false">
    <div style="margin-bottom:20px">
        <div>表名</div>
        <input class="easyui-textbox" name="tableName" style="width:100%;height:32px" data-options="required:true">
    </div>
    <div style="margin-bottom:20px">
        <div>实体类名</div>
        <input class="easyui-textbox" name="entityName" style="width:100%;height:32px" data-options="required:true">
    </div>

    <div>
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok"  onclick="submitForm()" style="width:100%;height:32px">自动生成</a>
    </div>
    </form>
</div>
</div>
<script>
    function submitForm(){
//        $('#ff_login').form('submit');
//        $('#ff_autogen').submit();

        $('#ff_autogen').form('submit',{
            onSubmit:function(){
                return $(this).form('validate');
//                return $(this).form();
            },
            success:function(data){
                var rj = eval('(' + data + ')');
                $.messager.alert('Info',rj.desc, 'Info');
            }
        });
    }

</script>
</body>
</html>