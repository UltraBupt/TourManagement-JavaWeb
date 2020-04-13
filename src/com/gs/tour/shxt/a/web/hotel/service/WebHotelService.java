package com.gs.tour.shxt.a.web.hotel.service;

import java.util.List;

import com.gs.tour.shxt.a.web.hotel.dao.WebHotelDao;
import com.gs.tour.shxt.hotel.model.Hotel;

public class WebHotelService {
	WebHotelDao webHotelDao=new WebHotelDao();
	/**获取信息*/
	public List<Hotel> getHotelList(){
		return this.webHotelDao.getHotelList();
	}
	/**根据快捷酒店id获取快捷酒店*/
	public Hotel queryHotelByHotelId(Integer hotel_id){
		return this.webHotelDao.queryHotelByHotelId(hotel_id);
	}
}
