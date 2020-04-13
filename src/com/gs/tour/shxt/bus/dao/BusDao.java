package com.gs.tour.shxt.bus.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.bus.model.Bus;
import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;

public class BusDao {
	/**查询汽车票列表*/
	public PageBean getAllBusList(Bus bus,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from bus where 1=1 ");
		if(bus.getBus_point()!=null&&bus.getBus_point().trim().length()>0){
			sb.append(" and bus_point like '%"+StringEscapeUtils.escapeSql(bus.getBus_point())+"%'");
		}
		if(bus.getBus_status()!=null){
			sb.append(" and bus_status like '%"+StringEscapeUtils.escapeSql(bus.getBus_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Bus> busList=new ArrayList<Bus>();
			for (Map<String,Object> map : list) {
				Bus a=new Bus();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				busList.add(a);
			}
			pageBean.setData(busList);
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
	public Integer addBus(Bus bus){
		String sql="insert into bus (bus_from,bus_to,bus_price,bus_time,bus_point) values(?,?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				bus.getBus_from(),
				bus.getBus_to(),
				bus.getBus_price(),
				bus.getBus_time(),
				bus.getBus_point()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Bus load(Integer bus_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from bus where bus_id=?";
		Map<String,Object> map=DBUtil.query(sql, bus_id);
		Bus bus=new Bus();
		BeanUtils.populate(bus, map);
		return bus;
	}
	/**编辑*/
	public void update(Bus bus){
		String sql="update bus set bus_from=? ,bus_to=?,bus_price=?,bus_time=?,bus_point=? where bus_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				bus.getBus_from(),
				bus.getBus_to(),
				bus.getBus_price(),
				bus.getBus_time(),
				bus.getBus_point(),
				bus.getBus_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update bus set bus_url=? where bus_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("bus_url").toString().trim(),
				map.get("bus_id").toString().trim()
		});
	}
	/**根据汽车票id获取汽车票*/
	public Bus queryBusByBusId(Integer bus_id){
		String sql="select * from bus where bus_id=?";
		Map<String,Object> map=DBUtil.query(sql,bus_id);
		if(map!=null&&map.size()>0){
			Bus bus=new Bus();
			try {
				BeanUtils.populate(bus, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bus;
		}else{
			return null;
		}
	}
	/**更改状态*/
	public void updateStatus(Integer bus_id,Integer bus_status) throws Exception{
		String sql="update bus set bus_status=? where bus_id=?";
		DBUtil.executeUpdate(sql, new Object[]{bus_status,bus_id});
	}
}
