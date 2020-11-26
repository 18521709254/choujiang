package com.zwy.community.dao;

import com.zwy.community.model.Community;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类 名: ICommunityDao
 * 描 述: 小区控制层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Repository("communityDaoImpl")
public interface ICommunityDao {

	/**
	 * 描 述： 查询全部小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 小区列表
	 */
	List<Community> listCommunityAll();

	/**
	 * 描 述： 分页查询小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param item 小区
	 */
	List<Community> listPropertyByPage(Community item);

	/**
	 * 描 述： 根据物业ID查询小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param propertyId 物业ID
	 * @return 小区查询数据
	 */
	List<Community> listCommunityByPropertyId(Long propertyId);

	/**
	 * 描 述： 根据ID查询小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param id 小区ID
	 * @return 小区数据
	 */
	Community getCommunityById(Long id);

	/**
	 * 描 述： 新增用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户信息
	 */
	void add(Community user);

	/**
	 * 描 述： 修改用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户信息
	 */
	void update(Community user);

	/**
	 * 描 述： 删除用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 用户ID数组
	 */
	void delByIds(Long[] ids);


}
