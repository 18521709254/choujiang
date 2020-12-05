package com.zwy.base.config;


import com.zwy.base.model.ApiAccessToken;
import com.zwy.base.model.Router;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类 名: SystemConstant
 * 描 述: 系统固定配置
 * 作 者: 张文雅
 * 创 建：2020年10月30日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
public final class SystemConstant {
	/** 构造器私有化 */
	private SystemConstant(){
	}

	/** 当前登录用户令牌 */
	public static final String CURRENT_API_ACCESS_TOKEN = "CURRENT_API_ACCESS_TOKEN";
	/** 当前登录用户令牌 */
	public static Map<String, ApiAccessToken> TOKEN_MAP = new HashMap<>();
	/** 平台管理员菜单 */
	public static final List<Router> adminRouter = new ArrayList<>();
	/** 平台管理员菜单 */
	public static final List<Router> otherRouter = new ArrayList<>();
	static {
		// 平台管理员路由集合
		adminRouter.add(new Router("首页","/dashboard"));
		adminRouter.add(new Router("物业管理","/property/propertyList"));
		adminRouter.add(new Router("小区管理","/property/communityList"));
		adminRouter.add(new Router("用户管理","/property/userList"));
		adminRouter.add(new Router("公告管理","/property/placardList"));
		adminRouter.add(new Router("投诉管理","/property/complaintList"));
		// 其他路由集合
		otherRouter.add(new Router("首页","/dashboard"));
		otherRouter.add(new Router("小区管理","/property/communityList"));
		otherRouter.add(new Router("物业车位管理","/property/propertySpaceList"));
		otherRouter.add(new Router("私家车位管理","/property/memberSpaceList"));
		otherRouter.add(new Router("订单管理","/property/billList"));
	}

}
