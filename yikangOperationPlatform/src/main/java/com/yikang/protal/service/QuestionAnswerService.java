package com.yikang.protal.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.ParameterParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.dao.QuestionAnswerDao;
import com.yikang.protal.entity.QuestionAnswer;
import com.yikang.protal.manager.QuestionAnswerManager;

@Service
public class QuestionAnswerService {
	
	@Autowired
	private QuestionAnswerManager questionAnswerManager;
	
	@Autowired
	private QuestionAnswerDao questionAnswerDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-08-12 10:46
	 * @desc 获取答案列表
	 * ***/
	public List<QuestionAnswer> getQuestionAnswerListPage(Integer isRecommend,String questionTitle,String questionAnswer,Long answerId,Date answerStartDateTime,Date answerEndTime,PageParameter page,String userName,String firstTime,String lastTime){
		return questionAnswerManager.getQuestionAnswerListPage(isRecommend,questionTitle, questionAnswer, answerId, answerStartDateTime, answerEndTime,page,userName,firstTime,lastTime);
	}
	
	public int deleteQuestionAnswer(Long questionAnswerId){
		return questionAnswerManager.deleteByPrimaryKey(questionAnswerId);
	}
	/**
	 * 	通过ID来更新问题回答是否为精华
	 * @param forumPostsId
	 * @return
	 */
	public int updateIssenceAnswerByPrimaryKey(Long questionAnswerId){
		questionAnswerDao.updateQuestionAnswerByPrimaryKey(questionAnswerId);
		return 1;
	}
	/**
	 * 	取消该精彩回答为普通
	 * @param forumPostsId
	 * @return
	 */
	public int cancelIssenceAnswerByPrimaryKey(Long questionAnswerId){
		questionAnswerDao.cancelQuestionAnswerByPrimaryKey(questionAnswerId);
		return 1;
	}

}
