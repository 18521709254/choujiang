package com.zwy.property.service;

import com.zwy.property.model.Property;
import com.zwy.user.model.User;

import java.util.List;

/**
 * 类 名: PropertyService
 * 描 述:
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
public interface PropertyService {

	/**
	 * 描 述： 分页查询物业
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param item 物业
	 */
	void listPropertyByPage(Property item);

	/**
	 * 描 述： 查询全部物业
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 当前用户
	 */
	List<Property> listPropertyAll(User user);


	/**
	 * 描 述： 根据ID查询物业
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param propertyId 物业ID
	 * @return 物业查询数据
	 */
	Property getPropertyById(Long propertyId);

	/**
	 * 描 述： 保存物业
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param property 物业
	 */
	void save(Property property);

	/**
	 * 描 述： 根据ID删除物业
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 物业ID数组
	 */
	void delByIds(Long[] ids);

}
