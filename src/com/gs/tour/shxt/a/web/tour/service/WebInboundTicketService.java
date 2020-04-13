package com.gs.tour.shxt.a.web.tour.service;

import java.util.List;

import com.gs.tour.shxt.a.web.tour.dao.WebInboundTicketDao;
import com.gs.tour.shxt.a.web.tour.model.InboundTicket;

public class WebInboundTicketService {
	WebInboundTicketDao webInboundTicketDao=new WebInboundTicketDao();
	/**获取国内景点门票信息*/
	public List<InboundTicket> getInboundTicketList(){
		return this.webInboundTicketDao.getInboundTicketList();
	}
}
