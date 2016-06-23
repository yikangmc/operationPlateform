package com.yikang.protal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginTestController {

	
	@RequestMapping(value="/index")
	public String index(){
		return "forward:/appointmentOrder/appointmentOrderList";
	}
}
