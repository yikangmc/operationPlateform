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
	}
}

var article = new Article();
article.init();