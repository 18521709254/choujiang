package com.zwy.placard.dao;

import com.zwy.placard.model.Placard;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类 名: IPlacardDao
 * 描 述: 公告数据访问层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Repository("placardDaoImpl")
public interface IPlacardDao {

	/**
	 * 描 述： 查询全部角色
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 角色列表
	 */
	List<Placard> listPlacardAll();

	/**
	 * 描 述： 新增公告
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param placard 公告信息
	 */
	void add(Placard placard);

	/**
	 * 描 述： 修改公告
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param placard 公告信息
	 */
	void update(Placard placard);

	/**
	 * 描 述： 删除公告
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 公告ID数组
	 */
	void delByIds(Long[] ids);
}
