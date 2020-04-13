package com.gs.tour.shxt.profit.dao;

import java.util.List;
import java.util.Map;

import com.gs.tour.shxt.base.util.DBUtil;

public class ProfitDao {
	/**获得周边游利润*/
	public double getAroundTourismProfit(){
		String sql="select * from bill where bill_type ='周边游' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double aroundTourismProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			aroundTourismProfit=aroundTourismProfit+temp;
		}
		return aroundTourismProfit;
	}
	/**获取国内游利润*/
	public double getInboundTourismProfit(){
		String sql="select * from bill where bill_type ='国内游' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double inboundTourismProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			inboundTourismProfit=inboundTourismProfit+temp;
		}
		return inboundTourismProfit;
	}
	/**获取海外游利润*/
	public double getOutboundTourismProfit(){
		String sql="select * from bill where bill_type ='海外游' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double outboundTourismProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			outboundTourismProfit=outboundTourismProfit+temp;
		}
		return outboundTourismProfit;
	}
	/**获取保险利润*/
	public double getInsuranceProfit(){
		String sql="select * from bill where bill_type ='保险' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double insuranceProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			insuranceProfit=insuranceProfit+temp;
		}
		return insuranceProfit;
	}
	/**获取签证利润*/
	public double getVisaProfit(){
		String sql="select * from bill where bill_type ='签证' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double visaProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			visaProfit=visaProfit+temp;
		}
		return visaProfit;
	}
	/**获取金融利润*/
	public double getFinanceProfit(){
		String sql="select * from bill where bill_type ='金融' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double financeProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			financeProfit=financeProfit+temp;
		}
		return financeProfit;
	}
	/**获取小吃利润*/
	public double getSnackProfit(){
		String sql="select * from bill where bill_type ='小吃' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double snackProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			snackProfit=snackProfit+temp;
		}
		return snackProfit;
	}
	/**获取快餐利润*/
	public double getQuickProfit(){
		String sql="select * from bill where bill_type ='快餐' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double quickProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			quickProfit=quickProfit+temp;
		}
		return quickProfit;
	}
	/**获取自助利润*/
	public double getBuffetProfit(){
		String sql="select * from bill where bill_type ='自助' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double buffetProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			buffetProfit=buffetProfit+temp;
		}
		return buffetProfit;
	}
	/**获取主题利润*/
	public double getThemedProfit(){
		String sql="select * from bill where bill_type ='主题' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double themedProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			themedProfit=themedProfit+temp;
		}
		return themedProfit;
	}
	/**获取西式利润*/
	public double getWesternProfit(){
		String sql="select * from bill where bill_type ='西式' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double westernProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			westernProfit=westernProfit+temp;
		}
		return westernProfit;
	}
	/**获取假日酒店利润*/
	public double getHolidayProfit(){
		String sql="select * from bill where bill_type ='假日酒店' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double holidayProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			holidayProfit=holidayProfit+temp;
		}
		return holidayProfit;
	}
	/**获取公寓利润*/
	public double getApartmentProfit(){
		String sql="select * from bill where bill_type ='公寓' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double apartmentProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			apartmentProfit=apartmentProfit+temp;
		}
		return apartmentProfit;
	}
	/**获取别墅利润*/
	public double getVillaProfit(){
		String sql="select * from bill where bill_type ='别墅' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double villaProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			villaProfit=villaProfit+temp;
		}
		return villaProfit;
	}
	/**获取农家乐利润*/
	public double getAgricolaProfit(){
		String sql="select * from bill where bill_type ='农家乐' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double agricolaProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			agricolaProfit=agricolaProfit+temp;
		}
		return agricolaProfit;
	}
	/**获取快捷酒店利润*/
	public double getHotelProfit(){
		String sql="select * from bill where bill_type ='快捷酒店' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double hotelProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			hotelProfit=hotelProfit+temp;
		}
		return hotelProfit;
	}
	/**获取机票利润*/
	public double getAirlineProfit(){
		String sql="select * from bill where bill_type ='机票' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double airlineProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			airlineProfit=airlineProfit+temp;
		}
		return airlineProfit;
	}
	/**获取火车票利润*/
	public double getTrainProfit(){
		String sql="select * from bill where bill_type ='火车票' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double trainProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			trainProfit=trainProfit+temp;
		}
		return trainProfit;
	}
	/**获取轮船票利润*/
	public double getShipProfit(){
		String sql="select * from bill where bill_type ='轮船票' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double shipProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			shipProfit=shipProfit+temp;
		}
		return shipProfit;
	}
	/**获取汽车票利润*/
	public double getBusProfit(){
		String sql="select * from bill where bill_type ='汽车票' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double busProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			busProfit=busProfit+temp;
		}
		return busProfit;
	}
	/**获取动车票利润*/
	public double getFasterProfit(){
		String sql="select * from bill where bill_type ='动车票' and bill_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double fasterProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("bill_totalPrice").toString());
			fasterProfit=fasterProfit+temp;
		}
		return fasterProfit;
	}
	/**获取广告利润*/
	public double getAdvertisementProfit(){
		String sql="select * from advertisementbenefit ";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double advertisementProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("advertisementBenefit_benefit").toString());
			advertisementProfit=advertisementProfit+temp;
		}
		return advertisementProfit;
	}
	/**获取招聘利润*/
	public double getRecruitProfit(){
		String sql="select * from recruitbenefit ";
		List<Map<String,Object>> list=DBUtil.list(sql);
		double recruitProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("recruitBenefit_benefit").toString());
			recruitProfit=recruitProfit+temp;
		}
		return recruitProfit;
	}

	
}
