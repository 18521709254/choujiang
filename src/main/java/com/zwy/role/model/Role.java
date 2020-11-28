package com.zwy.role.model;

import com.zwy.base.model.BaseQuery;
import lombok.Data;

/**
 * 类 名: Role
 * 描 述:
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public class Role extends BaseQuery<Role> {
	/** 角色名称 */
	private String name;
}
