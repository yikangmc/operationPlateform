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
import com.yikang.protal.dao.ForumPostsAnswerDao;
import com.yikang.protal.dao.RecommendDataDao;
import com.yikang.protal.dao.TaglibDao;
import com.yikang.protal.entity.FormPosts;
import com.yikang.protal.entity.FormPostsTaglibsMap;
import com.yikang.protal.entity.ForumPostsAnswer;
import com.yikang.protal.entity.ForumPostsImage;
import com.yikang.protal.manager.ForumPostDetailManager;
import com.yikang.protal.manager.ForumPostsImageManager;

@Service
public class ForumArticleManageService {
	@Autowired
	private FormPostsDao formPostsDao;
	@Autowired
	private ForumPostsAnswerDao forumPostsAnswerDao;
	@Autowired
	private FormPostsTaglibsMapDao formPostsTaglibsMapDao;
	@Autowired
	private ForumPostsImageManager forumPostsImageManager;
	@Autowired
	private ForumPostDetailManager forumPostDetailManager;

	@Autowired
	private TaglibDao taglibDao;

	/**
	 * @author zxh
	 * @date 2016-07-06 14:06
	 * @desc 获取帖子列表（按照更新时间倒序）
	 */
	public List<FormPosts> getAllArticleListByPage(Map<String, Object> paramMap) {
		return formPostsDao.getAllArticleListByPage(paramMap);
	}

	/**
	 * 通过ID来更新帖子是否为精华
	 * 
	 * @param forumPostsId
	 * @return
	 */
	public int updateIssenceByPrimaryKey(Long forumPostsId) {
		formPostsDao.updateTieziByPrimaryKey(forumPostsId);
		return 1;
	}

	/**
	 * 取消该精华帖子为普通
	 * 
	 * @param forumPostsId
	 * @return
	 */
	public int cancelIssenceByPrimaryKey(Long forumPostsId) {
		formPostsDao.cancelIssenceByPrimaryKey(forumPostsId);
		return 1;
	}

	/**
	 * 删除帖子
	 */
	public int deleteFormPostsById(Long formPostsId) {
		formPostsDao.deleteByPrimaryKey(formPostsId);
		List<FormPostsTaglibsMap> taglibId = formPostsTaglibsMapDao.selectTagLibIdByFormPostId(formPostsId);
		if (taglibId.size() > 0) {
			for (FormPostsTaglibsMap formPostsTaglibsMap : taglibId) {
				taglibDao.updateForumPostsTZNumberSubByTaglibId(formPostsTaglibsMap.getTagLibsId());
			}
		}
		return 1;
	}

	public List<ForumPostsAnswer> getForumPostsAnswersByFormPostId(Long forumPostsId) {
		return forumPostsAnswerDao.getForumPostsAnswersByFormPostId(forumPostsId);
	}

	/**
	 * 保存帖子业务
	 * 
	 * @return
	 */
	public int insertSelective(String title, String content, String forumPostDetailContent, Long userId,
			String[] images, Long[] taglibIds) {

		// UserServiceInfo
		// userServiceInfo=userManager.getUserServiceInfoByUserId(userId);

		Date currentDate = Calendar.getInstance().getTime();

		FormPosts formPosts = new FormPosts();

		formPosts.setTitle("");
		formPosts.setContent(content);
		formPosts.setCreateUserId(userId);
		formPosts.setIsEssence(Byte.valueOf("0"));
		if (images == null) {
			formPosts.setRecommendPicUrl("");
		} else {
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
		if (images != null) {
			for (int i = 0; i < images.length; i++) {
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
