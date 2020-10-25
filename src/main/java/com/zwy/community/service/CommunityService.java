package com.zwy.community.service;
import com.zwy.community.model.Community;

import java.util.List;

/**
 * 类 名: CommunityService
 * 描 述: 小区事物层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
public interface CommunityService {


	/**
	 * 描 述： 分页查询小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param community 小区
	 */
	List<Community> listCommunityAll();

	/**
	 * 描 述： 保存小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param community 小区
	 */
	void save(Community community);

	/**
	 * 描 述： 根据ID删除小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 小区ID数组
	 */
	void delByIds(Long[] ids);
}
