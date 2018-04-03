<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 审批 -->
<!--
<div id="dlg_opapprove" class="easyui-dialog" title="审核操作" style="width:400px;height:350px;padding:10px;"
     data-options="closed:true">
-->
    <form id="ff_approve_dialog" class="easyui-form" method="post" action="/erp/mapapproverecord/approve_operate.yy" data-options="novalidate:false">
        <input type="hidden" id="mId" name="mId">
        <div style="margin:10px 0px;height: 40px;">
            <div style="float: left;width:18%;margin-left:8px;">单据名称:</div>
            <div style="float: left;width:75%;">
                <input class="easyui-textbox" id="mName" name="mName" style="width:95%;height:32px" readonly="readonly" readonly="true"/>
            </div>
        </div>
        <div style="margin-bottom:10px;height: 40px;">
            <div style="float: left;width:18%;margin-left:8px;">单据号:</div>
            <div style="float: left;width:75%;">
                <input class="easyui-textbox" id="rId" name="rId" style="width:95%;height:32px" >
            </div>
        </div>
        <div style="margin-bottom:10px;height: 70px;">
            <div style="float: left;width:18%;margin-left:8px;">审批简述:</div>
            <div style="float: left;width:75%;">
                <input class="easyui-textbox" name="remark" style="width:95%;height:64px" data-options="multiline:true">
            </div>
        </div>
        <div style="margin-bottom:5px;height: 40px;">
            <div style="float: left;width:18%;margin-left:8px;">审批意见:</div>
            <div style="float: left;width:75%;">
                <input type="radio" name="state" value="1"><span>通过</span>
                <input type="radio" name="state" value="2"><span>驳回</span>
                <input type="radio" name="state" value="3"><span>作废</span>
                <input type="radio" name="state" value="4"><span>撤回</span>
                <input type="radio" name="state" value="5"><span>终止</span>
            </div>
        </div>
        <div style="margin-bottom:10px;height:30px;text-align: center;">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitApproveDialogForm()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="cancelApproveDialogForm()">取消</a>
        </div>

    </form>
<!--
</div>
-->