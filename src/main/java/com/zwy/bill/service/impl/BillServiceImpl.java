package com.zwy.bill.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwy.bill.dao.IBillDao;
import com.zwy.bill.model.Bill;
import com.zwy.bill.service.BillService;
import com.zwy.community.model.Community;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 类 名: BillServiceImpl
 * 描 述: 订单事物实现
 * 作 者: 宋凯翔
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

	/**
	 * 描 述： 分页查询订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param bill 订单
	 */
	@Override
	public List<Bill> listBillAll() {
		return billDao.listBillAll();
	}

	/**
	 * 描 述： 分页查询订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param item 订单信息
	 */
	@Override
	public void listBillByPage(Bill item) {
		PageInfo<Bill> pageInfo = item.getPageInfo();
		// 设置分页属性
		Page<Bill> pageResult = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		// 存放数据
		List<Bill> resultList = billDao.listBillByPage(item);
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
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param billId 订单ID
	 * @return 订单查询数据
	 */
	@Override
	public Bill getBillById(Long billId) {
		return billDao.getBillById(billId);
	}

	/**
	 * 描 述： 保存订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param bill 订单
	 */
	@Override
	public void save(Bill bill) {
		// ID 不存在新增
		if(bill.getId() == null){
			billDao.add(bill);
			return;
		}
		// 反之修改
		billDao.update(bill);
	}

	/**
	 * 描 述： 根据ID删除订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 订单ID数组
	 */
	@Override
	public void delByIds(Long[] ids) {
		billDao.delByIds(ids);
	}
}
