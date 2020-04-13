package com.gs.tour.shxt.leave.service;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.leave.dao.LeaveDao;
import com.gs.tour.shxt.leave.model.Leave;
import com.gs.tour.shxt.user.model.User;

public class LeaveService {
	LeaveDao leaveDao=new LeaveDao();
	/**查询请假列表*/
	public PageBean getAllLeaveList(Leave leave,PageBean pageBean){
		return this.leaveDao.getAllLeaveList(leave, pageBean);
	}
	/**更新*/
	public Leave load(Integer leave_id){
		Leave leave;
		try {
			leave=this.leaveDao.load(leave_id);
			return leave;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**处理假条*/
	public void operator(Leave leave){
		this.leaveDao.operator(leave);
	}
	/**创建假条
	 * @throws Exception */
	public void addLeave(Leave leave,User user) throws Exception{
		Integer num=this.leaveDao.addLeave(leave, user);
		if(num<=0){
			throw new Exception("创建假条失败");
		}
	}
}
