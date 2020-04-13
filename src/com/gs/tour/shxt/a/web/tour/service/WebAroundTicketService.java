package com.gs.tour.shxt.a.web.tour.service;

import java.util.List;

import com.gs.tour.shxt.a.web.tour.dao.WebAroundTicketDao;
import com.gs.tour.shxt.a.web.tour.model.AroundTicket;

public class WebAroundTicketService {
	WebAroundTicketDao webAroundTicketDao=new WebAroundTicketDao();
	/**获取周围景点门票信息*/
	public List<AroundTicket> getAroundTicketList(){
		return this.webAroundTicketDao.getAroundTicketList();
	}
}
