package com.zwy.base.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 类 名: BaseBusLongModel
 * 描 述: 基类
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public abstract class BaseBusLongModel implements Serializable {
	/** 自增长类型 */
	private Long id;
}
