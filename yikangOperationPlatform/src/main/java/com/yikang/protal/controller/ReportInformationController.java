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
		System.out.println("主键" + req.getParameter("reportId"));
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
	 * 删除举报的内容，并且记录一次
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
			// 删除举报的内容
			reportInformationService.deleteReportInformation(Byte.valueOf(req.getParameter("reportGroup")),
					Long.valueOf(req.getParameter("dataId")));
			// 记录警告一次
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
