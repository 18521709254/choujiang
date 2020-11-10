package com.zwy.community.controller;

import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.community.model.Community;
import com.zwy.community.service.CommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类 名: CommunityController
 * 描 述: 小区控制层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */

@Slf4j
@RestController
@RequestMapping("/api/community")
public class CommunityController {

	@Resource(name = "communityServiceImpl")
	private CommunityService communityService;

	/**
	 * 描 述： 分页查询小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 小区查询数据
	 */
	@PostMapping("/listCommunityAll")
	public Result<List<Community>> listCommunityByPage(){
		return Results.ok(communityService.listCommunityAll());
	}

	/**
	 * 描 述： 保存小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param community 小区
	 * @return 小区查询分页数据
	 */
	@PostMapping("/save")
	public Result<Void> save(Community community){
		communityService.save(community);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 小区ID数组
	 * @return 小区查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<Void> delByIds(Long[] ids){
		communityService.delByIds(ids);
		return Results.ok("删除成功");
	}

}
