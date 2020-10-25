package com.zwy.space.model;

import com.zwy.base.model.BaseBusLongModel;
import lombok.Data;

/**
 * 类 名: Space
 * 描 述:
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public class Space extends BaseBusLongModel {
	/** 所属小区ID */
	private Long communityId;
	/** 车位使用状态：0-暂停租用、1-空闲、2-使用中 */
	private Integer useStatus;
	/** 车位审核状态：0-审核中、1-审核通过、2审核未通过 */
	private Integer checkStatus;
	/** 停车单价/每小时 */
	private Double price;
	/** 费用占比 */
	private Double percent;
	/** 车位编号 */
	private Integer no;
}
