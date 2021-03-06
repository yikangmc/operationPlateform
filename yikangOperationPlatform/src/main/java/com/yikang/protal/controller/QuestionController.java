package com.yikang.protal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
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
import com.yikang.protal.entity.Question;
import com.yikang.protal.entity.Taglib;
import com.yikang.protal.entity.User;
import com.yikang.protal.manager.UserManager;
import com.yikang.protal.service.QuestionService;
import com.yikang.protal.service.TaglibService;

/**
 * 问题管理系统
 * @author zxh
 *
 */
@Controller
public class QuestionController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	private QuestionService systemService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private TaglibService taglibService;
	
	@Autowired
	private UserManager userManager;
	
	@RequestMapping
	public String questionList(ModelMap modelMap,Question question,HttpServletRequest request,String userName,String reservation){
		modelMap.put("question", question);
		PageParameter page=this.initPage(request);
		modelMap.put("page", page);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		if(null==title || title.equals("")){
			title=null;
		}
		if(null==content || content.equals("")){
			content=null;
		}
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
		modelMap.put("title", title);
		modelMap.put("content", content);
		modelMap.put("userName", userName);
		modelMap.put("reservation", reservation);
		List<Question> allQuestions = systemService.queryAllQuestions(modelMap);
		modelMap.put("allQuestions", allQuestions);
		return "question/questionList";
	}
	
	
	@RequestMapping
	public String questionCreate(ModelMap modelMap,Question question,String userName){
		
		List<Taglib> taglibs=taglibService.getAllTag(null);
		modelMap.put("taglibs",taglibs);
		modelMap.put("userName", userName);
		return "question/questionCreate";
	}
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> questionSave(String userName,String title,Long[] taglibId,String content,String[] images){
		
		ResponseMessage<String> message=new ResponseMessage<String>();
		User user=userManager.getUserByLoginName(userName);
		if(null != user){
			Long userId=user.getUserId();
			systemService.insertQuestion(title, content, taglibId, userId, images);
		}else{
			message.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			message.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return message;
		
	}
	
	/**
	 * 添加回答的跳转页面
	 * @return
	 */
	@RequestMapping
	public String answerQuestion(ModelMap modelMap,HttpServletRequest req){
		log.debug("");
		String title = systemService.queryQuestionTitleById(req.getParameter("questionId"));
		modelMap.addAttribute("title",title);
		modelMap.addAttribute("questionId", req.getParameter("questionId"));
		modelMap.addAttribute("taglibsId",req.getParameter("taglibsId"));
		return "question/answerQuestion";
	}
	
	/**
	 * 保存回答
	 * @param userName
	 * @param content
	 * @param images
	 * @param req
	 * @return
	 */
	@RequestMapping
	public String addAnswer(ModelMap modeMap,String userName,String taglibsId,String content,String questionId,HttpServletRequest req){
		log.debug("");
//		Long userId = systemService.queryUserIdByUserName(userName);
		User user=userManager.getUserByLoginName(userName);
		String[] images = null;
		String contents = null;
		if(user!=null){
			if(null != content && content.length()>0){
				List<String> imageArray=MatchHtmlElementAttrValue.getImgSrc(content);
				String[] args={};
				images=imageArray.toArray(args.clone());
			}
			String htmlDetailContent=content;
			contents=content.replaceAll("<br>", "\n").replaceAll("&nbsp;", " ").replaceAll("&ldquo;", "");
			contents=MatchHtmlElementAttrValue.replaseAndCharachter(contents);
			String detailContent=MatchHtmlElementAttrValue.replaceAllHtmlTagContent(contents);

			String subContent=detailContent.replaceAll("\n","").replaceAll(" ","").replace("\r","");
			String contentStr=subContent.length()>100?subContent.substring(0,100):subContent;
			
			int result = systemService.saveAnswerOfQuestion(user.getUserId(),htmlDetailContent,detailContent,contentStr,images,questionId,taglibsId);
			if(result>0){
				modeMap.addAttribute("resultMessage", "添加回答成功！！！");
			}else{
				modeMap.addAttribute("resultMessage", "添加回答失败，请联系管理员！！！");
			}
		}else{
			modeMap.addAttribute("resultMessage", "此用户不存在，请再次确认！！！");
		}
		return "redirect:/question/questionList";
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-09-06 13:52
	 * @desc 删除问题
	 * */
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> deleteQuestion(Long questionId,String userName){
		
		 ResponseMessage<String> resMessage=new ResponseMessage<String>();
		 User user=userManager.getUserByLoginName(userName);
		 if(null != user){
			 questionService.deleteQuestionByQuestionId(questionId);
			 log.info("QuestionController-->deleteQuestion-->"+user.getUserName()+"删除问题 info");
			 resMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
			 resMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
		 }else{
			 resMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			 resMessage.setMessage("用户不存在！");
		 }
		 
		 return resMessage;
		
	}
	
}