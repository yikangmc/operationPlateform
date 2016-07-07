package com.yikang.protal.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikang.common.utils.UuidGernerator;
import com.yikang.protal.common.utils.UrlGenerateUtil;
import com.yikang.protal.dao.FormPostsDao;
import com.yikang.protal.dao.FormPostsTaglibsMapDao;
import com.yikang.protal.entity.FormPosts;
import com.yikang.protal.entity.FormPostsTaglibsMap;
import com.yikang.protal.entity.ForumPostsImage;
import com.yikang.protal.manager.ForumPostDetailManager;
import com.yikang.protal.manager.ForumPostsImageManager;

@Service
public class ForumArticleManageService {
	@Autowired
	private FormPostsDao formPostsDao;
	@Autowired
	private FormPostsTaglibsMapDao formPostsTaglibsMapDao;
	@Autowired
	private ForumPostsImageManager forumPostsImageManager;
	@Autowired
	private ForumPostDetailManager forumPostDetailManager;
	
	/**
     * @author zxh
     *  @date 2016-07-06 14:06
     * @desc 获取帖子列表（按照更新时间倒序）
     */
	public List<FormPosts> getAllArticleListByPage(Map<String,Object> paramMap){
		return formPostsDao.getAllArticleListByPage(paramMap);
	}
	
	/**
	 * 保存帖子业务
	 * @return
	 */
	public int insertSelective(String title, String content, String forumPostDetailContent, Long userId, String[] images, Long[] taglibIds) {

		// UserServiceInfo
		// userServiceInfo=userManager.getUserServiceInfoByUserId(userId);

		Date currentDate = Calendar.getInstance().getTime();

		FormPosts formPosts = new FormPosts();

		formPosts.setTitle("");
		formPosts.setContent(content);
		formPosts.setCreateUserId(userId);
		formPosts.setIsEssence(Byte.valueOf("0"));
		if(images == null ){
			formPosts.setRecommendPicUrl("");
		}else{
			formPosts.setRecommendPicUrl(images[0]);
		}
		formPosts.setAnswersNums(0);
		formPosts.setCreateTime(currentDate);
		formPosts.setUpdateTime(currentDate);
		formPosts.setShareUrl(UrlGenerateUtil.generateShareForumPostUrl());
		formPosts.setShareNum(0);
		formPosts.setStars(0);
		formPosts.setReportComplaintsStatus(Byte.valueOf("0"));
		formPosts.setForumPostGroup(Byte.valueOf("0"));
		formPosts.setForumPostsUuid(UuidGernerator.getUuidString());
		formPostsDao.insertSelective(formPosts);
		forumPostDetailManager.insertSelective(forumPostDetailContent, forumPostDetailContent,
				formPosts.getForumPostId(), currentDate);

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
		if(images!=null){
			for (int i = 1; i < images.length; i++) {
				ForumPostsImage forumPostsImage = new ForumPostsImage();
				forumPostsImage.setCreateTime(currentDate);
				forumPostsImage.setForumPostsId(formPosts.getForumPostId());
				forumPostsImage.setImageUrl(images[i]);
				forumPostsImageManager.insertSelective(forumPostsImage);
			}
		}

		return 1;
	}
}
