package com.yikang.protal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikang.protal.entity.AppointmentOrder;
import com.yikang.protal.manager.AppointmentOrderManager;

@Service
public class AppointmentOrderService {
	
	@Autowired
	private AppointmentOrderManager appointmentOrderManager;
	
	
	/**
	 * @author liushuaic
	 * @date 2016/01/26 15:43
	 * @desc 查询所有定单列表
	 * **/
	public List<AppointmentOrder> getAppointmentOrderLilstPage(Map<String,Object> paramData){
		return appointmentOrderManager.getAppointmentOrderLilstPage(paramData);
	}

}
