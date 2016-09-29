var ReportInformation = function() {
}
ReportInformation.prototype = {
	init : function() {

	},
	del : function(reportId, reportGroup, dataId, reportUserId, basePath) {
		if (confirm("确定要删除吗？")) {
			$.ajax({
				type : "POST",
				data : {
					'reportId' : reportId,
					'reportGroup' : reportGroup,
					'dataId' : dataId,
					'reportUserId' : reportUserId
				},
				url : basePath + "reportInformation/deleteReportInformation",
				dataType : "json",
				success : function(result) {
					if ("000000" == result.status) {
						alert("删除成功");
						window.location.reload();
					} else {
						alert("删除失败");
					}
				},
				error : function(result) {
					alert("删除出错" + result);
				}
			});
		}
	},

	warn : function(reportId, reportUserId, basePath) {
		if (confirm("确定要记警告一次吗？")) {
			$.post(basePath + "/reportInformation/addOneReportTime", {
				'reportId' : reportId,
				"reportUserId" : reportUserId
			}, function(data) {
				if (null != data && data.status == "000000") {
					alert(data.message);
				} else {
					alert(data.message);
				}
				window.location.reload();
			});
		}
	},
	ignore : function(reportId, basePath) {
		if (confirm("确定要忽略吗？")) {
			$.post(basePath + "reportInformation/ignoreUpdateStatus", {
				"reportId" : reportId
			}, function(data) {
				if (null != data && data.status == "000000") {
					alert(data.message);
				} else {
					alert(data.message);
				}
				window.location.reload();
			});
		}
	},
	relond : function() {
		window.location.href = basePath + "reportInformation/reportList";
	}
}

var reportInformation = new ReportInformation();
reportInformation.init();