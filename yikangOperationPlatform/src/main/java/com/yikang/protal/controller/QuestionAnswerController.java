package com.yikang.protal.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.entity.QuestionAnswer;
import com.yikang.protal.service.QuestionAnswerService;

@Controller
public class QuestionAnswerController{

	
	@Autowired
	private QuestionAnswerService questionAnswerService;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-08-12 15:52
	 * @desc 获取回复列表
	 * */
	@RequestMapping
	public String questionAnswerList(ModelMap modelMap, String quetionTitle,String questionAnswerTitle,Long answerId,Date answerStartDateTime,Date answerEndTime,PageParameter page,HttpServletRequest hsr){
		List<QuestionAnswer> data=questionAnswerService.getQuestionAnswerListPage(hsr.getParameter("questionTitle"), hsr.getParameter("questionAnswerTitle"), answerId, answerStartDateTime, answerEndTime,page);
		modelMap.put("data", data);
		modelMap.put("page", page);
		return "questionAnswer/questionAnswerList";
	}
	
	
	/**
	 * 删除帖子回答
	 * @param hsr
	 * @return
	 */
	@RequestMapping
	public String deleteQuestionAnswer(HttpServletRequest hsr){
		int result = questionAnswerService.deleteQuestionAnswer(Long.valueOf(hsr.getParameter("questionAnswerId")));
		return "redirect:/questionAnswer/questionAnswerList";
	}
	
	
}
