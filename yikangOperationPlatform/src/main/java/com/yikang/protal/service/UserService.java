package com.yikang.protal.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.entity.User;
import com.yikang.protal.entity.UserLinkStatu;
import com.yikang.protal.manager.UserManager;


/**
 * 
 * @author liushuaic
 * @date 2015/01/09 15:08
 * 
 * 
 * **/

@Component
public class UserService {
	
	@Autowired
	private UserManager userManager;
	
	public boolean validateMoblieNumber(String mobileNumber){
		User user=userManager.getUserByLoginName(mobileNumber);
		if(null == user){
			return true;
		}else{
			return false;
		}
	}
	
	public List<Map<String,Object>> getUserLinkUserStatus(){
		return userManager.getUserLinkUserStatus();
	}
	
	/**
	 *修改用户的联系状态
	 * */
	public int updateUserLinkStatus(Long userId){
		return userManager.updateUserLinkStatus(userId);
	}

}
