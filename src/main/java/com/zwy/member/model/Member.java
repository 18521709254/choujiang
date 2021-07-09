package com.zwy.member.model;

import com.zwy.base.model.BaseQuery;
import lombok.Data;

/**
 * 类 名: Member
 * 描 述: 会员
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public class Member extends BaseQuery<Member> {
	/** 账号 */
	private String account;
	/** 密码 */
	private String password;
	/** 名称 */
	private String name;
	/** 联系电话 */
	private String tel;
	/** 性别 */
	private Integer sex;
}
