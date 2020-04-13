package com.gs.tour.shxt.a.web.hotel.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.hotel.model.Hotel;

public class HotelDao {
	/**查询快捷酒店列表*/
	public PageBean getAllHotelList(Hotel hotel,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from hotel where 1=1 ");
		if(hotel.getHotel_name()!=null&&hotel.getHotel_name().trim().length()>0){
			sb.append(" and hotel_name like '%"+StringEscapeUtils.escapeSql(hotel.getHotel_name())+"%'");
		}
		if(hotel.getHotel_status()!=null){
			sb.append(" and hotel_status like '%"+StringEscapeUtils.escapeSql(hotel.getHotel_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
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
			pageBean.setData(hotelList);
			String countSql="select count(*) as num from ("+sb.toString()+")t";
			Integer totalCount=Integer.parseInt(DBUtil.query(countSql).get("num").toString());
			pageBean.setTotalCount(totalCount);
			Integer totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			pageBean.setTotalPages(totalPage);
			return pageBean;
		}else{
			return null;
		}
	}
	/**添加*/
	public Integer addHotel(Hotel hotel){
		String sql="insert into hotel (hotel_name,hotel_price,hotel_address,hotel_desc) values(?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				hotel.getHotel_name(),
				hotel.getHotel_price(),
				hotel.getHotel_address(),
				hotel.getHotel_desc()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Hotel load(Integer hotel_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from hotel where hotel_id=?";
		Map<String,Object> map=DBUtil.query(sql, hotel_id);
		Hotel hotel=new Hotel();
		BeanUtils.populate(hotel, map);
		return hotel;
	}
	/**编辑*/
	public void update(Hotel hotel){
		String sql="update hotel set hotel_name=? ,hotel_price=?,hotel_address=?,hotel_desc=? where hotel_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				hotel.getHotel_name(),
				hotel.getHotel_price(),
				hotel.getHotel_address(),
				hotel.getHotel_desc(),
				hotel.getHotel_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update hotel set hotel_url=? where hotel_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("hotel_url").toString().trim(),
				map.get("hotel_id").toString().trim()
		});
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
	/**更改状态*/
	public void updateStatus(Integer hotel_id,Integer hotel_status) throws Exception{
		String sql="update hotel set hotel_status=? where hotel_id=?";
		DBUtil.executeUpdate(sql, new Object[]{hotel_status,hotel_id});
	}
}
