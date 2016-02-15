package com.yikang.protal.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.SeniorAccountDao;
import com.yikang.protal.entity.SeniorAccount;

@Component
public class SeniorAccountManager {
	
	@Autowired
	private SeniorAccountDao seniorAccountDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2016/01/27 10:40
	 * @desc 获取患者的列表
	 * **/
	public List<SeniorAccount> getSeniorAccountListPage(Map<String,Object> paramData){
		return seniorAccountDao.getSeniorAccountListPage(paramData);
	}

}
