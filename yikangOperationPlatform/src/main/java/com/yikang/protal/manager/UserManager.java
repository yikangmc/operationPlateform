package com.yikang.protal.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.UserDao;
import com.yikang.protal.dao.UserInfoDao;
import com.yikang.protal.dao.UserLinkStatuDao;
import com.yikang.protal.dao.UserServiceInfoDao;
import com.yikang.protal.entity.Adetps;
import com.yikang.protal.entity.User;
import com.yikang.protal.entity.UserInfo;
import com.yikang.protal.entity.UserLinkStatu;
import com.yikang.protal.entity.UserServiceInfo;


@Component
public class UserManager {
	
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Autowired
	private UserLinkStatuDao userLinkStatuDao;
	
	
	@Autowired
	private UserServiceInfoDao userServiceInfoDao;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:20
	 * @desc 添加用户信息
	 * **/
	public int insertUserSelective(User user){
		return userDao.insertSelective(user);
	}
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 查询某一个用户
	 * **/
	public User selectByPrimaryKey(Long userId){
		return userDao.selectByPrimaryKey(userId);
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/08/26 11:09 修改用户信息
	 * */
	public int updateUser(User user){
		return userDao.updateByPrimaryKeySelective(user);
	}

	
	/**
	 * @author liushuaic
	 * @date 2015/08/27 19:13 
	 * 查询某一个用户
	 * */
	public User getUserByLoginName(String loginName){
		return userDao.getUserByLoginName(loginName);
	}
	
	
	public List<Map<String,Object>> getUserLinkUserStatus(){
		return userLinkStatuDao.getUserLinkUserStatus();
	}
	
	
	/**
	 *修改用户的联系状态
	 * */
	public int updateUserLinkStatus(Long userId){
		
		Date currentDateTime=Calendar.getInstance().getTime();

		UserLinkStatu userLinkStatu =new UserLinkStatu();
		userLinkStatu.setLinkUserId(userId);
		userLinkStatu.setCreateTime(currentDateTime);
		userLinkStatu.setUserLinkStatus(Byte.valueOf("1"));
		
		return userLinkStatuDao.insert(userLinkStatu);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-1-19 19:55
	 * @desc 添加用户信息
	 * */
	public int inserUserInfoSelective(UserInfo userInfo){
		return userInfoDao.insertSelective(userInfo);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016/01/21 19:55
	 * @desc 获取用户列表
	 * */
	public List<UserInfo> getUserInfoListPage(Map<String,Object> paramData){
		return userInfoDao.getUserInfoListPage(paramData);
	}
	/**
	 * @desc 获取每日用户数量
	 * */
	public int getUserDayNumber(long startDateList,long endDateList,Integer userFrom){
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("startDate", startDateList);
		paramData.put("endDate", endDateList);
		paramData.put("userFrom", userFrom);
		return userInfoDao.getUserCountByDate(paramData);
	}
	
	
    /**
     * @author liushuaic
     * @date 2015/11/18 15:29
     * @desc 邀请码，是根据用户id 获取的
     * 添加用户邀请码
     * */
	public int updateInvitationCodeByUserId(String invitationCode,Long userId){
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("invitationCode", invitationCode);
		paramData.put("userId", userId);
		return userDao.updateInvitationCodeByUserId(paramData);
	}
	
	public UserServiceInfo getUserServiceInfoByUserId(Long userId){
		return userServiceInfoDao.getUserServiceInfoByUserIdTwo(userId);
	}
	
	public List<UserServiceInfo> getUserServiceInfoListPage(Map<String,Object> paramData){
		return userServiceInfoDao.getUserServiceInfoListPage(paramData);
	}
	
	public int updateUserPositionStatusCheckePass(Map<String,Object> paramData){
		return userServiceInfoDao.updateUserPositionStatusCheckePass(paramData);
	}
	
	public List<Adetps>	getAdeptsListPage(Map<String,Object> paramData){
		return userServiceInfoDao.getAdeptsListPage(paramData);
	}

}
