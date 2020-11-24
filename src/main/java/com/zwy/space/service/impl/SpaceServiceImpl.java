package com.zwy.space.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwy.community.model.Community;
import com.zwy.space.dao.ISpaceDao;
import com.zwy.space.model.Space;
import com.zwy.space.service.SpaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 类 名: SpaceServiceImpl
 * 描 述: 车位事物实现
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Slf4j
@Service("spaceServiceImpl")
@Transactional(value = "transactionManager",rollbackFor = Exception.class)
public class SpaceServiceImpl implements SpaceService {

	@Resource(name = "spaceDaoImpl")
	private ISpaceDao spaceDao;

	/**
	 * 描 述： 分页查询车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 */
	@Override
	public List<Space> listSpaceAll() {
		return spaceDao.listSpaceAll();
	}

	/**
	 * 描 述： 分页查询停车位
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param item 车位数据
	 */
	@Override
	public void listSpaceByPage(Space item) {
		PageInfo<Space> pageInfo = item.getPageInfo();
		// 设置分页属性
		Page<Space> pageResult = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		// 存放数据
		List<Space> resultList = spaceDao.listSpaceByPage(item);
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
	 * 描 述： 根据ID获取停车位
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param communityId 小区ID
	 * @return 停车位查询数据
	 */
	@Override
	public List<Space> listSpaceByCommunityId(Long communityId) {
		return spaceDao.listSpaceByCommunityId(communityId);
	}

	/**
	 * 描 述： 根据ID获取停车位
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param id 车位ID
	 * @return 停车位查询数据
	 */
	@Override
	public Space getParkingSpaceById(Long id) {
		return spaceDao.getParkingSpaceById(id);
	}

	/**
	 * 描 述： 保存车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param space 车位
	 */
	@Override
	public void save(Space space) {
		// ID 不存在新增
		if(space.getId() == null){
			// 默认空闲
			space.setUseStatus(0);
			// 新增数据默认给审核中
			space.setCheckStatus(0);
			spaceDao.add(space);
			return;
		}
		// 反之修改
		spaceDao.update(space);
	}

	/**
	 * 描 述： 根据ID删除车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 车位ID数组
	 */
	@Override
	public void delByIds(Long[] ids) {
		spaceDao.delByIds(ids);
	}
}
