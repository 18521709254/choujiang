package com.zwy.bill.model;

import com.zwy.base.model.BaseBusLongModel;
import lombok.Data;

import java.util.Date;

/**
 * 类 名: Bill
 * 描 述: 订单实体
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public class Bill extends BaseBusLongModel {

	/** 开始时间 */
	private Date startDate;
	/** 结束时间 */
	private Date endDate;
	/** 付费时间 */
	private Date payDate;
	/** 停车会员ID */
	private Long memberId;
	/** 车牌号 */
	private String carNo;
	/** 状态：0-未交费、1-已交费 */
	private Integer status;
	/** 车位ID */
	private Integer parkingSpaceId;
}
