package com.gs.tour.shxt.a.web.register.service;

import com.gs.tour.shxt.a.web.register.dao.WebRegisterDao;
import com.gs.tour.shxt.a.web.register.model.Member;

public class WebRegisterService {
	WebRegisterDao webRegisterDao=new WebRegisterDao();
	/**验证账号是否重复
	 * @throws Exception */
	public void checkMemberAccount(String member_account) throws Exception{
		Integer num=this.webRegisterDao.checkMemberAccount(member_account);
		if(num>0){
			throw new Exception("该会员账号已存在，请重新输入");
		}
	}
	/**添加会员
	 * @throws Exception */
	public void addMember(Member member) throws Exception{
		Integer num=this.webRegisterDao.addMember(member);
		if(num<=0){
			throw new Exception("注册失败");
		}
	}
}
