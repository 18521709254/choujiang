package com.zwy.property.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwy.property.service.PropertyService;
import com.zwy.property.dao.IPropertyDao;
import com.zwy.property.model.Property;
import com.zwy.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
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

	@Override
	public void listPropertyByPage(Property item) {
		PageInfo<Property> pageInfo = item.getPageInfo();
		// 设置分页属性
		Page<User> pageResult = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		// 设置总数
		pageInfo.setTotal(pageResult.getTotal());
		// 设置总页数
		pageInfo.setPages(pageResult.getPages());
		// 存放数据
		List<Property> resultList = propertyDao.listPropertyByPage(item);
		// 如果为空存放空数据
		if(resultList == null){
			resultList = Collections.emptyList();
		}
		pageInfo.setList(resultList);
	}

	/**
	 * 描 述： 查询全部物业
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
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
