package com.zwy.user.controller;

import com.github.pagehelper.PageInfo;
import com.zwy.base.model.ApiAccessToken;
import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.user.model.User;
import com.zwy.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
	public Result<PageInfo<User>> listUserByPage(@RequestBody User user) {
		userService.listUserByPage(user);
		return Results.ok(user.getPageInfo());
	}

	/**
	 * 描 述： 根据ID获取用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param userId 用户ID
	 * @return 用户信息
	 */
	@PostMapping("/getUserById")
	public Result<User> getUserById(@RequestParam(value = "userId") Long userId) {
		User user = userService.getUserById(userId);
		return Results.ok(user);
	}

	/**
	 * 描 述： 保存用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户
	 * @return 用户查询分页数据
	 */
	@PostMapping("/save")
	public Result<Void> save(@RequestBody User user){
		userService.save(user);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除用户
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param userIds 用户ID数组
	 * @return 用户查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<Void> delByIds(@RequestParam(value = "userIds") Long[] userIds) {
		userService.delByIds(userIds);
		return Results.ok("删除成功");
	}



	/**
	 * 描 述： 用户登录
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户
	 */
	@PostMapping("/login")
	public Result<String> login(@RequestBody User user, HttpServletRequest request){
		// 设置令牌
		String accessToken = UUID.randomUUID().toString().replaceAll("-", "");
		if(StringUtils.equals(user.getAccount(),"admin") && StringUtils.equals(user.getPassword(),"123456")){
			ApiAccessToken apiAccessToken = new ApiAccessToken(accessToken,user);
			request.setAttribute("token",apiAccessToken);
			return Results.ok("登陆成功",accessToken);
		}
		user = userService.getUserByUser(user);
		if(user == null){
			return Results.ok("账号或密码错误",null);
		}
		return Results.ok("登陆成功",accessToken);
	}

	/**
	 * 描 述： 登出
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param user 用户
	 */
	@PostMapping("/logout")
	public Result<Void> logout(@RequestBody User user, HttpServletRequest request){
		return Results.ok();
	}

	/**
	 * 描 述： 单纯需要的用户信息接口
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param token 登陆令牌
	 */
	@GetMapping("/info")
	public Result<Map> info(@RequestParam("token") String token){
		log.info(token);
		HashMap<String,String> map = new HashMap<>(2);
		map.put("name","测试Name");
		map.put("avatar","测试avatar");
		return Results.ok(map);
	}
}
