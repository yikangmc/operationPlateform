package com.yikang.protal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yikang.common.error.ExceptionConstants;
import com.yikang.common.utils.MatchHtmlElementAttrValue;
import com.yikang.protal.base.BaseController;
import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.common.response.ResponseMessage;
import com.yikang.protal.common.utils.operationmessage.OperationMessage;
import com.yikang.protal.common.utils.operationmessage.OperationMessageQueue;
import com.yikang.protal.entity.FormPosts;
import com.yikang.protal.entity.Taglib;
import com.yikang.protal.entity.User;
import com.yikang.protal.manager.IntegralManager;
import com.yikang.protal.manager.UserManager;
import com.yikang.protal.service.ForumPostService;
import com.yikang.protal.service.TaglibService;

@Controller
public class ForumPostsController extends BaseController {
	
	@Autowired
	private ForumPostService forumPostService;
	
	
	@Autowired
	private TaglibService taglibService; 
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private IntegralManager integralManager;
	
	/**
	 * 文章列表
	 * @param modelMap
	 * @return
	 */
	@RequestMapping
	public String formPostList(Integer isEssence,Integer dataStatus,ModelMap modelMap,
			PageParameter page,HttpServletRequest req,
			String content,String title,String reservation,String userName){
		modelMap.put("page", page);
		
		// 10/24/2016 - 10/24/2016
		if (null != reservation && (!(reservation.equals("")))) {

				String[] time = reservation.split("-");
				String[] first = time[0].split("/");
				String[] last = time[time.length - 1].split("/");

				String firstTime = first[first.length - 1].trim() + "-" + first[0].trim() + "-"
						+ first[first.length - 2].trim() + " 00:00:00";
				String lastTime = last[last.length - 1].trim() + "-" + last[0].trim() + "-"
						+ last[last.length - 2].trim() + " 23:59:59";
				modelMap.put("firstTime", firstTime);
				modelMap.put("lastTime", lastTime);
		}
		
		if (null == dataStatus || dataStatus.equals("")) {
			dataStatus = 1;
		}else if (null !=  dataStatus && dataStatus == 4) {
			dataStatus = null;
		}
		
		
		modelMap.put("title", title);
		modelMap.put("content", content);
		modelMap.put("isEssence", isEssence);
		modelMap.put("userName", userName);
		modelMap.put("dataStatus", dataStatus);
		modelMap.put("reservation", reservation);
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
	
	/**
	 * 发布文章
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
		long  forumPostId = 0;
		//if(null != user && null != content && null != recommendPicUrl  && content.length()>0 && null != images && images.length>0 && null != taglibId && taglibId.length>0){
		if(null != user && null != content && null != recommendPicUrl  && content.length()>0  && null != taglibId && taglibId.length>0){
			 forumPostId = forumPostService.insertSelective(title,subContent,forumPostDetailContent,forumPostHtmlDetailContent,recommendPicUrl,user.getUserId(),images,taglibId);
			for(Long id:taglibId){
				taglibService.updateForumPostsTZNumberAddByTaglibId(id);
			}
		}
		modelMap.put("userName", userName);
		//==============================================================================
		modelMap.put("title", title);
		modelMap.put("content", content);
		modelMap.put("recommendPicUrl", recommendPicUrl);
		modelMap.put("taglibId", taglibId);
		modelMap.put("images", images);
		modelMap.put("forumPostId", forumPostId+"");
		modelMap.put("test", "test");
//		return "redirect:/forumPosts/forumPost";
		List<Taglib> data=taglibService.getSecondAllTaglib();
		List<Taglib> data2=taglibService.getAllTag(null);
		modelMap.put("taglibs", data);
		modelMap.put("taglibs2", data2);
		String forumPostsId ;
		forumPostsId =  (String) modelMap.get("forumPostId");		
		FormPosts formPosts = forumPostService.findForumPostsInfo(Long.valueOf(forumPostsId));
		List<Long> taglibList = forumPostService.queryFormPostsTaglibsByFormPostsId(Long.valueOf(forumPostsId));
		modelMap.addAttribute("taglibList", taglibList);
		modelMap.addAttribute("forumPosts", formPosts);
		return "forumPost/updateForumPostsStudent";
		//==============================================================================
		
	}
	
	@RequestMapping
	public String updateForumPosts(ModelMap modelMap,HttpServletRequest req){
		List<Taglib> data=taglibService.getSecondAllTaglib();
		List<Taglib> data2=taglibService.getAllTag(null);
		modelMap.put("taglibs", data);
		modelMap.put("taglibs2", data2);
		String forumPostsId ;
		if (modelMap.get("test") != null) {
			forumPostsId = (String) modelMap.get("forumPostId");
		} else {
			forumPostsId = req.getParameter("forumPostsId");
		}
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
	@ResponseBody
	public ResponseMessage<String> updateForumPostsData(ModelMap modelMap,String forumPostId,String userName,String title,String content,String recommendPicUrl,String[] images,Long[] taglibId,HttpServletRequest hsr){
		ResponseMessage<String> resData=new ResponseMessage<String>();
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
		String contentStr=subContent.length()>100?subContent.substring(0,100):subContent;
		if(null != user && null != content && content.length()>0 && null != taglibId && taglibId.length>0){
			forumPostService.updateSelective(title,forumPostId,contentStr,forumPostDetailContent,forumPostHtmlDetailContent,recommendPicUrl,user.getUserId(),images,taglibId);
		}
		modelMap.put("userName", userName);
//		return "redirect:/forumPosts/formPostList";
//		resData.setData(shareUrl);
		return resData;
	}
	
	/**
	 * 更新该文章为精华
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> isEssenceForumPosts(HttpServletRequest hsr){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		forumPostService.updateIssenceByPrimaryKey(Long.valueOf(hsr.getParameter("forumPostsId")));
		return resData;
	}
	/**
	 * 取消该精华文章
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> cancelEssenceForumPosts(HttpServletRequest hsr){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		forumPostService.cancelIssenceByPrimaryKey(Long.valueOf(hsr.getParameter("forumPostsId")));
		return resData;
	}
	/**
	 * 删除文章
	 * @param hsr
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> deleteFormPost(HttpServletRequest hsr){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		try{
			forumPostService.deleteByPrimaryKey(Long.valueOf(hsr.getParameter("forumPostsId")));
		}catch(Exception e){e.printStackTrace();
		   resData.setStatus(ExceptionConstants.systemException.systemException.errorCode);
		   resData.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}
		return resData;
	}
	
	/**
	 * 审核通过该文章
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> okStatusFormPost(HttpServletRequest hsr){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		forumPostService.okStatusByPrimaryKey(Long.valueOf(hsr.getParameter("forumPostsId")));
		//***********************************************************
//		try{
//			OperationMessage operationMessage=new OperationMessage();
//			operationMessage.setContent(String.valueOf(hsr.getParameter("forumPostsId")));
////			operationMessage.setContentType("1"+"");
//			OperationMessageQueue.putMessage(operationMessage);
//		}catch(Exception e){
//			e.printStackTrace();
//		}

		integralManager.insertIntegralAddScoreIsUsualJob("FBZJS", Byte.valueOf("2"), Long.valueOf(hsr.getParameter("createUserId")));
		

		//***********************************************************

		return resData;
	}
	/**
	 * 审核不通过该文章
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> noStatusFormPost(HttpServletRequest hsr){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		forumPostService.noStatusByPrimaryKey(Long.valueOf(hsr.getParameter("forumPostsId")));
		return resData;
	}
}
