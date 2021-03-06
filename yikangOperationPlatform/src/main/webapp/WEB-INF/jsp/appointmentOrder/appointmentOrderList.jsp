
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

				<form id="paramForm" action="<%=basePath%>appointmentUser/getAppointmentList" method="post">
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
													style="width: 144px;">订单编号</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Browser: activate to sort column ascending"
													style="width: 180px;">客户联系号码</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 158px;">地图定位地址</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 158px;">详细地址</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Engine version: activate to sort column ascending"
													style="width: 123px;">预约时间</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="CSS grade: activate to sort column ascending"
													style="width: 88px;">操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${data }" var="appointmentOrder" varStatus="varIndex">
		<!-- 								 odd	even -->
												<tr role="row" class="${ varIndex.index % 2 eq 0 ? 'odd':'even' }">
													<td class="sorting_1">${appointmentOrder.appointmentOrderId }</td>
													<td>${appointmentOrder.myPhoneNumber }</td>
													<td>${appointmentOrder.mapPostionAddress }</td>
													<td>${appointmentOrder.detailAddress }</td>
													<td>${appointmentOrder.appointmentDateTime}</td>
													<td>
														<button class="btn btn-block btn-primary btn-sm"></button>
														<button class="btn btn-block btn-primary btn-sm">修改定单信息</button>
													</td>
												</tr>
											</c:forEach>
										
										</tbody>
										<tfoot>
											<tr>
												<th rowspan="1" colspan="1">订单编号</th>
												<th rowspan="1" colspan="1">客户联系号码</th>
												<th rowspan="1" colspan="1">地图定位</th>
												<th rowspan="1" colspan="1">详细地址</th>
												<th rowspan="1" colspan="1">预约时间</th>
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
	
	<div class="row">
		<div class="col-sm-12">
			
		</div>
	</div>
	
	
</body>
</html>
