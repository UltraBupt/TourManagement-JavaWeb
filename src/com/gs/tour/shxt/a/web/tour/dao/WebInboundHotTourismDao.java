package com.gs.tour.shxt.a.web.tour.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.a.web.tour.model.InboundTourism;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebInboundHotTourismDao {
	/**获取热门景点信息*/
	public List<InboundTourism> getInboundTourismList(){
		String sql="select * from inboundtourism";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<InboundTourism> inboundTourismList=new ArrayList<InboundTourism>();
			for (Map<String,Object> map : list) {
				InboundTourism i=new InboundTourism();
				try {
					BeanUtils.populate(i, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				inboundTourismList.add(i);
			}
			return inboundTourismList;
		}else{
			return null;
		}
	}
}
