package com.zwy.user.model;

import com.zwy.base.model.BaseBusLongModel;
import com.zwy.base.model.BaseQuery;
import com.zwy.base.model.Router;
import lombok.Data;

import java.util.List;

/**
 * 类 名: User
 * 描 述:
 * 作 者: 宋凯翔
 * 创 建：2020年10月24日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public class User extends BaseQuery<User> {
	/** 账号 */
	private String account;
	/** 密码 */
	private String password;
	/** 名称 */
	private String name;
	/** 联系电话 */
	private String tel;
	/** 角色ID */
	private Long roleId;
	/** 角色名称 */
	private String roleName;
	/** 路由集合 */
	private List<Router> routerList;
}
