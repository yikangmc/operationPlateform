package com.yikang.protal.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.common.response.ResponseMessage;
import com.yikang.protal.entity.QuestionAnswer;
import com.yikang.protal.service.QuestionAnswerService;

@Controller
public class QuestionAnswerController{

	
	@Autowired
	private QuestionAnswerService questionAnswerService;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-08-12 15:52
	 * @desc 获取回复列表
	 * */
	@RequestMapping
	public String questionAnswerList(ModelMap modelMap, String questionTitle,String questionAnswerTitle,Long answerId,Date answerStartDateTime,Date answerEndTime,PageParameter page,HttpServletRequest hsr,Integer isRecommend,String userName,String reservation){
		String firstTime = null;
		String lastTime = null;
		if (null != reservation && (!(reservation.equals("")))) {
			String[] time = reservation.split("-");
			String[] first = time[0].split("/");
			String[] last = time[time.length - 1].split("/");

			 firstTime = first[first.length - 1].trim() + "-" + first[0].trim() + "-"
					+ first[first.length - 2].trim() + " 00:00:00";
			 lastTime = last[last.length - 1].trim() + "-" + last[0].trim() + "-"
					+ last[last.length - 2].trim() + " 23:59:59";
	}
		List<QuestionAnswer> data=questionAnswerService.getQuestionAnswerListPage(isRecommend,questionTitle, questionAnswerTitle, answerId, answerStartDateTime, answerEndTime,page,userName,firstTime,lastTime);
		
		modelMap.put("userName", userName);
		modelMap.put("reservation", reservation);
		modelMap.put("data", data);
		modelMap.put("page", page);
		modelMap.put("questionTitle", questionTitle);
		modelMap.put("questionAnswerTitle", questionAnswerTitle);
		modelMap.put("isRecommend", isRecommend);
		return "questionAnswer/questionAnswerList";
	}
	/**
	 * 更新该回答为精华
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> isEssenceQuestionAnswer(HttpServletRequest hsr){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		questionAnswerService.updateIssenceAnswerByPrimaryKey(Long.valueOf(hsr.getParameter("questionAnswerId")));
		return resData;
	}
	/**
	 * 取消该精华回答为普通
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public ResponseMessage<String> cancelEssenceQuestionAnswer(HttpServletRequest hsr){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		questionAnswerService.cancelIssenceAnswerByPrimaryKey(Long.valueOf(hsr.getParameter("questionAnswerId")));
		return resData;
	}
	/**
	 * 删除帖子回答
	 * @param hsr
	 * @return
	 */
	@RequestMapping
	public String deleteQuestionAnswer(HttpServletRequest hsr){
		int result = questionAnswerService.deleteQuestionAnswer(Long.valueOf(hsr.getParameter("questionAnswerId")));
		return "redirect:/questionAnswer/questionAnswerList";
	}
	
	
}
