YouHui=function(){}
YouHui.prototype={
		init:function(){
		},
		saveYouHui:function(){
			$.post(basePath+"shareUser/regiestUser",$("#userForm").serializeArray(),function(data){
				if(null != data && data.status=="000000"){
					alert(data.message);
				}else{
					alert(data.message);
				}
			});
		},
		getCaptcha:function(){
			$.post(basePath+"shareUser/getCaptcha",$("#userForm").serializeArray(),function(data){
				if(null != data && data.status=="000000"){
					alert(data.message);
				}else{
					alert(data.message);
				}
			});
		},
		validateCaptcha:function(){
			$.post(basePath+"shareUser/validateCaptcha",$("#userForm").serializeArray(),function(){
				if(null != data && data.status=="000000"){
					alert(data.message);
				}else{
					alert(data.message);
				}
			});
		},
		validateMobileNumber:function(){
			$.post(basePath+"shareUser/validateMobileNumber",$("#userForm").serializeArray(),function(){
				if(null != data && data.status=="000000"){
					alert(data.message);
				}else{
					alert(data.message);
				}
			});
		}
}

var youHui=new YouHui();
youHui.init();


$(document).ready(function(){
	var width = $(window).width();
	var heigth = $(window).height();
	if(width >= heigth){
		$(".dv_body").css({"padding-left":"30%","padding-right":"30%"});
		$(".dv_banner").css({"height":"50%"});
		$(".dv_bodytitle").css({"padding-left":"30%","padding-right":"30%"});
		$(".right_fonts").css({"position:relative":"16px"});
		$(".titletop").css({"margin-top":"-120px"});
	}

});
//$(function () { $('#myModal').modal({
//	keyboard: true
//})});

//<!-- 验证时间 -->
//var wait=60;  
//var ini = 0;
//function time(o) {
//	if(ini >= 1){
//		alert(1);
//			if (wait == 0) {
//		alert(2);
//				o.removeAttribute("disabled");
//				wait = 60;  
//			} else {  
//		alert(3);
//				o.setAttribute("disabled", true);
//				wait--;  
//				setTimeout(function() {  
//					time(o)  
//				},  
//				1000)  
//			}
//		}
//	}
//document.getElementById("input_heightthree").onclick=function(){time(this);}  

function Confirmationphone() {
	if ($("#input_heightone").val() == "") { 
		alert("手机号码不能为空！"); 
		$("#input_heightone").focus(); 
			return false; 
	} 
	
	if (!$("#input_heightone").val().match(/^(((13[0-9]{1})|159|153)+\d{8})$/)) { 
		alert("手机号码格式不正确！");
		$("#input_heightone").focus(); 
			return false; 
	}
	alert("已发送验证码致 ：" + $("#input_heightone").val() +", 请注意接收，60秒后可重新发送。");
	ini = 1;
	return true; 
} 

function Verification(){
	if ($("#input_heighttwo").val() == "") { 
		alert("验证码不为空！"); 
		$("#input_heighttwo").focus(); 
			return false; 
	}
	
	if(!$("#input_heighttwo").val().match(/^\d{6}$/)) {
		alert("验证码格式不正确！");
		$("#input_heighttwo").focus(); 
			return false; 
	}
	
	if ($("#input_heightone").val() == "") { 
		alert("手机号码不能为空！"); 
		$("#input_heightone").focus(); 
			return false; 
	} 
	
	if (!$("#input_heightone").val().match(/^(((13[0-9]{1})|159|153)+\d{8})$/)) { 
		alert("手机号码格式不正确！");
		$("#input_heightone").focus(); 
			return false; 
	}
	alert("验证成功！");
	return true;
}




