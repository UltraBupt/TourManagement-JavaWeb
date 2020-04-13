package com.gs.tour.shxt.airline.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.airline.model.Airline;
import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;

public class AirlineDao {
	/**查询机票列表*/
	public PageBean getAllAirlineList(Airline airline,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from airline where 1=1 ");
		if(airline.getAirline_point()!=null&&airline.getAirline_point().trim().length()>0){
			sb.append(" and airline_point like '%"+StringEscapeUtils.escapeSql(airline.getAirline_point())+"%'");
		}
		if(airline.getAirline_status()!=null){
			sb.append(" and airline_status like '%"+StringEscapeUtils.escapeSql(airline.getAirline_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Airline> airlineList=new ArrayList<Airline>();
			for (Map<String,Object> map : list) {
				Airline a=new Airline();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				airlineList.add(a);
			}
			pageBean.setData(airlineList);
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
	public Integer addAirline(Airline airline){
		String sql="insert into airline (airline_from,airline_to,airline_price,airline_time,airline_point) values(?,?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				airline.getAirline_from(),
				airline.getAirline_to(),
				airline.getAirline_price(),
				airline.getAirline_time(),
				airline.getAirline_point()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Airline load(Integer airline_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from airline where airline_id=?";
		Map<String,Object> map=DBUtil.query(sql, airline_id);
		Airline airline=new Airline();
		BeanUtils.populate(airline, map);
		return airline;
	}
	/**编辑*/
	public void update(Airline airline){
		String sql="update airline set airline_from=? ,airline_to=?,airline_price=?,airline_time=?,airline_point=? where airline_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				airline.getAirline_from(),
				airline.getAirline_to(),
				airline.getAirline_price(),
				airline.getAirline_time(),
				airline.getAirline_point(),
				airline.getAirline_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update airline set airline_url=? where airline_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("airline_url").toString().trim(),
				map.get("airline_id").toString().trim()
		});
	}
	/**根据机票id获取机票*/
	public Airline queryAirlineByAirlineId(Integer airline_id){
		String sql="select * from airline where airline_id=?";
		Map<String,Object> map=DBUtil.query(sql,airline_id);
		if(map!=null&&map.size()>0){
			Airline airline=new Airline();
			try {
				BeanUtils.populate(airline, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return airline;
		}else{
			return null;
		}
	}
	/**更改状态*/
	public void updateStatus(Integer airline_id,Integer airline_status) throws Exception{
		String sql="update airline set airline_status=? where airline_id=?";
		DBUtil.executeUpdate(sql, new Object[]{airline_status,airline_id});
	}
}
