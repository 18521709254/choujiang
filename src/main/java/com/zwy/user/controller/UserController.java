package com.zwy.user.controller;

import com.github.pagehelper.PageInfo;
import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.user.model.User;
import com.zwy.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类 名: UserController
 * 描 述: 用户控制层
 * 作 者: 宋凯翔
 * 创 建：2020年10月24日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Resource(name = "userServiceImpl")
	private UserService userService;


	/**
	 * 描 述： 分页查询用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户
	 * @return 用户查询分页数据
	 */
	@PostMapping("/listUserByPage")
	public Result<PageInfo<User>> listUserByPage(User user){
		userService.listUserByPage(user);
		return Results.ok(user.getPageInfo());
	}

	/**
	 * 描 述： 保存用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户
	 * @return 用户查询分页数据
	 */
	@PostMapping("/save")
	public Result<String> save(User user){
		userService.save(user);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 用户ID数组
	 * @return 用户查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<String> delByIds(Long[] ids){
		userService.delByIds(ids);
		return Results.ok("删除成功");
	}



	/**
	 * 描 述： 用户登录
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户
	 */
	@PostMapping("/login")
	public Result<String> login(User user){
		String msg = "登录成功";
		user = userService.getUserByUser(user);
		if(user == null){
			msg = "账号或密码错误";
		}
		return Results.ok(msg);
	}
}
