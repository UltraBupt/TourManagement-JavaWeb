package com.gs.tour.shxt.a.web.tour.service;

import java.util.List;

import com.gs.tour.shxt.a.web.tour.dao.WebInboundHotTourismDao;
import com.gs.tour.shxt.a.web.tour.model.InboundTourism;

public class WebInboundHotTourismService {
	WebInboundHotTourismDao webInboundHotTourismDao=new WebInboundHotTourismDao();
	/**获取热门景点信息*/
	public List<InboundTourism> getInboundTourismList(){
		return this.webInboundHotTourismDao.getInboundTourismList();
	}
}
