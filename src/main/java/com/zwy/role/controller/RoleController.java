package com.zwy.role.controller;

import com.github.pagehelper.PageInfo;
import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.role.model.Role;
import com.zwy.role.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类 名: RoleController
 * 描 述: 角色控制层
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */

@Slf4j
@RestController
@RequestMapping("/api/role")
public class RoleController {

	@Resource(name = "roleServiceImpl")
	private RoleService roleService;

	/**
	 * 描 述： 分页全部角色
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @return 角色查询数据
	 */
	@PostMapping("/listRoleAll")
	public Result<List<Role>> listRoleAll(){
		return Results.ok(roleService.listRoleAll());
	}

	/**
	 * 描 述： 分页查询角色
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param role 角色信息
	 * @return 角色查询数据
	 */
	@PostMapping("/listRoleByPage")
	public Result<PageInfo<Role>> listRoleByPage(@RequestBody Role role){
		roleService.listRoleByPage(role);
		return Results.ok(role.getPageInfo());
	}

	/**
	 * 描 述： 根据ID查询橘色
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param roleId 角色ID
	 * @return 角色查询数据
	 */
	@PostMapping("/getRoleById")
	public Result<Role> getRoleById(@RequestParam(value = "roleId") Long roleId){
		Role role = roleService.getRoleById(roleId);
		return Results.ok(role);
	}

	/**
	 * 描 述： 保存角色
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param role 角色
	 * @return 角色查询分页数据
	 */
	@PostMapping("/save")
	public Result<Void> save(@RequestBody Role role){
		roleService.save(role);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除角色
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 角色ID数组
	 * @return 角色查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<Void> delByIds(Long[] ids){
		roleService.delByIds(ids);
		return Results.ok("删除成功");
	}

}
