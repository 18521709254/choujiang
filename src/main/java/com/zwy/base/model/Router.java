package com.zwy.base.model;

import lombok.Data;

/**
 * 类 名: Router
 * 描 述:
 * 作 者: 宋凯翔
 * 创 建：2020年11月28日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public class Router {
	/** 菜单名称 */
	public String menuName;
	/** 地址 */
	public String url;

	/** 构造器 */
	public Router(String menuName, String url) {
		this.menuName = menuName;
		this.url = url;
	}
}
