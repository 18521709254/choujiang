package com.zwy.placard.controller;

import com.github.pagehelper.PageInfo;
import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.placard.model.Placard;
import com.zwy.placard.service.PlacardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类 名: PlacardController
 * 描 述: 公告控制层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Slf4j
@RestController
@RequestMapping("/api/placard")
public class PlacardController {

	@Resource(name = "placardServiceImpl")
	private PlacardService placardService;

	/**
	 * 描 述： 公告分页查询
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param item 公告
	 * @return 物业查询数据
	 */
	@PostMapping("/listPlacardByPage")
	public Result<PageInfo<Placard>> listPlacardByPage(@RequestBody Placard item){
		placardService.listPlacardByPage(item);
		return Results.ok(item.getPageInfo());
	}

	/**
	 * 描 述： 公告分页查询
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param placardId 公告ID
	 * @return 物业查询数据
	 */
	@PostMapping("/getPlacardById")
	public Result<Placard> getPlacardById(@RequestParam(value = "placardId") Long placardId){
		Placard placard = placardService.getPlacardById(placardId);
		return Results.ok(placard);
	}


	/**
	 * 描 述： 保存公告
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param placard 公告
	 * @return 公告查询分页数据
	 */
	@PostMapping("/save")
	public Result<Void> save(@RequestBody Placard placard){
		placardService.save(placard);
		return Results.ok("保存成功");
	}



	/**
	 * 描 述： 删除公告
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param placardIds 公告ID数组
	 * @return 公告查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<Void> delByIds(@RequestParam(value = "placardIds") Long[] placardIds){
		placardService.delByIds(placardIds);
		return Results.ok("删除成功");
	}

}
