package com.gs.tour.shxt.a.web.airline.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.airline.model.Airline;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebAirlineDao {
	/**获取信息*/
	public List<Airline> getAirlineList(){
		String sql="select * from airline where airline_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Airline> airlineList=new ArrayList<Airline>();
			for (Map<String,Object> map : list) {
				Airline a=new Airline();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				airlineList.add(a);
			}
			return airlineList;
		}else{
			return null;
		}
	}
	/**根据机票id获取机票*/
	public Airline queryAirlineByAirlineId(Integer airline_id){
		String sql="select * from airline where airline_id=?";
		Map<String,Object> map=DBUtil.query(sql,airline_id);
		if(map!=null&&map.size()>0){
			Airline airline=new Airline();
			try {
				BeanUtils.populate(airline, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return airline;
		}else{
			return null;
		}
	}
}
