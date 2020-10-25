package com.zwy.role.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * 描 述:
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
	 * @param role 角色
	 */
	@Override
	public List<Role> listRoleAll() {
		return roleDao.listRoleAll();
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
