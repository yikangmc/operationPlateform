package com.yikang.protal.entity;

public class UserRecordNumber {
	// 文章数量
	private Long forumPostNumber;
	// 帖子数量
	private Long articleNumber;
	// 问题数量
	private Long questionNumber;
	// 问题的回答数量
	private Long questionAnswerNumber;

	public Long getForumPostNumber() {
		return forumPostNumber;
	}

	public void setForumPostNumber(Long forumPostNumber) {
		this.forumPostNumber = forumPostNumber;
	}

	public Long getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(Long articleNumber) {
		this.articleNumber = articleNumber;
	}

	public Long getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(Long questionNumber) {
		this.questionNumber = questionNumber;
	}

	public Long getQuestionAnswerNumber() {
		return questionAnswerNumber;
	}

	public void setQuestionAnswerNumber(Long questionAnswerNumber) {
		this.questionAnswerNumber = questionAnswerNumber;
	}

}
