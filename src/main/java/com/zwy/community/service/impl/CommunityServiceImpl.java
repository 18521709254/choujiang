package com.zwy.community.service.impl;

import com.zwy.community.dao.ICommunityDao;
import com.zwy.community.model.Community;
import com.zwy.community.service.CommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
	 * 描 述： 分页查询小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param community 小区
	 */
	@Override
	public List<Community> listCommunityAll() {
		return communityDao.listCommunityAll();
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
