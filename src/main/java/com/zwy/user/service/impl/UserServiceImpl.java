package com.zwy.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwy.property.dao.IPropertyDao;
import com.zwy.property.model.Property;
import com.zwy.property.service.PropertyService;
import com.zwy.user.dao.IUserDao;
import com.zwy.user.model.User;
import com.zwy.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 类 名: UserServiceImpl
 * 描 述:
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Slf4j
@Service("userServiceImpl")
@Transactional(value = "transactionManager",rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Resource(name = "userDaoImpl")
	private IUserDao userDao;
	@Resource(name = "propertyDaoImpl")
	private IPropertyDao propertyDao;

	/**
	 * 描 述： 分页查询用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户
	 */
	@Override
	public void listUserByPage(User user) {
		PageInfo<User> pageInfo = user.getPageInfo();
		// 设置分页属性
		Page<User> pageResult = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		// 设置总数
		pageInfo.setTotal(pageResult.getTotal());
		// 设置总页数
		pageInfo.setPages(pageResult.getPages());
		// 存放数据
		List<User> userList = userDao.listUserByPage(user);
		if(userList == null){
			userList = Collections.emptyList();
		}
		pageInfo.setList(userList);
	}

	/**
	 * 描 述： 用户登录
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 登录信息
	 */
	@Override
	public User getUserByUser(User user) {
		return userDao.getUserByUser(user);
	}

	/**
	 * 描 述： 根据ID获取用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param userId 用户ID
	 * @return 用户信息
	 */
	@Override
	public User getUserById(Long userId) {
		return userDao.getUserById(userId);
	}

	/**
	 * 描 述： 保存用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户
	 */
	@Override
	public void save(User user) {
		// ID 不存在新增
		if(user.getId() == null){
			userDao.add(user);
			return;
		}
		// 反之修改
		userDao.update(user);
	}

	/**
	 * 描 述： 用户注册
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户
	 */
	@Override
	public void register(User user) {
		//
		Property property = new Property();
		property.setName(user.getPropertyName());
		property.setStatus(0);
		propertyDao.add(property);
		user.setPropertyId(property.getId());
		userDao.add(user);
	}

	/**
	 * 描 述： 根据ID删除用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 用户ID数组
	 */
	@Override
	public void delByIds(Long[] ids) {
		userDao.delByIds(ids);
	}
}
