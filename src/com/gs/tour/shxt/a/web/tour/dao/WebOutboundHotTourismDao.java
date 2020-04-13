package com.gs.tour.shxt.a.web.tour.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.a.web.tour.model.OutboundTourism;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebOutboundHotTourismDao {
	/**获取热门景点信息*/
	public List<OutboundTourism> getOutboundTourismList(){
		String sql="select * from outboundtourism";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<OutboundTourism> outboundTourismList=new ArrayList<OutboundTourism>();
			for (Map<String,Object> map : list) {
				OutboundTourism o=new OutboundTourism();
				try {
					BeanUtils.populate(o, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				outboundTourismList.add(o);
			}
			return outboundTourismList;
		}else{
			return null;
		}
	}
}
