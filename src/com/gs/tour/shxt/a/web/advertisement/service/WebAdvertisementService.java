package com.gs.tour.shxt.a.web.advertisement.service;

import java.util.List;

import com.gs.tour.shxt.a.web.advertisement.dao.WebAdvertisementDao;
import com.gs.tour.shxt.a.web.advertisement.model.Advertisement;

public class WebAdvertisementService {
	WebAdvertisementDao webAdvertisementDao=new WebAdvertisementDao();
	/**获取广告*/
	public List<Advertisement> getAdvertisement(){
		return this.webAdvertisementDao.getAdvertisement();
	}
}
