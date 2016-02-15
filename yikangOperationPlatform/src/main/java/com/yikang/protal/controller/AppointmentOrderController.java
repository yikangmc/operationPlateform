package com.yikang.protal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.entity.AppointmentOrder;
import com.yikang.protal.service.AppointmentOrderService;

@Controller
public class AppointmentOrderController {

	
	@Autowired
	private AppointmentOrderService appointmentOrderService;
	
	
	
	@RequestMapping
	public String appointmentOrderList(ModelMap modelMap,PageParameter page){
		List<AppointmentOrder>  data=appointmentOrderService.getAppointmentOrderLilstPage(modelMap);
		modelMap.put("data", data);
		return "appointmentOrder/appointmentOrderList";
	}
}
