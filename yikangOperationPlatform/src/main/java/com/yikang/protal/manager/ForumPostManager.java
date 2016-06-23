package com.yikang.protal.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.FormPostsDao;
import com.yikang.protal.entity.FormPosts;

@Component
public class ForumPostManager {

	@Autowired
	private FormPostsDao formPostsDao;
	
	
	
	public int insertSelective(FormPosts formPosts){
		return  formPostsDao.insertSelective(formPosts);
	}
	
}
