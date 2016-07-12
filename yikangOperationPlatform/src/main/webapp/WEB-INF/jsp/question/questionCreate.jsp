<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<%@ include file="/common/head.jsp"%>
<title>创建问题</title>
</head>
<body>
	<script type="text/javascript" src="<%=path%>/js/views/question/questionCreate.js"></script>
	<script type="text/javascript" src="<%=path%>/js/views/question/questionCreate-upload.js"></script>
	<div class="row">
		<div class="col-sm-12">
			<div class="box">

				<!-- 				<div class="box-header"> -->
				<!-- 					<h3 class="box-title">创建问题</h3> -->
				<!-- 				</div> -->

				<form id="paramForm" action="<%=basePath%>question/questionSave" method="post">
					<!-- /.box-header -->
					<div class="box-body">
						<div id="example1_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-sm-12">
									<!-- Horizontal Form -->
									<div class="box box-info">
										<div class="box-header with-border">
											<h3 class="box-title">创建问题</h3>
										</div>
										<!-- /.box-header -->
										<!-- form start -->
										<form class="form-horizontal">
											<div class="box-body">
												<div class="row">
													<div class="col-sm-12">
														<div class="form-group col-sm-5">
															<label for="userName" class="col-sm-3 control-label">用户名</label>
															<div class="col-sm-2">
																<input type="text" class="form-control" id="userName" name="userName"
																 maxlength="15"	placeholder="用户名" value="${userName }">
															</div>
														</div>
														<div class="form-group  col-sm-5">
															<label for="title" class="col-sm-3 control-label">标题</label>
															<div class="col-sm-2">
																<input type="text" class="form-control" id="title" name="title"
																	maxlength="120" placeholder="标题">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-12">
														<c:forEach items="${taglibs }" var="taglib">
															<strong> ${taglib.tagName }</strong>
															<br> <c:forEach items="${taglib.childs}" var="ch">
										   							${ch.tagName}
										   							<input type="radio" name="taglibId"
																		value="${ch.taglibId }" />
																</c:forEach><br>
														</c:forEach>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-6">
														<input type="button" class="fileInput"
															name="recommendPicUrl" value="上传标题图片" draggable="true"
															capture="camera" onclick="$.upload()"> 
													</div>
												</div>
												<div class="row">
													<div class="col-sm-12">
														<div id="imgContaner"></div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-12">
														<textarea name="content" class="col-sm-12" rows="10"></textarea>
													</div>
												</div>
											</div>
											<!-- /.box-body -->
											<div class="box-footer">
												<button type="button" class="btn btn-default">取消</button>
												<button type="button" onclick="questionCreate.checkParam()" class="btn btn-info pull-right">保存</button>
											</div>
											<!-- /.box-footer -->
										</form>
									</div>
									<!-- /.box -->

								</div>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
				</form>
			</div>
		</div>
	</div>

</body>
</html>