package com.gs.tour.shxt.a.web.hotel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.hotel.model.Hotel;

public class WebHotelDao {
	/**获取信息*/
	public List<Hotel> getHotelList(){
		String sql="select * from hotel where hotel_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Hotel> hotelList=new ArrayList<Hotel>();
			for (Map<String,Object> map : list) {
				Hotel h=new Hotel();
				try {
					BeanUtils.populate(h, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				hotelList.add(h);
			}
			return hotelList;
		}else{
			return null;
		}
	}
	/**根据快捷酒店id获取快捷酒店*/
	public Hotel queryHotelByHotelId(Integer hotel_id){
		String sql="select * from hotel where hotel_id=?";
		Map<String,Object> map=DBUtil.query(sql,hotel_id);
		if(map!=null&&map.size()>0){
			Hotel hotel=new Hotel();
			try {
				BeanUtils.populate(hotel, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return hotel;
		}else{
			return null;
		}
	}
}
