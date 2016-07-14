package com.yikang.protal.manager;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.ForumPostDetailDao;
import com.yikang.protal.entity.FormPosts;
import com.yikang.protal.entity.ForumPostDetail;

@Component
public class ForumPostDetailManager {

	@Autowired
	private ForumPostDetailDao forumPostDetailDao;
	
	/**
	 * @author liushuaic
	 * @date 2016-06-22 17:32
	 * @desc 添加文章
	 * **/
	public int insertSelective(String forumPostDetailContent,String forumPostHtmlDetailContent,Long forumPostId,Date currentDate){
		
		
		if(null == currentDate){
			currentDate=Calendar.getInstance().getTime();
		}
		
		ForumPostDetail forumPostDetail=new ForumPostDetail();
		forumPostDetail.setForumPostDetailContent(forumPostDetailContent);
		forumPostDetail.setForumPostHtmlDetailContent(forumPostHtmlDetailContent);
		forumPostDetail.setCreateTime(currentDate);
		forumPostDetail.setUpdateTime(currentDate);
		forumPostDetail.setForumPostId(forumPostId);
		return forumPostDetailDao.insertSelective(forumPostDetail);
	}
	
	/**
	 * 更新文章
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(String forumPostDetailContent,String forumPostHtmlDetailContent,Long forumPostId,Date currentDate){
		if(null == currentDate){
			currentDate=Calendar.getInstance().getTime();
		}
		ForumPostDetail forumPostDetail=new ForumPostDetail();
		forumPostDetail.setForumPostDetailContent(forumPostDetailContent);
		forumPostDetail.setForumPostHtmlDetailContent(forumPostHtmlDetailContent);
		forumPostDetail.setCreateTime(currentDate);
		forumPostDetail.setUpdateTime(currentDate);
		forumPostDetail.setForumPostId(forumPostId);
		return forumPostDetailDao.updateByForumPostId(forumPostDetail);
	}
	
}
