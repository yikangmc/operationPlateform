appointmentList=function(){}
appointmentList.prototype={
		init:function(){
		},
		updateAppointmentStatus:function(userId){
			$.post(basePath+"appointment/updateUserStatusByUserId",{'userId':userId},function(data){
				if(null != data){
					alert(data.message);
				}
				userStatus.reflushPage();
			});
		},
		reflushPage:function(){
			window.location.href=basePath+"userStatus/getUserStatusList";
		}
}

var appointmentList=new appointmentList();
appointmentList.init();