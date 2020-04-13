package com.gs.tour.shxt.sumprofit.service;

import com.gs.tour.shxt.sumprofit.dao.SumProfitDao;

public class SumProfitService {
	SumProfitDao sumProfitDao=new SumProfitDao();
	/**计算总利润*/
	public double getSumProfit(){
		return this.sumProfitDao.getSumProfit();
	}
}
