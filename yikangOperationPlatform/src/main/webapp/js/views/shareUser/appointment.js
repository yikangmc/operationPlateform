Appointment=function(){}
Appointment.prototype={
		init:function(){
		},
		saveYouHui:function(){
			$.post(basePath+"appointmentUser/regiestUser",$("#userForm").serializeArray(),function(data){
				if(null != data && data.status=="000000"){
					alert(data.message);
				}else{
					alert(data.message);
				}
			});
		},
		getCaptcha:function(){
			$.post(basePath+"appointmentUser/getCaptcha",$("#userForm").serializeArray(),function(data){
				if(null != data && data.status=="000000"){
					alert(data.message);
				}else{
					alert(data.message);
				}
			});
		},
		validateCaptcha:function(){
			$.post(basePath+"appointmentUser/validateCaptcha",$("#userForm").serializeArray(),function(){
				if(null != data && data.status=="000000"){
					alert(data.message);
				}else{
					alert(data.message);
				}
			});
		},
		validateMobileNumber:function(){
			$.post(basePath+"appointmentUser/validateMobileNumber",$("#userForm").serializeArray(),function(){
				if(null != data && data.status=="000000"){
					alert(data.message);
				}else{
					alert(data.message);
				}
			});
		}
}

var appointment=new Appointment();
appointment.init();


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

