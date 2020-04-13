package com.gs.tour.shxt.a.web.tour.service;

import java.util.List;

import com.gs.tour.shxt.a.web.tour.dao.WebOutboundHotTourismDao;
import com.gs.tour.shxt.a.web.tour.model.OutboundTourism;

public class WebOutboundHotTourismService {
	WebOutboundHotTourismDao webOutboundHotTourismDao=new WebOutboundHotTourismDao();
	/**获取热门景点信息*/
	public List<OutboundTourism> getOutboundTourismList(){
		return this.webOutboundHotTourismDao.getOutboundTourismList();
	}
}
