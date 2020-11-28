package com.zwy.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 类 名: MvcConfigurer
 * 描 述: SpringMVC配置类
 * 作 者: 宋凯翔
 * 创 建：2020年10月30日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
	/**
	 * 描 述： 静态资源映射
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param registry 请求数据获取
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/upload/");
	}

	/**
	 * 描 述： 请求拦截
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param registry 请求数据获取
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 拦截全部api请求除了登陆接口
		registry.addInterceptor(new Interceptor()).excludePathPatterns("/api/user/login");
	}
}
