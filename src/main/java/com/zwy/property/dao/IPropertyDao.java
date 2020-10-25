package com.zwy.property.dao;

import com.zwy.property.model.Property;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类 名: IPropertyDao
 * 描 述: 物业数据访问层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Repository("propertyDaoImpl")
public interface IPropertyDao {

	/**
	 * 描 述： 查询全部角色
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 角色列表
	 */
	List<Property> listPropertyAll();

	/**
	 * 描 述： 新增物业
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param property 物业信息
	 */
	void add(Property property);

	/**
	 * 描 述： 修改物业
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param property 物业信息
	 */
	void update(Property property);

	/**
	 * 描 述： 删除物业
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 物业ID数组
	 */
	void delByIds(Long[] ids);
}
