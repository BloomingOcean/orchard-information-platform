package com.liyang.orchard.config.shiro;

import com.alibaba.fastjson.JSONObject;
//import com.li.example.service.LoginService;
import com.liyang.orchard.utils.constants.Constants;
import com.liyang.orchard.model.User;
import com.liyang.orchard.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @description: 自定义Realm
 */
@Slf4j
@Service
public class UserRealm extends AuthorizingRealm {
	private Logger logger = LoggerFactory.getLogger(UserRealm.class);

	@Autowired
	private UserService userService;

	@Override
	@SuppressWarnings("unchecked")
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Session session = SecurityUtils.getSubject().getSession();
		//查询用户的权限
		JSONObject permission = (JSONObject) session.getAttribute(Constants.SESSION_USER_PERMISSION);
		logger.info("permission的值为:" + permission);
		logger.info("本用户权限为:" + permission.get("permissionList"));
		//为当前用户设置角色和权限
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addStringPermissions((Collection<String>) permission.get("permissionList"));
		return authorizationInfo;
	}

	/**
	 * 验证当前登录的Subject
	 * LoginRegisterController.login()方法中执行Subject.login()时 执行此方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		System.out.println("authcToken.getPrincipal:" + authcToken.getPrincipal());
		String phone = (String) authcToken.getPrincipal();
		// 获取电话和密码
//		String password = new String((char[]) authcToken.getCredentials());
		User user = userService.findByPhone(phone);
		if (user == null) {
			//没找到帐号
			throw new UnknownAccountException();
		}
		//session中不需要保存密码
		JSONObject info = new JSONObject();
		info.put("phone", user.getPhone());
		info.put("nikename", user.getNikename());
		//将用户信息放入session中
		SecurityUtils.getSubject().getSession().setAttribute(Constants.SESSION_USER_INFO, info);
		//交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
		//ByteSource.Util.bytes("salt"), salt=username+salt,采用明文访问时，不需要此句
		return new SimpleAuthenticationInfo(user.getPhone(),user.getPassword(),getName());
	}
}
