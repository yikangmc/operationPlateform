package com.yikang.protal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping(value="/home")
	public String home(){
		return "home/home";
	}
	
	@RequestMapping(value="/test")
	public String test(){
		return "shareUser/Test";
	}

}
