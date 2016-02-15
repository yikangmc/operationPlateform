package com.yikang.protal.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.AppointmentOrderDao;
import com.yikang.protal.entity.AppointmentOrder;

@Component
public class AppointmentOrderManager {

	@Autowired
	private AppointmentOrderDao appointmentOrderDao;
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016/01/26 14:56
	 * @desc 获取定单列表
	 * **/
	public List<AppointmentOrder> getAppointmentOrderLilstPage(Map<String,Object> paramData){
		return appointmentOrderDao.getAppointmentOrderLilstPage(paramData);
	}
	
}
