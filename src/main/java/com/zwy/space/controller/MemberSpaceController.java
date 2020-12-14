package com.zwy.space.controller;

import com.github.pagehelper.PageInfo;
import com.zwy.base.config.SystemConstant;
import com.zwy.base.model.ApiAccessToken;
import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.space.model.MemberSpace;
import com.zwy.space.service.MemberSpaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.ServletRequest;
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
@RequestMapping("/api/memberSpace")
public class MemberSpaceController {

	@Resource(name = "memberSpaceServiceImpl")
	private MemberSpaceService memberSpaceService;

	/**
	 * 描 述： 分页查询全部停车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @return 停车位查询数据
	 */
	@PostMapping("/listMemberSpaceAll")
	public Result<List<MemberSpace>> listMemberSpaceByPage(){
		return Results.ok(memberSpaceService.listMemberSpaceAll());
	}

	/**
	 * 描 述： 分页查询停车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param memberSpace 车位数据
	 */
	@PostMapping("/listMemberSpaceByPage")
	public Result<PageInfo<MemberSpace>> listMemberSpaceByPage(@RequestBody MemberSpace memberSpace, ServletRequest request){
		// 获取当前登录人信息
		ApiAccessToken apiAccessToken = (ApiAccessToken) request.getAttribute(SystemConstant.CURRENT_API_ACCESS_TOKEN);
		memberSpaceService.listMemberSpaceByPage(memberSpace,apiAccessToken.getUser());
		return Results.ok(memberSpace.getPageInfo());
	}

	/**
	 * 描 述： 根据ID获取停车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param communityId 小区ID
	 * @return 停车位查询数据
	 */
	@PostMapping("/listMemberSpaceByCommunityId")
	public Result<List<MemberSpace>> listMemberSpaceByCommunityId(@RequestParam(value = "communityId") Long communityId){
		List<MemberSpace> memberSpaceList = memberSpaceService.listMemberSpaceByCommunityId(communityId);
		return Results.ok(memberSpaceList);
	}

	/**
	 * 描 述： 根据ID获取停车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param memberSpaceId 车位ID
	 * @return 停车位查询数据
	 */
	@PostMapping("/getParkingSpaceById")
	public Result<MemberSpace> getParkingSpaceById(@RequestParam(value = "memberSpaceId") Long memberSpaceId){
		MemberSpace memberSpace = memberSpaceService.getParkingSpaceById(memberSpaceId);
		return Results.ok(memberSpace);
	}

	/**
	 * 描 述： 保存停车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param memberSpace 停车位
	 * @return 停车位查询分页数据
	 */
	@PostMapping("/save")
	public Result<Void> save(@RequestBody MemberSpace memberSpace){
		memberSpaceService.save(memberSpace);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除停车位
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param memberSpaceIds 停车位ID数组
	 * @return 停车位查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<Void> delByIds(@RequestParam(value = "memberSpaceIds") Long[] memberSpaceIds){
		memberSpaceService.delByIds(memberSpaceIds);
		return Results.ok("删除成功");
	}

}
