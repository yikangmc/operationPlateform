package com.yikang.web.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.yikang.common.utils.Constants;

public class ForceLogoutFilter extends AccessControlFilter{

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object arg2) throws Exception {
		Session session=getSubject(request, response).getSession(false);
		if(session == null){
			return true;
		}
		return session.getAttribute(Constants.SESSION_FORCE_LOGOUT_KEY)==null;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try{
			getSubject(request, response).logout();
		}catch(Exception e){
			
		}
		String loginUrl=getLoginUrl()+(getLoginUrl().contains("?") ? "&" : "?") + "forceLogout=1";
		WebUtils.issueRedirect(request, response, loginUrl);
		return false;
	}

}
