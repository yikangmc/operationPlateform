package com.yikang.protal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yikang.common.utils.MatchHtmlElementAttrValue;
import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.common.response.ResponseMessage;
import com.yikang.protal.entity.FormPosts;
import com.yikang.protal.entity.ForumPostsAnswer;
import com.yikang.protal.entity.Taglib;
import com.yikang.protal.entity.User;
import com.yikang.protal.manager.UserManager;
import com.yikang.protal.service.ForumArticleManageService;
import com.yikang.protal.service.RecommendDataService;
import com.yikang.protal.service.TaglibService;

@Controller
public class ForumArticleMangeController {
	@Autowired
	private ForumArticleManageService manageService;
	@Autowired
	private UserManager userManager;
	@Autowired
	private TaglibService taglibService;
	@Autowired
	private RecommendDataService recommendDataService;

	/**
	 * 帖子列表
	 * 
	 * @author zxh
	 * @param modelMap
	 * @param formPosts
	 * @param page
	 * @return
	 */
	@RequestMapping
	public String getAllArticleList(ModelMap modelMap, FormPosts formPosts, PageParameter page,
			HttpServletRequest request, String content, Integer isEssence) {
		modelMap.put("content", content);
		modelMap.put("formPosts", formPosts);
		modelMap.put("page", page);
		modelMap.put("isEssence", isEssence);
		List<FormPosts> articleList = manageService.getAllArticleListByPage(modelMap);
		modelMap.put("articleList", articleList);
		return "forumPost/articleList";
	}

	/**
	 * 更新该帖子为精华
	 * 
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> isEssenceForumArticle(HttpServletRequest hsr) {
		ResponseMessage<String> resData = new ResponseMessage<String>();
		// 修改为精华
		manageService.updateIssenceByPrimaryKey(Long.valueOf(hsr.getParameter("forumPostsId")));
		// 插入推荐的列表
		recommendDataService.insertTieziByPrimaryKey(Long.valueOf(hsr.getParameter("forumPostsId")),
				hsr.getParameter("orders"));
		return resData;
	}

	/**
	 * 取消该精华帖子为普通
	 * 
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> cancelEssenceForumArticle(HttpServletRequest hsr) {
		ResponseMessage<String> resData = new ResponseMessage<String>();
		// 帖子列表修改为0
		manageService.cancelIssenceByPrimaryKey(Long.valueOf(hsr.getParameter("forumPostsId")));
		// 热门帖子列表删除
		recommendDataService.deleteHotByPrimaryKey(Long.valueOf(hsr.getParameter("forumPostsId")));
		return resData;
	}

	/**
	 * 发布帖子
	 * 
	 * @param modelMap
	 * @param userName
	 * @param title
	 * @param content
	 * @param recommendPicUrl
	 * @param images
	 * @param taglibId
	 * @param hsr
	 * @return
	 */
	@RequestMapping
	public String addForumPost(ModelMap modelMap, String userName, String title, String content,
			String[] recommendPicUrl, Long[] taglibId, HttpServletRequest hsr) {

		User user = userManager.getUserByLoginName(userName);
		String detailContent = MatchHtmlElementAttrValue.replaceAllHtmlTagContent(content);
		String forumPostDetailContent = detailContent;

		String subContent = forumPostDetailContent.replaceAll("\n", "").replaceAll(" ", "").replace("\r", "");
		String contentStr = subContent.length() > 100 ? subContent.substring(0, 100) : subContent;

		if (null != user && null != content && content.length() > 0 && null != taglibId && taglibId.length > 0) {
			manageService.insertSelective(title, contentStr, forumPostDetailContent, user.getUserId(), recommendPicUrl,
					taglibId);
			for(Long id:taglibId){
				taglibService.updateForumPostsTZNumberAddByTaglibId(id);
			}
		}
		modelMap.put("userName", userName);
		return "redirect:/forumArticleMange/getAllArticleList";
	}

	/**
	 * 帖子发布中间页
	 * 
	 * @param modelMap
	 * @param userName
	 * @return
	 */
	@RequestMapping
	public String forumPost(ModelMap modelMap, String userName) {
		List<Taglib> data = taglibService.getSecondAllTaglib();
		List<Taglib> data2 = taglibService.getAllTag(null);
		modelMap.put("taglibs", data);
		modelMap.put("taglibs2", data2);
		modelMap.put("userName", userName);
		return "forumPost/saveArticle";
	}

	/**
	 * 删除帖子
	 * 
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> deleteForumPost(ModelMap modelMap, HttpServletRequest request) {
		String forumPostId = request.getParameter("forumPostsId");
		ResponseMessage<String> rsMessage = new ResponseMessage<String>();
		// 获取帖子下的回答
		List<ForumPostsAnswer> answerList = manageService.getForumPostsAnswersByFormPostId(Long.valueOf(forumPostId));
		// 有回答不能删除帖子
		if (answerList.size() > 0) {
			rsMessage.setData("fail");
		} else {
			manageService.deleteFormPostsById(Long.valueOf(forumPostId));

			rsMessage.setData("success");
		}
		return rsMessage;
	}
}
