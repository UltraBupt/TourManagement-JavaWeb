package com.gs.tour.shxt.hotel.service;

import java.util.Map;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.hotel.dao.HotelDao;
import com.gs.tour.shxt.hotel.model.Hotel;

public class HotelService {
	HotelDao hotelDao=new HotelDao();
	/**查询快捷酒店列表*/
	public PageBean getAllHotelList(Hotel hotel,PageBean pageBean){
		return this.hotelDao.getAllHotelList(hotel, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addHotel(Hotel hotel) throws Exception{
		Integer num=this.hotelDao.addHotel(hotel);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Hotel load(Integer hotel_id){
		Hotel hotel;
		try {
			hotel=this.hotelDao.load(hotel_id);
			return hotel;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Hotel hotel){
		this.hotelDao.update(hotel);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.hotelDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据快捷酒店id获取快捷酒店*/
	public Hotel queryHotelByHotelId(Integer hotel_id){
		return this.hotelDao.queryHotelByHotelId(hotel_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer hotel_id) throws Exception {
		Hotel hotel = this.hotelDao.queryHotelByHotelId(hotel_id);
		Integer hotel_status = hotel.getHotel_status();
		if(hotel_status==1){
			hotel_status=0;
		}else{
			hotel_status=1;
		}
		this.hotelDao.updateStatus(hotel_id, hotel_status);
		return hotel_status;
	}
}
