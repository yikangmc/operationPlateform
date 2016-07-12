<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<%@ include file="/common/head.jsp"%>
<title>问题列表</title>
</head>
<body>
<script type="text/javascript" src="<%=path%>/js/views/forumPost/forumPost-upload.js"></script>
<div class="row">
		<div class="col-sm-12">
			<div class="box">

				<div class="box-header">
					<h3 class="box-title">问题列表</h3>
				</div>

				<form id="paramForm" action="<%=basePath%>question/questionList" method="post">
					<!-- /.box-header -->
					<div class="box-body">
						<div id="example1_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-sm-6">
									<div id="example1_filter" class="dataTables_filter">
										<label>Search:
										<input type="search" class="form-control input-sm" placeholder="搜索" aria-controls="example1"></label>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<table id="example1"
										class="table table-bordered table-striped dataTable"
										role="grid" aria-describedby="example1_info">
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
													style="width: 123px;">用户信息</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Engine version: activate to sort column ascending"
													style="width: 123px;">操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${allQuestions }" var="question" varStatus="varIndex">
		<!-- 								 odd	even -->
												<tr role="row" class="${ varIndex.index % 2 eq 0 ? 'odd':'even' }">
													<td class="sorting_1">${question.title }</td>
													<td>${question.content }
													</td>
													<td><fmt:formatDate value="${question.createTime }" type="both"/></td>
													<td><fmt:formatDate value="${question.updateTime }" type="both"/></td>
													<td><c:if test="${question.isDelete==0 }">否</c:if>
														<c:if test="${question.isDelete==1 }">是</c:if>
													</td>
													<td>${question.star}</td>
													<td>
														<c:if test="${question.photoUrl!=null && formPosts.photoUrl!=''}">
														<img src="${question.photoUrl}" width="50" height="50"/><br /></c:if>
															${question.userName }
													</td>
													<td><a href="<%=basePath%>question/jumpMidPage?questionId=${question.questionId}" class="btn primary-btn">添加回答</a></td>
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
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>