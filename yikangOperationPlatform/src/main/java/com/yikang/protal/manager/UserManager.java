package com.yikang.protal.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.UserDao;
import com.yikang.protal.dao.UserInfoDao;
import com.yikang.protal.dao.UserLinkStatuDao;
import com.yikang.protal.entity.User;
import com.yikang.protal.entity.UserLinkStatu;


@Component
public class UserManager {
	
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Autowired
	private UserLinkStatuDao userLinkStatuDao;
	
	
	
	
	
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
	
}
