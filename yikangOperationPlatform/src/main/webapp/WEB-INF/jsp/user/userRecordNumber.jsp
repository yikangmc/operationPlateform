<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ include file="/common/head.jsp"%>
<title>账号查询个人记录条数</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">条件查询</h3>
				</div>
				<form action="<%=basePath%>userRecordNumber/userRecordNumber"
					method="post">
					<div class="row">
						<div class="col-sm-12">
							<div class="box box-info">
								<div class="box-header with-border">
									<h3 class="box-title">搜索</h3>
									<div class="box-tools pull-right">
										<button class="btn btn-box-tool" data-widget="collapse">
											<i class="fa fa-minus"></i>
										</button>
										<button class="btn btn-box-tool" data-widget="remove">
											<i class="fa fa-times"></i>
										</button>
									</div>
								</div>
								<div class="box-body" style="display: block;">
									<div class="box-body">
										<div  class="form-group">
											<label class="col-sm-1 control-label">用户名字</label>
											<div class="col-sm-3">
												<input type="text" id="userName" name="userName"
													class="form-control" value="${userName}"> </input>
											</div>
											<label class="col-sm-1 control-label">日期选择</label>
											<div class="input-group col-sm-3">
												<div class="input-group-addon">
													<i class="fa fa-calendar"></i>
												</div>
												<input type="text" class="form-control pull-right "
													id="reservation" name="reservation" value="${reservation }">
											</div>
										</div>
									</div>
								</div>
								<div class="box-footer clearfix" style="display: block;">
									<button type="submit"
										class="btn btn-sm btn-info btn-flat pull-right">查询</button>
									<button type="reset"
										class="btn btn-sm btn-default btn-flat pull-right">重置</button>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<p style="text-indent: 3em;font-size:16px;">发过的专家说数量:${userRecordNumber.forumPostNumber }</p>
						<p style="text-indent: 3em;font-size:16px;">发过的帖子数量:${userRecordNumber.articleNumber }</p>
						<p style="text-indent: 3em;font-size:16px;">提出的问题数量:${userRecordNumber.questionNumber }</p>
						<p style="text-indent: 3em;font-size:16px;">回答过的问题数量:${userRecordNumber.questionAnswerNumber }</p>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
		$(function() {
			//Date range picker
			$('#reservation').daterangepicker();
		});
	</script>
</body>
</html>