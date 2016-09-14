<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<%@ include file="/common/head.jsp"%>
<title>问题回复列表</title>
</head>
<body>


	<form id="paramForm" class="form-horizontal"
		action="<%=basePath%>questionAnswer/questionAnswerList" method="post">
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
					<!-- /.box-header -->
					<div class="box-body" style="display: block;">
						<!-- /.table-responsive -->
						<div class="box-body">
							<div class="form-group">
								<label for="questionTitle" class="col-sm-2 control-label">问题名称</label>
								<div class="col-sm-2">
									<input type="text" name="questionTitle" class="form-control"
										value="${questionTitle}" />
								</div>
							</div>
							<div class="form-group">
								<label for="questionTitle" class="col-sm-2 control-label">回答内容</label>
								<div class="col-sm-2">
									<input type="text" name="questionAnswerTitle"
										class="form-control" value="${questionAnswerTitle}" />
								</div>
							</div>
							<div for="operatorType" class="form-group">
								<label class="col-sm-2 control-label">查询条件</label>
								<form action="<%=basePath%>questionAnswer/questionAnswerList"
									method="post">
									<div class="col-sm-2">
										<select class="form-control" name="isRecommend">
											<option value="" ${isRecommend==null?"selected":"" }>全部</option>
											<option value="0" ${isRecommend==0?"selected":"" }>非精华</option>
											<option value="1" ${isRecommend==1?"selected":"" }>精华</option>
										</select>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
					<div class="box-footer clearfix" style="display: block;">
						<button type="submit"
							class="btn btn-sm btn-info btn-flat pull-right">查询</button>
						<button type="reset"
							class="btn btn-sm btn-default btn-flat pull-right">重置</button>
					</div>
					<!-- /.box-footer -->
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="box">
					<!-- /.box-header -->
					<div class="box-body">
						<div id="example1_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-sm-12">
									<table class="table table-bordered table-striped dataTable"
										role="grid" aria-describedby="example1_info">
										<thead>
											<tr role="row">
												<th class="col-md-3 sorting">问题标题</th>
												<th class="sorting">创建人</th>
												<th class="sorting">精华</th>
												<th class="sorting">回复时间</th>
												<th class="sorting">回答内容</th>
												<th class="sorting">回复人</th>
												<th class="sorting">操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${data }" var="questionAnswer"
												varStatus="varIndex">
												<tr>
													<td>${questionAnswer.question.title }</td>
													<td>${questionAnswer.question.userName }</td>
													<td><c:if test="${questionAnswer.isRecommend==1 }">是</c:if>
														<c:if test="${questionAnswer.isRecommend==0 }">否</c:if></td>
													<td>
														<fmt:formatDate value="${questionAnswer.createTime }" type="both"/></td>
													<td>${questionAnswer.detailContent}</td>
													<td>${questionAnswer.userName}</td>
													<td>
														<button type="button" class="btn btn-info "
															onclick="questionAnswer.del(${questionAnswer.questionAnswerId},'<%=basePath%>')">删除</button>
														<c:if test="${questionAnswer.isRecommend==0 }">
															<button type="button" class="btn btn-info "
																onclick="questionAnswer.updateEssencea(${questionAnswer.questionAnswerId},'<%=basePath%>')">精华</button>
														</c:if> <c:if test="${questionAnswer.isRecommend==1 }">
															<button type="button" class="btn batn-info "
																onclick="questionAnswer.cancelEssencea(${questionAnswer.questionAnswerId},'<%=basePath%>')">取消</button>
														</c:if>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<%@ include file="/common/page.jsp"%>
						</div>
					</div>
					<!-- /.box-body -->

				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript"
		src="<%=path%>/js/views/UserStatus/UserStatus.js"></script>
	<script type="text/javascript"
		src="<%=path%>/js/views/question/questionAnswer.js"></script>
</body>
</html>