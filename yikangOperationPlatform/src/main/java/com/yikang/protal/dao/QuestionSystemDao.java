package com.yikang.protal.dao;

import java.util.List;
import java.util.Map;

import com.yikang.protal.entity.Question;

public interface QuestionSystemDao {
	/**
	 * 浏览问题
	 * @author zxh
	 * @return
	 */
	public List<Question> queryAllQuestions(Map<String ,Object> paramMap);
}
