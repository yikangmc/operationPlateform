package com.yikang.protal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yikang.common.message.im.Message;
import com.yikang.common.message.im.MessageQueue;
import com.yikang.common.utils.MessageProperties;
import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.common.utils.operationmessage.OperationMessage;
import com.yikang.protal.common.utils.operationmessage.OperationMessageQueue;
import com.yikang.protal.entity.Adetps;
import com.yikang.protal.entity.UserInfo;
import com.yikang.protal.entity.UserServiceInfo;
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
	
	@RequestMapping
	public String verificationList(ModelMap modelMap, UserServiceInfo userServiceInfo,PageParameter page ,HttpServletRequest req){
		modelMap.put("userServiceInfo", userServiceInfo);
		String operatorType = req.getParameter("operatorType");
		if(null==operatorType||operatorType.equals("null")){
			operatorType="1";
		}
		modelMap.put("positionAuditStatus", operatorType);
		modelMap.put("page", page);
		List<UserServiceInfo> userServiceInfoList=userService.listVerification(modelMap);
		modelMap.put("userServiceInfoList", userServiceInfoList);
		return "user/verification";
	}
	
	@RequestMapping
	public String updateUserPositionStatusCheckePass(String userId,String no,String otherReason,HttpServletRequest req){
		Map<String, Object> usiMap = new HashMap<String,Object>();
		String push_alias=req.getParameter("push_alias");
		//no值：2 通过，3 退回
		if("2".equals(no)){
			usiMap.put("userId", userId);
			usiMap.put("positionAuditStatus", 2);
			userService.updateUserPositionStatusCheckePass(usiMap);
		}else if("3".equals(no)){
			userId = req.getParameter("userId");
			usiMap.put("userId", userId);
			usiMap.put("positionAuditStatus", 3);
			userService.updateUserPositionStatusCheckePass(usiMap);
			String reasons[] = req.getParameterValues("reason");
			String message="";
			if(reasons.length>0){
				for(int i=0;i<reasons.length;i++){
					message+=reasons[i]+",";
				}
			}
			OperationMessage operationMessage = new OperationMessage();
			operationMessage.setContent(message);
			operationMessage.setMessageGroup("2");
			operationMessage.setPushAlias(push_alias);
			OperationMessageQueue.putUsersQueue(operationMessage);
		}
		return "redirect:/user/verificationList";
	}
	
}
