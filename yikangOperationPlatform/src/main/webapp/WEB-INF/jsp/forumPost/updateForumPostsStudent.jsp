<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<%@ include file="/common/head.jsp"%>
<title>修改文章</title>
<script type="text/javascript">
	$(document).ready(function() {
		alert("test");
		var taglibs = $("#hiddenID").val();
		console.log(taglibs);
	});
	window.onload = function() {
		alert("test");
		var taglibs = $("#hiddenID").val();
		console.log(taglibs);
	}
</script>
</head>
<body>
	<script type="text/javascript"
		src="<%=path%>/js/views/forumPost/forumPost-upload.js"></script>
	<script type="text/javascript"
		src="<%=path%>/js/views/forumPost/forumPost.js"></script>

	<div class="row">
		<div class="col-sm-12">
			<div class="box">

				<div class="box-header">
					<h3 class="box-title">修改文章</h3>
				</div>
				<input type="text" id="hiddenID" style="display: none"
					value="${taglibList}" />
				<form id="paramForm"
					action="<%=basePath%>forumPosts/updateForumPostsData" method="post">
					<!-- /.box-header -->
					<div class="box-body">
						<div id="example1_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-sm-6">
									<div id="example1_filter" class="dataTables_filter">
										<label>帐号: <input type="input" name="userName"
											class="form-control input-sm" placeholder="用户名"
											value="${forumPosts.userName }" aria-controls="example1"/></label>
									</div>
								</div>
								<div class="col-sm-6">
									<div id="example1_filter" class="dataTables_filter">
										<label>标题: <input type="input" name="title"
											class="form-control input-sm" placeholder="标题"
											value="${forumPosts.title}" aria-controls="example1"/></label>
									</div>
								</div>
							</div>
							<input type="hidden" name="forumPostId"
								value="${forumPosts.forumPostId }" /> <input type="hidden"
								id="forumPostShareUrl" value="${forumPosts.shareUrl }" />
							<div class="row">

								<div class="col-sm-9">
									<c:forEach items="${taglibs2}" var="taglib">
										<strong> ${taglib.tagName }</strong>
										<br> <c:forEach items="${taglib.childs}" var="ch">
											   		${ch.tagName}<input type="checkbox" id="${ch.taglibId }"
													name="taglibId" value="${ch.taglibId }" />
											</c:forEach> <br>
									</c:forEach>
								</div>
								<!-- <div class="col-sm-3"> -->
								<!-- <button class="btn btn-info " type="button" -->
								<!-- onclick="forumPost.checkParam()">提交</button> -->
								<!-- </div> -->
							</div>
							<div class="row">
								<div class="col-sm-6">
									<input type="button" class="fileInput" name="recommendPicUrl" value="上传标题图片" 
									 draggable="true" capture="camera" onclick="$.upload()"/> 
									<input type="hidden" name="recommendPicUrl" id="recommendPicUrlHidden"/>
								</div>
								<div class="col-sm-6">
									<c:if test="${forumPosts.recommendPicUrl != null }">
										<input name="recommendPicUrl" type="hidden"
											value="${forumPosts.recommendPicUrl }" />
										<img id="recommendPicUrlImage" style="height: 120px"
											src="${forumPosts.recommendPicUrl }"/>
									</c:if>
									<c:if test="${forumPosts.recommendPicUrl == null }">
										<img id="recommendPicUrlImage" style="height: 120px"/>
									</c:if>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<div class="box box-info">
										<div class="box-header">
											<h3 class="box-title">
												文本编辑 <small>输入文章内容</small>
											</h3>
											<!-- tools box -->
											<div class="pull-right box-tools">
												<button class="btn btn-info btn-sm" data-widget="collapse"
													data-toggle="tooltip" title="Collapse">
													<i class="fa fa-minus"></i>
												</button>
												<button class="btn btn-info btn-sm" data-widget="remove"
													data-toggle="tooltip" title="Remove">
													<i class="fa fa-times"></i>
												</button>
											</div>
											<!-- /. tools -->
										</div>
										<!-- /.box-header -->
										<div class="box-body pad">
											<textarea id="editor1" name="content" rows="10" cols="80"
												style="visibility: hidden; display: none;">${forumPosts.content }                           
											  </textarea>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="pull-right">
										<a id="link" target="_blank" href='${forumPosts.shareUrl }'
											style="display: none">预览1</a> <a id="links"
											href='<%=basePath%>forumPosts/forumPost'
											style="display: none">预览2</a>
										<button id="btn" class="btn btn-info " type="button"
											onclick="forumPost.previewAndUpdate()">预览</button>
										<button class="btn btn-info" type="button"
											onclick="forumPost.publish()">发布</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
				</form>

			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-12"></div>
	</div>

	<script type="text/javascript">
		var taglibs = $("#hiddenID").val();
		console.log(taglibs);
		var tags = taglibs.replace("[", "").replace("]", "");
		var tagArray = tags.split(",");
		for (i = 0; i < tagArray.length; i++) {
			var tas = tagArray[i].toString();
			$("input[id=" + tas + "]").attr("checked", true);
		}
	</script>
</body>
</html>
