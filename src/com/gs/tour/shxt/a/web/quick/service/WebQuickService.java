package com.gs.tour.shxt.a.web.quick.service;

import java.util.List;

import com.gs.tour.shxt.a.web.quick.dao.WebQuickDao;
import com.gs.tour.shxt.quick.model.Quick;

public class WebQuickService {
	WebQuickDao webQuickDao=new WebQuickDao();
	/**获取信息*/
	public List<Quick> getQuickList(){
		return this.webQuickDao.getQuickList();
	}
	/**根据小吃id获取小吃*/
	public Quick queryQuickByQuickId(Integer quick_id){
		return this.webQuickDao.queryQuickByQuickId(quick_id);
	}
}
