package com.liyang.orchard.config.shiro;

import com.liyang.orchard.utils.TokenUtils;
import com.liyang.orchard.model.User;
import com.liyang.orchard.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

	/**
	 * 指定自定义的token实例
	 * @param authenticationToken token
	 * @return token
	 */
	@Override
	public boolean supports(AuthenticationToken authenticationToken) {
		// 指定当前 authenticationToken 需要为 ShiroAuthToken 的实例
		System.out.print("instanceof:");
		System.out.println(authenticationToken instanceof ShiroAuthToken);
		return authenticationToken instanceof ShiroAuthToken;
	}

	@Override
	@SuppressWarnings("unchecked")
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 根据用户手机号码获得用户权限信息
		List<SysUser> sysUser = userService.findUserAuthority(principals.toString());
//		System.out.println("phone：" + principals.toString());
		// 设定用户权限和角色
		Collection<String> userPermissions = new ArrayList<>();
		Collection<String> userRoles = new ArrayList<>();
		// 获得用户权限
		for (SysUser user : sysUser) {
			userPermissions.add(user.getUserPermission());
		}
		// 获得用户角色
		userRoles.add(sysUser.get(0).getUserRole());
//		System.out.println("userRoles:" + userRoles);
//		System.out.println("userPermission:" + userPermissions);
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
//		String token = (String) authcToken.getPrincipal();
//		TokenUtils tokenUtils = new TokenUtils();
//		SysUser sysUser = tokenUtils.validationToken(token);
//		if (sysUser == null) {
//			throw new AuthenticationException("Token 无效");
//		}
//		Object principal = sysUser.getUserId();
//		User user = userService.findById(sysUser.getUserId());
//		Object hashedCredentials = user.getPassword();

		String token = (String) authcToken.getPrincipal();
		SysUser sysUser = tokenUtils.validationToken(token);
		if (sysUser == null) {
			throw new AuthenticationException("Token 无效");
		}
		User user = userService.findById(sysUser.getUserId());
		Object phone = user.getPhone();

		// 固定盐值
		ByteSource salt = ByteSource.Util.bytes("orchard");
//		System.out.println("salt:" + salt);
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
//		return new SimpleAuthenticationInfo(principal, token, salt, getName());
//		return new SimpleAuthenticationInfo(principal, hashedCredentials, salt, getName());
		return new SimpleAuthenticationInfo(phone, token, salt, getName());
	}
}


