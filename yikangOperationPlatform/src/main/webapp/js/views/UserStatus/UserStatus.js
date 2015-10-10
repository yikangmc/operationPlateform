UserStatus=function(){}
UserStatus.prototype={
		init:function(){
		},
		updateUserLinkStatus:function(userId){
			$.post(basePath+"userStatus/updateUserStatusByUserId",{'userId':userId},function(data){
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

var userStatus=new UserStatus();
userStatus.init();