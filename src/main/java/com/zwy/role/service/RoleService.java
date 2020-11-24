package com.zwy.role.service;
import com.zwy.role.model.Role;

import java.util.List;

/**
 * 类 名: RoleService
 * 描 述: 角色事物层
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
public interface RoleService {


	/**
	 * 描 述： 分页查询角色
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param role 角色
	 */
	List<Role> listRoleAll();

	/**
	 * 描 述： 分页查询角色
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param role 角色信息
	 */
	void listRoleByPage(Role role);

	/**
	 * 描 述： 根据ID查询橘色
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param roleId 角色ID
	 * @return 角色查询数据
	 */
	Role getRoleById(Long roleId);

	/**
	 * 描 述： 保存角色
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param role 角色
	 */
	void save(Role role);

	/**
	 * 描 述： 根据ID删除角色
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 角色ID数组
	 */
	void delByIds(Long[] ids);


}
