package com.zwy.role.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwy.property.model.Property;
import com.zwy.role.dao.IRoleDao;
import com.zwy.role.model.Role;
import com.zwy.role.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 类 名: RoleServiceImpl
 * 描 述: 角色事物实现
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Slf4j
@Service("roleServiceImpl")
@Transactional(value = "transactionManager",rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

	@Resource(name = "roleDaoImpl")
	private IRoleDao roleDao;

	/**
	 * 描 述： 分页查询角色
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 */
	@Override
	public List<Role> listRoleAll() {
		return roleDao.listRoleAll();
	}

	/**
	 * 描 述： 分页查询角色
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param item 角色信息
	 */
	@Override
	public void listRoleByPage(Role item) {
		PageInfo<Role> pageInfo = item.getPageInfo();
		// 设置分页属性
		Page<Role> pageResult = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		// 存放数据
		List<Role> resultList = roleDao.listRoleByPage(item);
		// 如果为空存放空数据
		if(resultList == null){
			resultList = Collections.emptyList();
		}
		// 设置总数
		pageInfo.setTotal(pageResult.getTotal());
		// 设置总页数
		pageInfo.setPages(pageResult.getPages());
		pageInfo.setList(resultList);
	}

	/**
	 * 描 述： 根据ID查询橘色
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param roleId 角色ID
	 * @return 角色查询数据
	 */
	@Override
	public Role getRoleById(Long roleId) {
		return roleDao.getRoleById(roleId);
	}

	/**
	 * 描 述： 保存角色
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param role 角色
	 */
	@Override
	public void save(Role role) {
		// ID 不存在新增
		if(role.getId() == null){
			roleDao.add(role);
			return;
		}
		// 反之修改
		roleDao.update(role);
	}

	/**
	 * 描 述： 根据ID删除角色
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 角色ID数组
	 */
	@Override
	public void delByIds(Long[] ids) {
		roleDao.delByIds(ids);
	}
}
