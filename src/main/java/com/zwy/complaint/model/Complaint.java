package com.zwy.complaint.model;

import com.zwy.base.model.BaseQuery;
import lombok.Data;

/**
 * 类 名: Community
 * 描 述:
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public class Complaint extends BaseQuery<Complaint> {
	/** 会员ID */
	private Long memberId;
	/** 会员名称 */
	private String memberName;
	/** 物业ID */
	private Long propertyId;
	/** 物业名称 */
	private String propertyName;
	/** 投诉内容 */
	private String content;
	/** 投诉状态：0-未处理、1-已处理 */
	private Integer status;
	/** 投诉内容回复 */
	private String replayContent;
}
