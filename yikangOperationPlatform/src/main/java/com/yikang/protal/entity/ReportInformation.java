package com.yikang.protal.entity;

import java.sql.Date;

public class ReportInformation {
	// 主键
	private Long reportId;
	// 举报时间
	private Date reportTime;
	// 举报时间毫秒数
	private Long reportTimeMillisecond;
	// 举报来源分类
	private byte reportGroup;
	// 举报理由
	private byte contentGroup;
	// 数据来源id
	private Long dataId;
	// 举报者用户id
	private Long userId;
	// 被举报者内容所属用户id
	private Long reportUserId;
	// 标记分类
	private byte dataStatus;
	// 类型（帖子，文章，回答）
	private String reportType;
	// 内容详情
	private String reportContent;
	// 所属标签
	private String reportTaglibName;
	// 创建时间
	private String reportCreateTime;
	// 发布者
	private String reportReportName;
	// 发布者被举报次数
	private String reportNumber;
	// 发布者被举报有效次数
	private String reportValidNumber;
	// 举报者
	private String reportUserName;

	public String getReportValidNumber() {
		return reportValidNumber;
	}

	public void setReportValidNumber(String reportValidNumber) {
		this.reportValidNumber = reportValidNumber;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public String getReportTaglibName() {
		return reportTaglibName;
	}

	public void setReportTaglibName(String reportTaglibName) {
		this.reportTaglibName = reportTaglibName;
	}

	public String getReportCreateTime() {
		return reportCreateTime;
	}

	public void setReportCreateTime(String reportCreateTime) {
		this.reportCreateTime = reportCreateTime;
	}

	public String getReportReportName() {
		return reportReportName;
	}

	public void setReportReportName(String reportReportName) {
		this.reportReportName = reportReportName;
	}

	public String getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
	}

	public String getReportUserName() {
		return reportUserName;
	}

	public void setReportUserName(String reportUserName) {
		this.reportUserName = reportUserName;
	}

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public Long getReportTimeMillisecond() {
		return reportTimeMillisecond;
	}

	public void setReportTimeMillisecond(Long reportTimeMillisecond) {
		this.reportTimeMillisecond = reportTimeMillisecond;
	}

	public byte getReportGroup() {
		return reportGroup;
	}

	public void setReportGroup(byte reportGroup) {
		this.reportGroup = reportGroup;
	}

	public byte getContentGroup() {
		return contentGroup;
	}

	public void setContentGroup(byte contentGroup) {
		this.contentGroup = contentGroup;
	}

	public Long getDataId() {
		return dataId;
	}

	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getReportUserId() {
		return reportUserId;
	}

	public void setReportUserId(Long reportUserId) {
		this.reportUserId = reportUserId;
	}

	public byte getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(byte dataStatus) {
		this.dataStatus = dataStatus;
	}

}
