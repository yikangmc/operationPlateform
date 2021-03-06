package com.yikang.protal.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.common.utils.UrlGenerateUtil;
import com.yikang.protal.dao.FormPostsDao;
import com.yikang.protal.dao.FormPostsTaglibsMapDao;
import com.yikang.protal.dao.TaglibDao;
import com.yikang.protal.entity.FormPosts;
import com.yikang.protal.entity.FormPostsTaglibsMap;
import com.yikang.protal.entity.ForumPostDetail;
import com.yikang.protal.entity.ForumPostsImage;
import com.yikang.protal.entity.Taglib;
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

	@Autowired
	private TaglibDao taglibDao;

	public long insertSelective(String title, String content, String forumPostDetailContent,
			String forumPostHtmlDetailContent, String recommendPicUrl, Long userId, String[] images, Long[] taglibIds) {

		// UserServiceInfo
		// userServiceInfo=userManager.getUserServiceInfoByUserId(userId);

		Date currentDate = Calendar.getInstance().getTime();

		FormPosts formPosts = new FormPosts();
		formPosts.setTitle(title);
		formPosts.setContent(content.length() > 100 ? content.substring(0, 100) : content);
		formPosts.setCreateUserId(userId);
		formPosts.setIsEssence(Byte.valueOf("0"));
		formPosts.setRecommendPicUrl(recommendPicUrl);
		formPosts.setAnswersNums(0);
		formPosts.setCreateTime(currentDate);
		formPosts.setUpdateTime(currentDate);
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String shareUrl = UrlGenerateUtil.generateShareForumPostUrl(uuid);
		formPosts.setShareUrl(shareUrl);
		formPosts.setForumPostsUuid(uuid);
		formPosts.setShareNum(0);
		formPosts.setStars(0);
		formPosts.setReportComplaintsStatus(Byte.valueOf("0"));
		formPosts.setForumPostGroup(Byte.valueOf("1"));
		formPostsDao.insertSelective(formPosts);
		// =================================================================================================
		Long formPostId = formPosts.getForumPostId();
		// =================================================================================================
		forumPostDetailManager.insertSelective(forumPostDetailContent, forumPostHtmlDetailContent,
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
		for (int i = 0; i < images.length; i++) {
			ForumPostsImage forumPostsImage = new ForumPostsImage();
			forumPostsImage.setCreateTime(currentDate);
			forumPostsImage.setForumPostsId(formPosts.getForumPostId());
			forumPostsImage.setImageUrl(images[i]);
			forumPostsImageManager.insertSelective(forumPostsImage);
		}

		// return 1;
		return formPostId;
	}

	public int updateSelective(String title, String forumPostId, String content, String forumPostDetailContent,
			String forumPostHtmlDetailContent, String recommendPicUrl, Long userId, String[] images, Long[] taglibIds) {
		Date currentDate = Calendar.getInstance().getTime();

		FormPosts formPosts = new FormPosts();
		formPosts.setForumPostId(Long.valueOf(forumPostId));
		formPosts.setTitle(title);
		formPosts.setContent(content);
		formPosts.setCreateUserId(userId);
		formPosts.setIsEssence(Byte.valueOf("0"));
		formPosts.setRecommendPicUrl(recommendPicUrl);
		formPosts.setAnswersNums(0);
		formPosts.setCreateTime(currentDate);
		formPosts.setUpdateTime(currentDate);
		// String shareUrl=UrlGenerateUtil.generateShareForumPostUrl();
		// formPosts.setShareUrl(shareUrl);
		formPosts.setShareNum(0);
		formPosts.setStars(0);
		formPosts.setReportComplaintsStatus(Byte.valueOf("0"));
		formPosts.setForumPostGroup(Byte.valueOf("1"));

		formPostsDao.updateByPrimaryKeySelective(formPosts);
		forumPostDetailManager.updateByPrimaryKeySelective(forumPostDetailContent, forumPostHtmlDetailContent,
				Long.valueOf(forumPostId), currentDate);
		// 先删除原来的
		formPostsTaglibsMapDao.deleteByFormPostId(Long.valueOf(forumPostId));
		// 更新标签
		for (Long tagLibId : taglibIds) {
			FormPostsTaglibsMap fptm = new FormPostsTaglibsMap();
			fptm.setCreateTime(currentDate);
			fptm.setUpdateTime(currentDate);
			fptm.setTagLibsId(tagLibId);
			fptm.setFormPostId(Long.valueOf(forumPostId));
			formPostsTaglibsMapDao.insertSelective(fptm);
		}
		// 更新图片
		for (int i = 0; i < images.length; i++) {
			ForumPostsImage forumPostsImage = new ForumPostsImage();
			forumPostsImage.setCreateTime(currentDate);
			forumPostsImage.setForumPostsId(Long.valueOf(forumPostId));
			forumPostsImage.setImageUrl(images[i]);
			forumPostsImageManager.insertSelective(forumPostsImage);
		}
		return 1;
	}

	public List<FormPosts> findAllFormPosts(Map<String, Object> paramMap) {
		return formPostsDao.getAllProfessionListByPage(paramMap);
	}

	public List<FormPosts> findAllFormPostsByTitle(Map<String, Object> paramMap) {
		return formPostsDao.getAllFormPostsByTitle(paramMap);
	}

	public List<FormPosts> findAllFormPostsByContent(Map<String, Object> paramMap) {
		return formPostsDao.getAllFormPostsByContent(paramMap);
	}

	public FormPosts findForumPostsInfo(Long forumPostsId) {
		return formPostsDao.queryFormPostsInfo(forumPostsId);
	}

	public List<Long> queryFormPostsTaglibsByFormPostsId(Long forumPostsId) {
		return formPostsDao.queryFormPostsTaglibsByFormPostsId(forumPostsId);
	}
	//删除文章
	public int deleteByPrimaryKey(Long forumPostsId) {
		List<FormPostsTaglibsMap> taglibsId = formPostsTaglibsMapDao.selectTagLibIdByFormPostId(forumPostsId);
		if (taglibsId != null) {
			for (int i = 0; i < taglibsId.size(); i++) {
				taglibDao.updateForumPostsNumberSubByTaglibId(Long.valueOf(taglibsId.get(i).getTagLibsId()));
			}
		}
		forumPostManager.deleteByPrimaryKey(forumPostsId);
		return 1;
	}

	// 通过ID来更新文章是否为精华
	public int updateIssenceByPrimaryKey(Long forumPostsId) {
		formPostsDao.updateTieziByPrimaryKey(forumPostsId);
		return 1;
	}

	// 通过ID来取消精华文章为普通
	public int cancelIssenceByPrimaryKey(Long forumPostsId) {
		formPostsDao.cancelIssenceByPrimaryKey(forumPostsId);
		return 1;
	}

	// 通过ID来修改文章审核状态：通过
	public int okStatusByPrimaryKey(Long forumPostsId) {
		formPostsDao.okStatusByPrimaryKey(forumPostsId);
		return 1;
	}

	// 通过ID来修改文章审核状态：不通过
	public int noStatusByPrimaryKey(Long forumPostsId) {
		formPostsDao.noStatusByPrimaryKey(forumPostsId);
		return 1;
	}
}
