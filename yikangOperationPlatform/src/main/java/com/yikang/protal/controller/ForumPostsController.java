package com.yikang.protal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yikang.common.utils.MatchHtmlElementAttrValue;
import com.yikang.protal.base.BaseController;
import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.entity.FormPosts;
import com.yikang.protal.entity.Taglib;
import com.yikang.protal.entity.User;
import com.yikang.protal.manager.UserManager;
import com.yikang.protal.service.ForumPostService;
import com.yikang.protal.service.TaglibService;

import sun.java2d.pipe.RenderQueue;

@Controller
public class ForumPostsController extends BaseController {
	
	@Autowired
	private ForumPostService forumPostService;
	
	
	@Autowired
	private TaglibService taglibService; 
	
	@Autowired
	private UserManager userManager;
	
	/**
	 * 文章列表
	 * @param modelMap
	 * @return
	 */
	@RequestMapping
	public String formPostList(ModelMap modelMap,PageParameter page,HttpServletRequest req){
		modelMap.put("page", page);
		String title=req.getParameter("title");
		String content = req.getParameter("content");
		modelMap.put("title", title);
		modelMap.put("content", content);
		List<FormPosts> allFormPosts = forumPostService.findAllFormPosts(modelMap);
		modelMap.addAttribute("formPostsList", allFormPosts);
		return "forumPost/formPostList";
	}
	
	
	
	@RequestMapping
	public String forumPost(ModelMap modelMap,String userName){
		List<Taglib> data=taglibService.getSecondAllTaglib();
		List<Taglib> data2=taglibService.getAllTag(null);
		modelMap.put("taglibs", data);
		modelMap.put("taglibs2", data2);
		modelMap.put("userName", userName);
		return "forumPost/forumPost";
	}
	
	
	@RequestMapping
	public String addForumPost(ModelMap modelMap,String userName,String title,String content,String recommendPicUrl,String[] images,Long[] taglibId,HttpServletRequest hsr){
		String contents=hsr.getParameter("content");
		User user=userManager.getUserByLoginName(userName);
		if(null != contents && contents.length()>0){
			List<String> imageArray=MatchHtmlElementAttrValue.getImgSrc(contents);
			String[] args={};
			images=imageArray.toArray(args.clone());
		}

		String forumPostHtmlDetailContent=content;
		content=content.replaceAll("<br>", "\n");
		content=content.replaceAll("&nbsp;", " ");
		content=content.replaceAll("&ldquo;", "");
		content=MatchHtmlElementAttrValue.replaseAndCharachter(content);
		String detailContent=MatchHtmlElementAttrValue.replaceAllHtmlTagContent(content);
		String forumPostDetailContent=detailContent;

		String subContent=forumPostDetailContent.replaceAll("\n","").replaceAll(" ","").replace("\r","");
		//String contentStr=subContent.length()>100?subContent.substring(0,100):subContent;

		if(null != user && null != content && null != recommendPicUrl  && content.length()>0 && null != images && images.length>0 && null != taglibId && taglibId.length>0){
			forumPostService.insertSelective(title,subContent,forumPostDetailContent,forumPostHtmlDetailContent,recommendPicUrl,user.getUserId(),images,taglibId);
			for(Long id:taglibId){
				taglibService.updateForumPostsTZNumberAddByTaglibId(id);
			}
		}
		modelMap.put("userName", userName);
		return "redirect:/forumPosts/forumPost";
	}
	
	@RequestMapping
	public String updateForumPosts(ModelMap modelMap,HttpServletRequest req){
		List<Taglib> data=taglibService.getSecondAllTaglib();
		List<Taglib> data2=taglibService.getAllTag(null);
		modelMap.put("taglibs", data);
		modelMap.put("taglibs2", data2);
		String forumPostsId = req.getParameter("forumPostsId");
		FormPosts formPosts = forumPostService.findForumPostsInfo(Long.valueOf(forumPostsId));
		List<Long> taglibList = forumPostService.queryFormPostsTaglibsByFormPostsId(Long.valueOf(forumPostsId));
		modelMap.addAttribute("taglibList", taglibList);
		modelMap.addAttribute("forumPosts", formPosts);
		return "forumPost/updateForumPosts";
	}
	
	/**
	 * 更新文章
	 * @return
	 */
	@RequestMapping
	public String updateForumPostsData(ModelMap modelMap,String forumPostId,String userName,String title,String content,String recommendPicUrl,String[] images,Long[] taglibId,HttpServletRequest hsr){
		String contents=hsr.getParameter("content");
		recommendPicUrl = recommendPicUrl.replace(",", "");
		User user=userManager.getUserByLoginName(userName);
		if(null != contents && contents.length()>0){
			List<String> imageArray=MatchHtmlElementAttrValue.getImgSrc(contents);
			String[] args={};
			images=imageArray.toArray(args.clone());
		}

		String forumPostHtmlDetailContent=content;
		content=content.replaceAll("<br>", "\n");
		content=content.replaceAll("&nbsp;", " ");
		content=content.replaceAll("&ldquo;", "");
		content=MatchHtmlElementAttrValue.replaseAndCharachter(content);
		String detailContent=MatchHtmlElementAttrValue.replaceAllHtmlTagContent(content);
		String forumPostDetailContent=detailContent;

		String subContent=forumPostDetailContent.replaceAll("\n","").replaceAll(" ","").replace("\r","");
		String contentStr=subContent.length()>100?subContent.substring(0,100):subContent;

		if(null != user && null != content && content.length()>0 && null != taglibId && taglibId.length>0){
			forumPostService.updateSelective(title,forumPostId,contentStr,forumPostDetailContent,forumPostHtmlDetailContent,recommendPicUrl,user.getUserId(),images,taglibId);
		}
		modelMap.put("userName", userName);
		return "redirect:/forumPosts/formPostList";
	}
	
	/**
	 * 删除文章
	 * @param hsr
	 * @return
	 */
	@RequestMapping
	public String deleteFormPost(HttpServletRequest hsr){
		int result = forumPostService.deleteByPrimaryKey(Long.valueOf(hsr.getParameter("forumPostsId")));
		return "redirect:/forumPosts/formPostList";
	}

}
