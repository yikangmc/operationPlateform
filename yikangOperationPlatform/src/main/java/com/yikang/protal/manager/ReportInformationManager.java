package com.yikang.protal.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.ReportInformationDao;
import com.yikang.protal.entity.ReportInformation;

@Component
public class ReportInformationManager {
	@Autowired
	private ReportInformationDao reportInformationDao;

	/**
	 * 获取举报信息列表
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<ReportInformation> getAllReportsListByPage(Map<String, Object> paramMap) {
		return reportInformationDao.getAllReportsListByPage(paramMap);
	}

	/**
	 * 举报记录警告用户+1，并设置标记分类为3，举报有效记警告
	 * 
	 * @param reportUserId
	 * @return
	 */
	public int addOneReportTime(Long reportUserId, Long reportId) {
		// 用户被举报次数+1
		reportInformationDao.addOneReportTimeByUserId(reportUserId);
		// 举报信息标记分类修改为3：举报有效记警告
		reportInformationDao.warnUpdateStatus(reportId);
		return 1;
	}

	/**
	 * 举报记录警告用户+1,并设置标记分类为2，举报有效删除
	 * 
	 * @param reportUserId
	 * @return
	 */
	public int addOneReportTimeSetTwo(Long reportUserId, Long reportId) {
		// 用户被举报次数+1
		reportInformationDao.addOneReportTimeByUserId(reportUserId);
		// 举报信息标记分类修改为2：举报有效删除
		reportInformationDao.deleteUpdateStatus(reportId);
		return 1;
	}

	/**
	 * 忽略并修改标识分类4举报无效
	 * 
	 * @param reportId
	 * @return
	 */
	public int ignoreUpdateStatus(Long reportId) {
		reportInformationDao.ignoreUpdateStatus(reportId);
		return 1;
	}

	/**
	 * 删除举报内容
	 * 
	 * @param reportGroup
	 * @param dataId
	 * @return
	 */
	public int deleteReportInformation(Byte reportGroup, Long dataId) {
		if (reportGroup == 3) {
			// 删除问题
			reportInformationDao.deleteReportInformationByQuestion(dataId);
		} else {
			// 删除文章和帖子
			reportInformationDao.deleteReportInformationByForm(dataId);
		}
		return 1;
	}
}
