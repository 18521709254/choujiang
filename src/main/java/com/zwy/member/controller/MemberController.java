package com.zwy.member.controller;

import com.github.pagehelper.PageInfo;
import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.member.model.Member;
import com.zwy.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@PostMapping("/listMemberByPage")
	public Result<PageInfo<Member>> listMemberByPage(@RequestBody Member member){
		memberService.listMemberByPage(member);
		return Results.ok(member.getPageInfo());
	}

	/**
	 * 描 述： 查询全部会员
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 会员查询数据
	 */
	@PostMapping("/listMemberAll")
	public Result<List<Member>> listMemberAll(){
		List<Member> memberList = memberService.listMemberAll();
		return Results.ok(memberList);
	}

	/**
	 * 描 述： 根据ID查询会员
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param memberId 会员ID
	 * @return 会员数据
	 */
	@PostMapping("/getMemberById")
	public Result<Member> getMemberById(@RequestParam(value = "memberId") Long memberId){
		Member item = memberService.getMemberById(memberId);
		return Results.ok(item);
	}

	/**
	 * 描 述： 保存会员
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param member 会员
	 * @return 会员查询分页数据
	 */
	@PostMapping("/save")
	public Result<Void> save(@RequestBody Member member){
		memberService.save(member);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除会员
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param memberIds 会员ID数组
	 * @return 会员查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<Void> delByIds(@RequestParam(value = "memberIds") Long[] memberIds){
		memberService.delByIds(memberIds);
		return Results.ok("删除成功");
	}

}
