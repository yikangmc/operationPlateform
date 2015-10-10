
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<%@ include file="/common/head.jsp"%>
<script type="text/javascript" src="<%=path%>/js/views/shareUser/appointmentList.js"></script>
<title>预约用户列表</title>
</head>
<body>
	
	
	<div class="row">
		<div class="col-sm-12">
			<div class="box">

				<div class="box-header">
					<h3 class="box-title">预约用户列表</h3>
				</div>

				
				<!-- /.box-header -->
				<div class="box-body">
					<div id="example1_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap">
						<div class="row">
							<div class="col-sm-6">
								<div class="dataTables_length" id="example1_length">
									<label>显示 <select name="example1_length"
										aria-controls="example1" class="form-control input-sm"><option
												value="10">10</option>
											<option value="25">25</option>
											<option value="50">50</option>
											<option value="100">100</option></select> 条
									</label>
								</div>
							</div>
							<div class="col-sm-6">
								<div id="example1_filter" class="dataTables_filter">
									<label>Search:<input type="search"
										class="form-control input-sm" placeholder="搜索"
										aria-controls="example1"></label>
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
												style="width: 144px;">用户编号</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												rowspan="1" colspan="1"
												aria-label="Browser: activate to sort column ascending"
												style="width: 180px;">手机号码</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												rowspan="1" colspan="1"
												aria-label="Platform(s): activate to sort column ascending"
												style="width: 158px;">预约日期</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												rowspan="1" colspan="1"
												aria-label="Engine version: activate to sort column ascending"
												style="width: 123px;">回访状态</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending"
												style="width: 88px;">操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${data }" var="appointmentUser" varStatus="varIndex">
	<!-- 								 odd	even -->
											<tr role="row" class="${ varIndex.index % 2 eq 0 ? 'odd':'even' }">
												<td class="sorting_1">${appointmentUser.appointmentUserId }</td>
												<td>${appointmentUser.mobileNumber }</td>
												<td><fmt:formatDate value="${appointmentUser.createTime }" type="both"/></td>
												<td>${appointmentUser.returnVisit}</td>
												<td><button class="btn btn-block btn-primary btn-sm">修改回访信息</button></td>
											</tr>
										</c:forEach>
									
									</tbody>
									<tfoot>
										<tr>
											<th rowspan="1" colspan="1">用户编号</th>
											<th rowspan="1" colspan="1">手机号码</th>
											<th rowspan="1" colspan="1">预约日期</th>
											<th rowspan="1" colspan="1">回访状态</th>
											<th rowspan="1" colspan="1"></th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-5">
								<div class="dataTables_info" id="example1_info" role="status"
									aria-live="polite">Showing 1 to 10 of 57 entries</div>
							</div>
							<div class="col-sm-7">
								<div class="dataTables_paginate paging_simple_numbers"
									id="example1_paginate">
									<ul class="pagination">
										<li class="paginate_button previous disabled"
											id="example1_previous"><a href="#"
											aria-controls="example1" data-dt-idx="0" tabindex="0">Previous</a></li>
										<li class="paginate_button active"><a href="#"
											aria-controls="example1" data-dt-idx="1" tabindex="0">1</a></li>
										<li class="paginate_button "><a href="#"
											aria-controls="example1" data-dt-idx="2" tabindex="0">2</a></li>
										<li class="paginate_button "><a href="#"
											aria-controls="example1" data-dt-idx="3" tabindex="0">3</a></li>
										<li class="paginate_button "><a href="#"
											aria-controls="example1" data-dt-idx="4" tabindex="0">4</a></li>
										<li class="paginate_button "><a href="#"
											aria-controls="example1" data-dt-idx="5" tabindex="0">5</a></li>
										<li class="paginate_button "><a href="#"
											aria-controls="example1" data-dt-idx="6" tabindex="0">6</a></li>
										<li class="paginate_button next" id="example1_next"><a
											href="#" aria-controls="example1" data-dt-idx="7"
											tabindex="0">Next</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.box-body -->
			</div>
		</div>
	</div>
	
	
</body>
</html>
