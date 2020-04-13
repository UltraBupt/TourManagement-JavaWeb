package com.gs.tour.shxt.a.web.apartment.service;

import java.util.List;

import com.gs.tour.shxt.a.web.apartment.dao.WebApartmentDao;
import com.gs.tour.shxt.apartment.model.Apartment;

public class WebApartmentService {
	WebApartmentDao webApartmentDao=new WebApartmentDao();
	/**获取信息*/
	public List<Apartment> getApartmentList(){
		return this.webApartmentDao.getApartmentList();
	}
	/**根据公寓id获取公寓*/
	public Apartment queryApartmentByApartmentId(Integer apartment_id){
		return this.webApartmentDao.queryApartmentByApartmentId(apartment_id);
	}
}
