package com.gs.tour.shxt.a.web.visa.service;

import java.util.List;

import com.gs.tour.shxt.a.web.visa.dao.WebVisaDao;
import com.gs.tour.shxt.visa.model.Visa;

public class WebVisaService {
	WebVisaDao webVisaDao=new WebVisaDao();
	/**获取签证信息*/
	public List<Visa> getVisaList(){
		return this.webVisaDao.getVisaList();
	}
	/**根据签证id获取签证*/
	public Visa queryVisaByVisaId(Integer visa_id){
		return this.webVisaDao.queryVisaByVisaId(visa_id);
	}
}
