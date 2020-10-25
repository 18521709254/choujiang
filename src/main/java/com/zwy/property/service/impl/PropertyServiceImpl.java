package com.zwy.property.service.impl;

import com.zwy.property.service.PropertyService;
import com.zwy.property.dao.IPropertyDao;
import com.zwy.property.model.Property;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类 名: PropertyServiceImpl
 * 描 述: 物业事物层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Slf4j
@Service("propertyServiceImpl")
@Transactional(value = "transactionManager",rollbackFor = Exception.class)
public class PropertyServiceImpl implements PropertyService {

	@Resource(name = "propertyDaoImpl")
	private IPropertyDao propertyDao;

	/**
	 * 描 述： 分页查询角色
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param property 角色
	 */
	@Override
	public List<Property> listPropertyAll() {
		return propertyDao.listPropertyAll();
	}

	/**
	 * 描 述： 保存角色
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param property 角色
	 */
	@Override
	public void save(Property property) {
		// ID 不存在新增
		if(property.getId() == null){
			propertyDao.add(property);
			return;
		}
		// 反之修改
		propertyDao.update(property);
	}

	/**
	 * 描 述： 根据ID删除角色
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 角色ID数组
	 */
	@Override
	public void delByIds(Long[] ids) {
		propertyDao.delByIds(ids);
	}
}
