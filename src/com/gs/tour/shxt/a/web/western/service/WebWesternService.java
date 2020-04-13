package com.gs.tour.shxt.a.web.western.service;

import java.util.List;

import com.gs.tour.shxt.a.web.western.dao.WebWesternDao;
import com.gs.tour.shxt.western.model.Western;


public class WebWesternService {
	WebWesternDao webWesternDao=new WebWesternDao();
	/**获取信息*/
	public List<Western> getWesternList(){
		return this.webWesternDao.getWesternList();
	}
	/**根据西式id获取西式*/
	public Western queryWesternByWesternId(Integer western_id){
		return this.webWesternDao.queryWesternByWesternId(western_id);
	}
}
