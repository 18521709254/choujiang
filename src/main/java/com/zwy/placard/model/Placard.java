package com.zwy.placard.model;

import com.zwy.base.model.BaseQuery;
import lombok.Data;

/**
 * 类 名: Placard
 * 描 述: 公告表
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public class Placard extends BaseQuery {
	/** 公告标题 */
	private String title;
	/** 公告内容 */
	private String content;
}
