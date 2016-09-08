<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ include file="/common/head.jsp"%>
<title>当天每个标签下数量</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">当天标签下发帖量柱状图</h3>
					</div>
<!-- 					<div style="height:250px;overflow:scroll;"> -->
<!-- 					  <canvas id="areaChart1" style="height:250px; width:2000px;"></canvas> -->
					  <canvas id="areaChart1" style="height:250px"></canvas>
<!-- 					</div> -->
					  <c:forEach items="${CountTaglib1}" var="countTaglib1" varStatus="index">
						 <input class="name1" type="hidden" value="${countTaglib1.taglibName }" />
						 <input class="number1" type="hidden" value="${countTaglib1.number }">
					  </c:forEach>					
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">当天标签下专家说量柱状图</h3>
					</div>
						<canvas id="areaChart2" style="height:250px"></canvas>
						<c:forEach items="${CountTaglib2}" var="countTaglib2" varStatus="index">
							 <input class="name2" type="hidden" value="${countTaglib2.taglibName}" />
							 <input class="number2" type="hidden" value="${countTaglib2.number }">
						</c:forEach>
			   </div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">当天标签下回答量柱状图</h3>
					</div>
						<canvas id="areaChart3" style="height:250px"></canvas>
						<c:forEach items="${CountTaglib3}" var="countTaglib3" varStatus="index">
							 <input class="name3" type="hidden" value="${countTaglib3.taglibName}" />
							 <input class="number3" type="hidden" value="${countTaglib3.number }">
						</c:forEach>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">当天标签下问题量柱状图</h3>
					</div>
						<canvas id="areaChart4" style="height:250px"></canvas>
						<c:forEach items="${CountTaglib4}" var="countTaglib4" varStatus="index">
