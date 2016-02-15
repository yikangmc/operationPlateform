package com.yikang.protal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.entity.AppointmentUser;
import com.yikang.protal.entity.UserInfo;
import com.yikang.protal.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping
	public String addUser(String mobileName){
		return "user/addUser";
	}
	
	
	@RequestMapping
	public String saveUser(String loginName,String password,String userName,Integer sex,String bithDay,Integer age,
			String address,String cityCode,String mapPositionAddress,Double longitude,Double latitude){
			userService.saveUser(loginName,password,userName,sex,age,address,cityCode,mapPositionAddress,longitude,latitude);
		return "";
	}
	
	@RequestMapping
	public String userList(ModelMap modelMap, UserInfo userInfo,PageParameter page){
		modelMap.put("page", page);
		modelMap.put("userInfo", userInfo);
		List<UserInfo> data=userService.listUser(modelMap);
		modelMap.put("data", data);
		return "user/userList";
	}

	@RequestMapping
	public String editUser(){
		return "";
	}
	
}
