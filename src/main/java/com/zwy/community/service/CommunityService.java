package com.zwy.community.service;
import com.zwy.community.model.Community;
import com.zwy.user.model.User;

import java.util.List;

/**
 * 类 名: CommunityService
 * 描 述: 小区事物层
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
public interface CommunityService {


	/**
	 * 描 述： 查询全部小区
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @return 小区集合
	 * @param user 当前用户
	 */
	List<Community> listCommunityAll(User user);

	/**
	 * 描 述： 分页查询小区
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param community 小区
	 * @param user 当前用户
	 */
	void listCommunityByPage(Community community, User user);

	/**
	 * 描 述： 根据物业ID查询小区
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param propertyId 物业ID
	 * @param user 当前用户
	 * @return 小区查询数据
	 */
	List<Community> listCommunityByPropertyId(Long propertyId, User user);

	/**
	 * 描 述： 根据ID查询小区
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param communityId 小区ID
	 * @return 小区数据
	 */
	Community getCommunityById(Long communityId);


	/**
	 * 描 述： 保存小区
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param community 小区
	 */
	void save(Community community);

	/**
	 * 描 述： 根据ID删除小区
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 小区ID数组
	 */
	void delByIds(Long[] ids);


}
