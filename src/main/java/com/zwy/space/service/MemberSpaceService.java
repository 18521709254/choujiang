package com.zwy.space.service;
import com.zwy.space.model.MemberSpace;
import com.zwy.user.model.User;

import java.util.List;

/**
 * 类 名: SpaceService
 * 描 述: 车位事物层
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
public interface MemberSpaceService {


	/**
	 * 描 述： 分页查询车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 */
	List<MemberSpace> listMemberSpaceAll();

	/**
	 * 描 述： 分页查询停车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param space 车位数据
	 * @param user 当前登录用户
	 */
	void listMemberSpaceByPage(MemberSpace space, User user);

	/**
	 * 描 述： 根据ID获取停车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param communityId 小区ID
	 * @return 停车位查询数据
	 */
	List<MemberSpace>listMemberSpaceByCommunityId(Long communityId);

	/**
	 * 描 述： 根据ID获取停车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param id 车位ID
	 * @return 停车位查询数据
	 */
	MemberSpace getParkingSpaceById(Long id);

	/**
	 * 描 述： 保存车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param space 车位
	 */
	void save(MemberSpace space);

	/**
	 * 描 述： 根据ID删除车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 车位ID数组
	 */
	void delByIds(Long[] ids);


}
