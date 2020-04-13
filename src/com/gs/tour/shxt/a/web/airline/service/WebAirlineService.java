package com.gs.tour.shxt.a.web.airline.service;

import java.util.List;

import com.gs.tour.shxt.a.web.airline.dao.WebAirlineDao;
import com.gs.tour.shxt.airline.model.Airline;

public class WebAirlineService {
	WebAirlineDao webAirlineDao=new WebAirlineDao();
	/**获取信息*/
	public List<Airline> getAirlineList(){
		return this.webAirlineDao.getAirlineList();
	}
	/**根据机票id获取机票*/
	public Airline queryAirlineByAirlineId(Integer airline_id){
		return this.webAirlineDao.queryAirlineByAirlineId(airline_id);
	}
}
