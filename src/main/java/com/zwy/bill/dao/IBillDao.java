package com.zwy.bill.dao;

import com.zwy.bill.model.Bill;
import com.zwy.user.model.User;
import org.apache.ibatis.annotations.Param;
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
	 * @param user 登陆用户
	 */
	List<Bill> listBillByPage(@Param("item") Bill item, @Param("user")User user);

	/**
	 * 描 述： 根据ID集合批量查询订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 用户ID数组
	 * @return 订单数据
	 */
	List<Bill> listBillByIds(Long[] ids);

	/**
	 * 描 述： 根据ID查询订单信息
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param billId 订单ID
	 * @return 订单查询数据
	 */
	Bill getBillById(Long billId);

	/**
	 * 描 述： 查询订单总计数据
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param item 订单信息
	 * @param user 登陆用户
	 * @return 总计数据
	 */
	Bill getTotalBill(@Param("item") Bill item, @Param("user")User user);

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
	 * 描 述： 订单缴费
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param billIds 订单ID数组
	 */
	void payBillByIds(Long[] billIds);

	/**
	 * 描 述： 批量结束订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param billList 订单集合
	 */
	void closeBillBatch(List<Bill> billList);
}
