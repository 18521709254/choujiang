package com.zwy.property.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zwy.base.model.BaseQuery;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

/**
 * 类 名: Property
 * 描 述: 物业实体
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public class Property extends BaseQuery<Property> {

	/** 物业名称 */
	private String name;
	/** 法人代表 */
	private String legalPerson;
	/** 资质等级 */
	private String level;
	/** 资质证书号 */
	private String cardNo;
	/** 准予时间 */
	private LocalDate grantTime;
	/** 联系人 */
	private String contactName;
	/** 电话 */
	private String tel;
	/** 托管面积 */
	private String area;
	/** 状态：0-审核中、1-审核通过、2-审核不通过 */
	private Integer status;
}
