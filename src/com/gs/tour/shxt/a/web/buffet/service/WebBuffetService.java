package com.gs.tour.shxt.a.web.buffet.service;

import java.util.List;

import com.gs.tour.shxt.a.web.buffet.dao.WebBuffetDao;
import com.gs.tour.shxt.a.web.buffet.model.Buffet;

public class WebBuffetService {
	WebBuffetDao webBuffetDao=new WebBuffetDao();
	/**获取信息*/
	public List<Buffet> getBuffetList(){
		return this.webBuffetDao.getBuffetList();
	}
	/**根据自助id获取自助*/
	public Buffet queryBuffetByBuffetId(Integer buffet_id){
		return this.webBuffetDao.queryBuffetByBuffetId(buffet_id);
	}
}
