 package com.yikang.protal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yikang.protal.base.BaseController;
import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.entity.Count;
import com.yikang.protal.entity.CountTaglib;
import com.yikang.protal.service.UserService;

@Controller
public class DayRegistrationNumberController extends BaseController{
	
	@Autowired
	private UserService userService;	
	/**
	 * 日注册数量
	 * @param modelMap
	 * @return
	 */
	@RequestMapping
	public String dayRegistrationNumber(Integer userFrom,ModelMap modelMap,PageParameter page,HttpServletRequest req){
		
		modelMap.put("page", page);
		String title=req.getParameter("title");
		String content = req.getParameter("content");
		modelMap.put("title", title);
		modelMap.put("content", content);
		modelMap.put("userFrom", userFrom);
		System.out.println("日注册量"+userFrom);
		List<Count> UserNumber = userService.getSevenDayUserCount(userFrom);
		modelMap.put("UserNumber", UserNumber);
		return "user/dayRegistrationNumber";
	}
	/**
	 * 当天每个标签下的发帖量，专家说量，回答量，问题量
	 * @param modelMap
	 * @return
	 */
	@RequestMapping
	public String dayCardNumber(ModelMap modelMap,PageParameter page,HttpServletRequest req){
		modelMap.put("page", page);
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		modelMap.put("title", title);
		modelMap.put("content", content);
		// 发帖量
		List<CountTaglib> CountTaglib1=userService.getDayCardCount();
		modelMap.put("CountTaglib1", CountTaglib1);
		// 专家说量
		List<CountTaglib> CountTaglib2=userService.getDayExpertCount();
		modelMap.put("CountTaglib2", CountTaglib2);
		// 回答量
		List<CountTaglib> CountTaglib3=userService.getDayAnswerCount();
		modelMap.put("CountTaglib3", CountTaglib3);
		// 问题量
		List<CountTaglib> CountTaglib4=userService.getDayQuestionCount();
		modelMap.put("CountTaglib4", CountTaglib4);
		
		return "user/dayCardNumber";
	}
}
