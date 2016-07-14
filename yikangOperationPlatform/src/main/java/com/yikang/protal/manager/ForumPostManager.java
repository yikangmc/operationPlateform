package com.yikang.protal.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.FormPostsDao;
import com.yikang.protal.dao.FormPostsStarListDao;
import com.yikang.protal.dao.FormPostsTaglibsMapDao;
import com.yikang.protal.dao.ForumPostDetailDao;
import com.yikang.protal.dao.ForumPostsAnswerDao;
import com.yikang.protal.dao.ForumPostsImageDao;
import com.yikang.protal.entity.FormPosts;

@Component
public class ForumPostManager {

	@Autowired
	private FormPostsDao formPostsDao;
	@Autowired
	private ForumPostDetailDao forumPostDetailDao;
	@Autowired
	private ForumPostsAnswerDao forumPostsAnswerDao;
	@Autowired
	private ForumPostsImageDao forumPostsImageDao;
	@Autowired
	private FormPostsStarListDao formPostsStarListDao;
	@Autowired
	private FormPostsTaglibsMapDao formPostsTaglibsMapDao;
	
	
	public int insertSelective(FormPosts formPosts){
		return  formPostsDao.insertSelective(formPosts);
	}

	public int deleteByPrimaryKey(Long forumPostsId) {
		formPostsDao.deleteByPrimaryKey(forumPostsId);
		forumPostDetailDao.deleteByForumPostId(forumPostsId);
		forumPostsAnswerDao.deleteByForumPostId(forumPostsId);
		forumPostsImageDao.deleteByForumPostsId(forumPostsId);
		formPostsStarListDao.deleteByForumPostId(forumPostsId);
		return formPostsTaglibsMapDao.deleteByFormPostId(forumPostsId);
	}
	
}
