package com.yikang.protal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yikang.common.error.ExceptionConstants;
import com.yikang.protal.base.BaseController;
import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.common.response.ResponseMessage;
import com.yikang.protal.common.utils.operationmessage.OperationMessage;
import com.yikang.protal.common.utils.operationmessage.OperationMessageQueue;
import com.yikang.protal.entity.ReportInformation;
import com.yikang.protal.service.ReportInformationService;

@Controller
public class ReportInformationController extends BaseController {

	@Autowired
	private ReportInformationService reportInformationService;

	private static Logger LOG = LoggerFactory.getLogger(ReportInformationController.class);

	/**
	 * 举报信息列表
	 * 
	 * @param modelMap
	 * @param page
	 * @param req
	 * @return
	 */
	@RequestMapping
	public String reportList(ModelMap modelMap, PageParameter page, HttpServletRequest req, Integer dataStatus,
			String content) {
		modelMap.put("page", page);
		if (null == dataStatus || dataStatus.equals("null")) {
			dataStatus = 1;
		}
		if (dataStatus == 5) {
			dataStatus = null;
		}
		modelMap.put("dataStatus", dataStatus);
		modelMap.put("content", content);
		List<ReportInformation> allReports = reportInformationService.findAllReports(modelMap);
		modelMap.put("allReports", allReports);
		return "user/reportInformation";
	}

	/**
	 * 忽略并修改标记分类为4举报无效
	 * 
	 * @param modelMap
	 * @param page
	 * @param req
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> ignoreUpdateStatus(ModelMap modelMap, PageParameter page, HttpServletRequest req) {
		ResponseMessage<String> resData = new ResponseMessage<String>();
		reportInformationService.ignoreUpdateStatus(Long.valueOf(req.getParameter("reportId")));
		return resData;
	}

	/**
	 * 举报记录警告用户一次，并标记分类为3举报有效记警告
	 * 
	 * @param modelMap
	 * @param page
	 * @param req
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> addOneReportTime(ModelMap modelMap, PageParameter page, HttpServletRequest req) {
		ResponseMessage<String> resData = new ResponseMessage<String>();
		reportInformationService.addOneReportTime(Long.valueOf(req.getParameter("reportUserId")),
				Long.valueOf(req.getParameter("reportId")));
		return resData;
	}

	/**
	 * 删除举报（①修改标记分类为2②删除举报信息③发送退信信息到用户 ）
	 * 
	 * @param modelMap
	 * @param page
	 * @param req
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> deleteReportInformation(ModelMap modelMap, PageParameter page,
			HttpServletRequest req) {
		ResponseMessage<String> resData = new ResponseMessage<String>();
		try {
			String reportUserId = req.getParameter("reportUserId");
			String reportContent = req.getParameter("reportContent");
			// 判断字节长度是否大于20个汉字，若多则截取
			if (reportContent.length() > 20) {
				reportContent = reportContent.trim().substring(0, 20);
				reportContent = reportContent + "...";
			}
			String pushAlias = req.getParameter("pushAlias");
			String reportType = req.getParameter("reportType");
			String contentGroup = req.getParameter("contentGroup");
			String reportReason = null;
			if (contentGroup.equals("1")) {
				reportReason = "广告等垃圾内容";
			} else if (contentGroup.equals("2")) {
				reportReason = "不友善内容";
			} else if (contentGroup.equals("3")) {
				reportReason = "违法违规行为";
			} else if (contentGroup.equals("4")) {
				reportReason = "恶意行为";
			}
			// 举报来源分类+举报理由+举报内容（20字）
			String message = reportType + "%" + reportReason + "%" + reportContent;
			OperationMessage operationMessage = new OperationMessage();
			operationMessage.setContent(message);
			operationMessage.setMessageGroup("2");
			operationMessage.setPushAlias(pushAlias);
			OperationMessageQueue.putReportQueue(operationMessage);
			// 删除举报的内容
			reportInformationService.deleteReportInformation(Byte.valueOf(req.getParameter("reportGroup")),
					Long.valueOf(req.getParameter("dataId")));
			// 记录警告一次并修改标记分类
			reportInformationService.addOneReportTimeSetTwo(Long.valueOf(req.getParameter("reportUserId")),
					Long.valueOf(req.getParameter("reportId")));

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
			resData.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			resData.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}
		return resData;
	}
}
