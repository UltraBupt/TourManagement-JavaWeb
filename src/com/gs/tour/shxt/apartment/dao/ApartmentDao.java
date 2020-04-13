package com.gs.tour.shxt.apartment.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.apartment.model.Apartment;
import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;

public class ApartmentDao {
	/**查询公寓列表*/
	public PageBean getAllApartmentList(Apartment apartment,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from apartment where 1=1 ");
		if(apartment.getApartment_name()!=null&&apartment.getApartment_name().trim().length()>0){
			sb.append(" and apartment_name like '%"+StringEscapeUtils.escapeSql(apartment.getApartment_name())+"%'");
		}
		if(apartment.getApartment_status()!=null){
			sb.append(" and apartment_status like '%"+StringEscapeUtils.escapeSql(apartment.getApartment_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
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
			pageBean.setData(apartmentList);
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
	public Integer addApartment(Apartment apartment){
		String sql="insert into apartment (apartment_name,apartment_price,apartment_address,apartment_desc) values(?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				apartment.getApartment_name(),
				apartment.getApartment_price(),
				apartment.getApartment_address(),
				apartment.getApartment_desc()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Apartment load(Integer apartment_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from apartment where apartment_id=?";
		Map<String,Object> map=DBUtil.query(sql, apartment_id);
		Apartment apartment=new Apartment();
		BeanUtils.populate(apartment, map);
		return apartment;
	}
	/**编辑*/
	public void update(Apartment apartment){
		String sql="update apartment set apartment_name=? ,apartment_price=?,apartment_address=?,apartment_desc=? where apartment_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				apartment.getApartment_name(),
				apartment.getApartment_price(),
				apartment.getApartment_address(),
				apartment.getApartment_desc(),
				apartment.getApartment_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update apartment set apartment_url=? where apartment_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("apartment_url").toString().trim(),
				map.get("apartment_id").toString().trim()
		});
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
	/**更改状态*/
	public void updateStatus(Integer apartment_id,Integer apartment_status) throws Exception{
		String sql="update apartment set apartment_status=? where apartment_id=?";
		DBUtil.executeUpdate(sql, new Object[]{apartment_status,apartment_id});
	}
}
