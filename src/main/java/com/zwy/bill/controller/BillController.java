package com.zwy.bill.controller;

import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.bill.model.Bill;
import com.zwy.bill.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类 名: BillController
 * 描 述: 订单控制层
 * 作 者: 宋凯翔
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
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 订单查询数据
	 */
	@PostMapping("/listBillAll")
	public Result<List<Bill>> listBillByPage(){
		return Results.ok(billService.listBillAll());
	}

	/**
	 * 描 述： 保存订单
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param bill 订单
	 * @return 订单查询分页数据
	 */
	@PostMapping("/save")
	public Result<Void> save(Bill bill){
		billService.save(bill);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除订单
	 * 作 者： 宋凯翔
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
