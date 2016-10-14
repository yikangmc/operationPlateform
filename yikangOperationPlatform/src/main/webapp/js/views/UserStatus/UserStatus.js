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
		openModal:function(pushAlias,userId){
			window.push_alias=pushAlias;
			window.user_id=userId;
			$("#myModal").modal("show");
		},
		modalSubmit:function(){
			var pushAlias=window.push_alias;
			var userId=window.user_id;
			$("input[name='push_alias']").val(pushAlias);
			$("input[name='userId']").val(userId);
			$("#statusForm").submit();
		},
		imgWindow:function(imgSrc){
			$("#imgWindow").modal("show");
			$("#imageId").attr("src",imgSrc);
		}
}

var userStatus=new UserStatus();
userStatus.init();