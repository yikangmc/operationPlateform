package com.yikang.protal.entity;

import java.util.Date;

public class Answer {
    private Long answerId;

    private String answerText;

    private Integer answerVal;

    private Date createTime;

    private Date updateTime;

    private Long createUserId;

    private Byte answersDataSource;
    
    private Long questionId;
    
    private Integer starNum;
    
    private Byte isRecommend;

    public Byte getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Byte isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Integer getStarNum() {
		return starNum;
	}

	public void setStarNum(Integer starNum) {
		this.starNum = starNum;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText == null ? null : answerText.trim();
    }

    public Integer getAnswerVal() {
        return answerVal;
    }

    public void setAnswerVal(Integer answerVal) {
        this.answerVal = answerVal;
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

    public Byte getAnswersDataSource() {
        return answersDataSource;
    }

    public void setAnswersDataSource(Byte answersDataSource) {
        this.answersDataSource = answersDataSource;
    }
}