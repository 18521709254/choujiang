package com.zwy.complaint.controller;

import com.github.pagehelper.PageInfo;
import com.zwy.base.config.SystemConstant;
import com.zwy.base.model.ApiAccessToken;
import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.complaint.model.Complaint;
import com.zwy.complaint.service.ComplaintService;
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
 * 类 名: ComplaintController
 * 描 述: 投诉控制层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */

@Slf4j
@RestController
@RequestMapping("/api/complaint")
public class ComplaintController {

	@Resource(name = "complaintServiceImpl")
	private ComplaintService complaintService;

	/**
	 * 描 述： 分页查询投诉
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 投诉查询数据
	 */
	@PostMapping("/listComplaintByPage")
	public Result<PageInfo<Complaint>> listComplaintByPage(@RequestBody Complaint complaint, ServletRequest request){
		// 获取当前登录人信息
		ApiAccessToken apiAccessToken = (ApiAccessToken) request.getAttribute(SystemConstant.CURRENT_API_ACCESS_TOKEN);
		complaintService.listComplaintByPage(complaint,apiAccessToken.getUser());
		return Results.ok(complaint.getPageInfo());
	}

	/**
	 * 描 述： 查询全部投诉
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 投诉查询数据
	 */
	@PostMapping("/listComplaintAll")
	public Result<List<Complaint>> listComplaintAll(ServletRequest request){
		// 获取当前登录人信息
		ApiAccessToken apiAccessToken = (ApiAccessToken) request.getAttribute(SystemConstant.CURRENT_API_ACCESS_TOKEN);
		List<Complaint> complaintList = complaintService.listComplaintAll(apiAccessToken.getUser());
		return Results.ok(complaintList);
	}

	/**
	 * 描 述： 根据物业ID查询投诉
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param propertyId 物业ID
	 * @return 投诉查询数据
	 */
	@PostMapping("/listComplaintByPropertyId")
	public Result<List<Complaint>> listComplaintByPropertyId(@RequestParam(value = "propertyId")Long propertyId, ServletRequest request){
		// 获取当前登录人信息
		ApiAccessToken apiAccessToken = (ApiAccessToken) request.getAttribute(SystemConstant.CURRENT_API_ACCESS_TOKEN);
		List<Complaint> complaintList = complaintService.listComplaintByPropertyId(propertyId,apiAccessToken.getUser());
		return Results.ok(complaintList);
	}



	/**
	 * 描 述： 根据ID查询投诉
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param complaintId 投诉ID
	 * @return 投诉数据
	 */
	@PostMapping("/getComplaintById")
	public Result<Complaint> getComplaintById(@RequestParam(value = "complaintId") Long complaintId){
		Complaint item = complaintService.getComplaintById(complaintId);
		return Results.ok(item);
	}
	
	/**
	 * 描 述： 保存投诉
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param complaint 投诉
	 * @return 投诉查询分页数据
	 */
	@PostMapping("/save")
	public Result<Void> save(@RequestBody Complaint complaint){
		complaintService.save(complaint);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除投诉
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param complaintIds 投诉ID数组
	 * @return 投诉查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<Void> delByIds(@RequestParam(value = "complaintIds") Long[] complaintIds){
		complaintService.delByIds(complaintIds);
		return Results.ok("删除成功");
	}

}
