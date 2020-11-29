package com.zwy.user.dao;

import com.zwy.user.model.User;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 类 名: UserDao
 * 描 述:
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Repository("userDaoImpl")
public interface IUserDao {


	/**
	 * 描 述： 分页查询用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户信息
	 * @return 数据集合
	 */
	List<User> listUserByPage(User user);

	/**
	 * 描 述： 根据账号密码查询用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户信息
	 * @return 用户信息
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
	 * 描 述： 根据账号查询用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param account 账号
	 * @return 用户信息
	 */
	User getUserByAccout(String account);


	/**
	 * 描 述： 新增用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户信息
	 */
	void add(User user);

	/**
	 * 描 述： 修改用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户信息
	 */
	void update(User user);

	/**
	 * 描 述： 删除用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 用户ID数组
	 */
	void delByIds(Long[] ids);


}
