package com.zwy.property.controller;

import com.github.pagehelper.PageInfo;
import com.zwy.base.config.SystemConstant;
import com.zwy.base.model.ApiAccessToken;
import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.property.model.Property;
import com.zwy.property.service.PropertyService;
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
 * 类 名: PropertyController
 * 描 述: 物业控制层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */

@Slf4j
@RestController
@RequestMapping("/api/property")
public class PropertyController {

	@Resource(name = "propertyServiceImpl")
	private PropertyService propertyService;


	/**
	 * 描 述： 查询全部物业
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 物业查询数据
	 */
	@PostMapping("/listPropertyAll")
	public Result<List<Property>> listPropertyAll(ServletRequest request){
		// 获取当前登录人信息
		ApiAccessToken apiAccessToken = (ApiAccessToken) request.getAttribute(SystemConstant.CURRENT_API_ACCESS_TOKEN);
		return Results.ok(propertyService.listPropertyAll(apiAccessToken.getUser()));
	}

	/**
	 * 描 述： 物业分页查询
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 物业查询数据
	 */
	@PostMapping("/listPropertyByPage")
	public Result<PageInfo<Property>> listPropertyByPage(@RequestBody Property item, ServletRequest request){
		// 获取当前登录人信息
		ApiAccessToken apiAccessToken = (ApiAccessToken) request.getAttribute(SystemConstant.CURRENT_API_ACCESS_TOKEN);
		propertyService.listPropertyByPage(item,apiAccessToken.getUser());
		return Results.ok(item.getPageInfo());
	}

	/**
	 * 描 述： 根据ID查询物业
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param propertyId 物业ID
	 * @return 物业查询数据
	 */
	@PostMapping("/getPropertyById")
	public Result<Property> getPropertyById(@RequestParam(value = "propertyId") Long propertyId){
		Property item = propertyService.getPropertyById(propertyId);
		return Results.ok(item);
	}

	/**
	 * 描 述： 保存物业
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param property 物业
	 * @return 物业查询分页数据
	 */
	@PostMapping("/save")
	public Result<Void> save(@RequestBody Property property){
		propertyService.save(property);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除物业
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param propertyIds 物业ID数组
	 * @return 物业查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<Void> delByIds(@RequestParam(value = "propertyIds") Long[] propertyIds){
		propertyService.delByIds(propertyIds);
		return Results.ok("删除成功");
	}

}
