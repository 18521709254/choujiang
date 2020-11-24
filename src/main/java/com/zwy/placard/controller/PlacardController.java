package com.zwy.placard.controller;

import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.placard.model.Placard;
import com.zwy.placard.service.PlacardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类 名: PlacardController
 * 描 述: 公告控制层
 * 作 者: 张文雅
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
	 * 描 述： 保存公告
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param placard 公告
	 * @return 公告查询分页数据
	 */
	@PostMapping("/save")
	public Result<Void> save(Placard placard){
		placardService.save(placard);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除公告
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 公告ID数组
	 * @return 公告查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<Void> delByIds(Long[] ids){
		placardService.delByIds(ids);
		return Results.ok("删除成功");
	}

}
