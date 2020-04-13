package com.gs.tour.shxt.a.web.villa.service;

import java.util.List;

import com.gs.tour.shxt.a.web.villa.dao.WebVillaDao;
import com.gs.tour.shxt.villa.model.Villa;

public class WebVillaService {
	WebVillaDao webVillaDao=new WebVillaDao();
	/**获取信息*/
	public List<Villa> getVillaList(){
		return this.webVillaDao.getVillaList();
	}
	/**根据别墅id获取别墅*/
	public Villa queryVillaByVillaId(Integer villa_id){
		return this.webVillaDao.queryVillaByVillaId(villa_id);
	}
}
