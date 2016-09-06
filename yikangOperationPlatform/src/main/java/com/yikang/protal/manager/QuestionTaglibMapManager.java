package com.yikang.protal.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.QuestionTaglibMapDao;

@Component
public class QuestionTaglibMapManager {

	@Autowired
	private QuestionTaglibMapDao questionTaglibMapDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-08-06 17:42
	 * @desc 删除某一个问题下的所有标签
	 * */
	public int deleteQuestionTaglibByQuestionId(Long questionId){
		return questionTaglibMapDao.deleteQuestionTaglibMapByQuetionId(questionId);
	}
	
	
}
