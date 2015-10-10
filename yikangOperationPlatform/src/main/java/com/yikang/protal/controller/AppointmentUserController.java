package com.yikang.protal.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yikang.common.error.ExceptionConstants;
import com.yikang.common.message.SMSUtil;
import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.entity.AppointmentUser;
import com.yikang.protal.service.AppointmentUserService;

@Controller
public class AppointmentUserController{
	
	
	
	@Autowired
	private AppointmentUserService  appointmentUserService;
	
	
	
	
	@RequestMapping
	public String getAppointmentList(ModelMap modelMap, AppointmentUser appointmentUser,PageParameter page){
		
		modelMap.put("appointmentUser", appointmentUser);
		modelMap.put("page", page);
		List<AppointmentUser> data=appointmentUserService.getAppointmentUserListPage(modelMap);
		modelMap.put("data",data);
		
		return "shareUser/appointmentList";
	}

	
	@RequestMapping
	@ResponseBody
	public Map<String,Object> updateAppointment(AppointmentUser appointmentUser){
		
		Map<String,Object> rtnMap=new HashMap<String, Object>();
		if(null != appointmentUser){
			
		}
		
		return rtnMap;
		
	}
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/01 15:01
	 * @desc 保存注册用户
	 * 
	 * **/
	@RequestMapping
	@ResponseBody
	public Map<String, Object> regiestUser(ModelMap modelMap, String mobileNumber, String captcha, String userFromStr, HttpServletRequest request) {

		Map<String, Object> rtnData = new HashMap<String, Object>();
		String sesionCaptcha = null;
		if(null != request.getSession().getAttribute("captcha")){
				sesionCaptcha=request.getSession().getAttribute("captcha").toString();
			if (null != mobileNumber && null != captcha && null != sesionCaptcha) {
					if (captcha.equals(sesionCaptcha)) {
						int i=appointmentUserService.insertSelective(mobileNumber);
						if (i>0) {
							rtnData.put("status",ExceptionConstants.responseSuccess.responseSuccess.code);
							rtnData.put("message", "恭喜，您预约成功！稍等，我们有服务人员跟，您联系。谢谢！");
						} else {
							
							if(i==0){
								rtnData.put("status",ExceptionConstants.systemException.systemException.errorCode);
								rtnData.put("message", "预约失败！");
							}else if(i==-1){
								rtnData.put("status",ExceptionConstants.systemException.systemException.errorCode);
								rtnData.put("message", "您已经预约过服务了！");
							}

						}
	
					} else {
						rtnData.put("status",ExceptionConstants.systemException.systemException.errorCode);
						rtnData.put("message", "抱歉，你的验证码，输入错误!");
					}
			}else{
				rtnData.put("status",ExceptionConstants.systemException.systemException.errorCode);
				rtnData.put("message", "请输入手机号 或验证码  ！");
			}
		}else{
			rtnData.put("status",ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", "还未获取验证码 ！");
		}

		return rtnData;
	}

	/**
	 * @author liushuaic
	 * @date 2015/09/21 17：29
	 * @desc 跳转到预约页面
	 * **/
	@RequestMapping
	public String Appointment() {

		return "shareUser/appointment";
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/01 20:00
	 * @desc 获取验证码
	 * **/

	@RequestMapping
	@ResponseBody
	public Map<String, Object> getCaptcha(ModelMap modelMap,
			String mobileNumber, HttpServletRequest request) {

		
		Map<String, Object> rtnData = new HashMap<String, Object>();
		if(null != mobileNumber && mobileNumber.length()==11){
			
	
			Random random = new Random();
			int captcha = random.nextInt(99999);
			
			Date currentDate=Calendar.getInstance().getTime();
			Date getDate=(Date) request.getSession().getAttribute("getCaptchaDate");
			boolean isTure=false;
			if(null != getDate){
				   long diff = currentDate.getTime() - getDate.getTime();
				    long days = diff / (1000 * 60 );
				    if(days>1){
				    	isTure=true;
				    }
			}
			
			
			if(getDate==null || isTure){
				
				if(appointmentUserService.validateMobileIsAppointment(mobileNumber)){
					if (SMSUtil.sendMessage(mobileNumber, captcha + "", 1 + "")) {
						
						request.getSession().setAttribute("captcha", captcha);
						request.getSession().setAttribute("getCaptchaDate", currentDate);
						
						rtnData.put("status",  ExceptionConstants.responseSuccess.responseSuccess.code);
						rtnData.put("message", "您的验证码，已经发送！请注意，手机提醒！");
					} else {
						rtnData.put( "status", ExceptionConstants.systemException.systemException.errorCode);
						rtnData.put("message", "抱歉，验证码发送失败！请您联系服务人员！");
					}
				}else{
					rtnData.put( "status", ExceptionConstants.systemException.systemException.errorCode);
					rtnData.put("message", "您已经预约过了！");
				}
			}else{
				rtnData.put( "status", ExceptionConstants.systemException.systemException.errorCode);
				rtnData.put("message", "请1分钟后在获取！");
			}
		
		}else{
			rtnData.put( "status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", "请您输入正确的手机号！");
		}

		return rtnData;
	}
	
	
}
