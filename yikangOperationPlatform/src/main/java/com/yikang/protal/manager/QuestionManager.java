package com.yikang.protal.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.QuestionDao;
import com.yikang.protal.entity.Question;

@Component
public class QuestionManager {
	
	@Autowired
	private QuestionDao questionDao;

	
	/**
	 * 浏览问题
	 * @param map
	 * @return
	 */
	public List<Question> queryAllQuestionsPage(Map<String,Object> paramMap){
		return questionDao.queryAllQuestionsPage(paramMap);
	}
}
