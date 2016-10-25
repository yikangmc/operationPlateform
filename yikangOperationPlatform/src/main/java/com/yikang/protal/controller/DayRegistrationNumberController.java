package com.yikang.protal.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yikang.protal.base.BaseController;
import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.entity.Count;
import com.yikang.protal.entity.CountTaglib;
import com.yikang.protal.service.UserService;

@Controller
public class DayRegistrationNumberController extends BaseController{
	
	@Autowired
	private UserService userService;	
	/**
	 * 日注册数量
	 * @param modelMap
	 * @return
	 */
	@RequestMapping
	public String dayRegistrationNumber(Integer userFrom,ModelMap modelMap,PageParameter page,HttpServletRequest req){
		
		modelMap.put("page", page);
		String title=req.getParameter("title");
		String content = req.getParameter("content");
		String reservation = req.getParameter("reservation");
		//当前时间 和选中开始时间相差天数
		int start_between_days=0;
		//当前时间和选中结束时间相差天数
		int end_between_days=0; 
		//选中开始时间和选中结束时间之前的天数 
		int dayNum=31;
		if(null!=reservation&&!reservation.equals("")){
			String dates[] = reservation.split("-");
			String startTime = dates[0].trim().replace("/", "-");
			String endTime = dates[1].trim().replace("/", "-");
			Date  date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
			try {
				long startDate = simpleDateFormat.parse(startTime).getTime();
				long endDate = simpleDateFormat.parse(endTime).getTime();
				long nowDate = simpleDateFormat.parse(simpleDateFormat.format(date)).getTime();
				if(nowDate==endDate){//结束时间是当天
					//当前时间 和选中开始时间相差天数
					start_between_days=(int) ((nowDate-startDate)/(1000*3600*24));
					dayNum=start_between_days;
				}else{//结束时间不是当天
					//当前时间和选中结束时间相差天数
					end_between_days=(int) ((nowDate-endDate)/(1000*3600*24));
					//当前时间 和选中开始时间相差天数
					start_between_days=(int) ((nowDate-startDate)/(1000*3600*24));
					dayNum=(int) ((endDate-startDate)/(1000*3600*24));
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		modelMap.put("title", title);
		modelMap.put("reservation", reservation);
		modelMap.put("content", content);
		modelMap.put("userFrom", userFrom);
		System.out.println("日注册量"+userFrom);
		List<Count> UserNumber = userService.getSevenDayUserCount(userFrom,start_between_days,end_between_days,dayNum);
		modelMap.put("UserNumber", UserNumber);
		return "user/dayRegistrationNumber";
	}
	/**
	 * 当天每个标签下的发帖量，专家说量，回答量，问题量
	 * @param modelMap
	 * @return
	 */
	@RequestMapping
	public String dayCardNumber(ModelMap modelMap,PageParameter page,HttpServletRequest req){
		modelMap.put("page", page);
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		modelMap.put("title", title);
		modelMap.put("content", content);
		// 发帖量
		List<CountTaglib> CountTaglib1=userService.getDayCardCount();
		modelMap.put("CountTaglib1", CountTaglib1);
		// 专家说量
		List<CountTaglib> CountTaglib2=userService.getDayExpertCount();
		modelMap.put("CountTaglib2", CountTaglib2);
		// 回答量
		List<CountTaglib> CountTaglib3=userService.getDayAnswerCount();
		modelMap.put("CountTaglib3", CountTaglib3);
		// 问题量
		List<CountTaglib> CountTaglib4=userService.getDayQuestionCount();
		modelMap.put("CountTaglib4", CountTaglib4);
		
		return "user/dayCardNumber";
	}
}
