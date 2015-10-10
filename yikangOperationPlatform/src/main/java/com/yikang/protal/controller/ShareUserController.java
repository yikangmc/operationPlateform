package com.yikang.protal.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yikang.common.error.ExceptionConstants;
import com.yikang.common.message.SMSUtil;
import com.yikang.protal.service.ShareUserService;
import com.yikang.protal.service.UserService;

/**
 * 
 * @author liushuaic
 * @date 2015/09/01 14:51 分享用户
 * ***/
@Controller
public class ShareUserController {

	@Autowired
	private ShareUserService shareUserService;

	@Autowired
	private UserService userService;

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
	
//				Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
//				Matcher matcher = p.matcher(mobileNumber);
//				if (matcher.matches()) {
					if (captcha.equals(sesionCaptcha)) {
						if (shareUserService.saveShareUser(mobileNumber,userFromStr, request)) {
							rtnData.put("status",ExceptionConstants.responseSuccess.responseSuccess.code);
							rtnData.put("message", "恭喜，您领取成功！稍等，我们有服务人员跟，您联系。谢谢！");
						} else {
							rtnData.put("status",ExceptionConstants.systemException.systemException.errorCode);
							rtnData.put("message", "用户已经注册！");
						}
	
					} else {
						rtnData.put("status",ExceptionConstants.systemException.systemException.errorCode);
						rtnData.put("message", "抱歉，你的验证码，输入错误!");
					}
//				} else {
//					rtnData.put("status",ExceptionConstants.systemException.systemException.errorCode);
//					rtnData.put("message", "请输入正确的手机号！");
//				}
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
	 * @date 2015/09/01 19:57
	 * @desc 跳转到领取服务页面
	 * **/
	@RequestMapping(value = "/getFuWus")
	// @RequestMapping
	public String getFuWu(ModelMap modelMap, String userFromStr) {
		// public String getFuWu(ModelMap modelMap ){
		modelMap.put("userFromStr", userFromStr);

		return "shareUser/getYouHui";
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/18 23:01
	 * @desc 中秋活动页面
	 * 
	 * */
	@RequestMapping(value="/WeChartActivity")
	public String toWeChartActivity(ModelMap modelMap, String userFromStr){
		modelMap.put("userFromStr", userFromStr);
		return "shareUser/WeChatActivity";
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
			
	//		Pattern p = Pattern
	//				.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
	//		Matcher matcher = p.matcher(mobileNumber);
	//		if(!matcher.matches()){
	//			rtnData.put(
	//					"status",
	//					ExceptionConstants.systemException.systemException.errorCode);
	//			rtnData.put("message", "手机号输入不正确");
	//			return rtnData;
	//		}
			
			if(getDate==null || isTure){
				
				if(userService.validateMoblieNumber(mobileNumber)){
					if (SMSUtil.sendMessage(mobileNumber, captcha + "", 1 + "")) {
						
						request.getSession().setAttribute("captcha", captcha);
						request.getSession().setAttribute("getCaptchaDate", currentDate);
						
						rtnData.put("status",
								ExceptionConstants.responseSuccess.responseSuccess.code);
						rtnData.put("message", "您的验证码，已经发送！请注意，手机提醒！");
					} else {
						rtnData.put(
								"status",
								ExceptionConstants.systemException.systemException.errorCode);
						rtnData.put("message", "抱歉，验证码发送失败！请您联系服务人员！");
					}
				}else{
					rtnData.put(
							"status",
							ExceptionConstants.systemException.systemException.errorCode);
					rtnData.put("message", "用户已经领取！");
				}
			}else{
				rtnData.put(
						"status",
						ExceptionConstants.systemException.systemException.errorCode);
				rtnData.put("message", "请1分钟后在获取！");
			}
		
		}else{
			rtnData.put( "status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", "请输入正确的手机号！");
		}

		return rtnData;
	}

	/**
	 * @author liushuaic
	 * @date 2015/09/01 19：58 验证短信，校验码。
	 * **/
	@RequestMapping
	@ResponseBody
	public Map<String, Object> validateCaptcha(String captcha,
			HttpServletRequest request) {
		Map<String, Object> rtnData = new HashMap<String, Object>();

		String sesionCaptcha = request.getSession().getAttribute("captcha")
				.toString();
		if (captcha.equals(sesionCaptcha)) {
			rtnData.put("status",
					ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", "您的验证码，输入成功！");
		} else {
			rtnData.put(
					"status",
					ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", "抱歉，您的验证码，输入有问题");
		}
		return rtnData;
	}

	/**
	 * @author liushuaic
	 * @date 2015/09/02 15：07 验证手机验证码
	 * **/
	@RequestMapping
	@ResponseBody
	public Map<String, Object> validateMobileNumber(String mobileNumber) {

		Map<String, Object> rtnData = new HashMap<String, Object>();

		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher matcher = p.matcher(mobileNumber);

		if (matcher.matches()) {
			if (userService.validateMoblieNumber(mobileNumber)) {
				rtnData.put("status",
						ExceptionConstants.responseSuccess.responseSuccess.code);
			} else {
				rtnData.put(
						"status",
						ExceptionConstants.systemException.systemException.errorCode);
				rtnData.put("message", "手机号重复！");
			}
		} else {
			rtnData.put(
					"status",
					ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message", "手机号错误！");
		}

		return rtnData;

	}

}
