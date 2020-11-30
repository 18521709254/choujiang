package com.zwy.base.config;

import com.zwy.base.model.ApiAccessToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类 名: Interceptor
 * 描 述: 拦截器
 * 作 者: 张文雅
 * 创 建：2020年11月27日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Slf4j
public class Interceptor implements HandlerInterceptor {

	/**
	 * 在请求处理之前进行调用（Controller方法调用之前）
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 获取请求来源和请求Token
		String accessToken = request.getHeader("Token");
		if (StringUtils.isBlank(accessToken)) {
			accessToken = (String) request.getAttribute("Token");
		}
		log.debug("获取到的请求Token：{}", accessToken);
		ApiAccessToken apiAccessToken = SystemConstant.TOKEN_MAP.get(accessToken);
		if(apiAccessToken == null || apiAccessToken.getUser() == null){
			log.debug("获取的Token未绑定用户:{}", accessToken);
			return false;
		}
		request.setAttribute(SystemConstant.CURRENT_API_ACCESS_TOKEN, apiAccessToken);
		return true;
	}

	/**
	 * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
