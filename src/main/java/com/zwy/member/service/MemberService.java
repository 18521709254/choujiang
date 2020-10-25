package com.zwy.member.service;
import com.zwy.member.model.Member;

import java.util.List;

/**
 * 类 名: MemberService
 * 描 述: 会员事物层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
public interface MemberService {


	/**
	 * 描 述： 分页查询会员
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param member 会员
	 */
	List<Member> listMemberAll();

	/**
	 * 描 述： 保存会员
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param member 会员
	 */
	void save(Member member);

	/**
	 * 描 述： 根据ID删除会员
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 会员ID数组
	 */
	void delByIds(Long[] ids);
}
