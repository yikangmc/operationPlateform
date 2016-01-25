<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/common/head.jsp"%>
<title>添加用户</title>
</head>
<body>
	<div class="container">
		<div class="col-sm-12">

			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">添加普通用户</h3>
				</div>
				<!-- /.box-header -->
				<!-- form start -->
				<form id="userForm" class="form-horizontal">
					<div class="box-body">
						<div class="form-group">
							<label for="inputLoginName" class="col-sm-2 control-label">登陆名</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="inputLoginName" placeholder="登陆名">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="inputPassword" placeholder="密码">
							</div>
						</div>
						<div class="form-group">
							<label for="inputMobileNumber" class="col-sm-2 control-label">手机号</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="inputMobileNumber" placeholder="手机号">
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputBithDay" class="col-sm-2 control-label">出生日期</label>
							<div class="col-sm-4">
								<input type="date" name="bithDay" class="form-control" id="inputBithDay" placeholder="出生日期">
							</div>
						</div>
						<div class="form-group">
							<label for="inputAge" class="col-sm-2 control-label">年龄</label>
							<div class="col-sm-4">
								<input type="number" name="age" class="form-control" id="inputAge" placeholder="年龄">
							</div>
						</div>
						<div class="form-group">
							<label for="inputSex" class="col-sm-2 control-label">性别</label>
							<div class="col-sm-4">
								<input type="radio" name="sex"  value="1" checked="checked"> 男
								<input type="radio" name="sex"  id="inputSex" value="0"> 女
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">地图搜索地址</label>
							<div class="col-sm-4">
								<input type="text" name="mapPositionAddress" class="form-control" id="inputMapPositionAddress" placeholder="地图搜索地址">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">详细地址</label>
							<div class="col-sm-4">
								<input type="text" name="detailAddress" class="form-control" id="inputDetailAddress" placeholder="详细地址">
							</div>
						</div>
					</div>
					<!-- /.box-body -->
					<div class="box-footer form-actions">
						<div class="form-group">
							<div class="col-sm-4">
								<button id="buttonReset"  type="button" class="btn btn-default">重置</button>
								<button id="buttonSubmit" type="button" class="btn btn-info pull-right">保存</button>
							</div>
						</div>
					</div>
					<!-- /.box-footer -->
				</form>
			</div>
		</div>
	</div>

</body>
</html>