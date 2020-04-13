package com.gs.tour.shxt.a.web.finance.service;

import java.util.List;

import com.gs.tour.shxt.a.web.finance.dao.WebFinanceDao;
import com.gs.tour.shxt.finance.model.Finance;

public class WebFinanceService {
	WebFinanceDao webFinanceDao=new WebFinanceDao();
	/**获取信息*/
	public List<Finance> getFinanceList(){
		return this.webFinanceDao.getFinanceList();
	}
	/**根据金融id获取金融*/
	public Finance queryFinanceByFinanceId(Integer finance_id){
		return this.webFinanceDao.queryFinanceByFinanceId(finance_id);
	}
}
