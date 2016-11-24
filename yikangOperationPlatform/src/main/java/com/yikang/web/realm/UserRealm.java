package com.yikang.web.realm;


import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.yikang.protal.entity.User;
import com.yikang.protal.manager.UserManager;

import ytx.org.apache.http.auth.UsernamePasswordCredentials;


/**
 * @author liushuaic
 * @date 2016-03-10 10:51
 * @desc 用户安全校验类
 * 
 * **/
public class UserRealm  extends AuthorizingRealm{
	
	
	@Autowired
	private UserManager userManager;

	
	
	/**
	 * @author liushuaic
	 * @date 2016-03-10 10:54
	 * @desc 获取用户信息 ,设置权限
	 * **/
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		
		String loginName=(String)arg0.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		
		//User user=userManager.getUserByLoginName(loginName);
//		String[] strArray={"role","role1"};
		Set<String> rolesSet=new HashSet<String>();
		rolesSet.add("role");
		rolesSet.add("role2");
//		authorizationInfo.setRoles(rolesSet);
		authorizationInfo.setRoles(rolesSet);
		
		Set<String> stringPermissions=new HashSet<String>();
		stringPermissions.add("user:create");
		stringPermissions.add("user:delete");
		
		authorizationInfo.setStringPermissions(stringPermissions);
		return authorizationInfo;
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-03-10 11:00
	 * @desc 验证用户名与密码的正确性
	 * */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		
		String loginName=((UsernamePasswordToken)arg0).getUsername();
		User user=userManager.getUserByLoginName(loginName);
		if(null == user){
			throw new UnknownAccountException("未知用户");
		}
		if(user.isLocked()){
			throw new LockedAccountException("用户已经被锁定");
		}
		SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getLoginName(),user.getLoginPassword(),this.getName());
		return authenticationInfo;
	}

}
