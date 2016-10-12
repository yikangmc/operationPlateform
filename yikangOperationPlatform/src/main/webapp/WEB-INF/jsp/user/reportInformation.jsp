<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ include file="/common/head.jsp"%>
<title>举报管理</title>
</head>
<body>
	<script type="text/javascript"
		src="<%=path%>/js/views/user/reportInformation.js"></script>
	<div class="row">
		<div class="col=sm-12">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">举报信息列表</h3>
				</div>
				<form id="paramForm"
					action="<%=basePath%>reportInformation/reportList" method="post"
					class="form-horizontal">
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
										<div for="operatorType" class="form-group">
											<label class="col-sm-2 control-label">信息内容</label>
											<div class="col-sm-2">
												<input type="text" id="content" name="content"
													class="form-control" value="${content}" />
											</div>
										</div>
										<div for="operatorType" class="form-group">
											<label class="col-sm-2 control-label">查询条件</label>
											<div class="col-sm-2">
												<select class="form-control" name="dataStatus">
													<option value="5" ${dataStatus== 5?"selected":"" }>全部</option>
													<option value="1" ${dataStatus==1?"selected":"" }>未处理</option>
													<option value="2" ${dataStatus==2?"selected":"" }>举报有效删除</option>
													<option value="3" ${dataStatus==3?"selected":"" }>举报有效记警告</option>
													<option value="4" ${dataStatus==4?"selected":"" }>举报无效</option>
												</select>
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
					<div id="example1_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap">
						<div class="row">
							<div class="col-sm-12">
								<table id="example1"
									class="table table-bordered table-striped dataTable"
									role="grid" aria-describedby="example1_info">
									<thead>
										<tr role="row">
											<th class="sorting_asc col-sm-1" tabindex="0"
												aria-controls="example1" aria-sort="ascending"
												aria-label="Rendering engine: activate to sort column descending">类型</th>
											<th class="col-sm-4 sorting" tabindex="0"
												aria-controls="example1"
												aria-label="Platform(s): activate to sort column ascending">内容详情</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												aria-label="Browser: activate to sort column ascending">所属标签</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												aria-label="Platform(s): activate to sort column ascending">创建时间</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												aria-label="Platform(s): activate to sort column ascending">发布者</th>
											<!-- <th class="sorting" tabindex="0" aria-controls="example1" -->
											<!-- aria-label="Platform(s): activate to sort column ascending">发布者被举报次数</th> -->
											<th class="sorting" tabindex="0" aria-controls="example1"
												aria-label="Platform(s): activate to sort column ascending">发布者被举报次数</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												aria-label="Platform(s): activate to sort column ascending">举报者</th>
											<th class="col-sm-1 sorting" tabindex="0"
												aria-controls="example1"
												aria-label="Platform(s): activate to sort column ascending">处理情况</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												aria-label="Engine version: activate to sort column ascending">操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${allReports }" var="allReports"
											varStatus="varIndex">
											<tr role="row"
												class="${ varIndex.index % 2 eq 0 ? 'odd':'even' }">
												<td>${allReports.reportType }</td>
												<td>${allReports.reportContent }</td>
												<td><c:forEach
														items="${allReports.reportForumPostTaglibs}"
														var="taglibForumPost" varStatus="varIndex">
														 ${taglibForumPost.tagName}</c:forEach> <c:forEach
														items="${allReports.reportQuestionTaglibs}"
														var="taglibQuestion" varStatus="varIndex">
														 ${taglibQuestion.tagName}</c:forEach></td>
												<td>${allReports.reportCreateTime }</td>
												<td>${allReports.reportReportName}</td>
												<td>${allReports.reportValidNumber}</td>
												<td>${allReports.reportUserName }</td>
												<td><c:if test="${allReports.dataStatus==1 }">未处理</c:if>
													<c:if test="${allReports.dataStatus==2 }">删除</c:if> <c:if
														test="${allReports.dataStatus==3 }">记警告</c:if> <c:if
														test="${allReports.dataStatus==4 }">举报无效</c:if></td>

												<td><c:if test="${allReports.dataStatus==1 }">
														<button type="button" class="btn btn-info "
															onclick="reportInformation.warn(${allReports.reportId },${allReports.reportUserId },'<%=basePath%>')">记警告一次</button>
														<button type="button" class="btn btn-info "
															onclick="reportInformation.del(${allReports.reportId },${allReports.reportGroup},${allReports.dataId},${allReports.reportUserId },
															'${allReports.reportContent}',
															${allReports.contentGroup},'${allReports.pushAlias}','${allReports.reportType}','<%=basePath%>')">删除</button>
														<button type="button" class="btn btn-info "
															onclick="reportInformation.ignore(${allReports.reportId },'<%=basePath%>')">忽略</button>
													</c:if> <c:if test="${allReports.dataStatus==2 }">

													</c:if> <c:if test="${allReports.dataStatus==3 }">

													</c:if> <c:if test="${allReports.dataStatus==4 }">

													</c:if></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<%@ include file="/common/page.jsp"%>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>