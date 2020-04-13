package com.gs.tour.shxt.a.web.tour.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.a.web.tour.model.AroundTicket;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebAroundTicketDao {
	/**获取周围景点门票信息*/
	public List<AroundTicket> getAroundTicketList(){
		String sql="select * from aroundTicket";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<AroundTicket> aroundTicketList=new ArrayList<AroundTicket>();
			for (Map<String,Object> map : list) {
				AroundTicket a=new AroundTicket();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				aroundTicketList.add(a);
			}
			return aroundTicketList;
		}else{
			return null;
		}
	}
}
