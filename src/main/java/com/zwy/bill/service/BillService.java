package com.zwy.bill.service;
import com.zwy.bill.model.Bill;
import com.zwy.user.model.User;

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
	 */
	List<Bill> listBillAll();

	/**
	 * 描 述： 分页查询订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param bill 订单信息
	 * @param user 登陆用户
	 */
	void listBillByPage(Bill bill, User user);

	/**
	 * 描 述： 根据ID查询订单信息
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param billId 订单ID
	 * @return 订单查询数据
	 */
	Bill getBillById(Long billId);

	/**
	 * 描 述： 获取订单总计数据
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param bill 订单信息
	 * @param user 当前用户
	 * @return 订单总计数据
	 */
	Bill getTotalBill(Bill bill, User user);

	/**
	 * 描 述： 保存订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param bill 订单
	 */
	String save(Bill bill);

	/**
	 * 描 述： 结束订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param billIds 订单ID数组
	 */
	void closeBillByIds(Long[] billIds);

	/**
	 * 描 述： 订单缴费
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param billIds 订单ID数组
	 */
	void payBillByIds(Long[] billIds);

	/**
	 * 描 述： 根据ID删除订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 订单ID数组
	 */
	void delByIds(Long[] ids);


}
