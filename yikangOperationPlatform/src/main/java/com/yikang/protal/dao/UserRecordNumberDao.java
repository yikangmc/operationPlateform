package com.yikang.protal.dao;

import java.util.Map;

import com.yikang.protal.entity.User;

public interface UserRecordNumberDao {
	// 文章
	long userRecordNumberForumPost(Map<String, Object> modelMap);

	// 帖子
	long userRecordNumberArticle(Map<String, Object> modelMap);

	// 问题
	long userRecordNumberQuestion(Map<String, Object> modelMap);

	// 问题的回答
	long userRecordNumberQuestionAnswer(Map<String, Object> modelMap);

}