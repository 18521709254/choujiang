package com.zwy.base.model;

import com.zwy.user.model.User;
import lombok.Data;

/**
 * 类 名: ApiAccessToken
 * 描 述:
 * 作 者: 张文雅
 * 创 建：2020年10月30日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public class ApiAccessToken {
	/** 令牌 */
	private String token;
	/** 登陆用户 */
	private User user;

	/** 构造器 */
	public ApiAccessToken(String token, User user) {
		this.token = token;
		this.user = user;
	}
}
