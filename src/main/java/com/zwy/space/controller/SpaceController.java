package com.zwy.space.controller;

import com.github.pagehelper.PageInfo;
import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.space.model.Space;
import com.zwy.space.service.SpaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类 名: SpaceController
 * 描 述: 停车位控制层
 * 作 者: 张文雅
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
	 * 描 述： 分页查询全部停车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @return 停车位查询数据
	 */
	@PostMapping("/listSpaceAll")
	public Result<List<Space>> listSpaceByPage(){
		return Results.ok(spaceService.listSpaceAll());
	}

	/**
	 * 描 述： 分页查询停车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param space 车位数据
	 */
	@PostMapping("/listSpaceByPage")
	public Result<PageInfo<Space>> listSpaceByPage(@RequestBody Space space){
		spaceService.listSpaceByPage(space);
		return Results.ok(space.getPageInfo());
	}

	/**
	 * 描 述： 根据ID获取停车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param communityId 小区ID
	 * @return 停车位查询数据
	 */
	@PostMapping("/listSpaceByCommunityId")
	public Result<List<Space>> listSpaceByCommunityId(@RequestParam(value = "communityId") Long communityId){
		List<Space> spaceList = spaceService.listSpaceByCommunityId(communityId);
		return Results.ok(spaceList);
	}

	/**
	 * 描 述： 根据ID获取停车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param spaceId 车位ID
	 * @return 停车位查询数据
	 */
	@PostMapping("/getParkingSpaceById")
	public Result<Space> getParkingSpaceById(@RequestParam(value = "spaceId") Long spaceId){
		Space space = spaceService.getParkingSpaceById(spaceId);
		return Results.ok(space);
	}

	/**
	 * 描 述： 保存停车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param space 停车位
	 * @return 停车位查询分页数据
	 */
	@PostMapping("/save")
	public Result<Void> save(@RequestBody Space space){
		spaceService.save(space);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除停车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param spaceIds 停车位ID数组
	 * @return 停车位查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<Void> delByIds(@RequestParam(value = "spaceIds") Long[] spaceIds){
		spaceService.delByIds(spaceIds);
		return Results.ok("删除成功");
	}

}
