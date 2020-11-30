package com.zwy.member.dao;

import com.zwy.member.model.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类 名: IMemberDao
 * 描 述: 会员数据连接层
 * 作 者: 张文雅
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Repository("memberDaoImpl")
public interface IMemberDao {

	/**
	 * 描 述： 查询全部会员
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @return 会员列表
	 */
	List<Member> listMemberAll();

	/**
	 * 描 述： 分页查询会员
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param item 会员
	 */
	List<Member> listMemberByPage(Member item);

	/**
	 * 描 述： 根据ID查询会员
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param memberId 会员ID
	 * @return 会员数据
	 */
	Member getMemberById(Long memberId);

	/**
	 * 描 述： 新增用户
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param member 用户信息
	 */
	void add(Member member);

	/**
	 * 描 述： 修改用户
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param member 用户信息
	 */
	void update(Member member);

	/**
	 * 描 述： 删除用户
	 * 作 者： 张文雅
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 用户ID数组
	 */
	void delByIds(Long[] ids);


}
