package com.gs.tour.shxt.a.web.insurance.service;

import java.util.List;

import com.gs.tour.shxt.a.web.insurance.dao.WebInsuranceDao;
import com.gs.tour.shxt.insurance.model.Insurance;

public class WebInsuranceService {
	WebInsuranceDao webInsuranceDao=new WebInsuranceDao();
	/**获取保险信息*/
	public List<Insurance> getInsuranceList(){
		return this.webInsuranceDao.getInsuranceList();
	}
	/**根据保单id获取保单*/
	public Insurance queryInsuranceByInsuranceId(Integer insurance_id){
		return this.webInsuranceDao.queryInsuranceByInsuranceId(insurance_id);
	}
}
