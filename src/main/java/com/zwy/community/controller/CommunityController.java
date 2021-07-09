package com.zwy.community.controller;

import com.github.pagehelper.PageInfo;
import com.zwy.base.config.SystemConstant;
import com.zwy.base.model.ApiAccessToken;
import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.community.model.Community;
import com.zwy.community.service.CommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
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

	/** 服务访问地址 */
	@Value("${server.address}")
	public String address;
	/** 服务端口 */
	@Value("${server.port}")
	public String port;

	@Resource(name = "communityServiceImpl")
	private CommunityService communityService;

	/**
	 * 描 述： 分页查询小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 小区查询数据
	 */
	@PostMapping("/listCommunityByPage")
	public Result<PageInfo<Community>> listCommunityByPage(@RequestBody Community community, ServletRequest request){
		// 获取当前登录人信息
		ApiAccessToken apiAccessToken = (ApiAccessToken) request.getAttribute(SystemConstant.CURRENT_API_ACCESS_TOKEN);
		communityService.listCommunityByPage(community,apiAccessToken.getUser());
		return Results.ok(community.getPageInfo());
	}

	/**
	 * 描 述： 查询全部小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 小区查询数据
	 */
	@PostMapping("/listCommunityAll")
	public Result<List<Community>> listCommunityAll(ServletRequest request){
		// 获取当前登录人信息
		ApiAccessToken apiAccessToken = (ApiAccessToken) request.getAttribute(SystemConstant.CURRENT_API_ACCESS_TOKEN);
		List<Community> communityList = communityService.listCommunityAll(apiAccessToken.getUser());
		return Results.ok(communityList);
	}

	/**
	 * 描 述： 根据物业ID查询小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param propertyId 物业ID
	 * @return 小区查询数据
	 */
	@PostMapping("/listCommunityByPropertyId")
	public Result<List<Community>> listCommunityByPropertyId(@RequestParam(value = "propertyId")Long propertyId,ServletRequest request){
		// 获取当前登录人信息
		ApiAccessToken apiAccessToken = (ApiAccessToken) request.getAttribute(SystemConstant.CURRENT_API_ACCESS_TOKEN);
		List<Community> communityList = communityService.listCommunityByPropertyId(propertyId,apiAccessToken.getUser());
		return Results.ok(communityList);
	}


	/**
	 * 描 述： 根据ID查询小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param communityId 小区ID
	 * @return 小区数据
	 */
	@PostMapping("/getCommunityById")
	public Result<Community> getCommunityById(@RequestParam(value = "communityId") Long communityId){
		Community item = communityService.getCommunityById(communityId);
		return Results.ok(item);
	}
	
	/**
	 * 描 述： 保存小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param community 小区
	 * @return 小区查询分页数据
	 */
	@PostMapping("/save")
	public Result<Void> save(@RequestBody Community community){
		communityService.save(community);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param communityIds 小区ID数组
	 * @return 小区查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<Void> delByIds(@RequestParam(value = "communityIds") Long[] communityIds){
		communityService.delByIds(communityIds);
		return Results.ok("删除成功");
	}

}
