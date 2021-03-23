package com.liyang.orchard.config.shiro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.core.constants.ErrorEnum;
import com.liyang.orchard.utils.TokenUtils;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description: 对没有登录的请求进行拦截, 全部返回json信息. 覆盖掉shiro原本的跳转login.jsp的拦截方式
 */
//public class AjaxPermissionsAuthorizationFilter extends FormAuthenticationFilter {
public class ShiroAuthFilter extends BasicHttpAuthenticationFilter {

	/**
	 * 存储Token的 Headers Key
	 */
	protected static final String AUTHORIZATION_HEADER = "Authorization";

	/**
	 * Token 的开头部分
	 */
	protected static final String BEARER = "Bearer ";

	/**
	 * Token 为空
	 */
	protected static final String TOKEN_NULL = "null_token";

	/**
	 * token
	 */
	private String token;

	/**
	 * 封装shiro的登录操作
	 * @param request request
	 * @param response response
	 * @return true为登录成功
	 */
	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) {
		// 设置 主题
		// 自动调用 ShiroRealm 进行 Token 检查
		/**
		 * 登录问题（可能是token格式问题，debug试试）
		 */
		this.getSubject(request, response).login(new ShiroAuthToken(this.token.substring(BEARER.length())));
		// 生成token
//		UsernamePasswordToken currentToken = new UsernamePasswordToken("1234", "1234");
//		System.out.println("自建固定currentToken登录");
//		this.getSubject(request, response).login(currentToken);
		return true;
	}

	/** Token 预处理，从 Request 的 Header 取得 Token
	 * @param request ServletRequest
	 * @return token or null
	 */
	@Override
	protected String getAuthzHeader(ServletRequest request) {
		try {
			// header 是否存在 Token
			HttpServletRequest httpRequest = WebUtils.toHttp(request);
			this.token = httpRequest.getHeader(AUTHORIZATION_HEADER).substring(BEARER.length());
			return this.token;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 登录失败 返回未授权访问(token)
	 * 登录成功 Header添加Token返回
	 * @param response Response
	 * @param refresh  是否刷新 Token(true: 在Header重新设置token)
	 */
	private void shiroAuthResponse(ServletResponse response, boolean refresh) {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		if (refresh) {
			// 刷新 Token，设置返回的头部
			httpServletResponse.setStatus(HttpServletResponse.SC_OK);
			httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
			httpServletResponse.addHeader(AUTHORIZATION_HEADER, this.token);
		} else {
			// 设置 HTTP 状态码为 401
			httpServletResponse.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
			// 设置 Json 格式返回
			httpServletResponse.setContentType("application/json;charset=UTF-8");
			try {
				// PrintWriter 输出 Response 返回信息
				PrintWriter writer = httpServletResponse.getWriter();
				ObjectMapper mapper = new ObjectMapper();
				Result failResult = ResultGenerator.genFailResult(ErrorEnum.E_20011.getErrorMsg());
				// 将对象输出为 JSON 格式
				writer.write(mapper.writeValueAsString(failResult));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**  是否允许访问
	 * @param request     Request
	 * @param response    Response
	 * @param mappedValue mapperValue
	 * @return true 表示允许放行
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		if (this.getAuthzHeader(request) != null) {
			try {
				System.out.println("executeLogin");
				/**
				 * 拦截用户操作，需要登录么（试试shiro的rememberMe）
				 * 需要！！如果不登录，shiro获取不到用户的Subject
				 */
				executeLogin(request, response);
				// (能正常登录)刷新 Token 1, Token 未过期，每次都调用 refreshToken 判断是否需要刷新 Token
				TokenUtils tokenUtils = new TokenUtils();
				System.out.println("refreshToken1");
				String refreshToken = tokenUtils.refreshToken(this.token);
				// 如果refreshToken不为null, 则表示刷新token成功
				if (refreshToken != null) {
					System.out.println("已刷新token");
					this.token = refreshToken;
					// 把新token放入response
					shiroAuthResponse(response, true);
				}
				/**
				 * 实现token为null的返回
				 */
//				else if (refreshToken.equals(TOKEN_NULL)) {
//					shiroAuthResponse(response, true);
//				}
				return true;
			} catch (Exception e) {
				// (executeLogin登录失败)刷新 Token 2, Token 已经过期，如果过期是在规定时间内则刷新 Token
				TokenUtils tokenUtils = new TokenUtils();
				// token已经过期了，刷新token
				System.out.println("refreshToken2");
				String refreshToken = tokenUtils.refreshToken(this.token);
				if (refreshToken != null) {
					this.token = refreshToken.substring(BEARER.length());
					// 重新调用 executeLogin 授权
					executeLogin(request, response);
					shiroAuthResponse(response, true);
					return true;
				} else {
					System.out.println("Token 刷新失败（1、时间还剩不止1分钟 2、时间过期10分钟）");
					// Token 刷新失败没得救或者非法 Token
					shiroAuthResponse(response, false);
					return false;
				}
			}
		} else {
			System.out.println("Token 不存在");
			// Token 不存在，返回未授权信息
			shiroAuthResponse(response, false);
			return false;
		}
	}

	@Bean
	public FilterRegistrationBean registration(ShiroAuthFilter filter) {
		FilterRegistrationBean registration = new FilterRegistrationBean(filter);
		registration.setEnabled(false);
		return registration;
	}



}
