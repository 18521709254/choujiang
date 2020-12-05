package com.zwy.user.model;

import com.zwy.property.model.Property;
import lombok.Data;

/**
 * 类 名: UserRegister
 * 描 述: 用户注册类
 * 作 者: 宋凯翔
 * 创 建：2020年12月05日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public class UserRegister {
	/** 用户信息 */
	private User user;
	/** 物业信息 */
	private Property property;
}
