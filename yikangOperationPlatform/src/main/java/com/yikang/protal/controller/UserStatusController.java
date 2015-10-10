package com.yikang.protal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yikang.common.error.ExceptionConstants;
import com.yikang.protal.service.UserService;

@Controller
public class UserStatusController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping
	public String getUserStatusList(ModelMap modalMap){
			List<Map<String,Object>> data=userService.getUserLinkUserStatus();
			modalMap.put("data", data);
		 return "UserStatus/userStatus";
	}
	
	@RequestMapping
	@ResponseBody
	public Map<String,Object> updateUserStatusByUserId(Long userId){
		Map<String,Object> rtnData=new HashMap<String,Object>();
		
		userService.updateUserLinkStatus(userId);
		
		rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
		rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		return rtnData;
		
	}
	
	
	

}
