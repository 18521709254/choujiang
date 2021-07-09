package com.zwy.complaint.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwy.complaint.dao.IComplaintDao;
import com.zwy.complaint.model.Complaint;
import com.zwy.complaint.service.ComplaintService;
import com.zwy.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 类 名: ComplaintServiceImpl
 * 描 述: 投诉事物实现
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Slf4j
@Service("complaintServiceImpl")
@Transactional(value = "transactionManager",rollbackFor = Exception.class)
public class ComplaintServiceImpl implements ComplaintService {

	@Resource(name = "complaintDaoImpl")
	private IComplaintDao complaintDao;

	/**
	 * 描 述： 查询全部投诉
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 投诉集合
	 * @param user 当前用户
	 */
	@Override
	public List<Complaint> listComplaintAll(User user) {
		return complaintDao.listComplaintAll(user);
	}


	/**
	 * 描 述： 分页查询投诉
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param item 投诉
	 * @param user 当前用户
	 */
	@Override
	public void listComplaintByPage(Complaint item, User user) {
		PageInfo<Complaint> pageInfo = item.getPageInfo();
		// 设置分页属性
		Page<Complaint> pageResult = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		// 存放数据
		List<Complaint> resultList = complaintDao.listPropertyByPage(item,user);
		// 如果为空存放空数据
		if(resultList == null){
			resultList = Collections.emptyList();
		}
		// 设置总数
		pageInfo.setTotal(pageResult.getTotal());
		// 设置总页数
		pageInfo.setPages(pageResult.getPages());
		pageInfo.setList(resultList);
	}

	/**
	 * 描 述： 根据物业ID查询投诉
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param propertyId 物业ID
	 * @param user 当前用户
	 * @return 投诉查询数据
	 */
	@Override
	public List<Complaint> listComplaintByPropertyId(Long propertyId, User user) {
		return complaintDao.listComplaintByPropertyId(propertyId,user);
	}

	/**
	 * 描 述： 根据ID查询投诉
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param complaintId 投诉ID
	 * @return 投诉数据
	 */
	@Override
	public Complaint getComplaintById(Long complaintId) {
		return complaintDao.getComplaintById(complaintId);
	}

	/**
	 * 描 述： 保存投诉
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param complaint 投诉
	 */
	@Override
	public void save(Complaint complaint) {
		// 审核状态
		int status = 0;
		if (StringUtils.isNotEmpty(complaint.getContent())){
			status = 1;
		}
		complaint.setStatus(status);
		// ID 不存在新增
		if(complaint.getId() == null){
			complaintDao.add(complaint);
			return;
		}
		// 反之修改
		complaintDao.update(complaint);
	}

	/**
	 * 描 述： 根据ID删除投诉
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 投诉ID数组
	 */
	@Override
	public void delByIds(Long[] ids) {
		complaintDao.delByIds(ids);
	}
}
