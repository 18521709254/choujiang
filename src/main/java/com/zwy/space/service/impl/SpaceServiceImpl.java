package com.zwy.space.service.impl;

import com.zwy.space.dao.ISpaceDao;
import com.zwy.space.model.Space;
import com.zwy.space.service.SpaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类 名: SpaceServiceImpl
 * 描 述: 车位事物实现
 * 作 者: 宋凯翔
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
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param space 车位
	 */
	@Override
	public List<Space> listSpaceAll() {
		return spaceDao.listSpaceAll();
	}

	/**
	 * 描 述： 保存车位
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param space 车位
	 */
	@Override
	public void save(Space space) {
		// ID 不存在新增
		if(space.getId() == null){
			spaceDao.add(space);
			return;
		}
		// 反之修改
		spaceDao.update(space);
	}

	/**
	 * 描 述： 根据ID删除车位
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 车位ID数组
	 */
	@Override
	public void delByIds(Long[] ids) {
		spaceDao.delByIds(ids);
	}
}
