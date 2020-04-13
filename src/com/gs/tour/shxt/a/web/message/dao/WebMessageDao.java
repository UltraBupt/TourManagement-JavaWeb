package com.gs.tour.shxt.a.web.message.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.gs.tour.shxt.a.web.login.model.Member;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebMessageDao {
	/**添加留言信息*/
	public Integer addMessage(Member member,String newMessage){
		String sql="insert into newmessage (newMessage_desc,newMessage_createDate,newMessageMember_name,newMessageMember_account) values(?,?,?,?)";
		Date date=new Date();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String newMessage_createDate=s.format(date);
		return DBUtil.executeUpdate(sql, new Object[]{
				newMessage.trim(),
				newMessage_createDate,
				member.getMember_name(),
				member.getMember_account()
		});
	}
}
