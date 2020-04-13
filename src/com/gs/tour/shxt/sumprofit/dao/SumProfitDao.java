package com.gs.tour.shxt.sumprofit.dao;

import java.util.List;
import java.util.Map;

import com.gs.tour.shxt.base.util.DBUtil;

public class SumProfitDao {
	/**计算总利润*/
	public double getSumProfit(){
		String sql="select * from bill where  bill_status=1";
		List<Map<String,Object>> list1=DBUtil.list(sql);
		double sumProfit1 = 0;
		for(int i=0;i<list1.size();i++){
			double temp=Double.parseDouble(list1.get(i).get("bill_totalPrice").toString());
			sumProfit1=sumProfit1+temp;
		}
		String sql1="select * from advertisementbenefit ";
		List<Map<String,Object>> list=DBUtil.list(sql1);
		double advertisementProfit = 0;
		for(int i=0;i<list.size();i++){
			double temp=Double.parseDouble(list.get(i).get("advertisementBenefit_benefit").toString());
			advertisementProfit=advertisementProfit+temp;
		}
		String sql2="select * from recruitbenefit ";
		List<Map<String,Object>> list2=DBUtil.list(sql2);
		double recruitProfit = 0;
		for(int i=0;i<list2.size();i++){
			double temp=Double.parseDouble(list2.get(i).get("recruitBenefit_benefit").toString());
			recruitProfit=recruitProfit+temp;
		}
		double sum=sumProfit1+advertisementProfit+recruitProfit;
		return sum;
	}
}
