package com.yikang.protal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yikang.common.utils.MatchHtmlElementAttrValue;
import com.yikang.protal.entity.Taglib;
import com.yikang.protal.entity.User;
import com.yikang.protal.manager.UserManager;
import com.yikang.protal.service.ForumPostService;
import com.yikang.protal.service.TaglibService;

@Controller
public class ForumPostsController {
	
	@Autowired
	private ForumPostService forumPostService;
	
	
	@Autowired
	private TaglibService taglibService; 
	
	@Autowired
	private UserManager userManager;
	
	
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
	public String addForumPost(ModelMap modelMap,String userName,String title,String content,String[] images,Long[] taglibId,HttpServletRequest hsr){
		String contents=hsr.getParameter("content");
		User user=userManager.getUserByLoginName(userName);
		if(null != contents && contents.length()>0){
			List<String> imageArray=MatchHtmlElementAttrValue.getImgSrc(contents);
			String[] args={};
			images=imageArray.toArray(args.clone());
		}
		
		
		if(null != user && null != content  && content.length()>0 && null != images && images.length>0 && null != taglibId && taglibId.length>0){
			forumPostService.insertSelective(title,contents,user.getUserId(),images,taglibId);
		}
		modelMap.put("userName", userName);
		return "redirect:/forumPosts/forumPost";
	}
	
	

}
