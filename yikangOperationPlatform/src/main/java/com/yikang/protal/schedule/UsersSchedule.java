package com.yikang.protal.schedule;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.base.cache.UsersCache;
import com.yikang.protal.entity.User;
import com.yikang.protal.manager.UserManager;

/**
 * @author houyt
 * @date 2016-09-20 16:13
 * @desc 用户表信息缓存任务
 **/
@Component(value="usersSchedule")
public class UsersSchedule {
	
	@Autowired
	private UserManager userManager;
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	/**
	 * @author houyt
	 * @date 2016-09-20 16:13
	 * @desc 重新加载数据
	 **/
	public void reloadUsersData(){
		logger.info("UsersSchedule -- > reloadUsersData");
		UsersCache.clear();
		List<User> users = userManager.getAllUsersData();
		for (User user : users) {
			UsersCache.put(user.getPushAlias(), user);
		}
		
	}

}
