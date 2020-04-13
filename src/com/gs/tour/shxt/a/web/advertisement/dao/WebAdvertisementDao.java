package com.gs.tour.shxt.a.web.advertisement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.a.web.advertisement.model.Advertisement;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebAdvertisementDao {
	/**获取广告*/
	public List<Advertisement> getAdvertisement(){
		String sql="select * from advertisement";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Advertisement> advertisementList=new ArrayList<Advertisement>();
			for (Map<String,Object> map : list) {
				Advertisement a=new Advertisement();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				advertisementList.add(a);
			}
			return advertisementList;
		}else{
			return null;
		}
	}
}
