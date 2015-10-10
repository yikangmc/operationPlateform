package com.yikang.protal.entity;

import java.util.Date;

public class UserLinkStatu {
    private Long userStatusId;

    private Byte userLinkStatus;

    private Date createTime;

    private Date updateTime;

    private Long linkUserId;

    public Long getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(Long userStatusId) {
        this.userStatusId = userStatusId;
    }

    public Byte getUserLinkStatus() {
        return userLinkStatus;
    }

    public void setUserLinkStatus(Byte userLinkStatus) {
        this.userLinkStatus = userLinkStatus;
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

    public Long getLinkUserId() {
        return linkUserId;
    }

    public void setLinkUserId(Long linkUserId) {
        this.linkUserId = linkUserId;
    }
}