package com.zwy.community.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwy.community.dao.ICommunityDao;
import com.zwy.community.model.Community;
import com.zwy.community.service.CommunityService;
import com.zwy.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 类 名: CommunityServiceImpl
 * 描 述: 小区事物实现
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Slf4j
@Service("communityServiceImpl")
@Transactional(value = "transactionManager",rollbackFor = Exception.class)
public class CommunityServiceImpl implements CommunityService {

	@Resource(name = "communityDaoImpl")
	private ICommunityDao communityDao;

	/**
	 * 描 述： 查询全部小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 小区集合
	 * @param user 当前用户
	 */
	@Override
	public List<Community> listCommunityAll(User user) {
		return communityDao.listCommunityAll(user);
	}


	/**
	 * 描 述： 分页查询小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param item 小区
	 * @param user 当前用户
	 */
	@Override
	public void listCommunityByPage(Community item, User user) {
		PageInfo<Community> pageInfo = item.getPageInfo();
		// 设置分页属性
		Page<Community> pageResult = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		// 存放数据
		List<Community> resultList = communityDao.listPropertyByPage(item,user);
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
	 * 描 述： 根据物业ID查询小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param propertyId 物业ID
	 * @param user 当前用户
	 * @return 小区查询数据
	 */
	@Override
	public List<Community> listCommunityByPropertyId(Long propertyId, User user) {
		return communityDao.listCommunityByPropertyId(propertyId,user);
	}

	/**
	 * 描 述： 根据ID查询小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param communityId 小区ID
	 * @return 小区数据
	 */
	@Override
	public Community getCommunityById(Long communityId) {
		return communityDao.getCommunityById(communityId);
	}

	/**
	 * 描 述： 保存小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param community 小区
	 */
	@Override
	public void save(Community community) {
		// ID 不存在新增
		if(community.getId() == null){
			communityDao.add(community);
			return;
		}
		// 反之修改
		communityDao.update(community);
	}

	/**
	 * 描 述： 根据ID删除小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 小区ID数组
	 */
	@Override
	public void delByIds(Long[] ids) {
		communityDao.delByIds(ids);
	}
}
