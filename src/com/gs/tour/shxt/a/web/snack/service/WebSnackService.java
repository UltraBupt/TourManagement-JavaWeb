package com.gs.tour.shxt.a.web.snack.service;

import java.util.List;

import com.gs.tour.shxt.a.web.snack.dao.WebSnackDao;
import com.gs.tour.shxt.snack.model.Snack;

public class WebSnackService {
	WebSnackDao webSnackDao=new WebSnackDao();
	/**获取信息*/
	public List<Snack> getSnackList(){
		return this.webSnackDao.getSnackList();
	}
	/**根据小吃id获取小吃*/
	public Snack querySnackBySnackId(Integer snack_id){
		return this.webSnackDao.querySnackBySnackId(snack_id);
	}
}
