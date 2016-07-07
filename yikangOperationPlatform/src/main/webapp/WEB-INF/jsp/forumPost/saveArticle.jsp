<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<%@ include file="/common/head.jsp"%>
<script type="text/javascript">
</script>
<title>帖子发布</title>
</head>
<body>
<script type="text/javascript" src="<%=path%>/js/views/forumPost/forumPost-upload2.js"></script>

	<div class="row">
		<div class="col-sm-12">
			<div class="box">

				<div class="box-header">
					<h3 class="box-title">帖子发布</h3>
				</div>

				<form id="paramForm" action="<%=basePath%>forumArticleMange/addForumPost"
					method="post">
					<!-- /.box-header -->
					<div class="box-body">
						<div id="example1_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-sm-6">
									<div id="example1_filter" class="dataTables_filter">
										<label>用户名: <input type="input" name="userName"
											class="form-control input-sm" placeholder="用户名" value="${userName }"
											aria-controls="example1"></label>
									</div>
								</div>
							</div>
							<div class="row">
								
								<div class="col-sm-9">
									<c:forEach items="${taglibs2}" var="taglib">
										<strong> ${taglib.tagName }</strong><br>
										   <c:forEach items="${taglib.childs}" var="ch">
										   		${ch.tagName}<input type="checkbox" name="taglibId" value="${ch.taglibId }"/>
										   </c:forEach>
										   <br>
									</c:forEach>
								</div>
								<div class="col-sm-3">
									<button class="btn btn-info " type="submit">提交</button>
								</div>
							</div>
							<div class="row">
                                <div class="col-sm-6">
                                    <input type="button" class="fileInput" name="recommendPicUrl" value="上传标题图片"
                                    					draggable="true" capture="camera" onclick="$.upload()">
                                    					
                                </div>
                                <div class="col-sm-6" id = "imgId1">
                                </div>
							</div>
							<div class="box-body pad">
								<textarea rows="10" name="content" cols="120">
									
								</textarea>
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


</body>
</html>
