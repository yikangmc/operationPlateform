package com.yikang.protal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.entity.Question;
import com.yikang.protal.service.QuestionSystemService;

/**
 * 问题管理系统
 * @author zxh
 *
 */
@Controller
public class QuestionSystemController {
	@Autowired
	private QuestionSystemService systemService;
	
	@RequestMapping
	public String queryAllQuestions(ModelMap modelMap,Question question,PageParameter page){
		modelMap.put("question", question);
		modelMap.put("page", page);
		List<Question> allQuestions = systemService.queryAllQuestions(modelMap);
		modelMap.put("allQuestions", allQuestions);
		return "question/questionList";
	}
}
