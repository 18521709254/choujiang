package com.zwy.member.service.impl;

import com.zwy.member.dao.IMemberDao;
import com.zwy.member.model.Member;
import com.zwy.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类 名: MemberServiceImpl
 * 描 述: 会员事物实现
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Slf4j
@Service("memberServiceImpl")
@Transactional(value = "transactionManager",rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {

	@Resource(name = "memberDaoImpl")
	private IMemberDao memberDao;

	/**
	 * 描 述： 分页查询会员
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param member 会员
	 */
	@Override
	public List<Member> listMemberAll() {
		return memberDao.listMemberAll();
	}

	/**
	 * 描 述： 保存会员
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param member 会员
	 */
	@Override
	public void save(Member member) {
		// ID 不存在新增
		if(member.getId() == null){
			memberDao.add(member);
			return;
		}
		// 反之修改
		memberDao.update(member);
	}

	/**
	 * 描 述： 根据ID删除会员
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param ids 会员ID数组
	 */
	@Override
	public void delByIds(Long[] ids) {
		memberDao.delByIds(ids);
	}
}
