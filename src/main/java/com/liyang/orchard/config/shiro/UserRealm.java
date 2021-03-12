package com.liyang.orchard.config.shiro;

import com.alibaba.fastjson.JSONObject;
//import com.li.example.service.LoginService;
import com.liyang.orchard.utils.TokenUtils;
import com.liyang.orchard.utils.constants.Constants;
import com.liyang.orchard.model.User;
import com.liyang.orchard.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @description: 自定义Realm
 */
@Slf4j
@Service
public class UserRealm extends AuthorizingRealm {
	private Logger logger = LoggerFactory.getLogger(UserRealm.class);

	@Autowired
	private UserService userService;

	@Resource
	TokenUtils tokenUtils;

//	/**
//	 * 指定自定义的token实例
//	 * @param authenticationToken token
//	 * @return token
//	 */
//	@Override
//	public boolean supports(AuthenticationToken authenticationToken) {
//		// 指定当前 authenticationToken 需要为 ShiroAuthToken 的实例
//		return authenticationToken instanceof ShiroAuthToken;
//	}

	@Override
	@SuppressWarnings("unchecked")
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 根据用户手机号码获得用户权限信息
		List<SysUser> sysUser = userService.findUserAuthority(principals.toString());
		System.out.println("principals.toString():" + principals.toString());
		Collection<String> userPermissions = new ArrayList<>();
		Collection<String> userRoles = new ArrayList<>();
		for (SysUser user : sysUser) {
			userPermissions.add(user.getUserPermission());
			userRoles.add(user.getUserRole());
		}
		System.out.println("userPermission:" + userPermissions);
		// 为当前用户设置角色和权限
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addStringPermissions(userPermissions);
		authorizationInfo.addRoles(userRoles);
		return authorizationInfo;
	}

	/**
	 * 验证当前登录的Subject
	 * LoginRegisterController.login()方法中执行Subject.login()时 执行此方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		String phone = (String) authcToken.getPrincipal();
		// 获取用户信息
		User user = userService.findByPhone(phone);
		if (user == null) {
			//没找到帐号
			throw new UnknownAccountException();
		}
		Object principal = user.getPhone();
		Object hashedCredentials = user.getPassword();
		// 固定盐值
		ByteSource salt = ByteSource.Util.bytes("orchard");
		System.out.println("salt:" + salt);
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
		return new SimpleAuthenticationInfo(principal, hashedCredentials, salt, getName());
	}
}


