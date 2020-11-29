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
 * 作 者: 宋凯翔
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
	/** 管理员菜单 */
	public static final List<Router> adminRouter = new ArrayList<>();
	/** 管理员菜单 */
	public static final List<Router> otherRouter = new ArrayList<>();
	static {
		// 管理员路由集合
		adminRouter.add(new Router("首页","/dashboard"));
		adminRouter.add(new Router("物业管理","/property/propertyList"));
		adminRouter.add(new Router("小区管理","/property/communityList"));
		adminRouter.add(new Router("用户管理","/property/userList"));
		adminRouter.add(new Router("角色管理","/property/roleList"));
		adminRouter.add(new Router("订单管理","/property/billList"));
		adminRouter.add(new Router("会员管理","/property/memberList"));
		adminRouter.add(new Router("车位管理","/property/spaceList"));
		adminRouter.add(new Router("公告管理","/property/placardList"));
		// 其他路由集合
		otherRouter.add(new Router("首页","/dashboard"));
		otherRouter.add(new Router("小区管理","/property/communityList"));
		otherRouter.add(new Router("车位管理","/property/spaceList"));
		otherRouter.add(new Router("订单管理","/property/billList"));
	}

}
