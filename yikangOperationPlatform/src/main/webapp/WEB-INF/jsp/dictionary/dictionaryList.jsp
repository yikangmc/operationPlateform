<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/common/head.jsp"%>
<title>数据字典</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="box">

					<div class="box-header">
						<h3 class="box-title">数据字典列表</h3>
					</div>

					<form id="paramForm" action="<%=basePath%>dictionary/getDictionaryList" method="post">
						<!-- /.box-header -->
						<div class="box-body">
							<div id="example1_wrapper"
								class="dataTables_wrapper form-inline dt-bootstrap">
								<div class="row">
									<div class="col-sm-12">
										<div id="example1_filter" class="dataTables_filter">
											<label>名字: 
											<input type="text"
												class="form-control input-sm" placeholder="名字"
												aria-controls="example1"></label>
											<label>注册日期: 
											<input type="date"
												class="form-control input-sm" placeholder="日期"
												aria-controls="example1"></label>
											<button class="btn" type="submit">查询</button>
											<button class="btn" type="button">
												<a href="${basePath }user/addUser">添加</a>
											</button>
											<button class="btn" type="button">修改</button>
											
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
													<th class="sorting_asc" tabindex="0"
														aria-controls="example1" rowspan="1" colspan="1"
														aria-sort="ascending"
														aria-label="Rendering engine: activate to sort column descending"
														style="width: 144px;">键名</th>
													<th class="sorting" tabindex="0" aria-controls="example1"
														rowspan="1" colspan="1"
														aria-label="Platform(s): activate to sort column ascending"
														style="width: 158px;">数据</th>
													<th class="sorting" tabindex="0" aria-controls="example1"
														rowspan="1" colspan="1"
														aria-label="Browser: activate to sort column ascending"
														style="width: 180px;">登陆名</th>
													<th class="sorting" tabindex="0" aria-controls="example1"
														rowspan="1" colspan="1"
														aria-label="Platform(s): activate to sort column ascending"
														style="width: 158px;">所属分类名称</th>
													<th class="sorting" tabindex="0" aria-controls="example1"
														rowspan="1" colspan="1"
														aria-label="Platform(s): activate to sort column ascending"
														style="width: 158px;">添加日期</th>
														
													<th class="sorting" tabindex="0" aria-controls="example1"
														rowspan="1" colspan="1"
														aria-label="CSS grade: activate to sort column ascending"
														style="width: 88px;">操作</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${data }" var="dictionary" varStatus="varIndex">
													<!--  odd	even -->
													<tr role="row"
														class="${ varIndex.index % 2 eq 0 ? 'odd':'even' }">
														<td class="sorting_1">${dictionary.dicName }</td>
														<td>${dictionary.dicCode}</td>
														<td>${dictionary.dicGroup }</td>
														<td>${dictionary.createTime}</td>
														<td>
															<button class="btn btn-block btn-primary btn-sm">修改用户信息</button>
														</td>
													</tr>
												</c:forEach>
											</tbody>
											<tfoot>
												<tr>
													<th rowspan="1" colspan="1">键名</th>
													<th rowspan="1" colspan="1">数据</th>
													<th rowspan="1" colspan="1">分类</th>
													<th rowspan="1" colspan="1">创建日期</th>
													<th rowspan="1" colspan="1"></th>
												</tr>
											</tfoot>
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
	</div>
</body>
</html>