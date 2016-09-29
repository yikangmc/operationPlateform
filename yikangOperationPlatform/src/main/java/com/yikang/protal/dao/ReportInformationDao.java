package com.yikang.protal.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yikang.protal.entity.ReportInformation;

public interface ReportInformationDao {

	int deleteByPrimaryKey(Long reportId);

	int insert(ReportInformation record);

	int insertSelective(ReportInformation record);

	ReportInformation selectByPrimaryKey(Long reportId);

	int updateByPrimaryKeySelective(ReportInformation record);

	int updateByPrimaryKey(ReportInformation record);

	/**
	 * 获取举报信息列表
	 * 
	 * @author bry
	 * @date 2016-09-21 17:04
	 * @param paramMap
	 * @return
	 */
	public List<ReportInformation> getAllReportsListByPage(Map<String, Object> paramMap);

	/**
	 * 举报记录警告用户一次
	 * 
	 * @param reportUserId
	 * @return
	 */
	int addOneReportTimeByUserId(Long reportUserId);

	/**
	 * 警告：举报信息标记分类修改为3举报有效记警告
	 * 
	 * @param reportId
	 * @return
	 */
	int warnUpdateStatus(Long reportId);

	/**
	 * 删除：举报信息标记分类修改为2举报有效删除
	 * 
	 * @param reportId
	 * @return
	 */
	int deleteUpdateStatus(Long reportId);

	/**
	 * 忽略并修改标识分类为4举报无效
	 * 
	 * @param reportId
	 * @return
	 */
	int ignoreUpdateStatus(Long reportId);

	/**
	 * 删除举报内容
	 * 
	 * @param reportGroup
	 * @param dataId
	 * @return
	 */
	// 删除问题
	int deleteReportInformationByQuestion(Long dataId);

	// 删除文章和帖子
	int deleteReportInformationByForm(Long dataId);

}
