package com.yikang.web.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.yikang.protal.entity.UserInfo;
import com.yikang.protal.service.UserService;

public class FKFormAuthenticationFilter extends FormAuthenticationFilter {

	@Autowired
	private UserService userService;
	
	
	/**
	 * @author liushuaic
	 * @date 2016/11/15 09:58
	 * @desc 登陆成功后回调
	 * */
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		String loginName=(String)SecurityUtils.getSubject().getPrincipal();
		UserInfo userInfo=userService.getUserInfoByLoginName(loginName);
		subject.getSession().setAttribute("user", userInfo);
		return super.onLoginSuccess(token, subject, request, response);
	}
	
}
