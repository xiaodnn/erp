<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="/erp/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="/erp/css/icon.css">
    <link rel="stylesheet" type="text/css" href="/erp/css/demo.css">
    <script type="text/javascript" src="/erp/js/jquery.min.js"></script>
    <script type="text/javascript" src="/erp/js/jquery.easyui.min.js"></script>
</head>
<body>
<div style="margin:100px auto;width:400px;">
<div class="easyui-panel" title="登录" style="margin:0 auto;width:300px;padding:30px 60px;" data-options="iconCls:'icon-login'">
    <form id="ff_login" method="post" action="/erp/user/login.yy">
    <div style="margin-bottom:20px">
        <div>用户名</div>
        <input class="easyui-textbox" name="uName" value="aa" style="width:100%;height:32px">
    </div>
    <div style="margin-bottom:20px">
        <div>密码</div>
        <input class="easyui-textbox" name="uPassword" value="111111" style="width:100%;height:32px">
    </div>

    <div>
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok"  onclick="submitForm()" style="width:100%;height:32px">登录</a>
    </div>
    </form>
</div>
</div>
<script>
    function submitForm(){
//        $('#ff_login').form('submit');
        $('#ff_login').submit();
    }

</script>
</body>
</html>