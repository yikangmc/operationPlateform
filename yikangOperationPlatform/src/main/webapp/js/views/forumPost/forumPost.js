var ForumPost=function(){}
ForumPost.prototype={
		init:function(){
			
		},
		checkParam:function(){
			var userName=$("input[name='userName']").val();
			var title=$("input[name='title']").val();
			var recommendPicUrlImage=$("#recommendPicUrlImage").attr("src");
			var content=$("input[name='content']").val();
			var taglibId=$("input[name='taglibId']:checked").val();
			if(userName == ''){
				alert('用户名不能为空！');
				return false;
			}
			if(title == ''){
				alert('标题为空！');
				return false;
			}
			if(typeof(taglibId) == "undefined" || taglibId == ''){
				alert('请选择标签！');
				return false;
			}
			if(recommendPicUrlImage == ''){
				alert('请添加推荐图片！');
				return false;
			}
			if(content == ''){
				alert('请填写内容！');
				return false;
			}
			$("#paramForm").submit();
		},
		del:function(forumPostId,basePath){
			if(confirm("确定要删除吗？")){
			
			$.post(basePath+"/forumPosts/deleteFormPost", { "forumPostsId": forumPostId }, function (data,status) {
              if (status == "success") {
                  alert("删除成功！");
                  window.location.reload();
              }
          });
			}
		},
		updateEssence:function(forumPostId,basePath){
			if(confirm("确定要设为精华吗？")){
				$.post(basePath+"/forumPosts/isEssenceForumPosts", { "forumPostsId": forumPostId}, function (data,status) {
					if(null != data && data.status == "000000"){
						alert(data.message);
					}else{
						alert(data.message)
					}
					forumPost.relond();
				});		        
			}
		},		
		cancelEssence:function(forumPostId,basePath){
			if(confirm("确定要取消精华吗？")){
				$.post(basePath+"/forumPosts/cancelEssenceForumPosts", { "forumPostsId": forumPostId}, function (data,status) {
					if(null != data && data.status == "000000"){
						alert(data.message);
					}else{
						alert(data.message);
					}
					forumPost.relond();
				});		        
			}
		},
		relond:function(){
			window.location.href=basePath+"forumPosts/formPostList";
		}
}
var forumPost=new ForumPost();
forumPost.init();