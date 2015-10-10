package com.yikang.protal.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.AppointmentUserDao;
import com.yikang.protal.entity.AppointmentUser;

@Component
public class AppointmentUserManager {

	
	@Autowired
	private AppointmentUserDao appointmentUserDao;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/21 12:26
	 * 添加预约用户
	 * */
	public int insertSelective(AppointmentUser appointmentUser){
		return appointmentUserDao.insertSelective(appointmentUser);
	}
	
	public int updateByPrimaryKeySelective(AppointmentUser appointmentUser){
		return appointmentUserDao.updateByPrimaryKeySelective(appointmentUser);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/21 14:16
	 * 获取预约用户列表
	 * */
	public List<AppointmentUser> getAppointmentUserListPage(Map<String,Object> param){
		return appointmentUserDao.getAppointmentUserListPage(param);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/21 17:06
	 * 查询某一个预约列表，根据，手机号
	 * */
	public List<AppointmentUser> findAppointmentUserByMobileNumber(String mobileNumber){
		return appointmentUserDao.findAppointmentUserByMobileNumber(mobileNumber);
	}
	
}
