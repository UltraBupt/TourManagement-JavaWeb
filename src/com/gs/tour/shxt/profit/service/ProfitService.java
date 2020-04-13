package com.gs.tour.shxt.profit.service;

import com.gs.tour.shxt.profit.dao.ProfitDao;

public class ProfitService {
	ProfitDao profitDao=new ProfitDao();
	/**获得周边游利润*/
	public double getAroundTourismProfit(){
		return this.profitDao.getAroundTourismProfit();
	}
	/**获取国内游利润*/
	public double getInboundTourismProfit(){
		return this.profitDao.getInboundTourismProfit();
	}
	/**获取海外游利润*/
	public double getOutboundTourismProfit(){
		return this.profitDao.getOutboundTourismProfit();
	}
	/**获取保险利润*/
	public double getInsuranceProfit(){
		return this.profitDao.getInsuranceProfit();
	}
	/**获取签证利润*/
	public double getVisaProfit(){
		return this.profitDao.getVisaProfit();
	}
	/**获取金融利润*/
	public double getFinanceProfit(){
		return this.profitDao.getFinanceProfit();
	}
	/**获取小吃利润*/
	public double getSnackProfit(){
		return this.profitDao.getSnackProfit();
	}
	/**获取快餐利润*/
	public double getQuickProfit(){
		return this.profitDao.getQuickProfit();
	}
	/**获取自助利润*/
	public double getBuffetProfit(){
		return this.profitDao.getBuffetProfit();
	}
	/**获取主题利润*/
	public double getThemedProfit(){
		return this.profitDao.getThemedProfit();
	}
	/**获取西式利润*/
	public double getWesternProfit(){
		return this.profitDao.getWesternProfit();
	}
	/**获取假日酒店利润*/
	public double getHolidayProfit(){
		return this.profitDao.getHolidayProfit();
	}
	/**获取公寓利润*/
	public double getApartmentProfit(){
		return this.profitDao.getApartmentProfit();
	}
	/**获取别墅利润*/
	public double getVillaProfit(){
		return this.profitDao.getVillaProfit();
	}
	/**获取农家乐利润*/
	public double getAgricolaProfit(){
		return this.profitDao.getAgricolaProfit();
	}
	/**获取快捷酒店利润*/
	public double getHotelProfit(){
		return this.profitDao.getHotelProfit();
	}
	/**获取机票利润*/
	public double getAirlineProfit(){
		return this.profitDao.getAirlineProfit();
	}
	/**获取火车票利润*/
	public double getTrainProfit(){
		return this.profitDao.getTrainProfit();
	}
	/**获取轮船票利润*/
	public double getShipProfit(){
		return this.profitDao.getShipProfit();
	}
	/**获取汽车票利润*/
	public double getBusProfit(){
		return this.profitDao.getBusProfit();
	}
	/**获取动车票利润*/
	public double getFasterProfit(){
		return this.profitDao.getFasterProfit();
	}
	/**获取广告利润*/
	public double getAdvertisementProfit(){
		return this.profitDao.getAdvertisementProfit();
	}
	/**获取招聘利润*/
	public double getRecruitProfit(){
		return this.profitDao.getRecruitProfit();
	}
}
