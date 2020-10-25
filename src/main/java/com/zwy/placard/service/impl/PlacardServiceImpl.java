package com.zwy.placard.service.impl;

import com.zwy.placard.dao.IPlacardDao;
import com.zwy.placard.model.Placard;
import com.zwy.placard.service.PlacardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类 名: PlacardServiceImpl
 * 描 述: 
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Slf4j
@Service("placardServiceImpl")
@Transactional(value = "transactionManager",rollbackFor = Exception.class)
public class PlacardServiceImpl implements PlacardService {

	@Resource(name = "placardDaoImpl")
	private IPlacardDao placardDao;

	/**
	 * 描 述： 分页查询公告
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param placard 公告
	 */
	@Override
	public List<Placard> listPlacardAll() {
		return placardDao.listPlacardAll();
	}

	/**
	 * 描 述： 保存公告
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param placard 公告
	 */
	@Override
	public void save(Placard placard) {
		// ID 不存在新增
		if(placard.getId() == null){
			placardDao.add(placard);
			return;
		}
		// 反之修改
		placardDao.update(placard);
	}

	/**
	 * 描 述： 根据ID删除公告
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 公告ID数组
	 */
	@Override
	public void delByIds(Long[] ids) {
		placardDao.delByIds(ids);
	}
}