<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="keywords" content="易康美辰,领取奖品,领取服务卷,600元优惠卷" />
<meta name="description" content="易康美辰,领取奖品,领取服务卷,600元优惠卷" />
<meta name="generator" content="易康美辰" />
<meta name="author" content="易康美辰技术部" />

<title>易康美辰</title>
<link rel="stylesheet" type="text/css"
	media="screen and (max-device-width: 400px)"
	href="<%=path%>/css/protal/smallScreen.css" />
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" />
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>


<script>
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "//hm.baidu.com/hm.js?bfa063bc01b8c0b11ee446bb9d4072a4";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s);
	})();
</script>
<style>
html, body {
	height: 100%;
	width: 100%;
}

.dv_body {
	text-align: center;
	width: 100%;
	height: 100%;
	padding: 12%;
	padding-top: 2%;
}

.dv_toptitle {
	width: 100%;
	height: 70px;
	background: #000;
	text-align: center;
	line-height: 70px;
	color: #FFF;
	font-size: 28px;
	font-family: Verdana, Geneva, sans-serif;
	font-weight: 600;
}

.dv_bodytitle {
	padding: 2%;
	padding-left: 12%;
	padding-right: 12%;
	font-size: 28px;
	font-family: Verdana, Geneva, sans-serif;
	font-weight: 600;
	color: #000;
}

.dv_banner {
	margin: 0 auto;
	text-align: center;
	width: 100%;
	height: 36%;
	margin-bottom: 10%;
}

input {
	border: 0px #FFFFFF none;
}

#input_heightone {
	height: 70px;
	margin-bottom: 60px;
	font-size: 32px;
	font: Verdana, Geneva, sans-serif;
	color: #2D86FF;
	font-weight: 600;
	border: #2D86FF 1px solid;
	-moz-border-radius: 7px; /* Gecko browsers */
	-webkit-border-radius: 7px; /* Webkit browsers */
	border-radius: 7px;
}

#input_height {
	height: 70px;
	margin-bottom: 60px;
	font-size: 32px;
	font: Verdana, Geneva, sans-serif;
	color: #2D86FF;
	font-weight: 600;
	border: #2D86FF 1px solid;
	-moz-border-radius: 7px; /* Gecko browsers */
	-webkit-border-radius: 7px; /* Webkit browsers */
	border-radius: 7px;
}


:-webkit-input-placeholder { /* WebKit browsers */
	color: #2D86FF;
}

:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
	color: #2D86FF;
}

:-moz-placeholder { /* Mozilla Firefox 19+ */
	color: #2D86FF;
}

:-ms-input-placeholder { /* Internet Explorer 10+ */
	color: #2D86FF;
}

#input_heightthree {
	height: 70px;
	margin-bottom: 60px;
	font-size: 32px;
	font: Verdana, Geneva, sans-serif;
	color: #FFF;
	font-weight: 600;
}

#input_heightfour {
	height: 70px;
	margin-bottom: 60px;
	font-size: 32px;
	font: Verdana, Geneva, sans-serif;
	color: #FFF;
	font-weight: 600;
}

div ul {
	margin: 0;
	padding: 0;
}

.dv_li_left {
	width: 100%;
	text-align: left;
}

.dv_li_right {
	width: 100%;
	text-align: right;
}

.dv_li_leftfont {
	position: relative;
	top: 6%;
	left: 0%;
}

.dv_li_rightfont {
	position: relative;
	top: 6%;
	right: 0px;
}

.left_fonts {
	position: relative;
	left: 75px;
}

.right_fonts {
	position: relative;
	left: -24px;
}
</style>
<script type="text/javascript"
	src="<%=path%>/js/views/shareUser/getYouHui.js"></script>

</head>
<body>
	<!-- 	<center>
	<div class="row-fluid">
		<form id="userForm" class="form-horizontal">

			<input type="hidden" name="userFromStr" value="${userFromStr}"></input>
			<div class="span6">
				<div class="control-group">
					<label class="control-label" for="inputEmail">手机号</label>
					<div class="controls">
						<input type="text" id="mobileNumber" name="mobileNumber" placeholder="mobileNumber">
					</div>
				</div>
			</div>

			<div class="span6">
				<div class="control-group">
					<label class="control-label" for="inputPassword">验证码</label>
					<div class="controls">
						<input type="password" id="captcha" name="captcha" placeholder="captcha">
					</div>
				</div>
			</div>

			<div class="span6">
				<div class="control-group">
					<div class="controls">
						<button id="getCaptChar" type="button" class="btn" onclick="youHui.getCaptcha()">获取验证码</button>
						<button id="regist" type="button" class="btn" onclick="youHui.saveYouHui()">注册</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	</center>
 -->
	<div class="dv_toptitle">master</div>
	<div class="dv_bodytitle">
		阅兵后温暖阅健康，600元健康评估免费到您家
		<p
			style="font-size: 14px; font: Verdana, Geneva, sans-serif; color: #CCC;">
			2015-09-06 爱您的 <font size="2" color="#FF9326">master</font>
		</p>
	</div>
	<div class="dv_body">
		<form id="userForm" class="form-horizontal">
			<div style="margin-top: -5%; margin-bottom: 18%;" class="dv_banner">
				<img style="width: 100%; height: 100%;"
					src="<%=path%>/img/protal/verificationPhone/banner.png" />
			</div>
			<div class="titletop"
				style="margin: 0 auto; ext-align: center; margin-top: -60px; margin-bottom: 80px;">
				<img src="<%=path%>/img/protal/verificationPhone/master.png" />
			</div>
	
			<p>
				<input name="mobileNumber" style="margin-top: 0px;"
					id="input_heightone" type="text"
					class="col-md-12 col-sm-12 col-xs-12" placeholder="请验证手机号" />
			</p>
			<p>
				<input name="captcha" type="text" id="input_height"
					class="col-md-8 col-sm-8 col-xs-8" placeholder="输入验证码" />
				<button id="input_heightthree"
					style="float: right; background: #FFA919; border: 0px;"
					class="btn btn-primary col-md-4 col-sm-4 col-xs-4"
					onclick="youHui.getCaptcha()" data-toggle="modal"
					data-target="#myModal">获取验证码</button>
			</p>
			<p>
				<button id="input_heightfour" style="background: #FFA919;"
					type="button" class="btn btn-lg col-md-12 col-sm-12 col-xs-12"
					onclick="youHui.saveYouHui()">获取代金劵</button>
			</p>
			<div
				style="width: 100%; margin: 0 auto; text-align: center; padding-bottom: 70px;">
				<img src="<%=path%>/img/protal/verificationPhone/bot.png" />
			</div>
		</form>
	</div>
</body>
</html>