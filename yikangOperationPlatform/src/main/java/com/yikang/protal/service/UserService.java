package com.yikang.protal.service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.entity.Location;
import com.yikang.protal.entity.User;
import com.yikang.protal.entity.UserInfo;
import com.yikang.protal.manager.LocationManager;
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
	
	
	@Autowired
	private LocationManager locationManager;
	
	
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
	
	
	/**
	 * @author liushuaic
	 * @date 2016-1-19 19:26
	 * @desc 保存用户
	 * */
	public int saveUser(User user){
		return userManager.insertUserSelective(user);
	}
			
	/**
	 * @author liushuaic
	 * @date 2016-1-19 19:26
	 * @desc 保存普通用户
	 * */
	public int saveUser(String mobileNumber,String userName,Integer sex,Integer age,String address,String districtCode,
			String mopPositionAddress,
			Double longitude,
			Double latitude
			){
			Long currentDateTime=Calendar.getInstance().getTimeInMillis();
			User user=new User();
			user.setLoginName(mobileNumber);
			user.setCreateTime(currentDateTime);
			user.setAccessTiket("");
			user.setUserName(mobileNumber);
			user.setSalt("");
			user.setLoginPassword(mobileNumber);
		
			 userManager.insertUserSelective(user);
			 
			Location city= locationManager.getCityByDistrictCode(districtCode);
			Location provence= locationManager.getProvenceByCityCode(districtCode);
			 
			 UserInfo userInfo=new UserInfo();
			 userInfo.setAddress(address);
			 userInfo.setCityCode(city.getAdministrativeCode());
			 userInfo.setCreateAt(currentDateTime);
			 userInfo.setDistrictCode(districtCode);
			 userInfo.setUpdateAt(currentDateTime);
			 userInfo.setProvenceCode(provence.getAdministrativeCode());
			 userInfo.setUserSex(sex.byteValue());
			 userInfo.setUserName(userName);
			 userManager.inserUserInfoSelective(userInfo);
		 
		 return 1;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016/1/21 14:56
	 * @desc 获取用户列表
	 * */
	public List<UserInfo> listUser(Map<String,Object>  paramMap){
		return userManager.getUserInfoListPage(paramMap);
	}
	
}
