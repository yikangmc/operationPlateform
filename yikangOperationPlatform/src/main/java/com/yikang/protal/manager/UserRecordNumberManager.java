package com.yikang.protal.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.UserRecordNumberDao;
import com.yikang.protal.entity.UserRecordNumber;

@Component
public class UserRecordNumberManager {

	@Autowired
	private UserRecordNumberDao userRecordNumberDao;

	/**
	 * 按账号查询任意日期区间个人的记录条数（ a.提出的问题 b.回答过的问题数量 c.发过的帖子数量 d.发过的专家说数量 ）
	 * 
	 * @param modelMap
	 * @return
	 */
	public UserRecordNumber userRecordNumber(Map<String, Object> modelMap) {
		// 文章
		long forumPostNumber = userRecordNumberDao.userRecordNumberForumPost(modelMap);
		// 帖子
		long articleNumber = userRecordNumberDao.userRecordNumberArticle(modelMap);
		// 问题
		long questionNumber = userRecordNumberDao.userRecordNumberQuestion(modelMap);
		// 问题的回答
		long questionAnswerNumber = userRecordNumberDao.userRecordNumberQuestionAnswer(modelMap);

		UserRecordNumber recordNumber = new UserRecordNumber();
		recordNumber.setForumPostNumber(forumPostNumber);
		recordNumber.setArticleNumber(articleNumber);
		recordNumber.setQuestionNumber(questionNumber);
		recordNumber.setQuestionAnswerNumber(questionAnswerNumber);

		return recordNumber;
	}

}
