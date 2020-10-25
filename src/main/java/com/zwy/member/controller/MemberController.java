package com.zwy.member.controller;

import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.member.model.Member;
import com.zwy.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类 名: MemberController
 * 描 述: 会员控制层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */

@Slf4j
@RestController
@RequestMapping("/api/member")
public class MemberController {

	@Resource(name = "memberServiceImpl")
	private MemberService memberService;

	/**
	 * 描 述： 分页查询会员
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 会员查询数据
	 */
	@PostMapping("/listMemberAll")
	public Result<List<Member>> listMemberByPage(){
		return Results.ok(memberService.listMemberAll());
	}

	/**
	 * 描 述： 保存会员
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param member 会员
	 * @return 会员查询分页数据
	 */
	@PostMapping("/save")
	public Result<String> save(Member member){
		memberService.save(member);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除会员
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 会员ID数组
	 * @return 会员查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<String> delByIds(Long[] ids){
		memberService.delByIds(ids);
		return Results.ok("删除成功");
	}

}
