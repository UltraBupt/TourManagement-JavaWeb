package com.gs.tour.shxt.a.web.tour.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.aroundtourism.model.AroundTourism;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebAroundHotTourismDao {
	/**获取热门景点信息*/
	public List<AroundTourism> getAroundTourismList(){
		String sql="select * from aroundTourism";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<AroundTourism> aroundTourismList=new ArrayList<AroundTourism>();
			for (Map<String,Object> map : list) {
				AroundTourism a=new AroundTourism();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				aroundTourismList.add(a);
			}
			return aroundTourismList;
		}else{
			return null;
		}
	}
}
