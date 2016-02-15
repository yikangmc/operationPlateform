package com.yikang.protal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.entity.SeniorAccount;
import com.yikang.protal.manager.SeniorAccountManager;

@Controller
public class SeniorAccountController {
	
	
	@Autowired
	private SeniorAccountManager seniorAccountManager;
	
	/**
	 * @author liushuaic
	 * @date 2016/01/27 
	 * */
	@RequestMapping
	public String seniorAccountList(ModelMap modelMap,PageParameter page){
		modelMap.put("page", page);
		List<SeniorAccount> data=seniorAccountManager.getSeniorAccountListPage(modelMap);
		modelMap.put("data", data);
		return "seniorAccount/seniorAccountList";
	}
	
	

}
