package com.zwy.complaint.service;
import com.zwy.complaint.model.Complaint;
import com.zwy.user.model.User;

import java.util.List;

/**
 * 类 名: ComplaintService
 * 描 述: 投诉事物层
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
public interface ComplaintService {


	/**
	 * 描 述： 查询全部投诉
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @return 投诉集合
	 * @param user 当前用户
	 */
	List<Complaint> listComplaintAll(User user);

	/**
	 * 描 述： 分页查询投诉
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param community 投诉
	 * @param user 当前用户
	 */
	void listComplaintByPage(Complaint community, User user);

	/**
	 * 描 述： 根据物业ID查询投诉
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param propertyId 物业ID
	 * @param user 当前用户
	 * @return 投诉查询数据
	 */
	List<Complaint> listComplaintByPropertyId(Long propertyId, User user);

	/**
	 * 描 述： 根据ID查询投诉
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param communityId 投诉ID
	 * @return 投诉数据
	 */
	Complaint getComplaintById(Long communityId);


	/**
	 * 描 述： 保存投诉
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param community 投诉
	 */
	void save(Complaint community);

	/**
	 * 描 述： 根据ID删除投诉
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 投诉ID数组
	 */
	void delByIds(Long[] ids);


}
