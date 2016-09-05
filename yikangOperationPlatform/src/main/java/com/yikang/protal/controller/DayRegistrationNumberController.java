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
		if(userFrom==null){
			userFrom=5;	
		}
		modelMap.put("userFrom", userFrom);
		List<Count> UserNumber = userService.getSevenDayUserCount(userFrom);
		modelMap.put("UserNumber", UserNumber);
		return "user/dayRegistrationNumber";
	}
}
