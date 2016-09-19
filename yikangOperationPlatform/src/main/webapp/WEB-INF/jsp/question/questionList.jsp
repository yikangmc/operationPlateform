<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<%@ include file="/common/head.jsp"%>
<title>问题列表</title>
</head>
<body>
	<script type="text/javascript"
		src="<%=path%>/js/views/forumPost/forumPost-upload.js"></script>
	<script type="text/javascript"
		src="<%=path%>/js/views/question/questionList.js"></script>
	<div class="row">
		<div class="col-sm-12">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">问题列表</h3>
				</div>
				<form id="paramForm" action="<%=basePath%>question/questionList"
					method="post" class="form-horizontal">
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
										<div class="form-group">
											<label for="content" class="col-sm-2 control-label">问题标题</label>
											<div class="col-sm-2">
												<input type="text" id="title" name="title" value="${title }" />
											</div>
										</div>
										<div for="operatorType" class="form-group">
											<label for="content" class="col-sm-2 control-label">问题内容</label>
											<div class="col-sm-2">
												<input type="text" id="content" name="content" value="${content }"/>
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
						<div class="col-sm-12">
							<table id="example1"
								class="table table-bordered table-striped dataTable" role="grid"
								aria-describedby="example1_info">
								<thead>
									<tr role="row">
										<th class="sorting_asc" tabindex="0" aria-controls="example1"
											rowspan="1" colspan="1" aria-sort="ascending"
											aria-label="Rendering engine: activate to sort column descending"
											style="width: 144px;">标题</th>
										<th class="sorting" tabindex="0" aria-controls="example1"
											rowspan="1" colspan="1"
											aria-label="Browser: activate to sort column ascending"
											style="width: 180px;">内容</th>
										<th class="sorting" tabindex="0" aria-controls="example1"
											rowspan="1" colspan="1"
											aria-label="Platform(s): activate to sort column ascending"
											style="width: 158px;">创建时间</th>
										<th class="sorting" tabindex="0" aria-controls="example1"
											rowspan="1" colspan="1"
											aria-label="Platform(s): activate to sort column ascending"
											style="width: 158px;">更新时间</th>
										<th class="sorting" tabindex="0" aria-controls="example1"
											rowspan="1" colspan="1"
											aria-label="Platform(s): activate to sort column ascending"
											style="width: 158px;">是否删除</th>
										<th class="sorting" tabindex="0" aria-controls="example1"
											rowspan="1" colspan="1"
											aria-label="Engine version: activate to sort column ascending"
											style="width: 123px;">星级</th>
										<th class="sorting" tabindex="0" aria-controls="example1"
											rowspan="1" colspan="1"
											aria-label="Engine version: activate to sort column ascending"
											style="width: 123px;">回答数量</th>
										<th class="sorting" tabindex="0" aria-controls="example1"
											rowspan="1" colspan="1"
											aria-label="Engine version: activate to sort column ascending"
											style="width: 123px;">用户信息</th>
										<th class="sorting" tabindex="0" aria-controls="example1"
											rowspan="1" colspan="1"
											aria-label="Engine version: activate to sort column ascending"
											style="width: 123px;">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${allQuestions }" var="question"
										varStatus="varIndex">
										<!-- 								 odd	even -->
										<tr role="row"
											class="${ varIndex.index % 2 eq 0 ? 'odd':'even' }">
											<td id="questionTitle${question.questionId }" class="sorting_1">${question.title }</td>
											<td>${question.content }</td>
											<td><fmt:formatDate value="${question.createTime }"
													type="both" /></td>
											<td><fmt:formatDate value="${question.updateTime }"
													type="both" /></td>
											<td><c:if test="${question.isDelete==0 }">否</c:if> <c:if
													test="${question.isDelete==1 }">是</c:if></td>
											<td>${question.star}</td>
											<td>${question.answerNum}</td>
											<td><c:if
													test="${question.photoUrl!=null && formPosts.photoUrl!=''}">
													<img src="${question.photoUrl}" width="50" height="50" />
													<br />
												</c:if> ${question.userName }</td>
											<td>
												<button class="btn btn-sm btn-info" type="button" onclick="questionList.showDeleteQuestionModal(${question.questionId})">删除</button>
												<a
												href="<%=basePath%>question/answerQuestion?questionId=${question.questionId}&taglibsId=${question.taglibsId}"
												class="btn primary-btn">添加回答</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<%@ include file="/common/page.jsp"%>
					<!-- /.box-body -->
				</form>
			</div>
		</div>
	</div>

	<div class="modal fade" id="deleteQuestionModelDialog" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" >提示：删除问题</h4>
				</div>
				<div class="modal-body">
					<form id="deleteQuestionForm" class="form-horizontal">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">删除人员帐号</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="userName" name="userName" placeholder="删除人员帐号"/>
								<input type="hidden" id="deleteQuestionId" name="questionId"></input>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">问题标题</label>
							<div class="col-sm-5" id="deleteQuestionTitleDiv">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭 </button>
					<button type="button" class="btn btn-default" onclick="questionList.deleteQuestion()" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/common/promptBox.jsp"%>

</body>
</html>