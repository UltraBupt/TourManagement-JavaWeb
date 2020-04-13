package com.gs.tour.shxt.a.web.tour.service;

import java.util.List;

import com.gs.tour.shxt.a.web.tour.dao.WebAroundHotTourismDao;
import com.gs.tour.shxt.aroundtourism.model.AroundTourism;

public class WebAroundHotTourismService {
	WebAroundHotTourismDao webAroundHotTourismDao=new WebAroundHotTourismDao();
	/**获取热门景点信息*/
	public List<AroundTourism> getAroundTourismList(){
		return this.webAroundHotTourismDao.getAroundTourismList();
	}
} 
