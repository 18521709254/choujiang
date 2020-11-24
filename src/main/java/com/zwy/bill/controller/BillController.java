package com.zwy.bill.controller;

import com.github.pagehelper.PageInfo;
import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.bill.model.Bill;
import com.zwy.bill.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类 名: BillController
 * 描 述: 订单控制层
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */

@Slf4j
@RestController
@RequestMapping("/api/bill")
public class BillController {

	@Resource(name = "billServiceImpl")
	private BillService billService;

	/**
	 * 描 述： 分页查询订单
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @return 订单查询数据
	 */
	@PostMapping("/listBillByPage")
	public Result<PageInfo<Bill>> listBillByPage(@RequestBody Bill bill){
		billService.listBillByPage(bill);
		return Results.ok(bill.getPageInfo());
	}

	/**
	 * 描 述： 根据ID查询订单信息
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param billId 订单ID
	 * @return 订单查询数据
	 */
	@PostMapping("/getBillById")
	public Result<Bill> getBillById(@RequestParam(value = "billId") Long billId){
		Bill bill = billService.getBillById(billId);
		return Results.ok(bill);
	}

	/**
	 * 描 述： 保存订单
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param bill 订单
	 * @return 订单查询分页数据
	 */
	@PostMapping("/save")
	public Result<Void> save(@RequestBody Bill bill){
		billService.save(bill);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除订单
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 订单ID数组
	 * @return 订单查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<Void> delByIds(Long[] ids){
		billService.delByIds(ids);
		return Results.ok("删除成功");
	}

}
