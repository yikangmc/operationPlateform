<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ include file="/common/head.jsp"%>
<title>日注册数量</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title">用户来源查询</h3>
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
								<label class="col-sm-2 control-label">用户来源</label>
								<form
									action="<%=basePath%>dayRegistrationNumber/dayRegistrationNumber"
									method="post">
									<div class="col-sm-2">
										<!-- <input type="text" id="content" name="content" class="form-control"/> -->
										<select class="form-control" name="userFrom">
											<option value="" ${userFrom==null?"selected":"" }>全部</option>
											<option value="0" ${userFrom==0?"selected":"" }>微信</option>
											<option value="1" ${userFrom==1?"selected":"" }>QQ</option>
											<option value="2" ${userFrom==2?"selected":"" }>微博</option>
											<option value="4" ${userFrom==4?"selected":"" }>理大师</option>
											<option value="5" ${userFrom==5?"selected":"" }>医生邀请</option>
											<option value="6" ${userFrom==6?"selected":"" }>自己注册</option>
											<option value="7" ${userFrom==7?"selected":"" }>360市场</option>
											<option value="8" ${userFrom==8?"selected":"" }>应用宝</option>
											<option value="9" ${userFrom==9?"selected":"" }>安智</option>
											<option value="10" ${userFrom==10?"selected":"" }>豌豆荚</option>
											<option value="11" ${userFrom==11?"selected":"" }>木蚂蚁</option>
											<option value="12" ${userFrom==12?"selected":"" }>华为</option>
											<option value="13" ${userFrom==13?"selected":"" }>小米</option>
											<option value="14" ${userFrom==14?"selected":"" }>百度</option>
										</select>
									</div>
									<div class="row">
										<label class="col-sm-2 control-label">注册时间：</label>
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-calendar"></i>
											</div>
											<input type="text" class="rwo" name="reservation"
												id="reservation" value="${reservation}">
												<font color="red">(开始时间和结束时间差最大31天)</font>
										</div>
									</div>
									<div class="box-footer clearfix" style="display: block;">
										<button type="submit"
											class="btn btn-sm btn-info btn-flat pull-right">查询</button>
										<button type="reset"
											class="btn btn-sm btn-default btn-flat pull-right">重置</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="box">
					<div class="box-header">
						<h3 id="box-title"></h3>
					</div>
					<div class="box-body">
						<form id="paramForm"
							action="<%=basePath%>forumArticleMange/dayRegistrationNumber"
							method="post" class="form-horizontal">
							<!--用于显示Chart图表的容器 -->
							<canvas id="areaChart" style="height:250px"></canvas>
							<c:forEach items="${UserNumber}" var="userNumber"
								varStatus="index">
								<%-- 						 ${userNumber.count}---${userNumber.checkDay } --%>
								<input class="Numbers" type="hidden" value="${userNumber.count}" />
								<input class="Days" type="hidden"
									value="${userNumber.checkDay}:${userNumber.count}">
							</c:forEach>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		// 在文档加载后激活函数
		$(document)
				.ready(
						function() {
							/* ChartJS
							 * -------
							 * Here we will create a few charts using ChartJS
							 */

							//--------------
							//- AREA CHART -
							//--------------
							//-------------
							//- BAR CHART -
							//-------------
							//   get(0)得到对应的jquery对现象的dom对象。$("#afui")得到的是jquery封装的对象，getContext("2d") 对象是内建的 HTML5 对象，拥有多种绘制路径、矩形、圆形、字符以及添加图像的方法。
							// 	   获取Canvas对象
							var barChartCanvas = $("#areaChart").get(0)
									.getContext("2d");
							//   创建Chart图表
							var barChart = new Chart(barChartCanvas);
							var barChartData = {
								labels : [],
								datasets : [
								//                   {
								// 					//  这里是第一个线条
								//                     label: "Electronics",	// 图例
								// 					// rgba括号中前3个数字代表着 red green blue三种颜色的rgb值，0-255，最后一个是设定这个颜色的透明度即alpha值。范围从0到1，越接近1，代表透明度越低。   
								//                     fillColor: "rgba(210, 214, 222, 1)",  // 充满的颜色
								//                     strokeColor: "rgba(210, 214, 222, 1)",  // 边框的颜色 
								//                     pointColor: "rgba(210, 214, 222, 1)",  // 不知道是啥颜色（变色时刻）
								//                     pointStrokeColor: "#c1c7d1",	// 不知道是啥
								//                     pointHighlightFill: "#fff",		// 不知道是啥
								//                     pointHighlightStroke: "rgba(220,220,220,1)",  	// 不知道是啥
								// 					//  从数据库中查出注册数量并赋值到这里
								//                     data: [65, 59, 80, 81, 56, 55, 40]
								//                   },
								{
									// 第二个线条
									label : "Digital Goods",
									fillColor : "rgba(60,141,188,0.9)",
									strokeColor : "rgba(60,141,188,0.8)",
									pointColor : "#3b8bba",
									pointStrokeColor : "rgba(60,141,188,1)",
									pointHighlightFill : "#fff",
									pointHighlightStroke : "rgba(60,141,188,1)",
									//                     data: [28, 48, 40, 19, 86, 27, 90]
									data : []
								} ],
							};
							var lablesArray = new Array();
							$('.Days').each(function() {
								var dValue = $(this).val();
								lablesArray.push(dValue);
							})
							barChartData.labels = lablesArray;

							var numbersArray = new Array();
							var sum = 0;
							$('.Numbers').each(function() {
								var nValue = $(this).val();
								// barChartData.datasets[0].data += nValue;
								sum = sum + parseInt(nValue);
								numbersArray.push(nValue);
							})
							document.getElementById("box-title").innerHTML = "日用户数量柱状图 （总数:"
									+ sum + ")";
							barChartData.datasets[0].data = numbersArray;

							barChartData.datasets[0].fillColor = "#00a65a";
							barChartData.datasets[0].strokeColor = "#00a65a";
							barChartData.datasets[0].pointColor = "#00a65a";

							var barChartOptions = {
								//Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
								scaleBeginAtZero : true, // y轴标记是否从0开始
								//Boolean - Whether grid lines are shown across the chart
								scaleShowGridLines : true, // 是否显示网格线
								//String - Colour of the grid lines
								scaleGridLineColor : "rgba(0,0,0,.05)", // 网格线的颜色
								//Number - Width of the grid lines
								scaleGridLineWidth : 1, // 网格线的线宽
								//Boolean - Whether to show horizontal lines (except X axis)
								scaleShowHorizontalLines : true, // 是否显示横向线
								//Boolean - Whether to show vertical lines (except Y axis)
								scaleShowVerticalLines : true, // 是否显示竖向线
								//Boolean - If there is a stroke on each bar
								barShowStroke : true, // 是否显示线
								//Number - Pixel width of the bar stroke
								barStrokeWidth : 2, //  线宽
								//Number - Spacing between each of the X value sets
								barValueSpacing : 5, // 柱状块与x值所形成的线之间的距离
								//Number - Spacing between data sets within X values
								barDatasetSpacing : 1, // 在同一x值内的柱状块之间的间距
								//String - A legend template
								legendTemplate : "", // 动画完成后调用的函数(每个柱上显示对应的数据)
								// Boolean - whether to make the chart responsive 
								responsive : true, // 创建指定图表时responsave选项为true
							};
							maintainAspectRatio: true // 在Image控件中保持一张图片的原始比率。
							barChartOptions.datasetFill = true;
							barChart.Bar(barChartData, barChartOptions);//data:用于设置柱状图上的数据、样式及名称 options:选项，用于配置柱状图
						});
		$(function() {
			//Date range picker
	        $('#reservation').daterangepicker();
		});
	</script>
</body>
</html>