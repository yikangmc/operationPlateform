package com.yikang.protal.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.common.utils.UrlGenerateUtil;
import com.yikang.protal.dao.FormPostsDao;
import com.yikang.protal.dao.FormPostsTaglibsMapDao;
import com.yikang.protal.entity.FormPosts;
import com.yikang.protal.entity.FormPostsTaglibsMap;
import com.yikang.protal.entity.ForumPostDetail;
import com.yikang.protal.entity.ForumPostsImage;
import com.yikang.protal.entity.UserServiceInfo;
import com.yikang.protal.manager.ForumPostDetailManager;
import com.yikang.protal.manager.ForumPostManager;
import com.yikang.protal.manager.ForumPostsImageManager;
import com.yikang.protal.manager.UserManager;

@Component
public class ForumPostService {

	
	@Autowired
	private ForumPostManager forumPostManager;
	
	@Autowired
	private FormPostsDao formPostsDao;
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private FormPostsTaglibsMapDao formPostsTaglibsMapDao;
	
	@Autowired
	private ForumPostsImageManager forumPostsImageManager;
	
	@Autowired
	private ForumPostDetailManager forumPostDetailManager;
	
	
	public int insertSelective(String title,String content,String forumPostDetailContent,String forumPostHtmlDetailContent,String recommendPicUrl,Long userId,String[] images,Long[] taglibIds){
		
		
		
		//UserServiceInfo userServiceInfo=userManager.getUserServiceInfoByUserId(userId);
		
		Date currentDate = Calendar.getInstance().getTime();

		FormPosts formPosts = new FormPosts();

		formPosts.setTitle(title);
		formPosts.setContent(content);
		formPosts.setCreateUserId(userId);
		formPosts.setIsEssence(Byte.valueOf("0"));
		formPosts.setRecommendPicUrl(recommendPicUrl);
		formPosts.setAnswersNums(0);
		formPosts.setCreateTime(currentDate);
		formPosts.setUpdateTime(currentDate);
		formPosts.setShareUrl(UrlGenerateUtil.generateShareForumPostUrl());
		formPosts.setShareNum(0);
		formPosts.setStars(0);
		formPosts.setReportComplaintsStatus(Byte.valueOf("0"));
		formPosts.setForumPostGroup(Byte.valueOf("1"));
		formPostsDao.insertSelective(formPosts);
		forumPostDetailManager.insertSelective(forumPostDetailContent,forumPostHtmlDetailContent,formPosts.getForumPostId(),currentDate);

		// 添加标签
		for (Long tagLibId : taglibIds) {

			FormPostsTaglibsMap fptm = new FormPostsTaglibsMap();
			fptm.setCreateTime(currentDate);
			fptm.setUpdateTime(currentDate);
			fptm.setTagLibsId(tagLibId);
			fptm.setFormPostId(formPosts.getForumPostId());
			formPostsTaglibsMapDao.insertSelective(fptm);
		}
		// 添加图片
		for (int i=1;i< images.length;i++) {
			ForumPostsImage forumPostsImage = new ForumPostsImage();
			forumPostsImage.setCreateTime(currentDate);
			forumPostsImage.setForumPostsId(formPosts.getForumPostId());
			forumPostsImage.setImageUrl(images[i]);
			forumPostsImageManager.insertSelective(forumPostsImage);
		}
		
		return  1;
	}
	
}
