package com.gs.tour.shxt.a.web.tour.service;

import java.util.List;

import com.gs.tour.shxt.a.web.tour.dao.WebOutboundTicketDao;
import com.gs.tour.shxt.a.web.tour.model.OutboundTicket;

public class WebOutboundTicketService {
	WebOutboundTicketDao webOutboundTicketDao=new WebOutboundTicketDao();
	/**获取国外景点门票信息*/
	public List<OutboundTicket> getOutboundTicketList(){
		return this.webOutboundTicketDao.getOutboundTicketList();
	}
}
