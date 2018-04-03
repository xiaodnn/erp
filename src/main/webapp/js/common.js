//显示审批流程
function showApprove(mId,rId) {
    $.post("/erp/mapapproverecord/find_map_approve_info.yy",
        {mId:mId,rId:rId},
        function(data) {
            if (data != "") {
                //debugger;
                var approve = data.approve;
                var mar = data.mapApproveRecord;
                $("#tr_approve1").show();
                $("#a_approve").show();
                var alevel = approve.aLevel;
                if(alevel > 3){
                    $("#tr_approve2").show();
                }
                if(alevel >= 1){
                    $('#td_approve_d1').html(approve.dname1+":");
                    if(mar.marUid1 != undefined) {
                        $('#td_approve_u1').html("<font color='red'>"+approve.uname1+"</font>");
                    }else {
                        $('#td_approve_u1').html(approve.uname1);
                    }
                }
                if(alevel >= 2){
                    $('#td_approve_d2').html(approve.dname2+":");
                    if(mar.marUid2 != undefined) {
                        $('#td_approve_u2').html("<font color='red'>"+approve.uname2+"</font>");
                    }else {
                        $('#td_approve_u2').html(approve.uname2);
                    }
                }
                if(alevel >= 3){
                    $('#td_approve_d3').html(approve.dname3+":");
                    if(mar.marUid3 != undefined) {
                        $('#td_approve_u3').html("<font color='red'>"+approve.uname3+"</font>");
                    }else {
                        $('#td_approve_u3').html(approve.uname3);
                    }
                }
                if(alevel >= 4){
                    $('#td_approve_d4').html(approve.dname4+":");
                    if(mar.marUid4 != undefined) {
                        $('#td_approve_u4').html("<font color='red'>"+approve.uname4+"</font>");
                    }else {
                        $('#td_approve_u4').html(approve.uname4);
                    }
                }
                if(alevel >= 5){
                    $('#td_approve_d5').html(approve.dname5+":");
                    if(mar.marUid5 != undefined) {
                        $('#td_approve_u5').html("<font color='red'>"+approve.uname5+"</font>");
                    }else {
                        $('#td_approve_u5').html(approve.uname5);
                    }
                }
                if(alevel >= 6){
                    $('#td_approve_d6').html(approve.dname6+":");
                    if(mar.marUid6 != undefined) {
                        $('#td_approve_u6').html("<font color='red'>"+approve.uname6+"</font>");
                    }else {
                        $('#td_approve_u6').html(approve.uname6);
                    }
                }

//                            $('#td_approve_d1').html("运营部:");
//                            $('#td_approve_u1').html("<font color='red'>qr</font>");
//                            $('#td_approve_d2').html("采购部:");
//                            $('#td_approve_u2').html("<font color='red'>aa</font>");
//                            $('#td_approve_d3').html("财务部:");
//                            $('#td_approve_u3').html("张三");

            }
        }
    );
}

//显示审批对话框
function showApproveDialog(mId,mName,rId) {
//        $('#dlg_opapprove').dialog('open');
//     $('#dlg_opapprove').dialog({
//         modal: true ,
//         href:'/common/op_approve.jsp',
//         onLoad:function(){
//             $("#mId").textbox("setValue","1");
//             $("#mName").textbox("setValue","采购入库单据1");

//         }
//     });
//     $('#dlg_opapprove').dialog('open');

    // $("#index_dlg").load("/erp/common/op_approve.jsp");
    // $('#dlg_opapprove').dialog({
    //     onOpen:function(){
    //         $('#mName').val("赋值");
    //     },
    //     onLoad:function(){
    //         $('#rId').val("赋值");
    //     },
    // });


    $('#dlg_opapprove').dialog({
        left:"450px",
        top:"200px",
        title: '审核操作',
        inline:false,
        closed:true,
        width: 400,
        height: 350,
        cache: false,
        buttons:"#footer",
        shadow:false,
        modal: true ,
        href:'/erp/common/op_approve.jsp',
        onOpen:function(){
            // $('#name').val("赋值");
            // $("#mId").textbox("setValue","1");
            // $("#mName").textbox("setValue","采购入库单据1");
            // $("#rId").val("201707011000021");
        },
        onLoad:function(){
            $("#mId").val(mId);
            $("#mName").textbox("setValue",mName);
            $("#rId").textbox("setValue",rId);
        },

    });



    $("#dlg_opapprove").dialog('center');
    $('#dlg_opapprove').dialog("open");
    // $("#rId").val("201707011000021");
}


function submitApproveDialogForm() {
    // var state = $('input:radio[name="state"]:checked').val();
    var state = $("input[name='state']:checked").val();
    if(!state){
        $.messager.alert('提示',"请选择审批意见。");
        return false;
    }
    //第二种
    $('#ff_approve_dialog').form('submit',{
        onSubmit:function(){
            return $(this).form('validate');
//                return $(this).form();
        },
        success:function(data){
            var rj = eval('(' + data + ')');
            $.messager.alert('提示',rj.desc, 'Info',function () {
                cancelApproveDialogForm();
                $("#ff_approve").form('clear');

                var selectTab = $('#admin_tabs').tabs('getSelected');
                var url = $(selectTab.panel('options')).attr('href');
                // var url =$(selectTab.panel('options').content).attr('src');
                // alert("url2:"+url);
                $('#admin_tabs').tabs('update', {
                    tab : selectTab,
                    options : {
                        href : url
                    }
                });
                selectTab.panel('refresh');
            });
            // if(rj.status == 1){
            //     dialog_close();
            //     $("#ff_approve").form('clear');
            //     // init();刷新当前tab
            //     // var tab = $('#admin_tabs').tabs('getSelected');  // get selected panel
            //     // tab.panel('refresh',url);
            //     var selectTab = $('#admin_tabs').tabs('getSelected');
            //
            //     var url =$(selectTab.panel('options').content).attr('src');
            //
            //     $('#admin_tabs').tabs('update', {
            //         tab : selectTab,
            //         options : {
            //             href : url
            //         }
            //     });
            // }
        }
    });
}
function cancelApproveDialogForm() {
    $("#dlg_opapprove").dialog("close");
}

