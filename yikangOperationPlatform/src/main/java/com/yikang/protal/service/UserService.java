package com.yikang.protal.service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.yikang.base.AliasFactory;
import com.yikang.base.InvitationCodeGnerateUtil;
import com.yikang.protal.entity.Adetps;
import com.yikang.protal.entity.Location;
import com.yikang.protal.entity.User;
import com.yikang.protal.entity.UserInfo;
import com.yikang.protal.entity.UserServiceInfo;
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
	public int saveUser(String loginName,String password,String userName,Integer sex,Integer age,String address,String districtCode,
			String mopPositionAddress,
			Double longitude,
			Double latitude
			){
			Long currentDateTime=Calendar.getInstance().getTimeInMillis();
			User user=new User();
			user.setLoginName(loginName);
			user.setCreateTime(currentDateTime);
			user.setAccessTiket("");
			user.setUserName(loginName);
			user.setSalt("");
			user.setLoginPassword(password);
			user.setLoginTime(currentDateTime);
		
			userManager.insertUserSelective(user);
			user.setPushAlias(AliasFactory.generateAliasByUser(user.getUserId().toString()));
			userManager.updateUser(user);  //修改用户推送
			//修改用户邀请码
			userManager.updateInvitationCodeByUserId(InvitationCodeGnerateUtil.generateInvitationCodeTwo(user), user.getUserId());
			 
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
	
	/**
	 * @desc 获取专业用户列表
	 * @param paramMap
	 * @return
	 */
	public List<UserServiceInfo> listVerification(Map<String, Object> paramMap){
		return userManager.getUserServiceInfoListPage(paramMap);
	}
	
	public List<Adetps> listAdepts(Map<String, Object> paramMap){
		return userManager.getAdeptsListPage(paramMap);
	}
	
	/**
	 * 更新专业用户认证信息
	 * @param userServiceInfoId
	 * @return
	 */
	public int updateUserPositionStatusCheckePass(Map<String,Object> paramData){
		return userManager.updateUserPositionStatusCheckePass(paramData);
	}
	
}
