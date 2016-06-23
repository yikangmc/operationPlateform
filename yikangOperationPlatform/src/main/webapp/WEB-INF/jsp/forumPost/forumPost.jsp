
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<%@ include file="/common/head.jsp"%>
<title>预约用户列表</title>
<script type="text/javascript">
</script>
</head>
<body>


	<div class="row">
		<div class="col-sm-12">
			<div class="box">

				<div class="box-header">
					<h3 class="box-title">预约用户列表</h3>
				</div>

				<form id="paramForm" action="<%=basePath%>forumPosts/addForumPost"
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
								<div class="col-sm-6">
									<div id="example1_filter" class="dataTables_filter">
										<label>标题: <input type="input" name="title"
											class="form-control input-sm" placeholder="标题"
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
												style="visibility: hidden; display: none;">                           
											  </textarea>
										</div>
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


</body>
</html>
