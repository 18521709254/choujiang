package com.zwy.role.dao;

import com.zwy.role.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类 名: IRoleDao
 * 描 述: 角色控制层
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Repository("roleDaoImpl")
public interface IRoleDao {

	/**
	 * 描 述： 查询全部角色
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @return 角色列表
	 */
	List<Role> listRoleAll();

	/**
	 * 描 述： 分页查询角色
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param item 角色信息
	 */
	List<Role> listRoleByPage(Role item);

	/**
	 * 描 述： 根据ID查询橘色
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param roleId 角色ID
	 * @return 角色查询数据
	 */
	Role getRoleById(Long roleId);

	/**
	 * 描 述： 新增用户
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户信息
	 */
	void add(Role user);

	/**
	 * 描 述： 修改用户
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户信息
	 */
	void update(Role user);

	/**
	 * 描 述： 删除用户
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 用户ID数组
	 */
	void delByIds(Long[] ids);

}
