package com.zwy.space.controller;

import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.space.model.Space;
import com.zwy.space.service.SpaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类 名: SpaceController
 * 描 述: 停车位控制层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */

@Slf4j
@RestController
@RequestMapping("/api/space")
public class SpaceController {

	@Resource(name = "spaceServiceImpl")
	private SpaceService spaceService;

	/**
	 * 描 述： 分页查询停车位
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 停车位查询数据
	 */
	@PostMapping("/listSpaceAll")
	public Result<List<Space>> listSpaceByPage(){
		return Results.ok(spaceService.listSpaceAll());
	}

	/**
	 * 描 述： 保存停车位
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param space 停车位
	 * @return 停车位查询分页数据
	 */
	@PostMapping("/save")
	public Result<Void> save(Space space){
		spaceService.save(space);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除停车位
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 停车位ID数组
	 * @return 停车位查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<Void> delByIds(Long[] ids){
		spaceService.delByIds(ids);
		return Results.ok("删除成功");
	}

}
