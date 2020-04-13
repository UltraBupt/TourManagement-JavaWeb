package com.gs.tour.shxt.a.web.register.dao;

import com.gs.tour.shxt.a.web.register.model.Member;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebRegisterDao {
	/**验证账号是否重复*/
	public Integer checkMemberAccount(String member_account){
		String sql="select count(1) as num from member where member_account=?";
		Integer num=Integer.parseInt(DBUtil.query(sql, member_account.trim()).get("num").toString());
		return num;
	}
	/**添加会员*/
	public Integer addMember(Member member){
		String member_type="青铜";
		String sql="insert into member (member_name,member_account,member_password,member_type) values (?,?,?,?)";
		return DBUtil.executeUpdate(sql,new Object[]{
				member.getMember_name().trim(),
				member.getMember_account().trim(),
				member.getMember_password().trim(),
				member_type
		});
	}
}
