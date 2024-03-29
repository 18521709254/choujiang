package com.zwy.user.model;

import com.zwy.base.model.BaseQuery;
import com.zwy.base.model.Router;
import com.zwy.placard.model.Placard;
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
	/** 物业ID */
	private Long propertyId;
	/** 物业名称 */
	private String propertyName;
	/** 状态：0-审核中、1-审核通过、2-审核不通过 */
	private Integer propertyStatus;
	/** 路由集合 */
	private List<Router> routerList;
	/** 公告集合 */
	private List<Placard> placardList;
}
