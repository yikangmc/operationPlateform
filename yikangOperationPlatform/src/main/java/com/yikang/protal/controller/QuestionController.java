package com.yikang.protal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yikang.protal.base.BaseController;
import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.entity.Question;
import com.yikang.protal.entity.Taglib;
import com.yikang.protal.service.QuestionService;
import com.yikang.protal.service.TaglibService;

/**
 * 问题管理系统
 * @author zxh
 *
 */
@Controller
public class QuestionController extends BaseController{
	@Autowired
	private QuestionService systemService;
	
	@Autowired
	private TaglibService taglibService;
	
	@RequestMapping
	public String questionList(ModelMap modelMap,Question question,HttpServletRequest request){
		modelMap.put("question", question);
		PageParameter page=this.initPage(request);
		modelMap.put("page", page);
		List<Question> allQuestions = systemService.queryAllQuestions(modelMap);
		modelMap.put("allQuestions", allQuestions);
		return "question/questionList";
	}
	
	
	@RequestMapping
	public String questionCreate(ModelMap modelMap,Question question){
		
		List<Taglib> taglibs=taglibService.getAllTag(null);
		modelMap.put("taglibs",taglibs);
		return "question/questionCreate";
	}
	
}
