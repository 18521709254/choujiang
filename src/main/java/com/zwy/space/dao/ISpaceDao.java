package com.zwy.space.dao;

import com.zwy.space.model.Space;
import com.zwy.user.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类 名: ISpaceDao
 * 描 述: 车位控制层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Repository("spaceDaoImpl")
public interface ISpaceDao {

	/**
	 * 描 述： 查询全部车位
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 车位列表
	 */
	List<Space> listSpaceAll();

	/**
	 * 描 述： 分页查询停车位
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param item 车位数据
	 * @param user 当前登录用户
	 */
	List<Space> listSpaceByPage(@Param("item") Space item, @Param("user") User user);

	/**
	 * 描 述： 根据ID获取停车位
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param communityId 小区ID
	 * @return 停车位查询数据
	 */
	List<Space> listSpaceByCommunityId(Long communityId);

	/**
	 * 描 述： 根据ID获取停车位
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param id 车位ID
	 * @return 停车位查询数据
	 */
	Space getParkingSpaceById(Long id);


	/**
	 * 描 述： 新增车位
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param space 车位信息
	 */
	void add(Space space);

	/**
	 * 描 述： 修改车位
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param space 车位信息
	 */
	void update(Space space);

	/**
	 * 描 述： 删除车位
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 车位ID数组
	 */
	void delByIds(Long[] ids);


}
