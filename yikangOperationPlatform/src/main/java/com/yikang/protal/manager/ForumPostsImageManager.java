package com.yikang.protal.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.ForumPostsImageDao;
import com.yikang.protal.entity.ForumPostsImage;

@Component
public class ForumPostsImageManager {

	@Autowired
	private ForumPostsImageDao forumPostsImageDao;
	
	public int insertSelective(ForumPostsImage forumPostsImage ){
		return forumPostsImageDao.insertSelective(forumPostsImage);
	}
	
}
