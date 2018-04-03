function getVilaCode(obj){
		var cmobile = $("#cmobile").val();
		var token = $("#token").val();
		var num = $("#num").val();
		var ccode = $("#ccode").val();
		if(cmobile == ""){
			alert("请输入手机号");
			return false;
		}else{
			time(obj);
			$.post("valiCode.yy",{Action: "post",token:token,num:num,cmobile:cmobile,ccode:ccode},
					function(data){
						 if(data != null && data > 0){
							 alert("验证码已发送,5分钟内有效.");
						 }else{
							 alert("验证码失败.");
						 }
					},
					'json'
					);
		}
	}
	
	var wait=60; 
	function time(obj) { 
		if (wait == 0) { 
			obj.removeAttribute("disabled");	
			obj.value="免费获取验证码"; 
			wait = 300;
		} else { 
			obj.setAttribute("disabled", true); 
			obj.value="重新发送(" + wait + ")"; 
			wait--; 
			setTimeout(function() { time(obj) }, 1000) 
		}
	} 