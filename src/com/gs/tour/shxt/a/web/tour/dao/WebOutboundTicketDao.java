package com.gs.tour.shxt.a.web.tour.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.a.web.tour.model.OutboundTicket;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebOutboundTicketDao {
	/**获取国外景点门票信息*/
	public List<OutboundTicket> getOutboundTicketList(){
		String sql="select * from outboundticket";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<OutboundTicket> outboundTicketList=new ArrayList<OutboundTicket>();
			for (Map<String,Object> map : list) {
				OutboundTicket o=new OutboundTicket();
				try {
					BeanUtils.populate(o, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				outboundTicketList.add(o);
			}
			return outboundTicketList;
		}else{
			return null;
		}
	}
}
