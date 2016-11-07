var ForumPost = function() {

}
ForumPost.prototype = {
	init : function() {

	},
	date:function(){
       $('#reservation').daterangepicker();
	},
	
	// 保存
	checkParam : function() {
		var userName = $("input[name='userName']").val();
		var title = $("input[name='title']").val();
		var recommendPicUrlImage = $("#recommendPicUrlImage").attr("src");
//		var content = $("input[name='content']").val();
		var content = CKEDITOR.instances['editor1'].getData();
		
		var taglibId = $("input[name='taglibId']:checked").val();
		if (userName == '') {
			alert('用户名不能为空！');
			return false;
		}
		if (title == '') {
			alert('标题为空！');
			return false;
		}
		if (typeof (taglibId) == "undefined" || taglibId == '') {
			alert('请选择标签！');
			return false;
		}
		if (recommendPicUrlImage == '' || typeof (recommendPicUrlImage) == "undefined") {
			alert('请添加推荐图片！');
			return false;
		}
		if (content == ''|| typeof (content) == "undefined" ) {
			alert('请填写内容！');
			return false;
		}
		$("#paramForm").submit();
	},
	// 更新并预览
	previewAndUpdate : function() {
		var userName = $("input[name='userName']").val();
		var title = $("input[name='title']").val();
		var recommendPicUrlImage = $("#recommendPicUrlImage").attr("src");
//		var content = $("input[name='content']").val();
		var content = CKEDITOR.instances['editor1'].getData();

		var taglibId = $("input[name='taglibId']:checked").val();
		if (userName == '') {
			alert('用户名不能为空！');
			return false;
		}
		if (title == '') {
			alert('标题为空！');
			return false;
		}
		if (typeof (taglibId) == "undefined" || taglibId == '') {
			alert('请选择标签！');
			return false;
		}
		if (recommendPicUrlImage == ''|| typeof (recommendPicUrlImage) == "undefined") {
			alert('请添加推荐图片！');
			return false;
		}
		if (content == ''|| typeof (content) == "undefined") {
			alert('请填写内容！');
			return false;
		}
		for (instance in CKEDITOR.instances) {
			CKEDITOR.instances[instance].updateElement();
		}
		$.post(basePath + "/forumPosts/updateForumPostsData", $("#paramForm")
				.serialize(), function(data) {
			if (data.status == "000000") {
				// var resData=data.data;
				document.getElementById("link").click();
				// window.open(resData);
			} else {
				alert(data.message);
			}
		});
	},
	// 发布
	publish : function() {
		var userName = $("input[name='userName']").val();
		var title = $("input[name='title']").val();
		var recommendPicUrlImage = $("#recommendPicUrlImage").attr("src");
//		var content = $("input[name='content']").val();
		var content = CKEDITOR.instances['editor1'].getData();

		var taglibId = $("input[name='taglibId']:checked").val();
		if (userName == '') {
			alert('用户名不能为空！');
			return false;
		}
		if (title == '') {
			alert('标题为空！');
			return false;
		}
		if (typeof (taglibId) == "undefined" || taglibId == '') {
			alert('请选择标签！');
			return false;
		}
		if (recommendPicUrlImage == '' || typeof (recommendPicUrlImage) == "undefined") {
			alert('请添加推荐图片！');
			return false;
		}
		if (content == '' || typeof (content) == "undefined") {
			alert('请填写内容！');
			return false;
		}
		for (instance in CKEDITOR.instances) {
			CKEDITOR.instances[instance].updateElement();
		}
		$.post(basePath + "/forumPosts/updateForumPostsData", $("#paramForm")
				.serialize(), function(data) {
			if (data.status == "000000") {
				alert("发布成功！");
				document.getElementById("links").click();
			} else {
				alert(data.message);
			}
		});
	},
	del : function(forumPostId, basePath) {
		if (confirm("确定要删除吗？")) {
			$.post(basePath + "/forumPosts/deleteFormPost", {
				"forumPostsId" : forumPostId
			}, function(data, status) {
				if (data.status == "000000") {
					alert("删除成功！");
				}else{
					alert(data.messages);
				}
				$("#paramForm").submit();
			});
		}
	},
	okStatus : function(forumPostId,createUserId, basePath) {
		if (confirm("确定要通过吗？")) {

			$.post(basePath + "/forumPosts/okStatusFormPost", {
				"forumPostsId" : forumPostId,
				"createUserId":createUserId
			}, function(data) {
				if (data.status == "000000") {
					alert("审核通过成功！");
					window.location.reload();
				} else {
					alert(data.message);
				}
			});
		}
	},
	noStatus : function(forumPostId, basePath) {
		if (confirm("确定要不通过吗？")) {

			$.post(basePath + "/forumPosts/noStatusFormPost", {
				"forumPostsId" : forumPostId
			}, function(data, status) {
				if (status == "success") {
					alert("审核不通过成功！");
					window.location.reload();
				} else {
					alert(data.message);
				}
			});
		}
	},
	updateEssence : function(forumPostId, basePath) {
		if (confirm("确定要设为精华吗？")) {
			$.post(basePath + "/forumPosts/isEssenceForumPosts", {
				"forumPostsId" : forumPostId
			}, function(data, status) {
				if (null != data && data.status == "000000") {
					alert(data.message);
				} else {
					alert(data.message)
				}
				window.location.reload();
			});
		}
	},
	cancelEssence : function(forumPostId, basePath) {
		if (confirm("确定要取消精华吗？")) {
			$.post(basePath + "/forumPosts/cancelEssenceForumPosts", {
				"forumPostsId" : forumPostId
			}, function(data, status) {
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
		window.location.href = basePath + "forumPosts/formPostList";
	}
	
	
}
var forumPost = new ForumPost();
forumPost.init();