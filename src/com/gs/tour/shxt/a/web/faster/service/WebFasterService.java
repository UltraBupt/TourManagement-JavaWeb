package com.gs.tour.shxt.a.web.faster.service;

import java.util.List;

import com.gs.tour.shxt.a.web.faster.dao.WebFasterDao;
import com.gs.tour.shxt.faster.model.Faster;

public class WebFasterService {
	WebFasterDao webFasterDao=new WebFasterDao();
	/**获取信息*/
	public List<Faster> getFasterList(){
		return this.webFasterDao.getFasterList();
	}
	/**根据动车票id获取动车票*/
	public Faster queryFasterByFasterId(Integer faster_id){
		return this.webFasterDao.queryFasterByFasterId(faster_id);
	}
}
