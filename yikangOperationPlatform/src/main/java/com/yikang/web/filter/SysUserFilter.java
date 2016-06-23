package com.yikang.web.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.yikang.common.utils.Constants;
import com.yikang.protal.manager.UserManager;

public class SysUserFilter extends PathMatchingFilter {

	
	@Autowired
	private UserManager userManager;
	
	
	protected boolean onPreHandle(ServletRequest request,ServletResponse response,Object mappedValue){
		
		String username=(String)SecurityUtils.getSubject().getPrincipal();
		request.setAttribute(Constants.CURRENT_USER, userManager.getUserByLoginName(username));
		
		return true;
	}
	
	
}
