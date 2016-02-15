package com.yikang.protal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikang.protal.entity.SeniorAccount;
import com.yikang.protal.manager.SeniorAccountManager;

@Service
public class SeniorAccountService {
	
	@Autowired
	private SeniorAccountManager seniorAccountManager;
	
	
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2016/01/26 20:24
	 * @desc 获取患者列表
	 * 
	 * **/
	public List<SeniorAccount> getSeniorAccountListPage(Map<String,Object> paramData){
		 return seniorAccountManager.getSeniorAccountListPage(paramData);
	}
	

}
