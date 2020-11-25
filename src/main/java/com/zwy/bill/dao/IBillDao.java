package com.zwy.bill.dao;

import com.zwy.bill.model.Bill;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类 名: IBillDao
 * 描 述: 订单控制层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Repository("billDaoImpl")
public interface IBillDao {

	/**
	 * 描 述： 查询全部订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 订单列表
	 */
	List<Bill> listBillAll();

	/**
	 * 描 述： 分页查询订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param item 订单信息
	 */
	List<Bill> listBillByPage(Bill item);

	/**
	 * 描 述： 新增用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户信息
	 */
	void add(Bill user);

	/**
	 * 描 述： 修改用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户信息
	 */
	void update(Bill user);

	/**
	 * 描 述： 删除用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 用户ID数组
	 */
	void delByIds(Long[] ids);

	/**
	 * 描 述： 根据ID查询订单信息
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param billId 订单ID
	 * @return 订单查询数据
	 */
	Bill getBillById(Long billId);
}
