package com.zwy.bill.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwy.bill.dao.IBillDao;
import com.zwy.bill.model.Bill;
import com.zwy.bill.service.BillService;
import com.zwy.space.dao.ISpaceDao;
import com.zwy.space.model.Space;
import com.zwy.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 类 名: BillServiceImpl
 * 描 述: 订单事物实现
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Slf4j
@Service("billServiceImpl")
@Transactional(value = "transactionManager",rollbackFor = Exception.class)
public class BillServiceImpl implements BillService {

	@Resource(name = "billDaoImpl")
	private IBillDao billDao;
	@Resource(name = "spaceDaoImpl")
	private ISpaceDao spaceDao;

	/**
	 * 描 述： 分页查询订单
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 */
	@Override
	public List<Bill> listBillAll() {
		return billDao.listBillAll();
	}

	/**
	 * 描 述： 分页查询订单
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param item 订单信息
	 * @param user 登陆用户
	 */
	@Override
	public void listBillByPage(Bill item, User user) {
		PageInfo<Bill> pageInfo = item.getPageInfo();
		// 设置分页属性
		Page<Bill> pageResult = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		// 存放数据
		List<Bill> resultList = billDao.listBillByPage(item,user);
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
	 * 描 述： 根据ID查询订单信息
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param billId 订单ID
	 * @return 订单查询数据
	 */
	@Override
	public Bill getBillById(Long billId) {
		return billDao.getBillById(billId);
	}

	/**
	 * 描 述： 获取订单总计数据
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param bill 订单信息
	 * @param user 当前用户
	 * @return 订单总计数据
	 */
	@Override
	public Bill getTotalBill(Bill bill, User user) {
		return billDao.getTotalBill(bill,user);
	}

	/**
	 * 描 述： 保存订单
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param bill 订单
	 */
	@Override
	public String save(Bill bill) {
		Space space = spaceDao.getParkingSpaceById(bill.getParkingSpaceId()) ;
		if(space == null){
			return "保存订单时车位不存在";
		}
		// 私人物业需要审核
		if(Objects.equals(2,space.getType()) &&!Objects.equals(1,space.getCheckStatus())){
			return "车位未审核通过,暂无法使用";
		}
		if(Objects.equals(space.getUseStatus(),0)){
			return "车位已暂停租用，请使用其他车位";
		}
		if(Objects.equals(space.getUseStatus(),2)){
			return "车位已使用请选择其他编号车位";
		}
		// 反之修改
		billDao.update(bill);
		return "订单保存成功";
	}

	/**
	 * 描 述： 结束订单
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param billIds 订单ID数组
	 */
	@Override
	public void closeBillByIds(Long[] billIds) {
		// 获取现在的时间
		Date now = new Date();
		// 批量查询订单先
		List<Bill> billList = billDao.listBillByIds(billIds);
		for (Bill bill : billList) {
			Long billId = bill.getId();
			// 查询订单
			Space space = spaceDao.getParkingSpaceById(bill.getParkingSpaceId());
			if(space == null){
				log.warn("结束订单时车位不存在订单ID:{}",billId);
			}
			// 查看停了多少个小时
			long hour = this.getHoursBetween(now,bill.getStartDate());
			// 会员需要付全部金额
			Double totalMoney = hour * space.getPrice();
			bill.setTotalMoney(totalMoney);
			// 如果车位是私人的需要抽成
			if(Objects.equals(space.getType(),2)){
				Double percentMoney = totalMoney * space.getPercent();
				bill.setPercentMoney(percentMoney);
			}
		}
		billDao.closeBillBatch(billList);
	}

	/**
	 * 描 述： 订单缴费
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param billIds 订单ID数组
	 */
	@Override
	public void payBillByIds(Long[] billIds) {
		billDao.payBillByIds(billIds);
	}

	/**
	 * 描 述： 根据ID删除订单
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 订单ID数组
	 */
	@Override
	public void delByIds(Long[] ids) {
		billDao.delByIds(ids);
	}

	/**
	 * 描 述： 获取两个时间段的小时差
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param date1 日期1
	 * @param date2 日期2
	 * @return 相差时间
	 */
	private long getHoursBetween(Date date1,Date date2){
		// 获取时间差
		long subTime = date1.getTime() - date2.getTime();
		return subTime/ DateUtils.MILLIS_PER_HOUR;
	}
}
