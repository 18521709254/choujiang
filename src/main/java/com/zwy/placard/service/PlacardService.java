package com.zwy.placard.service;
import com.zwy.placard.model.Placard;

import java.util.List;

/**
 * 类 名: PlacardService
 * 描 述: 公告Service层
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
public interface PlacardService {


	/**
	 * 描 述： 分页查询公告
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 */
	List<Placard> listPlacardAll();

	/**
	 * 描 述： 公告分页查询
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 */
	void listPlacardByPage(Placard item);

	/**
	 * 描 述： 公告分页查询
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param placardId 公告ID
	 * @return 物业查询数据
	 */
	Placard getPlacardById(Long placardId);

	/**
	 * 描 述： 保存公告
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param placard 公告
	 */
	void save(Placard placard);

	/**
	 * 描 述： 根据ID删除公告
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 公告ID数组
	 */
	void delByIds(Long[] ids);


}
