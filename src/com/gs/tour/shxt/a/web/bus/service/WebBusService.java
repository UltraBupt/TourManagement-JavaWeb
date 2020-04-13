package com.gs.tour.shxt.a.web.bus.service;

import java.util.List;

import com.gs.tour.shxt.a.web.bus.dao.WebBusDao;
import com.gs.tour.shxt.bus.model.Bus;

public class WebBusService {
	WebBusDao webBusDao=new WebBusDao();
	/**获取信息*/
	public List<Bus> getBusList(){
		return this.webBusDao.getBusList();
	}
	/**根据汽车票id获取汽车票*/
	public Bus queryBusByBusId(Integer bus_id){
		return this.webBusDao.queryBusByBusId(bus_id);
	}
}