<%-- 							 ${countTaglib4.taglibId}---${countTaglib4.taglibName }+++${countTaglib4.number } --%>
						    <input class="name4" type="hidden" value="${countTaglib4.taglibName}" />
							<input class="number4" type="hidden" value="${countTaglib4.number }">
						</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<script>
		$(document).ready(function() {
			var barChartCanvas1 = $("#areaChart1").get(0).getContext("2d");
			var barChartCanvas2 = $("#areaChart2").get(0).getContext("2d");
			var barChartCanvas3 = $("#areaChart3").get(0).getContext("2d");
			var barChartCanvas4 = $("#areaChart4").get(0).getContext("2d");
			var barChart1 = new Chart(barChartCanvas1);
			var barChart2 = new Chart(barChartCanvas2);
			var barChart3 = new Chart(barChartCanvas3);
			var barChart4 = new Chart(barChartCanvas4);
			var barChartData1 = {
				labels : [],
				datasets : [			
				{
					label : "Digital Goods",// 图例
					fillColor : "rgba(60,141,188,0.9)",// 充满的颜色
					strokeColor : "rgba(60,141,188,0.8)", // 边框的颜色 
					pointColor : "#3b8bba",// 不知道是啥颜色（变色时刻）
					pointStrokeColor : "rgba(60,141,188,1)",	// 不知道是啥
					pointHighlightFill : "#fff",	// 不知道是啥
					pointHighlightStroke : "rgba(60,141,188,1)",	// 不知道是啥
					data : []
				} ],
			};
			var barChartData2 = {
				labels : [],
				datasets : [			
				{
					label : "Digital Goods",
					fillColor : "rgba(60,141,188,0.9)",
					strokeColor : "rgba(60,141,188,0.8)",
					pointColor : "#3b8bba",
					pointStrokeColor : "rgba(60,141,188,1)",	
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(60,141,188,1)",	
					data : []
				} ],
			};
			var barChartData3 = {
				labels : [],
				datasets : [			
				{
					label : "Digital Goods",
					fillColor : "rgba(60,141,188,0.9)",
					strokeColor : "rgba(60,141,188,0.8)", 
					pointColor : "#3b8bba",
					pointStrokeColor : "rgba(60,141,188,1)",	
					pointHighlightFill : "#fff",	
					pointHighlightStroke : "rgba(60,141,188,1)",	
					data : []
				} ],
			};
			var barChartData4 = {
				labels : [],
				datasets : [			
				{
					label : "Digital Goods",
					fillColor : "rgba(60,141,188,0.9)",
					strokeColor : "rgba(60,141,188,0.8)", 
					pointColor : "#3b8bba",
					pointStrokeColor : "rgba(60,141,188,1)",	
					pointHighlightFill : "#fff",	
					pointHighlightStroke : "rgba(60,141,188,1)",	
					data : []
				} ],
			};
			var lablesArray1 = new Array();
			$('.name1').each(function() {
				var dValue = $(this).val();
				lablesArray1.push(dValue);
			})
			barChartData1.labels = lablesArray1;
			
			var lablesArray2 = new Array();
			$('.name2').each(function() {
				var dValue = $(this).val();
				lablesArray2.push(dValue);
			})
			barChartData2.labels = lablesArray2;
			
			var lablesArray3 = new Array();
			$('.name3').each(function() {
				var dValue = $(this).val();
				lablesArray3.push(dValue);
			})
			barChartData3.labels = lablesArray3;
			
			var lablesArray4 = new Array();
			$('.name4').each(function() {
				var dValue = $(this).val();
				lablesArray4.push(dValue);
			})
			barChartData4.labels = lablesArray4;

			
			var numbersArray1 = new Array();
			$('.number1').each(function() {
				var nValue = $(this).val();
				numbersArray1.push(nValue);
			})
			barChartData1.datasets[0].data = numbersArray1;
			
			var numbersArray2 = new Array();
			$('.number2').each(function() {
				var nValue = $(this).val();
				numbersArray2.push(nValue);
			})
			barChartData2.datasets[0].data = numbersArray2;
			
			var numbersArray3 = new Array();
			$('.number3').each(function() {
				var nValue = $(this).val();
				numbersArray3.push(nValue);
			})
			barChartData3.datasets[0].data = numbersArray3;
			
			var numbersArray4 = new Array();
			$('.number4').each(function() {
				var nValue = $(this).val();
				numbersArray4.push(nValue);
			})
			barChartData4.datasets[0].data = numbersArray4;

			barChartData1.datasets[0].fillColor = "#00a65a";
			barChartData1.datasets[0].strokeColor = "#00a65a";
			barChartData1.datasets[0].pointColor = "#00a65a";
			barChartData2.datasets[0].fillColor = "#00a65a";
			barChartData2.datasets[0].strokeColor = "#00a65a";
			barChartData2.datasets[0].pointColor = "#00a65a";
			barChartData3.datasets[0].fillColor = "#00a65a";
			barChartData3.datasets[0].strokeColor = "#00a65a";
			barChartData3.datasets[0].pointColor = "#00a65a";
			barChartData4.datasets[0].fillColor = "#00a65a";
			barChartData4.datasets[0].strokeColor = "#00a65a";
			barChartData4.datasets[0].pointColor = "#00a65a";

			var barChartOptions = {
				scaleBeginAtZero : true, // y轴标记是否从0开始
				scaleShowGridLines : true, // 是否显示网格线
				scaleGridLineColor : "rgba(0,0,0,.05)", // 网格线的颜色
				scaleGridLineWidth : 1, // 网格线的线宽
				scaleShowHorizontalLines : true, // 是否显示横向线
				scaleShowVerticalLines : true, // 是否显示竖向线
				barShowStroke : true, // 是否显示线
				barStrokeWidth : 2, //  线宽
				barValueSpacing : 5, // 柱状块与x值所形成的线之间的距离
				barDatasetSpacing : 1, // 在同一x值内的柱状块之间的间距
				legendTemplate : "", // 动画完成后调用的函数(每个柱上显示对应的数据)
				responsive : true, // 创建指定图表时responsave选项为true
			};
			maintainAspectRatio: true // 在Image控件中保持一张图片的原始比率。
			barChartOptions.datasetFill = true;
			barChart1.Bar(barChartData1, barChartOptions);//data:用于设置柱状图上的数据、样式及名称 options:选项，用于配置柱状图
			barChart2.Bar(barChartData2, barChartOptions);
			barChart3.Bar(barChartData3, barChartOptions);
			barChart4.Bar(barChartData4, barChartOptions);
		});
	</script>
</body>
</html>