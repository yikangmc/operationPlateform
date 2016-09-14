var Article = function() {
}
Article.prototype = {
	init : function() {

	},
	del : function(forumPostId, basePath) {
		if (confirm("确定要删除吗？")) {
			$.ajax({
				type : "POST",
				data : {
					'forumPostsId' : forumPostId
				},
				url : basePath + "forumArticleMange/deleteForumPost",
				dataType : "json",
				success : function(result) {
					if ("success" == result.data) {
						alert("删除成功");
						window.location.reload();
					} else {
						alert("删除失败，此贴下边有回答未删除");
					}
				},
				error : function(result) {
					alert("删除出错" + result);
				}
			});
		}
	},
	updateEssence:function(forumPostId,basePath){
		if(confirm("确定要设为精华吗？")){
			$.post(basePath+"/forumArticleMange/isEssenceForumArticle", { "forumPostsId": forumPostId}, function (data,status) {
				if(null != data && data.status == "000000"){
					alert(data.message);
				}else{
					alert(data.message)
				}
//				article.relond();
			});		        
		}
	},		
	cancelEssence:function(forumPostId,basePath){
		if(confirm("确定要取消精华吗？")){
			$.post(basePath+"/forumArticleMange/cancelEssenceForumArticle", { "forumPostsId": forumPostId}, function (data,status) {
				if(null != data && data.status == "000000"){
					alert(data.message);
				}else{
					alert(data.message)
				}
//				article.relond();
			});		        
		}
	},
	relond:function(){
		window.location.href=basePath+"forumPost/articleList";
	}
}

var article = new Article();
article.init();