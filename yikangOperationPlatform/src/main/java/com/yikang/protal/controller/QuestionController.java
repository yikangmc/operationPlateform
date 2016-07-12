package com.yikang.protal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yikang.common.error.ExceptionConstants;
import com.yikang.protal.base.BaseController;
import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.common.response.ResponseMessage;
import com.yikang.protal.entity.Question;
import com.yikang.protal.entity.Taglib;
import com.yikang.protal.entity.User;
import com.yikang.protal.manager.UserManager;
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
	
	@Autowired
	private UserManager userManager;
	
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
	public String questionCreate(ModelMap modelMap,Question question,String userName){
		
		List<Taglib> taglibs=taglibService.getAllTag(null);
		modelMap.put("taglibs",taglibs);
		modelMap.put("userName", userName);
		return "question/questionCreate";
	}
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> questionSave(String userName,String title,Long[] taglibId,String content,String[] images){
		
		ResponseMessage<String> message=new ResponseMessage<String>();
		User user=userManager.getUserByLoginName(userName);
		if(null != user){
			Long userId=user.getUserId();
			systemService.insertQuestion(title, content, taglibId, userId, images);
		}else{
			message.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			message.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return message;
		
	}
	
}
