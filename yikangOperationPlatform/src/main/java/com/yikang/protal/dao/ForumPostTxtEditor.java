package com.yikang.protal.dao;

import java.util.Date;

public class ForumPostTxtEditor {
    private Long forumPostTxtEditorId;

    private String uniqueCode;

    private Long ownUserId;

    private Date createDateTime;

    private Date updateDateTime;

    private Byte isDelete;

    public Long getForumPostTxtEditorId() {
        return forumPostTxtEditorId;
    }

    public void setForumPostTxtEditorId(Long forumPostTxtEditorId) {
        this.forumPostTxtEditorId = forumPostTxtEditorId;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode == null ? null : uniqueCode.trim();
    }

    public Long getOwnUserId() {
        return ownUserId;
    }

    public void setOwnUserId(Long ownUserId) {
        this.ownUserId = ownUserId;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}