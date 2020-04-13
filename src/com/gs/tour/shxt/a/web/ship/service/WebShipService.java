package com.gs.tour.shxt.a.web.ship.service;

import java.util.List;

import com.gs.tour.shxt.a.web.ship.dao.WebShipDao;
import com.gs.tour.shxt.ship.model.Ship;

public class WebShipService {
	WebShipDao webShipDao=new WebShipDao();
	/**获取信息*/
	public List<Ship> getShipList(){
		return this.webShipDao.getShipList();
	}
	/**根据轮船票id获取轮船票*/
	public Ship queryShipByShipId(Integer ship_id){
		return this.webShipDao.queryShipByShipId(ship_id);
	}
}
