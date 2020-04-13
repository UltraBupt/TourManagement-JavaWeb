package com.gs.tour.shxt.a.web.message.service;

import com.gs.tour.shxt.a.web.login.model.Member;
import com.gs.tour.shxt.a.web.message.dao.WebMessageDao;

public class WebMessageService {
	WebMessageDao webMessageDao=new WebMessageDao();
	/**添加留言信息
	 * @throws Exception */
	public void addMessage(Member member,String newMessage) throws Exception{
		Integer num=this.webMessageDao.addMessage(member, newMessage);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
}
