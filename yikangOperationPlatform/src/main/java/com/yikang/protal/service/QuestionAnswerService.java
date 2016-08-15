package com.yikang.protal.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.ParameterParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.entity.QuestionAnswer;
import com.yikang.protal.manager.QuestionAnswerManager;

@Service
public class QuestionAnswerService {
	
	@Autowired
	private QuestionAnswerManager questionAnswerManager;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-08-12 10:46
	 * @desc 获取答案列表
	 * ***/
	public List<QuestionAnswer> getQuestionAnswerListPage(String questionTitle,String questionAnswer,Long answerId,Date answerStartDateTime,Date answerEndTime,PageParameter page){
		return questionAnswerManager.getQuestionAnswerListPage(questionTitle, questionAnswer, answerId, answerStartDateTime, answerEndTime,page);
	}

}
