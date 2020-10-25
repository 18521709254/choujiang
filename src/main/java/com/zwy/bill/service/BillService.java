package com.zwy.bill.service;
import com.zwy.bill.model.Bill;

import java.util.List;

/**
 * 类 名: BillService
 * 描 述: 订单事物层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
public interface BillService {


	/**
	 * 描 述： 分页查询订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param bill 订单
	 */
	List<Bill> listBillAll();

	/**
	 * 描 述： 保存订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param bill 订单
	 */
	void save(Bill bill);

	/**
	 * 描 述： 根据ID删除订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 订单ID数组
	 */
	void delByIds(Long[] ids);
}