package com.gs.tour.shxt.a.web.tour.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.a.web.tour.model.InboundTicket;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebInboundTicketDao {
	/**获取国内景点门票信息*/
	public List<InboundTicket> getInboundTicketList(){
		String sql="select * from inboundticket";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<InboundTicket> inboundTicketList=new ArrayList<InboundTicket>();
			for (Map<String,Object> map : list) {
				InboundTicket i=new InboundTicket();
				try {
					BeanUtils.populate(i, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				inboundTicketList.add(i);
			}
			return inboundTicketList;
		}else{
			return null;
		}
	}
}
