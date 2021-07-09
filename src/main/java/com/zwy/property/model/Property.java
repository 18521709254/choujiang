package com.zwy.property.model;

import com.zwy.base.model.BaseQuery;
import lombok.Data;

/**
 * 类 名: Property
 * 描 述: 物业实体
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public class Property extends BaseQuery<Property> {

	/** 物业名称 */
	private String name;
	/** 状态：0-审核中、1-审核通过、2-审核不通过 */
	private Integer status;
	/** 图片路径 */
	private String path;
	/** 平台占比 */
	private Double platformPercent;
	/** 物业占比 */
	private Double propertyPercent;
	/** 会员占比 */
	private Double memberPercent;

}
