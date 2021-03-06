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
	updateEssence : function(forumPostId, basePath) {
		if (confirm("确定要设为精华吗？")) {
			orders = prompt("请输入排序的优先级（1-100）", "5");
			if (orders != null) {
				alert("本条帖子的优先级：" + orders);
			} else {
				alert("您没有设置优先级");
				return;
			}
			$.post(basePath + "/forumArticleMange/isEssenceForumArticle", {
				"forumPostsId" : forumPostId,
				"orders" : orders
			}, function(data) {
				if (null != data && data.status == "000000") {
					alert(data.message);

				} else {
					alert(data.message);
				}
				window.location.reload();
			});
		}
	},
	cancelEssence : function(forumPostId, basePath) {
		if (confirm("确定要取消精华吗？")) {
			$.post(basePath + "/forumArticleMange/cancelEssenceForumArticle", {
				"forumPostsId" : forumPostId
			}, function(data) {
				if (null != data && data.status == "000000") {
					alert(data.message);
				} else {
					alert(data.message);
				}
				window.location.reload();
			});
		}
	},
	relond : function() {
		window.location.href = basePath + "forumArticleMange/getAllArticleList";
	}
}

var article = new Article();
article.init();