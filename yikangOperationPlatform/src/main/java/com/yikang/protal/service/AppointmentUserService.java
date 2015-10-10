package com.yikang.protal.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikang.protal.entity.AppointmentUser;
import com.yikang.protal.manager.AppointmentUserManager;

@Service
public class AppointmentUserService {
	
	
	@Autowired
	private AppointmentUserManager appointmentUserManager;
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/21 12:26
	 * 添加预约用户
	 * 0:添加失败
	 * -1:已经预约
	 * >0:添加成功
	 * */
	public int insertSelective(String mobileNumber){
		
			List<AppointmentUser> data= appointmentUserManager.findAppointmentUserByMobileNumber(mobileNumber);
			if(null== data || data.size()==0){
				Date currentDateTime=Calendar.getInstance().getTime();
				AppointmentUser appointmentUser=new AppointmentUser();
				
				appointmentUser.setCreateTime(currentDateTime);
				appointmentUser.setUpdateTime(currentDateTime);
				appointmentUser.setMobileNumber(mobileNumber);
				appointmentUser.setCreateUserId(-1l);
				
				int i=appointmentUserManager.insertSelective(appointmentUser);
				if(i>0){
					return i;
				}
			}else{
				return -1;
			}
			

			return 0;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/21 13:34
	 * 修改预约用户信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(AppointmentUser appointmentUser){
		return appointmentUserManager.updateByPrimaryKeySelective(appointmentUser);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/21 14:55
	 * 查询预约用户列表
	 * **/
	public List<AppointmentUser> getAppointmentUserListPage(Map<String,Object> param){
		return appointmentUserManager.getAppointmentUserListPage(param);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/21 17:06
	 * 验证手机号，是否已经预约
	 * */
	public boolean validateMobileIsAppointment(String mobileNumber){
		List<AppointmentUser> data= appointmentUserManager.findAppointmentUserByMobileNumber(mobileNumber);
		if(null != data && data.size()>0){
			return false;
		}
		return true;
	}

}
