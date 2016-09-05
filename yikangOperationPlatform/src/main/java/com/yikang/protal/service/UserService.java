package com.yikang.protal.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.base.AliasFactory;
import com.yikang.base.InvitationCodeGnerateUtil;
import com.yikang.protal.entity.Adetps;
import com.yikang.protal.entity.Count;
import com.yikang.protal.entity.Location;
import com.yikang.protal.entity.User;
import com.yikang.protal.entity.UserInfo;
import com.yikang.protal.entity.UserServiceInfo;
import com.yikang.protal.manager.IntegralManager;
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
	
	@Autowired
	private IntegralManager integralManager;
	
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
	 * @desc 获取每日用户数量
	 * */
	public List<Count> getSevenDayUserCount(Integer userFrom){
		List<Count> countList=new ArrayList<Count>();
		List<String> startDateList=new ArrayList<String>();
		List<String> endDateList=new ArrayList<String>();
		for(int i=0;i<7;i++){
			Calendar cal=Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, -i);
			cal.set(Calendar.HOUR_OF_DAY, 0);
	        cal.set(Calendar.SECOND, 0);
	        cal.set(Calendar.MINUTE, 0);
	        cal.set(Calendar.MILLISECOND, 0);
	        startDateList.add(cal.getTimeInMillis()+"");
	        System.out.println(cal.get(Calendar.YEAR)+"年"+(cal.get(Calendar.MONTH)+1)+"月"+cal.get(Calendar.DAY_OF_MONTH)+"日"+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));
		}
		System.out.println("零点:"+startDateList.toString());
		for(int i=0;i<7;i++){
			Calendar cal=Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, -i+1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
	        cal.set(Calendar.SECOND, 0);
	        cal.set(Calendar.MINUTE, 0);
	        cal.set(Calendar.MILLISECOND, -1);
	        endDateList.add(cal.getTimeInMillis()+"");
	        System.out.println(cal.get(Calendar.YEAR)+"年"+(cal.get(Calendar.MONTH)+1)+"月"+cal.get(Calendar.DAY_OF_MONTH)+"日"+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));
		}
		System.out.println("午夜："+endDateList.toString());
		
		for(int i=0 ; i<7 ; i++){		
			int number=userManager.getUserDayNumber(Long.valueOf(startDateList.get(i)),Long.valueOf(endDateList.get(i)),userFrom);
			long time = Long.valueOf(startDateList.get(i));
	        Calendar c = Calendar.getInstance();	         
	        c.setTimeInMillis(time);
	        java.util.Date date = c.getTime();
	        SimpleDateFormat df = new SimpleDateFormat("MM月dd日");
	        String checkDay=df.format(date);
	        
			Count count=new Count();
			count.setCount(number);
			count.setCheckDay(checkDay);
			countList.add(count);
		}
		return countList;
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
		userManager.updateUserPositionStatusCheckePass(paramData);
		integralManager.insertIntegralAddScoreIsONCEJob("RZCG", Long.valueOf(paramData.get("userId").toString()));
		return 1;
	}
	
}
