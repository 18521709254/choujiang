package com.zwy.community.model;

import com.zwy.base.model.BaseBusLongModel;
import lombok.Data;

/**
 * 类 名: Community
 * 描 述:
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public class Community extends BaseBusLongModel {
	/** 小区名称 */
	private String name;
	/** 小区地址 */
	private String address;
	/** 小区车位平面图路径 */
	private String path;
	/** 状态：0-审核中、1-审核通过、2-审核不通过 */
	private Integer status;
	/** 所属物业ID */
	private Long propertyId;
}
