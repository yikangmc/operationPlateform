package com.yikang.protal.entity;

import java.util.Date;

public class AppointmentUser {
    private Long appointmentUserId;

    private Byte sex;

    private Date createTime;

    private Date updateTime;

    private Long createUserId;

    private Byte returnVisit;

    private Byte userStatus;

    private Byte haveSenior;

    private Long returnVisitUserId;

    private String mobileNumber;

    public Long getAppointmentUserId() {
        return appointmentUserId;
    }

    public void setAppointmentUserId(Long appointmentUserId) {
        this.appointmentUserId = appointmentUserId;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
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

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Byte getReturnVisit() {
        return returnVisit;
    }

    public void setReturnVisit(Byte returnVisit) {
        this.returnVisit = returnVisit;
    }

    public Byte getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Byte userStatus) {
        this.userStatus = userStatus;
    }

    public Byte getHaveSenior() {
        return haveSenior;
    }

    public void setHaveSenior(Byte haveSenior) {
        this.haveSenior = haveSenior;
    }

    public Long getReturnVisitUserId() {
        return returnVisitUserId;
    }

    public void setReturnVisitUserId(Long returnVisitUserId) {
        this.returnVisitUserId = returnVisitUserId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber == null ? null : mobileNumber.trim();
    }
}