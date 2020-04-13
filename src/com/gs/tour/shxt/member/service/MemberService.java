package com.gs.tour.shxt.member.service;


import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.member.dao.MemberDao;
import com.gs.tour.shxt.member.model.Member;

public class MemberService {
	MemberDao memberDao=new MemberDao();
	/**查询会员列表*/
	public PageBean getAllMemberList(Member member,PageBean pageBean){
		return this.memberDao.getAllMemberList(member, pageBean);
	}
	/**更改会员状态*/
	public Integer updateStatus(Integer member_id) throws Exception {
		Member member = this.memberDao.queryMemberByMemberId(member_id);
		Integer member_status =member.getMember_status();
		if(member_status==1){
			member_status=0;
		}else{
			member_status=1;
		}
		this.memberDao.updateStatus(member_id, member_status);
		return member_status;
	}
}
