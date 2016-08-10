package com.yikang.protal.entity;

import java.util.Date;

public class Adetps {
	
	private Long adeptId;
	
	private String adeptName;
	
	private Date createTime;
	
	private Date updateTime;
	
	private Integer isDelete;
	
	private Integer type;

	public Long getAdeptId() {
		return adeptId;
	}

	public void setAdeptId(Long adeptId) {
		this.adeptId = adeptId;
	}

	public String getAdeptName() {
		return adeptName;
	}

	public void setAdeptName(String adeptName) {
		this.adeptName = adeptName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
