package com.gs.tour.shxt.login_record.service;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.login_record.dao.LoginRecordDao;
import com.gs.tour.shxt.login_record.model.LoginRecord;

public class LoginRecordService {
	LoginRecordDao loginRecordDao=new LoginRecordDao();
	/**查询登陆日志*/
	public PageBean getAllLoginRecoerdList(LoginRecord loginRecord,PageBean pageBean){
		return this.loginRecordDao.getAllLoginRecoerdList(loginRecord, pageBean);
	}
}
