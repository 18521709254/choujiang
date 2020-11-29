package com.zwy.user.service;
import com.zwy.user.model.User;

/**
 * 类 名: UserService
 * 描 述:
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
public interface UserService {


	/**
	 * 描 述： 分页查询用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户
	 */
	void listUserByPage(User user);

	/**
	 * 描 述： 根据账号密码查询用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户信息
	 */
	User getUserByUser(User user);

	/**
	 * 描 述： 根据ID获取用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param userId 用户ID
	 * @return 用户信息
	 */
	User getUserById(Long userId);

	/**
	 * 描 述： 保存用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户
	 */
	void save(User user);

	/**
	 * 描 述： 用户注册
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户
	 */
	void register(User user);

	/**
	 * 描 述： 根据ID删除用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 用户ID数组
	 */
	void delByIds(Long[] ids);

}
