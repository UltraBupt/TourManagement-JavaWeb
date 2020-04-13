package com.gs.tour.shxt.a.web.bus.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.bus.model.Bus;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebBusDao {
	/**获取信息*/
	public List<Bus> getBusList(){
		String sql="select * from bus where bus_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Bus> busList=new ArrayList<Bus>();
			for (Map<String,Object> map : list) {
				Bus a=new Bus();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				busList.add(a);
			}
			return busList;
		}else{
			return null;
		}
	}
	/**根据汽车票id获取汽车票*/
	public Bus queryBusByBusId(Integer bus_id){
		String sql="select * from bus where bus_id=?";
		Map<String,Object> map=DBUtil.query(sql,bus_id);
		if(map!=null&&map.size()>0){
			Bus bus=new Bus();
			try {
				BeanUtils.populate(bus, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bus;
		}else{
			return null;
		}
	}
}
