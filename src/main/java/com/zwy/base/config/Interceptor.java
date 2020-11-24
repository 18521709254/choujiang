package com.zwy.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 类 名: Interceptor
 * 描 述: 拦截器
 * 作 者: 张文雅
 * 创 建：2020年10月30日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Configuration
public class Interceptor implements WebMvcConfigurer {
	/**
	 * 描 述： 宋凯翔请求支援拦截
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param registry 请求数据获取
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/upload/");
	}
}
