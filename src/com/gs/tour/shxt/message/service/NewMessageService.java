package com.gs.tour.shxt.message.service;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.message.dao.NewMessageDao;
import com.gs.tour.shxt.message.model.NewMessage;

public class NewMessageService {
	NewMessageDao newMessageDao=new NewMessageDao();
	/**查询留言列表*/
	public PageBean getAllNewMessageList(NewMessage newMessage,PageBean pageBean){
		return this.newMessageDao.getAllNewMessageList(newMessage, pageBean);
	}
	/**根据留言id获取留言*/
	public NewMessage queryNewMessageByNewMessageId(Integer newMessage_id){
		return this.newMessageDao.queryNewMessageByNewMessageId(newMessage_id);
	}
	/**更改留言状态*/
	public Integer updateStatus(Integer newMessage_id) throws Exception {
		NewMessage newMessage = this.newMessageDao.queryNewMessageByNewMessageId(newMessage_id);
		Integer newMessage_status = newMessage.getNewMessage_status();
		if(newMessage_status==1){
			newMessage_status=0;
		}else{
			newMessage_status=1;
		}
		this.newMessageDao.updateStatus(newMessage_id, newMessage_status);
		return newMessage_status;
	}
}
