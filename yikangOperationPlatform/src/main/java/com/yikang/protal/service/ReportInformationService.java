package com.yikang.protal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.ReportInformationDao;
import com.yikang.protal.entity.ReportInformation;
import com.yikang.protal.manager.ReportInformationManager;

@Component
public class ReportInformationService {
	@Autowired
	private ReportInformationManager reportInformationManager;

	/**
	 * 获取举报信息
	 * 
	 * @author bry
	 * @date 2016-9-21 17:03
	 * @param paramMap
	 * @return
	 */
	public List<ReportInformation> findAllReports(Map<String, Object> paramMap) {
		return reportInformationManager.getAllReportsListByPage(paramMap);
	}

	/**
	 * 举报记录警告用户+1，并设置标记分类为3，举报有效记警告
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addOneReportTime(Long reportUserId, Long reportId) {
		reportInformationManager.addOneReportTime(reportUserId, reportId);
		return 1;
	}

	/**
	 * 举报记录警告用户+1,并设置标记分类为2，举报有效删除
	 * 
	 * @param paramMap
	 * @return
	 */
	public int addOneReportTimeSetTwo(Long reportUserId, Long reportId) {
		reportInformationManager.addOneReportTimeSetTwo(reportUserId, reportId);
		return 1;
	}

	/**
	 * 忽略并修改标识分类4举报无效
	 * 
	 * @param reportId
	 * @return
	 */
	public int ignoreUpdateStatus(Long reportId) {
		reportInformationManager.ignoreUpdateStatus(reportId);
		return 1;

	}

	/**
	 * 删除举报内容
	 * 
	 * @return
	 */
	public int deleteReportInformation(Byte reportGroup, Long dataId) {
		reportInformationManager.deleteReportInformation(reportGroup, dataId);
		return 1;
	}
}
