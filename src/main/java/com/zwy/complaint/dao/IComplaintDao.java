package com.zwy.complaint.dao;

import com.zwy.complaint.model.Complaint;
import com.zwy.user.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类 名: IComplaintDao
 * 描 述: 投诉控制层
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Repository("complaintDaoImpl")
public interface IComplaintDao {

	/**
	 * 描 述： 查询全部投诉
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @return 投诉列表
	 * @param user 当前用户
	 */
	List<Complaint> listComplaintAll(@Param("user") User user);

	/**
	 * 描 述： 分页查询投诉
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param item 投诉
	 * @param user 当前用户
	 */
	List<Complaint> listPropertyByPage(@Param("item") Complaint item, @Param("user") User user);

	/**
	 * 描 述： 根据物业ID查询投诉
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param propertyId 物业ID
	 * @param user 当前用户
	 * @return 投诉查询数据
	 */
	List<Complaint> listComplaintByPropertyId(@Param("propertyId") Long propertyId, @Param("user") User user);

	/**
	 * 描 述： 根据ID查询投诉
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param id 投诉ID
	 * @return 投诉数据
	 */
	Complaint getComplaintById(Long id);

	/**
	 * 描 述： 新增用户
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户信息
	 */
	void add(Complaint user);

	/**
	 * 描 述： 修改用户
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户信息
	 */
	void update(Complaint user);

	/**
	 * 描 述： 删除用户
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 用户ID数组
	 */
	void delByIds(Long[] ids);


}
