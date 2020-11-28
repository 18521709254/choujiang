package com.zwy.base.config;


import com.zwy.base.model.ApiAccessToken;
import java.util.HashMap;
import java.util.Map;

/**
 * 类 名: SystemConstant
 * 描 述: 系统固定配置
 * 作 者: 宋凯翔
 * 创 建：2020年10月30日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
public class SystemConstant {
	/** 构造器私有化 */
	private SystemConstant(){
	}

	/** 当前登录用户令牌 */
	public static final String CURRENT_API_ACCESS_TOKEN = "CURRENT_API_ACCESS_TOKEN";
	/** 当前登录用户令牌 */
	public static Map<String, ApiAccessToken> TOKEN_MAP = new HashMap<>();
}
