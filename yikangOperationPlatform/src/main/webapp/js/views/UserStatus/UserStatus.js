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
		},
		openModal:function(pushAlias){
			window.push_alias=pushAlias;
			$("#myModal").modal("show");
		},
		modalSubmit:function(){
			var pushAlias=window.push_alias;
			$("input[name='push_alias']").val(pushAlias);
			$("#statusForm").submit();
		}
}

var userStatus=new UserStatus();
userStatus.init();