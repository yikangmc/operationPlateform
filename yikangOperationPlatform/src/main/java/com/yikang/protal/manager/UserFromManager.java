package com.yikang.protal.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.UserFromDao;
import com.yikang.protal.entity.UserFrom;


@Component
public class UserFromManager {

	
	@Autowired
	private UserFromDao userFromDao;
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/9/1 14:14
	 * @desc 添加用户来源
	 * */
	public  int insertSelective(UserFrom record){
		return userFromDao.insert(record);
	}
	
	
}
