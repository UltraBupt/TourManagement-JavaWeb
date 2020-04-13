package com.gs.tour.shxt.a.web.agricola.service;

import java.util.List;

import com.gs.tour.shxt.a.web.agricola.dao.WebAgricolaDao;
import com.gs.tour.shxt.agricola.model.Agricola;

public class WebAgricolaService {
	WebAgricolaDao webAgricolaDao=new WebAgricolaDao();
	/**获取信息*/
	public List<Agricola> getAgricolaList(){
		return this.webAgricolaDao.getAgricolaList();
	}
	/**根据小吃id获取小吃*/
	public Agricola queryAgricolaByAgricolaId(Integer agricola_id){
		return this.webAgricolaDao.queryAgricolaByAgricolaId(agricola_id);
	}
}
