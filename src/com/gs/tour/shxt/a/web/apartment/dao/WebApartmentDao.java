package com.gs.tour.shxt.a.web.apartment.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.apartment.model.Apartment;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebApartmentDao {
	/**获取信息*/
	public List<Apartment> getApartmentList(){
		String sql="select * from apartment where apartment_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Apartment> apartmentList=new ArrayList<Apartment>();
			for (Map<String,Object> map : list) {
				Apartment a=new Apartment();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				apartmentList.add(a);
			}
			return apartmentList;
		}else{
			return null;
		}
	}
	/**根据公寓id获取公寓*/
	public Apartment queryApartmentByApartmentId(Integer apartment_id){
		String sql="select * from apartment where apartment_id=?";
		Map<String,Object> map=DBUtil.query(sql,apartment_id);
		if(map!=null&&map.size()>0){
			Apartment apartment=new Apartment();
			try {
				BeanUtils.populate(apartment, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return apartment;
		}else{
			return null;
		}
	}
}
