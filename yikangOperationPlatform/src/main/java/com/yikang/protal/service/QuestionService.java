package com.yikang.protal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikang.protal.dao.QuestionDao;
import com.yikang.protal.entity.Question;
import com.yikang.protal.manager.QuestionManager;

/**
 * 问题管理service
 * @author zxh
 *
 */
@Service
public class QuestionService {
	
	
	@Autowired
	private QuestionManager questionManager; 
	
	/**
	 * 浏览问题
	 * @param map
	 * @return
	 */
	public List<Question> queryAllQuestions(Map<String,Object> paramMap){
		return questionManager.queryAllQuestionsPage(paramMap);
	}
	
}
