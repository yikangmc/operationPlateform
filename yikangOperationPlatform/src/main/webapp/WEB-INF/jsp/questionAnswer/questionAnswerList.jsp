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
		action="<%=basePath%>user/verificationList" method="post">
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
									<input type="text" name="questionTitle" />
								</div>
							</div>
							<div class="form-group">
								<label for="operatorType" class="col-sm-2 control-label">回复内容</label>
								<div class="col-sm-2">
									<select class="form-control" name="operatorType">
										<option value="-1">全部</option>
										<option value="-1">审核中</option>
										<option value="-1">审核通过</option>
										<option value="-1">退回</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
					<div class="box-footer clearfix" style="display: block;">
						<button type="submit" class="btn btn-sm btn-info btn-flat pull-right">查询</button>
						<button type="reset"  class="btn btn-sm btn-default btn-flat pull-right">重置</button>
					</div>
					<!-- /.box-footer -->
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="box">

					<div class="box-header">
						<h3 class="box-title">身份审核列表</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<div id="example1_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-sm-12">
									<table
										class="table table-bordered table-striped dataTable"
										role="grid" aria-describedby="example1_info">
										<thead>
											<tr role="row">
												<th class="sorting">问题标题</th>
												<th class="sorting">创建人</th>
												<th class="sorting">回复时间</th>
												<th class="sorting">回答内容</th>
												<th class="sorting">回复人</th>
												<th class="sorting">操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${data }"
												var="questionAnswer" varStatus="varIndex">
												<tr>
													<td>${questionAnswer.question.title }</td>
													<td>${questionAnswer.question.userName }</td>
													<td>${questionAnswer.createTime }</td>
													<td>${questionAnswer.content}</td>
													<td>${questionAnswer.userName}</td>
													<td>
														<button type="button" value="删除"></button>
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




	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">不通过原因</h4>
				</div>
				<div class="modal-body">
					<form id="statusForm"
						action="<%=basePath%>user/updateUserPositionStatusCheckePass"
						method="post">
						<table id="example1"
							class="table table-bordered table-striped dataTable" role="grid"
							aria-describedby="example1_info">
							<tr>
								<td>
									<p>
										<input type="hidden" name="no" value="3" /> <input
											type="hidden" name="push_alias" /> <input type="checkbox"
											name="reason" value="资料不属实" />资料不属实
									</p>
									<p>
										<input type="checkbox" name="reason" value="资历不足" />资历不足
									</p>
									<p>
										<input type="checkbox" name="reason" value="资料不符合平台要求" />资料不符合平台要求
									</p>
									<p>
										其他原因:<input type="text" name="otherReason" />
									</p>
								</td>
							</tr>
						</table>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="button" class="btn btn-info"
								onclick="userStatus.modalSubmit()">确定</button>
						</div>
					</form>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<script type="text/javascript"
		src="<%=path%>/js/views/UserStatus/UserStatus.js"></script>
</body>
</html>