package com.zwy.property.controller;

import com.github.pagehelper.PageInfo;
import com.zwy.base.model.BaseQuery;
import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.property.model.Property;
import com.zwy.property.service.PropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
	public Result<List<Property>> listPropertyAll(){
		return Results.ok(propertyService.listPropertyAll());
	}

	/**
	 * 描 述： 物业分页查询
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 物业查询数据
	 */
	@PostMapping("/listPropertyByPage")
	public Result<PageInfo<Property>> listPropertyByPage(@RequestBody Property item){
		propertyService.listPropertyByPage(item);
		return Results.ok(item.getPageInfo());
	}

	/**
	 * 描 述： 保存物业
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param property 物业
	 * @return 物业查询分页数据
	 */
	@PostMapping("/save")
	public Result<String> save(Property property){
		propertyService.save(property);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除物业
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 物业ID数组
	 * @return 物业查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<String> delByIds(Long[] ids){
		propertyService.delByIds(ids);
		return Results.ok("删除成功");
	}

}
